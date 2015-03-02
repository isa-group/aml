package isa.us.es.aml.model;


/**
 * @author jdelafuente
 *
 */
public class Metric extends AgreementElement {

	String type;
	Domain domain;

	public Metric(String id) {
		super(id);
		this.type = "int";
		this.domain = new Range(0, 100);
	}

	public Metric(String id, String type, Domain domain) {
		super(id);
		this.type = type;
		this.domain = domain;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
}
