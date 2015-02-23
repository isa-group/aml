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
//import choco.Choco;
//import choco.cp.model.CPModel;
//import choco.cp.solver.CPSolver;
//import choco.kernel.model.Model;
//import choco.kernel.model.constraints.Constraint;
//import choco.kernel.model.constraints.ConstraintType;
//import choco.kernel.model.variables.integer.IntegerExpressionVariable;
//import choco.kernel.model.variables.integer.IntegerVariable;
//import choco.kernel.solver.Solver;
//import choco.kernel.solver.variables.integer.IntDomainVar;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoReifiedTranslator;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AbstractDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AgreementElement;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.ExplainNoConsistencyOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.OfferItem;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Term;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
///*
// * Devolvemos el conjunto minimo de explanations que, dandoles
// * arreglo, hace que el documento sea consistente.
// * Para documentos con multiples alternatives, devolvemos
// * el conjunto mas peque-o de todos los posibles entre
// * todos los alternatives.
// * @author Jesus
// *
// */
//
//public class ChocoExplainNoConsistencyOp extends ChocoOperation implements ExplainNoConsistencyOperation {
//
//    private Map<AgreementElement, Collection<AgreementElement>> res;
//    /*
//     * Por cada alternative, reificamos e intentamos maximizar. Nos vamos
//     * quedando con el conjunto menor (y su documento plano)
//     * 
//     * Una vez tengamos el menor, por cada elemento dentro del conjunto de
//     * conflicto, imponemos este y reificamos el resto para obtener el mapping
//     * AgreementElement -> Collection<AgreementElement>
//     * 
//     * (non-Javadoc)
//     * 
//     * @see
//     * es.us.isa.ada.choco.ChocoOperation#execute(es.us.isa.ada.choco.ChocoAnalyzer
//     * )
//     */
//
//    @Override
//    public void execute(ChocoAnalyzer an) {
//        res = new HashMap<AgreementElement, Collection<AgreementElement>>();
//        AbstractDocument d = this.docs.get(0);
//        // explanations previas sobre variables duplicadas, SDT's duplicados
//        // en las referencias desde GT's para valores de utilidad, y
//        // sumas incorrectas de los valores de utilidad
//        ChocoTranslator basicTrans = new ChocoTranslator(d);
//        basicTrans.translate();
//        Collection<AgreementElement> duplicatedVars = basicTrans.getDuplicatedVars();
//        Collection<Term> gtsErrors = basicTrans.getDuplicatedSDTsGTs();
//        Map<GuaranteeTerm, Float> badUtils = basicTrans.getBadUtilitySums();
//        Collection<AgreementElement> unknownVars = basicTrans.getUnknownVars();
//        if (!duplicatedVars.isEmpty()) {
//            for (AgreementElement elem : duplicatedVars) {
//                res.put(elem, new LinkedList<AgreementElement>());
//            }
//        }
//        if (!gtsErrors.isEmpty()) {
//            for (AgreementElement elem : gtsErrors) {
//                res.put(elem, new LinkedList<AgreementElement>());
//            }
//        }
//        if (!badUtils.isEmpty()) {
//            for (AgreementElement elem : badUtils.keySet()) {
//                res.put(elem, new LinkedList<AgreementElement>());
//            }
//        }
//        if (!unknownVars.isEmpty()) {
//            for (AgreementElement elem : unknownVars) {
//                res.put(elem, new LinkedList<AgreementElement>());
//            }
//        }
//        // aqui almacenamos el conjunto minimo de explanations
//        Collection<IntegerVariable> minSet = new LinkedList<IntegerVariable>();
//        Collection<Constraint> minSetConstraints = null;
//        Map<IntegerVariable, AgreementElement> minSetVars = null;
//        int minSetSize = Integer.MAX_VALUE;
//        ChocoReifiedTranslator minSetTranslator = null;
//        Collection<AbstractDocument> altDocs = super.getAlternatives(d, an, true);
//        // -----------------------
//        // ------ ERRORES --------
//        // -----------------------
//        // por cada alternative, tomamos el minimo conjunto de elementos
//        // de explaining, y de todos los alternatives, nos kedamos con el menor
//        Iterator<AbstractDocument> it = altDocs.iterator();
//        // boolean hayErrores = true;
//        while (it.hasNext()) {
//            AbstractAgreementDocument alternative = (AbstractAgreementDocument) it.next();
//            Collection<AbstractDocument> views = super.getViews(alternative, an).values();
//            Iterator<AbstractDocument> itViews = views.iterator();
//            while (itViews.hasNext()) {
//                AbstractDocument v = itViews.next();
//                ChocoReifiedTranslator trans = new ChocoReifiedTranslator(v);
//                trans.translate();
//                Collection<Constraint> constraints = trans.getChocoConstraints().values();
//                Map<IntegerVariable, AgreementElement> reifiedVars = trans.getReifiedVariables();
//                if (!reifiedVars.isEmpty()) {
//                    IntegerVariable[] varsToMax = reifiedVars.keySet().toArray(new IntegerVariable[0]);
//                    IntegerVariable suma = Choco.makeIntVar("Maximizacion", 0, varsToMax.length);
//                    // esta linea esta bien
//                    IntegerExpressionVariable sumatorio = Choco.sum(varsToMax);
//                    Constraint sumReifieds = Choco.eq(suma, sumatorio);
//                    CPModel problem = new CPModel();
//                    Iterator<Constraint> itConstraints = constraints.iterator();
//                    while (itConstraints.hasNext()) {
//                        Constraint c = itConstraints.next();
//                        problem.addConstraint(c);
//                    }
//                    problem.addConstraint(sumReifieds);
//                    CPSolver solver = new CPSolver();
//                    solver.read(problem);
//                    solver.maximize(solver.getVar(suma), false);
//                    // si ha encontrado errores
//                    if ((solver.getVar(suma)).getVal() < varsToMax.length) {
//                        Set<IntegerVariable> expElements = new HashSet<IntegerVariable>();
//                        Iterator<Entry<IntegerVariable, AgreementElement>> itVars = reifiedVars.entrySet().iterator();
//                        while (itVars.hasNext()) {
//                            Entry<IntegerVariable, AgreementElement> e = itVars.next();
//                            IntDomainVar solVar = solver.getVar(e.getKey());
//                            if (solVar.getVal() == 0) {
//                                expElements.add(e.getKey());
//                            }
//                        }
//                        if (expElements.size() < minSetSize) {
//                            minSetSize = expElements.size();
//                            minSet = expElements;
//                            minSetConstraints = constraints;
//                            minSetVars = reifiedVars;
//                            minSetTranslator = trans;
//                            /*
//                             * detalle de implementacion: choco almacena en las
//                             * variables todas las constraints en las que dicha
//                             * variable aparece. por ello, vamos a eliminar esas
//                             * restricciones, salvo la del reificado de la
//                             * variable con el if only if (si y solo si)
//                             */
//                            Set<Entry<IntegerVariable, AgreementElement>> entries = reifiedVars.entrySet();
//                            for (Entry<IntegerVariable, AgreementElement> entry : entries) {
//                                IntegerVariable var = entry.getKey();
//                                Constraint[] varConstraints = var.getConstraints();
//                                for (Constraint c : varConstraints) {
//                                    if (!c.getConstraintType().equals(ConstraintType.IFONLYIF)) {
//                                        // This was var.removeConstraint(c); but the method doesn't exist
//                                        var._removeConstraint(c);
//                                        //var.removeConstraints();	
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
////		System.out.println("Ya hemos encontrado los errores");
//        // ----------------------
//        // ---- EXPLAINING ------
//        // ------ (CAUSAS) ------
//        // ----------------------
//        // por cada error encontrado en el conjunto minimo
//        if (minSetSize > 0) {
//            for (IntegerVariable var : minSet) {
//                Set<Entry<IntegerVariable, AgreementElement>> entries = minSetVars.entrySet();
//                AgreementElement error = minSetVars.get(var);
//                Collection<AgreementElement> causes = new LinkedList<AgreementElement>();
//                CPModel problem = new CPModel();
//                // recordar que ya tenemos el conjunto minimo de fallos
//                // ya solo queda encontrar aquellos elementos que los originan
//                // comprobamos con esto si el termino falla
//                // por si mismo
//                Model auxModel = new CPModel();
//                Constraint[] varConstraints = var.getConstraints();
//                auxModel.addConstraints(varConstraints);
//                // aqui tengo que cargarme el resto de restricciones
//                // que son erroneas
//                auxModel.addConstraint(Choco.eq(var, 1));
//                Solver auxSolver = new CPSolver();
//                auxSolver.read(auxModel);
//                if (auxSolver.solve()) {
//                    // Y LAS RESTRICCIONES DE ABAJO, POR QUE NO SE REIFICAN?
//                    // porque esas no fallan seguro
//                    // al encontar las inconsistencias, buscamos todas las
//                    // soluciones,
//                    // y en ese conjunto estan todas las restricciones
//                    // problematicas
//                    Iterator<Constraint> itConstraints = minSetConstraints.iterator();
//                    while (itConstraints.hasNext()) {
//                        Constraint c = itConstraints.next();
//                        problem.addConstraint(c);
//                    }
//                    // necesito eliminar
//                    // las constraints de los otros errores
//                    Map<IntegerVariable, AgreementElement> auxMap1 = minSetTranslator.getReifiedVariables();
//                    Map<String, Constraint> auxMap2 = minSetTranslator.getChocoConstraints();
//                    for (IntegerVariable varAux : minSet) {
//                        if (varAux != var) {
//                            AgreementElement elemAux = auxMap1.get(varAux);
//                            //Distinguimos entre OfferItem y el resto de AgElements.
//                            //Sino, el nombre del OfferItem se puede considerar
//                            //erroneamente como un Item de CreationConstraint y
//                            //eliminar la constraint equivocada
//                            if (elemAux instanceof OfferItem) {
//                                Constraint cAux = auxMap2.get(elemAux.toString());
//                                problem.removeConstraint(cAux);
//                            } else {
//                                Constraint cAux = auxMap2.get(elemAux.getName());
//                                problem.removeConstraint(cAux);
//                            }
//                        }
//                    }
//                    // y meto variables reificadas
//                    // el error lo impongo como fijo a 1
//                    Collection<IntegerVariable> reifiedVars = new LinkedList<IntegerVariable>();
//                    for (Entry<IntegerVariable, AgreementElement> entry : entries) {
//                        if (entry.getKey() == var) {
//                            Constraint c1 = Choco.eq(entry.getKey(), 1);
//                            problem.addConstraint(c1);
//                        } else {
//                            reifiedVars.add(entry.getKey());
//                        }
//                    }
//                    IntegerVariable[] varsToMax = reifiedVars.toArray(new IntegerVariable[0]);
//                    IntegerVariable suma = Choco.makeIntVar("Maximizacion", 0, varsToMax.length);
//                    if (varsToMax.length > 0) {
//                        IntegerExpressionVariable sumatorio = Choco.sum(varsToMax);
//                        Constraint sumReifieds = Choco.eq(suma, sumatorio);
//                        problem.addConstraint(sumReifieds);
//                        Solver solver = new CPSolver();
//                        solver.read(problem);
//                        solver.maximize(solver.getVar(suma), false);
//                        // en el solver ya tenemos impuesta la restriccion
//                        // del error, y reificadas las posibles causas
//                        // ahora maximizamos las posibles causas
//                        // para encontrar las verdaderas
//                        for (Entry<IntegerVariable, AgreementElement> entry : entries) {
//                            IntDomainVar solVar = solver.getVar(entry.getKey());
//                            if (solVar.getVal() == 0) {
//                                AgreementElement cause = entry.getValue();
////								//Si es un OfferItem queremos que aparezca 
////								//como por ejemplo "SDT1-Size"
////								if(cause instanceof OfferItem){
////									cause.setName(((OfferItem)cause).toString());
////								}
//                                causes.add(cause);
//                            }
//                        }
//                    }
//                } else {
//                    // la causa es la propia restriccion consigo misma
//                    causes.add(error);
//                    // TODO hay que tener cuidao en este caso, pk puede afectar
//                    // a otros
//                    // elementos, cuando el problema de este elemento es consigo
//                    // mismo
//                }
////				//Si el error es un OfferItem queremos que aparezca
////				//como por ejemplo "SDT1-Size"
////				if(error instanceof OfferItem){
////					error.setName(((OfferItem)error).toString());
////				}
//                res.put(error, causes);
//            }
//        }
////		System.out.println("Ya hemos encontrando las explanations a los errores");
//    }
//
//    @Override
//    public Map<AgreementElement, Collection<AgreementElement>> explainErrors() {
//        return res;
//    }
//}
