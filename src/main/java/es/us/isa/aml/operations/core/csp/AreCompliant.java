/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
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

		// areCompliant(T.GTs, O.GTs) <-> implies(map(T.GTs), map(O.GTs))

		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();

		AgreementOffer offer_gts = (AgreementOffer) offer.clone();
		offer_gts.getAgreementTerms().getService().getConfigurationProperties()
				.clear();

		Boolean compliant1 = true;

		if ((template.getAgreementTerms().getGuaranteeTerms().size() > 0)
				&& (offer.getAgreementTerms().getGuaranteeTerms().size() > 0)) {
			CSPModel csp_template_gts = (CSPModel) translator
					.translate(template_gts);
			CSPModel csp_offer_gts = (CSPModel) translator.translate(offer_gts);
			compliant1 = reasoner.implies(csp_template_gts, csp_offer_gts);
		}

		// areCompliant(O.Ts, T.CCs) <-> implies(map(O.Terms), map(T.CCs))

		CSPModel csp_offer = (CSPModel) translator.translate(offer);
		AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
		template_ccs.getAgreementTerms().getGuaranteeTerms().clear();
		Boolean compliant2 = true;

		if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
			CSPModel csp_template_ccs = (CSPModel) translator
					.translate(template_ccs);
			compliant2 = reasoner.implies(csp_offer, csp_template_ccs);
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
