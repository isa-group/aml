package isa.us.es.aml.model;


/**
 * @author jdelafuente
 *
 */
public class Metric extends AgreementElement {
	
	String type;
	Range domain;
	
	public Metric(String id) {
		super(id);
		this.type = "int";
		this.domain = new Range(0, 100);
	}
	
	public Metric(String id, String type, Range domain) {
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

	public Range getRange() {
		return domain;
	}

	public void setRange(Range domain) {
		this.domain = domain;
	}
	
	@Override
	public String toString() {
		return getId() + ": " + getType() + getRange();
	}

}
