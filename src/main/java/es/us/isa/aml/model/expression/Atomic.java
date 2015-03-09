package es.us.isa.aml.model.expression;

import es.us.isa.aml.model.AgreementElement;

/**
 * @author jdelafuente
 *
 */
public class Atomic extends Expression {

    public Atomic(Object n) {
        this.value = n;
    }

    @Override
    public Object calculate() {
        return this.value;
    }

    @Override
    public String toString() {
        if (AgreementElement.class.isAssignableFrom(this.value.getClass())) {
            return ((AgreementElement) this.value).getId();
        } else {
            return this.value.toString();
        }
    }
    
    public void setValue(Object o) {
		this.value = o;
	}
    
    public void setDoubleValue(Double n) {
		this.value = n;
	}
    
    public void setIntegerValue(Integer n) {
		this.value = n;
	}
    
    public void setBooleanValue(Boolean b) {
		this.value = b;
	}
}
