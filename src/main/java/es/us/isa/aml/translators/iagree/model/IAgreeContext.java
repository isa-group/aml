/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.Metric;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class IAgreeContext extends Context {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (getInitiator() != null) {
            sb.append("\t").append("Initiator: " + "\"").append(this.getInitiator()).append("\";" + "\n");
        }

        if (getResponder() != null) {
            if (getResponder().getRoleType() == Actor.Provider) {
                sb.append("\t").append(this.getResponder()).append(";" + "\n");
                sb.append("\t").append("Consumer ").append(getConsumer())
                        .append(";" + "\n");
            } else {
                sb.append("\t").append("Provider ").append(getProvider())
                        .append(";" + "\n");
                sb.append("\t").append(this.getResponder()).append(";" + "\n");
            }
        }

        sb.append("\t" + "Metrics:" + "\n");
        List<Metric> metrics = this.getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric).append("\n");
        }

        return sb.toString();

    }

}
