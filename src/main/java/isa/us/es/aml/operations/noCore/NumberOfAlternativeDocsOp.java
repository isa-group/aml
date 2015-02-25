/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.noCore;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.operations.core.NumberOfAlternativeDocsCOp;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author AntonioGamez
 */
public class NumberOfAlternativeDocsOp extends NoCoreOperation {

    private CoreOperation numberOfAlternativeDocsCOp;

    public NumberOfAlternativeDocsOp() {
        this.coreOperations = new HashSet<>();
        numberOfAlternativeDocsCOp = new NumberOfAlternativeDocsCOp();
        coreOperations.add(numberOfAlternativeDocsCOp);
    }

    @Override
    public void analyze(AgreementModel agreementModel) {
        checkReasonerExistence(); // throws AssertionError if no reasoners have been provided
        numberOfAlternativeDocsCOp.analyze(agreementModel);
        setResult(new Random().nextBoolean());
        //todo: do something with these results
    }

    @Override
    public Integer getResult() {
        return (Integer) super.getResult();
    }
    
    

}
