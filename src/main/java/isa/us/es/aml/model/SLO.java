package isa.us.es.aml.model;

import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class SLO {

    private Expression expression;

    public SLO(Expression expression) {
        super();
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return getExpression().toString();
    }
}
