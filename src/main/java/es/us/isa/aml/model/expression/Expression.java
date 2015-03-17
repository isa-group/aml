package es.us.isa.aml.model.expression;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jdelafuente
 *
 */
public abstract class Expression {

    public static Set<Atomic> getAtomics(Expression exp) {
        Set<Atomic> lst = new HashSet<>();
        if (!(exp instanceof Var)) {
            if (exp instanceof CompoundExpression) {
                CompoundExpression ce = (CompoundExpression) exp;
                for (Expression ex : ce.getExpressions()) {
                    lst.addAll(Expression.getAtomics(ex));
                }
            } else if (exp instanceof UnitaryExpression) {
                UnitaryExpression ue = (UnitaryExpression) exp;
                lst.addAll(Expression.getAtomics(ue.getExpression()));
            }
        } else {
            lst.add((Atomic) exp);
        }
        return lst;
    }

    public static Set<Var> getVars(Expression exp) {
        Set<Var> lst = new HashSet<>();
        if (!(exp instanceof Var)) {
            if (exp instanceof CompoundExpression) {
                CompoundExpression ce = (CompoundExpression) exp;
                for (Expression ex : ce.getExpressions()) {
                    lst.addAll(Expression.getVars(ex));
                }
            } else if (exp instanceof UnitaryExpression) {
                UnitaryExpression ue = (UnitaryExpression) exp;
                lst.addAll(Expression.getVars(ue.getExpression()));
            }
        } else {
            lst.add((Var) exp);
        }
        return lst;
    }

    public static void printTree(Expression exp, Integer index) {
        if (index == 0) {
            System.out.println("\n=============== Abstract Syntax Tree ===============" + "\n");
        }
        String tab = new String(new char[index]).replace("\0", "\t");
        
        System.out.println(tab + exp.getClass().getSimpleName());
        if (!(exp instanceof Atomic) && !(exp instanceof Var)) {
            if (exp instanceof CompoundExpression) {
                CompoundExpression ce = (CompoundExpression) exp;
                index++;
                try {
                    System.out.println(tab + "[" + ce.getOperator() + "]");
                } catch (Exception e) {
                    System.out.println(tab + "[=]");
                }
                for (Expression ex : ce.getExpressions()) {
                	Expression.printTree(ex, index);
                }
            } else if (exp instanceof UnitaryExpression) {
                UnitaryExpression ue = (UnitaryExpression) exp;
                index++;
                Expression.printTree(ue.getExpression(), index);
            }
        } else {
            System.out.println(tab + "[" + exp + "]");
        }
    }

    protected Object value;

    public abstract Object calculate();

}
