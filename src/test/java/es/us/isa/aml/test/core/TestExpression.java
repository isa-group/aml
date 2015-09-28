/**
 *
 */
package es.us.isa.aml.test.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.AssignmentExpression;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;

/**
 * @author jdelafuente
 *
 */
public class TestExpression {

    // Check assignment expressions
    @Test
    public void testAssignmentExpression() {

        Var a = new Var("a", new Atomic(2.0));
        assertEquals(2.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b");
        Expression e = new AssignmentExpression(b, new Atomic(2));
        e.calculate();
        assertEquals(2, b.getIntegerValue().intValue());

        Var c = new Var("c", new Atomic(false));
        assertFalse(c.getBooleanValue());
    }

    // Check arithmetic expressions
    @Test
    public void testArithmeticExpression() {
        Var a = new Var("a", new Atomic(2));
        assertEquals(2.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b", new ArithmeticExpression(a, new Atomic(1), ArithmeticOperator.ADD));
        assertEquals(3.0, b.getDoubleValue(), 0.0);

        Var c = new Var("c", new ArithmeticExpression(a, b, ArithmeticOperator.ADD));
        assertEquals(5.0, c.getDoubleValue(), 0.0);

        Expression e = new ArithmeticExpression(a, c, ArithmeticOperator.ADD);
        assertEquals(7.0, (Double) e.calculate(), 0.0);
    }

    // Check relational expressions
    @Test
    public void testRelationalExpression() {
        Var a = new Var("a", new Atomic(2));
        assertEquals(2.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b", new ArithmeticExpression(a, new Atomic(1), ArithmeticOperator.ADD));
        assertEquals(3.0, b.getDoubleValue(), 0.0);

        Var c = new Var("c", new ArithmeticExpression(a, b, ArithmeticOperator.ADD));
        assertEquals(5.0, c.getDoubleValue(), 0.0);

        Expression exp = new ArithmeticExpression(a, b, ArithmeticOperator.ADD);
        assertEquals(5.0, (double) exp.calculate(), 0.0);

        Expression e = new RelationalExpression(exp, c, RelationalOperator.EQ);
        assertTrue((boolean) e.calculate());
    }

    // Check logical expressions
    @Test
    public void testLogicalExpression() {
        Var a = new Var("a", new Atomic(3));
        assertEquals(3.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b", new Atomic(2));
        assertEquals(2.0, b.getDoubleValue(), 0.0);

        Var c = new Var("c", new Atomic(true));
        assertTrue(c.getBooleanValue());

        Expression exp = new RelationalExpression(a, b, RelationalOperator.GT);
        assertTrue((boolean) exp.calculate());

        Expression e = new LogicalExpression(exp, c, LogicalOperator.AND);
        assertTrue((boolean) e.calculate());
        
        // NEGACION DE EXPRESIONES
        Expression neg = new LogicalExpression(new ParenthesisExpression(e), LogicalOperator.NOT);
        assertFalse((boolean) neg.calculate());
    }

    // Check uninitialized variables
    @Test(expected = NullPointerException.class)
    public void testNoInitializedVariable() {
        Var a = new Var("a");
        Expression exp = new ArithmeticExpression(a, new Atomic(2), ArithmeticOperator.ADD);
        exp.calculate();
    }
}
