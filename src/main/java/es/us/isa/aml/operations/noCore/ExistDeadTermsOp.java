/**
 * 
 */
package es.us.isa.aml.operations.noCore;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translators.iagree.model.IAgreeSLO;
import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 *
 */
public class ExistDeadTermsOp extends NoCoreOperation {

	private final ExistInconsistenciesOp existsInconsistenciesOp;

	public ExistDeadTermsOp() {
		this.existsInconsistenciesOp = new ExistInconsistenciesOp();
	}

	public void analyze(AgreementModel model) {
		
		existsInconsistenciesOp.analyze(model);
		Boolean consistent = (Boolean) existsInconsistenciesOp.getResult().get("consistent");
		
		result = existsInconsistenciesOp.getResult();
		
		if(!consistent){
			result.put("existDeadTerms", false);
			return;
		}
		
		List<GuaranteeTerm> gtOriginal = new ArrayList<>(model
				.getAgreementTerms().getGuaranteeTerms());
		List<GuaranteeTerm> gtCopy = new ArrayList<GuaranteeTerm>(gtOriginal);
		
		for(int i=0; i<gtCopy.size();i++){
						
			GuaranteeTerm gt = gtCopy.get(i);
			if(gt.getQc() != null){				
				GuaranteeTerm newgt = new IAgreeGuaranteeTerm(gt.getId(), gt.getServiceRole(), new IAgreeSLO(gt.getQc().getCondition()));
				gtCopy.set(gtCopy.indexOf(gt), newgt);
				
				model.getAgreementTerms().setGuaranteeTerms(gtCopy);
				
				existsInconsistenciesOp.analyze(model);
				result = existsInconsistenciesOp.getResult();
				consistent = (Boolean) result.get("consistent");
				
//				System.out.println(model.toString());
//				System.out.println("############################# consistent: " + consistent);
				
				if(!consistent){
					result.put("existDeadTerms", true);
					result.put("conflicts", "Dead terms:\n" + result.get("conflicts"));
					break;
				} else {				
					gtCopy.clear();
					gtCopy.addAll(gtOriginal);
					
					model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
					result.put("existDeadTerms", false);
				}
			} else {
				result.put("existDeadTerms", false);
			}
		}
		
		model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
	}

	@Override
	public OperationResponse getResult() {
		return this.result;
	}

}