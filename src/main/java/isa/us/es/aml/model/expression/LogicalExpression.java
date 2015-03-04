package isa.us.es.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class LogicalExpression extends CompoundExpression {

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
            case and:
                res = Boolean.valueOf(this.exp1.calculate().toString())
                        && Boolean.valueOf(this.exp2.calculate().toString());
                break;
            case or:
                res = Boolean.valueOf(this.exp1.calculate().toString())
                        || Boolean.valueOf(this.exp2.calculate().toString());
                break;
            case not:
                res = !Boolean.valueOf(this.exp1.calculate().toString());
                break;
        }

        return res;
    }

    @Override
    public String toString() {
        String op = "";
        switch ((LogicalOperator) this.operator) {
            case and:
                op = "AND";
                break;
            case or:
                op = "OR";
                break;
            case not:
                op = "NOT";
                break;
        }

        if (op.equals("NOT")) {
            return "NOT " + this.exp1;
        } else {
            return this.exp1 + " " + op + " " + this.exp2;
        }
    }
}
