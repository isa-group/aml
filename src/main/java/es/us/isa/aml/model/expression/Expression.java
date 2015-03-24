package es.us.isa.aml.model.expression;

import es.us.isa.aml.parsers.expression.ExpressionLexer;
import es.us.isa.aml.parsers.expression.ExpressionParser;
import es.us.isa.aml.parsers.expression.ExpressionParser.ParseContext;
import es.us.isa.aml.parsers.expression.MExpressionVisitor;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author jdelafuente
 *
 */
public abstract class Expression {

    private static final Logger LOG = Logger.getLogger(Expression.class.getName());

    public static Expression parse(String content) {

        ExpressionLexer lexer = new ExpressionLexer(new ANTLRInputStream(content));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        ExpressionParser parser = new ExpressionParser(tokens);

        // Specify our entry point
        ParseContext context = parser.parse();

        // Walk it and attach our listener
        MExpressionVisitor visitor = new MExpressionVisitor();
        Expression res = visitor.visitParse(context);

        return res;
    }

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
            LOG.log(Level.INFO, "\n=============== Abstract Syntax Tree ===============" + "\n");
        }
        String tab = new String(new char[index]).replace("\0", "\t");

        LOG.log(Level.INFO, "{0}{1}", new Object[]{tab, exp.getClass().getSimpleName()});
        if (!(exp instanceof Atomic) && !(exp instanceof Var)) {
            if (exp instanceof CompoundExpression) {
                CompoundExpression ce = (CompoundExpression) exp;
                index++;
                try {
                    LOG.log(Level.INFO, "{0}[{1}]", new Object[]{tab, ce.getOperator()});
                } catch (Exception e) {
                    LOG.log(Level.INFO, "{0}[=]", tab);
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
            LOG.log(Level.INFO, "{0}[{1}]", new Object[]{tab, exp});
        }
    }
    protected Object value;

    public abstract Object calculate();
}
