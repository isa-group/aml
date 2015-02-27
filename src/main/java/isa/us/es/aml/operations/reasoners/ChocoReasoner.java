/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.translators.Translator;
import isa.us.es.aml.translators.csp.choco.ChocoBuilder;
import isa.us.es.aml.util.ReasonerType;
import java.util.Random;

/**
 *
 * @author AntonioGamez
 */
public class ChocoReasoner extends Reasoner {

    private String chocoString;

    public ChocoReasoner() {
        type = ReasonerType.CHOCO;
        translator = new Translator(new ChocoBuilder());
    }

    @Override
    public void addProblem(AgreementModel model) {
        chocoString = translator.export(model);

    }

    @Override
    public Object solve() {
        //todo: realizar lo que sea correcto aqui
        if (chocoString != null) {
            return new Random().nextBoolean();
        } else {
            return new Random().nextBoolean();
        }
    }

    @Override
    public Object explain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object implies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object whyNotImplies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CHOCO;
    }

}
