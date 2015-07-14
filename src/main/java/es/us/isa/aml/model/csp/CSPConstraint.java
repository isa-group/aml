package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.QualifyingCondition;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;

/**
 * @author jdelafuente
 *
 */
public class CSPConstraint implements Comparable<CSPConstraint> {

	protected String id;
	protected Expression expr;

	public CSPConstraint(String id, SLO slo) {
		this.id = id;
		this.expr = slo.getExpression();
	}

	public CSPConstraint(String id, SLO slo, QualifyingCondition qc) {
		this.id = id;
		if (qc != null)
			this.expr = new LogicalExpression(qc.getCondition(),
					slo.getExpression(), LogicalOperator.IMPLIES);
		else
			this.expr = slo.getExpression();
	}

	public CSPConstraint(String id, Expression expr) {
		this.id = id;
		this.expr = expr;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CSPConstraint) {
			CSPConstraint cons = (CSPConstraint) obj;
			return this.expr.equals(cons.getExpr());
		}
		return false;
	}

	@Override
	public CSPConstraint clone() {
		CSPConstraint cons = new CSPConstraint(getId(), getExpr());
		return cons;
	}

	@Override
	public int compareTo(CSPConstraint o) {
		return getId().compareTo(o.getId());
	}

	@Override
	public int hashCode() {
		return this.getExpr().hashCode() * 31;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		String exp = getExpr().toString();
		exp = exp.replaceAll("\\bAND\\b", "&&");
		exp = exp.replaceAll("\\bOR\\b", "||");
		exp = exp.replaceAll("\\bNOT\\b ", "!");
		exp = exp.replaceAll("\\bIMPLIES\\b", "=>");

		sb.append(exp);

		return this.getId() + ": " + sb.toString() + ";";
	}

}
