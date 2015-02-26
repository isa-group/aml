package isa.us.es.aml.util;

import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.operations.core.csp.choco.ChocoExistsInconsistenciesCOp;
import isa.us.es.aml.operations.core.csp.choco.CplexExistsInconsistenciesCOp;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AntonioGamez
 */
public class CoreOperationProxy {

    public CoreOperationProxy() {
    }

    public static CoreOperation createOperation(CoreOperationType operationType, ReasonerType reasonerType) {
        switch (reasonerType) {

            case CHOCO:
                switch (operationType) {
                    case ExistInconsistencies:
                        return new ChocoExistsInconsistenciesCOp();
                    default:
                        throw new IllegalArgumentException("there is no operation for this reasoner" + operationType.toString() + " " + reasonerType.toString());
                }

            case CPLEX:
                switch (operationType) {
                    case ExistInconsistencies:
                        return new CplexExistsInconsistenciesCOp();
                    default:
                        throw new IllegalArgumentException("there is no operation for this reasoner" + operationType.toString() + " " + reasonerType.toString());
                }

            default:
                throw new IllegalArgumentException("there is no reasoner for" + reasonerType.toString());
        }
    }

}
