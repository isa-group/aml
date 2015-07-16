/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.google.gson.Gson;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;
import es.us.isa.aml.util.Util;

/**
 * @author cmuller
 *
 */
public class WhyAreNotCompliant extends CoreOperation {

	public WhyAreNotCompliant() {
		result = new OperationResponse();
		this.reasoner = ReasonerFactory.createCSPReasoner();
	}

	public void analyze(AgreementModel template, AgreementModel offer) {
		//La comprobación de si son o no compliant se hace dentro del whyNotImplies

		OperationResponse res = null;
		Translator translator = new Translator(new CSPBuilder());


		CSPModel csp_offer = (CSPModel) translator.translate(offer);

		// whyNotImplies(map(T.GTs), map(O.GTs))
		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();

		AgreementOffer offer_gts = (AgreementOffer) offer.clone();
		offer_gts.getAgreementTerms().getService().getConfigurationProperties().clear();

		if ((template.getAgreementTerms().getGuaranteeTerms().size() > 0) && (offer.getAgreementTerms().getGuaranteeTerms().size() > 0)) {
			CSPModel csp_template_gts = (CSPModel) translator.translate(template_gts);
			CSPModel csp_offer_gts = (CSPModel) translator.translate(offer_gts);
			System.out.println("CSP_template_GTs: \n"+csp_template_gts);
			System.out.println("CSP_offer_GTs: \n"+csp_offer_gts);
			res = reasoner.whyNotImplies(csp_template_gts, csp_offer_gts);
			System.out.println("Resultado de whyNotImplies(map(T.GTs), map(O.GTs)): \n"+res.getResult());
		}


		//Si lo anterior no es compliant que devuelva su resultado, y si sí es compliant, se analiza la segunda parte
		if((Boolean)res.get("compliant")){
			// whyNotImplies(map(O.Terms), map(T.CCs))
			AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
			template_ccs.getAgreementTerms().getGuaranteeTerms().clear();

			if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
				CSPModel csp_template_ccs = (CSPModel) translator
						.translate(template_ccs);
				System.out.println("CSP_offer: \n"+csp_offer);
				System.out.println("CSP_template_CCs: \n"+csp_template_ccs);
				OperationResponse res2 = reasoner.whyNotImplies(csp_offer, csp_template_ccs);
				System.out.println("Resultado de whyNotImplies(map(O.Terms), map(T.CCs)): \n"+res2.getResult());	

				res = res2;

				// Alt1: Sólo poner los conflictos del segundo whyNotImplies si en el primero no hubo conflictos
				/*
						if ((res.get("conflicts")==null) && (res.get("conflictType")==null)){
							res = res2;
						}
				 */

				// Alt2: Unir el res2 al res
				/*
						String conflicts = (String) res.get("conflicts");
						String conflictType = (String) res.get("conflictType");

						res.put("conflicts", conflicts.concat(", "+res2.get("conflicts")));
						res.put("conflicttype", conflictType.concat(", "+res2.get("conflictType")));
				 */		
			}	
		}
		
		// Si han habido conflictos analizamos de qué tipo son con este código de debajo
		if (!(Boolean)res.get("compliant")){
			//Añado aquí la comprobación del tipo de conflicto detectado
			Boolean moreRestrictive = null;
			Boolean contradictory = null;
			//Boolean intersec = null;
			
			System.out.println("Res es: "+res);
			Map<String, Object> test2 = res.getResult();
			ArrayList result2 = (ArrayList) test2.get("conflicts");
			
			System.out.println("Conflictos por limpiar Problem, mirar que sean de Offer, y clasificar: "+result2);
			
			//CSPModel resModel = consequent;
			//CSPModel resModel = antecedent;
			List<CSPConstraint> sourceConstraints = csp_offer.getConstraints();
			List<CSPConstraint> constraints = new ArrayList<CSPConstraint>();
			
			//Esto lo hago para quitar el Problem de los conflictos a devolver 
			res.remove("conflicts");
			
			Iterator itResult2 = result2.iterator();
			while (itResult2.hasNext()) {
				String conf = (String) itResult2.next();
				System.out.println("Nombre del Conflicto: "+conf);
				
				Iterator itResult3 = sourceConstraints.iterator();
				while (itResult3.hasNext()) {
					CSPConstraint cons = (CSPConstraint) itResult3.next();
					String constraint_name = cons.getId(); 
					System.out.println("Nombre de la restricción de la Offer: "+constraint_name);
					
					if (!(conf=="Problem") && !(conf.startsWith("ASSIG"))){
						if (conf.equalsIgnoreCase(constraint_name)){
							if (conf.contains("_")) {
								conf = conf
										.substring(0, conf
												.lastIndexOf("_"));
							}
							System.out.println("Añado: "+cons.getId());
							constraints.add(cons);
							res.put("conflicts", cons);
						}
					}
					if (conf.startsWith("ASSIG") && conf.equalsIgnoreCase(constraint_name)){
						System.out.println("Añado: "+cons.getId());
						constraints.add(cons);
						res.put("conflicts", cons);
					}
				}
			}
			System.out.println("Restricciones conflicto: "+constraints);
			
			CSPModel csp_template = (CSPModel) translator.translate(template);
			
			AgreementTemplate empty_template = (AgreementTemplate) template.clone();
			empty_template.getCreationConstraints().clear(); 
			empty_template.getAgreementTerms().getGuaranteeTerms().clear();
			CSPModel confModel = (CSPModel) translator.translate(empty_template);
			System.out.println("ConfModel debe tener sólo las variables y monitorable props: \n"+confModel);
			confModel.setConstraints(constraints);
			System.out.println("ConfModel con las constraints de conflicto: \n"+confModel);
			
			CSPModel modelForClassify2 = confModel.clone().add(csp_template); //V,D,Conflict y T
			System.out.println("Model for Classify2 (debe ser V,D,Conflict y T): "+modelForClassify2.toString());
			
			Boolean sol = reasoner.solve(modelForClassify2);
			
			if (sol) moreRestrictive = true;
			else moreRestrictive = false;
				
			String conflictType = null;
			
			if (moreRestrictive) {
				if (res.get("conflicts")==null) conflictType = "the offer has more restrictive terms";
				else conflictType = "more restrictive offer term";
			} 
			else {
				CSPModel modelForClassify = confModel.clone().add(csp_template.negate()); //V,D,Conflict y noT
				System.out.println("Model for Classify (debe ser V,D,Conflict y noT): "+modelForClassify.toString());
				
				//Boolean sol2 = reasoner.solve(modelForClassify2);
				Boolean sol2 = reasoner.solve(modelForClassify);
				
				if (sol2) contradictory = true;
				else contradictory = false;
				
				if (contradictory) {
					if (res.get("conflicts")==null) conflictType = "the offer has contradictory terms";
					else conflictType = "contradictory offer term";
				}
				else {
					if (res.get("conflicts")==null) conflictType = "the offer has possibly contradictory terms (i.e. it allows values non-compliant with template terms)";
					else conflictType = "possibly contradictory offer term (i.e. it allows values non-compliant with template terms)";
				}
			}
			res.put("compliant", false);
			res.put("conflictType", conflictType);
		}
		result.putAll(res);		
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
