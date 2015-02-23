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
import choco.kernel.solver.Solver;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.translators.ChocoWarningsTranslator;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.utils.ChocoComplexGT;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AbstractDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.exceptions.InconsistenciesException;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.DeadTermsOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//XXX esta implementacion, a priori, es correcta
//pasarle pruebas de nuevo

public class ChocoDeadTermsOp extends ChocoOperation implements
        DeadTermsOperation {

    private Collection<Term> res;
    /*
     * Presuponemos consistencia
     * 
     * Guardar todos los terminos (SDT's y GT's) en una lista
     * 
     * Por cada alternative document CONSISTENTE (hay que comprobar su consistencia), 
     * comprobar que terminos se cumplen correctamente (reificando
     * y maximizando). Aquellos que se cumplan,
     * eliminarlos de la lista.
     * 
     * Finalmente devolvemos la lista.
     * 
     */

    @Override
    public void execute(ChocoAnalyzer an) {
        res = new LinkedList<Term>();
        if (docs.size() == 1) {
            AbstractAgreementDocument doc = (AbstractAgreementDocument) docs.get(0);
//			Collection<Term> allTerms = new LinkedList<Term>(doc.getAllTerms());
            AlternativeDocumentsOperation altsOp = new ChocoAlternativeDocumentsOp();
            altsOp.addDocument(doc);
            an.analyze(altsOp);
            Collection<AbstractDocument> altDocs = altsOp.getAlternativeDocuments();
            for (AbstractDocument altD : altDocs) {
                Collection<AbstractDocument> views = super.getViews(altD, an).values();
                for (AbstractDocument v : views) {
                    ConsistencyOperation conOp = new ChocoConsistencyOp();
                    conOp.addDocument(v);
                    an.analyze(conOp);
                    if (conOp.isConsistent()) {
                        //ya sabemos que el documento es consistente
                        //al serlo, todos los GT sin QC deben cumplirse
                        //asi que solo nos queda los GT's con QC
                        ChocoWarningsTranslator translator = new ChocoWarningsTranslator(v);
                        translator.translate();
//						Collection<Term> othersGts = translator.getChocoConstraints().keySet();
                        //eliminamos los terminos validos, que son todos aquellos
                        //del alternative que no tienen Qualify Condition
//						translator.getComplexGTs().keySet()
                        Collection<Term> allTerms = new LinkedList<Term>(translator.getComplexGTs().keySet());
//						for (AgreementElement elem: othersGts){
//							allTerms.remove(elem);
//						}
                        //No pondremos inconvenientes en que dos GT's complejos
                        //choquen entre si. Se considerara como un alternative
                        //encubierto. Mientras que no choquen con el resto de 
                        //elementos no habra poblema
                        //por cada GT complejo, resolver el problema
                        //formado por su QC y el resto de elementos del documento
                        Set<Entry<GuaranteeTerm, ChocoComplexGT>> entries
                                = translator.getComplexGTs().entrySet();
                        Collection<Constraint> chocoConstraints = new ArrayList<Constraint>();
                        Collection<Constraint> auxCollection1 = translator.getChocoConstraints().values();
                        Collection<Constraint> auxCollection2 = translator.getCreationContraints().values();
                        chocoConstraints.addAll(auxCollection1);
                        chocoConstraints.addAll(auxCollection2);
                        Constraint[] constraints
                                = chocoConstraints.toArray(new Constraint[0]);
                        //guardamos ya mapeadas normalmente mediante implies 
                        //todas las GT's complejas
                        Map<Term, Constraint> complexGtsMapped = new HashMap<Term, Constraint>();
                        for (Entry<GuaranteeTerm, ChocoComplexGT> e : entries) {
                            ChocoComplexGT aux = e.getValue();
                            Constraint c = Choco.implies(aux.getQc(), aux.getSlo());
                            complexGtsMapped.put(e.getKey(), c);
                        }
                        for (Entry<GuaranteeTerm, ChocoComplexGT> e : entries) {
                            Model m = new CPModel();
                            if (!chocoConstraints.isEmpty()) {
                                m.addConstraints(constraints);
                            }
                            ChocoComplexGT complexGT = e.getValue();
                            m.addConstraint(complexGT.getQc());
                            //es necesario tb imponer el resto de GT's
                            //complejas como toda la vida, con implies??
                            //SI, puede darse el caso de que la QC
                            //sea cierta si o si para un determinado
                            //alternative
                            Set<Entry<Term, Constraint>> complexGTsMappedSet = complexGtsMapped.entrySet();
                            for (Entry<Term, Constraint> e2 : complexGTsMappedSet) {
                                if (!e2.getKey().equals(complexGT.getTerm())) {
                                    //si no es la propia GT que estamos analizando
                                    //la a-adimos
                                    m.addConstraint(e2.getValue());
                                }
                            }
                            //finalmente, resolvemos, y si no hay problema con
                            //el termino, lo eliminamos del conjunto
                            //de terminos problematicos
                            Solver s = new CPSolver();
                            s.read(m);
                            boolean b = s.solve();
//							System.out.println(s.pretty());
                            if (!b) {
                                allTerms.remove(complexGT.getTerm());
                                if (!res.contains(complexGT.getTerm())) {
                                    res.add(complexGT.getTerm());
                                }
                            }
                        }
                        //TODO y si dos GT's complejas colisionan entre si???
                        //TODO y si las QC son complementarias?
                        //TODO y si el GT complejo ademas es ludicrous?
                    } else {
                        //TODO si no es consistente tenemos que ver cuales son los que fallan
                        //XXX realmente hace falta? si no es consistente
                        //no se elimina ningun termino...
                        // Lanzar excepci-n que diga:
                        // There are inconsistents elements inside the document. They must be solved beforehand to get the dead terms.
                        throw new InconsistenciesException("There are inconsistent elements inside the document. They must be solved beforehand to get the dead terms.");
                    }
                }
            }
            //finalmente, nos quedamos con los terminos que no han aparecido
            //activados en ningun alternative document valido
//			res = new LinkedList<Term>(allTerms);
        }
    }

    @Override
    public Collection<Term> getDeadTerms() {
        return res;
    }

    @Override
    public boolean hasDeadTerms() {
        return !res.isEmpty();
    }
    /*
     * Explaining de Dead terms:
     * 
     * 
     * 
     * Suponemos ya documentos planos, sin alternatives.
     * Por cada deadTerm, imponemos este(1) y reificamos
     * el resto de elementos, maximizando el numero de 
     * elementos. 
     * Si el numero de elementos obtenidos es menor
     * al actual, sustituimos.
     * 
     * 
     * (1) si es un GT normal, lo imponemos tal cual. si es
     * un GT con QC, imponemos solo la QC
     */
}
