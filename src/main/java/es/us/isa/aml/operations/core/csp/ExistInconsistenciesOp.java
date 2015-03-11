/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.core.csp;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 *
 * @author AntonioGamez
 */
public class ExistInconsistenciesOp extends CoreOperation {

    private Boolean existInconsistencies;

    public ExistInconsistenciesOp() {
        this.reasoner = ReasonerFactory.createCSPReasoner();
    }

    public void analyze(AgreementModel model) {
        this.reasoner.addProblem(model);
        existInconsistencies = !(Boolean) this.reasoner.solve();
        // reasoner.solve() gives us "isConsistent" operation
        // but we want "existInconsistencies" one.
    }

    @Override
    public OperationResponse getResult() {
        this.result.addResponseObject(existInconsistencies);
        return this.result;
    }
}
