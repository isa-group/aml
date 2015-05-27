package es.us.isa.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class LogicalExpression extends CompoundExpression {

	public LogicalExpression(Expression e1, LogicalOperator operator) {
		this.exp1 = e1;
		this.operator = operator;
	}

	public LogicalExpression(Expression e1, Expression e2,
			LogicalOperator operator) {
		this.exp1 = e1;
		this.exp2 = e2;
		this.operator = operator;
	}

	@Override
	public Boolean calculate() {
		Boolean res = null;
		switch ((LogicalOperator) this.operator) {
		case AND:
			res = Boolean.valueOf(this.exp1.calculate().toString())
					&& Boolean.valueOf(this.exp2.calculate().toString());
			break;
		case OR:
			res = Boolean.valueOf(this.exp1.calculate().toString())
					|| Boolean.valueOf(this.exp2.calculate().toString());
			break;
		case NOT:
			res = !Boolean.valueOf(this.exp1.calculate().toString());
			break;
		case IMPLIES:
			res = !Boolean.valueOf(this.exp1.calculate().toString())
					|| Boolean.valueOf(this.exp2.calculate().toString());
			break;
		}

		return res;
	}

	@Override
	public String toString() {
		String op = "";
		switch ((LogicalOperator) this.operator) {
		case AND:
			op = "AND";
			break;
		case OR:
			op = "OR";
			break;
		case NOT:
			op = "NOT";
			break;
		case IMPLIES:
			op = "IMPLIES";
			break;
		}

		if (operator == LogicalOperator.NOT) {
			return "NOT " + this.exp1;
		} else {
			return this.exp1 + " " + op + " " + this.exp2;
		}
	}
}
