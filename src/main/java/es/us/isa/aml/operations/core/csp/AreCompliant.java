/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
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

		// areCompliant(T.GTs, O.Terms) <-> implies(map(T.GTs), map(O.Terms))
		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();
		CSPModel csp_template = (CSPModel) translator.translate(template_gts);
		CSPModel csp_offer = (CSPModel) translator.translate(offer);

		Boolean compliant1 = reasoner.implies(csp_template, csp_offer);

		// areCompliant(T.CCs,O.Terms) <-> implies(map(T.CCs),map(O.Terms))
		AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
		template_ccs.getAgreementTerms().getGuaranteeTerms().clear();
		CSPModel csp_template2 = (CSPModel) translator.translate(template_ccs);
		CSPModel csp_offer2 = (CSPModel) translator.translate(offer);

		Boolean compliant2 = reasoner.implies(csp_template2, csp_offer2);

		result.put("compliant", compliant1 && compliant2);
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
