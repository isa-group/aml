/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import java.util.Collection;

import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.ServiceRole;

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
			if (getResponder().getRoleType() == ServiceRole.Provider) {
				sb.append("\t").append(this.getResponder()).append(";" + "\n");
				if (getConsumer() != null)
					sb.append("\t").append("Consumer " + getConsumer())
							.append(";" + "\n");
			} else {
				if (getProvider() != null)
					sb.append("\t").append("Provider " + getProvider())
							.append(";" + "\n");
				sb.append("\t").append(this.getResponder()).append(";" + "\n");
			}
		}

		sb.append("\t" + "Metrics:" + "\n");
		Collection<Metric> metrics = this.getMetrics().values();
		for (Metric metric : metrics) {
			sb.append("\t\t").append(metric).append("\n");
		}

		return sb.toString();

	}

}
