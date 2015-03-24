/**
 *
 */
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class CustomServiceLevel extends SLO {

    /**
     * @param expression
     */
    public CustomServiceLevel(Expression expression) {
        super(expression);
    }

    @Override
    public String toString() {
        return getExpression().toString();
    }

}
