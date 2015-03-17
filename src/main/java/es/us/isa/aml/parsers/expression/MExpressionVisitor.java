/**
 *
 */
package es.us.isa.aml.parsers.expression;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

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
import es.us.isa.aml.parsers.expression.ExpressionParser.ParseContext;

/**
 * @author jdelafuente
 *
 */
public class MExpressionVisitor implements ExpressionVisitor<Object> {

	@Override
	public Expression visitParse(ParseContext ctx) {
		Expression e = visitExpression(ctx.expression());
		return e;
	}
	
    // expr overrides
    public Expression visitExpression(ExpressionParser.ExpressionContext ctx) {
        Expression res = null;

        switch (ctx.getClass().getSimpleName()) {
            case "AssigExprContext":
                res = this.visitAssigExpr((ExpressionParser.AssigExprContext) ctx);
                break;
            case "NotExprContext":
                res = this.visitNotExpr((ExpressionParser.NotExprContext) ctx);
                break;
            case "MultiplicationExprContext":
                res = this
                        .visitMultiplicationExpr((ExpressionParser.MultiplicationExprContext) ctx);
                break;
            case "AdditiveExprContext":
                res = this
                        .visitAdditiveExpr((ExpressionParser.AdditiveExprContext) ctx);
                break;
            case "RelationalExprContext":
                res = this
                        .visitRelationalExpr((ExpressionParser.RelationalExprContext) ctx);
                break;
            case "EqualityExprContext":
                res = this
                        .visitEqualityExpr((ExpressionParser.EqualityExprContext) ctx);
                break;
            case "AndExprContext":
                res = this.visitAndExpr((ExpressionParser.AndExprContext) ctx);
                break;
            case "OrExprContext":
                res = this.visitOrExpr((ExpressionParser.OrExprContext) ctx);
                break;
            case "ParExprContext":
                res = this.visitParExpr((ExpressionParser.ParExprContext) ctx);
                break;
            case "AtomExprContext":
                res = this.visitAtomExpr((ExpressionParser.AtomExprContext) ctx);
                break;
        }

        return res;
    }

    @Override
    public Expression visitAssigExpr(ExpressionParser.AssigExprContext ctx) {
        Var v = new Var(ctx.Identifier().getText());
        Expression e2 = this.visitExpression(ctx.expression());
        Expression res = new AssignmentExpression(v, e2);
        return res;
    }

    @Override
    public Expression visitNotExpr(ExpressionParser.NotExprContext ctx) {
        Expression e1 = this.visitExpression(ctx.expression());
        Expression res = new LogicalExpression(e1, LogicalOperator.not);
        return res;
    }

    @Override
    public Expression visitMultiplicationExpr(
            @NotNull ExpressionParser.MultiplicationExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

        switch (ctx.op.getType()) {
            case ExpressionParser.MULTIPLY:
                return new ArithmeticExpression(e1, e2, ArithmeticOperator.multiply);
            case ExpressionParser.DIVIDE:
                return new ArithmeticExpression(e1, e2, ArithmeticOperator.divide);
            default:
                throw new RuntimeException("unknown operator: "
                        + ExpressionParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expression visitAdditiveExpr(
            @NotNull ExpressionParser.AdditiveExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

        switch (ctx.op.getType()) {
            case ExpressionParser.ADD:
                return new ArithmeticExpression(e1, e2, ArithmeticOperator.add);
            case ExpressionParser.SUBTRACT:
                return new ArithmeticExpression(e1, e2, ArithmeticOperator.subtract);
            default:
                throw new RuntimeException("unknown operator: "
                        + ExpressionParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expression visitRelationalExpr(
            @NotNull ExpressionParser.RelationalExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

        switch (ctx.op.getType()) {
            case ExpressionParser.LTE:
                return new RelationalExpression(e1, e2, RelationalOperator.lte);
            case ExpressionParser.GTE:
                return new RelationalExpression(e1, e2, RelationalOperator.gte);
            case ExpressionParser.LT:
                return new RelationalExpression(e1, e2, RelationalOperator.lt);
            case ExpressionParser.GT:
                return new RelationalExpression(e1, e2, RelationalOperator.gt);
            default:
                throw new RuntimeException("unknown operator: "
                        + ExpressionParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expression visitEqualityExpr(
            @NotNull ExpressionParser.EqualityExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

        switch (ctx.op.getType()) {
            case ExpressionParser.EQ:
                return new RelationalExpression(e1, e2, RelationalOperator.eq);
            default:
                throw new IllegalArgumentException("unknown operator: "
                        + ExpressionParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expression visitAndExpr(ExpressionParser.AndExprContext ctx) {
        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));
        return new LogicalExpression(e1, e2, LogicalOperator.and);
    }

    @Override
    public Expression visitOrExpr(ExpressionParser.OrExprContext ctx) {
        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));
        return new LogicalExpression(e1, e2, LogicalOperator.or);
    }

    // atom overrides
    @Override
    public Expression visitAtomExpr(ExpressionParser.AtomExprContext ctx) {
        Expression res = null;

        switch (ctx.atom().getClass().getSimpleName()) {
            case "NumberAtomContext":
                res = this.visitNumberAtom((ExpressionParser.NumberAtomContext) ctx
                        .atom());
                break;
            case "BooleanAtomContext":
                res = this.visitBooleanAtom((ExpressionParser.BooleanAtomContext) ctx
                        .atom());
                break;
            case "IdAtomContext":
                res = this.visitIdAtom((ExpressionParser.IdAtomContext) ctx.atom());
                break;
            case "StringAtomContext":
                res = this.visitStringAtom((ExpressionParser.StringAtomContext) ctx
                        .atom());
                break;
        }

        return res;
    }

    @Override
    public Expression visitParExpr(ExpressionParser.ParExprContext ctx) {
        return new ParenthesisExpression(this.visitExpression(ctx.expression()));
    }

    @Override
    public Expression visitNumberAtom(ExpressionParser.NumberAtomContext ctx) {
        return new Atomic(ctx.getText());
    }

    @Override
    public Expression visitBooleanAtom(ExpressionParser.BooleanAtomContext ctx) {
        return new Atomic(ctx.getText());
    }

    @Override
    public Expression visitIdAtom(ExpressionParser.IdAtomContext ctx) {
        return new Var(ctx.getText());
    }

    @Override
    public Expression visitStringAtom(ExpressionParser.StringAtomContext ctx) {
        return new Atomic(ctx.getText());
    }

	@Override
	public Object visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitChildren(RuleNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		return null;
	}
}
