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

/**
 * @author jdelafuente
 *
 */
public class RelationalExpression extends CompoundExpression {

    public RelationalExpression(Expression e1, Expression e2, RelationalOperator operator) {
        this.exp1 = e1;
        this.exp2 = e2;
        this.operator = operator;
    }

    @Override
    public Boolean calculate() {
        Boolean res = null;
        switch ((RelationalOperator) this.operator) {
            case GT:
                res = Double.valueOf(this.exp1.calculate().toString()) > Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case LT:
                res = Double.valueOf(this.exp1.calculate().toString()) < Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case GTE:
                res = Double.valueOf(this.exp1.calculate().toString()) >= Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case LTE:
                res = Double.valueOf(this.exp1.calculate().toString()) <= Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case EQ:
                res = Double.valueOf(this.exp1.calculate().toString()).equals(
                        Double.valueOf(this.exp2.calculate().toString()));
                break;
            case NEQ:
                res = !(Double.valueOf(this.exp1.calculate().toString()).equals(
                        Double.valueOf(this.exp2.calculate().toString())));
                break;
        }

        return res;
    }

    @Override
    public String toString() {
        String op = "";
        switch ((RelationalOperator) this.operator) {
            case GT:
                op = ">";
                break;
            case GTE:
                op = ">=";
                break;
            case LT:
                op = "<";
                break;
            case LTE:
                op = "<=";
                break;
            case EQ:
                op = "==";
                break;
            case NEQ:
                op = "!=";
                break;
        }

        return this.exp1 + " " + op + " " + this.exp2;
    }
}
