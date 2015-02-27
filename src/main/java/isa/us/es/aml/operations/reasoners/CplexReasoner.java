/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.translators.Translator;
import isa.us.es.aml.translators.csp.opl.OPLBuilder;
import isa.us.es.aml.util.ReasonerType;
import java.util.Random;

/**
 *
 * @author AntonioGamez
 */
public class CplexReasoner extends Reasoner {

    private String oplString;

    public CplexReasoner() {
        type = ReasonerType.CPLEX;
        translator = new Translator(new OPLBuilder());
    }

    @Override
    public void addProblem(AgreementModel model) {
        oplString = translator.export(model);
    }

    @Override
    public Object solve() {
        //todo: realizar lo que sea correcto aqui
        if (oplString != null) {
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

}
