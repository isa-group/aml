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
package es.us.isa.aml.model.expression;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jdelafuente
 *
 */
public class LogicalExpression extends CompoundExpression {

	private static final Logger LOGGER = Logger
			.getLogger(LogicalExpression.class.getName());

	public LogicalExpression(Expression e1, LogicalOperator operator) {
		this.exp1 = e1;
		this.operator = operator;
	}

	public LogicalExpression(Expression e1, Expression e2,
			LogicalOperator operator) {
		this.exp1 = e1;
		this.exp2 = e2;
		this.operator = operator;
	}

	@Override
	public Boolean calculate() {
		Boolean res = null;
		switch ((LogicalOperator) this.operator) {
		case AND:
			res = Boolean.valueOf(this.exp1.calculate().toString())
					&& Boolean.valueOf(this.exp2.calculate().toString());
			break;
		case OR:
			res = Boolean.valueOf(this.exp1.calculate().toString())
					|| Boolean.valueOf(this.exp2.calculate().toString());
			break;
		case NOT:
			res = !Boolean.valueOf(this.exp1.calculate().toString());
			break;
		case IMPLIES:
			res = !Boolean.valueOf(this.exp1.calculate().toString())
					|| Boolean.valueOf(this.exp2.calculate().toString());
			break;
		}

		return res;
	}

	@Override
	public String toString() {
		String op = "";
		switch ((LogicalOperator) this.operator) {
		case AND:
			op = "AND";
			break;
		case OR:
			op = "OR";
			break;
		case NOT:
			op = "NOT";
			break;
		case IMPLIES:
			op = "IMPLIES";
			break;
		}

		try {
			if (operator == LogicalOperator.NOT) {
				return "NOT " + this.exp1;
			} else {
				return this.exp1 + " " + op + " " + this.exp2;
			}
		} catch (StackOverflowError e) {
			LOGGER.log(Level.SEVERE, "Expression is too large");
		}
		return null;
	}
}
