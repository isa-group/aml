/**
 * 
 */
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class Constraint extends CreationConstraint {

	/**
	 * @param id
	 * @param slo
	 */
	public Constraint(String id, SLO slo) {
		super(id, slo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t\t" + "<wsag:Constraint>").append("\n");
		sb.append("\t\t\t" + "<Name>" + getId() + "</Name>").append("\n");

		if (getQc() != null)
			sb.append(
					"\t\t\t" + "<Content>" + getQc().getCondition()
							+ " IMPLIES " + getSlo().getExpression()
							+ "</Content>").append("\n");
		else
			sb.append(
					"\t\t\t" + "<Content>" + getSlo().getExpression()
							+ "</Content>").append("\n");

		sb.append("\t\t" + "</wsag:Constraint>").append("\n");
		return sb.toString();
	}

}
