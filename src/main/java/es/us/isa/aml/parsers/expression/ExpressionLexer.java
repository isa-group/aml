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
		OR=18, NOT=19, IMPLIES=20, REQUIRES=21, IFF=22, EXCLUDES=23, ADD=24, SUBTRACT=25, 
		MULTIPLY=26, DIVIDE=27, LT=28, GT=29, EQ=30, NEQ=31, LTE=32, GTE=33, ASSIG=34, 
		BELONGS=35, UPON=36, Identifier=37, Integer=38, S_Integer=39, Float=40, 
		S_Float=41, Boolean=42, String=43, WS=44, COMMENT=45, LINE_COMMENT=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'boolean'", "'integer'", "'float'", "'natural'", "'number'", "'set'", 
		"'enum'", "'true'", "'false'", "'['", "']'", "'('", "')'", "'{'", "'}'", 
		"'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'REQUIRES'", "'IFF'", "'EXCLUDES'", 
		"'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", 
		"'='", "'belongs'", "'upon'", "Identifier", "Integer", "S_Integer", "Float", 
		"S_Float", "Boolean", "String", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__0", "BOOLEAN", "INTEGER", "FLOAT", "NATURAL", "NUMBER", "SET", "ENUM", 
		"TRUE", "FALSE", "CA", "CC", "PA", "PC", "LLA", "LLC", "AND", "OR", "NOT", 
		"IMPLIES", "REQUIRES", "IFF", "EXCLUDES", "ADD", "SUBTRACT", "MULTIPLY", 
		"DIVIDE", "LT", "GT", "EQ", "NEQ", "LTE", "GTE", "ASSIG", "BELONGS", "UPON", 
		"Identifier", "Letter", "LetterOrDigit", "Integer", "S_Integer", "Float", 
		"S_Float", "Boolean", "Digit", "NonZeroDigit", "String", "WS", "COMMENT", 
		"LINE_COMMENT"
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
		case 47: WS_action((RuleContext)_localctx, actionIndex); break;

		case 48: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 49: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\60\u015c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\7&\u0102\n&\f&\16&\u0105\13&\3\'\3\'\3"+
		"(\3(\3)\6)\u010c\n)\r)\16)\u010d\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\5-\u0123\n-\3.\3.\5.\u0127\n.\3/\3/\3\60\3\60\7\60"+
		"\u012d\n\60\f\60\16\60\u0130\13\60\3\60\3\60\3\60\7\60\u0135\n\60\f\60"+
		"\16\60\u0138\13\60\3\60\5\60\u013b\n\60\3\61\6\61\u013e\n\61\r\61\16\61"+
		"\u013f\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0148\n\62\f\62\16\62\u014b"+
		"\13\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u0156\n\63\f"+
		"\63\16\63\u0159\13\63\3\63\3\63\3\u0149\64\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1"+
		"\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33"+
		"\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M\2\1"+
		"O\2\1Q(\1S)\1U*\1W+\1Y,\1[\2\1]\2\1_-\1a.\2c/\3e\60\4\3\2\13\4\2/\60a"+
		"a\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2--//\3\2\63;\3\2))\3\2$$\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\u0162\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\3g\3\2\2\2\5i\3\2\2\2\7q\3\2\2\2\ty\3\2\2\2\13\177\3\2\2\2"+
		"\r\u0087\3\2\2\2\17\u008e\3\2\2\2\21\u0092\3\2\2\2\23\u0097\3\2\2\2\25"+
		"\u009c\3\2\2\2\27\u00a2\3\2\2\2\31\u00a4\3\2\2\2\33\u00a6\3\2\2\2\35\u00a8"+
		"\3\2\2\2\37\u00aa\3\2\2\2!\u00ac\3\2\2\2#\u00ae\3\2\2\2%\u00b2\3\2\2\2"+
		"\'\u00b5\3\2\2\2)\u00b9\3\2\2\2+\u00c1\3\2\2\2-\u00ca\3\2\2\2/\u00ce\3"+
		"\2\2\2\61\u00d7\3\2\2\2\63\u00d9\3\2\2\2\65\u00db\3\2\2\2\67\u00dd\3\2"+
		"\2\29\u00df\3\2\2\2;\u00e1\3\2\2\2=\u00e3\3\2\2\2?\u00e6\3\2\2\2A\u00e9"+
		"\3\2\2\2C\u00ec\3\2\2\2E\u00ef\3\2\2\2G\u00f1\3\2\2\2I\u00f9\3\2\2\2K"+
		"\u00fe\3\2\2\2M\u0106\3\2\2\2O\u0108\3\2\2\2Q\u010b\3\2\2\2S\u010f\3\2"+
		"\2\2U\u0112\3\2\2\2W\u0116\3\2\2\2Y\u0122\3\2\2\2[\u0126\3\2\2\2]\u0128"+
		"\3\2\2\2_\u013a\3\2\2\2a\u013d\3\2\2\2c\u0143\3\2\2\2e\u0151\3\2\2\2g"+
		"h\7.\2\2h\4\3\2\2\2ij\7d\2\2jk\7q\2\2kl\7q\2\2lm\7n\2\2mn\7g\2\2no\7c"+
		"\2\2op\7p\2\2p\6\3\2\2\2qr\7k\2\2rs\7p\2\2st\7v\2\2tu\7g\2\2uv\7i\2\2"+
		"vw\7g\2\2wx\7t\2\2x\b\3\2\2\2yz\7h\2\2z{\7n\2\2{|\7q\2\2|}\7c\2\2}~\7"+
		"v\2\2~\n\3\2\2\2\177\u0080\7p\2\2\u0080\u0081\7c\2\2\u0081\u0082\7v\2"+
		"\2\u0082\u0083\7w\2\2\u0083\u0084\7t\2\2\u0084\u0085\7c\2\2\u0085\u0086"+
		"\7n\2\2\u0086\f\3\2\2\2\u0087\u0088\7p\2\2\u0088\u0089\7w\2\2\u0089\u008a"+
		"\7o\2\2\u008a\u008b\7d\2\2\u008b\u008c\7g\2\2\u008c\u008d\7t\2\2\u008d"+
		"\16\3\2\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\u0091\7v\2\2\u0091"+
		"\20\3\2\2\2\u0092\u0093\7g\2\2\u0093\u0094\7p\2\2\u0094\u0095\7w\2\2\u0095"+
		"\u0096\7o\2\2\u0096\22\3\2\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099"+
		"\u009a\7w\2\2\u009a\u009b\7g\2\2\u009b\24\3\2\2\2\u009c\u009d\7h\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2"+
		"\u00a1\26\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3\30\3\2\2\2\u00a4\u00a5\7_\2"+
		"\2\u00a5\32\3\2\2\2\u00a6\u00a7\7*\2\2\u00a7\34\3\2\2\2\u00a8\u00a9\7"+
		"+\2\2\u00a9\36\3\2\2\2\u00aa\u00ab\7}\2\2\u00ab \3\2\2\2\u00ac\u00ad\7"+
		"\177\2\2\u00ad\"\3\2\2\2\u00ae\u00af\7C\2\2\u00af\u00b0\7P\2\2\u00b0\u00b1"+
		"\7F\2\2\u00b1$\3\2\2\2\u00b2\u00b3\7Q\2\2\u00b3\u00b4\7T\2\2\u00b4&\3"+
		"\2\2\2\u00b5\u00b6\7P\2\2\u00b6\u00b7\7Q\2\2\u00b7\u00b8\7V\2\2\u00b8"+
		"(\3\2\2\2\u00b9\u00ba\7K\2\2\u00ba\u00bb\7O\2\2\u00bb\u00bc\7R\2\2\u00bc"+
		"\u00bd\7N\2\2\u00bd\u00be\7K\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7U\2\2"+
		"\u00c0*\3\2\2\2\u00c1\u00c2\7T\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7S\2"+
		"\2\u00c4\u00c5\7W\2\2\u00c5\u00c6\7K\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8"+
		"\7G\2\2\u00c8\u00c9\7U\2\2\u00c9,\3\2\2\2\u00ca\u00cb\7K\2\2\u00cb\u00cc"+
		"\7H\2\2\u00cc\u00cd\7H\2\2\u00cd.\3\2\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d0"+
		"\7Z\2\2\u00d0\u00d1\7E\2\2\u00d1\u00d2\7N\2\2\u00d2\u00d3\7W\2\2\u00d3"+
		"\u00d4\7F\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6\7U\2\2\u00d6\60\3\2\2\2\u00d7"+
		"\u00d8\7-\2\2\u00d8\62\3\2\2\2\u00d9\u00da\7/\2\2\u00da\64\3\2\2\2\u00db"+
		"\u00dc\7,\2\2\u00dc\66\3\2\2\2\u00dd\u00de\7\61\2\2\u00de8\3\2\2\2\u00df"+
		"\u00e0\7>\2\2\u00e0:\3\2\2\2\u00e1\u00e2\7@\2\2\u00e2<\3\2\2\2\u00e3\u00e4"+
		"\7?\2\2\u00e4\u00e5\7?\2\2\u00e5>\3\2\2\2\u00e6\u00e7\7#\2\2\u00e7\u00e8"+
		"\7?\2\2\u00e8@\3\2\2\2\u00e9\u00ea\7>\2\2\u00ea\u00eb\7?\2\2\u00ebB\3"+
		"\2\2\2\u00ec\u00ed\7@\2\2\u00ed\u00ee\7?\2\2\u00eeD\3\2\2\2\u00ef\u00f0"+
		"\7?\2\2\u00f0F\3\2\2\2\u00f1\u00f2\7d\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4"+
		"\7n\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7i\2\2\u00f7"+
		"\u00f8\7u\2\2\u00f8H\3\2\2\2\u00f9\u00fa\7w\2\2\u00fa\u00fb\7r\2\2\u00fb"+
		"\u00fc\7q\2\2\u00fc\u00fd\7p\2\2\u00fdJ\3\2\2\2\u00fe\u0103\5M\'\2\u00ff"+
		"\u0102\t\2\2\2\u0100\u0102\5O(\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2"+
		"\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104L"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\t\3\2\2\u0107N\3\2\2\2\u0108"+
		"\u0109\t\4\2\2\u0109P\3\2\2\2\u010a\u010c\5[.\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010eR\3\2\2\2"+
		"\u010f\u0110\t\5\2\2\u0110\u0111\5Q)\2\u0111T\3\2\2\2\u0112\u0113\5Q)"+
		"\2\u0113\u0114\7\60\2\2\u0114\u0115\5Q)\2\u0115V\3\2\2\2\u0116\u0117\t"+
		"\5\2\2\u0117\u0118\5U+\2\u0118X\3\2\2\2\u0119\u011a\7v\2\2\u011a\u011b"+
		"\7t\2\2\u011b\u011c\7w\2\2\u011c\u0123\7g\2\2\u011d\u011e\7h\2\2\u011e"+
		"\u011f\7c\2\2\u011f\u0120\7n\2\2\u0120\u0121\7u\2\2\u0121\u0123\7g\2\2"+
		"\u0122\u0119\3\2\2\2\u0122\u011d\3\2\2\2\u0123Z\3\2\2\2\u0124\u0127\7"+
		"\62\2\2\u0125\u0127\5]/\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127"+
		"\\\3\2\2\2\u0128\u0129\t\6\2\2\u0129^\3\2\2\2\u012a\u012e\7)\2\2\u012b"+
		"\u012d\n\7\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\u013b\7)\2\2\u0132\u0136\7$\2\2\u0133\u0135\n\b\2\2\u0134\u0133\3\2\2"+
		"\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139"+
		"\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013b\7$\2\2\u013a\u012a\3\2\2\2\u013a"+
		"\u0132\3\2\2\2\u013b`\3\2\2\2\u013c\u013e\t\t\2\2\u013d\u013c\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141\u0142\b\61\2\2\u0142b\3\2\2\2\u0143\u0144\7\61\2\2\u0144"+
		"\u0145\7,\2\2\u0145\u0149\3\2\2\2\u0146\u0148\13\2\2\2\u0147\u0146\3\2"+
		"\2\2\u0148\u014b\3\2\2\2\u0149\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a"+
		"\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7,\2\2\u014d\u014e\7\61"+
		"\2\2\u014e\u014f\3\2\2\2\u014f\u0150\b\62\3\2\u0150d\3\2\2\2\u0151\u0152"+
		"\7\61\2\2\u0152\u0153\7\61\2\2\u0153\u0157\3\2\2\2\u0154\u0156\n\n\2\2"+
		"\u0155\u0154\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015b\b\63\4\2"+
		"\u015bf\3\2\2\2\16\2\u0101\u0103\u010d\u0122\u0126\u012e\u0136\u013a\u013f"+
		"\u0149\u0157";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}