// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;

import java.util.*;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HalcyonQueryLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TYPE_INT=6, TYPE_STRING=7, KWORD_INSERT=8, 
		KWORD_CREATE=9, KWORD_SELECT=10, KWORD_FROM=11, KWORD_WHERE=12, KWORD_INTO=13, 
		KWORD_VALUES=14, KWORD_TABLE=15, KWORD_WITH=16, Q_MARK=17, ASTERISK=18, 
		IDENTIFIER=19, QUOTED=20, NUMBER=21, FLOAT=22, INTEGER=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "TYPE_INT", "TYPE_STRING", "KWORD_INSERT", 
		"KWORD_CREATE", "KWORD_SELECT", "KWORD_FROM", "KWORD_WHERE", "KWORD_INTO", 
		"KWORD_VALUES", "KWORD_TABLE", "KWORD_WITH", "A", "B", "C", "D", "E", 
		"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
		"T", "U", "V", "W", "X", "Y", "Z", "Q_MARK", "ASTERISK", "IDENTIFIER", 
		"QUOTED", "NUMBER", "FLOAT", "INTEGER", "LETTER", "DIGIT", "WS"
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


	    class FieldDef {
	        public String fieldId;
	        public DataType dataType;

	        public FieldDef(String fieldName, DataType dataType) {
	            this.fieldId = fieldName;
	            this.dataType = dataType;
	        }
	    }


	public HalcyonQueryLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HalcyonQueryLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u0134\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\5.\u00f2\n.\3.\3.\3.\7.\u00f7\n.\f.\16.\u00fa"+
		"\13.\3/\3/\3/\3/\7/\u0100\n/\f/\16/\u0103\13/\3/\3/\3\60\5\60\u0108\n"+
		"\60\3\60\3\60\5\60\u010c\n\60\3\60\5\60\u010f\n\60\3\61\6\61\u0112\n\61"+
		"\r\61\16\61\u0113\3\61\3\61\7\61\u0118\n\61\f\61\16\61\u011b\13\61\3\61"+
		"\3\61\6\61\u011f\n\61\r\61\16\61\u0120\5\61\u0123\n\61\3\62\6\62\u0126"+
		"\n\62\r\62\16\62\u0127\3\63\3\63\3\64\3\64\3\65\6\65\u012f\n\65\r\65\16"+
		"\65\u0130\3\65\3\65\2\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65"+
		"\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\23Y\24[\25]\26_"+
		"\27a\30c\31e\2g\2i\32\3\2!\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2"+
		"HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYy"+
		"y\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2$$^^\4\2--//\4\2C\\c|\3\2\62;\5\2\13\f"+
		"\17\17\"\"\2\u0126\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5m\3\2\2\2\7o\3\2\2\2\tq\3\2\2"+
		"\2\13s\3\2\2\2\ru\3\2\2\2\17y\3\2\2\2\21\u0080\3\2\2\2\23\u0087\3\2\2"+
		"\2\25\u008e\3\2\2\2\27\u0095\3\2\2\2\31\u009a\3\2\2\2\33\u00a0\3\2\2\2"+
		"\35\u00a5\3\2\2\2\37\u00ac\3\2\2\2!\u00b2\3\2\2\2#\u00b7\3\2\2\2%\u00b9"+
		"\3\2\2\2\'\u00bb\3\2\2\2)\u00bd\3\2\2\2+\u00bf\3\2\2\2-\u00c1\3\2\2\2"+
		"/\u00c3\3\2\2\2\61\u00c5\3\2\2\2\63\u00c7\3\2\2\2\65\u00c9\3\2\2\2\67"+
		"\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf\3\2\2\2=\u00d1\3\2\2\2?\u00d3\3\2"+
		"\2\2A\u00d5\3\2\2\2C\u00d7\3\2\2\2E\u00d9\3\2\2\2G\u00db\3\2\2\2I\u00dd"+
		"\3\2\2\2K\u00df\3\2\2\2M\u00e1\3\2\2\2O\u00e3\3\2\2\2Q\u00e5\3\2\2\2S"+
		"\u00e7\3\2\2\2U\u00e9\3\2\2\2W\u00eb\3\2\2\2Y\u00ed\3\2\2\2[\u00f1\3\2"+
		"\2\2]\u00fb\3\2\2\2_\u010e\3\2\2\2a\u0122\3\2\2\2c\u0125\3\2\2\2e\u0129"+
		"\3\2\2\2g\u012b\3\2\2\2i\u012e\3\2\2\2kl\7=\2\2l\4\3\2\2\2mn\7*\2\2n\6"+
		"\3\2\2\2op\7+\2\2p\b\3\2\2\2qr\7.\2\2r\n\3\2\2\2st\7?\2\2t\f\3\2\2\2u"+
		"v\5\63\32\2vw\5=\37\2wx\5I%\2x\16\3\2\2\2yz\5G$\2z{\5I%\2{|\5E#\2|}\5"+
		"\63\32\2}~\5=\37\2~\177\5/\30\2\177\20\3\2\2\2\u0080\u0081\5\63\32\2\u0081"+
		"\u0082\5=\37\2\u0082\u0083\5G$\2\u0083\u0084\5+\26\2\u0084\u0085\5E#\2"+
		"\u0085\u0086\5I%\2\u0086\22\3\2\2\2\u0087\u0088\5\'\24\2\u0088\u0089\5"+
		"E#\2\u0089\u008a\5+\26\2\u008a\u008b\5#\22\2\u008b\u008c\5I%\2\u008c\u008d"+
		"\5+\26\2\u008d\24\3\2\2\2\u008e\u008f\5G$\2\u008f\u0090\5+\26\2\u0090"+
		"\u0091\59\35\2\u0091\u0092\5+\26\2\u0092\u0093\5\'\24\2\u0093\u0094\5"+
		"I%\2\u0094\26\3\2\2\2\u0095\u0096\5-\27\2\u0096\u0097\5E#\2\u0097\u0098"+
		"\5? \2\u0098\u0099\5;\36\2\u0099\30\3\2\2\2\u009a\u009b\5O(\2\u009b\u009c"+
		"\5\61\31\2\u009c\u009d\5+\26\2\u009d\u009e\5E#\2\u009e\u009f\5+\26\2\u009f"+
		"\32\3\2\2\2\u00a0\u00a1\5\63\32\2\u00a1\u00a2\5=\37\2\u00a2\u00a3\5I%"+
		"\2\u00a3\u00a4\5? \2\u00a4\34\3\2\2\2\u00a5\u00a6\5M\'\2\u00a6\u00a7\5"+
		"#\22\2\u00a7\u00a8\59\35\2\u00a8\u00a9\5K&\2\u00a9\u00aa\5+\26\2\u00aa"+
		"\u00ab\5G$\2\u00ab\36\3\2\2\2\u00ac\u00ad\5I%\2\u00ad\u00ae\5#\22\2\u00ae"+
		"\u00af\5%\23\2\u00af\u00b0\59\35\2\u00b0\u00b1\5+\26\2\u00b1 \3\2\2\2"+
		"\u00b2\u00b3\5O(\2\u00b3\u00b4\5\63\32\2\u00b4\u00b5\5I%\2\u00b5\u00b6"+
		"\5\61\31\2\u00b6\"\3\2\2\2\u00b7\u00b8\t\2\2\2\u00b8$\3\2\2\2\u00b9\u00ba"+
		"\t\3\2\2\u00ba&\3\2\2\2\u00bb\u00bc\t\4\2\2\u00bc(\3\2\2\2\u00bd\u00be"+
		"\t\5\2\2\u00be*\3\2\2\2\u00bf\u00c0\t\6\2\2\u00c0,\3\2\2\2\u00c1\u00c2"+
		"\t\7\2\2\u00c2.\3\2\2\2\u00c3\u00c4\t\b\2\2\u00c4\60\3\2\2\2\u00c5\u00c6"+
		"\t\t\2\2\u00c6\62\3\2\2\2\u00c7\u00c8\t\n\2\2\u00c8\64\3\2\2\2\u00c9\u00ca"+
		"\t\13\2\2\u00ca\66\3\2\2\2\u00cb\u00cc\t\f\2\2\u00cc8\3\2\2\2\u00cd\u00ce"+
		"\t\r\2\2\u00ce:\3\2\2\2\u00cf\u00d0\t\16\2\2\u00d0<\3\2\2\2\u00d1\u00d2"+
		"\t\17\2\2\u00d2>\3\2\2\2\u00d3\u00d4\t\20\2\2\u00d4@\3\2\2\2\u00d5\u00d6"+
		"\t\21\2\2\u00d6B\3\2\2\2\u00d7\u00d8\t\22\2\2\u00d8D\3\2\2\2\u00d9\u00da"+
		"\t\23\2\2\u00daF\3\2\2\2\u00db\u00dc\t\24\2\2\u00dcH\3\2\2\2\u00dd\u00de"+
		"\t\25\2\2\u00deJ\3\2\2\2\u00df\u00e0\t\26\2\2\u00e0L\3\2\2\2\u00e1\u00e2"+
		"\t\27\2\2\u00e2N\3\2\2\2\u00e3\u00e4\t\30\2\2\u00e4P\3\2\2\2\u00e5\u00e6"+
		"\t\31\2\2\u00e6R\3\2\2\2\u00e7\u00e8\t\32\2\2\u00e8T\3\2\2\2\u00e9\u00ea"+
		"\t\33\2\2\u00eaV\3\2\2\2\u00eb\u00ec\7A\2\2\u00ecX\3\2\2\2\u00ed\u00ee"+
		"\7,\2\2\u00eeZ\3\2\2\2\u00ef\u00f2\5e\63\2\u00f0\u00f2\7a\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f8\3\2\2\2\u00f3\u00f7\5e\63\2\u00f4"+
		"\u00f7\5g\64\2\u00f5\u00f7\7a\2\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\\\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u0101\7$\2\2"+
		"\u00fc\u0100\n\34\2\2\u00fd\u00fe\7^\2\2\u00fe\u0100\13\2\2\2\u00ff\u00fc"+
		"\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7$"+
		"\2\2\u0105^\3\2\2\2\u0106\u0108\t\35\2\2\u0107\u0106\3\2\2\2\u0107\u0108"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010f\5c\62\2\u010a\u010c\t\35\2\2"+
		"\u010b\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f"+
		"\5a\61\2\u010e\u0107\3\2\2\2\u010e\u010b\3\2\2\2\u010f`\3\2\2\2\u0110"+
		"\u0112\5g\64\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0119\7\60\2\2\u0116"+
		"\u0118\5g\64\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u011a\3\2\2\2\u011a\u0123\3\2\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011e\7\60\2\2\u011d\u011f\5g\64\2\u011e\u011d\3\2\2\2\u011f\u0120\3"+
		"\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122"+
		"\u0111\3\2\2\2\u0122\u011c\3\2\2\2\u0123b\3\2\2\2\u0124\u0126\5g\64\2"+
		"\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128d\3\2\2\2\u0129\u012a\t\36\2\2\u012af\3\2\2\2\u012b\u012c"+
		"\t\37\2\2\u012ch\3\2\2\2\u012d\u012f\t \2\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2"+
		"\2\2\u0132\u0133\b\65\2\2\u0133j\3\2\2\2\21\2\u00f1\u00f6\u00f8\u00ff"+
		"\u0101\u0107\u010b\u010e\u0113\u0119\u0120\u0122\u0127\u0130\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}