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

import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import isa.us.es.aml.operations.Operation;
import java.util.Collection;

/**
 * Determines the set of ludicrous terms of an agreement document
 *
 */
public interface LudicrousTermsOperation extends Operation {

    /**
     * Returns true if the document has ludicrous terms.
     *
     * A term is considered as ludicrous when its qualifying condition is hold
     * but the service level objective is contradictory with other terms.
     *
     * @return boolean
     */
    public boolean hasLudicrousTerms();

    /**
     * Returns a collection with the agreement document's ludicrous terms.
     *
     * A term is considered as ludicrous when its qualifying condition is hold
     * but the service level objective is contradictory with other terms.
     *
     * @return Collection<Term>
     */
    public Collection<Term> getLudicrousTerms();
}
