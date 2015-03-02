/**
 *
 */
package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.ConfigurationProperty;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Scope;
import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class IAgreeConfigurationProperty extends ConfigurationProperty {

    public IAgreeConfigurationProperty(Property property) {
        super(property.getId(), property.getMetric(), property.getExpression(),
                property.getScope());
    }

    public IAgreeConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

    public IAgreeConfigurationProperty(String id, Metric metric, Scope scope) {
        super(id, metric, scope);
    }

    public IAgreeConfigurationProperty(String id, Metric metric, Expression expr) {
        super(id, metric, expr);
    }

    public IAgreeConfigurationProperty(String id, Metric metric, Expression expr,
            Scope scope) {
        super(id, metric, expr, scope);
    }
    
    @Override
    public String toString() {
        if (getExpression() != null) {
            return getId() + ": " + getMetric().getId() + " = " + getExpression() + ";";
        } else {
            return getId() + ": " + getMetric().getId();
        }
    }
}
