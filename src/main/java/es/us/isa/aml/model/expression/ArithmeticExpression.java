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

/**
 * @author jdelafuente
 *
 */
public class ArithmeticExpression extends CompoundExpression {

    public ArithmeticExpression(Expression e1, Expression e2,
            ArithmeticOperator operator) {
        this.exp1 = e1;
        this.exp2 = e2;
        this.operator = operator;
    }

    @Override
    public Number calculate() {
        Number res = 0;

        try {
            switch ((ArithmeticOperator) this.operator) {
                case ADD:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            + Double.valueOf(this.exp2.calculate().toString());

                    break;
                case SUBTRACT:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            - Double.valueOf(this.exp2.calculate().toString());

                    break;
                case MULTIPLY:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            * Double.valueOf(this.exp2.calculate().toString());

                    break;
                case DIVIDE:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            / Double.valueOf(this.exp2.calculate().toString());
                    break;
            }
        } catch (NumberFormatException e) {
            throw new ArithmeticException("One of the arguments is not a valid number");
        }

        return res;
    }

    @Override
    public String toString() {
        String op = "";
        switch ((ArithmeticOperator) this.operator) {
            case ADD:
                op = "+";
                break;
            case SUBTRACT:
                op = "-";
                break;
            case MULTIPLY:
                op = "*";
                break;
            case DIVIDE:
                op = "/";
                break;
        }
        
        return this.exp1 + " " + op + " " + this.exp2;
    }

}
