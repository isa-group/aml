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
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class Constraint extends CreationConstraint {

    /**
     * @param id The constraint identifier
     * @param slo The constraint service level objective
     */
    public Constraint(String id, SLO slo) {
        super(id, slo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t" + "<wsag:Constraint>").append("\n");
        sb.append("\t\t\t" + "<Name>").append(getId()).append("</Name>").append("\n");

        if (getQc() != null) {
            sb.append("\t\t\t" + "<Content>").append(Util.encodeEntities(getQc().getCondition().toString())).append(" IMPLIES ").append(Util.encodeEntities(getSlo().getExpression().toString())).append("</Content>").append("\n");
        } else {
            sb.append("\t\t\t" + "<Content>").append(Util.encodeEntities(getSlo().getExpression().toString())).append("</Content>").append("\n");
        }

        sb.append("\t\t" + "</wsag:Constraint>").append("\n");
        return sb.toString();
    }

}
