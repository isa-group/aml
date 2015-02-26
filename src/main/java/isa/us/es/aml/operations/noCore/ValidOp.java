/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.noCore;

import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.operations.core.csp.ExistsInconsistenciesCOp;
import isa.us.es.aml.util.ReasonerEngineType;

/**
 *
 * @author AntonioGamez
 */
public class ValidOp extends NoCoreOperation {

    private ExistsInconsistenciesCOp existsInconsistenciesCOp;

    public ValidOp() {
        existsInconsistenciesCOp = new ExistsInconsistenciesCOp();
        getCoreOperations().add(existsInconsistenciesCOp);
        this.setDefaultConfig(ReasonerEngineType.CSP);
    }

    public CoreOperation getExistsInconsistenciesCOp() {
        return existsInconsistenciesCOp;
    }

    public void setExistsInconsistenciesCOp(ExistsInconsistenciesCOp existsInconsistenciesCOp) {
        this.existsInconsistenciesCOp = existsInconsistenciesCOp;
    }

    @Override
    public void analyze() {
        checkReasonerExistence(); // throws AssertionError if no reasoners have been provided
        existsInconsistenciesCOp.setModel(model);
        existsInconsistenciesCOp.analyze();
        result = existsInconsistenciesCOp.getResult();
    }

    @Override
    public Boolean getResult() {
        return (Boolean) result;
    }

}
