/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.subsystems;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.noCore.ValidOp;
import isa.us.es.aml.util.DefaultReasonerProxy;
import isa.us.es.aml.util.ReasonerEngineType;
import isa.us.es.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public class AnalyzerService {

    public AnalyzerService() {

    }

//    public Boolean existCondInconsTerms(AgreementModel agreementModel) {
//        ExistCondInconsTermsOp op = new ExistCondInconsTermsOp();
//        op.setDefaultConfig(ReasonerEngineType.CSP);
//        op.analyze(agreementModel);
//        return op.getResult();
//    }
//
//    public Boolean existCondInconsTerms(AgreementModel agreementModel, Set<CoreOperation> coreOperations) {
//        ExistCondInconsTermsOp op = new ExistCondInconsTermsOp();
//        op.setCoreOperations(coreOperations);
//        op.analyze(agreementModel);
//        return op.getResult();
//    }
//    
//    public Integer numberOfAlternativeDocs(AgreementModel agreementModel) {
//        NumberOfAlternativeDocsOp op = new NumberOfAlternativeDocsOp();
//        op.setDefaultConfig(ReasonerEngineType.CSP);
//        op.analyze(agreementModel);
//        return op.getResult();
//    }
//
//    public Integer numberOfAlternativeDocs(AgreementModel agreementModel, Set<CoreOperation> coreOperations) {
//        NumberOfAlternativeDocsOp op = new NumberOfAlternativeDocsOp();
//        op.setCoreOperations(coreOperations);
//        op.analyze(agreementModel);
//        return op.getResult();
//    }
    public Boolean valid(AgreementModel agreementModel) {
        ValidOp op = new ValidOp();
        op.setDefaultConfig(ReasonerEngineType.CSP);
        op.setModel(agreementModel);
        op.analyze();
        return op.getResult();
    }

    public Boolean validCoreOperationExample(AgreementModel agreementModel, ReasonerType type) {
        ValidOp op = new ValidOp();
        op.getExistsInconsistenciesCOp().setReasoner(DefaultReasonerProxy.createReasoner(type));
        op.setModel(agreementModel);
        op.analyze();
        return op.getResult();
    }

}
