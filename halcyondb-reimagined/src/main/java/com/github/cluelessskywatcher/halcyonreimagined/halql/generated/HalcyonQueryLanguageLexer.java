// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, KWORD_INSERT=6, KWORD_NEW=7, KWORD_SELECT=8, 
		KWORD_FROM=9, KWORD_INTO=10, KWORD_VALUES=11, Q_MARK=12, ASTERISK=13, 
		IDENTIFIER=14, QUOTED=15, NUMBER=16, FLOAT=17, INTEGER=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "KWORD_INSERT", "KWORD_NEW", "KWORD_SELECT", 
		"KWORD_FROM", "KWORD_INTO", "KWORD_VALUES", "A", "B", "C", "D", "E", "F", 
		"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
		"U", "V", "W", "X", "Y", "Z", "Q_MARK", "ASTERISK", "IDENTIFIER", "QUOTED", 
		"NUMBER", "FLOAT", "INTEGER", "LETTER", "DIGIT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u010b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\5)\u00c9\n)\3"+
		")\3)\3)\7)\u00ce\n)\f)\16)\u00d1\13)\3*\3*\3*\3*\7*\u00d7\n*\f*\16*\u00da"+
		"\13*\3*\3*\3+\5+\u00df\n+\3+\3+\5+\u00e3\n+\3+\5+\u00e6\n+\3,\6,\u00e9"+
		"\n,\r,\16,\u00ea\3,\3,\7,\u00ef\n,\f,\16,\u00f2\13,\3,\3,\6,\u00f6\n,"+
		"\r,\16,\u00f7\5,\u00fa\n,\3-\6-\u00fd\n-\r-\16-\u00fe\3.\3.\3/\3/\3\60"+
		"\6\60\u0106\n\60\r\60\16\60\u0107\3\60\3\60\2\2\61\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+"+
		"\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\16O\17Q\20"+
		"S\21U\22W\23Y\24[\2]\2_\25\3\2!\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GG"+
		"gg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2"+
		"PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2$$^^\4\2--//\4\2C\\c|\3\2\62;\5\2"+
		"\13\f\17\17\"\"\2\u00fd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3\2\2"+
		"\2\tg\3\2\2\2\13i\3\2\2\2\rk\3\2\2\2\17r\3\2\2\2\21v\3\2\2\2\23}\3\2\2"+
		"\2\25\u0082\3\2\2\2\27\u0087\3\2\2\2\31\u008e\3\2\2\2\33\u0090\3\2\2\2"+
		"\35\u0092\3\2\2\2\37\u0094\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2\2%\u009a"+
		"\3\2\2\2\'\u009c\3\2\2\2)\u009e\3\2\2\2+\u00a0\3\2\2\2-\u00a2\3\2\2\2"+
		"/\u00a4\3\2\2\2\61\u00a6\3\2\2\2\63\u00a8\3\2\2\2\65\u00aa\3\2\2\2\67"+
		"\u00ac\3\2\2\29\u00ae\3\2\2\2;\u00b0\3\2\2\2=\u00b2\3\2\2\2?\u00b4\3\2"+
		"\2\2A\u00b6\3\2\2\2C\u00b8\3\2\2\2E\u00ba\3\2\2\2G\u00bc\3\2\2\2I\u00be"+
		"\3\2\2\2K\u00c0\3\2\2\2M\u00c2\3\2\2\2O\u00c4\3\2\2\2Q\u00c8\3\2\2\2S"+
		"\u00d2\3\2\2\2U\u00e5\3\2\2\2W\u00f9\3\2\2\2Y\u00fc\3\2\2\2[\u0100\3\2"+
		"\2\2]\u0102\3\2\2\2_\u0105\3\2\2\2ab\7=\2\2b\4\3\2\2\2cd\7*\2\2d\6\3\2"+
		"\2\2ef\7+\2\2f\b\3\2\2\2gh\7\60\2\2h\n\3\2\2\2ij\7.\2\2j\f\3\2\2\2kl\5"+
		")\25\2lm\5\63\32\2mn\5=\37\2no\5!\21\2op\5;\36\2pq\5? \2q\16\3\2\2\2r"+
		"s\5\63\32\2st\5!\21\2tu\5E#\2u\20\3\2\2\2vw\5=\37\2wx\5!\21\2xy\5/\30"+
		"\2yz\5!\21\2z{\5\35\17\2{|\5? \2|\22\3\2\2\2}~\5#\22\2~\177\5;\36\2\177"+
		"\u0080\5\65\33\2\u0080\u0081\5\61\31\2\u0081\24\3\2\2\2\u0082\u0083\5"+
		")\25\2\u0083\u0084\5\63\32\2\u0084\u0085\5? \2\u0085\u0086\5\65\33\2\u0086"+
		"\26\3\2\2\2\u0087\u0088\5C\"\2\u0088\u0089\5\31\r\2\u0089\u008a\5/\30"+
		"\2\u008a\u008b\5A!\2\u008b\u008c\5!\21\2\u008c\u008d\5=\37\2\u008d\30"+
		"\3\2\2\2\u008e\u008f\t\2\2\2\u008f\32\3\2\2\2\u0090\u0091\t\3\2\2\u0091"+
		"\34\3\2\2\2\u0092\u0093\t\4\2\2\u0093\36\3\2\2\2\u0094\u0095\t\5\2\2\u0095"+
		" \3\2\2\2\u0096\u0097\t\6\2\2\u0097\"\3\2\2\2\u0098\u0099\t\7\2\2\u0099"+
		"$\3\2\2\2\u009a\u009b\t\b\2\2\u009b&\3\2\2\2\u009c\u009d\t\t\2\2\u009d"+
		"(\3\2\2\2\u009e\u009f\t\n\2\2\u009f*\3\2\2\2\u00a0\u00a1\t\13\2\2\u00a1"+
		",\3\2\2\2\u00a2\u00a3\t\f\2\2\u00a3.\3\2\2\2\u00a4\u00a5\t\r\2\2\u00a5"+
		"\60\3\2\2\2\u00a6\u00a7\t\16\2\2\u00a7\62\3\2\2\2\u00a8\u00a9\t\17\2\2"+
		"\u00a9\64\3\2\2\2\u00aa\u00ab\t\20\2\2\u00ab\66\3\2\2\2\u00ac\u00ad\t"+
		"\21\2\2\u00ad8\3\2\2\2\u00ae\u00af\t\22\2\2\u00af:\3\2\2\2\u00b0\u00b1"+
		"\t\23\2\2\u00b1<\3\2\2\2\u00b2\u00b3\t\24\2\2\u00b3>\3\2\2\2\u00b4\u00b5"+
		"\t\25\2\2\u00b5@\3\2\2\2\u00b6\u00b7\t\26\2\2\u00b7B\3\2\2\2\u00b8\u00b9"+
		"\t\27\2\2\u00b9D\3\2\2\2\u00ba\u00bb\t\30\2\2\u00bbF\3\2\2\2\u00bc\u00bd"+
		"\t\31\2\2\u00bdH\3\2\2\2\u00be\u00bf\t\32\2\2\u00bfJ\3\2\2\2\u00c0\u00c1"+
		"\t\33\2\2\u00c1L\3\2\2\2\u00c2\u00c3\7A\2\2\u00c3N\3\2\2\2\u00c4\u00c5"+
		"\7,\2\2\u00c5P\3\2\2\2\u00c6\u00c9\5[.\2\u00c7\u00c9\7a\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cf\3\2\2\2\u00ca\u00ce\5[.\2\u00cb"+
		"\u00ce\5]/\2\u00cc\u00ce\7a\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2"+
		"\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0R\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d8\7$\2\2\u00d3\u00d7"+
		"\n\34\2\2\u00d4\u00d5\7^\2\2\u00d5\u00d7\13\2\2\2\u00d6\u00d3\3\2\2\2"+
		"\u00d6\u00d4\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7$\2\2\u00dc"+
		"T\3\2\2\2\u00dd\u00df\t\35\2\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00e6\5Y-\2\u00e1\u00e3\t\35\2\2\u00e2\u00e1"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\5W,\2\u00e5"+
		"\u00de\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6V\3\2\2\2\u00e7\u00e9\5]/\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00f0\7\60\2\2\u00ed\u00ef\5]/\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00fa\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\7\60\2\2\u00f4"+
		"\u00f6\5]/\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2"+
		"\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00e8\3\2\2\2\u00f9\u00f3"+
		"\3\2\2\2\u00faX\3\2\2\2\u00fb\u00fd\5]/\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ffZ\3\2\2\2\u0100"+
		"\u0101\t\36\2\2\u0101\\\3\2\2\2\u0102\u0103\t\37\2\2\u0103^\3\2\2\2\u0104"+
		"\u0106\t \2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\b\60\2\2\u010a"+
		"`\3\2\2\2\21\2\u00c8\u00cd\u00cf\u00d6\u00d8\u00de\u00e2\u00e5\u00ea\u00f0"+
		"\u00f7\u00f9\u00fe\u0107\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}