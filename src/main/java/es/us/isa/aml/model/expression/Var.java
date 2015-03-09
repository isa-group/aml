package es.us.isa.aml.model.expression;

import es.us.isa.aml.model.AgreementElement;

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
		value = e.calculate();
	}

	@Override
	public Object calculate() {
		if(value == null)
			throw new NullPointerException("Variable " + this.id
					+ " has not been initialized");
		else
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

	
	public Object getValue() {
		if (this.value == null) {
			throw new NullPointerException("Variable " + this.id
					+ " has not been initialized");
		} else {
			return value;
		}
	}

	
	public Double getDoubleValue() {
		if (value instanceof String)
			return Double.valueOf((String) value);
		else if (value instanceof Number)
			return ((Number) this.value).doubleValue();
		else
			return null;
	}

	
	public Integer getIntegerValue() {
		if (value instanceof String)
			return Integer.valueOf((String) value);
		else if (value instanceof Number)
			return ((Number) this.value).intValue();
		else
			return null;
	}

	
	public Boolean getBooleanValue() {
		if (value instanceof String)
			return Boolean.valueOf((String) value);
		else if (value instanceof Boolean)
			return ((Boolean) this.value);
		else
			return null;
	}

	public void setValue(Object o) {
		this.value = o;
	}
}
