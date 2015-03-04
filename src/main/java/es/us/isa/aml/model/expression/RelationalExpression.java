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
            case gt:
                res = Double.valueOf(this.exp1.calculate().toString()) > Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case lt:
                res = Double.valueOf(this.exp1.calculate().toString()) < Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case gte:
                res = Double.valueOf(this.exp1.calculate().toString()) >= Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case lte:
                res = Double.valueOf(this.exp1.calculate().toString()) <= Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case eq:
                res = Double.valueOf(this.exp1.calculate().toString()).equals(
                        Double.valueOf(this.exp2.calculate().toString()));
                break;
        }

        return res;
    }

    @Override
    public String toString() {
        String op = "";
        switch ((RelationalOperator) this.operator) {
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

        return this.exp1 + " " + op + " " + this.exp2;
    }
}
