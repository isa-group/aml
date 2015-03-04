/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.noCore;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.Operation;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.operations.reasoners.Reasoner;
import isa.us.es.aml.util.DefaultReasonerProxy;
import isa.us.es.aml.util.ReasonerEngineType;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author AntonioGamez
 */
public abstract class NoCoreOperation implements Operation {

    protected Set<CoreOperation> coreOperations = new HashSet<>();
    protected AgreementModel model;
    protected Object result;

    protected NoCoreOperation() {
        coreOperations = new HashSet<>();
    }

    @Override
    public abstract void analyze() throws AssertionError;

    @Override
    public Object getResult() {
        return this.result;
    }

    protected void setResult(Object result) {
        this.result = result;
    }

    public Set<CoreOperation> getCoreOperations() {
        return this.coreOperations; //we really want modify this field from outside
    }

    protected void setCoreOperations(Set<CoreOperation> coreOperations) {
        this.coreOperations = coreOperations;
    }

    public AgreementModel getModel() {
        return this.model;
    }

    public void setModel(AgreementModel model) {
        this.model = model;
    }

    public void setDefaultConfig(ReasonerEngineType type) {
        Reasoner reasoner = DefaultReasonerProxy.createDefaultReasoner(type);
        for (CoreOperation op : this.coreOperations) {
            op.setReasoner(reasoner);
        }
    }

    protected void checkReasonerExistence() {
        for (CoreOperation op : this.coreOperations) {
            if (op.getReasoner() == null) {
                throw new AssertionError("all core operation should have been provided of an reasoner");
            }
        }
    }

}
