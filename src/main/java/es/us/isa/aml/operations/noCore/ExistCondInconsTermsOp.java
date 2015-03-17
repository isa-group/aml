/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translators.iagree.model.IAgreeSLO;
import es.us.isa.aml.util.OperationResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AntonioGamez
 */
public class ExistCondInconsTermsOp extends NoCoreOperation {

    private final ExistInconsistenciesOp existsInconsistenciesOp;

    public ExistCondInconsTermsOp() {
        this.existsInconsistenciesOp = new ExistInconsistenciesOp();
    }

    public void analyze(AgreementModel model) {
        existsInconsistenciesOp.analyze(model);
        Boolean consistent = (Boolean) existsInconsistenciesOp.getResult().get("consistent");
        this.result = existsInconsistenciesOp.getResult();
        if (!consistent) {
            result.put("existCondInconsTerms", false);
            return;
        }
        List<GuaranteeTerm> gtOriginal = new ArrayList<>(model.getAgreementTerms().getGuaranteeTerms());
        List<GuaranteeTerm> gtCopy = new ArrayList<>(gtOriginal);

        for (int i = 0; i < gtCopy.size(); i++) {
            GuaranteeTerm gti = gtCopy.get(i);
            if (gti.getQc() != null && gti.getSlo() != null) {
                GuaranteeTerm newGtQc = new IAgreeGuaranteeTerm(gti.getId() + "_QC", gti.getServiceRole(), new IAgreeSLO(gti.getQc().getCondition()));
                GuaranteeTerm newGtSlo = new IAgreeGuaranteeTerm(gti.getId() + "_SLO", gti.getServiceRole(), new IAgreeSLO(gti.getSlo().getExpression()));
                gtCopy.set(gtCopy.indexOf(gti), newGtQc);
                gtCopy.add(gtCopy.indexOf(gti) + 1, newGtSlo);

                model.getAgreementTerms().setGuaranteeTerms(gtCopy);

                existsInconsistenciesOp.analyze(model);
                result = existsInconsistenciesOp.getResult();
                consistent = (Boolean) result.get("consistent");
//                System.out.println(model.toString());
//                System.out.println("############################# consistent: " + consistent);
                if (!consistent) {
                    result.put("existCondInconsTerms", true);
                    //cleaning suffix added above
                    String conflicts = result.get("conflicts").toString().replaceAll("_QC", "").replaceAll("_SLO", "");
                    result.put("conflicts_existCondInconsTerms", conflicts);
                    break;
                } else {
                    gtCopy.clear();
                    gtCopy.addAll(gtOriginal);

                    model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
                    result.put("existCondInconsTerms", false);
                }
            } else {
                result.put("existCondInconsTerms", false);
            }
        }
        model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
    }

    @Override
    public OperationResponse getResult() {
        return this.result;
    }

}
