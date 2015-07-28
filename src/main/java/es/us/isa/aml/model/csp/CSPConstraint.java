package es.us.isa.aml.model.csp;

import java.util.logging.Level;
import java.util.logging.Logger;

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

	private static final Logger LOGGER = Logger.getLogger(CSPConstraint.class
			.getName());

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
			return this.id.equals(cons.getId());
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
		return this.getId().hashCode() * 31;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getId()).append(": ");
		try {
			String exp = getExpr().toString();
			exp = exp.replaceAll("\\bAND\\b", "&&")
					.replaceAll("\\bOR\\b", "||").replaceAll("\\bNOT\\b ", "!")
					.replaceAll("\\bIMPLIES\\b", "=>");
			sb.append(exp).append(";");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return sb.toString();
	}

}
