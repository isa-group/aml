/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;

/**
 * @author jdelafuente
 *
 */
public class IAgreeConfigurationProperty extends ConfigurationProperty {

    public IAgreeConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

	public IAgreeConfigurationProperty(Property cp) {
		super(cp.getId(), cp.getMetric(), cp.getExpression(), cp.getScope(), cp.getFeature());
	}

	@Override
    public String toString() {
        if (this.getExpression() != null) {
            return this.getId() + ": " + this.getMetric().getId() + " = "
                    + this.getExpression() + ";";
        } else {
            return this.getId() + ": " + this.getMetric().getId() + ";";
        }
    }
}
