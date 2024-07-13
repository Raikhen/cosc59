// Generated from /Users/dylanfridman/cosc59/A01/PassagesJava/passage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link passageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface passageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link passageParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(passageParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(passageParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#l}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitL(passageParser.LContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#v}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitV(passageParser.VContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(passageParser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(passageParser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(passageParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link passageParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitB(passageParser.BContext ctx);
}