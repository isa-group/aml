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
package es.us.isa.aml.model.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class ListExpression extends Expression {

	public ListExpression(Object n) {
		this.value = n;
	}

	@Override
	public Object calculate() {
		return this.value;
	}

	@Override
	public String toString() {
		if (value instanceof ArrayList) {
			return value.toString();
		} else {
			StringBuilder sb = new StringBuilder();
			Object[] values = (Object[]) value;
			List<Object> ls = new ArrayList<Object>();
			for (int i = 0; i < values.length; i++) {
				ls.add("\"" + values[i] + "\"");
			}
			sb.append(ls.toString().replace("[", "{").replace("]", "}"));
			return sb.toString();
		}
	}
}
