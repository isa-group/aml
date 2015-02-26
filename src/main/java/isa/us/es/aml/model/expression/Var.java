package isa.us.es.aml.model.expression;

import isa.us.es.aml.model.AgreementElement;

/**
 * @author jdelafuente
 *
 */
public class Var extends Expression {

    private Object id;

    public Var(Object n) {
        id = n;
    }

    @Override
    public Object calculate() {
        return value;
    }

    @Override
    public String toString() {
        if (AgreementElement.class.isAssignableFrom(id.getClass())) {
            return ((AgreementElement) id).getId().toString();
        } else {
            return id.toString();
        }
    }
}
