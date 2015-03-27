/**
 *
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
import es.us.isa.aml.util.OperationResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class ExistDeadTermsOp extends NoCoreOperation {

    private final ExistInconsistenciesOp existInconsistenciesOp;

    public ExistDeadTermsOp() {
        this.existInconsistenciesOp = new ExistInconsistenciesOp();
        result = new OperationResponse();
    }

    public void analyze(AgreementModel model) {

    	existInconsistenciesOp.analyze(model);
        Boolean existInconsistencies = (Boolean) existInconsistenciesOp.getResult().get("existInconsistencies");
        
        if (existInconsistencies) {
        	result.put("result", existInconsistenciesOp.getResult().get("result"));
            result.put("conflicts", existInconsistenciesOp.getResult().get("conflicts"));
            result.put("existDeadTerms", false);
            return;
        }

        List<GuaranteeTerm> gtOriginal = new ArrayList<>(model
                .getAgreementTerms().getGuaranteeTerms());
        List<GuaranteeTerm> gtCopy = new ArrayList<>(gtOriginal);

        for (int i = 0; i < gtCopy.size(); i++) {

            GuaranteeTerm gt = gtCopy.get(i);
            if (gt.getQc() != null) {
                GuaranteeTerm newgt = new IAgreeGuaranteeTerm(gt.getId(), gt.getServiceRole(), new IAgreeSLO(gt.getQc().getCondition()));
                gtCopy.set(gtCopy.indexOf(gt), newgt);

                model.getAgreementTerms().setGuaranteeTerms(gtCopy);

                existInconsistenciesOp.analyze(model);
                existInconsistencies = (Boolean) existInconsistenciesOp.getResult().get("existInconsistencies");

                if (existInconsistencies) {
                	result.put("result", existInconsistenciesOp.getResult().get("result"));
                    result.put("conflicts", existInconsistenciesOp.getResult().get("conflicts"));
                    result.put("existDeadTerms", true);
                    break;
                } else {
                    gtCopy.clear();
                    gtCopy.addAll(gtOriginal);

                    model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
                    result.put("result", existInconsistenciesOp.getResult().get("result"));
                    result.put("conflicts", existInconsistenciesOp.getResult().get("conflicts"));
                    result.put("existDeadTerms", false);
                }
            } else {
            	result.put("result", existInconsistenciesOp.getResult().get("result"));
                result.put("conflicts", existInconsistenciesOp.getResult().get("conflicts"));
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
