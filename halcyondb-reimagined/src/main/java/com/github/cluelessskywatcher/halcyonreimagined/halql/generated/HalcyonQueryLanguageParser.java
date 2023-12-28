// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import java.util.*;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TYPE_INT=6, TYPE_STRING=7, KWORD_INSERT=8, 
		KWORD_CREATE=9, KWORD_SELECT=10, KWORD_FROM=11, KWORD_INTO=12, KWORD_VALUES=13, 
		KWORD_TABLE=14, KWORD_WITH=15, Q_MARK=16, ASTERISK=17, IDENTIFIER=18, 
		QUOTED=19, NUMBER=20, FLOAT=21, INTEGER=22, WS=23;
	public static final int
		RULE_halqlEntryPoint = 0, RULE_halqlStatement = 1, RULE_halqlDmlStatement = 2, 
		RULE_halqlDdlStatement = 3, RULE_halqlDqlStatement = 4, RULE_insertRowStatement = 5, 
		RULE_createTableStatement = 6, RULE_selectTableStatement = 7, RULE_tableIdentifier = 8, 
		RULE_fieldIdentifier = 9, RULE_identifier = 10, RULE_tableDefinition = 11, 
		RULE_fieldDefinition = 12, RULE_values = 13, RULE_constValue = 14, RULE_dataType = 15;
	public static final String[] ruleNames = {
		"halqlEntryPoint", "halqlStatement", "halqlDmlStatement", "halqlDdlStatement", 
		"halqlDqlStatement", "insertRowStatement", "createTableStatement", "selectTableStatement", 
		"tableIdentifier", "fieldIdentifier", "identifier", "tableDefinition", 
		"fieldDefinition", "values", "constValue", "dataType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'.'", "','", null, null, null, null, null, 
		null, null, null, null, null, "'?'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "TYPE_INT", "TYPE_STRING", "KWORD_INSERT", 
		"KWORD_CREATE", "KWORD_SELECT", "KWORD_FROM", "KWORD_INTO", "KWORD_VALUES", 
		"KWORD_TABLE", "KWORD_WITH", "Q_MARK", "ASTERISK", "IDENTIFIER", "QUOTED", 
		"NUMBER", "FLOAT", "INTEGER", "WS"
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


	    class FieldDef {
	        public String fieldId;
	        public DataType dataType;

	        public FieldDef(String fieldName, DataType dataType) {
	            this.fieldId = fieldName;
	            this.dataType = dataType;
	        }
	    }

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
			setState(32);
			halqlStatement();
			setState(33);
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
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KWORD_INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				halqlDmlStatement();
				}
				break;
			case KWORD_CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				halqlDdlStatement();
				}
				break;
			case KWORD_SELECT:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
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
			setState(40);
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
		public CreateTableStatementContext createTableStatement() {
			return getRuleContext(CreateTableStatementContext.class,0);
		}
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
			setState(42);
			createTableStatement();
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
			setState(44);
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
			setState(46);
			match(KWORD_INSERT);
			setState(47);
			match(KWORD_INTO);
			setState(48);
			tableIdentifier();
			setState(49);
			match(KWORD_VALUES);
			setState(50);
			match(T__1);
			setState(51);
			values();
			setState(52);
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

	public static class CreateTableStatementContext extends ParserRuleContext {
		public TerminalNode KWORD_CREATE() { return getToken(HalcyonQueryLanguageParser.KWORD_CREATE, 0); }
		public TerminalNode KWORD_TABLE() { return getToken(HalcyonQueryLanguageParser.KWORD_TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode KWORD_WITH() { return getToken(HalcyonQueryLanguageParser.KWORD_WITH, 0); }
		public TableDefinitionContext tableDefinition() {
			return getRuleContext(TableDefinitionContext.class,0);
		}
		public CreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterCreateTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitCreateTableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitCreateTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_createTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(KWORD_CREATE);
			setState(55);
			match(KWORD_TABLE);
			setState(56);
			tableIdentifier();
			setState(57);
			match(KWORD_WITH);
			setState(58);
			match(T__1);
			setState(59);
			tableDefinition();
			setState(60);
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
		public TerminalNode KWORD_WITH() { return getToken(HalcyonQueryLanguageParser.KWORD_WITH, 0); }
		public TableDefinitionContext tableDefinition() {
			return getRuleContext(TableDefinitionContext.class,0);
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
		enterRule(_localctx, 14, RULE_selectTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(KWORD_SELECT);
			setState(63);
			match(ASTERISK);
			setState(64);
			match(KWORD_FROM);
			setState(65);
			tableIdentifier();
			setState(66);
			match(KWORD_WITH);
			setState(67);
			match(T__1);
			setState(68);
			tableDefinition();
			setState(69);
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

	public static class TableIdentifierContext extends ParserRuleContext {
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
		enterRule(_localctx, 16, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			identifier();
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

	public static class FieldIdentifierContext extends ParserRuleContext {
		public String fieldId;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(HalcyonQueryLanguageParser.IDENTIFIER, 0); }
		public FieldIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterFieldIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitFieldIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitFieldIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldIdentifierContext fieldIdentifier() throws RecognitionException {
		FieldIdentifierContext _localctx = new FieldIdentifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fieldIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((FieldIdentifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 ((FieldIdentifierContext)_localctx).fieldId =  (((FieldIdentifierContext)_localctx).IDENTIFIER!=null?((FieldIdentifierContext)_localctx).IDENTIFIER.getText():null); 
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
		enterRule(_localctx, 20, RULE_identifier);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(IDENTIFIER);
				setState(77);
				match(T__3);
				setState(78);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
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

	public static class TableDefinitionContext extends ParserRuleContext {
		public Map<String, DataType> tableDef;
		public FieldDefinitionContext a;
		public FieldDefinitionContext b;
		public List<FieldDefinitionContext> fieldDefinition() {
			return getRuleContexts(FieldDefinitionContext.class);
		}
		public FieldDefinitionContext fieldDefinition(int i) {
			return getRuleContext(FieldDefinitionContext.class,i);
		}
		public TableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterTableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitTableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitTableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableDefinitionContext tableDefinition() throws RecognitionException {
		TableDefinitionContext _localctx = new TableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tableDefinition);

		        ((TableDefinitionContext)_localctx).tableDef =  new LinkedHashMap<String, DataType>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((TableDefinitionContext)_localctx).a = fieldDefinition();
			 _localctx.tableDef.put(((TableDefinitionContext)_localctx).a.def.fieldId, ((TableDefinitionContext)_localctx).a.def.dataType); 
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(84);
				match(T__4);
				setState(85);
				((TableDefinitionContext)_localctx).b = fieldDefinition();
				 _localctx.tableDef.put(((TableDefinitionContext)_localctx).b.def.fieldId, ((TableDefinitionContext)_localctx).b.def.dataType); 
				}
				}
				setState(92);
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

	public static class FieldDefinitionContext extends ParserRuleContext {
		public FieldDef def;
		public FieldIdentifierContext a;
		public DataTypeContext b;
		public FieldIdentifierContext fieldIdentifier() {
			return getRuleContext(FieldIdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterFieldDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitFieldDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitFieldDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
		FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fieldDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			((FieldDefinitionContext)_localctx).a = fieldIdentifier();
			setState(94);
			((FieldDefinitionContext)_localctx).b = dataType();
			 ((FieldDefinitionContext)_localctx).def =  new FieldDef(((FieldDefinitionContext)_localctx).a.fieldId, ((FieldDefinitionContext)_localctx).b.dtType); 
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
		enterRule(_localctx, 26, RULE_values);

		        ((ValuesContext)_localctx).valueList =  new ArrayList<String>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			((ValuesContext)_localctx).a = constValue();
			 _localctx.valueList.add(((ValuesContext)_localctx).a.value); 
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(99);
				match(T__4);
				setState(100);
				((ValuesContext)_localctx).b = constValue();
				 _localctx.valueList.add(((ValuesContext)_localctx).b.value); 
				}
				}
				setState(107);
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
		enterRule(_localctx, 28, RULE_constValue);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((ConstValueContext)_localctx).NUMBER = match(NUMBER);
				 ((ConstValueContext)_localctx).value =  (((ConstValueContext)_localctx).NUMBER!=null?((ConstValueContext)_localctx).NUMBER.getText():null); 
				}
				break;
			case QUOTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
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

	public static class DataTypeContext extends ParserRuleContext {
		public DataType dtType;
		public TerminalNode TYPE_INT() { return getToken(HalcyonQueryLanguageParser.TYPE_INT, 0); }
		public TerminalNode TYPE_STRING() { return getToken(HalcyonQueryLanguageParser.TYPE_STRING, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dataType);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(TYPE_INT);
				((DataTypeContext)_localctx).dtType =  DataType.INTEGER; 
				}
				break;
			case TYPE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(TYPE_STRING);
				((DataTypeContext)_localctx).dtType =  DataType.STRING; 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31{\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\5\3)\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\fS\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\7\r[\n\r\f\r\16\r^\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\7\17j\n\17\f\17\16\17m\13\17\3\20\3\20\3\20\3\20\5\20s\n\20\3"+
		"\21\3\21\3\21\3\21\5\21y\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\2\2q\2\"\3\2\2\2\4(\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n.\3\2"+
		"\2\2\f\60\3\2\2\2\168\3\2\2\2\20@\3\2\2\2\22I\3\2\2\2\24K\3\2\2\2\26R"+
		"\3\2\2\2\30T\3\2\2\2\32_\3\2\2\2\34c\3\2\2\2\36r\3\2\2\2 x\3\2\2\2\"#"+
		"\5\4\3\2#$\7\3\2\2$\3\3\2\2\2%)\5\6\4\2&)\5\b\5\2\')\5\n\6\2(%\3\2\2\2"+
		"(&\3\2\2\2(\'\3\2\2\2)\5\3\2\2\2*+\5\f\7\2+\7\3\2\2\2,-\5\16\b\2-\t\3"+
		"\2\2\2./\5\20\t\2/\13\3\2\2\2\60\61\7\n\2\2\61\62\7\16\2\2\62\63\5\22"+
		"\n\2\63\64\7\17\2\2\64\65\7\4\2\2\65\66\5\34\17\2\66\67\7\5\2\2\67\r\3"+
		"\2\2\289\7\13\2\29:\7\20\2\2:;\5\22\n\2;<\7\21\2\2<=\7\4\2\2=>\5\30\r"+
		"\2>?\7\5\2\2?\17\3\2\2\2@A\7\f\2\2AB\7\23\2\2BC\7\r\2\2CD\5\22\n\2DE\7"+
		"\21\2\2EF\7\4\2\2FG\5\30\r\2GH\7\5\2\2H\21\3\2\2\2IJ\5\26\f\2J\23\3\2"+
		"\2\2KL\7\24\2\2LM\b\13\1\2M\25\3\2\2\2NO\7\24\2\2OP\7\6\2\2PS\7\24\2\2"+
		"QS\7\24\2\2RN\3\2\2\2RQ\3\2\2\2S\27\3\2\2\2TU\5\32\16\2U\\\b\r\1\2VW\7"+
		"\7\2\2WX\5\32\16\2XY\b\r\1\2Y[\3\2\2\2ZV\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2"+
		"\\]\3\2\2\2]\31\3\2\2\2^\\\3\2\2\2_`\5\24\13\2`a\5 \21\2ab\b\16\1\2b\33"+
		"\3\2\2\2cd\5\36\20\2dk\b\17\1\2ef\7\7\2\2fg\5\36\20\2gh\b\17\1\2hj\3\2"+
		"\2\2ie\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\35\3\2\2\2mk\3\2\2\2no\7"+
		"\26\2\2os\b\20\1\2pq\7\25\2\2qs\b\20\1\2rn\3\2\2\2rp\3\2\2\2s\37\3\2\2"+
		"\2tu\7\b\2\2uy\b\21\1\2vw\7\t\2\2wy\b\21\1\2xt\3\2\2\2xv\3\2\2\2y!\3\2"+
		"\2\2\b(R\\krx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}