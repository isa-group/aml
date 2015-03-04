/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.translators.Translator;
import isa.us.es.aml.util.CoreOperationProxy;
import isa.us.es.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public abstract class Reasoner {

    protected Translator translator;
    protected ReasonerType type;

    public Object execute(CoreOperation coreOperation, AgreementModel agreementModel) {
        CoreOperation op = CoreOperationProxy.createOperation(coreOperation.getType(), this.getType());
        op.setModel(agreementModel);
        op.setReasoner(coreOperation.getReasoner());
        op.analyze();
        return op.getResult();
    }

    public ReasonerType getType() {
        return this.type;
    }

    public Translator getTranslator() {
        return this.translator;
    }

    public abstract void addProblem(AgreementModel model);

    public abstract Object solve();

    public abstract Object explain();

    public abstract Object implies();

    public abstract Object whyNotImplies();
}
