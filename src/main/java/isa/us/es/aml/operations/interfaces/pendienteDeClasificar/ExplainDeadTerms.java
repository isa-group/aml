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
package isa.us.es.aml.operations.interfaces.pendienteDeClasificar;

import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AgreementElement;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import isa.us.es.aml.operations.Operation;
import java.util.Collection;
import java.util.Map;

/**
 * This operation explains the dead terms of an agreement documents, mapping
 * each dead term detected with the elements cause it. Previously, it is
 * necessary to set the dead terms of document, calculated by
 * DeadTermsOperation.
 *
 */
public interface ExplainDeadTerms extends Operation {

    /**
     * Returns the explaining of dead terms. For each dead term previously set,
     * it returns a set of elements that causes the term is dead.
     *
     * A term is considered as dead when its qualifying condition is never hold
     * since it collides with other elements of the document
     *
     * @return Map<Term,Collection<AgreementElement>>
     */
    public Map<Term, Collection<AgreementElement>> explainDeadTerms();

    /**
     * Sets dead terms to explain. You can recover them from DeadTermsOperation
     *
     * @param terms Collection<Term>
     */
    public void setDeadTerms(Collection<Term> terms);
}
