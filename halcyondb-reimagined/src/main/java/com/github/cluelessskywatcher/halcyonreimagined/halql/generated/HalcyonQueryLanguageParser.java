// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HalcyonQueryLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, KWORD_INSERT=6, KWORD_NEW=7, KWORD_SELECT=8, 
		KWORD_FROM=9, KWORD_INTO=10, KWORD_VALUES=11, Q_MARK=12, ASTERISK=13, 
		IDENTIFIER=14, QUOTED=15, NUMBER=16, FLOAT=17, INTEGER=18, WS=19;
	public static final int
		RULE_halqlEntryPoint = 0, RULE_halqlStatement = 1, RULE_halqlDmlStatement = 2, 
		RULE_halqlDdlStatement = 3, RULE_halqlDqlStatement = 4, RULE_insertRowStatement = 5, 
		RULE_selectTableStatement = 6, RULE_tableIdentifier = 7, RULE_identifier = 8, 
		RULE_values = 9, RULE_constValue = 10;
	public static final String[] ruleNames = {
		"halqlEntryPoint", "halqlStatement", "halqlDmlStatement", "halqlDdlStatement", 
		"halqlDqlStatement", "insertRowStatement", "selectTableStatement", "tableIdentifier", 
		"identifier", "values", "constValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'.'", "','", null, null, null, null, null, 
		null, "'?'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "KWORD_INSERT", "KWORD_NEW", "KWORD_SELECT", 
		"KWORD_FROM", "KWORD_INTO", "KWORD_VALUES", "Q_MARK", "ASTERISK", "IDENTIFIER", 
		"QUOTED", "NUMBER", "FLOAT", "INTEGER", "WS"
	};
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
	public String getGrammarFileName() { return "HalcyonQueryLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HalcyonQueryLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class HalqlEntryPointContext extends ParserRuleContext {
		public HalqlStatementContext halqlStatement() {
			return getRuleContext(HalqlStatementContext.class,0);
		}
		public HalqlEntryPointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halqlEntryPoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterHalqlEntryPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitHalqlEntryPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitHalqlEntryPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalqlEntryPointContext halqlEntryPoint() throws RecognitionException {
		HalqlEntryPointContext _localctx = new HalqlEntryPointContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_halqlEntryPoint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			halqlStatement();
			setState(23);
			match(T__0);
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

	public static class HalqlStatementContext extends ParserRuleContext {
		public HalqlDmlStatementContext halqlDmlStatement() {
			return getRuleContext(HalqlDmlStatementContext.class,0);
		}
		public HalqlDdlStatementContext halqlDdlStatement() {
			return getRuleContext(HalqlDdlStatementContext.class,0);
		}
		public HalqlDqlStatementContext halqlDqlStatement() {
			return getRuleContext(HalqlDqlStatementContext.class,0);
		}
		public HalqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterHalqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitHalqlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitHalqlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalqlStatementContext halqlStatement() throws RecognitionException {
		HalqlStatementContext _localctx = new HalqlStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_halqlStatement);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KWORD_INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				halqlDmlStatement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				halqlDdlStatement();
				}
				break;
			case KWORD_SELECT:
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				halqlDqlStatement();
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

	public static class HalqlDmlStatementContext extends ParserRuleContext {
		public InsertRowStatementContext insertRowStatement() {
			return getRuleContext(InsertRowStatementContext.class,0);
		}
		public HalqlDmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halqlDmlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterHalqlDmlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitHalqlDmlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitHalqlDmlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalqlDmlStatementContext halqlDmlStatement() throws RecognitionException {
		HalqlDmlStatementContext _localctx = new HalqlDmlStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_halqlDmlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			insertRowStatement();
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

	public static class HalqlDdlStatementContext extends ParserRuleContext {
		public HalqlDdlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halqlDdlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterHalqlDdlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitHalqlDdlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitHalqlDdlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalqlDdlStatementContext halqlDdlStatement() throws RecognitionException {
		HalqlDdlStatementContext _localctx = new HalqlDdlStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_halqlDdlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class HalqlDqlStatementContext extends ParserRuleContext {
		public SelectTableStatementContext selectTableStatement() {
			return getRuleContext(SelectTableStatementContext.class,0);
		}
		public HalqlDqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halqlDqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterHalqlDqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitHalqlDqlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitHalqlDqlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HalqlDqlStatementContext halqlDqlStatement() throws RecognitionException {
		HalqlDqlStatementContext _localctx = new HalqlDqlStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_halqlDqlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			selectTableStatement();
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

	public static class InsertRowStatementContext extends ParserRuleContext {
		public TerminalNode KWORD_INSERT() { return getToken(HalcyonQueryLanguageParser.KWORD_INSERT, 0); }
		public TerminalNode KWORD_INTO() { return getToken(HalcyonQueryLanguageParser.KWORD_INTO, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode KWORD_VALUES() { return getToken(HalcyonQueryLanguageParser.KWORD_VALUES, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public InsertRowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertRowStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterInsertRowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitInsertRowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitInsertRowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertRowStatementContext insertRowStatement() throws RecognitionException {
		InsertRowStatementContext _localctx = new InsertRowStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_insertRowStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(KWORD_INSERT);
			setState(37);
			match(KWORD_INTO);
			setState(38);
			tableIdentifier();
			setState(39);
			match(KWORD_VALUES);
			setState(40);
			match(T__1);
			setState(41);
			values();
			setState(42);
			match(T__2);
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

	public static class SelectTableStatementContext extends ParserRuleContext {
		public TerminalNode KWORD_SELECT() { return getToken(HalcyonQueryLanguageParser.KWORD_SELECT, 0); }
		public TerminalNode ASTERISK() { return getToken(HalcyonQueryLanguageParser.ASTERISK, 0); }
		public TerminalNode KWORD_FROM() { return getToken(HalcyonQueryLanguageParser.KWORD_FROM, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public SelectTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterSelectTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitSelectTableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitSelectTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectTableStatementContext selectTableStatement() throws RecognitionException {
		SelectTableStatementContext _localctx = new SelectTableStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(KWORD_SELECT);
			setState(45);
			match(ASTERISK);
			setState(46);
			match(KWORD_FROM);
			setState(47);
			tableIdentifier();
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

	public static class TableIdentifierContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterTableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitTableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitTableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIdentifierContext tableIdentifier() throws RecognitionException {
		TableIdentifierContext _localctx = new TableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			((TableIdentifierContext)_localctx).name = identifier();
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

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(HalcyonQueryLanguageParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(HalcyonQueryLanguageParser.IDENTIFIER, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identifier);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(IDENTIFIER);
				setState(52);
				match(T__3);
				setState(53);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(IDENTIFIER);
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

	public static class ValuesContext extends ParserRuleContext {
		public List<String> valueList;
		public ConstValueContext a;
		public ConstValueContext b;
		public List<ConstValueContext> constValue() {
			return getRuleContexts(ConstValueContext.class);
		}
		public ConstValueContext constValue(int i) {
			return getRuleContext(ConstValueContext.class,i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_values);

		        ((ValuesContext)_localctx).valueList =  new ArrayList<String>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((ValuesContext)_localctx).a = constValue();
			 _localctx.valueList.add(((ValuesContext)_localctx).a.value); 
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(59);
				match(T__4);
				setState(60);
				((ValuesContext)_localctx).b = constValue();
				 _localctx.valueList.add(((ValuesContext)_localctx).b.value); 
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ConstValueContext extends ParserRuleContext {
		public String value;
		public Token NUMBER;
		public Token QUOTED;
		public TerminalNode NUMBER() { return getToken(HalcyonQueryLanguageParser.NUMBER, 0); }
		public TerminalNode QUOTED() { return getToken(HalcyonQueryLanguageParser.QUOTED, 0); }
		public ConstValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterConstValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitConstValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitConstValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstValueContext constValue() throws RecognitionException {
		ConstValueContext _localctx = new ConstValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constValue);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((ConstValueContext)_localctx).NUMBER = match(NUMBER);
				 ((ConstValueContext)_localctx).value =  (((ConstValueContext)_localctx).NUMBER!=null?((ConstValueContext)_localctx).NUMBER.getText():null); 
				}
				break;
			case QUOTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				((ConstValueContext)_localctx).QUOTED = match(QUOTED);
				 ((ConstValueContext)_localctx).value =  (((ConstValueContext)_localctx).QUOTED!=null?((ConstValueContext)_localctx).QUOTED.getText():null); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25M\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\5\n:\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13B\n\13\f\13\16\13E\13\13"+
		"\3\f\3\f\3\f\3\f\5\fK\n\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2F"+
		"\2\30\3\2\2\2\4\36\3\2\2\2\6 \3\2\2\2\b\"\3\2\2\2\n$\3\2\2\2\f&\3\2\2"+
		"\2\16.\3\2\2\2\20\63\3\2\2\2\229\3\2\2\2\24;\3\2\2\2\26J\3\2\2\2\30\31"+
		"\5\4\3\2\31\32\7\3\2\2\32\3\3\2\2\2\33\37\5\6\4\2\34\37\5\b\5\2\35\37"+
		"\5\n\6\2\36\33\3\2\2\2\36\34\3\2\2\2\36\35\3\2\2\2\37\5\3\2\2\2 !\5\f"+
		"\7\2!\7\3\2\2\2\"#\3\2\2\2#\t\3\2\2\2$%\5\16\b\2%\13\3\2\2\2&\'\7\b\2"+
		"\2\'(\7\f\2\2()\5\20\t\2)*\7\r\2\2*+\7\4\2\2+,\5\24\13\2,-\7\5\2\2-\r"+
		"\3\2\2\2./\7\n\2\2/\60\7\17\2\2\60\61\7\13\2\2\61\62\5\20\t\2\62\17\3"+
		"\2\2\2\63\64\5\22\n\2\64\21\3\2\2\2\65\66\7\20\2\2\66\67\7\6\2\2\67:\7"+
		"\20\2\28:\7\20\2\29\65\3\2\2\298\3\2\2\2:\23\3\2\2\2;<\5\26\f\2<C\b\13"+
		"\1\2=>\7\7\2\2>?\5\26\f\2?@\b\13\1\2@B\3\2\2\2A=\3\2\2\2BE\3\2\2\2CA\3"+
		"\2\2\2CD\3\2\2\2D\25\3\2\2\2EC\3\2\2\2FG\7\22\2\2GK\b\f\1\2HI\7\21\2\2"+
		"IK\b\f\1\2JF\3\2\2\2JH\3\2\2\2K\27\3\2\2\2\6\369CJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}