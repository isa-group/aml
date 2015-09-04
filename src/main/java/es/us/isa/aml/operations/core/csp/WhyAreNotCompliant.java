/**
 * 
 */
package es.us.isa.aml.operations.core.csp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 * @author cmuller
 *
 */
public class WhyAreNotCompliant extends CoreOperation {

	private final static Logger logger = Logger.getLogger(WhyAreNotCompliant.class.getName());
	
	public WhyAreNotCompliant() {
		result = new OperationResponse();
		this.reasoner = ReasonerFactory.createCSPReasoner();
	}

	public void analyze(AgreementModel template, AgreementModel offer) {
		//Compliance checking is done within whyNotImplies CSP operation.

		OperationResponse res = null;
		Translator translator = new Translator(new CSPBuilder());

		CSPModel csp_offer = (CSPModel) translator.translate(offer);
		CSPModel csp_template = (CSPModel) translator.translate(template);

		// whyNotImplies(map(T.GTs), map(O.GTs))
		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();

		AgreementOffer offer_gts = (AgreementOffer) offer.clone();
		offer_gts.getAgreementTerms().getService().getConfigurationProperties().clear();
		//With the following code line I do not consider in the compliance analysis the value assignments for MonitorableProps within the Offer
		Map<String, MonitorableProperty> mps = offer_gts.getAgreementTerms().getMonitorableProperties();
		Iterator<String> it = mps.keySet().iterator();
		while (it.hasNext()) {
			String mpId = (String) it.next();
			MonitorableProperty mp = mps.get(mpId);
			if (mp.getExpression() != null) {
				mp.setExpression(null);
			}
		}

		if ((template.getAgreementTerms().getGuaranteeTerms().size() > 0) && (offer.getAgreementTerms().getGuaranteeTerms().size() > 0)) {
			CSPModel csp_template_gts = (CSPModel) translator.translate(template_gts);
			CSPModel csp_offer_gts = (CSPModel) translator.translate(offer_gts);
			res = reasoner.whyNotImplies(csp_template_gts, csp_offer_gts);
		}


		//If previous checking is not compliant conflicts are returned, and if it was compliant second part is analysed as follows
		if((Boolean)res.get("compliant")){
			// whyNotImplies(map(O.Terms), map(T.CCs))
			AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
			template_ccs.getAgreementTerms().getGuaranteeTerms().clear();

			if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
				CSPModel csp_template_ccs = (CSPModel) translator
						.translate(template_ccs);
				OperationResponse res2 = reasoner.whyNotImplies(csp_offer, csp_template_ccs);	

				res = res2;
			}	
		}
		
		result.putAll(res);
		
