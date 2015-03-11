/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;

/**
 * @author jdelafuente
 *
 */
public class IAgreeMonitorableProperty extends MonitorableProperty {

    public IAgreeMonitorableProperty(String id, Metric metric) {
        super(id, metric);
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
