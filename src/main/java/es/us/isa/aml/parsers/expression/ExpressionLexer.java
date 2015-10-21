<<<<<<< Updated upstream
/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
=======
// Generated from C:\Users\ISA Group\Desktop\Parsers\Expression-parser\Expression.g4 by ANTLR 4.1
>>>>>>> Stashed changes
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
		TRUE=9, FALSE=10, YEARLY=11, MONTHLY=12, WEEKLY=13, DAILY=14, HOURLY=15, 
		MINUTELY=16, SECONDLY=17, YEAR=18, MONTH=19, WEEK=20, DAY=21, HOUR=22, 
		MINUTE=23, SECOND=24, IN=25, BY=26, CA=27, CC=28, PA=29, PC=30, LLA=31, 
		LLC=32, AND=33, OR=34, NOT=35, IMPLIES=36, REQUIRES=37, IFF=38, EXCLUDES=39, 
		ADD=40, SUBTRACT=41, MULTIPLY=42, DIVIDE=43, LT=44, GT=45, EQ=46, NEQ=47, 
		LTE=48, GTE=49, ASSIG=50, BELONGS=51, UPON=52, Identifier=53, Integer=54, 
		S_Integer=55, Float=56, S_Float=57, Boolean=58, String=59, WS=60, COMMENT=61, 
		LINE_COMMENT=62;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'boolean'", "'integer'", "'float'", "'natural'", "'number'", "'set'", 
		"'enum'", "'true'", "'false'", "'yearly'", "'monthly'", "'weekly'", "'daily'", 
		"'hourly'", "'minutely'", "'secondly'", "YEAR", "MONTH", "WEEK", "DAY", 
		"HOUR", "MINUTE", "SECOND", "'in'", "'by'", "'['", "']'", "'('", "')'", 
		"'{'", "'}'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'REQUIRES'", "'IFF'", 
		"'EXCLUDES'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "'!='", 
		"'<='", "'>='", "'='", "'belongs'", "'upon'", "Identifier", "Integer", 
		"S_Integer", "Float", "S_Float", "Boolean", "String", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__0", "BOOLEAN", "INTEGER", "FLOAT", "NATURAL", "NUMBER", "SET", "ENUM", 
		"TRUE", "FALSE", "YEARLY", "MONTHLY", "WEEKLY", "DAILY", "HOURLY", "MINUTELY", 
		"SECONDLY", "YEAR", "MONTH", "WEEK", "DAY", "HOUR", "MINUTE", "SECOND", 
		"IN", "BY", "CA", "CC", "PA", "PC", "LLA", "LLC", "AND", "OR", "NOT", 
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
		case 63: WS_action((RuleContext)_localctx, actionIndex); break;

		case 64: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 65: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2@\u020c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u0101\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u010e\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0119\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0122\n"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u012d\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u013c"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u014b\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\7\66\u01b2"+
		"\n\66\f\66\16\66\u01b5\13\66\3\67\3\67\38\38\39\69\u01bc\n9\r9\169\u01bd"+
		"\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u01d3\n="+
		"\3>\3>\5>\u01d7\n>\3?\3?\3@\3@\7@\u01dd\n@\f@\16@\u01e0\13@\3@\3@\3@\7"+
		"@\u01e5\n@\f@\16@\u01e8\13@\3@\5@\u01eb\n@\3A\6A\u01ee\nA\rA\16A\u01ef"+
		"\3A\3A\3B\3B\3B\3B\7B\u01f8\nB\fB\16B\u01fb\13B\3B\3B\3B\3B\3B\3C\3C\3"+
		"C\3C\7C\u0206\nC\fC\16C\u0209\13C\3C\3C\3\u01f9D\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35"+
		"\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1"+
		"\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1"+
		"M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i"+
		"\66\1k\67\1m\2\1o\2\1q8\1s9\1u:\1w;\1y<\1{\2\1}\2\1\177=\1\u0081>\2\u0083"+
		"?\3\u0085@\4\3\2\13\4\2/\60aa\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2--//\3"+
		"\2\63;\3\2))\3\2$$\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u0219\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3\2\2\2\5\u0089\3\2\2\2\7\u0091\3\2\2"+
		"\2\t\u0099\3\2\2\2\13\u009f\3\2\2\2\r\u00a7\3\2\2\2\17\u00ae\3\2\2\2\21"+
		"\u00b2\3\2\2\2\23\u00b7\3\2\2\2\25\u00bc\3\2\2\2\27\u00c2\3\2\2\2\31\u00c9"+
		"\3\2\2\2\33\u00d1\3\2\2\2\35\u00d8\3\2\2\2\37\u00de\3\2\2\2!\u00e5\3\2"+
		"\2\2#\u00ee\3\2\2\2%\u0100\3\2\2\2\'\u010d\3\2\2\2)\u0118\3\2\2\2+\u0121"+
		"\3\2\2\2-\u012c\3\2\2\2/\u013b\3\2\2\2\61\u014a\3\2\2\2\63\u014c\3\2\2"+
		"\2\65\u014f\3\2\2\2\67\u0152\3\2\2\29\u0154\3\2\2\2;\u0156\3\2\2\2=\u0158"+
		"\3\2\2\2?\u015a\3\2\2\2A\u015c\3\2\2\2C\u015e\3\2\2\2E\u0162\3\2\2\2G"+
		"\u0165\3\2\2\2I\u0169\3\2\2\2K\u0171\3\2\2\2M\u017a\3\2\2\2O\u017e\3\2"+
		"\2\2Q\u0187\3\2\2\2S\u0189\3\2\2\2U\u018b\3\2\2\2W\u018d\3\2\2\2Y\u018f"+
		"\3\2\2\2[\u0191\3\2\2\2]\u0193\3\2\2\2_\u0196\3\2\2\2a\u0199\3\2\2\2c"+
		"\u019c\3\2\2\2e\u019f\3\2\2\2g\u01a1\3\2\2\2i\u01a9\3\2\2\2k\u01ae\3\2"+
		"\2\2m\u01b6\3\2\2\2o\u01b8\3\2\2\2q\u01bb\3\2\2\2s\u01bf\3\2\2\2u\u01c2"+
		"\3\2\2\2w\u01c6\3\2\2\2y\u01d2\3\2\2\2{\u01d6\3\2\2\2}\u01d8\3\2\2\2\177"+
		"\u01ea\3\2\2\2\u0081\u01ed\3\2\2\2\u0083\u01f3\3\2\2\2\u0085\u0201\3\2"+
		"\2\2\u0087\u0088\7.\2\2\u0088\4\3\2\2\2\u0089\u008a\7d\2\2\u008a\u008b"+
		"\7q\2\2\u008b\u008c\7q\2\2\u008c\u008d\7n\2\2\u008d\u008e\7g\2\2\u008e"+
		"\u008f\7c\2\2\u008f\u0090\7p\2\2\u0090\6\3\2\2\2\u0091\u0092\7k\2\2\u0092"+
		"\u0093\7p\2\2\u0093\u0094\7v\2\2\u0094\u0095\7g\2\2\u0095\u0096\7i\2\2"+
		"\u0096\u0097\7g\2\2\u0097\u0098\7t\2\2\u0098\b\3\2\2\2\u0099\u009a\7h"+
		"\2\2\u009a\u009b\7n\2\2\u009b\u009c\7q\2\2\u009c\u009d\7c\2\2\u009d\u009e"+
		"\7v\2\2\u009e\n\3\2\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2"+
		"\7v\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7c\2\2\u00a5"+
		"\u00a6\7n\2\2\u00a6\f\3\2\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7w\2\2\u00a9"+
		"\u00aa\7o\2\2\u00aa\u00ab\7d\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7t\2\2"+
		"\u00ad\16\3\2\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7"+
		"v\2\2\u00b1\20\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5"+
		"\7w\2\2\u00b5\u00b6\7o\2\2\u00b6\22\3\2\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9"+
		"\7t\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7g\2\2\u00bb\24\3\2\2\2\u00bc\u00bd"+
		"\7h\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7u\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\26\3\2\2\2\u00c2\u00c3\7{\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7c\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7{\2\2"+
		"\u00c8\30\3\2\2\2\u00c9\u00ca\7o\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7"+
		"p\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7j\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0"+
		"\7{\2\2\u00d0\32\3\2\2\2\u00d1\u00d2\7y\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7m\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7{\2\2\u00d7"+
		"\34\3\2\2\2\u00d8\u00d9\7f\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7k\2\2\u00db"+
		"\u00dc\7n\2\2\u00dc\u00dd\7{\2\2\u00dd\36\3\2\2\2\u00de\u00df\7j\2\2\u00df"+
		"\u00e0\7q\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7n\2\2"+
		"\u00e3\u00e4\7{\2\2\u00e4 \3\2\2\2\u00e5\u00e6\7o\2\2\u00e6\u00e7\7k\2"+
		"\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7v\2\2\u00ea\u00eb"+
		"\7g\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7{\2\2\u00ed\"\3\2\2\2\u00ee\u00ef"+
		"\7u\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7e\2\2\u00f1\u00f2\7q\2\2\u00f2"+
		"\u00f3\7p\2\2\u00f3\u00f4\7f\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7{\2\2"+
		"\u00f6$\3\2\2\2\u00f7\u00f8\7{\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7c\2"+
		"\2\u00fa\u0101\7t\2\2\u00fb\u00fc\7{\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe"+
		"\7c\2\2\u00fe\u00ff\7t\2\2\u00ff\u0101\7u\2\2\u0100\u00f7\3\2\2\2\u0100"+
		"\u00fb\3\2\2\2\u0101&\3\2\2\2\u0102\u0103\7o\2\2\u0103\u0104\7q\2\2\u0104"+
		"\u0105\7p\2\2\u0105\u0106\7v\2\2\u0106\u010e\7j\2\2\u0107\u0108\7o\2\2"+
		"\u0108\u0109\7q\2\2\u0109\u010a\7p\2\2\u010a\u010b\7v\2\2\u010b\u010c"+
		"\7j\2\2\u010c\u010e\7u\2\2\u010d\u0102\3\2\2\2\u010d\u0107\3\2\2\2\u010e"+
		"(\3\2\2\2\u010f\u0110\7y\2\2\u0110\u0111\7g\2\2\u0111\u0112\7g\2\2\u0112"+
		"\u0119\7m\2\2\u0113\u0114\7y\2\2\u0114\u0115\7g\2\2\u0115\u0116\7g\2\2"+
		"\u0116\u0117\7m\2\2\u0117\u0119\7u\2\2\u0118\u010f\3\2\2\2\u0118\u0113"+
		"\3\2\2\2\u0119*\3\2\2\2\u011a\u011b\7f\2\2\u011b\u011c\7c\2\2\u011c\u0122"+
		"\7{\2\2\u011d\u011e\7f\2\2\u011e\u011f\7c\2\2\u011f\u0120\7{\2\2\u0120"+
		"\u0122\7u\2\2\u0121\u011a\3\2\2\2\u0121\u011d\3\2\2\2\u0122,\3\2\2\2\u0123"+
		"\u0124\7j\2\2\u0124\u0125\7q\2\2\u0125\u0126\7w\2\2\u0126\u012d\7t\2\2"+
		"\u0127\u0128\7j\2\2\u0128\u0129\7q\2\2\u0129\u012a\7w\2\2\u012a\u012b"+
		"\7t\2\2\u012b\u012d\7u\2\2\u012c\u0123\3\2\2\2\u012c\u0127\3\2\2\2\u012d"+
		".\3\2\2\2\u012e\u012f\7o\2\2\u012f\u0130\7k\2\2\u0130\u0131\7p\2\2\u0131"+
		"\u0132\7w\2\2\u0132\u0133\7v\2\2\u0133\u013c\7g\2\2\u0134\u0135\7o\2\2"+
		"\u0135\u0136\7k\2\2\u0136\u0137\7p\2\2\u0137\u0138\7w\2\2\u0138\u0139"+
		"\7v\2\2\u0139\u013a\7g\2\2\u013a\u013c\7u\2\2\u013b\u012e\3\2\2\2\u013b"+
		"\u0134\3\2\2\2\u013c\60\3\2\2\2\u013d\u013e\7u\2\2\u013e\u013f\7g\2\2"+
		"\u013f\u0140\7e\2\2\u0140\u0141\7q\2\2\u0141\u0142\7p\2\2\u0142\u014b"+
		"\7f\2\2\u0143\u0144\7u\2\2\u0144\u0145\7g\2\2\u0145\u0146\7e\2\2\u0146"+
		"\u0147\7q\2\2\u0147\u0148\7p\2\2\u0148\u0149\7f\2\2\u0149\u014b\7u\2\2"+
		"\u014a\u013d\3\2\2\2\u014a\u0143\3\2\2\2\u014b\62\3\2\2\2\u014c\u014d"+
		"\7k\2\2\u014d\u014e\7p\2\2\u014e\64\3\2\2\2\u014f\u0150\7d\2\2\u0150\u0151"+
		"\7{\2\2\u0151\66\3\2\2\2\u0152\u0153\7]\2\2\u01538\3\2\2\2\u0154\u0155"+
		"\7_\2\2\u0155:\3\2\2\2\u0156\u0157\7*\2\2\u0157<\3\2\2\2\u0158\u0159\7"+
		"+\2\2\u0159>\3\2\2\2\u015a\u015b\7}\2\2\u015b@\3\2\2\2\u015c\u015d\7\177"+
		"\2\2\u015dB\3\2\2\2\u015e\u015f\7C\2\2\u015f\u0160\7P\2\2\u0160\u0161"+
		"\7F\2\2\u0161D\3\2\2\2\u0162\u0163\7Q\2\2\u0163\u0164\7T\2\2\u0164F\3"+
		"\2\2\2\u0165\u0166\7P\2\2\u0166\u0167\7Q\2\2\u0167\u0168\7V\2\2\u0168"+
		"H\3\2\2\2\u0169\u016a\7K\2\2\u016a\u016b\7O\2\2\u016b\u016c\7R\2\2\u016c"+
		"\u016d\7N\2\2\u016d\u016e\7K\2\2\u016e\u016f\7G\2\2\u016f\u0170\7U\2\2"+
		"\u0170J\3\2\2\2\u0171\u0172\7T\2\2\u0172\u0173\7G\2\2\u0173\u0174\7S\2"+
		"\2\u0174\u0175\7W\2\2\u0175\u0176\7K\2\2\u0176\u0177\7T\2\2\u0177\u0178"+
		"\7G\2\2\u0178\u0179\7U\2\2\u0179L\3\2\2\2\u017a\u017b\7K\2\2\u017b\u017c"+
		"\7H\2\2\u017c\u017d\7H\2\2\u017dN\3\2\2\2\u017e\u017f\7G\2\2\u017f\u0180"+
		"\7Z\2\2\u0180\u0181\7E\2\2\u0181\u0182\7N\2\2\u0182\u0183\7W\2\2\u0183"+
		"\u0184\7F\2\2\u0184\u0185\7G\2\2\u0185\u0186\7U\2\2\u0186P\3\2\2\2\u0187"+
		"\u0188\7-\2\2\u0188R\3\2\2\2\u0189\u018a\7/\2\2\u018aT\3\2\2\2\u018b\u018c"+
		"\7,\2\2\u018cV\3\2\2\2\u018d\u018e\7\61\2\2\u018eX\3\2\2\2\u018f\u0190"+
		"\7>\2\2\u0190Z\3\2\2\2\u0191\u0192\7@\2\2\u0192\\\3\2\2\2\u0193\u0194"+
		"\7?\2\2\u0194\u0195\7?\2\2\u0195^\3\2\2\2\u0196\u0197\7#\2\2\u0197\u0198"+
		"\7?\2\2\u0198`\3\2\2\2\u0199\u019a\7>\2\2\u019a\u019b\7?\2\2\u019bb\3"+
		"\2\2\2\u019c\u019d\7@\2\2\u019d\u019e\7?\2\2\u019ed\3\2\2\2\u019f\u01a0"+
		"\7?\2\2\u01a0f\3\2\2\2\u01a1\u01a2\7d\2\2\u01a2\u01a3\7g\2\2\u01a3\u01a4"+
		"\7n\2\2\u01a4\u01a5\7q\2\2\u01a5\u01a6\7p\2\2\u01a6\u01a7\7i\2\2\u01a7"+
		"\u01a8\7u\2\2\u01a8h\3\2\2\2\u01a9\u01aa\7w\2\2\u01aa\u01ab\7r\2\2\u01ab"+
		"\u01ac\7q\2\2\u01ac\u01ad\7p\2\2\u01adj\3\2\2\2\u01ae\u01b3\5m\67\2\u01af"+
		"\u01b2\t\2\2\2\u01b0\u01b2\5o8\2\u01b1\u01af\3\2\2\2\u01b1\u01b0\3\2\2"+
		"\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4l"+
		"\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\t\3\2\2\u01b7n\3\2\2\2\u01b8"+
		"\u01b9\t\4\2\2\u01b9p\3\2\2\2\u01ba\u01bc\5{>\2\u01bb\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01ber\3\2\2\2"+
		"\u01bf\u01c0\t\5\2\2\u01c0\u01c1\5q9\2\u01c1t\3\2\2\2\u01c2\u01c3\5q9"+
		"\2\u01c3\u01c4\7\60\2\2\u01c4\u01c5\5q9\2\u01c5v\3\2\2\2\u01c6\u01c7\t"+
		"\5\2\2\u01c7\u01c8\5u;\2\u01c8x\3\2\2\2\u01c9\u01ca\7v\2\2\u01ca\u01cb"+
		"\7t\2\2\u01cb\u01cc\7w\2\2\u01cc\u01d3\7g\2\2\u01cd\u01ce\7h\2\2\u01ce"+
		"\u01cf\7c\2\2\u01cf\u01d0\7n\2\2\u01d0\u01d1\7u\2\2\u01d1\u01d3\7g\2\2"+
		"\u01d2\u01c9\3\2\2\2\u01d2\u01cd\3\2\2\2\u01d3z\3\2\2\2\u01d4\u01d7\7"+
		"\62\2\2\u01d5\u01d7\5}?\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5\3\2\2\2\u01d7"+
		"|\3\2\2\2\u01d8\u01d9\t\6\2\2\u01d9~\3\2\2\2\u01da\u01de\7)\2\2\u01db"+
		"\u01dd\n\7\2\2\u01dc\u01db\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2"+
		"\2\2\u01de\u01df\3\2\2\2\u01df\u01e1\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1"+
		"\u01eb\7)\2\2\u01e2\u01e6\7$\2\2\u01e3\u01e5\n\b\2\2\u01e4\u01e3\3\2\2"+
		"\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9"+
		"\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01eb\7$\2\2\u01ea\u01da\3\2\2\2\u01ea"+
		"\u01e2\3\2\2\2\u01eb\u0080\3\2\2\2\u01ec\u01ee\t\t\2\2\u01ed\u01ec\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f1\3\2\2\2\u01f1\u01f2\bA\2\2\u01f2\u0082\3\2\2\2\u01f3\u01f4\7\61"+
		"\2\2\u01f4\u01f5\7,\2\2\u01f5\u01f9\3\2\2\2\u01f6\u01f8\13\2\2\2\u01f7"+
		"\u01f6\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01fa\3\2\2\2\u01f9\u01f7\3\2"+
		"\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01fd\7,\2\2\u01fd"+
		"\u01fe\7\61\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\bB\3\2\u0200\u0084\3\2"+
		"\2\2\u0201\u0202\7\61\2\2\u0202\u0203\7\61\2\2\u0203\u0207\3\2\2\2\u0204"+
		"\u0206\n\n\2\2\u0205\u0204\3\2\2\2\u0206\u0209\3\2\2\2\u0207\u0205\3\2"+
		"\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u0207\3\2\2\2\u020a"+
		"\u020b\bC\4\2\u020b\u0086\3\2\2\2\25\2\u0100\u010d\u0118\u0121\u012c\u013b"+
		"\u014a\u01b1\u01b3\u01bd\u01d2\u01d6\u01de\u01e6\u01ea\u01ef\u01f9\u0207";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}