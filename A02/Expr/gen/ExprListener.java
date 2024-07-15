// Generated from /Users/dylanfridman/Downloads/Expr/Expr.g4 by ANTLR 4.13.1

    import java.util.HashSet;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExprParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExprParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(ExprParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(ExprParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ExprParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ExprParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(ExprParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(ExprParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExprParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#factors}.
	 * @param ctx the parse tree
	 */
	void enterFactors(ExprParser.FactorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#factors}.
	 * @param ctx the parse tree
	 */
	void exitFactors(ExprParser.FactorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExprParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExprParser.FactorContext ctx);
}