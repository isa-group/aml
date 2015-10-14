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
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.parsers.expression;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by ExpressionParser#arrayAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull ExpressionParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#listExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull ExpressionParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#andExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull ExpressionParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#args.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull ExpressionParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#atomExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull ExpressionParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#list.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull ExpressionParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#stringAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull ExpressionParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#additiveExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull ExpressionParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#numberAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull ExpressionParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#iffExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull ExpressionParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#arrayExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull ExpressionParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#multiplicationExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull ExpressionParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#booleanAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull ExpressionParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#orExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull ExpressionParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#assigExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull ExpressionParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#parExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull ExpressionParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#idAtom.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull ExpressionParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#excludesExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull ExpressionParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#relationalExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull ExpressionParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#impliesExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull ExpressionParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#parse.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull ExpressionParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#equalityExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull ExpressionParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#array.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull ExpressionParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by ExpressionParser#notExpr.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull ExpressionParser.NotExprContext ctx);
}