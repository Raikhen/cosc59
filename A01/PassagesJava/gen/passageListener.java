// Generated from /Users/dylanfridman/cosc59/A01/PassagesJava/passage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link passageParser}.
 */
public interface passageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link passageParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(passageParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link passageParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(passageParser.PruleContext ctx);
}