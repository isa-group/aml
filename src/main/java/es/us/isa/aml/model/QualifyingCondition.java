/**
 *
 */
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class QualifyingCondition {

    private Expression condition;

    public QualifyingCondition(Expression condition) {
        super();
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }
    
    @Override
    public QualifyingCondition clone() {
    	Expression e = Expression.parse(condition.toString());
    	QualifyingCondition qc = new QualifyingCondition(e);
    	return qc;
    }

}
