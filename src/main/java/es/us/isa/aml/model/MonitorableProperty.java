/**
 *
 */
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class MonitorableProperty extends Property {

    public MonitorableProperty(String id, Metric metric) {
        super(id, metric);
    }

	public MonitorableProperty(String id, Metric metric, Expression expression,
			Scope scope, Feature feature) {
		super(id, metric, expression, scope, feature);
	}

}
