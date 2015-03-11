/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;

/**
 *
 * @author AntonioGamez
 */
public class ExistDeadTermsOp extends NoCoreOperation {

    private final ExistInconsistenciesOp existsInconsistenciesOp;
    private Boolean inconsistent;

    public ExistDeadTermsOp() {
        this.existsInconsistenciesOp = new ExistInconsistenciesOp();
    }

    public void analyze(AgreementModel model) {
        /*existsInconsistenciesOp.analyze(model);
         inconsistent = (Boolean) existsInconsistenciesOp.getResult().getResponseObject(0);
         AgreementModel modelCopy = model.clone();
         modelCopy.getAgreementTerms();

         while (!inconsistent) {
         model.getAgreementTerms().getGuaranteeTerms();
         }*/

    }

    @Override
    public Boolean getResult() {
        return true;
    }

}
