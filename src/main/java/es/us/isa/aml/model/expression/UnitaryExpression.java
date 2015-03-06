package es.us.isa.aml.model.expression;


/**
 * @author jdelafuente
 *
 */
public abstract class UnitaryExpression extends Expression {

    protected Expression exp;

    public Expression getExpression() {
        return exp;
    }
}
