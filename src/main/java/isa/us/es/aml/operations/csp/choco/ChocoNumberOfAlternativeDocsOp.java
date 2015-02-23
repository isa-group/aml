///**
// * This file is part of ADA.
// *
// * ADA is free software: you can redistribute it and/or modify it under the
// * terms of the GNU Lesser General Public License as published by the Free
// * Software Foundation, either version 3 of the License, or (at your option) any
// * later version.
// *
// * ADA is distributed in the hope that it will be useful, but WITHOUT ANY
// * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
// * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
// * details.
// *
// * You should have received a copy of the GNU Lesser General Public License
// * along with ADA. If not, see <http://www.gnu.org/licenses/>.
// */
//package isa.us.es.aml.operations.csp.choco;
//
//import choco.cp.solver.CPSolver;
//import choco.kernel.model.Model;
//import choco.kernel.model.constraints.Constraint;
//import choco.kernel.solver.ContradictionException;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator4Alternative;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.NumberOfAlternativeDocsOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
//import java.util.Collection;
//import java.util.Iterator;
//
//public class ChocoNumberOfAlternativeDocsOp extends ChocoOperation implements
//        NumberOfAlternativeDocsOperation {
//
//    private int numberOfDocs;
//
//    @Override
//    public int getNumberOfAlternativeDocs() {
//        return numberOfDocs;
//    }
//
//    @Override
//    public void execute(ChocoAnalyzer an) {
//        AbstractAgreementDocument d = (AbstractAgreementDocument) this.docs.get(0);
//        ChocoTranslator4Alternative trans = new ChocoTranslator4Alternative(d);
//        trans.translate();
//        Collection<Constraint> constraints = trans.getChocoConstraints();
//        Model problem = an.getChocoProblem();
//        Iterator<Constraint> it = constraints.iterator();
//        while (it.hasNext()) {
//            Constraint c = it.next();
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
//            e.printStackTrace();
//        }
//    }
//}
