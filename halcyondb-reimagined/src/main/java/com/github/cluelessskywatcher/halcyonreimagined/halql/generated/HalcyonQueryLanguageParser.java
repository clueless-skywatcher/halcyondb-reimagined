// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;

import java.util.*;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;

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
		KWORD_CREATE=9, KWORD_SELECT=10, KWORD_FROM=11, KWORD_WHERE=12, KWORD_INTO=13, 
		KWORD_VALUES=14, KWORD_TABLE=15, KWORD_WITH=16, Q_MARK=17, ASTERISK=18, 
		IDENTIFIER=19, QUOTED=20, NUMBER=21, FLOAT=22, INTEGER=23, WS=24;
	public static final int
		RULE_halqlEntryPoint = 0, RULE_halqlStatement = 1, RULE_halqlDmlStatement = 2, 
		RULE_halqlDdlStatement = 3, RULE_halqlDqlStatement = 4, RULE_insertRowStatement = 5, 
		RULE_createTableStatement = 6, RULE_selectTableStatement = 7, RULE_projection = 8, 
		RULE_queryFilters = 9, RULE_tableIdentifier = 10, RULE_fieldIdentifier = 11, 
		RULE_identifier = 12, RULE_tableDefinition = 13, RULE_fieldDefinition = 14, 
		RULE_values = 15, RULE_constValue = 16, RULE_dataType = 17;
	public static final String[] ruleNames = {
		"halqlEntryPoint", "halqlStatement", "halqlDmlStatement", "halqlDdlStatement", 
		"halqlDqlStatement", "insertRowStatement", "createTableStatement", "selectTableStatement", 
		"projection", "queryFilters", "tableIdentifier", "fieldIdentifier", "identifier", 
		"tableDefinition", "fieldDefinition", "values", "constValue", "dataType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'='", null, null, null, null, null, 
		null, null, null, null, null, null, "'?'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "TYPE_INT", "TYPE_STRING", "KWORD_INSERT", 
		"KWORD_CREATE", "KWORD_SELECT", "KWORD_FROM", "KWORD_WHERE", "KWORD_INTO", 
		"KWORD_VALUES", "KWORD_TABLE", "KWORD_WITH", "Q_MARK", "ASTERISK", "IDENTIFIER", 
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
			setState(36);
			halqlStatement();
			setState(37);
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
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KWORD_INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				halqlDmlStatement();
				}
				break;
			case KWORD_CREATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				halqlDdlStatement();
				}
				break;
			case KWORD_SELECT:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
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
			setState(44);
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
			setState(46);
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
			setState(48);
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
			setState(50);
			match(KWORD_INSERT);
			setState(51);
			match(KWORD_INTO);
			setState(52);
			tableIdentifier();
			setState(53);
			match(KWORD_VALUES);
			setState(54);
			match(T__1);
			setState(55);
			values();
			setState(56);
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
			setState(58);
			match(KWORD_CREATE);
			setState(59);
			match(KWORD_TABLE);
			setState(60);
			tableIdentifier();
			setState(61);
			match(KWORD_WITH);
			setState(62);
			match(T__1);
			setState(63);
			tableDefinition();
			setState(64);
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
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public TerminalNode KWORD_FROM() { return getToken(HalcyonQueryLanguageParser.KWORD_FROM, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode KWORD_WHERE() { return getToken(HalcyonQueryLanguageParser.KWORD_WHERE, 0); }
		public QueryFiltersContext queryFilters() {
			return getRuleContext(QueryFiltersContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(KWORD_SELECT);
			setState(67);
			projection();
			setState(68);
			match(KWORD_FROM);
			setState(69);
			tableIdentifier();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KWORD_WHERE) {
				{
				setState(70);
				match(KWORD_WHERE);
				setState(71);
				queryFilters();
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

	public static class ProjectionContext extends ParserRuleContext {
		public List<String> projectionList;
		public IdentifierContext a;
		public IdentifierContext b;
		public TerminalNode ASTERISK() { return getToken(HalcyonQueryLanguageParser.ASTERISK, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_projection);

		        ((ProjectionContext)_localctx).projectionList =  new ArrayList<>();
		    
		int _la;
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(ASTERISK);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(75);
				((ProjectionContext)_localctx).a = identifier();
				 _localctx.projectionList.add(((ProjectionContext)_localctx).a.value); 
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(78);
					match(T__3);
					setState(79);
					((ProjectionContext)_localctx).b = identifier();
					 _localctx.projectionList.add(((ProjectionContext)_localctx).b.value); 
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class QueryFiltersContext extends ParserRuleContext {
		public Map<String, Object> filters;
		public FieldIdentifierContext a;
		public ConstValueContext b;
		public FieldIdentifierContext fieldIdentifier() {
			return getRuleContext(FieldIdentifierContext.class,0);
		}
		public ConstValueContext constValue() {
			return getRuleContext(ConstValueContext.class,0);
		}
		public QueryFiltersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryFilters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).enterQueryFilters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HalcyonQueryLanguageListener ) ((HalcyonQueryLanguageListener)listener).exitQueryFilters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HalcyonQueryLanguageVisitor ) return ((HalcyonQueryLanguageVisitor<? extends T>)visitor).visitQueryFilters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryFiltersContext queryFilters() throws RecognitionException {
		QueryFiltersContext _localctx = new QueryFiltersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_queryFilters);

		        ((QueryFiltersContext)_localctx).filters =  new HashMap<>();
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(89);
			((QueryFiltersContext)_localctx).a = fieldIdentifier();
			setState(90);
			match(T__4);
			setState(91);
			((QueryFiltersContext)_localctx).b = constValue();
			}

			            _localctx.filters.put(((QueryFiltersContext)_localctx).a.fieldId, ((QueryFiltersContext)_localctx).b.value);
			        
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
		enterRule(_localctx, 20, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		enterRule(_localctx, 22, RULE_fieldIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		public String value;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(HalcyonQueryLanguageParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 24, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			((IdentifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 ((IdentifierContext)_localctx).value =  (((IdentifierContext)_localctx).IDENTIFIER!=null?((IdentifierContext)_localctx).IDENTIFIER.getText():null); 
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
		enterRule(_localctx, 26, RULE_tableDefinition);

		        ((TableDefinitionContext)_localctx).tableDef =  new LinkedHashMap<String, DataType>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			((TableDefinitionContext)_localctx).a = fieldDefinition();
			 _localctx.tableDef.put(((TableDefinitionContext)_localctx).a.def.fieldId, ((TableDefinitionContext)_localctx).a.def.dataType); 
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(105);
				match(T__3);
				setState(106);
				((TableDefinitionContext)_localctx).b = fieldDefinition();
				 _localctx.tableDef.put(((TableDefinitionContext)_localctx).b.def.fieldId, ((TableDefinitionContext)_localctx).b.def.dataType); 
				}
				}
				setState(113);
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
		enterRule(_localctx, 28, RULE_fieldDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			((FieldDefinitionContext)_localctx).a = fieldIdentifier();
			setState(115);
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
		enterRule(_localctx, 30, RULE_values);

		        ((ValuesContext)_localctx).valueList =  new ArrayList<String>();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			((ValuesContext)_localctx).a = constValue();
			 _localctx.valueList.add(((ValuesContext)_localctx).a.value); 
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(120);
				match(T__3);
				setState(121);
				((ValuesContext)_localctx).b = constValue();
				 _localctx.valueList.add(((ValuesContext)_localctx).b.value); 
				}
				}
				setState(128);
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
		enterRule(_localctx, 32, RULE_constValue);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				((ConstValueContext)_localctx).NUMBER = match(NUMBER);
				 ((ConstValueContext)_localctx).value =  (((ConstValueContext)_localctx).NUMBER!=null?((ConstValueContext)_localctx).NUMBER.getText():null); 
				}
				break;
			case QUOTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
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
		enterRule(_localctx, 34, RULE_dataType);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(TYPE_INT);
				((DataTypeContext)_localctx).dtType =  DataType.INTEGER; 
				}
				break;
			case TYPE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u0090\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\5\3-\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tK\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nU\n\n\f\n"+
		"\16\nX\13\n\5\nZ\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17p\n\17\f\17\16\17s\13"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\177\n\21\f"+
		"\21\16\21\u0082\13\21\3\22\3\22\3\22\3\22\5\22\u0088\n\22\3\23\3\23\3"+
		"\23\3\23\5\23\u008e\n\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$\2\2\2\u0086\2&\3\2\2\2\4,\3\2\2\2\6.\3\2\2\2\b\60\3\2\2\2\n"+
		"\62\3\2\2\2\f\64\3\2\2\2\16<\3\2\2\2\20D\3\2\2\2\22Y\3\2\2\2\24[\3\2\2"+
		"\2\26a\3\2\2\2\30c\3\2\2\2\32f\3\2\2\2\34i\3\2\2\2\36t\3\2\2\2 x\3\2\2"+
		"\2\"\u0087\3\2\2\2$\u008d\3\2\2\2&\'\5\4\3\2\'(\7\3\2\2(\3\3\2\2\2)-\5"+
		"\6\4\2*-\5\b\5\2+-\5\n\6\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\5\3\2\2\2./"+
		"\5\f\7\2/\7\3\2\2\2\60\61\5\16\b\2\61\t\3\2\2\2\62\63\5\20\t\2\63\13\3"+
		"\2\2\2\64\65\7\n\2\2\65\66\7\17\2\2\66\67\5\26\f\2\678\7\20\2\289\7\4"+
		"\2\29:\5 \21\2:;\7\5\2\2;\r\3\2\2\2<=\7\13\2\2=>\7\21\2\2>?\5\26\f\2?"+
		"@\7\22\2\2@A\7\4\2\2AB\5\34\17\2BC\7\5\2\2C\17\3\2\2\2DE\7\f\2\2EF\5\22"+
		"\n\2FG\7\r\2\2GJ\5\26\f\2HI\7\16\2\2IK\5\24\13\2JH\3\2\2\2JK\3\2\2\2K"+
		"\21\3\2\2\2LZ\7\24\2\2MN\5\32\16\2NO\b\n\1\2OV\3\2\2\2PQ\7\6\2\2QR\5\32"+
		"\16\2RS\b\n\1\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3"+
		"\2\2\2XV\3\2\2\2YL\3\2\2\2YM\3\2\2\2Z\23\3\2\2\2[\\\5\30\r\2\\]\7\7\2"+
		"\2]^\5\"\22\2^_\3\2\2\2_`\b\13\1\2`\25\3\2\2\2ab\5\32\16\2b\27\3\2\2\2"+
		"cd\7\25\2\2de\b\r\1\2e\31\3\2\2\2fg\7\25\2\2gh\b\16\1\2h\33\3\2\2\2ij"+
		"\5\36\20\2jq\b\17\1\2kl\7\6\2\2lm\5\36\20\2mn\b\17\1\2np\3\2\2\2ok\3\2"+
		"\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\35\3\2\2\2sq\3\2\2\2tu\5\30\r\2uv"+
		"\5$\23\2vw\b\20\1\2w\37\3\2\2\2xy\5\"\22\2y\u0080\b\21\1\2z{\7\6\2\2{"+
		"|\5\"\22\2|}\b\21\1\2}\177\3\2\2\2~z\3\2\2\2\177\u0082\3\2\2\2\u0080~"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081!\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0084\7\27\2\2\u0084\u0088\b\22\1\2\u0085\u0086\7\26\2\2\u0086\u0088"+
		"\b\22\1\2\u0087\u0083\3\2\2\2\u0087\u0085\3\2\2\2\u0088#\3\2\2\2\u0089"+
		"\u008a\7\b\2\2\u008a\u008e\b\23\1\2\u008b\u008c\7\t\2\2\u008c\u008e\b"+
		"\23\1\2\u008d\u0089\3\2\2\2\u008d\u008b\3\2\2\2\u008e%\3\2\2\2\n,JVYq"+
		"\u0080\u0087\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}