package isa.us.es.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class AssignmentExpression extends CompoundExpression {

    public AssignmentExpression(Expression e1, Expression e2) {
        exp1 = e1;
        exp2 = e2;
        this.operator = "assig";
    }

    @Override
    public Object calculate() {
        exp1.setValue(exp2.calculate());
        return exp1.getValue();
    }

    @Override
    public String toString() {
        return exp1.toString() + " = " + exp2.toString();
    }

}
