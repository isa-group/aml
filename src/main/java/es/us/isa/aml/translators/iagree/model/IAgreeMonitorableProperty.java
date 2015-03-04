/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.expression.Expression;

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
