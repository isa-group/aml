package isa.us.es.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class AssignmentExpression extends CompoundExpression {

    public AssignmentExpression(Var v, Expression e2) {
        this.exp1 = v;
        this.exp2 = e2;
        operator = "assig";

        this.exp1.setValue(this.exp2.calculate());
    }

    @Override
    public Object calculate() {
        return this.exp1.getValue();
    }

    public Var getVar() {
        return (Var) this.exp1;
    }

    @Override
    public String toString() {
        return this.exp1 + " = " + this.exp2;
    }

}
