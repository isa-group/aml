/**
 * 
 */
package es.us.isa.aml.translators.wsag.model;

import java.net.URI;

/**
 * Guarantees contain logical expressions that refer to aspects of the
 * service(s) subject to the guarantee. For instance, metrics for availability
 * and response time must refer to named concepts (availability, response time)
 * and must be declared as named variables that can be used in assertions. The
 * semantics of those variables must be defined to interpret the condition
 * expression.
 * 
 * @author jdelafuente
 *
 */
public class Variable {

	/**
	 * This element, of type String, is the name of the variable and allows the
	 * concept represented by this variable to be used in assertions. The name
	 * of each variable MUST be unique within the variable set.
	 */
	private String name;

	/**
	 * This element, of type URI, is an identification of a domain-specific
	 * metric. This element is optional and intended for cases where the
	 * structural reference of the variable does not sufficiently explain the
	 * semantics and typing of a variable.
	 */
	private URI metric;

	/**
	 * The value of this element is a structural reference to a field of
	 * arbitrary granularity in the service terms — including fields within the
	 * domain-specific service descriptions.
	 */
	private String location;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the metric
	 */
	public URI getMetric() {
		return metric;
	}

	/**
	 * @param metric
	 *            the metric to set
	 */
	public void setMetric(URI metric) {
		this.metric = metric;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "<wsag:Variable wsag:Name=\"" + getName() + "\" wsag:Metric=\""
				+ getMetric().toString() + "\">" + "\n" + "\t\t\t\t\t\t" + "<wsag:Location>" +
				getLocation() + "</wsag:Location>" + "\n" + "\t\t\t\t\t" + "</wsag:Variable>";
	}

}
