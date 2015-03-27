/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.reasoners;

import java.util.Random;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.choco.ChocoBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public class ChocoReasoner extends Reasoner {

    private String chocoString;

    public ChocoReasoner() {
        this.type = ReasonerType.CHOCO;
        this.translator = new Translator(new ChocoBuilder());
    }

    @Override
    public Boolean solve(CSPModel model) {
        //todo: realizar lo que sea correcto aqui
    	Boolean res = false;
        if (this.chocoString != null) {
            res = new Random().nextBoolean();
        }
        return res;
    }

    @Override
    public OperationResponse explain(CSPModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OperationResponse implies() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OperationResponse whyNotImplies() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CHOCO;
    }

}
