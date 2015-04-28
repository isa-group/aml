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
	
	public MonitorableProperty(String id) {
		super(id);
	}

    public MonitorableProperty(String id, Metric metric) {
        super(id, metric);
    }

    public MonitorableProperty(String id, Metric metric, Expression expression,
            Scope scope, Feature feature) {
        super(id, metric, expression, scope, feature);
    }

	@Override
    public MonitorableProperty clone() {
    	MonitorableProperty mp = new MonitorableProperty(getId(), getMetric().clone());
    	mp.setExpression(getExpression());
    	if(getFeature() != null)
    		mp.setFeature(getFeature().clone());
    	mp.setScope(getScope());
    	return mp;
    }

}
