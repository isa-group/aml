/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.CSPExistsInconsistenciesCOp;

/**
 *
 * @author AntonioGamez
 */
public class ValidOp extends NoCoreOperation {

    private final CSPExistsInconsistenciesCOp existsInconsistenciesCOp;

    public ValidOp() {
        this.existsInconsistenciesCOp = new CSPExistsInconsistenciesCOp();
    }

    public void analyze(AgreementModel model) {
        existsInconsistenciesCOp.analyze(model);
        this.result = existsInconsistenciesCOp.getResult();
    }

    @Override
    public Boolean getResult() {
        return (Boolean) this.result.getResponseObject(0);
    }

}
