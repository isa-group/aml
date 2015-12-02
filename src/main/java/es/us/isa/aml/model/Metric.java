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
package es.us.isa.aml.model;

import es.us.isa.aml.translator.builders.iagree.model.IAgreeUtils;

/**
 * @author jdelafuente
 *
 */
public class Metric extends AgreementElement {

    private String type;
    private Domain domain;

    public Metric(String id) {
        super(id);
        type = "int";
        domain = new Range(0, 100);
    }

    public Metric(String id, String type, Domain domain) {
        super(id);
        setType(type);
        this.domain = domain;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
    	if (IAgreeUtils.DATATYPES.containsKey(type))
			this.type = IAgreeUtils.DATATYPES.get(type);
		else
			this.type = type;
    }

    public Domain getDomain() {
        return this.domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
    
    @Override
    public Metric clone() {
    	Metric m = new Metric(id);
    	m.setType(type);
    	m.setDomain(domain);
    	return m;
    }
}
