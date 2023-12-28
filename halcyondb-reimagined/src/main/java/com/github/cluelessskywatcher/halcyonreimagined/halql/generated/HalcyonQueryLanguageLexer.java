// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import java.util.*;

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
		KWORD_CREATE=9, KWORD_SELECT=10, KWORD_FROM=11, KWORD_INTO=12, KWORD_VALUES=13, 
		KWORD_TABLE=14, KWORD_WITH=15, Q_MARK=16, ASTERISK=17, IDENTIFIER=18, 
		QUOTED=19, NUMBER=20, FLOAT=21, INTEGER=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "TYPE_INT", "TYPE_STRING", "KWORD_INSERT", 
		"KWORD_CREATE", "KWORD_SELECT", "KWORD_FROM", "KWORD_INTO", "KWORD_VALUES", 
		"KWORD_TABLE", "KWORD_WITH", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
		"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
		"X", "Y", "Z", "Q_MARK", "ASTERISK", "IDENTIFIER", "QUOTED", "NUMBER", 
		"FLOAT", "INTEGER", "LETTER", "DIGIT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u012c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\5-\u00ea"+
		"\n-\3-\3-\3-\7-\u00ef\n-\f-\16-\u00f2\13-\3.\3.\3.\3.\7.\u00f8\n.\f.\16"+
		".\u00fb\13.\3.\3.\3/\5/\u0100\n/\3/\3/\5/\u0104\n/\3/\5/\u0107\n/\3\60"+
		"\6\60\u010a\n\60\r\60\16\60\u010b\3\60\3\60\7\60\u0110\n\60\f\60\16\60"+
		"\u0113\13\60\3\60\3\60\6\60\u0117\n\60\r\60\16\60\u0118\5\60\u011b\n\60"+
		"\3\61\6\61\u011e\n\61\r\61\16\61\u011f\3\62\3\62\3\63\3\63\3\64\6\64\u0127"+
		"\n\64\r\64\16\64\u0128\3\64\3\64\2\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\2%\2\'\2)\2+\2-\2/\2"+
		"\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\22W\23"+
		"Y\24[\25]\26_\27a\30c\2e\2g\31\3\2!\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4"+
		"\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOo"+
		"o\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2"+
		"XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2$$^^\4\2--//\4\2C\\c|\3\2\62"+
		";\5\2\13\f\17\17\"\"\2\u011e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7m\3\2\2\2\to\3\2\2\2"+
		"\13q\3\2\2\2\rs\3\2\2\2\17w\3\2\2\2\21~\3\2\2\2\23\u0085\3\2\2\2\25\u008c"+
		"\3\2\2\2\27\u0093\3\2\2\2\31\u0098\3\2\2\2\33\u009d\3\2\2\2\35\u00a4\3"+
		"\2\2\2\37\u00aa\3\2\2\2!\u00af\3\2\2\2#\u00b1\3\2\2\2%\u00b3\3\2\2\2\'"+
		"\u00b5\3\2\2\2)\u00b7\3\2\2\2+\u00b9\3\2\2\2-\u00bb\3\2\2\2/\u00bd\3\2"+
		"\2\2\61\u00bf\3\2\2\2\63\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c5\3\2\2"+
		"\29\u00c7\3\2\2\2;\u00c9\3\2\2\2=\u00cb\3\2\2\2?\u00cd\3\2\2\2A\u00cf"+
		"\3\2\2\2C\u00d1\3\2\2\2E\u00d3\3\2\2\2G\u00d5\3\2\2\2I\u00d7\3\2\2\2K"+
		"\u00d9\3\2\2\2M\u00db\3\2\2\2O\u00dd\3\2\2\2Q\u00df\3\2\2\2S\u00e1\3\2"+
		"\2\2U\u00e3\3\2\2\2W\u00e5\3\2\2\2Y\u00e9\3\2\2\2[\u00f3\3\2\2\2]\u0106"+
		"\3\2\2\2_\u011a\3\2\2\2a\u011d\3\2\2\2c\u0121\3\2\2\2e\u0123\3\2\2\2g"+
		"\u0126\3\2\2\2ij\7=\2\2j\4\3\2\2\2kl\7*\2\2l\6\3\2\2\2mn\7+\2\2n\b\3\2"+
		"\2\2op\7\60\2\2p\n\3\2\2\2qr\7.\2\2r\f\3\2\2\2st\5\61\31\2tu\5;\36\2u"+
		"v\5G$\2v\16\3\2\2\2wx\5E#\2xy\5G$\2yz\5C\"\2z{\5\61\31\2{|\5;\36\2|}\5"+
		"-\27\2}\20\3\2\2\2~\177\5\61\31\2\177\u0080\5;\36\2\u0080\u0081\5E#\2"+
		"\u0081\u0082\5)\25\2\u0082\u0083\5C\"\2\u0083\u0084\5G$\2\u0084\22\3\2"+
		"\2\2\u0085\u0086\5%\23\2\u0086\u0087\5C\"\2\u0087\u0088\5)\25\2\u0088"+
		"\u0089\5!\21\2\u0089\u008a\5G$\2\u008a\u008b\5)\25\2\u008b\24\3\2\2\2"+
		"\u008c\u008d\5E#\2\u008d\u008e\5)\25\2\u008e\u008f\5\67\34\2\u008f\u0090"+
		"\5)\25\2\u0090\u0091\5%\23\2\u0091\u0092\5G$\2\u0092\26\3\2\2\2\u0093"+
		"\u0094\5+\26\2\u0094\u0095\5C\"\2\u0095\u0096\5=\37\2\u0096\u0097\59\35"+
		"\2\u0097\30\3\2\2\2\u0098\u0099\5\61\31\2\u0099\u009a\5;\36\2\u009a\u009b"+
		"\5G$\2\u009b\u009c\5=\37\2\u009c\32\3\2\2\2\u009d\u009e\5K&\2\u009e\u009f"+
		"\5!\21\2\u009f\u00a0\5\67\34\2\u00a0\u00a1\5I%\2\u00a1\u00a2\5)\25\2\u00a2"+
		"\u00a3\5E#\2\u00a3\34\3\2\2\2\u00a4\u00a5\5G$\2\u00a5\u00a6\5!\21\2\u00a6"+
		"\u00a7\5#\22\2\u00a7\u00a8\5\67\34\2\u00a8\u00a9\5)\25\2\u00a9\36\3\2"+
		"\2\2\u00aa\u00ab\5M\'\2\u00ab\u00ac\5\61\31\2\u00ac\u00ad\5G$\2\u00ad"+
		"\u00ae\5/\30\2\u00ae \3\2\2\2\u00af\u00b0\t\2\2\2\u00b0\"\3\2\2\2\u00b1"+
		"\u00b2\t\3\2\2\u00b2$\3\2\2\2\u00b3\u00b4\t\4\2\2\u00b4&\3\2\2\2\u00b5"+
		"\u00b6\t\5\2\2\u00b6(\3\2\2\2\u00b7\u00b8\t\6\2\2\u00b8*\3\2\2\2\u00b9"+
		"\u00ba\t\7\2\2\u00ba,\3\2\2\2\u00bb\u00bc\t\b\2\2\u00bc.\3\2\2\2\u00bd"+
		"\u00be\t\t\2\2\u00be\60\3\2\2\2\u00bf\u00c0\t\n\2\2\u00c0\62\3\2\2\2\u00c1"+
		"\u00c2\t\13\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\t\f\2\2\u00c4\66\3\2\2\2"+
		"\u00c5\u00c6\t\r\2\2\u00c68\3\2\2\2\u00c7\u00c8\t\16\2\2\u00c8:\3\2\2"+
		"\2\u00c9\u00ca\t\17\2\2\u00ca<\3\2\2\2\u00cb\u00cc\t\20\2\2\u00cc>\3\2"+
		"\2\2\u00cd\u00ce\t\21\2\2\u00ce@\3\2\2\2\u00cf\u00d0\t\22\2\2\u00d0B\3"+
		"\2\2\2\u00d1\u00d2\t\23\2\2\u00d2D\3\2\2\2\u00d3\u00d4\t\24\2\2\u00d4"+
		"F\3\2\2\2\u00d5\u00d6\t\25\2\2\u00d6H\3\2\2\2\u00d7\u00d8\t\26\2\2\u00d8"+
		"J\3\2\2\2\u00d9\u00da\t\27\2\2\u00daL\3\2\2\2\u00db\u00dc\t\30\2\2\u00dc"+
		"N\3\2\2\2\u00dd\u00de\t\31\2\2\u00deP\3\2\2\2\u00df\u00e0\t\32\2\2\u00e0"+
		"R\3\2\2\2\u00e1\u00e2\t\33\2\2\u00e2T\3\2\2\2\u00e3\u00e4\7A\2\2\u00e4"+
		"V\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6X\3\2\2\2\u00e7\u00ea\5c\62\2\u00e8"+
		"\u00ea\7a\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00f0\3\2"+
		"\2\2\u00eb\u00ef\5c\62\2\u00ec\u00ef\5e\63\2\u00ed\u00ef\7a\2\2\u00ee"+
		"\u00eb\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1Z\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f9\7$\2\2\u00f4\u00f8\n\34\2\2\u00f5\u00f6\7^\2\2\u00f6"+
		"\u00f8\13\2\2\2\u00f7\u00f4\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3"+
		"\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u00fd\7$\2\2\u00fd\\\3\2\2\2\u00fe\u0100\t\35\2\2"+
		"\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0107"+
		"\5a\61\2\u0102\u0104\t\35\2\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2"+
		"\u0104\u0105\3\2\2\2\u0105\u0107\5_\60\2\u0106\u00ff\3\2\2\2\u0106\u0103"+
		"\3\2\2\2\u0107^\3\2\2\2\u0108\u010a\5e\63\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u0111\7\60\2\2\u010e\u0110\5e\63\2\u010f\u010e\3\2\2\2\u0110"+
		"\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u011b\3\2"+
		"\2\2\u0113\u0111\3\2\2\2\u0114\u0116\7\60\2\2\u0115\u0117\5e\63\2\u0116"+
		"\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\u011b\3\2\2\2\u011a\u0109\3\2\2\2\u011a\u0114\3\2\2\2\u011b"+
		"`\3\2\2\2\u011c\u011e\5e\63\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2"+
		"\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120b\3\2\2\2\u0121\u0122\t"+
		"\36\2\2\u0122d\3\2\2\2\u0123\u0124\t\37\2\2\u0124f\3\2\2\2\u0125\u0127"+
		"\t \2\2\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\b\64\2\2\u012bh\3\2\2\2"+
		"\21\2\u00e9\u00ee\u00f0\u00f7\u00f9\u00ff\u0103\u0106\u010b\u0111\u0118"+
		"\u011a\u011f\u0128\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}