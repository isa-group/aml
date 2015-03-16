/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.reasoners;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public abstract class Reasoner {

    protected Translator translator;
    protected ReasonerType type;

    public ReasonerType getType() {
        return this.type;
    }

    public Translator getTranslator() {
        return this.translator;
    }

    public abstract void addProblem(AgreementModel model);

    public abstract OperationResponse solve();

    public abstract OperationResponse explain();

    public abstract OperationResponse implies();

    public abstract OperationResponse whyNotImplies();
}
