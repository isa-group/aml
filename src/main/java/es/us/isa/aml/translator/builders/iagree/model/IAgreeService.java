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
package es.us.isa.aml.translator.builders.iagree.model;

import java.util.Map;

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceConfiguration;

/**
 * @author jdelafuente
 *
 */
public class IAgreeService extends ServiceConfiguration {

	public IAgreeService() {
	}
	
	public IAgreeService(ServiceConfiguration s) {
		super(s.getServiceName(), s.getEndpointReference(), s.getFeatures(), s.getConfigurationProperties());
	}	

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Service ").append(this.getServiceName()).append(" availableAt " + "\"").append(this.getEndpointReference()).append("\"").append("\n");

        if (getFeatures().size() > 0) {
            sb.append("\t\t" + "Features: ").append(getFeatures().values().toString().replace("[", "").replace("]", "")).append(";").append("\n");
        }
        
        Map<String, ConfigurationProperty> cps = this.getConfigurationProperties();
        
        sb.append("\t\t" + "GlobalDescription").append("\n");
        for (ConfigurationProperty cp : cps.values()) {
            if (cp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(cp).append("\n");
            }
        }

        for (ConfigurationProperty cp : cps.values()) {
            if (cp.getScope() == Scope.Local) {
                sb.append("\t\t" + "Description for ").append(cp.getFeature().getId()).append(":" + "\n");
                sb.append("\t\t\t").append(cp).append("\n");
            }
        }

        return sb.toString();
    }

}
