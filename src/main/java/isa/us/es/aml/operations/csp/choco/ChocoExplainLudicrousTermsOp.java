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
//import choco.kernel.model.variables.integer.IntegerExpressionVariable;
//import choco.kernel.model.variables.integer.IntegerVariable;
//import choco.kernel.solver.Solver;
//import choco.kernel.solver.variables.integer.IntDomainVar;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoWarningsTranslator;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.utils.ChocoComplexGT;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AbstractDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AgreementElement;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.ExplainLudicrousTerms;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.LudicrousTermsOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Term;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//
//public class ChocoExplainLudicrousTermsOp extends ChocoOperation implements ExplainLudicrousTerms {
//
//    private Map<Term, Collection<AgreementElement>> res;
//    private Collection<Term> ludicrousTerms;
//
//    // aqui nos ahorramos el comprobar que el termino en lugar de ser
//    // ludicrous sea inconsistente, pues lo recibimos desde fuera
//    // previamente con la operacion getLudicrousTerms
//    /*
//     * 
//     * Por cada alternative document consistente, y por cada GT ridiculo que
//     * haya en este, veo si el SLO es conflictivo por si mismo, sino veo si 
//     * el SLO es conflictivo con la QC, sino impongo SLO de este, y reifico
//     * el resto, incluyendo la QC. Maximizo la suma de ellos, y si el resultado
//     * es menor que el actual, me quedo con el.
//     * 
//     * Notas: inicialmente el map estara vacio. Cada termino se a-adira cuando
//     * encontremos alguna explicacion. Si no encontramos ningna, es que no es un
//     * error. Si encontramos alguna, pero luego encontramos que no es un error
//     * (no hay explicacion) lo borraremos al final
//     * 
//     * 
//     * (non-Javadoc)
//     * 
//     * @see
//     * es.us.isa.ada.choco.ChocoOperation#execute(es.us.isa.ada.choco.ChocoAnalyzer
//     * )
//     */
//    @Override
//    public void execute(ChocoAnalyzer an) {
//        res = new HashMap<Term, Collection<AgreementElement>>();
//        if (docs.size() == 1 && ludicrousTerms == null) {
//            ludicrousTerms = getLudicrousTerms(docs.get(0), an);
//        }
//        if (docs.size() == 1 && ludicrousTerms != null && !ludicrousTerms.isEmpty()) {
//            for (Term t : ludicrousTerms) {
//                res.put(t, new LinkedList<AgreementElement>());
//            }
//            AbstractDocument d = docs.get(0);
//            Collection<AbstractDocument> alts = getAlternativeDocuments(d, an);
//            for (AbstractDocument doc : alts) {
//                // si imponemos que deben ser consistentes
//                // habra dead terms (todos aquellos que no sean complejos)
//                // por lo tanto, no vamos a imponerlo-
//                Collection<AbstractDocument> views = super.getViews(doc, an).values();
//                for (AbstractDocument v : views) {
//                    ChocoWarningsTranslator trans = new ChocoWarningsTranslator(v);
//                    trans.translate();
//                    Map<AgreementElement, Constraint> regularCons = trans.getChocoConstraints();
//                    Map<GuaranteeTerm, ChocoComplexGT> complexGTs = trans.getComplexGTs();
//                    Map<AgreementElement, Constraint> ccs = trans.getCreationContraints();
//                    // y por cada uno de ellos, un problema de choco distinto
//                    for (Term t : ludicrousTerms) {
//                        // en el cual imponemos el termino actual
//                        // y reificamos todos los demas
//                        if (res.containsKey(t)) {
//                            // puede darse el caso de que se haya encontrao una
//                            // solucion sin errores, y hayamos borrado el
//                            // termino
//                            // del map
//                            // guardamos el tama-o actual de las explanations
//                            int setSize = res.get(t).size();
//                            // impongo el termino actual (dentro de complexGTs)
//                            Constraint c = null;
//                            ChocoComplexGT complexgt = complexGTs.get(t);
//                            if (complexgt != null) {
//                                // mapeamos solo el SLO
//                                c = complexgt.getSlo();
//                            }
//                            // si el termino no esta en el documento,
//                            // la constraint sera null
//                            if (c != null) {
//                                // probamos si el SLO es consistente consigo mismo
//                                // en caso de no serlo ser- una explicaci-n
//                                Model sloModel = new CPModel();
//                                sloModel.addConstraint(c);
//                                Solver sloSolver = new CPSolver();
//                                sloSolver.read(sloModel);
//                                if (sloSolver.solve()) {
//                                    Model model = new CPModel();
//                                    Solver solver = new CPSolver();
//                                    // vemos si entra en conflicto con su QC
//                                    // a-adimos ambas restricciones
//                                    model.addConstraint(c);
//                                    model.addConstraint(complexgt.getQc());
//                                    solver.read(model);
//                                    if (solver.solve()) {
//                                        // QC y SLO no son conflictivos,
//                                        // vemos si el SLO entra en conflicto con otros t-rminos
//                                        // imponiendo como fija la restricci-n del SLO y la QC
//                                        model.addConstraint(c);
//                                        // reificamos el resto de constraints y las
//                                        // imponemos
//                                        Map<IntegerVariable, AgreementElement> reifiedElements = new HashMap<IntegerVariable, AgreementElement>();
//                                        // reificamos tb la QC del GT complejo como otra
//                                        // posible explicacion
//                                        // (contradiccion entre QC y SLO)
//                                        IntegerVariable reifiedVar = Choco.makeBooleanVar(complexgt.getTerm().getName());
//                                        Constraint reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), complexgt.getQc());
//                                        model.addConstraint(reifiedConstraint);
//                                        reifiedElements.put(reifiedVar, complexgt.getTerm());
//                                        // en este Map guardaremos todos los t-rminos regulares,
//                                        // GTs complejos y creation constraints para despu-s 
//                                        // refinar las explanations
//                                        Map<AgreementElement, Constraint> allTerms = new HashMap<AgreementElement, Constraint>();
//                                        // reificamos terminos regulares
//                                        Set<Entry<AgreementElement, Constraint>> entries1 = regularCons.entrySet();
//                                        for (Entry<AgreementElement, Constraint> e : entries1) {
//                                            if (!t.equals(e.getKey())) {
//                                                reifiedVar = Choco.makeBooleanVar(e.getKey().getName());
//                                                reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), e.getValue());
//                                                model.addConstraint(reifiedConstraint);
//                                                reifiedElements.put(reifiedVar, e.getKey());
//                                                allTerms.put(e.getKey(), e.getValue());
//                                            }
//                                        }
//                                        // reificamos GT's complejos con su implies
//                                        Set<Entry<GuaranteeTerm, ChocoComplexGT>> entries2 = complexGTs.entrySet();
//                                        for (Entry<GuaranteeTerm, ChocoComplexGT> e : entries2) {
//                                            if (!t.equals(e.getKey())) {
//                                                reifiedVar = Choco.makeBooleanVar(e.getKey().getName());
//                                                complexgt = e.getValue();
//                                                Constraint previousConstraint = Choco.implies(complexgt.getQc(), complexgt.getSlo());
//                                                reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), previousConstraint);
//                                                model.addConstraint(reifiedConstraint);
//                                                reifiedElements.put(reifiedVar, e.getKey());
//                                                allTerms.put(e.getKey(), previousConstraint);
//                                            }
//                                        }
//                                        // reificamos los creation constraint
//                                        Set<Entry<AgreementElement, Constraint>> entries3 = ccs.entrySet();
//                                        for (Entry<AgreementElement, Constraint> e : entries3) {
//                                            reifiedVar = Choco.makeBooleanVar(e.getKey().getName());
//                                            reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), e.getValue());
//                                            model.addConstraint(reifiedConstraint);
//                                            reifiedElements.put(reifiedVar, e.getKey());
//                                            allTerms.put(e.getKey(), e.getValue());
//                                        }
//                                        if (!reifiedElements.isEmpty()) {
//                                            IntegerVariable[] reifiedArray = reifiedElements.keySet().toArray(new IntegerVariable[0]);
//                                            IntegerVariable suma = Choco.makeIntVar("@reified-sum", 0, reifiedArray.length);
//                                            // FIXME cuidado con esta linea en los
//                                            // explainings
//                                            IntegerExpressionVariable sumatorio = Choco.sum(reifiedArray);
//                                            Constraint sumReifieds = Choco.eq(suma, sumatorio);
//                                            model.addConstraint(sumReifieds);
//                                            solver = new CPSolver();
//                                            solver.read(model);
//                                            boolean b = solver.maximize(solver.getVar(suma), false);
//                                            if (b) {
//                                                int currentSetSize = reifiedArray.length - (solver.getVar(suma)).getVal();
//                                                if (currentSetSize > 0) {
//                                                    if (setSize == 0) {
//                                                        // esto significa que aun no nos
//                                                        // habiamos
//                                                        // topado con este termino
//                                                        Collection<AgreementElement> elems = getPasiveReifieds(solver, reifiedElements);
//                                                        elems = refineExplanations(complexGTs.get(t), elems, allTerms);
//                                                        res.put(t, elems);
//                                                    } else {
//                                                        // ya tenemos un explaining
//                                                        // previo
//                                                        // asi que comparamos cual es
//                                                        // mejor
//                                                        if (currentSetSize < setSize) {
//                                                            // el actual es mejor
//                                                            Collection<AgreementElement> elems = getPasiveReifieds(solver, reifiedElements);
//                                                            elems = refineExplanations(complexGTs.get(t), elems, allTerms);
//                                                            res.put(t, elems);
//                                                        }
//                                                    }
//                                                } else {
//                                                    // esto significa que no hay
//                                                    // errores!!!!
//                                                    // eliminamos el termino como
//                                                    // ludicrous...
////													res.remove(t);
//                                                    // XXX comento esta linea porque si en una variante no hay
//                                                    // explanations para el ludicrous que tratamos, borra el
//                                                    // ludicrous del resultado evitando que se trate dicho
//                                                    // t-rmino en otras variantes
//                                                }
//                                            }
//                                        }
//                                    } else {
//                                        // la QC y el SLO entran en conflicto,
//                                        // marcamos el propio GT como causa
//                                        Collection<AgreementElement> exp = new LinkedList<AgreementElement>();
//                                        exp.add(t);
//                                        res.put(t, exp);
//                                    }
//                                } else {
//                                    // marcamos el propio GT como causa
//                                    Collection<AgreementElement> exp = new LinkedList<AgreementElement>();
//                                    exp.add(t);
//                                    res.put(t, exp);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public Map<Term, Collection<AgreementElement>> explainLudicrousTerms() {
//        return res;
//    }
//
//    @Override
//    public void setLudicrousTerms(Collection<Term> terms) {
//        ludicrousTerms = terms;
//    }
//
//    private Collection<AbstractDocument> getAlternativeDocuments(AbstractDocument d, ChocoAnalyzer an) {
//        Collection<AbstractDocument> res = new LinkedList<AbstractDocument>();
//        AlternativeDocumentsOperation op = new ChocoAlternativeDocumentsOp();
//        op.addDocument(d);
//        an.analyze(op);
//        res = op.getAlternativeDocuments();
//        return res;
//    }
//
//    private Collection<AgreementElement> getPasiveReifieds(Solver s, Map<IntegerVariable, AgreementElement> elems) {
//        Collection<AgreementElement> res = new LinkedList<AgreementElement>();
//        Set<Entry<IntegerVariable, AgreementElement>> entries = elems.entrySet();
//        for (Entry<IntegerVariable, AgreementElement> e : entries) {
//            IntDomainVar var = s.getVar(e.getKey());
//            if (var.getVal() == 0) {
//                res.add(e.getValue());
//            }
//        }
//        return res;
//    }
//
//    private Collection<Term> getLudicrousTerms(AbstractDocument doc, ChocoAnalyzer an) {
//        LudicrousTermsOperation op = new ChocoLudicrousTermsOp();
//        op.addDocument(doc);
//        an.analyze(op);
//        return op.getLudicrousTerms();
//    }
//
//    /**
//     * Comprueba una por una si cada explicaci-n es conflictiva con la
//     * restricci-n del SLO. En caso de que alguna no sea conflictiva quiere
//     * decir que no es causante del ludicrous term, por lo que no ser- devuelta.
//     *
//     * @param sloCons Constraint del SLO del t-rmino detectado como ludicrous
//     * term
//     * @param explanations Colecci-n de t-rminos devueltos como explicaciones
//     * del ludicrous term
//     * @param allTerms Todos los t-rminos del documento y sus restricciones
//     * @return Colecci-n de explicaciones refinada. S-lo aquellos t-rminos que
//     * son conflictivos con el SLO
//     */
//    private Collection<AgreementElement> refineExplanations(ChocoComplexGT ludicrous, Collection<AgreementElement> explanations, Map<AgreementElement, Constraint> allTerms) {
//        // Si s-lo hay una explicaci-n no refinamos nada
//        if (explanations.size() > 1) {
//            Iterator<AgreementElement> it = explanations.iterator();
//            while (it.hasNext()) {
//                AgreementElement ae = it.next();
//                // S-lo refinamos si la explicaci-n es otro ludicrous
////				if(ludicrousTerms.contains(ae)){
//                Constraint c = allTerms.get(ae);
//                if (c != null) {
//                    Model model = new CPModel();
//                    Solver solver = new CPSolver();
//                    if (ae instanceof GuaranteeTerm) {
//                        GuaranteeTerm gt = (GuaranteeTerm) ae;
//                        if (gt.hasQualifyCondition()) {
//                            if (gt.getQualifyingCondition().equalsIgnoreCase(ludicrous.getTerm().getQualifyingCondition())) {
//                                // la QC del ludicrous y de la explicaci-n es la misma
//                                // por lo que la imponemos en el problema para que se
//                                // compruebe si hay conflicto entre los SLO
//                                model.addConstraint(ludicrous.getSlo());
//                                model.addConstraint(ludicrous.getQc());
//                                model.addConstraint(c); // c es la restricci-n de la explicaci-n
//                            } else {
//                                // la QC del ludicrous y de la explicaci-n son distintas
//                                // por lo que s-lo metemos en el problema el SLO del
//                                // ludicrous y la restricci-n de la explicaci-n
//                                model.addConstraint(ludicrous.getSlo());
//                                model.addConstraint(c); // c es la restricci-n de la explicaci-n
//                            }
//                        } else {
//                            // la explicaci-n es un GT sin QC
//                            // metemos en el problema s-lo los SLO de ambos
//                            model.addConstraint(ludicrous.getSlo());
//                            model.addConstraint(c); // c es la restricci-n de la explicaci-n
//                        }
//                    } else {
//                        // la explicaci-n no es un GT
//                        // metemos el SLO del ludicrous y la restricci-n
//                        // de la explicaci-n
//                        model.addConstraint(ludicrous.getSlo());
//                        model.addConstraint(c);
//                    }
//                    solver.read(model);
//                    if (solver.solve()) {
//                        // tiene soluci-n por lo que no son conflictivas, borramos la explicaci-n
//                        it.remove();
//                    }
//                } else {
//                    System.err.println("El AgreementElement " + ae + " no est- en los t-rminos del documento");
//                }
////				}
//            }
//        }
//        return explanations;
//    }
//}
