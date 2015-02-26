/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.core;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.util.CoreOperationType;

/**
 *
 * @author AntonioGamez
 */
public class NumberOfAlternativeDocsCOp extends CoreOperation{

    public NumberOfAlternativeDocsCOp() {
        setType(CoreOperationType.NumberOfAlternativeDocs);
    }

    @Override
    public void analyze(AgreementModel agreementModel) {
        getReasoner().analyze(this, agreementModel);
    }

    @Override
    public Object getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
