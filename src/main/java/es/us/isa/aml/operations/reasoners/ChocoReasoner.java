/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.reasoners;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.translators.csp.choco.ChocoBuilder;
import es.us.isa.aml.util.ReasonerType;
import java.util.Random;

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
    public void addProblem(AgreementModel model) {
        this.chocoString = this.translator.export(model);

    }

    @Override
    public Object solve() {
        //todo: realizar lo que sea correcto aqui
        if (this.chocoString != null) {
            return new Random().nextBoolean();
        } else {
            return new Random().nextBoolean();
        }
    }

    @Override
    public Object explain() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object implies() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object whyNotImplies() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CHOCO;
    }

}
