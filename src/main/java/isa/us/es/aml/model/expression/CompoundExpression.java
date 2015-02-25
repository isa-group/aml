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
        res.add(exp1);
        res.add(exp2);
        return res;
    }

    public Expression getExpresion1() {
        return exp1;
    }

    public Expression getExpresion2() {
        return exp2;
    }

    public Object getOperator() {
        return operator;
    }
}
