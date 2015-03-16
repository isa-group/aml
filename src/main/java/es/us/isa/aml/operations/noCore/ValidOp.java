/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.OperationResponse;

/**
 *
 * @author AntonioGamez
 */
public class ValidOp extends NoCoreOperation {

//    private final ExistInconsistenciesOp existsInconsistenciesOp;
    private final ExistDeadTermsOp existDeadTermsOp;

    public ValidOp() {
//        this.existsInconsistenciesOp = new ExistInconsistenciesOp();
        this.existDeadTermsOp = new ExistDeadTermsOp();
    }

    public void analyze(AgreementModel model) {
    	
    	// TODO existDeadTermsOp ya comprueba que no existan inconsistencias
//        existsInconsistenciesOp.analyze(model);
        existDeadTermsOp.analyze(model);
        
//        Boolean consistent = (Boolean) existsInconsistenciesOp.getResult().get("consistent");
        Boolean consistent = (Boolean) existDeadTermsOp.getResult().get("consistent");
        Boolean existDeadTerms = (Boolean) existDeadTermsOp.getResult().get("existDeadTerms");
        
//        result.putAll(existsInconsistenciesOp.getResult());
        result = existDeadTermsOp.getResult();        
        result.put("valid", consistent && !existDeadTerms);
    }

    @Override
    public OperationResponse getResult() {
        return result;
    }

}
