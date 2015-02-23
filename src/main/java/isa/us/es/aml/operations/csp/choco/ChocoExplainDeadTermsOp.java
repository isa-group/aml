/**
 * This file is part of ADA.
 *
 * ADA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * ADA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ADA. If not, see <http://www.gnu.org/licenses/>.
 */
package isa.us.es.aml.operations.csp.choco;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.Solver;
import choco.kernel.solver.variables.integer.IntDomainVar;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.translators.ChocoWarningsTranslator;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.utils.ChocoComplexGT;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AbstractDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AgreementElement;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.DeadTermsOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.ExplainDeadTerms;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ChocoExplainDeadTermsOp extends ChocoOperation implements ExplainDeadTerms {

    private Map<Term, Collection<AgreementElement>> res;
    private Collection<Term> deadTerms;
    /*
     * 
     * Por cada alternative document consistente, y por cada termino muerto que
     * haya en este, impongo este(1), y reifico el resto. Maximizo la suma de
     * ellos, y si el resultado es menor que el actual, me quedo con el.
     * 
     * Notas: inicialmente el map estara vacio. Cada termino se a-adira cuando
     * encontremos alguna explicacion. Si no encontramos ningna, es que no es un
     * error. Si encontramos alguna, pero luego encontramos que no es un error
     * (no hay explicacion) lo borraremos al final
     * 
     * (1) Si es un GT complejo, imponemos unicamente la QC.
     * 
     * TODO creo que se me olvida algo en la implementacion, pero no se el que
     * 
     * @see
     * es.us.isa.ada.choco.ChocoOperation#execute(es.us.isa.ada.choco.ChocoAnalyzer
     * )
     */

    @Override
    public void execute(ChocoAnalyzer an) {
        res = new HashMap<Term, Collection<AgreementElement>>();
        if (docs.size() == 1 && deadTerms == null) {
            deadTerms = getDeadTerms(docs.get(0), an);
        }
        if (docs.size() == 1 && deadTerms != null && !deadTerms.isEmpty()) {
            for (Term t : deadTerms) {
                res.put(t, new LinkedList<AgreementElement>());
            }
            AbstractDocument d = docs.get(0);
            Collection<AbstractDocument> alts = getAlternativeDocuments(d, an);
            for (AbstractDocument doc : alts) {
                // si imponemos que deben ser consistentes
                // habra dead terms (todos aquellos que no sean complejos)
                // por lo tanto, no vamos a imponerlo
                Collection<AbstractDocument> views = super.getViews(doc, an).values();
                for (AbstractDocument v : views) {
                    ChocoWarningsTranslator trans = new ChocoWarningsTranslator(v);
                    trans.translate();
                    Map<AgreementElement, Constraint> regularCons = trans.getChocoConstraints();
                    Map<GuaranteeTerm, ChocoComplexGT> complexGTs = trans.getComplexGTs();
                    Map<AgreementElement, Constraint> ccs = trans.getCreationContraints();
                    // y por cada uno de ellos, un problema de choco distinto
                    for (Term t : deadTerms) {
                        // en el cual imponemos el termino actual
                        // y reificamos todos los demas
                        if (res.containsKey(t)) {
                            // puede darse el caso de que se haya encontrao una
                            // solucion sin errores, y hayamos borrado el
                            // termino
                            // del map
                            // guardamos el tama-o actual de las explanations
                            int setSize = res.get(t).size();
                            // impongo el termino actual (dentro de regularCons
                            // o complexGTs)
                            Constraint c = regularCons.get(t);
                            if (c == null) {
                                ChocoComplexGT complexgt = complexGTs.get(t);
                                if (complexgt != null) {
                                    c = complexgt.getQc();
                                }
                            }
                            // si el termino no esta en el documento,
                            // la constraint sera null
                            if (c != null) {
                                Model model = new CPModel();
                                // imponemos como fija unicamente la restriccion
                                // del termino
                                // que tenemos entre manos
                                model.addConstraint(c);
                                Solver preSolver = new CPSolver();
                                preSolver.read(model);
                                if (preSolver.solve()) {
                                    // la QC no es falsa de por si
                                    // reificamos el resto de constraints y las
                                    // imponemos
                                    Map<IntegerVariable, AgreementElement> reifiedElements = new HashMap<IntegerVariable, AgreementElement>();
                                    // reificamos terminos regulares
                                    Set<Entry<AgreementElement, Constraint>> entries1 = regularCons.entrySet();
                                    for (Entry<AgreementElement, Constraint> e : entries1) {
                                        if (!t.equals(e.getKey())) {
                                            IntegerVariable reifiedVar = Choco.makeBooleanVar(e.getKey().getName());
                                            Constraint reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), e.getValue());
                                            model.addConstraint(reifiedConstraint);
                                            reifiedElements.put(reifiedVar, e.getKey());
                                        }
                                    }
                                    // reificamos GT's complejos con su implies
                                    Set<Entry<GuaranteeTerm, ChocoComplexGT>> entries2 = complexGTs.entrySet();
                                    for (Entry<GuaranteeTerm, ChocoComplexGT> e : entries2) {
                                        if (!t.equals(e.getKey())) {
                                            IntegerVariable reifiedVar = Choco.makeBooleanVar(e.getKey().getName());
                                            ChocoComplexGT complexgt = e.getValue();
                                            Constraint previousConstraint = Choco.implies(complexgt.getQc(), complexgt.getSlo());
                                            Constraint reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), previousConstraint);
                                            model.addConstraint(reifiedConstraint);
                                            reifiedElements.put(reifiedVar, e.getKey());
                                        }
                                    }
                                    // reificamos los creation constraint
                                    Set<Entry<AgreementElement, Constraint>> entries3 = ccs.entrySet();
                                    for (Entry<AgreementElement, Constraint> e : entries3) {
                                        IntegerVariable reifiedVar = Choco.makeBooleanVar(e.getKey().getName());
                                        Constraint reifiedConstraint = Choco.implies(Choco.eq(reifiedVar, 1), e.getValue());
                                        model.addConstraint(reifiedConstraint);
                                        reifiedElements.put(reifiedVar, e.getKey());
                                    }
                                    if (!reifiedElements.isEmpty()) {
                                        IntegerVariable[] reifiedArray = reifiedElements.keySet().toArray(new IntegerVariable[0]);
                                        IntegerVariable suma = Choco.makeIntVar("@reified-sum", 0, reifiedArray.length);
                                        // FIXME cuidado con estas lineas en los
                                        // explainings
                                        IntegerExpressionVariable sumatorio = Choco.sum(reifiedArray);
                                        Constraint sumReifieds = Choco.eq(suma, sumatorio);
                                        model.addConstraint(sumReifieds);
                                        Solver solver = new CPSolver();
                                        solver.read(model);
                                        boolean b = solver.maximize(solver.getVar(suma), false);
                                        if (b) {
                                            int currentSetSize = reifiedArray.length - (solver.getVar(suma)).getVal();
                                            if (currentSetSize > 0) {
                                                if (setSize == 0) {
                                                    // esto significa que aun no
                                                    // nos habiamos
                                                    // topado con este termino
                                                    Collection<AgreementElement> elems = getPasiveReifieds(solver, reifiedElements);
                                                    res.put(t, elems);
                                                } else {
                                                    // ya tenemos un explaining
                                                    // previo
                                                    // asi que comparamos cual
                                                    // es mejor
                                                    if (currentSetSize < setSize) {
                                                        // el actual es mejor
                                                        Collection<AgreementElement> elems = getPasiveReifieds(solver, reifiedElements);
                                                        res.put(t, elems);
                                                    }
                                                }
                                            } else {
                                                // esto significa que no hay
                                                // errores!!!!
                                                // eliminamos el termino como
                                                // muerto...
//												res.remove(t);
                                            }
                                        }
                                    }
                                } else {
                                    // la QC es falsa por si misma
                                    Collection<AgreementElement> auxCol = new LinkedList<AgreementElement>();
                                    auxCol.add(t);
                                    res.put(t, auxCol);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Map<Term, Collection<AgreementElement>> explainDeadTerms() {
        return res;
    }

    @Override
    public void setDeadTerms(Collection<Term> terms) {
        deadTerms = terms;
    }

    private Collection<AbstractDocument> getAlternativeDocuments(AbstractDocument d, ChocoAnalyzer an) {
        Collection<AbstractDocument> res = new LinkedList<AbstractDocument>();
        AlternativeDocumentsOperation op = new ChocoAlternativeDocumentsOp();
        op.addDocument(d);
        an.analyze(op);
        res = op.getAlternativeDocuments();
        return res;
    }

    private Collection<AgreementElement> getPasiveReifieds(Solver s, Map<IntegerVariable, AgreementElement> elems) {
        Collection<AgreementElement> res = new LinkedList<AgreementElement>();
        Set<Entry<IntegerVariable, AgreementElement>> entries = elems.entrySet();
        for (Entry<IntegerVariable, AgreementElement> e : entries) {
            IntDomainVar var = s.getVar(e.getKey());
            if (var.getVal() == 0) {
                res.add(e.getValue());
            }
        }
        return res;
    }

    private Collection<Term> getDeadTerms(AbstractDocument doc, ChocoAnalyzer an) {
        DeadTermsOperation op = new ChocoDeadTermsOp();
        op.addDocument(doc);
        an.analyze(op);
        return op.getDeadTerms();
    }
}
