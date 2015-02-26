package isa.us.es.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class ArithmeticExpression extends CompoundExpression {

	public ArithmeticExpression(Expression e1, Expression e2,
			ArithmeticOperator operator) {
		exp1 = e1;
		exp2 = e2;
		this.operator = operator;
	}

	@Override
	public Number calculate() {
		Number res = 0;

		try {
			switch ((ArithmeticOperator) operator) {
			case add:
				res = Double.valueOf(exp1.calculate().toString())
						+ Double.valueOf(exp2.calculate().toString());

				break;
			case subtract:
				res = Double.valueOf(exp1.calculate().toString())
						- Double.valueOf(exp2.calculate().toString());

				break;
			case multiply:
				res = Double.valueOf(exp1.calculate().toString())
						* Double.valueOf(exp2.calculate().toString());

				break;
			case divide:
				res = Double.valueOf(exp1.calculate().toString())
						/ Double.valueOf(exp2.calculate().toString());
				break;
			}
		} catch (Exception e) {
			System.out.println("Error calculating the expression");
		}		

		return res;
	}

	@Override
	public String toString() {
		String op = "";
		switch ((ArithmeticOperator) operator) {
		case add:
			op = "+";
			break;
		case subtract:
			op = "-";
			break;
		case multiply:
			op = "*";
			break;
		case divide:
			op = "/";
			break;
		}
		return exp1.toString() + " " + op + " " + exp2.toString();
	}

}
