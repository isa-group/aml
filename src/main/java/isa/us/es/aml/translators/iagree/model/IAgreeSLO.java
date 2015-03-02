package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.SLO;
import isa.us.es.aml.model.expression.Expression;

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
        return getExpression().toString();
    }
}
