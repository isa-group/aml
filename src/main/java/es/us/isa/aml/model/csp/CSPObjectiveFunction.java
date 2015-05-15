/**
 * 
 */
package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class CSPObjectiveFunction {
	
	private Boolean minimize;
	private Expression expression;

	
	public CSPObjectiveFunction() {
		
	}
	
	
	/**
	 * @param minimize
	 * @param expression
	 */
	public CSPObjectiveFunction(Boolean minimize, Expression expression) {
		super();
		this.minimize = minimize;
		this.expression = expression;
	}
	/**
	 * @return the minimize
	 */
	public Boolean getMinimize() {
		return minimize;
	}
	/**
	 * @param minimize the minimize to set
	 */
	public void setMinimize(Boolean minimize) {
		this.minimize = minimize;
	}
	/**
	 * @return the expression
	 */
	public Expression getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	protected CSPObjectiveFunction clone() {
		CSPObjectiveFunction objfunc= new CSPObjectiveFunction();
		objfunc.setMinimize(minimize);
		objfunc.setExpression(Expression.parse(expression.toString()));
		return objfunc;
	}
	
	

}
