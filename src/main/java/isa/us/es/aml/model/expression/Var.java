package isa.us.es.aml.model.expression;

import isa.us.es.aml.model.AgreementElement;

/**
 * @author jdelafuente
 *
 */
public class Var extends Expression {

    private Object id;

    public Var(Object n) {
        this.id = n;
    }

    public Var(Object n, Expression e) {
        this.id = n;
        new AssignmentExpression(this, e);
    }

    @Override
    public Object calculate() {
        return this.value;
    }

    @Override
    public String toString() {
        if (this.id instanceof AgreementElement) {
            return ((AgreementElement) this.id).getId();
        } else {
            return this.id.toString();
        }
    }

    public Double getDoubleValue() {
        if (this.value instanceof Number) {
            return ((Number) this.value).doubleValue();
        } else if (this.value == null) {
            throw new NullPointerException("Variable " + this.id + " has not been initialized");
        } else {
            throw new NumberFormatException();
        }
    }

    public Integer getIntegerValue() {
        if (this.value instanceof Number) {
            return ((Number) this.value).intValue();
        } else if (this.value == null) {
            throw new NullPointerException("Variable " + this.id + " has not been initialized");
        } else {
            throw new NumberFormatException();
        }
    }

    public Boolean getBooleanValue() {
        try {
            if (this.value instanceof Boolean) {
                return (Boolean) this.value;
            } else if (this.value == null) {
                throw new NullPointerException("Variable " + this.id + " has not been initialized");
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
