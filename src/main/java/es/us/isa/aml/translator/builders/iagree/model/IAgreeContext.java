/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import java.util.Collection;

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

		if (getInitiator() != null) {
			IAgreeActor a = new IAgreeActor(getInitiator());
			sb.append("\t").append(a).append(";").append("\n");
		}

		if (getResponder() != null){
			IAgreeActor a = new IAgreeActor(getResponder());
			sb.append("\t").append(a).append(";").append("\n");
		}

		sb.append("\t" + "Metrics:" + "\n");
		Collection<Metric> metrics = this.getMetrics().values();
		for (Metric metric : metrics) {
			sb.append("\t\t").append(metric).append("\n");
		}

		return sb.toString();

	}
}
