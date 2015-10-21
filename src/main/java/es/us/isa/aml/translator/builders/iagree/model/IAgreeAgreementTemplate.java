/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementTemplate extends AgreementTemplate {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Template ").append(this.getID()).append(" version ")
				.append(this.getVersion()).append("\n");
		sb.append(getContext()).append("\n");
		sb.append(getAgreementTerms());

		if (this.getCreationConstraints().size() > 0) {
			sb.append("CreationConstraints" + "\n");
			for (CreationConstraint cc : this.getCreationConstraints().values()) {
				sb.append("\t").append(cc).append("\n");
			}
		}

		sb.append("\n" + "EndTemplate");

		return sb.toString();
	}
}
