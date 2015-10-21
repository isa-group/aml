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
package es.us.isa.aml.translator.builders.wsag.model;

import java.util.Arrays;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class Metric {

	private String id;
	private String type;
	private Domain domain;

	public Metric(String id) {
		this.id = id;
		type = "int";
	}

	public Metric(String id, String type, Domain domain) {
		this.id = id;
		this.type = type;
		this.domain = domain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (getDomain() instanceof Range) {
			Range r = (Range) getDomain();
			String range_str = "[" + r.getMin() + ".." + r.getMax() + "]";
			sb.append("<iag:Metric id=\"").append(getId())
					.append("\" " + "type=\"").append(getType())
					.append("\" " + "domain=\"").append(range_str)
					.append("\">" + "</iag:Metric>").append("\n");
		} else {
			Enumerated e = (Enumerated) getDomain();
			String enum_str = Arrays.asList(e.getValues()).toString().replace("[", "{")
					.replace("]", "}");
			sb.append("<iag:Metric id=\"").append(getId())
					.append("\" " + "type=\"").append(getType())
					.append("\" " + "domain=\"").append(enum_str)
					.append("\">" + "</iag:Metric>").append("\n");
		}
		return sb.toString();
	}
}
