/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import java.util.Collection;

import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.ServiceRole;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class IAgreeContext extends Context {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (getInitiator() != null) {
			sb.append("\t").append(
					"Initiator: " + "\"" + this.getInitiator() + "\";" + "\n");
		}

		if (getResponder() != null) {
			sb.append("\t").append(this.getResponder()).append(";" + "\n");
		}
		
		if (getProvider() != null)
			sb.append("\t").append("Provider " + "\"" + Util.withoutDoubleQuotes(getProvider()) + "\"")
					.append(";" + "\n");
		
		if (getConsumer() != null)
			sb.append("\t").append("Consumer " + "\"" + Util.withoutDoubleQuotes(getConsumer()) + "\"")
					.append(";" + "\n");		

		sb.append("\t" + "Metrics:" + "\n");
		Collection<Metric> metrics = this.getMetrics().values();
		for (Metric metric : metrics) {
			sb.append("\t\t").append(metric).append("\n");
		}

		return sb.toString();

	}
}
