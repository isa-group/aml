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
	
	public Var(Object n, Expression e) {
		id = n;
		new AssignmentExpression(this, e);
	}

	@Override
	public Object calculate() {
		return value;
	}

	@Override
	public String toString() {
		if (id instanceof AgreementElement) {
			return ((AgreementElement) id).getId().toString();
		} else {
			return id.toString();
		}
	}

	public Double getDoubleValue() {
		if (value instanceof Number)
			return ((Number) value).doubleValue();
		else if(value == null)
			throw new NullPointerException("Variable " + id + " has not been initialized");
		else
			throw new NumberFormatException();
	}

	public Integer getIntegerValue() {
		if (value instanceof Number)
			return ((Number) value).intValue();
		else if(value == null)
			throw new NullPointerException("Variable " + id + " has not been initialized");
		else
			throw new NumberFormatException();
	}

	public Boolean getBooleanValue() {
		try {
			if (value instanceof Boolean)
				return ((Boolean) value).booleanValue();
			else if(value == null)
				throw new NullPointerException("Variable " + id + " has not been initialized");
			else
				return null;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
	}
}
