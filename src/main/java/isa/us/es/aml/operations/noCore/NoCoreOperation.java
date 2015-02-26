/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.noCore;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.Operation;
import isa.us.es.aml.operations.reasoners.Reasoner;
import isa.us.es.aml.operations.core.CoreOperation;
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
        this.coreOperations = new HashSet<>();
    }

    @Override
    public abstract void analyze() throws AssertionError;

    @Override
    public Object getResult() {
        return result;
    }

    protected void setResult(Object result) {
        this.result = result;
    }

    public Set<CoreOperation> getCoreOperations() {
        return coreOperations; //we really want modify this field from outside
    }

    protected void setCoreOperations(Set<CoreOperation> coreOperations) {
        this.coreOperations = coreOperations;
    }

    public AgreementModel getModel() {
        return model;
    }

    public void setModel(AgreementModel model) {
        this.model = model;
    }

    public void setDefaultConfig(ReasonerEngineType type) {
        Reasoner reasoner = DefaultReasonerProxy.createDefaultReasoner(type);
        for (CoreOperation op : coreOperations) {
            op.setReasoner(reasoner);
        }
    }

    protected void checkReasonerExistence() {
        for (CoreOperation op : coreOperations) {
            if (op.getReasoner() == null) {
                throw new AssertionError("all core operation should have been provided of an reasoner");
            }
        }
    }

}
