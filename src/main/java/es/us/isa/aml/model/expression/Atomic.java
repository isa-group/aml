package es.us.isa.aml.model.expression;

import es.us.isa.aml.model.AgreementElement;

/**
 * @author jdelafuente
 *
 */
public class Atomic extends Expression {

    private final Object value;

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
}
