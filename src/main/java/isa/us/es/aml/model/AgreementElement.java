package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class AgreementElement {

    protected String id;

    public AgreementElement(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AgreementElement) {
            AgreementElement elem = (AgreementElement) obj;
            return id.equals(elem.id);
        }
        return false;
    }
}
