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

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class IAgreeMetric extends Metric {

    public IAgreeMetric(String id) {
        super(id);
    }

    public IAgreeMetric(String id, String type, Domain domain) {
        super(id, type, domain);
    }

    public IAgreeMetric(Metric m) {
        super(m.getId(), m.getType(), m.getDomain());
    }

    @Override
    public String toString() {
        String res = "";
        
        if (getDomain() instanceof Range) {
            IAgreeRange range = new IAgreeRange(((Range) getDomain()).getMin(), ((Range) getDomain()).getMax());
            res = this.getId() + ": " + this.getType() + range + ";";
        } else if (getDomain() instanceof Enumerated) {
        	Object[] values = ((Enumerated) getDomain()).getValues();
            IAgreeEnumerated enume = new IAgreeEnumerated(values);
            res = this.getId() + ": " + this.getType() + enume + ";";
        }
        return res;
    }

}
