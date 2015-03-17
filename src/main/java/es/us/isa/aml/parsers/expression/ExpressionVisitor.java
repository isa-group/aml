// Generated from C:\Users\ISA Group\Desktop\iAgree\Expression.g4 by ANTLR 4.1
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
	 * Visit a parse tree produced by {@link ExpressionParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull ExpressionParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull ExpressionParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull ExpressionParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull ExpressionParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#numberAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull ExpressionParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull ExpressionParser.MultiplicationExprContext ctx);

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
	 * Visit a parse tree produced by {@link ExpressionParser#assigExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull ExpressionParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull ExpressionParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull ExpressionParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull ExpressionParser.RelationalExprContext ctx);

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
	 * Visit a parse tree produced by {@link ExpressionParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull ExpressionParser.NotExprContext ctx);
}