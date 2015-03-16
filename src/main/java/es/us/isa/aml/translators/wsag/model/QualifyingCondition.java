/**
 * 
 */
package es.us.isa.aml.translators.wsag.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * The optional Qualifying Condition in a guarantee term, when present, is expressed as
 * an assertion over service attributes and/or external factors such as date, time, and
 * the service request rate by the client.
 * 
 * @author jdelafuente
 *
 */
public class QualifyingCondition extends es.us.isa.aml.model.QualifyingCondition {

	
	public QualifyingCondition(Expression condition) {
		super(condition);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}

}
