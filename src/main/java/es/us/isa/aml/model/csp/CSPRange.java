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
package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class CSPRange {

	protected String id;
	protected String type;
	protected String domain;

	public CSPRange(String id) {
		this.id = id;
	}

	public CSPRange(String id, Domain domain) {
		this.id = id;
		this.setDomain(domain);
	}
	
	public CSPRange(Domain domain) {
		this.setDomain(domain);
	}

	public CSPRange(String id, String type, Domain domain) {
		this.id = id;
		this.type = type;
		this.setDomain(domain);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setDomain(Domain domain) {
		Range range = null;

		if (domain instanceof Enumerated) {
			Object[] values = ((Enumerated) domain).getValues();
			range = new Range(0, values.length - 1);
		} else if (domain instanceof Range) {
			range = (Range) domain;
		}

		this.domain = range.getMin() + ".." + range.getMax();
	}

	@Override
	public CSPRange clone() {
		CSPRange range = new CSPRange(getId());
		range.setDomain(getDomain());
		return range;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CSPRange) {
			CSPRange elem = (CSPRange) obj;
			return id.equals(elem.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode() * 31;
	}

	@Override
	public String toString() {
		if (getType() != null)
			return "range " + getType() + " " + this.getId() + " = "
					+ this.getDomain() + ";";
		else
			return "range " + this.getId() + " = " + this.getDomain() + ";";
	}

}
