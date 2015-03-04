/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.core;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.Operation;
import isa.us.es.aml.operations.reasoners.Reasoner;
import isa.us.es.aml.util.CoreOperationType;

/**
 *
 * @author AntonioGamez
 */
public abstract class CoreOperation implements Operation {

    private Reasoner reasoner;
    private CoreOperationType type;
    protected AgreementModel model;

    public Reasoner getReasoner() {
        return this.reasoner;
    }

    public void setReasoner(Reasoner reasoner) {
        this.reasoner = reasoner;
    }

    public CoreOperationType getType() {
        return this.type;
    }

    public void setType(CoreOperationType type) {
        this.type = type;
    }

    public AgreementModel getModel() {
        return this.model;
    }

    public void setModel(AgreementModel model) {
        this.model = model;
    }

}
