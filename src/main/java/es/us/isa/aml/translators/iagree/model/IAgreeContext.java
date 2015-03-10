/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import java.util.List;

import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.Metric;

/**
 * @author jdelafuente
 *
 */
public class IAgreeContext extends Context {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!getInitiator().isEmpty()) {
            sb.append("\t").append("Initiator: " + "\"" + this.getInitiator() + "\";" + "\n");
        }
        if (getResponder() != null) {
            sb.append("\t").append(this.getResponder()).append(";" + "\n");
        }

        sb.append("\t" + "Metrics:" + "\n");
        List<Metric> metrics = this.getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric).append("\n");
        }

        return sb.toString();

    }

}
