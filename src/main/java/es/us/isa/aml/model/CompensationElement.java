/**
 *
 */
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class CompensationElement {

    private Expression expression;
    private Expression condition;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }
}
