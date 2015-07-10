/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import java.util.HashMap;
import java.util.Map;

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
public class WhyAreNotCompliant extends CoreOperation {

	public WhyAreNotCompliant() {
		result = new OperationResponse();
		this.reasoner = ReasonerFactory.createCSPReasoner();
	}

	public void analyze(AgreementModel template, AgreementModel offer) {

		Translator translator = new Translator(new CSPBuilder());

		CSPModel csp_offer = (CSPModel) translator.translate(offer);

		StringBuilder sb = new StringBuilder();
		
		// areCompliant(T.GTs, O.Terms) <-> implies(map(T.GTs),
		// map(O.Terms))
		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();
		Map<String, GuaranteeTerm> gts = template_gts.getAgreementTerms()
				.getGuaranteeTerms();
		Boolean compliant1 = true;
		
		if (template.getAgreementTerms().getGuaranteeTerms().size() > 0) {
			for (GuaranteeTerm gt : gts.values()) {
				Map<String, GuaranteeTerm> new_gts = new HashMap<String, GuaranteeTerm>();
				new_gts.put(gt.getId(), gt);
				template_gts.getAgreementTerms().setGuaranteeTerms(new_gts);
				CSPModel csp_template_gts = (CSPModel) translator
						.translate(template_gts);
				Boolean compliant = reasoner.implies(csp_template_gts,
						csp_offer);

				if (!compliant) {
					sb.append("Caused by guarantee term: " + gt.getId() + "\n");
					compliant1 = false;
				}
			}
		}

		// areCompliant(O.Terms, T.CCs) <-> implies(map(O.Terms),
		// map(T.CCs))
		AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
		template_ccs.getAgreementTerms().getGuaranteeTerms().clear();
		Map<String, CreationConstraint> ccs = template_ccs
				.getCreationConstraints();
		Boolean compliant2 = true;

		if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
			for (CreationConstraint cc : ccs.values()) {
				Map<String, CreationConstraint> new_ccs = new HashMap<String, CreationConstraint>();
				new_ccs.put(cc.getId(), cc);
				template_ccs.setCreationConstraints(new_ccs);
				CSPModel csp_template_ccs = (CSPModel) translator
						.translate(template_ccs);
				Boolean compliant = reasoner.implies(csp_offer,
						csp_template_ccs);

				if (!compliant) {
					sb.append("Caused by constraint: " + cc.getId() + "\n");
					compliant2 = false;
				}
			}
		}
		
		result.put("explaining", sb.toString());

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
