/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Metric;

/**
 * @author jdelafuente
 *
 */
public class IAgreeConfigurationProperty extends ConfigurationProperty {

    public IAgreeConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

    @Override
    public String toString() {
        if (this.getExpression() != null) {
            return this.getId() + ": " + this.getMetric().getId() + " = "
                    + this.getExpression() + ";";
        } else {
            return this.getId() + ": " + this.getMetric().getId();
        }
    }
}
