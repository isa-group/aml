package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class IAgreeSLO extends SLO {

    public IAgreeSLO(Expression expression) {
        super(expression);
    }

    @Override
    public String toString() {
        return this.getExpression().toString();
    }
}
