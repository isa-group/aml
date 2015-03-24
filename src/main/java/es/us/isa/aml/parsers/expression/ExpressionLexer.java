// Generated from C:\Users\ISA Group\Desktop\iAgree\Expression.g4 by ANTLR 4.1
package es.us.isa.aml.parsers.expression;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache
            = new PredictionContextCache();
    public static final int BOOLEAN = 1, INTEGER = 2, FLOAT = 3, NATURAL = 4, NUMBER = 5, SET = 6, ENUM = 7, TRUE = 8,
            FALSE = 9, CA = 10, CC = 11, PA = 12, PC = 13, LLA = 14, LLC = 15, AND = 16, OR = 17, NOT = 18,
            IMPLIES = 19, ADD = 20, SUBTRACT = 21, MULTIPLY = 22, DIVIDE = 23, LT = 24, GT = 25,
            EQ = 26, NEQ = 27, LTE = 28, GTE = 29, ASSIG = 30, BELONGS = 31, UPON = 32, Identifier = 33,
            Integer = 34, S_Integer = 35, Float = 36, S_Float = 37, Boolean = 38, String = 39,
            WS = 40, COMMENT = 41, LINE_COMMENT = 42;
    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    public static final String[] tokenNames = {
        "<INVALID>",
        "'boolean'", "'integer'", "'float'", "'natural'", "'number'", "'set'",
        "'enum'", "'true'", "'false'", "'['", "']'", "'('", "')'", "'{'", "'}'",
        "'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'+'", "'-'", "'*'", "'/'", "'<'",
        "'>'", "'=='", "'!='", "'<='", "'>='", "'='", "'belongs'", "'upon'", "Identifier",
        "Integer", "S_Integer", "Float", "S_Float", "Boolean", "String", "WS",
        "COMMENT", "LINE_COMMENT"
    };
    public static final String[] ruleNames = {
        "BOOLEAN", "INTEGER", "FLOAT", "NATURAL", "NUMBER", "SET", "ENUM", "TRUE",
        "FALSE", "CA", "CC", "PA", "PC", "LLA", "LLC", "AND", "OR", "NOT", "IMPLIES",
        "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "LT", "GT", "EQ", "NEQ", "LTE",
        "GTE", "ASSIG", "BELONGS", "UPON", "Identifier", "Letter", "LetterOrDigit",
        "Integer", "S_Integer", "Float", "S_Float", "Boolean", "Digit", "NonZeroDigit",
        "String", "WS", "COMMENT", "LINE_COMMENT"
    };
    public static final String _serializedATN = "\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2,\u013c\b\1\4\2\t"
            + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
            + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
            + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
            + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
            + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
            + ",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"
            + "\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"
            + "\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"
            + "\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"
            + "\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"
            + "\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"
            + "\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34"
            + "\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3"
            + "!\3!\3!\3!\3\"\3\"\3\"\7\"\u00e2\n\"\f\"\16\"\u00e5\13\"\3#\3#\3$\3$\3"
            + "%\6%\u00ec\n%\r%\16%\u00ed\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)"
            + "\3)\3)\3)\3)\3)\3)\5)\u0103\n)\3*\3*\5*\u0107\n*\3+\3+\3,\3,\7,\u010d"
            + "\n,\f,\16,\u0110\13,\3,\3,\3,\7,\u0115\n,\f,\16,\u0118\13,\3,\5,\u011b"
            + "\n,\3-\6-\u011e\n-\r-\16-\u011f\3-\3-\3.\3.\3.\3.\7.\u0128\n.\f.\16.\u012b"
            + "\13.\3.\3.\3.\3.\3.\3/\3/\3/\3/\7/\u0136\n/\f/\16/\u0139\13/\3/\3/\3\u0129"
            + "\60\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1"
            + "\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1"
            + "+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1"
            + "A\"\1C#\1E\2\1G\2\1I$\1K%\1M&\1O\'\1Q(\1S\2\1U\2\1W)\1Y*\2[+\3],\4\3\2"
            + "\13\4\2/\60aa\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2--//\3\2\63;\3\2))\3\2"
            + "$$\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u0142\2\3\3\2\2\2\2\5\3\2\2\2\2\7"
            + "\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"
            + "\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"
            + "\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"
            + "\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"
            + "\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"
            + "\2A\3\2\2\2\2C\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"
            + "\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5g\3\2"
            + "\2\2\7o\3\2\2\2\tu\3\2\2\2\13}\3\2\2\2\r\u0084\3\2\2\2\17\u0088\3\2\2"
            + "\2\21\u008d\3\2\2\2\23\u0092\3\2\2\2\25\u0098\3\2\2\2\27\u009a\3\2\2\2"
            + "\31\u009c\3\2\2\2\33\u009e\3\2\2\2\35\u00a0\3\2\2\2\37\u00a2\3\2\2\2!"
            + "\u00a4\3\2\2\2#\u00a8\3\2\2\2%\u00ab\3\2\2\2\'\u00af\3\2\2\2)\u00b7\3"
            + "\2\2\2+\u00b9\3\2\2\2-\u00bb\3\2\2\2/\u00bd\3\2\2\2\61\u00bf\3\2\2\2\63"
            + "\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c6\3\2\2\29\u00c9\3\2\2\2;\u00cc"
            + "\3\2\2\2=\u00cf\3\2\2\2?\u00d1\3\2\2\2A\u00d9\3\2\2\2C\u00de\3\2\2\2E"
            + "\u00e6\3\2\2\2G\u00e8\3\2\2\2I\u00eb\3\2\2\2K\u00ef\3\2\2\2M\u00f2\3\2"
            + "\2\2O\u00f6\3\2\2\2Q\u0102\3\2\2\2S\u0106\3\2\2\2U\u0108\3\2\2\2W\u011a"
            + "\3\2\2\2Y\u011d\3\2\2\2[\u0123\3\2\2\2]\u0131\3\2\2\2_`\7d\2\2`a\7q\2"
            + "\2ab\7q\2\2bc\7n\2\2cd\7g\2\2de\7c\2\2ef\7p\2\2f\4\3\2\2\2gh\7k\2\2hi"
            + "\7p\2\2ij\7v\2\2jk\7g\2\2kl\7i\2\2lm\7g\2\2mn\7t\2\2n\6\3\2\2\2op\7h\2"
            + "\2pq\7n\2\2qr\7q\2\2rs\7c\2\2st\7v\2\2t\b\3\2\2\2uv\7p\2\2vw\7c\2\2wx"
            + "\7v\2\2xy\7w\2\2yz\7t\2\2z{\7c\2\2{|\7n\2\2|\n\3\2\2\2}~\7p\2\2~\177\7"
            + "w\2\2\177\u0080\7o\2\2\u0080\u0081\7d\2\2\u0081\u0082\7g\2\2\u0082\u0083"
            + "\7t\2\2\u0083\f\3\2\2\2\u0084\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086\u0087"
            + "\7v\2\2\u0087\16\3\2\2\2\u0088\u0089\7g\2\2\u0089\u008a\7p\2\2\u008a\u008b"
            + "\7w\2\2\u008b\u008c\7o\2\2\u008c\20\3\2\2\2\u008d\u008e\7v\2\2\u008e\u008f"
            + "\7t\2\2\u008f\u0090\7w\2\2\u0090\u0091\7g\2\2\u0091\22\3\2\2\2\u0092\u0093"
            + "\7h\2\2\u0093\u0094\7c\2\2\u0094\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096"
            + "\u0097\7g\2\2\u0097\24\3\2\2\2\u0098\u0099\7]\2\2\u0099\26\3\2\2\2\u009a"
            + "\u009b\7_\2\2\u009b\30\3\2\2\2\u009c\u009d\7*\2\2\u009d\32\3\2\2\2\u009e"
            + "\u009f\7+\2\2\u009f\34\3\2\2\2\u00a0\u00a1\7}\2\2\u00a1\36\3\2\2\2\u00a2"
            + "\u00a3\7\177\2\2\u00a3 \3\2\2\2\u00a4\u00a5\7C\2\2\u00a5\u00a6\7P\2\2"
            + "\u00a6\u00a7\7F\2\2\u00a7\"\3\2\2\2\u00a8\u00a9\7Q\2\2\u00a9\u00aa\7T"
            + "\2\2\u00aa$\3\2\2\2\u00ab\u00ac\7P\2\2\u00ac\u00ad\7Q\2\2\u00ad\u00ae"
            + "\7V\2\2\u00ae&\3\2\2\2\u00af\u00b0\7K\2\2\u00b0\u00b1\7O\2\2\u00b1\u00b2"
            + "\7R\2\2\u00b2\u00b3\7N\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7G\2\2\u00b5"
            + "\u00b6\7U\2\2\u00b6(\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8*\3\2\2\2\u00b9\u00ba"
            + "\7/\2\2\u00ba,\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc.\3\2\2\2\u00bd\u00be\7"
            + "\61\2\2\u00be\60\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\62\3\2\2\2\u00c1\u00c2"
            + "\7@\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7?\2\2\u00c4\u00c5\7?\2\2\u00c5\66"
            + "\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8\7?\2\2\u00c88\3\2\2\2\u00c9\u00ca"
            + "\7>\2\2\u00ca\u00cb\7?\2\2\u00cb:\3\2\2\2\u00cc\u00cd\7@\2\2\u00cd\u00ce"
            + "\7?\2\2\u00ce<\3\2\2\2\u00cf\u00d0\7?\2\2\u00d0>\3\2\2\2\u00d1\u00d2\7"
            + "d\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6"
            + "\7p\2\2\u00d6\u00d7\7i\2\2\u00d7\u00d8\7u\2\2\u00d8@\3\2\2\2\u00d9\u00da"
            + "\7w\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7q\2\2\u00dc\u00dd\7p\2\2\u00dd"
            + "B\3\2\2\2\u00de\u00e3\5E#\2\u00df\u00e2\t\2\2\2\u00e0\u00e2\5G$\2\u00e1"
            + "\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"
            + "\2\2\u00e3\u00e4\3\2\2\2\u00e4D\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7"
            + "\t\3\2\2\u00e7F\3\2\2\2\u00e8\u00e9\t\4\2\2\u00e9H\3\2\2\2\u00ea\u00ec"
            + "\5S*\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"
            + "\u00ee\3\2\2\2\u00eeJ\3\2\2\2\u00ef\u00f0\t\5\2\2\u00f0\u00f1\5I%\2\u00f1"
            + "L\3\2\2\2\u00f2\u00f3\5I%\2\u00f3\u00f4\7\60\2\2\u00f4\u00f5\5I%\2\u00f5"
            + "N\3\2\2\2\u00f6\u00f7\t\5\2\2\u00f7\u00f8\5M\'\2\u00f8P\3\2\2\2\u00f9"
            + "\u00fa\7v\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7w\2\2\u00fc\u0103\7g\2\2"
            + "\u00fd\u00fe\7h\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7n\2\2\u0100\u0101"
            + "\7u\2\2\u0101\u0103\7g\2\2\u0102\u00f9\3\2\2\2\u0102\u00fd\3\2\2\2\u0103"
            + "R\3\2\2\2\u0104\u0107\7\62\2\2\u0105\u0107\5U+\2\u0106\u0104\3\2\2\2\u0106"
            + "\u0105\3\2\2\2\u0107T\3\2\2\2\u0108\u0109\t\6\2\2\u0109V\3\2\2\2\u010a"
            + "\u010e\7)\2\2\u010b\u010d\n\7\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2"
            + "\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110"
            + "\u010e\3\2\2\2\u0111\u011b\7)\2\2\u0112\u0116\7$\2\2\u0113\u0115\n\b\2"
            + "\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117"
            + "\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\7$\2\2\u011a"
            + "\u010a\3\2\2\2\u011a\u0112\3\2\2\2\u011bX\3\2\2\2\u011c\u011e\t\t\2\2"
            + "\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"
            + "\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\b-\2\2\u0122Z\3\2\2\2\u0123\u0124"
            + "\7\61\2\2\u0124\u0125\7,\2\2\u0125\u0129\3\2\2\2\u0126\u0128\13\2\2\2"
            + "\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u012a\3\2\2\2\u0129\u0127"
            + "\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7,\2\2\u012d"
            + "\u012e\7\61\2\2\u012e\u012f\3\2\2\2\u012f\u0130\b.\3\2\u0130\\\3\2\2\2"
            + "\u0131\u0132\7\61\2\2\u0132\u0133\7\61\2\2\u0133\u0137\3\2\2\2\u0134\u0136"
            + "\n\n\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137"
            + "\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\b/"
            + "\4\2\u013b^\3\2\2\2\16\2\u00e1\u00e3\u00ed\u0102\u0106\u010e\u0116\u011a"
            + "\u011f\u0129\u0137";
    public static final ATN _ATN = ATNSimulator.deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public ExpressionLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "Expression.g4";
    }

    @Override
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    @Override
    public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
        switch (ruleIndex) {
            case 43:
                WS_action((RuleContext) _localctx, actionIndex);
                break;

            case 44:
                COMMENT_action((RuleContext) _localctx, actionIndex);
                break;

            case 45:
                LINE_COMMENT_action((RuleContext) _localctx, actionIndex);
                break;
        }
    }

    private void WS_action(RuleContext _localctx, int actionIndex) {
        switch (actionIndex) {
            case 0:
                skip();
                break;
        }
    }

    private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
        switch (actionIndex) {
            case 2:
                skip();
                break;
        }
    }

    private void COMMENT_action(RuleContext _localctx, int actionIndex) {
        switch (actionIndex) {
            case 1:
                skip();
                break;
        }
    }

}
