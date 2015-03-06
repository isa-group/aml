//package es.us.isa.aml.util;
//
//import es.us.isa.aml.operations.core.CoreOperation;
//import es.us.isa.aml.operations.core.csp.choco.ChocoExistsInconsistenciesCOp;
//import es.us.isa.aml.operations.core.csp.cplex.CplexExistsInconsistenciesCOp;
//
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author AntonioGamez
// */
//public class CoreOperationProxy {
//
//    public static CoreOperation createOperation(CoreOperationType operationType, ReasonerType reasonerType) {
//        switch (reasonerType) {
//
//            case CHOCO:
//                switch (operationType) {
//                    case ExistInconsistencies:
//                        return new ChocoExistsInconsistenciesCOp();
//                    default:
//                        throw new IllegalArgumentException("there is no operation for this reasoner" + operationType + " " + reasonerType);
//                }
//
//            case CPLEX:
//                switch (operationType) {
//                    case ExistInconsistencies:
//                        return new CplexExistsInconsistenciesCOp();
//                    default:
//                        throw new IllegalArgumentException("there is no operation for this reasoner" + operationType + " " + reasonerType);
//                }
//
//            default:
//                throw new IllegalArgumentException("there is no reasoner for" + reasonerType);
//        }
//    }
//
//    private CoreOperationProxy() {
//    }
//
//}
