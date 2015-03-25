package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class SLO {

    private Expression expression;

    public SLO(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public SLO clone() {
    	Expression e = Expression.parse(expression.toString());
    	SLO slo = new SLO(e);
    	return slo;
    }
}
