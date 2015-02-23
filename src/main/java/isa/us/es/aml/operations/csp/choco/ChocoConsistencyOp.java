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

import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.solver.ContradictionException;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AbstractDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AgreementElement;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ChocoConsistencyOp extends ChocoOperation implements ConsistencyOperation {

    public boolean consistent;

    public ChocoConsistencyOp() {
        super();
        consistent = false;
    }

    @Override
    public boolean isConsistent() {
        return consistent;
    }

    @Override
    public void execute(ChocoAnalyzer an) {
        consistent = true;
        if (!docs.isEmpty()) {
            AbstractAgreementDocument d = (AbstractAgreementDocument) this.docs.get(0);
            ChocoTranslator trans = new ChocoTranslator(d);
            trans.translate();
            Collection<AgreementElement> duplicatedVars = trans.getDuplicatedVars();
            Collection<Term> gtsErrors = trans.getDuplicatedSDTsGTs();
            Map<GuaranteeTerm, Float> badUtils = trans.getBadUtilitySums();
            Collection<AgreementElement> unknownVars = trans.getUnknownVars();
            // comprobaciones previas
            // si hay variables duplicadas, sdts repetidos en valores de
            // utilidad,
            // sumas incorrectas en dichos valores de utilidad de los GT's,
            // o variables no declaradas,
            // el documento no es consistente
            if (!duplicatedVars.isEmpty() || !gtsErrors.isEmpty()
                    || !badUtils.isEmpty() || !unknownVars.isEmpty()) {
                consistent = false;
            } else {
                //con que uno de los documentos planos sea consistente basta
                Collection<AbstractDocument> alternativeDocs = super.getAlternatives(d, an, true);
                Iterator<AbstractDocument> it = alternativeDocs.iterator();
                while (it.hasNext() && consistent) {
                    AbstractAgreementDocument aux = (AbstractAgreementDocument) it.next();
                    Collection<AbstractDocument> views = super.getViews(aux, an).values();
                    Iterator<AbstractDocument> itViews = views.iterator();
                    while (itViews.hasNext() && consistent) {
                        Model problem = new CPModel();
                        trans = new ChocoTranslator(itViews.next());
                        trans.translate();
                        addToChoco(problem, trans);
                        CPSolver solver = new CPSolver();
                        solver.read(problem);
                        try {
                            solver.propagate();
                            consistent = solver.solve();
                        } catch (ContradictionException e) {
                            //no hacemos nada, para que el documento no sea consistente
                            //no deben serlo ninguna de sus alternativas
                            consistent = false;
                        }
                    }
                }
            }
        } else {
            consistent = false;
        }
    }

    public void addToChoco(Model chocoProblem, ChocoTranslator translator) {
        translator.translate();
        Collection<Constraint> constraints = translator.getChocoConstraints().values();
        Iterator<Constraint> itCons = constraints.iterator();
        while (itCons.hasNext()) {
            Constraint c = itCons.next();
            chocoProblem.addConstraint(c);
        }
    }
}
