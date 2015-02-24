package isa.us.es.aml.model;


/**
 * @author jdelafuente
 *
 */
public class AgreementElement {

	private String id;

	public AgreementElement(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return getId();
	}
}
