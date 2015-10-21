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
public abstract class CompoundExpression extends Expression {

    protected Expression exp1;
    protected Expression exp2;
    protected Object operator;

    public List<Expression> getExpressions() {
        List<Expression> res = new ArrayList<>();
        if (exp1 != null) {
            res.add(this.exp1);
        }
        if (exp2 != null) {
            res.add(this.exp2);
        }
        return res;
    }

    public Expression getExpression1() {
        return this.exp1;
    }
    
    public void setExpression1(Expression exp1) {
		this.exp1 = exp1;
	}

    public Expression getExpression2() {
        return this.exp2;
    }

	public void setExpression2(Expression exp2) {
		this.exp2 = exp2;
	}

	public Object getOperator() {
        return this.operator;
    }
}
