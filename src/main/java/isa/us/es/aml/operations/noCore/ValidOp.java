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
        this.existsInconsistenciesCOp = new ExistsInconsistenciesCOp();
        this.getCoreOperations().add(this.existsInconsistenciesCOp);
        setDefaultConfig(ReasonerEngineType.CSP);
    }

    public CoreOperation getExistsInconsistenciesCOp() {
        return this.existsInconsistenciesCOp;
    }

    public void setExistsInconsistenciesCOp(ExistsInconsistenciesCOp existsInconsistenciesCOp) {
        this.existsInconsistenciesCOp = existsInconsistenciesCOp;
    }

    @Override
    public void analyze() {
        this.checkReasonerExistence(); // throws AssertionError if no reasoners have been provided
        this.existsInconsistenciesCOp.setModel(this.model);
        this.existsInconsistenciesCOp.analyze();
        this.result = this.existsInconsistenciesCOp.getResult();
    }

    @Override
    public Boolean getResult() {
        return (Boolean) this.result;
    }

}
