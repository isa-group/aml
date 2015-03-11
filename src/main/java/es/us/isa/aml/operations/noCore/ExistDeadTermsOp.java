/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AntonioGamez
 */
public class ExistDeadTermsOp extends NoCoreOperation {

    private final ExistInconsistenciesOp existsInconsistenciesOp;
    private Boolean consistent;

    public ExistDeadTermsOp() {
        this.existsInconsistenciesOp = new ExistInconsistenciesOp();
    }

    public void analyze(AgreementModel model) {
        existsInconsistenciesOp.analyze(model);
        consistent = !(Boolean) existsInconsistenciesOp.getResult().getResponseObject(0);
        List<GuaranteeTerm> gtOriginal = new ArrayList<>(model.getAgreementTerms().getGuaranteeTerms());
        List<GuaranteeTerm> gtCopy = new ArrayList<>(gtOriginal);
        while (consistent && gtCopy.size() > 0) {
            System.err.println(model.getAgreementTerms());
            if (gtCopy.get(0).getSlo() != null) {
                gtCopy.get(0).setQc(null);
            }
            gtCopy.remove(0);
            model.getAgreementTerms().setGuaranteeTerms(gtCopy);
            existsInconsistenciesOp.analyze(model);
            consistent = !(Boolean) existsInconsistenciesOp.getResult().getResponseObject(0);
            if (!consistent) {
                break;
            }
        }
        model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
    }

    @Override
    public Boolean getResult() {
        return !consistent;
    }

}
