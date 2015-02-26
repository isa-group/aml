package isa.us.es.aml.model.expression;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jdelafuente
 *
 */
public abstract class Expression  {
	
	protected Object value;
	
	public abstract Object calculate();
	
	public static Set<Atomic> getAtomics(Expression exp){
		Set<Atomic> lst = new HashSet<Atomic>();
		if(exp.getClass() != Atomic.class){
			if(CompoundExpression.class.isAssignableFrom(exp.getClass())){
				CompoundExpression ce = (CompoundExpression) exp;
				for(Expression ex : ce.getExpressions()){
					lst.addAll(getAtomics(ex));
				}
			}
		} else {
			lst.add((Atomic) exp);
		}
		
		return lst;
	}
	
	public static Set<Var> getVars(Expression exp){
		Set<Var> lst = new HashSet<Var>();
		if(exp.getClass() != Var.class){
			if(CompoundExpression.class.isAssignableFrom(exp.getClass())){
				CompoundExpression ce = (CompoundExpression) exp;
				for(Expression ex : ce.getExpressions()){
					lst.addAll(getVars(ex));
				}
			}
		} else {
			lst.add((Var) exp);
		}
		
		return lst;
	}
	
	public static void printTree(Expression exp, Integer index){
		if(index == 0)
			System.out.println("\n=============== Abstract Syntax Tree ===============" + "\n");
		String tab = new String(new char[index]).replace("\0", "\t");
		System.out.println(tab + exp.getClass().getSimpleName());
		if(exp.getClass() != Atomic.class && exp.getClass() != Var.class){
			if(CompoundExpression.class.isAssignableFrom(exp.getClass())){
				CompoundExpression ce = (CompoundExpression) exp;
				index++;
				try {
					System.out.println(tab + "[" + ce.getOperator() + "]");
				} catch(Exception e) {
					System.out.println(tab + "[=]");
				}
				for(Expression ex : ce.getExpressions()){
					printTree(ex, index);
				}
			}
		} else {
			System.out.println(tab + "[" + exp + "]");
		}
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
