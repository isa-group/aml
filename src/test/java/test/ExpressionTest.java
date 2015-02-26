/**
 * 
 */
package test;

import isa.us.es.aml.model.expression.ArithmeticExpression;
import isa.us.es.aml.model.expression.ArithmeticOperator;
import isa.us.es.aml.model.expression.AssignmentExpression;
import isa.us.es.aml.model.expression.Atomic;
import isa.us.es.aml.model.expression.Expression;
import isa.us.es.aml.model.expression.Var;

/**
 * @author jdelafuente
 *
 */
public class ExpressionTest {
	
	public static void main(String[] args) {
		
		Var a = new Var("a");
		Var b = new Var("b");
		Var c = new Var("c");
		
		Expression e = new AssignmentExpression(a, new Atomic(2));
		e.calculate();
		
		Expression e2 = new AssignmentExpression(b, new ArithmeticExpression(a, new Atomic(1), ArithmeticOperator.add));
		e2.calculate();
		
		Expression e3 = new AssignmentExpression(c, new ArithmeticExpression(a, b, ArithmeticOperator.add));
		e3.calculate();
		
		System.out.println(e.toString());
		System.out.println("valor de a: " + a.calculate());
		
		System.out.println("\n");
		
		System.out.println(e2.toString());
		System.out.println("valor de b: " + b.calculate());
		
		System.out.println("\n");
		
		System.out.println(e3.toString());
		System.out.println("valor de c: " + c.calculate());
		
		System.out.println("\n");
		
		
		Var d = new Var("d");
		
		Expression e4 = new AssignmentExpression(d, new Atomic(false));
		e4.calculate();
		
		System.out.println(e4.toString());
		System.out.println("Es d == true?: " + ((Boolean) d.calculate() == true));
		System.out.println("Es d == false?: " + ((Boolean) d.calculate() == false));
		
	}

}
