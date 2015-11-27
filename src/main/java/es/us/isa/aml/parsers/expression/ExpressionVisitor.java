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
	 * Visit a parse tree produced by {@link ExpressionParser#arrayAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull ExpressionParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull ExpressionParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#duringExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuringExpr(@NotNull ExpressionParser.DuringExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull ExpressionParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#duringInterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuringInterval(@NotNull ExpressionParser.DuringIntervalContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull ExpressionParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#numberAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull ExpressionParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull ExpressionParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull ExpressionParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#assigExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull ExpressionParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#freqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFreqExpr(@NotNull ExpressionParser.FreqExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull ExpressionParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#excludesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull ExpressionParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull ExpressionParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull ExpressionParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#compensationsInterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompensationsInterval(@NotNull ExpressionParser.CompensationsIntervalContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull ExpressionParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull ExpressionParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull ExpressionParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull ExpressionParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull ExpressionParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull ExpressionParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#iffExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull ExpressionParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull ExpressionParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull ExpressionParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull ExpressionParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#impliesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull ExpressionParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull ExpressionParser.ArrayContext ctx);
}