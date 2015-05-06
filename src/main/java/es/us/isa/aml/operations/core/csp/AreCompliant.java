/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 * @author jdelafuente
 *
 */
public class AreCompliant extends CoreOperation {

	public AreCompliant() {
		result = new OperationResponse();
		this.reasoner = ReasonerFactory.createCSPReasoner();
	}

	public void analyze(AgreementModel template, AgreementModel offer) {

		Translator translator = new Translator(new CSPBuilder());

		CSPModel csp_offer = (CSPModel) translator.translate(offer);

		// areCompliant(T.GTs, O.Terms) <-> implies(map(T.GTs),
		// map(O.Terms))
		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();
		List<GuaranteeTerm> list_gts = template_gts.getAgreementTerms()
				.getGuaranteeTerms();
		Boolean compliant1 = true;

		if (template.getAgreementTerms().getGuaranteeTerms().size() > 0) {
			for (GuaranteeTerm gt : list_gts) {
				List<GuaranteeTerm> new_gts = new ArrayList<GuaranteeTerm>();
				new_gts.add(gt);
				template_gts.getAgreementTerms().setGuaranteeTerms(new_gts);
				CSPModel csp_template_gts = (CSPModel) translator
						.translate(template_gts);
				Boolean compliant = reasoner.implies(csp_template_gts,
						csp_offer);

				compliant1 &= compliant;
				if (!compliant) {
					result.put("explaining",
							"Caused by guarantee term: " + gt.getId());
					break;
				}
			}
		}

		// areCompliant(O.Terms, T.CCs) <-> implies(map(O.Terms),
		// map(T.CCs))
		AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
		template_ccs.getAgreementTerms().getGuaranteeTerms().clear();
		List<CreationConstraint> list_ccs = template_ccs
				.getCreationConstraints();
		Boolean compliant2 = true;

		if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
			for (CreationConstraint cc : list_ccs) {
				List<CreationConstraint> new_ccs = new ArrayList<CreationConstraint>();
				new_ccs.add(cc);
				template_ccs.setCreationConstraints(new_ccs);
				CSPModel csp_template_ccs = (CSPModel) translator
						.translate(template_ccs);
				Boolean compliant = reasoner.implies(csp_offer,
						csp_template_ccs);

				compliant2 &= compliant;
				if (!compliant) {
					result.put("explaining",
							"Caused by constraint: " + cc.getId());
					break;
				}
			}
		}

		if (compliant1 != null && compliant2 != null)
			result.put("compliant", compliant1 && compliant2);
		else
			result.put("compliant", null);
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
