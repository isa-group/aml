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
package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class CSPVar {

	protected String id;
	protected String type;
	protected CSPRange range;
	protected Expression value;
	protected Boolean dvar;

	public CSPVar(String id, String type, Boolean dvar) {
		this.id = id;
		this.dvar = dvar;
		this.setType(type);
	}

	public CSPVar(String id, String type, CSPRange range, Boolean dvar) {
		this.id = id;
		this.range = range;
		this.dvar = dvar;
		this.setType(type);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		if (CSPUtil.DATATYPES.containsKey(type))
			this.type = CSPUtil.DATATYPES.get(type);
		else
			this.type = type;
	}

	public CSPRange getRange() {
		return this.range;
	}

	public void setRange(CSPRange range) {
		this.range = range;
	}

	public Expression getExpression() {
		return this.value;
	}

	public void setExpression(Expression value) {
		this.value = value;
	}

	public Boolean getDvar() {
		return this.dvar;
	}

	public void setDvar(Boolean dvar) {
		this.dvar = dvar;
	}

	@Override
	public CSPVar clone() {
		CSPVar var = null;
		var = new CSPVar(getId(), getType(), getDvar());
		if (getRange() != null)
			var.setRange(getRange().clone());

		if (var != null && getExpression() != null)
			var.setExpression(Expression.parse(getExpression().toString()));
		return var;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CSPVar) {
			CSPVar elem = (CSPVar) obj;
			return id.equals(elem.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode() * 31;
	}

	@Override
	public String toString() {
		if (this.dvar) {
			if (getType().equals("boolean"))
				return "dvar " + this.getType() + " " + this.getId() + ";";
			else if (getType().equals("{string}"))
				return "dvar " + "int " + this.getId() + " in "
						+ this.getRange().getDomain() + ";";
			else {
				if (getRange().getId() != null)
					return "dvar " + this.getType() + " " + this.getId()
							+ " in " + getRange().getId() + ";";
				else
					return "dvar " + this.getType() + " " + this.getId()
							+ " in " + getRange().getDomain().toString() + ";";
			}
		} else {
			if (getType().equals("boolean"))
				return this.getType() + " " + this.getId() + ";";
			else if (getType().equals("{string}")) {
				StringBuilder sb = new StringBuilder();
				if (getExpression() != null) {
					sb.append(this.getType() + " " + this.getId() + " = "
							+ getExpression().toString());
				} else {
					sb.append(this.getType() + " " + this.getId());
				}
				sb.append(";");
				return sb.toString();

			} else {
				if (getRange() != null) {
					if (getExpression() != null)
						return this.getType() + " " + this.getId() + "["
								+ getRange().getId() + "]" + " = "
								+ this.getExpression() + ";";
					else {
						if (getRange().getId() != null)
							return this.getType() + " " + this.getId() + " in "
									+ getRange().getId() + ";";
						else
							return this.getType() + " " + this.getId() + " in "
									+ getRange().getDomain().toString() + ";";
					}
				} else {
					if (getExpression() != null)
						return this.getType() + " " + this.getId() + " = "
								+ this.getExpression();
					else
						return this.getType() + " " + this.getId() + ";";
				}
			}
		}
	}

}
