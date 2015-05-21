package es.us.isa.aml.model.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public abstract class CompoundExpression extends Expression {

    protected Expression exp1;
    protected Expression exp2;
    protected Object operator;

    public List<Expression> getExpressions() {
        List<Expression> res = new ArrayList<>();
        if (exp1 != null) {
            res.add(this.exp1);
        }
        if (exp2 != null) {
            res.add(this.exp2);
        }
        return res;
    }

    public Expression getExpression1() {
        return this.exp1;
    }
    
    public void setExpression1(Expression exp1) {
		this.exp1 = exp1;
	}

    public Expression getExpression2() {
        return this.exp2;
    }

	public void setExpression2(Expression exp2) {
		this.exp2 = exp2;
	}

	public Object getOperator() {
        return this.operator;
    }
}
