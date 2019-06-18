// Generated from /Users/satch/IdeaProjects/StackMachine/AST.g4 by ANTLR 4.7.2
package cs143.reader;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ASTParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, CLASS=2, METHOD=3, ATTR=4, FORMAL=5, BRANCH=6, ASSIGN=7, STATIC_DISPATCH=8, 
		DISPATCH=9, COND=10, LOOP=11, TYPCASE=12, BLOCK=13, LET=14, PLUS=15, SUB=16, 
		MUL=17, DIVIDE=18, NEG=19, LT=20, EQ=21, LEQ=22, COMP=23, INT=24, STR=25, 
		BOOL=26, NEW=27, ISVOID=28, NO_EXPR=29, NO_TYPE=30, BOTTOM=31, OBJECT=32, 
		THROW=33, TRY_CATCH=34, TRY_FINALLY=35, ID=36, INT_CONST=37, LINENO=38, 
		LPAREN=39, RPAREN=40, COLON=41, STR_CONST=42, WS=43;
	public static final int
		RULE_program = 0, RULE_klass = 1, RULE_feature = 2, RULE_formal = 3, RULE_expr = 4, 
		RULE_type = 5, RULE_actuals = 6, RULE_kase = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "klass", "feature", "formal", "expr", "type", "actuals", "kase"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'_program'", "'_class'", "'_method'", "'_attr'", "'_formal'", 
			"'_branch'", "'_assign'", "'_static_dispatch'", "'_dispatch'", "'_cond'", 
			"'_loop'", "'_typcase'", "'_block'", "'_let'", "'_plus'", "'_sub'", "'_mul'", 
			"'_divide'", "'_neg'", "'_lt'", "'_eq'", "'_leq'", "'_comp'", "'_int'", 
			"'_string'", "'_bool'", "'_new'", "'_isvoid'", "'_no_expr'", "'_no_type'", 
			"'_bottom'", "'_object'", "'_throw'", "'_try_catch'", "'_try_finally'", 
			null, null, null, "'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "CLASS", "METHOD", "attr", "FORMAL", "BRANCH", "ASSIGN",
			"STATIC_DISPATCH", "DISPATCH", "COND", "LOOP", "TYPCASE", "BLOCK", "LET", 
			"PLUS", "SUB", "MUL", "DIVIDE", "NEG", "LT", "EQ", "LEQ", "COMP", "INT", 
			"STR", "BOOL", "NEW", "ISVOID", "NO_EXPR", "NO_TYPE", "BOTTOM", "OBJECT", 
			"THROW", "TRY_CATCH", "TRY_FINALLY", "ID", "INT_CONST", "LINENO", "LPAREN", 
			"RPAREN", "COLON", "STR_CONST", "WS"
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
	public String getGrammarFileName() { return "AST.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ASTParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode PROGRAM() { return getToken(ASTParser.PROGRAM, 0); }
		public List<KlassContext> klass() {
			return getRuleContexts(KlassContext.class);
		}
		public KlassContext klass(int i) {
			return getRuleContext(KlassContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(16);
			match(LINENO);
			setState(17);
			match(PROGRAM);
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				klass();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LINENO );
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
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode CLASS() { return getToken(ASTParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public TerminalNode STR_CONST() { return getToken(ASTParser.STR_CONST, 0); }
		public TerminalNode LPAREN() { return getToken(ASTParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ASTParser.RPAREN, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public KlassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitKlass(this);
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
			setState(23);
			match(LINENO);
			setState(24);
			match(CLASS);
			setState(25);
			match(ID);
			setState(26);
			match(ID);
			setState(27);
			match(STR_CONST);
			setState(28);
			match(LPAREN);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINENO) {
				{
				{
				setState(29);
				feature();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			match(RPAREN);
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
	public static class MethodFeatureContext extends FeatureContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode METHOD() { return getToken(ASTParser.METHOD, 0); }
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public MethodFeatureContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitMethodFeature(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttrFeatureContext extends FeatureContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode ATTR() { return getToken(ASTParser.ATTR, 0); }
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AttrFeatureContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitAttrFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new MethodFeatureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(LINENO);
				setState(38);
				match(METHOD);
				setState(39);
				match(ID);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINENO) {
					{
					{
					setState(40);
					formal();
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46);
				match(ID);
				setState(47);
				expr();
				}
				break;
			case 2:
				_localctx = new AttrFeatureContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(LINENO);
				setState(49);
				match(ATTR);
				setState(50);
				match(ID);
				setState(51);
				match(ID);
				setState(52);
				expr();
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
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode FORMAL() { return getToken(ASTParser.FORMAL, 0); }
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(LINENO);
			setState(56);
			match(FORMAL);
			setState(57);
			match(ID);
			setState(58);
			match(ID);
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
	public static class DispatchExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode DISPATCH() { return getToken(ASTParser.DISPATCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(ASTParser.ID, 0); }
		public ActualsContext actuals() {
			return getRuleContext(ActualsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DispatchExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitDispatchExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode NEW() { return getToken(ASTParser.NEW, 0); }
		public TerminalNode ID() { return getToken(ASTParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode STR() { return getToken(ASTParser.STR, 0); }
		public TerminalNode STR_CONST() { return getToken(ASTParser.STR_CONST, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitStrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode DIVIDE() { return getToken(ASTParser.DIVIDE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DivideExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitDivideExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode OBJECT() { return getToken(ASTParser.OBJECT, 0); }
		public TerminalNode ID() { return getToken(ASTParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ObjectExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitObjectExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode COND() { return getToken(ASTParser.COND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CondExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode SUB() { return getToken(ASTParser.SUB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode LET() { return getToken(ASTParser.LET, 0); }
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LetExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitLetExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypCaseExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode TYPCASE() { return getToken(ASTParser.TYPCASE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<KaseContext> kase() {
			return getRuleContexts(KaseContext.class);
		}
		public KaseContext kase(int i) {
			return getRuleContext(KaseContext.class,i);
		}
		public TypCaseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitTypCaseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode LT() { return getToken(ASTParser.LT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitLtExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsVoidExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode ISVOID() { return getToken(ASTParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IsVoidExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitIsVoidExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode COMP() { return getToken(ASTParser.COMP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode MUL() { return getToken(ASTParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MulExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode BLOCK() { return getToken(ASTParser.BLOCK, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitBlockExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode ASSIGN() { return getToken(ASTParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(ASTParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThrowExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode THROW() { return getToken(ASTParser.THROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ThrowExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitThrowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode INT() { return getToken(ASTParser.INT, 0); }
		public TerminalNode INT_CONST() { return getToken(ASTParser.INT_CONST, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StaticDispatchExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode STATIC_DISPATCH() { return getToken(ASTParser.STATIC_DISPATCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public ActualsContext actuals() {
			return getRuleContext(ActualsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StaticDispatchExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitStaticDispatchExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode PLUS() { return getToken(ASTParser.PLUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TryCatchExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode TRY_CATCH() { return getToken(ASTParser.TRY_CATCH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(ASTParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TryCatchExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitTryCatchExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoopExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode LOOP() { return getToken(ASTParser.LOOP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LoopExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitLoopExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode EQ() { return getToken(ASTParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoExprExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode NO_EXPR() { return getToken(ASTParser.NO_EXPR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NoExprExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitNoExprExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TryFinallyExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode TRY_FINALLY() { return getToken(ASTParser.TRY_FINALLY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TryFinallyExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitTryFinallyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode NEG() { return getToken(ASTParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NegExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitNegExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeqExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode LEQ() { return getToken(ASTParser.LEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitLeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode BOOL() { return getToken(ASTParser.BOOL, 0); }
		public TerminalNode INT_CONST() { return getToken(ASTParser.INT_CONST, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AssignExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(LINENO);
				setState(61);
				match(ASSIGN);
				setState(62);
				match(ID);
				setState(63);
				expr();
				setState(64);
				type();
				}
				break;
			case 2:
				_localctx = new StaticDispatchExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(LINENO);
				setState(67);
				match(STATIC_DISPATCH);
				setState(68);
				expr();
				setState(69);
				match(ID);
				setState(70);
				match(ID);
				setState(71);
				actuals();
				setState(72);
				type();
				}
				break;
			case 3:
				_localctx = new DispatchExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(LINENO);
				setState(75);
				match(DISPATCH);
				setState(76);
				expr();
				setState(77);
				match(ID);
				setState(78);
				actuals();
				setState(79);
				type();
				}
				break;
			case 4:
				_localctx = new CondExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				match(LINENO);
				setState(82);
				match(COND);
				setState(83);
				expr();
				setState(84);
				expr();
				setState(85);
				expr();
				setState(86);
				type();
				}
				break;
			case 5:
				_localctx = new LoopExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				match(LINENO);
				setState(89);
				match(LOOP);
				setState(90);
				expr();
				setState(91);
				expr();
				setState(92);
				type();
				}
				break;
			case 6:
				_localctx = new BlockExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(LINENO);
				setState(95);
				match(BLOCK);
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(96);
					expr();
					}
					}
					setState(99); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LINENO );
				setState(101);
				type();
				}
				break;
			case 7:
				_localctx = new LetExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(103);
				match(LINENO);
				setState(104);
				match(LET);
				setState(105);
				match(ID);
				setState(106);
				match(ID);
				setState(107);
				expr();
				setState(108);
				expr();
				setState(109);
				type();
				}
				break;
			case 8:
				_localctx = new TypCaseExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(111);
				match(LINENO);
				setState(112);
				match(TYPCASE);
				setState(113);
				expr();
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(114);
					kase();
					}
					}
					setState(117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LINENO );
				setState(119);
				type();
				}
				break;
			case 9:
				_localctx = new NewExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(121);
				match(LINENO);
				setState(122);
				match(NEW);
				setState(123);
				match(ID);
				setState(124);
				type();
				}
				break;
			case 10:
				_localctx = new IsVoidExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(125);
				match(LINENO);
				setState(126);
				match(ISVOID);
				setState(127);
				expr();
				setState(128);
				type();
				}
				break;
			case 11:
				_localctx = new PlusExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(130);
				match(LINENO);
				setState(131);
				match(PLUS);
				setState(132);
				expr();
				setState(133);
				expr();
				setState(134);
				type();
				}
				break;
			case 12:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(136);
				match(LINENO);
				setState(137);
				match(SUB);
				setState(138);
				expr();
				setState(139);
				expr();
				setState(140);
				type();
				}
				break;
			case 13:
				_localctx = new MulExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(142);
				match(LINENO);
				setState(143);
				match(MUL);
				setState(144);
				expr();
				setState(145);
				expr();
				setState(146);
				type();
				}
				break;
			case 14:
				_localctx = new DivideExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(148);
				match(LINENO);
				setState(149);
				match(DIVIDE);
				setState(150);
				expr();
				setState(151);
				expr();
				setState(152);
				type();
				}
				break;
			case 15:
				_localctx = new NegExprContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(154);
				match(LINENO);
				setState(155);
				match(NEG);
				setState(156);
				expr();
				setState(157);
				type();
				}
				break;
			case 16:
				_localctx = new LtExprContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(159);
				match(LINENO);
				setState(160);
				match(LT);
				setState(161);
				expr();
				setState(162);
				expr();
				setState(163);
				type();
				}
				break;
			case 17:
				_localctx = new EqExprContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(165);
				match(LINENO);
				setState(166);
				match(EQ);
				setState(167);
				expr();
				setState(168);
				expr();
				setState(169);
				type();
				}
				break;
			case 18:
				_localctx = new LeqExprContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(171);
				match(LINENO);
				setState(172);
				match(LEQ);
				setState(173);
				expr();
				setState(174);
				expr();
				setState(175);
				type();
				}
				break;
			case 19:
				_localctx = new CompExprContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(177);
				match(LINENO);
				setState(178);
				match(COMP);
				setState(179);
				expr();
				setState(180);
				type();
				}
				break;
			case 20:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(182);
				match(LINENO);
				setState(183);
				match(INT);
				setState(184);
				match(INT_CONST);
				setState(185);
				type();
				}
				break;
			case 21:
				_localctx = new StrExprContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(186);
				match(LINENO);
				setState(187);
				match(STR);
				setState(188);
				match(STR_CONST);
				setState(189);
				type();
				}
				break;
			case 22:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(190);
				match(LINENO);
				setState(191);
				match(BOOL);
				setState(192);
				match(INT_CONST);
				setState(193);
				type();
				}
				break;
			case 23:
				_localctx = new ObjectExprContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(194);
				match(LINENO);
				setState(195);
				match(OBJECT);
				setState(196);
				match(ID);
				setState(197);
				type();
				}
				break;
			case 24:
				_localctx = new NoExprExprContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(198);
				match(LINENO);
				setState(199);
				match(NO_EXPR);
				setState(200);
				type();
				}
				break;
			case 25:
				_localctx = new ThrowExprContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(201);
				match(LINENO);
				setState(202);
				match(THROW);
				setState(203);
				expr();
				setState(204);
				type();
				}
				break;
			case 26:
				_localctx = new TryCatchExprContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(206);
				match(LINENO);
				setState(207);
				match(TRY_CATCH);
				setState(208);
				expr();
				setState(209);
				match(ID);
				setState(210);
				expr();
				setState(211);
				type();
				}
				break;
			case 27:
				_localctx = new TryFinallyExprContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(213);
				match(LINENO);
				setState(214);
				match(TRY_FINALLY);
				setState(215);
				expr();
				setState(216);
				expr();
				setState(217);
				type();
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeNoTypeContext extends TypeContext {
		public TerminalNode COLON() { return getToken(ASTParser.COLON, 0); }
		public TerminalNode NO_TYPE() { return getToken(ASTParser.NO_TYPE, 0); }
		public TypeNoTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitTypeNoType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeTypeContext extends TypeContext {
		public TerminalNode COLON() { return getToken(ASTParser.COLON, 0); }
		public TerminalNode ID() { return getToken(ASTParser.ID, 0); }
		public TypeTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeBottomContext extends TypeContext {
		public TerminalNode COLON() { return getToken(ASTParser.COLON, 0); }
		public TerminalNode BOTTOM() { return getToken(ASTParser.BOTTOM, 0); }
		public TypeBottomContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitTypeBottom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new TypeTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(COLON);
				setState(222);
				match(ID);
				}
				break;
			case 2:
				_localctx = new TypeNoTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(COLON);
				setState(224);
				match(NO_TYPE);
				}
				break;
			case 3:
				_localctx = new TypeBottomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				match(COLON);
				setState(226);
				match(BOTTOM);
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

	public static class ActualsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ASTParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ASTParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ActualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitActuals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualsContext actuals() throws RecognitionException {
		ActualsContext _localctx = new ActualsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_actuals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(LPAREN);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINENO) {
				{
				{
				setState(230);
				expr();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
			match(RPAREN);
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

	public static class KaseContext extends ParserRuleContext {
		public TerminalNode LINENO() { return getToken(ASTParser.LINENO, 0); }
		public TerminalNode BRANCH() { return getToken(ASTParser.BRANCH, 0); }
		public List<TerminalNode> ID() { return getTokens(ASTParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ASTParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public KaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ASTVisitor ) return ((ASTVisitor<? extends T>)visitor).visitKase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KaseContext kase() throws RecognitionException {
		KaseContext _localctx = new KaseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_kase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(LINENO);
			setState(239);
			match(BRANCH);
			setState(240);
			match(ID);
			setState(241);
			match(ID);
			setState(242);
			expr();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00f7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\6\2"+
		"\26\n\2\r\2\16\2\27\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6d\n\6\r\6\16\6e\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6v\n\6\r\6\16\6"+
		"w\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00de\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u00e6\n\7\3\b\3\b\7\b\u00ea\n\b\f\b\16\b\u00ed"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2"+
		"\2\u0111\2\22\3\2\2\2\4\31\3\2\2\2\6\67\3\2\2\2\b9\3\2\2\2\n\u00dd\3\2"+
		"\2\2\f\u00e5\3\2\2\2\16\u00e7\3\2\2\2\20\u00f0\3\2\2\2\22\23\7(\2\2\23"+
		"\25\7\3\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27"+
		"\30\3\2\2\2\30\3\3\2\2\2\31\32\7(\2\2\32\33\7\4\2\2\33\34\7&\2\2\34\35"+
		"\7&\2\2\35\36\7,\2\2\36\"\7)\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3\2\2\2\" "+
		"\3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7*\2\2&\5\3\2\2\2\'(\7(\2\2"+
		"()\7\5\2\2)-\7&\2\2*,\5\b\5\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2"+
		".\60\3\2\2\2/-\3\2\2\2\60\61\7&\2\2\618\5\n\6\2\62\63\7(\2\2\63\64\7\6"+
		"\2\2\64\65\7&\2\2\65\66\7&\2\2\668\5\n\6\2\67\'\3\2\2\2\67\62\3\2\2\2"+
		"8\7\3\2\2\29:\7(\2\2:;\7\7\2\2;<\7&\2\2<=\7&\2\2=\t\3\2\2\2>?\7(\2\2?"+
		"@\7\t\2\2@A\7&\2\2AB\5\n\6\2BC\5\f\7\2C\u00de\3\2\2\2DE\7(\2\2EF\7\n\2"+
		"\2FG\5\n\6\2GH\7&\2\2HI\7&\2\2IJ\5\16\b\2JK\5\f\7\2K\u00de\3\2\2\2LM\7"+
		"(\2\2MN\7\13\2\2NO\5\n\6\2OP\7&\2\2PQ\5\16\b\2QR\5\f\7\2R\u00de\3\2\2"+
		"\2ST\7(\2\2TU\7\f\2\2UV\5\n\6\2VW\5\n\6\2WX\5\n\6\2XY\5\f\7\2Y\u00de\3"+
		"\2\2\2Z[\7(\2\2[\\\7\r\2\2\\]\5\n\6\2]^\5\n\6\2^_\5\f\7\2_\u00de\3\2\2"+
		"\2`a\7(\2\2ac\7\17\2\2bd\5\n\6\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2"+
		"\2fg\3\2\2\2gh\5\f\7\2h\u00de\3\2\2\2ij\7(\2\2jk\7\20\2\2kl\7&\2\2lm\7"+
		"&\2\2mn\5\n\6\2no\5\n\6\2op\5\f\7\2p\u00de\3\2\2\2qr\7(\2\2rs\7\16\2\2"+
		"su\5\n\6\2tv\5\20\t\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2"+
		"\2yz\5\f\7\2z\u00de\3\2\2\2{|\7(\2\2|}\7\35\2\2}~\7&\2\2~\u00de\5\f\7"+
		"\2\177\u0080\7(\2\2\u0080\u0081\7\36\2\2\u0081\u0082\5\n\6\2\u0082\u0083"+
		"\5\f\7\2\u0083\u00de\3\2\2\2\u0084\u0085\7(\2\2\u0085\u0086\7\21\2\2\u0086"+
		"\u0087\5\n\6\2\u0087\u0088\5\n\6\2\u0088\u0089\5\f\7\2\u0089\u00de\3\2"+
		"\2\2\u008a\u008b\7(\2\2\u008b\u008c\7\22\2\2\u008c\u008d\5\n\6\2\u008d"+
		"\u008e\5\n\6\2\u008e\u008f\5\f\7\2\u008f\u00de\3\2\2\2\u0090\u0091\7("+
		"\2\2\u0091\u0092\7\23\2\2\u0092\u0093\5\n\6\2\u0093\u0094\5\n\6\2\u0094"+
		"\u0095\5\f\7\2\u0095\u00de\3\2\2\2\u0096\u0097\7(\2\2\u0097\u0098\7\24"+
		"\2\2\u0098\u0099\5\n\6\2\u0099\u009a\5\n\6\2\u009a\u009b\5\f\7\2\u009b"+
		"\u00de\3\2\2\2\u009c\u009d\7(\2\2\u009d\u009e\7\25\2\2\u009e\u009f\5\n"+
		"\6\2\u009f\u00a0\5\f\7\2\u00a0\u00de\3\2\2\2\u00a1\u00a2\7(\2\2\u00a2"+
		"\u00a3\7\26\2\2\u00a3\u00a4\5\n\6\2\u00a4\u00a5\5\n\6\2\u00a5\u00a6\5"+
		"\f\7\2\u00a6\u00de\3\2\2\2\u00a7\u00a8\7(\2\2\u00a8\u00a9\7\27\2\2\u00a9"+
		"\u00aa\5\n\6\2\u00aa\u00ab\5\n\6\2\u00ab\u00ac\5\f\7\2\u00ac\u00de\3\2"+
		"\2\2\u00ad\u00ae\7(\2\2\u00ae\u00af\7\30\2\2\u00af\u00b0\5\n\6\2\u00b0"+
		"\u00b1\5\n\6\2\u00b1\u00b2\5\f\7\2\u00b2\u00de\3\2\2\2\u00b3\u00b4\7("+
		"\2\2\u00b4\u00b5\7\31\2\2\u00b5\u00b6\5\n\6\2\u00b6\u00b7\5\f\7\2\u00b7"+
		"\u00de\3\2\2\2\u00b8\u00b9\7(\2\2\u00b9\u00ba\7\32\2\2\u00ba\u00bb\7\'"+
		"\2\2\u00bb\u00de\5\f\7\2\u00bc\u00bd\7(\2\2\u00bd\u00be\7\33\2\2\u00be"+
		"\u00bf\7,\2\2\u00bf\u00de\5\f\7\2\u00c0\u00c1\7(\2\2\u00c1\u00c2\7\34"+
		"\2\2\u00c2\u00c3\7\'\2\2\u00c3\u00de\5\f\7\2\u00c4\u00c5\7(\2\2\u00c5"+
		"\u00c6\7\"\2\2\u00c6\u00c7\7&\2\2\u00c7\u00de\5\f\7\2\u00c8\u00c9\7(\2"+
		"\2\u00c9\u00ca\7\37\2\2\u00ca\u00de\5\f\7\2\u00cb\u00cc\7(\2\2\u00cc\u00cd"+
		"\7#\2\2\u00cd\u00ce\5\n\6\2\u00ce\u00cf\5\f\7\2\u00cf\u00de\3\2\2\2\u00d0"+
		"\u00d1\7(\2\2\u00d1\u00d2\7$\2\2\u00d2\u00d3\5\n\6\2\u00d3\u00d4\7&\2"+
		"\2\u00d4\u00d5\5\n\6\2\u00d5\u00d6\5\f\7\2\u00d6\u00de\3\2\2\2\u00d7\u00d8"+
		"\7(\2\2\u00d8\u00d9\7%\2\2\u00d9\u00da\5\n\6\2\u00da\u00db\5\n\6\2\u00db"+
		"\u00dc\5\f\7\2\u00dc\u00de\3\2\2\2\u00dd>\3\2\2\2\u00ddD\3\2\2\2\u00dd"+
		"L\3\2\2\2\u00ddS\3\2\2\2\u00ddZ\3\2\2\2\u00dd`\3\2\2\2\u00ddi\3\2\2\2"+
		"\u00ddq\3\2\2\2\u00dd{\3\2\2\2\u00dd\177\3\2\2\2\u00dd\u0084\3\2\2\2\u00dd"+
		"\u008a\3\2\2\2\u00dd\u0090\3\2\2\2\u00dd\u0096\3\2\2\2\u00dd\u009c\3\2"+
		"\2\2\u00dd\u00a1\3\2\2\2\u00dd\u00a7\3\2\2\2\u00dd\u00ad\3\2\2\2\u00dd"+
		"\u00b3\3\2\2\2\u00dd\u00b8\3\2\2\2\u00dd\u00bc\3\2\2\2\u00dd\u00c0\3\2"+
		"\2\2\u00dd\u00c4\3\2\2\2\u00dd\u00c8\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd"+
		"\u00d0\3\2\2\2\u00dd\u00d7\3\2\2\2\u00de\13\3\2\2\2\u00df\u00e0\7+\2\2"+
		"\u00e0\u00e6\7&\2\2\u00e1\u00e2\7+\2\2\u00e2\u00e6\7 \2\2\u00e3\u00e4"+
		"\7+\2\2\u00e4\u00e6\7!\2\2\u00e5\u00df\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e6\r\3\2\2\2\u00e7\u00eb\7)\2\2\u00e8\u00ea\5\n\6\2"+
		"\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7*\2\2\u00ef"+
		"\17\3\2\2\2\u00f0\u00f1\7(\2\2\u00f1\u00f2\7\b\2\2\u00f2\u00f3\7&\2\2"+
		"\u00f3\u00f4\7&\2\2\u00f4\u00f5\5\n\6\2\u00f5\21\3\2\2\2\13\27\"-\67e"+
		"w\u00dd\u00e5\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}