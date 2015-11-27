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
public class CSPObjectiveFunction {
	
	private Boolean minimize;
	private Expression expression;

	
	public CSPObjectiveFunction() {
		
	}
	
	
	/**
	 * @param minimize Indicates the type of the objective function
	 * @param expression The expression of the objective function
	 */
	public CSPObjectiveFunction(Boolean minimize, Expression expression) {
		super();
		this.minimize = minimize;
		this.expression = expression;
	}
	/**
	 * @return the minimize
	 */
	public Boolean getMinimize() {
		return minimize;
	}
	/**
	 * @param minimize the minimize to set
	 */
	public void setMinimize(Boolean minimize) {
		this.minimize = minimize;
	}
	/**
	 * @return the expression
	 */
	public Expression getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	protected CSPObjectiveFunction clone() {
		CSPObjectiveFunction objfunc= new CSPObjectiveFunction();
		objfunc.setMinimize(minimize);
		objfunc.setExpression(Expression.parse(expression.toString()));
		return objfunc;
	}
	
	

}
