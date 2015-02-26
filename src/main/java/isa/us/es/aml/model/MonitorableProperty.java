/**
 * 
 */
package isa.us.es.aml.model;

import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class MonitorableProperty extends Property {

	public MonitorableProperty(Property property) {
		super(property.getId(), property.getMetric(), property.getExpression(),
				property.getScope());
	}

	public MonitorableProperty(String id, Metric metric) {
		super(id, metric);
	}

	public MonitorableProperty(String id, Metric metric, Scope scope) {
		super(id, metric, scope);
	}

	public MonitorableProperty(String id, Metric metric, Expression expr) {
		super(id, metric, expr);
	}

	public MonitorableProperty(String id, Metric metric, Expression expr,
			Scope scope) {
		super(id, metric, expr, scope);
	}
}
