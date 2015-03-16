/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.OperationResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AntonioGamez
 */
public class ValidOp extends NoCoreOperation {

//    private final ExistInconsistenciesOp existsInconsistenciesOp;
    private final ExistDeadTermsOp existDeadTermsOp;
    private final ExistCondInconsTermsOp existCondInconsTermsOp;

    public ValidOp() {
//        this.existsInconsistenciesOp = new ExistInconsistenciesOp();
        this.existDeadTermsOp = new ExistDeadTermsOp();
        this.existCondInconsTermsOp = new ExistCondInconsTermsOp();
        this.result = new OperationResponse();
    }

    public void analyze(AgreementModel model) {

        //existDeadTermsOp ya comprueba que no existan inconsistencias
        existDeadTermsOp.analyze(model);
        existCondInconsTermsOp.analyze(model);

        Boolean consistent = (Boolean) existDeadTermsOp.getResult().get("consistent");
        Boolean existDeadTerms = (Boolean) existDeadTermsOp.getResult().get("existDeadTerms");
        Boolean existCondInconsTerms = (Boolean) existCondInconsTermsOp.getResult().get("existCondInconsTerms");

        result.put("valid", consistent && !existDeadTerms && !existCondInconsTerms);
    }

    @Override
    public OperationResponse getResult() {
        Map<String, Object> conflicts = new HashMap<>();
        conflicts.put("existDeadTerms", existDeadTermsOp.getResult().get("conflicts_existDeadTerms"));
        conflicts.put("existCondInconsTerms", existCondInconsTermsOp.getResult().get("conflicts_existCondInconsTerms"));

        result.putAll(existDeadTermsOp.getResult());
        result.putAll(existCondInconsTermsOp.getResult());

        //remove temp results
        result.remove("conflicts_existCondInconsTerms");
        result.remove("conflicts_existDeadTerms");
        result.remove("consistent");

        result.put("conflicts", conflicts);

        return result;
    }

}
