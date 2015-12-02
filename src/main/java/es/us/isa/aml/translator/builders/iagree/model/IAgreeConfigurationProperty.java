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

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;

/**
 * @author jdelafuente
 *
 */
public class IAgreeConfigurationProperty extends ConfigurationProperty {

    public IAgreeConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

    public IAgreeConfigurationProperty(Property cp) {
        super(cp.getId(), cp.getMetric(), cp.getExpression(), cp.getScope(), cp.getFeature());
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getId() + ": " + this.getMetric().getId());
    	
    	if(this.getDefinitionReference() != null){
        	sb.append(" definedAt " + getDefinitionReference());
        }
        
    	if (this.getExpression() != null) {
            sb.append(" = " + this.getExpression());
        }
        
        sb.append(";");
        return sb.toString();
    }
}
