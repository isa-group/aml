package isa.us.es.aml.model.expression;

/**
 * @author jdelafuente
 *
 */
public class AssignmentExpression extends CompoundExpression {

    public AssignmentExpression(Var v, Expression e2) {
        exp1 = v;
        exp2 = e2;
        this.operator = "assig";
    }

    @Override
    public Object calculate() {
        exp1.setValue(exp2.calculate());
        return exp1.getValue();
    }
    
    public Var getVar() {
    	return (Var) exp1;
    }

    @Override
    public String toString() {
        return exp1.toString() + " = " + exp2.toString();
    }

}
