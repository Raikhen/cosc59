// Generated from /Users/dylanfridman/Downloads/Expr/Expr.g4 by ANTLR 4.13.1

    import java.util.HashSet;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MOD=8, NUM=9, 
		ID=10, WS=11;
	public static final int
		RULE_start = 0, RULE_list = 1, RULE_line = 2, RULE_expr = 3, RULE_terms = 4, 
		RULE_term = 5, RULE_factors = 6, RULE_factor = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "list", "line", "expr", "terms", "term", "factors", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'MOD'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MOD", "NUM", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public HashSet<String> ids = new HashSet<String>();
	    public String toPrint = "";

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			list();
			setState(17);
			match(EOF);

			    String s = ids.toString();
			    s = s.substring(1, s.length() - 1);
			    toPrint += "Symbol Table: " + s + ".";

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case NUM:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				expr();
				setState(21);
				match(T__0);
				 toPrint += ";"; 
				setState(23);
				list();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			expr();
			setState(29);
			match(T__0);
			 toPrint += ";"; 
			setState(31);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			term();
			setState(34);
			terms();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermsContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_terms);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(T__1);
				setState(37);
				term();
				 toPrint += "+ "; 
				setState(39);
				terms();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(T__2);
				setState(42);
				term();
				 toPrint += "- "; 
				setState(44);
				terms();
				}
				break;
			case T__0:
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorsContext factors() {
			return getRuleContext(FactorsContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			factor();
			setState(50);
			factors();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorsContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorsContext factors() {
			return getRuleContext(FactorsContext.class,0);
		}
		public TerminalNode MOD() { return getToken(ExprParser.MOD, 0); }
		public FactorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterFactors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitFactors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitFactors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorsContext factors() throws RecognitionException {
		FactorsContext _localctx = new FactorsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factors);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__3);
				setState(53);
				factor();
				 toPrint += "* "; 
				setState(55);
				factors();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__4);
				setState(58);
				factor();
				 toPrint += "/ "; 
				setState(60);
				factors();
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(MOD);
				setState(63);
				factor();
				 toPrint += "MOD "; 
				setState(65);
				factors();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public Token id;
		public Token num;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode NUM() { return getToken(ExprParser.NUM, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(T__5);
				setState(71);
				expr();
				setState(72);
				match(T__6);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((FactorContext)_localctx).id = match(ID);
				 toPrint += (((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + " "; ids.add((((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null)); 
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				((FactorContext)_localctx).num = match(NUM);
				 toPrint += (((FactorContext)_localctx).num!=null?((FactorContext)_localctx).num.getText():null) + " "; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000bQ\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u00040\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006E\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007O\b\u0007\u0001\u0007\u0000\u0000\b\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000P\u0000\u0010\u0001\u0000\u0000"+
		"\u0000\u0002\u001a\u0001\u0000\u0000\u0000\u0004\u001c\u0001\u0000\u0000"+
		"\u0000\u0006!\u0001\u0000\u0000\u0000\b/\u0001\u0000\u0000\u0000\n1\u0001"+
		"\u0000\u0000\u0000\fD\u0001\u0000\u0000\u0000\u000eN\u0001\u0000\u0000"+
		"\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011\u0012\u0005\u0000\u0000"+
		"\u0001\u0012\u0013\u0006\u0000\uffff\uffff\u0000\u0013\u0001\u0001\u0000"+
		"\u0000\u0000\u0014\u0015\u0003\u0006\u0003\u0000\u0015\u0016\u0005\u0001"+
		"\u0000\u0000\u0016\u0017\u0006\u0001\uffff\uffff\u0000\u0017\u0018\u0003"+
		"\u0002\u0001\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u001b\u0001"+
		"\u0000\u0000\u0000\u001a\u0014\u0001\u0000\u0000\u0000\u001a\u0019\u0001"+
		"\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001d\u0003"+
		"\u0006\u0003\u0000\u001d\u001e\u0005\u0001\u0000\u0000\u001e\u001f\u0006"+
		"\u0002\uffff\uffff\u0000\u001f \u0005\u0000\u0000\u0001 \u0005\u0001\u0000"+
		"\u0000\u0000!\"\u0003\n\u0005\u0000\"#\u0003\b\u0004\u0000#\u0007\u0001"+
		"\u0000\u0000\u0000$%\u0005\u0002\u0000\u0000%&\u0003\n\u0005\u0000&\'"+
		"\u0006\u0004\uffff\uffff\u0000\'(\u0003\b\u0004\u0000(0\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0003\u0000\u0000*+\u0003\n\u0005\u0000+,\u0006\u0004\uffff"+
		"\uffff\u0000,-\u0003\b\u0004\u0000-0\u0001\u0000\u0000\u0000.0\u0001\u0000"+
		"\u0000\u0000/$\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000\u0000/.\u0001"+
		"\u0000\u0000\u00000\t\u0001\u0000\u0000\u000012\u0003\u000e\u0007\u0000"+
		"23\u0003\f\u0006\u00003\u000b\u0001\u0000\u0000\u000045\u0005\u0004\u0000"+
		"\u000056\u0003\u000e\u0007\u000067\u0006\u0006\uffff\uffff\u000078\u0003"+
		"\f\u0006\u00008E\u0001\u0000\u0000\u00009:\u0005\u0005\u0000\u0000:;\u0003"+
		"\u000e\u0007\u0000;<\u0006\u0006\uffff\uffff\u0000<=\u0003\f\u0006\u0000"+
		"=E\u0001\u0000\u0000\u0000>?\u0005\b\u0000\u0000?@\u0003\u000e\u0007\u0000"+
		"@A\u0006\u0006\uffff\uffff\u0000AB\u0003\f\u0006\u0000BE\u0001\u0000\u0000"+
		"\u0000CE\u0001\u0000\u0000\u0000D4\u0001\u0000\u0000\u0000D9\u0001\u0000"+
		"\u0000\u0000D>\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000E\r\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0006\u0000\u0000GH\u0003\u0006\u0003\u0000"+
		"HI\u0005\u0007\u0000\u0000IO\u0001\u0000\u0000\u0000JK\u0005\n\u0000\u0000"+
		"KO\u0006\u0007\uffff\uffff\u0000LM\u0005\t\u0000\u0000MO\u0006\u0007\uffff"+
		"\uffff\u0000NF\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000O\u000f\u0001\u0000\u0000\u0000\u0004\u001a/DN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}