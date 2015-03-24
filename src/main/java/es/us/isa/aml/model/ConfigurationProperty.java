/**
 *
 */
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class ConfigurationProperty extends Property {

    public ConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

    public ConfigurationProperty(String id, Metric metric,
            Expression expression, Scope scope, Feature feature) {
        super(id, metric, expression, scope, feature);
    }

}
