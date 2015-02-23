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

import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.ContradictionException;
import choco.kernel.solver.variables.integer.IntDomainVar;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator4Alternative;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AbstractDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Template;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.TermCompositor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ChocoAlternativeDocumentsOp extends ChocoOperation implements
        AlternativeDocumentsOperation {

    private List<AbstractDocument> altDocs;
    private boolean orToAnd;

    public ChocoAlternativeDocumentsOp() {
        orToAnd = false;
    }

    @Override
    public Collection<AbstractDocument> getAlternativeDocuments() {
        return altDocs;
    }

    @Override
    public int getNumberOfDocuments() {
        return altDocs.size();
    }

    @Override
    public void execute(ChocoAnalyzer an) {
        // TODO Auto-generated method stub
        altDocs = new LinkedList<AbstractDocument>();
        AbstractAgreementDocument d = (AbstractAgreementDocument) this.docs.get(0);
        ChocoTranslator4Alternative trans = new ChocoTranslator4Alternative(d, orToAnd);
        trans.translate();
        Collection<Constraint> constraints = trans.getChocoConstraints();
        Map<IntegerVariable, Term> varsToTerms = trans.getVarsToTerms();
        Model problem = an.getChocoProblem();
        Iterator<Constraint> it = constraints.iterator();
        while (it.hasNext()) {
            Constraint c = it.next();
            problem.addConstraint(c);
        }
        CPSolver solver = new CPSolver();
        solver.read(problem);
        try {
            solver.propagate();
            if (solver.solve()) {
                AbstractAgreementDocument newDoc = createAlternativeDoc(d, varsToTerms, solver);
                altDocs.add(newDoc);
                while (solver.nextSolution()) {
                    newDoc = createAlternativeDoc(d, varsToTerms, solver);
                    altDocs.add(newDoc);
                }
            }
        } catch (ContradictionException e) {
            e.printStackTrace();
        }
    }

    private AbstractAgreementDocument createAlternativeDoc(AbstractAgreementDocument d,
            Map<IntegerVariable, Term> varsToTerms, CPSolver solver) {
        AbstractAgreementDocument doc;
        if (d instanceof Template) {
            Template template = new Template();
            Template docTemplate = (Template) d;
            template.setCc(docTemplate.getCc());
            doc = template;
        } else {
            doc = new AgreementOffer();
        }
        TermCompositor compositor = new TermCompositor();
        compositor.setType(TermCompositor.ALL);
        compositor.setName("terms");
        Iterator<Entry<IntegerVariable, Term>> itVars = varsToTerms.entrySet().iterator();
        while (itVars.hasNext()) {
            Entry<IntegerVariable, Term> e = itVars.next();
            IntDomainVar solVar = solver.getVar(e.getKey());
            if (solVar.getVal() == 1) {
                compositor.addComprisedTerm(e.getValue());
            }
        }
        doc.setContext(d.getContext());
        doc.setName(d.getName());
        doc.setId(d.getId());
        doc.setTerms(compositor);
        return doc;
    }

    public void orToAnd(boolean b) {
        this.orToAnd = b;
    }
}
