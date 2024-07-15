// Generated from /Users/dylanfridman/Downloads/Expr/Expr.g4 by ANTLR 4.13.1

    import java.util.HashSet;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExprParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(ExprParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(ExprParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(ExprParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ExprParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#factors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactors(ExprParser.FactorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ExprParser.FactorContext ctx);
}