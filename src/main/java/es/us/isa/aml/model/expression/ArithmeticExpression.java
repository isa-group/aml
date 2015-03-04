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
                case add:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            + Double.valueOf(this.exp2.calculate().toString());

                    break;
                case subtract:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            - Double.valueOf(this.exp2.calculate().toString());

                    break;
                case multiply:
                    res = Double.valueOf(this.exp1.calculate().toString())
                            * Double.valueOf(this.exp2.calculate().toString());

                    break;
                case divide:
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
            case add:
                op = "+";
                break;
            case subtract:
                op = "-";
                break;
            case multiply:
                op = "*";
                break;
            case divide:
                op = "/";
                break;
        }

        return this.exp1 + " " + op + " " + this.exp2;
    }

}
