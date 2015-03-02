package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class AgreementElement {

    protected String id;

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
    
    @Override
   	public boolean equals(Object obj) {
   		if (obj instanceof AgreementElement) {
   			AgreementElement elem = (AgreementElement) obj;
   			return this.id.equals(elem.id);
   		}
   		return false;
   	}
}
