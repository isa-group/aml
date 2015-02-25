package isa.us.es.aml.model.expression;

import java.util.HashSet;
import java.util.Set;



/**
 * @author jdelafuente
 *
 */
public abstract class Expression {

    public abstract Object calculate();

    public static Set<AtomicExpression> getAtomics(Expression exp) {
        Set<AtomicExpression> lst = new HashSet<>();
        if (exp.getClass() != AtomicExpression.class) {
            if (CompoundExpression.class.isAssignableFrom(exp.getClass())) {
                CompoundExpression ce = (CompoundExpression) exp;
                for (Expression ex : ce.getExpressions()) {
                    lst.addAll(getAtomics(ex));
                }
            }
        } else {
            lst.add((AtomicExpression) exp);
        }

        return lst;
    }

    public static void printTree(Expression exp, Integer index) {
        if (index == 0) {
            System.out.println("\n=============== Abstract Syntax Tree ===============" + "\n");
        }
        String tab = new String(new char[index]).replace("\0", "\t");
        System.out.println(tab + exp.getClass().getSimpleName());
        if (exp.getClass() != AtomicExpression.class) {
            if (CompoundExpression.class.isAssignableFrom(exp.getClass())) {
                CompoundExpression ce = (CompoundExpression) exp;
                index++;
                System.out.println(tab + "[" + ce.getOperator() + "]");
                for (Expression ex : ce.getExpressions()) {
                    printTree(ex, index);
                }
            }
        } else {
            System.out.println(tab + "[" + (AtomicExpression) exp + "]");
        }
    }
}
