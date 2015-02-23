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
//import choco.kernel.solver.Solver;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoWarningsTranslator;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.utils.ChocoComplexGT;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AbstractDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.exceptions.InconsistenciesException;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.LudicrousTermsOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.ServiceProperties;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Term;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//
//public class ChocoLudicrousTermsOp extends ChocoOperation implements LudicrousTermsOperation {
//
//    private Collection<Term> res;
//    /*
//     * ludicrous term: si qc cierta -> slo falso qc debe poder ser falsa en
//     * algun caso
//     */
//    /*
//     * pseudocodigo: A => B == !A o B , A => !A == !A o !A
//     * 
//     * 
//     * 
//     * por cada termino: si su QC es falsa respecto al resto de terminos
//     * simples, items, sdt's y cc's no puede ser ludicrous terms si su Qc es
//     * siempre cierta respecto al resto de elementos mirar si existe
//     * contradiccion entre QC y SLO. si la hay, ludicrous term si el valor de
//     * verdad no esta fijado comprobar por un lado QC y SLO comprobar por otro
//     * lado resto de terminos simples y SLO
//     */
//    /*
//     * Implementacion
//     * 
//     * Dos posibilidades para ludicrous terms: 1) SLO se contradice con QC
//     * (unicamente entre los dos) 2) QC cierta, y slo se contradice contra algun
//     * otro termino o CC
//     * 
//     * -Igual que para dead terms, pero incluyendo tambien el SLO?
//     * 
//     * Tomamos todos los terminos muertos, pues los ludicrous son un subconjunto
//     * de estos. mapeamos, por cada GT complejo, su QC, su SLO, y el resto
//     * 
//     * @see
//     * es.us.isa.ada.choco.ChocoOperation#execute(es.us.isa.ada.choco.ChocoAnalyzer
//     * )
//     */
//
//    @Override
//    public void execute(ChocoAnalyzer an) {
//        res = new LinkedList<Term>();
//        if (docs.size() == 1) {
//            AbstractAgreementDocument doc = (AbstractAgreementDocument) docs.get(0);
//            Collection<Term> allTerms = new LinkedList<Term>(doc.getAllTerms());
//            // nos aseguramos de eliminar los service properties
//            Iterator<Term> firstIt = allTerms.iterator();
//            while (firstIt.hasNext()) {
//                Term t = firstIt.next();
//                if (t instanceof ServiceProperties) {
//                    firstIt.remove();
//                }
//            }
//            // cuidado, aqui solo debe haber GT's complejos
//            // GT's sin qualify condition y resto de terminos
//            // van fuera
//            Iterator<Term> itTerms = allTerms.iterator();
//            while (itTerms.hasNext()) {
//                Term t = itTerms.next();
//                if (t instanceof GuaranteeTerm) {
//                    GuaranteeTerm gt = (GuaranteeTerm) t;
//                    if (!gt.hasQualifyCondition()) {
//                        itTerms.remove();
//                    }
//                } else {
//                    itTerms.remove();
//                }
//            }
//            AlternativeDocumentsOperation altsOp = new ChocoAlternativeDocumentsOp();
//            altsOp.addDocument(doc);
//            an.analyze(altsOp);
//            Collection<AbstractDocument> altDocs = altsOp.getAlternativeDocuments();
//            for (AbstractDocument altD : altDocs) {
//                Collection<AbstractDocument> views = super.getViews(altD, an).values();
//                for (AbstractDocument v : views) {
//                    ConsistencyOperation conOp = new ChocoConsistencyOp();
//                    conOp.addDocument(v);
//                    an.analyze(conOp);
//                    if (conOp.isConsistent()) {
//                        // ya sabemos que el documento es consistente
//                        // al serlo, todos los GT sin QC deben cumplirse
//                        // asi que solo nos queda
//                        ChocoWarningsTranslator translator = new ChocoWarningsTranslator(v);
//                        translator.translate();
//                        // No pondremos inconvenientes en que dos GT's complejos
//                        // choquen entre si. Se considerara como un alternative
//                        // encubierto. Mientras que no choquen con el resto de
//                        // elementos no habra poblema
//                        // por cada GT complejo, resolver el problema
//                        // formado por su QC y el resto de elementos del
//                        // documento
//                        Set<Entry<GuaranteeTerm, ChocoComplexGT>> entries = translator.getComplexGTs().entrySet();
//                        Collection<Constraint> chocoConstraints = new ArrayList<Constraint>();
//                        Collection<Constraint> auxCollection1 = translator.getChocoConstraints().values();
//                        Collection<Constraint> auxCollection2 = translator.getCreationContraints().values();
//                        chocoConstraints.addAll(auxCollection1);
//                        chocoConstraints.addAll(auxCollection2);
//                        Constraint[] constraints = chocoConstraints.toArray(new Constraint[0]);
//                        // guardamos ya mapeadas normalmente mediante implies
//                        // todas las GT's complejas
//                        Map<Term, Constraint> complexGtsMapped = new HashMap<Term, Constraint>();
//                        for (Entry<GuaranteeTerm, ChocoComplexGT> e : entries) {
//                            ChocoComplexGT aux = e.getValue();
//                            Constraint c = Choco.implies(aux.getQc(), aux.getSlo());
//                            complexGtsMapped.put(e.getKey(), c);
//                        }
//                        for (Entry<GuaranteeTerm, ChocoComplexGT> e : entries) {
//                            ChocoComplexGT complexGT = e.getValue();
//                            // m.addConstraint(complexGT.getQc());
//                            // m.addConstraint(complexGT.getSlo());
//                            // comprobar primero si el qc y el slo chocan
//                            Model auxModel = new CPModel();
//                            // 1. csp con la QC y el resto de terminos simples
//                            // para evaluar el valor de verdad
//                            // si es falso, no puede ser ludicrous term
//                            // si es cierto, quizas lo sea
//                            auxModel.addConstraint(complexGT.getQc());
//                            if (constraints.length > 0) {
//                                auxModel.addConstraints(constraints);
//                            }
//                            // auxModel.addConstraint(complexGT.getSlo());
//                            Solver auxSolver = new CPSolver();
//                            auxSolver.read(auxModel);
//                            if (auxSolver.solve()) {
//                                // no es falso, por lo que ahora comprobaremos
//                                // si existe contradiccion con el SLO
//                                Model m = new CPModel();
//                                m.addConstraint(complexGT.getQc());
//                                m.addConstraint(complexGT.getSlo());
//                                Solver solver = new CPSolver();
//                                solver.read(m);
//                                if (solver.solve()) {
//                                    // no se contradice con el SLO
//                                    // finalmente vamos a mapear SLO y resto de
//                                    // restricciones
//                                    m = new CPModel();
//                                    m.addConstraint(complexGT.getSlo());
//                                    m.addConstraints(constraints);
//                                    m.addConstraints(complexGtsMapped.values().toArray(new Constraint[0]));
//                                    solver = new CPSolver();
//                                    solver.read(m);
//                                    if (!solver.solve()) {
//                                        // XXX ludicrous term
//                                        if (!res.contains(e.getKey())) {
//                                            res.add(e.getKey());
//                                        }
//                                    } else {
//                                        // no se contradice con el resto de restricciones
//                                        // a-adimos un nuevo caso donde tambi-n a-adimos
//                                        // la restricci-n de la QC del ludicrous. As- 
//                                        // vemos si hay t-rminos que tienen la misma QC
//                                        // o donde la parte izquierda de un IMPLIES coincide
//                                        // con la QC.
//                                        m = new CPModel();
//                                        m.addConstraint(complexGT.getSlo());
//                                        m.addConstraint(complexGT.getQc());
//                                        m.addConstraints(constraints);
//                                        m.addConstraints(complexGtsMapped.values().toArray(new Constraint[0]));
//                                        solver = new CPSolver();
//                                        solver.read(m);
//                                        if (!solver.solve()) {
//                                            // XXX ludicrous term
//                                            if (!res.contains(e.getKey())) {
//                                                res.add(e.getKey());
//                                            }
//                                        }
//                                    }
//                                } else {
//                                    // XXX ludicrous term
//                                    if (!res.contains(e.getKey())) {
//                                        res.add(e.getKey());
//                                    }
//                                }
//                            }
//                        }
//                    } else {
//                        // el documento no es consistente
//                        throw new InconsistenciesException(
//                                "There are inconsistent elements inside the document. They must be solved beforehand to get the dead terms.");
//                    }
//                    // TODO y si dos GT's complejas colisionan entre si???
//                    // TODO y si las QC son complementarias?
//                    // TODO y si el GT complejo ademas es ludicrous?
//                }
//            }
//        }
//    }
//
//    @Override
//    public Collection<Term> getLudicrousTerms() {
//        return res;
//    }
//
//    @Override
//    public boolean hasLudicrousTerms() {
//        return !res.isEmpty();
//    }
//}
