/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.parsers.expression;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import es.us.isa.aml.model.ResourceProperty;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.AssignmentExpression;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.DuringExpression;
import es.us.isa.aml.model.expression.DuringInterval;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.FrecuencyExpression;
import es.us.isa.aml.model.expression.ListExpression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.expression.ExpressionParser.AdditiveExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.AndExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ArgsContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ArrayAtomContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ArrayContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ArrayExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.AssigExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.AtomExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.DuringExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.EqualityExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ExcludesExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ExpressionContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.FreqExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.IffExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ImpliesExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ListContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ListExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.MultiplicationExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.NotExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.OrExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ParExprContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.ParseContext;
import es.us.isa.aml.parsers.expression.ExpressionParser.RelationalExprContext;
import es.us.isa.aml.util.AssessmentInterval;
import es.us.isa.aml.util.Util;

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
	public Expression visitExpression(ExpressionContext ctx) {
		Expression res = null;

		switch (ctx.getClass().getSimpleName()) {
		case "AssigExprContext":
			res = this.visitAssigExpr((AssigExprContext) ctx);
			break;
		case "NotExprContext":
			res = this.visitNotExpr((NotExprContext) ctx);
			break;
		case "MultiplicationExprContext":
			res = this.visitMultiplicationExpr((MultiplicationExprContext) ctx);
			break;
		case "AdditiveExprContext":
			res = this.visitAdditiveExpr((AdditiveExprContext) ctx);
			break;
		case "RelationalExprContext":
			res = this.visitRelationalExpr((RelationalExprContext) ctx);
			break;
		case "EqualityExprContext":
			res = this.visitEqualityExpr((EqualityExprContext) ctx);
			break;
		case "AndExprContext":
			res = this.visitAndExpr((AndExprContext) ctx);
			break;
		case "OrExprContext":
			res = this.visitOrExpr((OrExprContext) ctx);
			break;
		case "ImpliesExprContext":
			res = this.visitImpliesExpr((ImpliesExprContext) ctx);
			break;
		case "ExcludesExprContext":
			res = this.visitExcludesExpr((ExcludesExprContext) ctx);
			break;
		case "IffExprContext":
			res = this.visitIffExpr((IffExprContext) ctx);
			break;
		case "DuringExprContext":
			res = this.visitDuringExpr((DuringExprContext) ctx);
			break;
		case "FreqExprContext":
			res = this.visitFreqExpr((FreqExprContext) ctx);
			break;
		case "ParExprContext":
			res = this.visitParExpr((ParExprContext) ctx);
			break;
		case "ListExprContext":
			res = this.visitListExpr((ListExprContext) ctx);
			break;
		case "ArrayExprContext":
			res = this.visitArrayExpr((ArrayExprContext) ctx);
			break;
		case "AtomExprContext":
			res = this.visitAtomExpr((AtomExprContext) ctx);
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
		Expression res = new LogicalExpression(e1, LogicalOperator.NOT);
		return res;
	}

	@Override
	public Expression visitMultiplicationExpr(
			@NotNull ExpressionParser.MultiplicationExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case ExpressionParser.MULTIPLY:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.MULTIPLY);
		case ExpressionParser.DIVIDE:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.DIVIDE);
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
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.ADD);
		case ExpressionParser.SUBTRACT:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.SUBTRACT);
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
			return new RelationalExpression(e1, e2, RelationalOperator.LTE);
		case ExpressionParser.GTE:
			return new RelationalExpression(e1, e2, RelationalOperator.GTE);
		case ExpressionParser.LT:
			return new RelationalExpression(e1, e2, RelationalOperator.LT);
		case ExpressionParser.GT:
			return new RelationalExpression(e1, e2, RelationalOperator.GT);
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
			return new RelationalExpression(e1, e2, RelationalOperator.EQ);
		default:
			throw new IllegalArgumentException("unknown operator: "
					+ ExpressionParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAndExpr(ExpressionParser.AndExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.AND);
	}

	@Override
	public Expression visitOrExpr(ExpressionParser.OrExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.OR);
	}

	@Override
	public Expression visitImpliesExpr(ImpliesExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
	}

	@Override
	public Expression visitExcludesExpr(ExcludesExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression _e2 = this.visitExpression(ctx.expression(1));
		Expression e2 = new LogicalExpression(_e2, LogicalOperator.NOT);
		return new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
	}

	@Override
	public Expression visitIffExpr(IffExprContext ctx) {
		Expression e1_1 = this.visitExpression(ctx.expression(0));
		Expression e1_2 = this.visitExpression(ctx.expression(1));
		Expression e1 = new LogicalExpression(e1_1, e1_2,
				LogicalOperator.IMPLIES);
		Expression e2 = new LogicalExpression(e1_2, e1_1,
				LogicalOperator.IMPLIES);
		return new LogicalExpression(new ParenthesisExpression(e1),
				new ParenthesisExpression(e2), LogicalOperator.AND);
	}

	@Override
	public Expression visitDuringExpr(ExpressionParser.DuringExprContext ctx) {
		DuringInterval interval = (DuringInterval) visitDuringInterval(ctx.durInt);
		Expression state = visitExpression(ctx.state);
		Expression dur = visitExpression(ctx.dur);
		// ResourceProperty resourceProperty = (ResourceProperty)
		// model.getProperty(ctx.expression(0).getText());

		ResourceProperty resourceProperty = new ResourceProperty(ctx
				.expression(0).getText());
		DuringExpression e = new DuringExpression(resourceProperty, state, dur,
				interval);
		return e;
	}

	@Override
	public Object visitDuringInterval(ExpressionParser.DuringIntervalContext ctx) {
		return DuringInterval.valueOf(ctx.getText().toUpperCase());
	}

	@Override
	public Expression visitFreqExpr(ExpressionParser.FreqExprContext ctx) {
		Expression state = visitExpression(ctx.state);
		Expression ntimes = visitExpression(ctx.ntimes);
		AssessmentInterval interval = (AssessmentInterval) visitCompensationsInterval(ctx.compInt);
		RelationalOperator op;
		switch (ctx.op.getType()) {
		case ExpressionParser.LTE:
			op = RelationalOperator.LTE;
			break;
		case ExpressionParser.GTE:
			op = RelationalOperator.GTE;
			break;
		case ExpressionParser.LT:
			op = RelationalOperator.LT;
			break;
		case ExpressionParser.GT:
			op = RelationalOperator.GT;
			break;
		case ExpressionParser.EQ:
			op = RelationalOperator.EQ;
			break;
		default:
			throw new RuntimeException("unknown operator: "
					+ ExpressionParser.tokenNames[ctx.op.getType()]);
		}
		ResourceProperty resourceProperty = new ResourceProperty(ctx
				.expression(0).getText());
		FrecuencyExpression f = new FrecuencyExpression(resourceProperty,
				state, op, ntimes, interval);
		return f;
	}

	@Override
	public Expression visitListExpr(ListExprContext ctx) {
		return visitList(ctx.list());
	}

	@Override
	public Expression visitList(ListContext ctx) {
		List<Object> ls = new ArrayList<Object>();
		for (ArgsContext actx : ctx.args()) {
			ls.add(actx.getText());
		}
		return new ListExpression(ls);
	}

	@Override
	public Expression visitArrayExpr(ArrayExprContext ctx) {
		return visitArray(ctx.array());
	}

	@Override
	public Expression visitArray(ArrayContext ctx) {
		Object[] ls = new Object[ctx.args().size()];
		for (int i = 0; i < ctx.args().size(); i++) {
			ls[i] = Util.withoutDoubleQuotes(ctx.args(i).getText());
		}
		return new ListExpression(ls);
	}

	@Override
	public Object visitCompensationsInterval(
			ExpressionParser.CompensationsIntervalContext ctx) {
		return AssessmentInterval.valueOf(ctx.getText().toUpperCase());
	}

	@Override
	public Expression visitAtomExpr(ExpressionParser.AtomExprContext ctx) {
		Expression res = null;

		switch (ctx.atom().getClass().getSimpleName()) {
		case "NumberAtomContext":
			res = this.visitNumberAtom((ExpressionParser.NumberAtomContext) ctx
					.atom());
			break;
		case "BooleanAtomContext":
			res = this
					.visitBooleanAtom((ExpressionParser.BooleanAtomContext) ctx
							.atom());
			break;
		case "ArrayAtomContext":
			res = this.visitArrayAtom((ExpressionParser.ArrayAtomContext) ctx
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
	public Expression visitArrayAtom(ArrayAtomContext ctx) {
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

	@Override
	public Object visitArgs(ArgsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
