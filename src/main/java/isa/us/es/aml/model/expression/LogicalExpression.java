package isa.us.es.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class LogicalExpression extends CompoundExpression {

    public LogicalExpression(Expression e1, Expression e2, LogicalOperator operator) {
        exp1 = e1;
        exp2 = e2;
        this.operator = operator;
    }

    @Override
    public Boolean calculate() {
        Boolean res = null;
        switch ((LogicalOperator) operator) {
            case gt:
                res = Double.valueOf(exp1.calculate().toString()) > Double
                        .valueOf(exp2.calculate().toString());
                break;
            case lt:
                res = Double.valueOf(exp1.calculate().toString()) < Double
                        .valueOf(exp2.calculate().toString());
                break;
            case gte:
                res = Double.valueOf(exp1.calculate().toString()) >= Double
                        .valueOf(exp2.calculate().toString());
                break;
            case lte:
                res = Double.valueOf(exp1.calculate().toString()) <= Double
                        .valueOf(exp2.calculate().toString());
                break;
            case eq:
                res = Double.valueOf(exp1.calculate().toString()).equals(
                        Double.valueOf(exp2.calculate().toString()));
                break;
        }

        return res;
    }

    @Override
    public String toString() {
        String op = "";
        switch ((LogicalOperator) operator) {
            case eq:
                op = "==";
                break;
            case gt:
                op = ">";
                break;
            case gte:
                op = ">=";
                break;
            case lt:
                op = "<";
                break;
            case lte:
                op = "<=";
                break;
        }
        return exp1.toString() + " " + op + " " + exp2.toString();
    }
}
