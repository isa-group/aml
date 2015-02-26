/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.core.csp;

import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.util.CoreOperationType;

/**
 *
 * @author AntonioGamez
 */
public class ExistsInconsistenciesCOp extends CoreOperation {

    private Boolean existsInconsistencies;

    public ExistsInconsistenciesCOp() {
        setType(CoreOperationType.ExistInconsistencies);
    }

    @Override
    public void analyze() {
        existsInconsistencies = (Boolean) getReasoner().execute(this, model);
    }

    @Override
    public Boolean getResult() {
        return existsInconsistencies;
    }

}
