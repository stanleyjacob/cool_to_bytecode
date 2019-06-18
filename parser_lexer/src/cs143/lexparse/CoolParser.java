// Generated from src/cs143/lexparse/Cool.g4 by ANTLR 4.7.2
package cs143.lexparse;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, LINECOMMENT=3, LINECOMMENTEOF=4, BEGINCOMMENT=5, BEGINCOMMENTNEST=6, 
		ENDCOMMENT=7, IGNOREINCOMMENT=8, IGNOREINCOMMENTLPAREN=9, IGNOREINCOMMENTSTAR=10, 
		IGNOREINCOMMENTNEWLINE=11, BADENDCOMMENT=12, TRUE=13, FALSE=14, CLASS=15, 
		FI=16, IF=17, IN=18, INHERITS=19, ISVOID=20, LET=21, LOOP=22, POOL=23, 
		THEN=24, ELSE=25, WHILE=26, CASE=27, ESAC=28, NEW=29, OF=30, NOT=31, TYPE=32, 
		ID=33, INT_CONST=34, LPAREN=35, RPAREN=36, LBRACE=37, RBRACE=38, SEMI=39, 
		COLON=40, ASSIGN=41, DARROW=42, NEG=43, COMMA=44, PERIOD=45, AT=46, MUL=47, 
		ADD=48, MINUS=49, DIV=50, LT=51, LEQ=52, EQ=53, STR_CONST=54;
	public static final int
		RULE_program = 0, RULE_klass = 1, RULE_feature = 2, RULE_formal = 3, RULE_let_formal = 4, 
		RULE_expr = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "klass", "feature", "formal", "let_formal", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'('", 
			"')'", "'{'", "'}'", "';'", "':'", "'<-'", "'=>'", "'~'", "','", "'.'", 
			"'@'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "LINECOMMENT", "LINECOMMENTEOF", "BEGINCOMMENT", 
			"BEGINCOMMENTNEST", "ENDCOMMENT", "IGNOREINCOMMENT", "IGNOREINCOMMENTLPAREN", 
			"IGNOREINCOMMENTSTAR", "IGNOREINCOMMENTNEWLINE", "BADENDCOMMENT", "TRUE", 
			"FALSE", "CLASS", "FI", "IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", 
			"POOL", "THEN", "ELSE", "WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", 
			"TYPE", "ID", "INT_CONST", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", 
			"COLON", "ASSIGN", "DARROW", "NEG", "COMMA", "PERIOD", "AT", "MUL", "ADD", 
			"MINUS", "DIV", "LT", "LEQ", "EQ", "STR_CONST"
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
	public String getGrammarFileName() { return "Cool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public List<KlassContext> klass() {
			return getRuleContexts(KlassContext.class);
		}
		public KlassContext klass(int i) {
			return getRuleContext(KlassContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				klass();
				setState(13);
				match(SEMI);
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(19);
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

	public static class KlassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public KlassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitKlass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KlassContext klass() throws RecognitionException {
		KlassContext _localctx = new KlassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_klass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(CLASS);
			setState(22);
			match(TYPE);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(23);
				match(INHERITS);
				setState(24);
				match(TYPE);
				}
			}

			setState(27);
			match(LBRACE);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(28);
				feature();
				setState(29);
				match(SEMI);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(RBRACE);
			 System.out.println("Class ended: " + CoolLexer.linenum); 
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

	public static class FeatureContext extends ParserRuleContext {
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	 
		public FeatureContext() { }
		public void copyFrom(FeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodContext extends FeatureContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public MethodContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttrContext extends FeatureContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AttrContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new MethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(ID);
				setState(40);
				match(LPAREN);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(41);
					formal();
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(42);
						match(COMMA);
						setState(43);
						formal();
						}
						}
						setState(48);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(RPAREN);
				setState(55);
				match(COLON);
				setState(56);
				match(TYPE);
				setState(57);
				match(LBRACE);
				setState(58);
				expr(0);
				setState(59);
				match(RBRACE);
				}
				break;
			case 2:
				_localctx = new AttrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(ID);
				setState(62);
				match(COLON);
				setState(63);
				match(TYPE);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(64);
					match(ASSIGN);
					setState(65);
					expr(0);
					}
				}

				}
				break;
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

	public static class FormalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(ID);
			setState(71);
			match(COLON);
			setState(72);
			match(TYPE);
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

	public static class Let_formalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Let_formalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_formal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitLet_formal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_formalContext let_formal() throws RecognitionException {
		Let_formalContext _localctx = new Let_formalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_let_formal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ID);
			setState(75);
			match(COLON);
			setState(76);
			match(TYPE);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(77);
				match(ASSIGN);
				setState(78);
				expr(0);
				}
			}

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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public MinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DispatchContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PERIOD() { return getToken(CoolParser.PERIOD, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode AT() { return getToken(CoolParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public DispatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitDispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Str_constContext extends ExprContext {
		public TerminalNode STR_CONST() { return getToken(CoolParser.STR_CONST, 0); }
		public Str_constContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitStr_const(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(CoolParser.MUL, 0); }
		public MulContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsvoidContext extends ExprContext {
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitIsvoid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfdispatchContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public SelfdispatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitSelfdispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends ExprContext {
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(CoolParser.DIV, 0); }
		public DivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegContext extends ExprContext {
		public TerminalNode NEG() { return getToken(CoolParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public ParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public LessThanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends ExprContext {
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public List<Let_formalContext> let_formal() {
			return getRuleContexts(Let_formalContext.class);
		}
		public Let_formalContext let_formal(int i) {
			return getRuleContext(Let_formalContext.class,i);
		}
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends ExprContext {
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public BlockContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends ExprContext {
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CaseContext extends ExprContext {
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public List<TerminalNode> ID() { return getTokens(CoolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CoolParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(CoolParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CoolParser.COLON, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public List<TerminalNode> DARROW() { return getTokens(CoolParser.DARROW); }
		public TerminalNode DARROW(int i) {
			return getToken(CoolParser.DARROW, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public CaseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanOrEqualToContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEQ() { return getToken(CoolParser.LEQ, 0); }
		public LessThanOrEqualToContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitLessThanOrEqualTo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(CoolParser.ADD, 0); }
		public AddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends ExprContext {
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_trueContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(CoolParser.TRUE, 0); }
		public Bool_trueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitBool_true(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(CoolParser.EQ, 0); }
		public EqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Int_constContext extends ExprContext {
		public TerminalNode INT_CONST() { return getToken(CoolParser.INT_CONST, 0); }
		public Int_constContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitInt_const(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_falseContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(CoolParser.FALSE, 0); }
		public Bool_falseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitBool_false(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExprContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new SelfdispatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(82);
				match(ID);
				setState(83);
				match(LPAREN);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << NOT) | (1L << ID) | (1L << INT_CONST) | (1L << LPAREN) | (1L << LBRACE) | (1L << NEG) | (1L << STR_CONST))) != 0)) {
					{
					{
					setState(84);
					expr(0);
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(85);
						match(COMMA);
						setState(86);
						expr(0);
						}
						}
						setState(91);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(IF);
				setState(99);
				expr(0);
				setState(100);
				match(THEN);
				setState(101);
				expr(0);
				setState(102);
				match(ELSE);
				setState(103);
				expr(0);
				setState(104);
				match(FI);
				}
				break;
			case 3:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(WHILE);
				setState(107);
				expr(0);
				setState(108);
				match(LOOP);
				setState(109);
				expr(0);
				setState(110);
				match(POOL);
				}
				break;
			case 4:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(LET);
				setState(113);
				let_formal();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(114);
					match(COMMA);
					setState(115);
					let_formal();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(IN);
				setState(122);
				expr(21);
				}
				break;
			case 5:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(CASE);
				setState(125);
				expr(0);
				setState(126);
				match(OF);
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(127);
					match(ID);
					setState(128);
					match(COLON);
					setState(129);
					match(TYPE);
					setState(130);
					match(DARROW);
					setState(131);
					expr(0);
					setState(132);
					match(SEMI);
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(138);
				match(ESAC);
				}
				break;
			case 6:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(NEW);
				setState(141);
				match(TYPE);
				}
				break;
			case 7:
				{
				_localctx = new NegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(NEG);
				setState(143);
				expr(18);
				}
				break;
			case 8:
				{
				_localctx = new IsvoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(ISVOID);
				setState(145);
				expr(17);
				}
				break;
			case 9:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(LPAREN);
				setState(147);
				expr(0);
				setState(148);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(LBRACE);
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151);
					expr(0);
					setState(152);
					match(SEMI);
					}
					}
					setState(156); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << NOT) | (1L << ID) | (1L << INT_CONST) | (1L << LPAREN) | (1L << LBRACE) | (1L << NEG) | (1L << STR_CONST))) != 0) );
				setState(158);
				match(RBRACE);
				}
				break;
			case 11:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(NOT);
				setState(161);
				expr(7);
				}
				break;
			case 12:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(ID);
				setState(163);
				match(ASSIGN);
				setState(164);
				expr(6);
				}
				break;
			case 13:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(ID);
				}
				break;
			case 14:
				{
				_localctx = new Int_constContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(INT_CONST);
				}
				break;
			case 15:
				{
				_localctx = new Str_constContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(STR_CONST);
				}
				break;
			case 16:
				{
				_localctx = new Bool_trueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(TRUE);
				}
				break;
			case 17:
				{
				_localctx = new Bool_falseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(215);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(173);
						match(MUL);
						setState(174);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(175);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(176);
						match(DIV);
						setState(177);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new AddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(179);
						match(ADD);
						setState(180);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new MinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(182);
						match(MINUS);
						setState(183);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new LessThanOrEqualToContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(185);
						match(LEQ);
						setState(186);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new LessThanContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(188);
						match(LT);
						setState(189);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new EqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(191);
						match(EQ);
						setState(192);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new DispatchContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(196);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(194);
							match(AT);
							setState(195);
							match(TYPE);
							}
						}

						setState(198);
						match(PERIOD);
						setState(199);
						match(ID);
						setState(200);
						match(LPAREN);
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << NOT) | (1L << ID) | (1L << INT_CONST) | (1L << LPAREN) | (1L << LBRACE) | (1L << NEG) | (1L << STR_CONST))) != 0)) {
							{
							{
							setState(201);
							expr(0);
							setState(206);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(202);
								match(COMMA);
								setState(203);
								expr(0);
								}
								}
								setState(208);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							setState(213);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(214);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 24);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u00df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\6\2\22\n\2\r\2\16\2"+
		"\23\3\2\3\2\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16"+
		"\3%\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\7\4"+
		"\64\n\4\f\4\16\4\67\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4E\n\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\7\7_\n\7\f\7\16\7b\13\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\6\7\u0089\n\7\r\7\16\7\u008a\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u009d\n\7\r\7\16\7\u009e\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00ad\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u00c7\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00cf\n\7\f\7\16"+
		"\7\u00d2\13\7\7\7\u00d4\n\7\f\7\16\7\u00d7\13\7\3\7\7\7\u00da\n\7\f\7"+
		"\16\7\u00dd\13\7\3\7\2\3\f\b\2\4\6\b\n\f\2\2\2\u0100\2\21\3\2\2\2\4\27"+
		"\3\2\2\2\6F\3\2\2\2\bH\3\2\2\2\nL\3\2\2\2\f\u00ac\3\2\2\2\16\17\5\4\3"+
		"\2\17\20\7)\2\2\20\22\3\2\2\2\21\16\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2"+
		"\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\7\2\2\3\26\3\3\2\2\2\27\30\7\21\2"+
		"\2\30\33\7\"\2\2\31\32\7\25\2\2\32\34\7\"\2\2\33\31\3\2\2\2\33\34\3\2"+
		"\2\2\34\35\3\2\2\2\35#\7\'\2\2\36\37\5\6\4\2\37 \7)\2\2 \"\3\2\2\2!\36"+
		"\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7(\2\2"+
		"\'(\b\3\1\2(\5\3\2\2\2)*\7#\2\2*\65\7%\2\2+\60\5\b\5\2,-\7.\2\2-/\5\b"+
		"\5\2.,\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\64\3\2\2\2\62"+
		"\60\3\2\2\2\63+\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668"+
		"\3\2\2\2\67\65\3\2\2\289\7&\2\29:\7*\2\2:;\7\"\2\2;<\7\'\2\2<=\5\f\7\2"+
		"=>\7(\2\2>G\3\2\2\2?@\7#\2\2@A\7*\2\2AD\7\"\2\2BC\7+\2\2CE\5\f\7\2DB\3"+
		"\2\2\2DE\3\2\2\2EG\3\2\2\2F)\3\2\2\2F?\3\2\2\2G\7\3\2\2\2HI\7#\2\2IJ\7"+
		"*\2\2JK\7\"\2\2K\t\3\2\2\2LM\7#\2\2MN\7*\2\2NQ\7\"\2\2OP\7+\2\2PR\5\f"+
		"\7\2QO\3\2\2\2QR\3\2\2\2R\13\3\2\2\2ST\b\7\1\2TU\7#\2\2U`\7%\2\2V[\5\f"+
		"\7\2WX\7.\2\2XZ\5\f\7\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\_\3"+
		"\2\2\2][\3\2\2\2^V\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3"+
		"\2\2\2c\u00ad\7&\2\2de\7\23\2\2ef\5\f\7\2fg\7\32\2\2gh\5\f\7\2hi\7\33"+
		"\2\2ij\5\f\7\2jk\7\22\2\2k\u00ad\3\2\2\2lm\7\34\2\2mn\5\f\7\2no\7\30\2"+
		"\2op\5\f\7\2pq\7\31\2\2q\u00ad\3\2\2\2rs\7\27\2\2sx\5\n\6\2tu\7.\2\2u"+
		"w\5\n\6\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2"+
		"{|\7\24\2\2|}\5\f\7\27}\u00ad\3\2\2\2~\177\7\35\2\2\177\u0080\5\f\7\2"+
		"\u0080\u0088\7 \2\2\u0081\u0082\7#\2\2\u0082\u0083\7*\2\2\u0083\u0084"+
		"\7\"\2\2\u0084\u0085\7,\2\2\u0085\u0086\5\f\7\2\u0086\u0087\7)\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0081\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\36\2\2\u008d"+
		"\u00ad\3\2\2\2\u008e\u008f\7\37\2\2\u008f\u00ad\7\"\2\2\u0090\u0091\7"+
		"-\2\2\u0091\u00ad\5\f\7\24\u0092\u0093\7\26\2\2\u0093\u00ad\5\f\7\23\u0094"+
		"\u0095\7%\2\2\u0095\u0096\5\f\7\2\u0096\u0097\7&\2\2\u0097\u00ad\3\2\2"+
		"\2\u0098\u009c\7\'\2\2\u0099\u009a\5\f\7\2\u009a\u009b\7)\2\2\u009b\u009d"+
		"\3\2\2\2\u009c\u0099\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7(\2\2\u00a1\u00ad\3\2"+
		"\2\2\u00a2\u00a3\7!\2\2\u00a3\u00ad\5\f\7\t\u00a4\u00a5\7#\2\2\u00a5\u00a6"+
		"\7+\2\2\u00a6\u00ad\5\f\7\b\u00a7\u00ad\7#\2\2\u00a8\u00ad\7$\2\2\u00a9"+
		"\u00ad\78\2\2\u00aa\u00ad\7\17\2\2\u00ab\u00ad\7\20\2\2\u00acS\3\2\2\2"+
		"\u00acd\3\2\2\2\u00acl\3\2\2\2\u00acr\3\2\2\2\u00ac~\3\2\2\2\u00ac\u008e"+
		"\3\2\2\2\u00ac\u0090\3\2\2\2\u00ac\u0092\3\2\2\2\u00ac\u0094\3\2\2\2\u00ac"+
		"\u0098\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a7\3\2"+
		"\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00db\3\2\2\2\u00ae\u00af\f\20\2\2\u00af\u00b0\7"+
		"\61\2\2\u00b0\u00da\5\f\7\21\u00b1\u00b2\f\17\2\2\u00b2\u00b3\7\64\2\2"+
		"\u00b3\u00da\5\f\7\20\u00b4\u00b5\f\16\2\2\u00b5\u00b6\7\62\2\2\u00b6"+
		"\u00da\5\f\7\17\u00b7\u00b8\f\r\2\2\u00b8\u00b9\7\63\2\2\u00b9\u00da\5"+
		"\f\7\16\u00ba\u00bb\f\f\2\2\u00bb\u00bc\7\66\2\2\u00bc\u00da\5\f\7\r\u00bd"+
		"\u00be\f\13\2\2\u00be\u00bf\7\65\2\2\u00bf\u00da\5\f\7\f\u00c0\u00c1\f"+
		"\n\2\2\u00c1\u00c2\7\67\2\2\u00c2\u00da\5\f\7\13\u00c3\u00c6\f\32\2\2"+
		"\u00c4\u00c5\7\60\2\2\u00c5\u00c7\7\"\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\7/\2\2\u00c9\u00ca\7#\2\2\u00ca"+
		"\u00d5\7%\2\2\u00cb\u00d0\5\f\7\2\u00cc\u00cd\7.\2\2\u00cd\u00cf\5\f\7"+
		"\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\7&\2\2\u00d9\u00ae\3\2\2\2\u00d9"+
		"\u00b1\3\2\2\2\u00d9\u00b4\3\2\2\2\u00d9\u00b7\3\2\2\2\u00d9\u00ba\3\2"+
		"\2\2\u00d9\u00bd\3\2\2\2\u00d9\u00c0\3\2\2\2\u00d9\u00c3\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\r\3\2\2\2"+
		"\u00dd\u00db\3\2\2\2\25\23\33#\60\65DFQ[`x\u008a\u009e\u00ac\u00c6\u00d0"+
		"\u00d5\u00d9\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}