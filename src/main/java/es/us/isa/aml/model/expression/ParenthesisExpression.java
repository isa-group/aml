package es.us.isa.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class ParenthesisExpression extends UnitaryExpression {

    public ParenthesisExpression(Expression e) {
        this.exp = e;
    }

    @Override
    public Object calculate() {
        return exp.calculate();
    }

    @Override
    public String toString() {
        return "(" + this.exp + ")";
    }

}
