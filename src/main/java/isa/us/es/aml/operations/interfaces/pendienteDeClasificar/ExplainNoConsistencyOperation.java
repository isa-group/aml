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
import isa.us.es.aml.operations.Operation;
import java.util.Collection;
import java.util.Map;

public interface ExplainNoConsistencyOperation extends Operation {

    /**
     * Provides explanations about document inconsistencies. For each
     * inconsistent element, a set of elements that collide with it is exposed.
     *
     * @return Map<AgreementElement,Collection<AgreementElement>>
     */
    public Map<AgreementElement, Collection<AgreementElement>> explainErrors();
}
