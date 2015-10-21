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
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ExpressionVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ExpressionBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExpressionVisitor<T> {
	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitArrayAtom(@NotNull ExpressionParser.ArrayAtomContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitListExpr(@NotNull ExpressionParser.ListExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitAndExpr(@NotNull ExpressionParser.AndExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitArgs(@NotNull ExpressionParser.ArgsContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitAtomExpr(@NotNull ExpressionParser.AtomExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitList(@NotNull ExpressionParser.ListContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitStringAtom(@NotNull ExpressionParser.StringAtomContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitAdditiveExpr(@NotNull ExpressionParser.AdditiveExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitNumberAtom(@NotNull ExpressionParser.NumberAtomContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitIffExpr(@NotNull ExpressionParser.IffExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitArrayExpr(@NotNull ExpressionParser.ArrayExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitMultiplicationExpr(@NotNull ExpressionParser.MultiplicationExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitBooleanAtom(@NotNull ExpressionParser.BooleanAtomContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitOrExpr(@NotNull ExpressionParser.OrExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitAssigExpr(@NotNull ExpressionParser.AssigExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitParExpr(@NotNull ExpressionParser.ParExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitIdAtom(@NotNull ExpressionParser.IdAtomContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitExcludesExpr(@NotNull ExpressionParser.ExcludesExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitRelationalExpr(@NotNull ExpressionParser.RelationalExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitImpliesExpr(@NotNull ExpressionParser.ImpliesExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitParse(@NotNull ExpressionParser.ParseContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitEqualityExpr(@NotNull ExpressionParser.EqualityExprContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitArray(@NotNull ExpressionParser.ArrayContext ctx) { return visitChildren(ctx); }

	/**
	 * {@inheritDoc}
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitNotExpr(@NotNull ExpressionParser.NotExprContext ctx) { return visitChildren(ctx); }
}