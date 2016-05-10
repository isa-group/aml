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

import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.CompensationElement;
import es.us.isa.aml.model.CompensationLimit;

/**
 * @author jdelafuente
 *
 */
public class IAgreeCompensation extends Compensation {

    public IAgreeCompensation(Compensation c) {
        super(c.getAssessmentInterval(), c.getCompensationType(), c.getElements());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("with ").append(getAssessmentInterval().toString().toLowerCase()).append(" ").append(getCompensationType().toString().toLowerCase()).append("\n");
        for (CompensationElement elem : getElements()) {
            sb.append("\t\t\t\t" + "of ").append(elem.getExpression().toString()).append(" if ").append(elem.getCondition().toString()).append(";" + "\n");
        }
        for (CompensationLimit limit : getLimits()) {
            sb.append("\t\t\t\t" + "upTo ").append(limit.getExpression().toString()).append(";" + "\n");
        }
        sb.append("\t\t\t" + "end");

        return sb.toString();
    }

}
