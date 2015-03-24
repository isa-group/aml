/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.util.Util;
import java.util.Collection;

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
            sb.append("\t").append(this.getResponder()).append(";" + "\n");
        }

        if (getProvider() != null) {
            StringBuilder append = sb.append("\t").append("Provider " + "\"").append(Util.withoutDoubleQuotes(getProvider())).append("\"")
                    .append(";" + "\n");
        }

        if (getConsumer() != null) {
            sb.append("\t").append("Consumer " + "\"").append(Util.withoutDoubleQuotes(getConsumer())).append("\"")
                    .append(";" + "\n");
        }

        sb.append("\t" + "Metrics:" + "\n");
        Collection<Metric> metrics = this.getMetrics().values();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric).append("\n");
        }

        return sb.toString();

    }
}
