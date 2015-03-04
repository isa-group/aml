/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.core.csp.choco;

import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.util.CoreOperationType;

/**
 *
 * @author AntonioGamez
 */
public class ChocoExistsInconsistenciesCOp extends CoreOperation {

    private Boolean existsInconsistencies;

    public ChocoExistsInconsistenciesCOp() {
        this.setType(CoreOperationType.ExistInconsistencies);
    }

    @Override
    public void analyze() {
        // business logic with reasoner
        // init reasoner
        this.getReasoner().addProblem(this.model);
        // using reasoner
        this.existsInconsistencies = (Boolean) this.getReasoner().solve();
        // processing answer
        this.existsInconsistencies = !this.existsInconsistencies;
    }

    @Override
    public Boolean getResult() {
        return this.existsInconsistencies;
    }

}
