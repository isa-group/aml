/**
 *
 */
package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.MonitorableProperty;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Scope;
import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class IAgreeMonitorableProperty extends MonitorableProperty {

    public IAgreeMonitorableProperty(Property property) {
        super(property.getId(), property.getMetric(), property.getExpression(),
                property.getScope());
    }

    public IAgreeMonitorableProperty(String id, Metric metric) {
        super(id, metric);
    }

    public IAgreeMonitorableProperty(String id, Metric metric, Scope scope) {
        super(id, metric, scope);
    }

    public IAgreeMonitorableProperty(String id, Metric metric, Expression expr) {
        super(id, metric, expr);
    }

    public IAgreeMonitorableProperty(String id, Metric metric, Expression expr,
            Scope scope) {
        super(id, metric, expr, scope);
    }

    @Override
    public String toString() {
        if (this.getExpression() != null) {
            return this.getId() + ": " + this.getMetric().getId() + " = " + this.getExpression() + ";";
        } else {
            return this.getId() + ": " + this.getMetric().getId();
        }
    }
}
