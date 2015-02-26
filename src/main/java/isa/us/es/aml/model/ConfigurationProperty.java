/**
 *
 */
package isa.us.es.aml.model;

import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class ConfigurationProperty extends Property {

    public ConfigurationProperty(Property property) {
        super(property.getId(), property.getMetric(), property.getExpression(),
                property.getScope());
    }

    public ConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

    public ConfigurationProperty(String id, Metric metric, Scope scope) {
        super(id, metric, scope);
    }

    public ConfigurationProperty(String id, Metric metric, Expression expr) {
        super(id, metric, expr);
    }

    public ConfigurationProperty(String id, Metric metric, Expression expr,
            Scope scope) {
        super(id, metric, expr, scope);
    }
}
