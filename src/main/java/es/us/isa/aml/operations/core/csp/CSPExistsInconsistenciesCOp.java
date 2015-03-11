/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.core.csp;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.operations.reasoners.CSPResponse;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 *
 * @author AntonioGamez
 */
public class CSPExistsInconsistenciesCOp extends CoreOperation {

    private Boolean existsInconsistencies;

    public CSPExistsInconsistenciesCOp() {
        this.reasoner = ReasonerFactory.createCSPReasoner();
    }

    public void analyze(AgreementModel model) {
        this.reasoner.addProblem(model);
        CSPResponse response = (CSPResponse) this.reasoner.solve();
        existsInconsistencies = response.getConsistent();
    }

    @Override
    public OperationResponse getResult() {
        this.result.addResponseObject(existsInconsistencies);
        return this.result;
    }
}
