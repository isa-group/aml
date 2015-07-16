/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.reasoners;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.translator.Translator;
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

    public abstract Boolean solve(CSPModel model);

    public abstract OperationResponse explain(CSPModel model);

    public abstract Boolean implies(CSPModel antecedent, CSPModel consequent);

    public abstract OperationResponse whyNotImplies(CSPModel antecedent, CSPModel consequent);
}