		// If conflicts were found, we classify the kind of conflict as follows
		if (!(Boolean)res.get("compliant")) {
			List<CSPConstraint> conflictingConstraints = putExplanation(res, csp_offer.clone(), csp_template.clone());
			classifyConflicts(conflictingConstraints, (AgreementTemplate) template, csp_template.clone(), translator);
		}
		//result.putAll(res);		
	}

	private List<CSPConstraint> putExplanation(OperationResponse res, CSPModel csp_offer, CSPModel csp_template) {
		//System.out.println("Res es: "+res);
		Map<String, Object> resMap = res.getResult();
		ArrayList<String> conflictResult = (ArrayList<String>) resMap.get("conflicts");
		
		//Created a copy to remove the conflicts that are from the offer. This is used to show the affected template constraints
		ArrayList<String> conflictsForTemplate = (ArrayList<String>) conflictResult.clone();
		
		logger.log(Level.INFO, "Conflicts to be cleanned (i.e. Problem constraint must be removed and to get the conflicts of the Offer: "+conflictResult);
		//System.out.println("Conflictos por limpiar Problem, mirar que sean de Offer, y clasificar: "+result2);
		
		List<CSPConstraint> sourceConstraints = csp_offer.getConstraints();
		List<CSPConstraint> constraints = new ArrayList<CSPConstraint>();
		
		//the following line remove Problem constraint from the conflicts to be returned
		result.remove("conflicts");		
		
		//Sometimes, although documents have conflicts, none of them are returned because some problematic SDT value assignment are not detected
		//to be developed
		List<CSPConstraint> sourceTemplateConstraints = csp_template.getConstraints();
		List<CSPConstraint> affectedTemplateConstraints = new ArrayList<CSPConstraint>();
		
		Boolean constraintsEmpty = true;
		Boolean exit = false;
		while (constraintsEmpty){
			Iterator<String> itConflictResult = conflictResult.iterator();
			while (itConflictResult.hasNext()) {
				String conf = (String) itConflictResult.next();				
				String confs = (String) result.get("conflicts");
				
				Iterator<CSPConstraint> itSourceConstraints = sourceConstraints.iterator();
				while (itSourceConstraints.hasNext()) {
					CSPConstraint cons = (CSPConstraint) itSourceConstraints.next();
					String constraint_name = cons.getId(); 
					
					if (!(conf=="Problem") && !(conf.startsWith("ASSIG"))){
						
						if (conf.contains("_")) conf = removeUnderScore(conf);
						
						if (conf.equalsIgnoreCase(constraint_name)){
							if (conf.contains("_")) conf = removeUnderScore(conf);

							//We check that the cons has not been included yet (such a situation happens when GTs have the same name in offer and template)
							if (confs == null || !confs.contains(cons.toString())){
								constraints.add(cons);
								result.put("conflicts", cons.toString());
								conflictsForTemplate.remove(cons.getId());
							}
						}
					}
					if (conf.startsWith("ASSIG") && conf.equalsIgnoreCase(constraint_name)){
						if (confs == null || confs != null && !confs.contains(cons.toString())){
							constraints.add(cons);
							result.put("conflicts", cons.toString());
							conflictsForTemplate.remove(cons.getId());
						}
					}
				}
			}
			logger.log(Level.INFO, "Conflicting Offer constraints: "+constraints);
			//System.out.println("Restricciones conflicto: "+constraints);
			if (constraints.isEmpty() && !exit){
				CSPModel modelAux = csp_template.clone().add(csp_offer); //O y T
				OperationResponse resAux = reasoner.explain(modelAux);
				Map<String, Object> test3 = resAux.getResult();
				conflictResult = (ArrayList<String>) test3.get("conflicts");
				exit = true;
			} else {
				constraintsEmpty = false;
			}
		}
		result.put("conflicts", constraints.toString());
		
		
		//To run on conflictsForTemplate in order to create the list of affected template CSP conflicts
		//ESTO SE PODRÁ SACAR FACTOR COMÚN CON LO DE ARRIBA SEGURO
		Iterator<String> itConflictsForTemplate = conflictsForTemplate.iterator();
		while (itConflictsForTemplate.hasNext()) {
			String affected = (String) itConflictsForTemplate.next();				

			Iterator<CSPConstraint> itSourceTemplateConstraints = sourceTemplateConstraints.iterator();
			while (itSourceTemplateConstraints.hasNext()) {
				CSPConstraint c = (CSPConstraint) itSourceTemplateConstraints.next();
				String constraint_name = c.getId(); 
				
				if (!(affected=="Problem") && !(affected.startsWith("ASSIG"))){
					
					if (affected.contains("_")) {
						affected = removeUnderScore(affected);
					}						
					
					if (affected.equalsIgnoreCase(constraint_name)){
						if (affected.contains("_")) {
							affected = removeUnderScore(affected);
						}
						if (affected == null || !affected.contains(c.toString())){
							affectedTemplateConstraints.add(c);
							result.put("affectedTerms", c.toString());
							//conflictsForTemplate.remove(cons.getId());
						}
						
					}
				}
				if (affected.startsWith("ASSIG") && affected.equalsIgnoreCase(constraint_name)){
					if (affected == null || affected != null && !affected.contains(c.toString())){
						affectedTemplateConstraints.add(c);
						result.put("affectedTerms", c.toString());
						//conflictsForTemplate.remove(cons.getId());
					}
				}
			}
		}
		
		logger.log(Level.INFO, "Affected Template constraints: "+affectedTemplateConstraints);
		
		//CSPModel csp_template = (CSPModel) translator.translate(template);
		return constraints;
	}
	
	private void classifyConflicts(List<CSPConstraint> constraints, AgreementTemplate template, CSPModel csp_template, Translator translator) {	
		Boolean moreRestrictive = null;
		Boolean contradictory = null;
		//Boolean intersec = null;  //this is another kind of CSP conflict not observed yet
		
		AgreementTemplate empty_template = (AgreementTemplate) template.clone();
		empty_template.getCreationConstraints().clear(); 
		empty_template.getAgreementTerms().getGuaranteeTerms().clear();
		CSPModel confModel = (CSPModel) translator.translate(empty_template);
		confModel.setConstraints(constraints);
		
		CSPModel modelForClassify2 = confModel.clone().add(csp_template); //V,D,Conflict y T
		
		Boolean sol = reasoner.solve(modelForClassify2);
		
		if (sol) moreRestrictive = true;
		else moreRestrictive = false;
			
		String conflictType = null;
		
		if (moreRestrictive) {
			if (result.get("conflicts")==null) conflictType = "the offer has more restrictive terms";
			else conflictType = "more restrictive offer term";
		} 
		else {
			CSPModel modelForClassify = confModel.clone().add(csp_template.negate()); //V,D,Conflict y noT

			Boolean sol2 = reasoner.solve(modelForClassify);
			
			if (sol2) contradictory = true;
			else contradictory = false;
			
			if (contradictory) {
				if (result.get("conflicts")==null) conflictType = "the offer has contradictory terms";
				else conflictType = "contradictory offer term";
			}
			else {
				if (result.get("conflicts")==null) conflictType = "the offer has possibly contradictory terms (i.e. it allows values non-compliant with template terms)";
				else conflictType = "possibly contradictory offer term (i.e. it allows values non-compliant with template terms)";
			}
		}
		result.put("compliant", false);
		result.put("conflictType", conflictType);
	}

	
	private String removeUnderScore(String conf) {
		conf = conf
				.substring(0, conf
						.lastIndexOf("_"));
		return conf;
	}

	
	
	@Override
	public OperationResponse getResult() {
		return result;
	}

}
