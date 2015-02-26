/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.util.CoreOperationProxy;
import isa.us.es.aml.util.ReasonerType;
import java.util.Random;

/**
 *
 * @author AntonioGamez
 */
public class CplexReasoner implements Reasoner {

    @Override
    public Object execute(CoreOperation coreOperation, AgreementModel agreementModel) {
        CoreOperation op = CoreOperationProxy.createOperation(coreOperation.getType(), getType());
        op.setModel(agreementModel);
        op.setReasoner(coreOperation.getReasoner());
        op.analyze();
        return op.getResult();
    }

    @Override
    public void addProblem(Object model) {

    }

    @Override
    public Object solve() {
        //todo: realizar lo que sea correcto aqui
        return new Random().nextBoolean();
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
        return ReasonerType.CPLEX;
    }

}
