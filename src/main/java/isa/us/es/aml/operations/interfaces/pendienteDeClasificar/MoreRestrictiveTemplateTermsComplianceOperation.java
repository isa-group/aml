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

import isa.us.es.aml.operations.Operation;

/**
 * Checks if the template GTs are more restrictive than the template CCs.
 */
public interface MoreRestrictiveTemplateTermsComplianceOperation extends Operation {

    /**
     * Returns true if the template terms are more restrictive than the template
     * CC, and false in other case
     *
     * @return boolean moreRestrictiveTemplateTermsThanCC
     */
    public boolean isMoreRestrictiveTemplateTermsThanCC();
}
