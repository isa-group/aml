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

import java.util.Collection;

import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.Metric;

/**
 * @author jdelafuente
 *
 */
public class IAgreeContext extends Context {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (getInitiator() != null) {
			IAgreeActor a = new IAgreeActor(getInitiator());
			sb.append("\t").append(a).append(";").append("\n");
		}

		if (getResponder() != null){
			IAgreeActor a = new IAgreeActor(getResponder());
			sb.append("\t").append(a).append(";").append("\n");
		}

		sb.append("\t" + "Metrics:" + "\n");
		Collection<Metric> metrics = this.getMetrics().values();
		for (Metric metric : metrics) {
			sb.append("\t\t").append(metric).append("\n");
		}

		return sb.toString();

	}
}
