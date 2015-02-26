/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.core.csp.choco;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.reasoners.ChocoReasoner;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.util.CoreOperationType;
import java.util.logging.Logger;

/**
 *
 * @author AntonioGamez
 */
public class ChocoNumberOfAlternativeDocsCOp extends CoreOperation {

    private Integer numberOfDocs;
    private static final Logger LOG = Logger.getLogger(ChocoNumberOfAlternativeDocsCOp.class.getName());

    public ChocoNumberOfAlternativeDocsCOp() {
        setReasoner(new ChocoReasoner());
        //setCoreTranslator(new ChocoFullTranslator());
        setType(CoreOperationType.NumberOfAlternativeDocs);
    }

    @Override
    public void analyze(AgreementModel agreementModel) {
        //revisar
//        ChocoTranslator4Alternative trans = new ChocoTranslator4Alternative(d);
//        trans.translate();
//        Collection<Constraint> constraints = trans.getChocoConstraints();
//
//        ChocoReasoner reasoner = (ChocoReasoner) getReasoner();
//        Model problem = reasoner.getChocoProblem();
//
//        for (Constraint c : constraints) {
//            problem.addConstraint(c);
//        }
//        CPSolver solver = new CPSolver();
//        solver.read(problem);
//        try {
//            solver.propagate();
//            if (solver.solveAll()) {
//                numberOfDocs = solver.getNbSolutions();
//            } else {
//                numberOfDocs = 0;
//            }
//        } catch (ContradictionException e) {
//            LOG.log(Level.WARNING, "ContradictionException", e);
//        }
    }

    @Override
    public Object getResult() {
        return numberOfDocs;
    }

}
