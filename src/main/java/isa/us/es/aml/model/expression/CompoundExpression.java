package isa.us.es.aml.model.expression;

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
        res.add(this.exp1);
        res.add(this.exp2);
        return res;
    }

    public Expression getExpresion1() {
        return this.exp1;
    }

    public Expression getExpresion2() {
        return this.exp2;
    }

    public Object getOperator() {
        return this.operator;
    }
}
