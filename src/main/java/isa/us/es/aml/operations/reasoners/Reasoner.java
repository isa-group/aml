/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public interface Reasoner {

    public void analyze(CoreOperation coreOperation, AgreementModel agreementModel);

    public Object getResult();
    
    public ReasonerType getType();
}
