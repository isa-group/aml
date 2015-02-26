package isa.us.es.aml.model.expression;

import isa.us.es.aml.model.AgreementElement;


/**
 * @author jdelafuente
 *
 */
public class Atomic extends Expression {
	
	private Object value;
	
	public Atomic(Object n) {
		value = n;
	}

	@Override
	public Object calculate() {
		return value;
	}
	
	@Override
	public String toString() {
		if(AgreementElement.class.isAssignableFrom(value.getClass()))
			return ((AgreementElement) value).getId().toString();
		else
			return value.toString();
	}
}
