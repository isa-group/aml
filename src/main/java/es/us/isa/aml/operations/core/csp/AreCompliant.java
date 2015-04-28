/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;
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
		CSPModel csp_template_gts = (CSPModel) translator.translate(template_gts);
		CSPModel csp_offer = (CSPModel) translator.translate(offer);

		Boolean compliant1 = reasoner.implies(csp_template_gts, csp_offer);

		// areCompliant(O.Terms, T.CCs) <-> implies(map(O.Terms), map(T.CCs))
		AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
		template_ccs.getAgreementTerms().getGuaranteeTerms().clear();		
		List<CreationConstraint> list_ccs = template_ccs.getCreationConstraints();
		Boolean compliant2 = true;
		for(CreationConstraint cc : list_ccs){
			List<CreationConstraint> new_ccs = new ArrayList<CreationConstraint>();
			new_ccs.add(cc);
			template_ccs.setCreationConstraints(new_ccs);
			CSPModel csp_template_ccs = (CSPModel) translator.translate(template_ccs);
			Boolean compliant = reasoner.implies(csp_offer, csp_template_ccs);
			
			compliant2 &= compliant;
			if(!compliant){
				result.put("explaining", "Caused by CreationConstraint: " + cc.getId());
				break;
			}
		}
		
		if(compliant1 != null && compliant2 != null)
			result.put("compliant", compliant1 && compliant2);
		else
			result.put("compliant", null);
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
