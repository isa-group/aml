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
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class IAgreeGuaranteeTerm extends GuaranteeTerm {

    public IAgreeGuaranteeTerm(String id) {
        super(id);
    }

    public IAgreeGuaranteeTerm(String id, Role role, SLO slo) {
        super(id, role, slo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t").append(getId()).append(": ").append(getRole()).append(" guarantees ").append(getSlo()).append(";" + "\n");

        if (getServiceScope() != null && !getServiceScope().isEmpty()) {
            sb.append("\t\t\t" + "upon ").append(getServiceScope());
        }

        if (getQc() != null) {
            sb.append("\t\t\t").append(Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])).append("(").append(getQc().getCondition()).append(")" + ";");
            sb.append("\n");
        }

        if (getCompensations().size() > 0) {
            for (Compensation comp : getCompensations()) {
                IAgreeCompensation compensation = (IAgreeCompensation) comp;
                sb.append("\t\t\t").append(compensation.toString());
            }
        }

        return sb.toString();
    }

}
