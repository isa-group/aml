package es.us.isa.aml.model;

import java.util.Objects;

/**
 * This class represents any element that can appear during the agreement lifecycle. 
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
	public AgreementElement clone() {
    	return new AgreementElement(id);
    }
}
