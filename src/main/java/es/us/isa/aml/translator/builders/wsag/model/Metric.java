/**
 *
 */
package es.us.isa.aml.translator.builders.wsag.model;

import java.util.Arrays;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class Metric {

	private String id;
	private String type;
	private Domain domain;

	public Metric(String id) {
		this.id = id;
		type = "int";
	}

	public Metric(String id, String type, Domain domain) {
		this.id = id;
		this.type = type;
		this.domain = domain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (getDomain() instanceof Range) {
			Range r = (Range) getDomain();
			String range_str = "[" + r.getMin() + ".." + r.getMax() + "]";
			sb.append("<iag:Metric id=\"").append(getId())
					.append("\" " + "type=\"").append(getType())
					.append("\" " + "domain=\"").append(range_str)
					.append("\">" + "</iag:Metric>").append("\n");
		} else {
			Enumerated e = (Enumerated) getDomain();
			String enum_str = Arrays.asList(e.getValues()).toString().replace("[", "{")
					.replace("]", "}");
			sb.append("<iag:Metric id=\"").append(getId())
					.append("\" " + "type=\"").append(getType())
					.append("\" " + "domain=\"").append(enum_str)
					.append("\">" + "</iag:Metric>").append("\n");
		}
		return sb.toString();
	}
}
