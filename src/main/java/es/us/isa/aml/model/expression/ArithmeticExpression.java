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
