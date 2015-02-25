/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.util.CoreOperationProxy;
import isa.us.es.aml.util.ReasonerType;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author AntonioGamez
 */
public class ChocoReasoner implements Reasoner {

    private Model chocoProblem;

    public ChocoReasoner() {
        chocoProblem = new CPModel();
    }

    @Override
    public void analyze(CoreOperation coreOperation, AgreementModel agreementModel) {
        chocoProblem = new CPModel();
        CoreOperation op = CoreOperationProxy.createOperation(coreOperation.getType(),coreOperation.getReasoner().getType());
        op.analyze(agreementModel);
    }

    public void addToChoco(AbstractDocument d) {
//        chocoProblem = new CPModel();
//        ChocoTranslator translator = new ChocoFullTranslator(d);
//        translator.translate();
//        Collection<Variable> vars = translator.getChocoVars().values();
//        Collection<Constraint> constraints = translator.getChocoConstraints().values();
//        Iterator<Variable> itVars = vars.iterator();
//        while (itVars.hasNext()) {
//            Variable v = itVars.next();
//            chocoProblem.addVariable(v);
//        }
//        Iterator<Constraint> itCons = constraints.iterator();
//        while (itCons.hasNext()) {
//            Constraint c = itCons.next();
//            chocoProblem.addConstraint(c);
//        }
//        //TODO guardar el mapeo despues de esto
    }

    public Model getChocoProblem() {
        return chocoProblem;
    }

    public Model getChocoProblem(Collection<Constraint> constraints) {
        CPModel problem = new CPModel();
        Iterator<Constraint> it = constraints.iterator();
        while (it.hasNext()) {
            Constraint c = it.next();
            problem.addConstraint(c);
        }
        return problem;
    }

    @Override
    public Object getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CHOCO;
    }

}
