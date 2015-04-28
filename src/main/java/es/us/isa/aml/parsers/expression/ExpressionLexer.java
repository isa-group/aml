// Generated from C:\Users\ISA Group\Desktop\iAgree\Expression.g4 by ANTLR 4.1
package es.us.isa.aml.parsers.expression;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BOOLEAN=2, INTEGER=3, FLOAT=4, NATURAL=5, NUMBER=6, SET=7, ENUM=8, 
		TRUE=9, FALSE=10, CA=11, CC=12, PA=13, PC=14, LLA=15, LLC=16, AND=17, 
		OR=18, NOT=19, IMPLIES=20, ADD=21, SUBTRACT=22, MULTIPLY=23, DIVIDE=24, 
		LT=25, GT=26, EQ=27, NEQ=28, LTE=29, GTE=30, ASSIG=31, BELONGS=32, UPON=33, 
		Identifier=34, Integer=35, S_Integer=36, Float=37, S_Float=38, Boolean=39, 
		String=40, WS=41, COMMENT=42, LINE_COMMENT=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'boolean'", "'integer'", "'float'", "'natural'", "'number'", "'set'", 
		"'enum'", "'true'", "'false'", "'['", "']'", "'('", "')'", "'{'", "'}'", 
		"'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'+'", "'-'", "'*'", "'/'", "'<'", 
		"'>'", "'=='", "'!='", "'<='", "'>='", "'='", "'belongs'", "'upon'", "Identifier", 
		"Integer", "S_Integer", "Float", "S_Float", "Boolean", "String", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__0", "BOOLEAN", "INTEGER", "FLOAT", "NATURAL", "NUMBER", "SET", "ENUM", 
		"TRUE", "FALSE", "CA", "CC", "PA", "PC", "LLA", "LLC", "AND", "OR", "NOT", 
		"IMPLIES", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "LT", "GT", "EQ", 
		"NEQ", "LTE", "GTE", "ASSIG", "BELONGS", "UPON", "Identifier", "Letter", 
		"LetterOrDigit", "Integer", "S_Integer", "Float", "S_Float", "Boolean", 
		"Digit", "NonZeroDigit", "String", "WS", "COMMENT", "LINE_COMMENT"
	};


	public ExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 44: WS_action((RuleContext)_localctx, actionIndex); break;

		case 45: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 46: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2-\u0140\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\7#\u00e6\n#\f#\16#\u00e9"+
		"\13#\3$\3$\3%\3%\3&\6&\u00f0\n&\r&\16&\u00f1\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		")\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0107\n*\3+\3+\5+\u010b\n+\3,\3"+
		",\3-\3-\7-\u0111\n-\f-\16-\u0114\13-\3-\3-\3-\7-\u0119\n-\f-\16-\u011c"+
		"\13-\3-\5-\u011f\n-\3.\6.\u0122\n.\r.\16.\u0123\3.\3.\3/\3/\3/\3/\7/\u012c"+
		"\n/\f/\16/\u012f\13/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u013a\n\60"+
		"\f\60\16\60\u013d\13\60\3\60\3\60\3\u012d\61\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1"+
		"\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33"+
		"\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G\2\1I\2\1K%\1M&\1"+
		"O\'\1Q(\1S)\1U\2\1W\2\1Y*\1[+\2],\3_-\4\3\2\13\4\2/\60aa\6\2&&C\\aac|"+
		"\7\2&&\62;C\\aac|\4\2--//\3\2\63;\3\2))\3\2$$\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\u0146\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7k\3\2\2\2\t"+
		"s\3\2\2\2\13y\3\2\2\2\r\u0081\3\2\2\2\17\u0088\3\2\2\2\21\u008c\3\2\2"+
		"\2\23\u0091\3\2\2\2\25\u0096\3\2\2\2\27\u009c\3\2\2\2\31\u009e\3\2\2\2"+
		"\33\u00a0\3\2\2\2\35\u00a2\3\2\2\2\37\u00a4\3\2\2\2!\u00a6\3\2\2\2#\u00a8"+
		"\3\2\2\2%\u00ac\3\2\2\2\'\u00af\3\2\2\2)\u00b3\3\2\2\2+\u00bb\3\2\2\2"+
		"-\u00bd\3\2\2\2/\u00bf\3\2\2\2\61\u00c1\3\2\2\2\63\u00c3\3\2\2\2\65\u00c5"+
		"\3\2\2\2\67\u00c7\3\2\2\29\u00ca\3\2\2\2;\u00cd\3\2\2\2=\u00d0\3\2\2\2"+
		"?\u00d3\3\2\2\2A\u00d5\3\2\2\2C\u00dd\3\2\2\2E\u00e2\3\2\2\2G\u00ea\3"+
		"\2\2\2I\u00ec\3\2\2\2K\u00ef\3\2\2\2M\u00f3\3\2\2\2O\u00f6\3\2\2\2Q\u00fa"+
		"\3\2\2\2S\u0106\3\2\2\2U\u010a\3\2\2\2W\u010c\3\2\2\2Y\u011e\3\2\2\2["+
		"\u0121\3\2\2\2]\u0127\3\2\2\2_\u0135\3\2\2\2ab\7.\2\2b\4\3\2\2\2cd\7d"+
		"\2\2de\7q\2\2ef\7q\2\2fg\7n\2\2gh\7g\2\2hi\7c\2\2ij\7p\2\2j\6\3\2\2\2"+
		"kl\7k\2\2lm\7p\2\2mn\7v\2\2no\7g\2\2op\7i\2\2pq\7g\2\2qr\7t\2\2r\b\3\2"+
		"\2\2st\7h\2\2tu\7n\2\2uv\7q\2\2vw\7c\2\2wx\7v\2\2x\n\3\2\2\2yz\7p\2\2"+
		"z{\7c\2\2{|\7v\2\2|}\7w\2\2}~\7t\2\2~\177\7c\2\2\177\u0080\7n\2\2\u0080"+
		"\f\3\2\2\2\u0081\u0082\7p\2\2\u0082\u0083\7w\2\2\u0083\u0084\7o\2\2\u0084"+
		"\u0085\7d\2\2\u0085\u0086\7g\2\2\u0086\u0087\7t\2\2\u0087\16\3\2\2\2\u0088"+
		"\u0089\7u\2\2\u0089\u008a\7g\2\2\u008a\u008b\7v\2\2\u008b\20\3\2\2\2\u008c"+
		"\u008d\7g\2\2\u008d\u008e\7p\2\2\u008e\u008f\7w\2\2\u008f\u0090\7o\2\2"+
		"\u0090\22\3\2\2\2\u0091\u0092\7v\2\2\u0092\u0093\7t\2\2\u0093\u0094\7"+
		"w\2\2\u0094\u0095\7g\2\2\u0095\24\3\2\2\2\u0096\u0097\7h\2\2\u0097\u0098"+
		"\7c\2\2\u0098\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u009b\7g\2\2\u009b"+
		"\26\3\2\2\2\u009c\u009d\7]\2\2\u009d\30\3\2\2\2\u009e\u009f\7_\2\2\u009f"+
		"\32\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7+\2\2\u00a3"+
		"\36\3\2\2\2\u00a4\u00a5\7}\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7\177\2\2\u00a7"+
		"\"\3\2\2\2\u00a8\u00a9\7C\2\2\u00a9\u00aa\7P\2\2\u00aa\u00ab\7F\2\2\u00ab"+
		"$\3\2\2\2\u00ac\u00ad\7Q\2\2\u00ad\u00ae\7T\2\2\u00ae&\3\2\2\2\u00af\u00b0"+
		"\7P\2\2\u00b0\u00b1\7Q\2\2\u00b1\u00b2\7V\2\2\u00b2(\3\2\2\2\u00b3\u00b4"+
		"\7K\2\2\u00b4\u00b5\7O\2\2\u00b5\u00b6\7R\2\2\u00b6\u00b7\7N\2\2\u00b7"+
		"\u00b8\7K\2\2\u00b8\u00b9\7G\2\2\u00b9\u00ba\7U\2\2\u00ba*\3\2\2\2\u00bb"+
		"\u00bc\7-\2\2\u00bc,\3\2\2\2\u00bd\u00be\7/\2\2\u00be.\3\2\2\2\u00bf\u00c0"+
		"\7,\2\2\u00c0\60\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2\62\3\2\2\2\u00c3\u00c4"+
		"\7>\2\2\u00c4\64\3\2\2\2\u00c5\u00c6\7@\2\2\u00c6\66\3\2\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8\u00c9\7?\2\2\u00c98\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb\u00cc"+
		"\7?\2\2\u00cc:\3\2\2\2\u00cd\u00ce\7>\2\2\u00ce\u00cf\7?\2\2\u00cf<\3"+
		"\2\2\2\u00d0\u00d1\7@\2\2\u00d1\u00d2\7?\2\2\u00d2>\3\2\2\2\u00d3\u00d4"+
		"\7?\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7d\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8"+
		"\7n\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7i\2\2\u00db"+
		"\u00dc\7u\2\2\u00dcB\3\2\2\2\u00dd\u00de\7w\2\2\u00de\u00df\7r\2\2\u00df"+
		"\u00e0\7q\2\2\u00e0\u00e1\7p\2\2\u00e1D\3\2\2\2\u00e2\u00e7\5G$\2\u00e3"+
		"\u00e6\t\2\2\2\u00e4\u00e6\5I%\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2"+
		"\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8F"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\t\3\2\2\u00ebH\3\2\2\2\u00ec"+
		"\u00ed\t\4\2\2\u00edJ\3\2\2\2\u00ee\u00f0\5U+\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2L\3\2\2\2"+
		"\u00f3\u00f4\t\5\2\2\u00f4\u00f5\5K&\2\u00f5N\3\2\2\2\u00f6\u00f7\5K&"+
		"\2\u00f7\u00f8\7\60\2\2\u00f8\u00f9\5K&\2\u00f9P\3\2\2\2\u00fa\u00fb\t"+
		"\5\2\2\u00fb\u00fc\5O(\2\u00fcR\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff"+
		"\7t\2\2\u00ff\u0100\7w\2\2\u0100\u0107\7g\2\2\u0101\u0102\7h\2\2\u0102"+
		"\u0103\7c\2\2\u0103\u0104\7n\2\2\u0104\u0105\7u\2\2\u0105\u0107\7g\2\2"+
		"\u0106\u00fd\3\2\2\2\u0106\u0101\3\2\2\2\u0107T\3\2\2\2\u0108\u010b\7"+
		"\62\2\2\u0109\u010b\5W,\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b"+
		"V\3\2\2\2\u010c\u010d\t\6\2\2\u010dX\3\2\2\2\u010e\u0112\7)\2\2\u010f"+
		"\u0111\n\7\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u011f\7)\2\2\u0116\u011a\7$\2\2\u0117\u0119\n\b\2\2\u0118\u0117\3\2\2"+
		"\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011f\7$\2\2\u011e\u010e\3\2\2\2\u011e"+
		"\u0116\3\2\2\2\u011fZ\3\2\2\2\u0120\u0122\t\t\2\2\u0121\u0120\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0126\b.\2\2\u0126\\\3\2\2\2\u0127\u0128\7\61\2\2\u0128"+
		"\u0129\7,\2\2\u0129\u012d\3\2\2\2\u012a\u012c\13\2\2\2\u012b\u012a\3\2"+
		"\2\2\u012c\u012f\3\2\2\2\u012d\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7,\2\2\u0131\u0132\7\61"+
		"\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b/\3\2\u0134^\3\2\2\2\u0135\u0136"+
		"\7\61\2\2\u0136\u0137\7\61\2\2\u0137\u013b\3\2\2\2\u0138\u013a\n\n\2\2"+
		"\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\b\60\4\2"+
		"\u013f`\3\2\2\2\16\2\u00e5\u00e7\u00f1\u0106\u010a\u0112\u011a\u011e\u0123"+
		"\u012d\u013b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}