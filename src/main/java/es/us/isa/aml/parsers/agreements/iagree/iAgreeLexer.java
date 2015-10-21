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
package es.us.isa.aml.parsers.agreements.iagree;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class iAgreeLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, TEMPLATE=5, END_TEMPLATE=6, AG_OFFER=7, 
		END_AG_OFFER=8, AGREEMENT=9, END_AGREEMENT=10, INITIATOR=11, RESPONDER=12, 
		SERVICEPROVIDER=13, EXPIRATIONTIME=14, DATEFORMAT=15, GMTZONE=16, GLOBALPERIOD=17, 
		DEFINEDPERIOD=18, METRICS=19, AGREEMENT_TERMS=20, CREATION_CONSTRAINTS=21, 
		GUARANTEE_TERMS=22, SERVICE=23, FEATURES=24, GLOBALDESCRIPTION=25, DESCRIPTION=26, 
		GLOBAL=27, MONITORABLEPROPERTIES=28, GUARANTEES=29, AVAL_AT=30, DEFINED_AT=31, 
		MONITORED_AT=32, PROVIDER=33, CONSUMER=34, VERSION=35, EXCEPT=36, DURING=37, 
		BOOLEAN=38, INTEGER=39, FLOAT=40, NATURAL=41, NUMBER=42, SET=43, ENUM=44, 
		TRUE=45, FALSE=46, WITH=47, END=48, IF=49, ONLY_IF=50, YEARLY=51, MONTHLY=52, 
		WEEKLY=53, DAILY=54, HOURLY=55, MINUTELY=56, PENALTY=57, REWARD=58, CREATED=59, 
		ON=60, FROM=61, OF=62, FOR=63, AS=64, CA=65, CC=66, PA=67, PC=68, LLA=69, 
		LLC=70, EXACTLY_ONE=71, ONE_OR_MORE=72, ALL=73, AND=74, OR=75, NOT=76, 
		IMPLIES=77, REQUIRES=78, IFF=79, EXCLUDES=80, ADD=81, SUBTRACT=82, MULTIPLY=83, 
		DIVIDE=84, LT=85, GT=86, EQ=87, NEQ=88, LTE=89, GTE=90, ASSIG=91, BELONGS=92, 
		UPON=93, Identifier=94, Integer=95, S_Integer=96, Float=97, S_Float=98, 
		Boolean=99, Url=100, Version=101, Date=102, Hour=103, Access=104, Unit=105, 
		String=106, WS=107, COMMENT=108, LINE_COMMENT=109;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "':'", "';'", "'..'", "'Template'", "'EndTemplate'", "'AgreementOffer'", 
		"'EndAgreementOffer'", "'Agreement'", "'EndAgreement'", "'Initiator'", 
		"'Responder'", "'ServiceProvider'", "'ExpirationTime'", "'DateFormat'", 
		"'GMTZone'", "'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", "'AgreementTerms'", 
		"'CreationConstraints'", "'GuaranteeTerms'", "'Service'", "'Features'", 
		"'GlobalDescription'", "'Description'", "'global'", "'MonitorableProperties'", 
		"'guarantees'", "'availableAt'", "'definedAt'", "'monitoredAt'", "'Provider'", 
		"'Consumer'", "'version'", "'except'", "'during'", "'boolean'", "'integer'", 
		"'float'", "'natural'", "'number'", "'set'", "'enum'", "'true'", "'false'", 
		"'with'", "'end'", "'if'", "'onlyIf'", "'yearly'", "'monthly'", "'weekly'", 
		"'daily'", "'hourly'", "'minutely'", "'penalty'", "'reward'", "'Created'", 
		"'on'", "'from'", "'of'", "'for'", "'as'", "'['", "']'", "'('", "')'", 
		"'{'", "'}'", "'exactly one'", "'one or more'", "'all'", "'AND'", "'OR'", 
		"'NOT'", "'IMPLIES'", "'REQUIRES'", "'IFF'", "'EXCLUDES'", "'+'", "'-'", 
		"'*'", "'/'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", "'='", "'belongs'", 
		"'upon'", "Identifier", "Integer", "S_Integer", "Float", "S_Float", "Boolean", 
		"Url", "Version", "Date", "Hour", "Access", "Unit", "String", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "TEMPLATE", "END_TEMPLATE", "AG_OFFER", 
		"END_AG_OFFER", "AGREEMENT", "END_AGREEMENT", "INITIATOR", "RESPONDER", 
		"SERVICEPROVIDER", "EXPIRATIONTIME", "DATEFORMAT", "GMTZONE", "GLOBALPERIOD", 
		"DEFINEDPERIOD", "METRICS", "AGREEMENT_TERMS", "CREATION_CONSTRAINTS", 
		"GUARANTEE_TERMS", "SERVICE", "FEATURES", "GLOBALDESCRIPTION", "DESCRIPTION", 
		"GLOBAL", "MONITORABLEPROPERTIES", "GUARANTEES", "AVAL_AT", "DEFINED_AT", 
		"MONITORED_AT", "PROVIDER", "CONSUMER", "VERSION", "EXCEPT", "DURING", 
		"BOOLEAN", "INTEGER", "FLOAT", "NATURAL", "NUMBER", "SET", "ENUM", "TRUE", 
		"FALSE", "WITH", "END", "IF", "ONLY_IF", "YEARLY", "MONTHLY", "WEEKLY", 
		"DAILY", "HOURLY", "MINUTELY", "PENALTY", "REWARD", "CREATED", "ON", "FROM", 
		"OF", "FOR", "AS", "CA", "CC", "PA", "PC", "LLA", "LLC", "EXACTLY_ONE", 
		"ONE_OR_MORE", "ALL", "AND", "OR", "NOT", "IMPLIES", "REQUIRES", "IFF", 
		"EXCLUDES", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "LT", "GT", "EQ", 
		"NEQ", "LTE", "GTE", "ASSIG", "BELONGS", "UPON", "Identifier", "Letter", 
		"LetterOrDigit", "Integer", "S_Integer", "Float", "S_Float", "Boolean", 
		"Url", "Version", "Date", "Hour", "Access", "Unit", "Digit", "NonZeroDigit", 
		"String", "WS", "COMMENT", "LINE_COMMENT"
	};


	public iAgreeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "iAgree.g4"; }

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
		case 110: WS_action((RuleContext)_localctx, actionIndex); break;

		case 111: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 112: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2o\u0432\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+"+
		"\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\39\39\39\39\39\39\39\3"+
		"9\39\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3B\3B\3C\3"+
		"C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3"+
		"I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3K\3K\3K\3K\3L\3L\3L\3M\3M\3"+
		"M\3M\3N\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3"+
		"Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3"+
		"X\3Y\3Y\3Y\3Z\3Z\3Z\3[\3[\3[\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3^\3^\3^"+
		"\3^\3^\3_\3_\3_\7_\u0394\n_\f_\16_\u0397\13_\3`\3`\3a\3a\3b\6b\u039e\n"+
		"b\rb\16b\u039f\3c\3c\3c\3d\3d\3d\3d\3e\3e\3e\3f\3f\3f\3f\3f\3f\3f\3f\3"+
		"f\5f\u03b5\nf\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\3g\5g\u03c7"+
		"\ng\3g\3g\3g\3g\7g\u03cd\ng\fg\16g\u03d0\13g\3g\3g\3h\3h\3h\6h\u03d7\n"+
		"h\rh\16h\u03d8\3i\3i\3i\3i\3i\3i\3j\5j\u03e2\nj\3j\3j\3j\3j\3j\3j\3j\3"+
		"j\5j\u03ec\nj\3k\3k\3k\6k\u03f1\nk\rk\16k\u03f2\3l\3l\3l\3l\5l\u03f9\n"+
		"l\3m\3m\5m\u03fd\nm\3n\3n\3o\3o\7o\u0403\no\fo\16o\u0406\13o\3o\3o\3o"+
		"\7o\u040b\no\fo\16o\u040e\13o\3o\5o\u0411\no\3p\6p\u0414\np\rp\16p\u0415"+
		"\3p\3p\3q\3q\3q\3q\7q\u041e\nq\fq\16q\u0421\13q\3q\3q\3q\3q\3q\3r\3r\3"+
		"r\3r\7r\u042c\nr\fr\16r\u042f\13r\3r\3r\3\u041fs\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35"+
		"\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1"+
		"\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1"+
		"M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i"+
		"\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083"+
		"C\1\u0085D\1\u0087E\1\u0089F\1\u008bG\1\u008dH\1\u008fI\1\u0091J\1\u0093"+
		"K\1\u0095L\1\u0097M\1\u0099N\1\u009bO\1\u009dP\1\u009fQ\1\u00a1R\1\u00a3"+
		"S\1\u00a5T\1\u00a7U\1\u00a9V\1\u00abW\1\u00adX\1\u00afY\1\u00b1Z\1\u00b3"+
		"[\1\u00b5\\\1\u00b7]\1\u00b9^\1\u00bb_\1\u00bd`\1\u00bf\2\1\u00c1\2\1"+
		"\u00c3a\1\u00c5b\1\u00c7c\1\u00c9d\1\u00cbe\1\u00cdf\1\u00cfg\1\u00d1"+
		"h\1\u00d3i\1\u00d5j\1\u00d7k\1\u00d9\2\1\u00db\2\1\u00ddl\1\u00dfm\2\u00e1"+
		"n\3\u00e3o\4\3\2\16\4\2/\60aa\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2--//\f"+
		"\2##%%\'(-=??A\\aac|~~\u0080\u0080\r\2%%\'(--//\61;??B\\aac|~~\u0080\u0080"+
		"\4\2//\61\61\3\2\63;\3\2))\3\2$$\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u0441"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb"+
		"\3\2\2\2\2\u00bd\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2"+
		"\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1"+
		"\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00dd\3\2\2"+
		"\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\3\u00e5\3\2\2\2\5\u00e7"+
		"\3\2\2\2\7\u00e9\3\2\2\2\t\u00eb\3\2\2\2\13\u00ee\3\2\2\2\r\u00f7\3\2"+
		"\2\2\17\u0103\3\2\2\2\21\u0112\3\2\2\2\23\u0124\3\2\2\2\25\u012e\3\2\2"+
		"\2\27\u013b\3\2\2\2\31\u0145\3\2\2\2\33\u014f\3\2\2\2\35\u015f\3\2\2\2"+
		"\37\u016e\3\2\2\2!\u0179\3\2\2\2#\u0181\3\2\2\2%\u018e\3\2\2\2\'\u019c"+
		"\3\2\2\2)\u01a4\3\2\2\2+\u01b3\3\2\2\2-\u01c7\3\2\2\2/\u01d6\3\2\2\2\61"+
		"\u01de\3\2\2\2\63\u01e7\3\2\2\2\65\u01f9\3\2\2\2\67\u0205\3\2\2\29\u020c"+
		"\3\2\2\2;\u0222\3\2\2\2=\u022d\3\2\2\2?\u0239\3\2\2\2A\u0243\3\2\2\2C"+
		"\u024f\3\2\2\2E\u0258\3\2\2\2G\u0261\3\2\2\2I\u0269\3\2\2\2K\u0270\3\2"+
		"\2\2M\u0277\3\2\2\2O\u027f\3\2\2\2Q\u0287\3\2\2\2S\u028d\3\2\2\2U\u0295"+
		"\3\2\2\2W\u029c\3\2\2\2Y\u02a0\3\2\2\2[\u02a5\3\2\2\2]\u02aa\3\2\2\2_"+
		"\u02b0\3\2\2\2a\u02b5\3\2\2\2c\u02b9\3\2\2\2e\u02bc\3\2\2\2g\u02c3\3\2"+
		"\2\2i\u02ca\3\2\2\2k\u02d2\3\2\2\2m\u02d9\3\2\2\2o\u02df\3\2\2\2q\u02e6"+
		"\3\2\2\2s\u02ef\3\2\2\2u\u02f7\3\2\2\2w\u02fe\3\2\2\2y\u0306\3\2\2\2{"+
		"\u0309\3\2\2\2}\u030e\3\2\2\2\177\u0311\3\2\2\2\u0081\u0315\3\2\2\2\u0083"+
		"\u0318\3\2\2\2\u0085\u031a\3\2\2\2\u0087\u031c\3\2\2\2\u0089\u031e\3\2"+
		"\2\2\u008b\u0320\3\2\2\2\u008d\u0322\3\2\2\2\u008f\u0324\3\2\2\2\u0091"+
		"\u0330\3\2\2\2\u0093\u033c\3\2\2\2\u0095\u0340\3\2\2\2\u0097\u0344\3\2"+
		"\2\2\u0099\u0347\3\2\2\2\u009b\u034b\3\2\2\2\u009d\u0353\3\2\2\2\u009f"+
		"\u035c\3\2\2\2\u00a1\u0360\3\2\2\2\u00a3\u0369\3\2\2\2\u00a5\u036b\3\2"+
		"\2\2\u00a7\u036d\3\2\2\2\u00a9\u036f\3\2\2\2\u00ab\u0371\3\2\2\2\u00ad"+
		"\u0373\3\2\2\2\u00af\u0375\3\2\2\2\u00b1\u0378\3\2\2\2\u00b3\u037b\3\2"+
		"\2\2\u00b5\u037e\3\2\2\2\u00b7\u0381\3\2\2\2\u00b9\u0383\3\2\2\2\u00bb"+
		"\u038b\3\2\2\2\u00bd\u0390\3\2\2\2\u00bf\u0398\3\2\2\2\u00c1\u039a\3\2"+
		"\2\2\u00c3\u039d\3\2\2\2\u00c5\u03a1\3\2\2\2\u00c7\u03a4\3\2\2\2\u00c9"+
		"\u03a8\3\2\2\2\u00cb\u03b4\3\2\2\2\u00cd\u03c6\3\2\2\2\u00cf\u03d3\3\2"+
		"\2\2\u00d1\u03da\3\2\2\2\u00d3\u03e1\3\2\2\2\u00d5\u03ed\3\2\2\2\u00d7"+
		"\u03f8\3\2\2\2\u00d9\u03fc\3\2\2\2\u00db\u03fe\3\2\2\2\u00dd\u0410\3\2"+
		"\2\2\u00df\u0413\3\2\2\2\u00e1\u0419\3\2\2\2\u00e3\u0427\3\2\2\2\u00e5"+
		"\u00e6\7.\2\2\u00e6\4\3\2\2\2\u00e7\u00e8\7<\2\2\u00e8\6\3\2\2\2\u00e9"+
		"\u00ea\7=\2\2\u00ea\b\3\2\2\2\u00eb\u00ec\7\60\2\2\u00ec\u00ed\7\60\2"+
		"\2\u00ed\n\3\2\2\2\u00ee\u00ef\7V\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7"+
		"o\2\2\u00f1\u00f2\7r\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5"+
		"\7v\2\2\u00f5\u00f6\7g\2\2\u00f6\f\3\2\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9"+
		"\7p\2\2\u00f9\u00fa\7f\2\2\u00fa\u00fb\7V\2\2\u00fb\u00fc\7g\2\2\u00fc"+
		"\u00fd\7o\2\2\u00fd\u00fe\7r\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100\7c\2\2"+
		"\u0100\u0101\7v\2\2\u0101\u0102\7g\2\2\u0102\16\3\2\2\2\u0103\u0104\7"+
		"C\2\2\u0104\u0105\7i\2\2\u0105\u0106\7t\2\2\u0106\u0107\7g\2\2\u0107\u0108"+
		"\7g\2\2\u0108\u0109\7o\2\2\u0109\u010a\7g\2\2\u010a\u010b\7p\2\2\u010b"+
		"\u010c\7v\2\2\u010c\u010d\7Q\2\2\u010d\u010e\7h\2\2\u010e\u010f\7h\2\2"+
		"\u010f\u0110\7g\2\2\u0110\u0111\7t\2\2\u0111\20\3\2\2\2\u0112\u0113\7"+
		"G\2\2\u0113\u0114\7p\2\2\u0114\u0115\7f\2\2\u0115\u0116\7C\2\2\u0116\u0117"+
		"\7i\2\2\u0117\u0118\7t\2\2\u0118\u0119\7g\2\2\u0119\u011a\7g\2\2\u011a"+
		"\u011b\7o\2\2\u011b\u011c\7g\2\2\u011c\u011d\7p\2\2\u011d\u011e\7v\2\2"+
		"\u011e\u011f\7Q\2\2\u011f\u0120\7h\2\2\u0120\u0121\7h\2\2\u0121\u0122"+
		"\7g\2\2\u0122\u0123\7t\2\2\u0123\22\3\2\2\2\u0124\u0125\7C\2\2\u0125\u0126"+
		"\7i\2\2\u0126\u0127\7t\2\2\u0127\u0128\7g\2\2\u0128\u0129\7g\2\2\u0129"+
		"\u012a\7o\2\2\u012a\u012b\7g\2\2\u012b\u012c\7p\2\2\u012c\u012d\7v\2\2"+
		"\u012d\24\3\2\2\2\u012e\u012f\7G\2\2\u012f\u0130\7p\2\2\u0130\u0131\7"+
		"f\2\2\u0131\u0132\7C\2\2\u0132\u0133\7i\2\2\u0133\u0134\7t\2\2\u0134\u0135"+
		"\7g\2\2\u0135\u0136\7g\2\2\u0136\u0137\7o\2\2\u0137\u0138\7g\2\2\u0138"+
		"\u0139\7p\2\2\u0139\u013a\7v\2\2\u013a\26\3\2\2\2\u013b\u013c\7K\2\2\u013c"+
		"\u013d\7p\2\2\u013d\u013e\7k\2\2\u013e\u013f\7v\2\2\u013f\u0140\7k\2\2"+
		"\u0140\u0141\7c\2\2\u0141\u0142\7v\2\2\u0142\u0143\7q\2\2\u0143\u0144"+
		"\7t\2\2\u0144\30\3\2\2\2\u0145\u0146\7T\2\2\u0146\u0147\7g\2\2\u0147\u0148"+
		"\7u\2\2\u0148\u0149\7r\2\2\u0149\u014a\7q\2\2\u014a\u014b\7p\2\2\u014b"+
		"\u014c\7f\2\2\u014c\u014d\7g\2\2\u014d\u014e\7t\2\2\u014e\32\3\2\2\2\u014f"+
		"\u0150\7U\2\2\u0150\u0151\7g\2\2\u0151\u0152\7t\2\2\u0152\u0153\7x\2\2"+
		"\u0153\u0154\7k\2\2\u0154\u0155\7e\2\2\u0155\u0156\7g\2\2\u0156\u0157"+
		"\7R\2\2\u0157\u0158\7t\2\2\u0158\u0159\7q\2\2\u0159\u015a\7x\2\2\u015a"+
		"\u015b\7k\2\2\u015b\u015c\7f\2\2\u015c\u015d\7g\2\2\u015d\u015e\7t\2\2"+
		"\u015e\34\3\2\2\2\u015f\u0160\7G\2\2\u0160\u0161\7z\2\2\u0161\u0162\7"+
		"r\2\2\u0162\u0163\7k\2\2\u0163\u0164\7t\2\2\u0164\u0165\7c\2\2\u0165\u0166"+
		"\7v\2\2\u0166\u0167\7k\2\2\u0167\u0168\7q\2\2\u0168\u0169\7p\2\2\u0169"+
		"\u016a\7V\2\2\u016a\u016b\7k\2\2\u016b\u016c\7o\2\2\u016c\u016d\7g\2\2"+
		"\u016d\36\3\2\2\2\u016e\u016f\7F\2\2\u016f\u0170\7c\2\2\u0170\u0171\7"+
		"v\2\2\u0171\u0172\7g\2\2\u0172\u0173\7H\2\2\u0173\u0174\7q\2\2\u0174\u0175"+
		"\7t\2\2\u0175\u0176\7o\2\2\u0176\u0177\7c\2\2\u0177\u0178\7v\2\2\u0178"+
		" \3\2\2\2\u0179\u017a\7I\2\2\u017a\u017b\7O\2\2\u017b\u017c\7V\2\2\u017c"+
		"\u017d\7\\\2\2\u017d\u017e\7q\2\2\u017e\u017f\7p\2\2\u017f\u0180\7g\2"+
		"\2\u0180\"\3\2\2\2\u0181\u0182\7I\2\2\u0182\u0183\7n\2\2\u0183\u0184\7"+
		"q\2\2\u0184\u0185\7d\2\2\u0185\u0186\7c\2\2\u0186\u0187\7n\2\2\u0187\u0188"+
		"\7R\2\2\u0188\u0189\7g\2\2\u0189\u018a\7t\2\2\u018a\u018b\7k\2\2\u018b"+
		"\u018c\7q\2\2\u018c\u018d\7f\2\2\u018d$\3\2\2\2\u018e\u018f\7F\2\2\u018f"+
		"\u0190\7g\2\2\u0190\u0191\7h\2\2\u0191\u0192\7k\2\2\u0192\u0193\7p\2\2"+
		"\u0193\u0194\7g\2\2\u0194\u0195\7f\2\2\u0195\u0196\7R\2\2\u0196\u0197"+
		"\7g\2\2\u0197\u0198\7t\2\2\u0198\u0199\7k\2\2\u0199\u019a\7q\2\2\u019a"+
		"\u019b\7f\2\2\u019b&\3\2\2\2\u019c\u019d\7O\2\2\u019d\u019e\7g\2\2\u019e"+
		"\u019f\7v\2\2\u019f\u01a0\7t\2\2\u01a0\u01a1\7k\2\2\u01a1\u01a2\7e\2\2"+
		"\u01a2\u01a3\7u\2\2\u01a3(\3\2\2\2\u01a4\u01a5\7C\2\2\u01a5\u01a6\7i\2"+
		"\2\u01a6\u01a7\7t\2\2\u01a7\u01a8\7g\2\2\u01a8\u01a9\7g\2\2\u01a9\u01aa"+
		"\7o\2\2\u01aa\u01ab\7g\2\2\u01ab\u01ac\7p\2\2\u01ac\u01ad\7v\2\2\u01ad"+
		"\u01ae\7V\2\2\u01ae\u01af\7g\2\2\u01af\u01b0\7t\2\2\u01b0\u01b1\7o\2\2"+
		"\u01b1\u01b2\7u\2\2\u01b2*\3\2\2\2\u01b3\u01b4\7E\2\2\u01b4\u01b5\7t\2"+
		"\2\u01b5\u01b6\7g\2\2\u01b6\u01b7\7c\2\2\u01b7\u01b8\7v\2\2\u01b8\u01b9"+
		"\7k\2\2\u01b9\u01ba\7q\2\2\u01ba\u01bb\7p\2\2\u01bb\u01bc\7E\2\2\u01bc"+
		"\u01bd\7q\2\2\u01bd\u01be\7p\2\2\u01be\u01bf\7u\2\2\u01bf\u01c0\7v\2\2"+
		"\u01c0\u01c1\7t\2\2\u01c1\u01c2\7c\2\2\u01c2\u01c3\7k\2\2\u01c3\u01c4"+
		"\7p\2\2\u01c4\u01c5\7v\2\2\u01c5\u01c6\7u\2\2\u01c6,\3\2\2\2\u01c7\u01c8"+
		"\7I\2\2\u01c8\u01c9\7w\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb\7t\2\2\u01cb"+
		"\u01cc\7c\2\2\u01cc\u01cd\7p\2\2\u01cd\u01ce\7v\2\2\u01ce\u01cf\7g\2\2"+
		"\u01cf\u01d0\7g\2\2\u01d0\u01d1\7V\2\2\u01d1\u01d2\7g\2\2\u01d2\u01d3"+
		"\7t\2\2\u01d3\u01d4\7o\2\2\u01d4\u01d5\7u\2\2\u01d5.\3\2\2\2\u01d6\u01d7"+
		"\7U\2\2\u01d7\u01d8\7g\2\2\u01d8\u01d9\7t\2\2\u01d9\u01da\7x\2\2\u01da"+
		"\u01db\7k\2\2\u01db\u01dc\7e\2\2\u01dc\u01dd\7g\2\2\u01dd\60\3\2\2\2\u01de"+
		"\u01df\7H\2\2\u01df\u01e0\7g\2\2\u01e0\u01e1\7c\2\2\u01e1\u01e2\7v\2\2"+
		"\u01e2\u01e3\7w\2\2\u01e3\u01e4\7t\2\2\u01e4\u01e5\7g\2\2\u01e5\u01e6"+
		"\7u\2\2\u01e6\62\3\2\2\2\u01e7\u01e8\7I\2\2\u01e8\u01e9\7n\2\2\u01e9\u01ea"+
		"\7q\2\2\u01ea\u01eb\7d\2\2\u01eb\u01ec\7c\2\2\u01ec\u01ed\7n\2\2\u01ed"+
		"\u01ee\7F\2\2\u01ee\u01ef\7g\2\2\u01ef\u01f0\7u\2\2\u01f0\u01f1\7e\2\2"+
		"\u01f1\u01f2\7t\2\2\u01f2\u01f3\7k\2\2\u01f3\u01f4\7r\2\2\u01f4\u01f5"+
		"\7v\2\2\u01f5\u01f6\7k\2\2\u01f6\u01f7\7q\2\2\u01f7\u01f8\7p\2\2\u01f8"+
		"\64\3\2\2\2\u01f9\u01fa\7F\2\2\u01fa\u01fb\7g\2\2\u01fb\u01fc\7u\2\2\u01fc"+
		"\u01fd\7e\2\2\u01fd\u01fe\7t\2\2\u01fe\u01ff\7k\2\2\u01ff\u0200\7r\2\2"+
		"\u0200\u0201\7v\2\2\u0201\u0202\7k\2\2\u0202\u0203\7q\2\2\u0203\u0204"+
		"\7p\2\2\u0204\66\3\2\2\2\u0205\u0206\7i\2\2\u0206\u0207\7n\2\2\u0207\u0208"+
		"\7q\2\2\u0208\u0209\7d\2\2\u0209\u020a\7c\2\2\u020a\u020b\7n\2\2\u020b"+
		"8\3\2\2\2\u020c\u020d\7O\2\2\u020d\u020e\7q\2\2\u020e\u020f\7p\2\2\u020f"+
		"\u0210\7k\2\2\u0210\u0211\7v\2\2\u0211\u0212\7q\2\2\u0212\u0213\7t\2\2"+
		"\u0213\u0214\7c\2\2\u0214\u0215\7d\2\2\u0215\u0216\7n\2\2\u0216\u0217"+
		"\7g\2\2\u0217\u0218\7R\2\2\u0218\u0219\7t\2\2\u0219\u021a\7q\2\2\u021a"+
		"\u021b\7r\2\2\u021b\u021c\7g\2\2\u021c\u021d\7t\2\2\u021d\u021e\7v\2\2"+
		"\u021e\u021f\7k\2\2\u021f\u0220\7g\2\2\u0220\u0221\7u\2\2\u0221:\3\2\2"+
		"\2\u0222\u0223\7i\2\2\u0223\u0224\7w\2\2\u0224\u0225\7c\2\2\u0225\u0226"+
		"\7t\2\2\u0226\u0227\7c\2\2\u0227\u0228\7p\2\2\u0228\u0229\7v\2\2\u0229"+
		"\u022a\7g\2\2\u022a\u022b\7g\2\2\u022b\u022c\7u\2\2\u022c<\3\2\2\2\u022d"+
		"\u022e\7c\2\2\u022e\u022f\7x\2\2\u022f\u0230\7c\2\2\u0230\u0231\7k\2\2"+
		"\u0231\u0232\7n\2\2\u0232\u0233\7c\2\2\u0233\u0234\7d\2\2\u0234\u0235"+
		"\7n\2\2\u0235\u0236\7g\2\2\u0236\u0237\7C\2\2\u0237\u0238\7v\2\2\u0238"+
		">\3\2\2\2\u0239\u023a\7f\2\2\u023a\u023b\7g\2\2\u023b\u023c\7h\2\2\u023c"+
		"\u023d\7k\2\2\u023d\u023e\7p\2\2\u023e\u023f\7g\2\2\u023f\u0240\7f\2\2"+
		"\u0240\u0241\7C\2\2\u0241\u0242\7v\2\2\u0242@\3\2\2\2\u0243\u0244\7o\2"+
		"\2\u0244\u0245\7q\2\2\u0245\u0246\7p\2\2\u0246\u0247\7k\2\2\u0247\u0248"+
		"\7v\2\2\u0248\u0249\7q\2\2\u0249\u024a\7t\2\2\u024a\u024b\7g\2\2\u024b"+
		"\u024c\7f\2\2\u024c\u024d\7C\2\2\u024d\u024e\7v\2\2\u024eB\3\2\2\2\u024f"+
		"\u0250\7R\2\2\u0250\u0251\7t\2\2\u0251\u0252\7q\2\2\u0252\u0253\7x\2\2"+
		"\u0253\u0254\7k\2\2\u0254\u0255\7f\2\2\u0255\u0256\7g\2\2\u0256\u0257"+
		"\7t\2\2\u0257D\3\2\2\2\u0258\u0259\7E\2\2\u0259\u025a\7q\2\2\u025a\u025b"+
		"\7p\2\2\u025b\u025c\7u\2\2\u025c\u025d\7w\2\2\u025d\u025e\7o\2\2\u025e"+
		"\u025f\7g\2\2\u025f\u0260\7t\2\2\u0260F\3\2\2\2\u0261\u0262\7x\2\2\u0262"+
		"\u0263\7g\2\2\u0263\u0264\7t\2\2\u0264\u0265\7u\2\2\u0265\u0266\7k\2\2"+
		"\u0266\u0267\7q\2\2\u0267\u0268\7p\2\2\u0268H\3\2\2\2\u0269\u026a\7g\2"+
		"\2\u026a\u026b\7z\2\2\u026b\u026c\7e\2\2\u026c\u026d\7g\2\2\u026d\u026e"+
		"\7r\2\2\u026e\u026f\7v\2\2\u026fJ\3\2\2\2\u0270\u0271\7f\2\2\u0271\u0272"+
		"\7w\2\2\u0272\u0273\7t\2\2\u0273\u0274\7k\2\2\u0274\u0275\7p\2\2\u0275"+
		"\u0276\7i\2\2\u0276L\3\2\2\2\u0277\u0278\7d\2\2\u0278\u0279\7q\2\2\u0279"+
		"\u027a\7q\2\2\u027a\u027b\7n\2\2\u027b\u027c\7g\2\2\u027c\u027d\7c\2\2"+
		"\u027d\u027e\7p\2\2\u027eN\3\2\2\2\u027f\u0280\7k\2\2\u0280\u0281\7p\2"+
		"\2\u0281\u0282\7v\2\2\u0282\u0283\7g\2\2\u0283\u0284\7i\2\2\u0284\u0285"+
		"\7g\2\2\u0285\u0286\7t\2\2\u0286P\3\2\2\2\u0287\u0288\7h\2\2\u0288\u0289"+
		"\7n\2\2\u0289\u028a\7q\2\2\u028a\u028b\7c\2\2\u028b\u028c\7v\2\2\u028c"+
		"R\3\2\2\2\u028d\u028e\7p\2\2\u028e\u028f\7c\2\2\u028f\u0290\7v\2\2\u0290"+
		"\u0291\7w\2\2\u0291\u0292\7t\2\2\u0292\u0293\7c\2\2\u0293\u0294\7n\2\2"+
		"\u0294T\3\2\2\2\u0295\u0296\7p\2\2\u0296\u0297\7w\2\2\u0297\u0298\7o\2"+
		"\2\u0298\u0299\7d\2\2\u0299\u029a\7g\2\2\u029a\u029b\7t\2\2\u029bV\3\2"+
		"\2\2\u029c\u029d\7u\2\2\u029d\u029e\7g\2\2\u029e\u029f\7v\2\2\u029fX\3"+
		"\2\2\2\u02a0\u02a1\7g\2\2\u02a1\u02a2\7p\2\2\u02a2\u02a3\7w\2\2\u02a3"+
		"\u02a4\7o\2\2\u02a4Z\3\2\2\2\u02a5\u02a6\7v\2\2\u02a6\u02a7\7t\2\2\u02a7"+
		"\u02a8\7w\2\2\u02a8\u02a9\7g\2\2\u02a9\\\3\2\2\2\u02aa\u02ab\7h\2\2\u02ab"+
		"\u02ac\7c\2\2\u02ac\u02ad\7n\2\2\u02ad\u02ae\7u\2\2\u02ae\u02af\7g\2\2"+
		"\u02af^\3\2\2\2\u02b0\u02b1\7y\2\2\u02b1\u02b2\7k\2\2\u02b2\u02b3\7v\2"+
		"\2\u02b3\u02b4\7j\2\2\u02b4`\3\2\2\2\u02b5\u02b6\7g\2\2\u02b6\u02b7\7"+
		"p\2\2\u02b7\u02b8\7f\2\2\u02b8b\3\2\2\2\u02b9\u02ba\7k\2\2\u02ba\u02bb"+
		"\7h\2\2\u02bbd\3\2\2\2\u02bc\u02bd\7q\2\2\u02bd\u02be\7p\2\2\u02be\u02bf"+
		"\7n\2\2\u02bf\u02c0\7{\2\2\u02c0\u02c1\7K\2\2\u02c1\u02c2\7h\2\2\u02c2"+
		"f\3\2\2\2\u02c3\u02c4\7{\2\2\u02c4\u02c5\7g\2\2\u02c5\u02c6\7c\2\2\u02c6"+
		"\u02c7\7t\2\2\u02c7\u02c8\7n\2\2\u02c8\u02c9\7{\2\2\u02c9h\3\2\2\2\u02ca"+
		"\u02cb\7o\2\2\u02cb\u02cc\7q\2\2\u02cc\u02cd\7p\2\2\u02cd\u02ce\7v\2\2"+
		"\u02ce\u02cf\7j\2\2\u02cf\u02d0\7n\2\2\u02d0\u02d1\7{\2\2\u02d1j\3\2\2"+
		"\2\u02d2\u02d3\7y\2\2\u02d3\u02d4\7g\2\2\u02d4\u02d5\7g\2\2\u02d5\u02d6"+
		"\7m\2\2\u02d6\u02d7\7n\2\2\u02d7\u02d8\7{\2\2\u02d8l\3\2\2\2\u02d9\u02da"+
		"\7f\2\2\u02da\u02db\7c\2\2\u02db\u02dc\7k\2\2\u02dc\u02dd\7n\2\2\u02dd"+
		"\u02de\7{\2\2\u02den\3\2\2\2\u02df\u02e0\7j\2\2\u02e0\u02e1\7q\2\2\u02e1"+
		"\u02e2\7w\2\2\u02e2\u02e3\7t\2\2\u02e3\u02e4\7n\2\2\u02e4\u02e5\7{\2\2"+
		"\u02e5p\3\2\2\2\u02e6\u02e7\7o\2\2\u02e7\u02e8\7k\2\2\u02e8\u02e9\7p\2"+
		"\2\u02e9\u02ea\7w\2\2\u02ea\u02eb\7v\2\2\u02eb\u02ec\7g\2\2\u02ec\u02ed"+
		"\7n\2\2\u02ed\u02ee\7{\2\2\u02eer\3\2\2\2\u02ef\u02f0\7r\2\2\u02f0\u02f1"+
		"\7g\2\2\u02f1\u02f2\7p\2\2\u02f2\u02f3\7c\2\2\u02f3\u02f4\7n\2\2\u02f4"+
		"\u02f5\7v\2\2\u02f5\u02f6\7{\2\2\u02f6t\3\2\2\2\u02f7\u02f8\7t\2\2\u02f8"+
		"\u02f9\7g\2\2\u02f9\u02fa\7y\2\2\u02fa\u02fb\7c\2\2\u02fb\u02fc\7t\2\2"+
		"\u02fc\u02fd\7f\2\2\u02fdv\3\2\2\2\u02fe\u02ff\7E\2\2\u02ff\u0300\7t\2"+
		"\2\u0300\u0301\7g\2\2\u0301\u0302\7c\2\2\u0302\u0303\7v\2\2\u0303\u0304"+
		"\7g\2\2\u0304\u0305\7f\2\2\u0305x\3\2\2\2\u0306\u0307\7q\2\2\u0307\u0308"+
		"\7p\2\2\u0308z\3\2\2\2\u0309\u030a\7h\2\2\u030a\u030b\7t\2\2\u030b\u030c"+
		"\7q\2\2\u030c\u030d\7o\2\2\u030d|\3\2\2\2\u030e\u030f\7q\2\2\u030f\u0310"+
		"\7h\2\2\u0310~\3\2\2\2\u0311\u0312\7h\2\2\u0312\u0313\7q\2\2\u0313\u0314"+
		"\7t\2\2\u0314\u0080\3\2\2\2\u0315\u0316\7c\2\2\u0316\u0317\7u\2\2\u0317"+
		"\u0082\3\2\2\2\u0318\u0319\7]\2\2\u0319\u0084\3\2\2\2\u031a\u031b\7_\2"+
		"\2\u031b\u0086\3\2\2\2\u031c\u031d\7*\2\2\u031d\u0088\3\2\2\2\u031e\u031f"+
		"\7+\2\2\u031f\u008a\3\2\2\2\u0320\u0321\7}\2\2\u0321\u008c\3\2\2\2\u0322"+
		"\u0323\7\177\2\2\u0323\u008e\3\2\2\2\u0324\u0325\7g\2\2\u0325\u0326\7"+
		"z\2\2\u0326\u0327\7c\2\2\u0327\u0328\7e\2\2\u0328\u0329\7v\2\2\u0329\u032a"+
		"\7n\2\2\u032a\u032b\7{\2\2\u032b\u032c\7\"\2\2\u032c\u032d\7q\2\2\u032d"+
		"\u032e\7p\2\2\u032e\u032f\7g\2\2\u032f\u0090\3\2\2\2\u0330\u0331\7q\2"+
		"\2\u0331\u0332\7p\2\2\u0332\u0333\7g\2\2\u0333\u0334\7\"\2\2\u0334\u0335"+
		"\7q\2\2\u0335\u0336\7t\2\2\u0336\u0337\7\"\2\2\u0337\u0338\7o\2\2\u0338"+
		"\u0339\7q\2\2\u0339\u033a\7t\2\2\u033a\u033b\7g\2\2\u033b\u0092\3\2\2"+
		"\2\u033c\u033d\7c\2\2\u033d\u033e\7n\2\2\u033e\u033f\7n\2\2\u033f\u0094"+
		"\3\2\2\2\u0340\u0341\7C\2\2\u0341\u0342\7P\2\2\u0342\u0343\7F\2\2\u0343"+
		"\u0096\3\2\2\2\u0344\u0345\7Q\2\2\u0345\u0346\7T\2\2\u0346\u0098\3\2\2"+
		"\2\u0347\u0348\7P\2\2\u0348\u0349\7Q\2\2\u0349\u034a\7V\2\2\u034a\u009a"+
		"\3\2\2\2\u034b\u034c\7K\2\2\u034c\u034d\7O\2\2\u034d\u034e\7R\2\2\u034e"+
		"\u034f\7N\2\2\u034f\u0350\7K\2\2\u0350\u0351\7G\2\2\u0351\u0352\7U\2\2"+
		"\u0352\u009c\3\2\2\2\u0353\u0354\7T\2\2\u0354\u0355\7G\2\2\u0355\u0356"+
		"\7S\2\2\u0356\u0357\7W\2\2\u0357\u0358\7K\2\2\u0358\u0359\7T\2\2\u0359"+
		"\u035a\7G\2\2\u035a\u035b\7U\2\2\u035b\u009e\3\2\2\2\u035c\u035d\7K\2"+
		"\2\u035d\u035e\7H\2\2\u035e\u035f\7H\2\2\u035f\u00a0\3\2\2\2\u0360\u0361"+
		"\7G\2\2\u0361\u0362\7Z\2\2\u0362\u0363\7E\2\2\u0363\u0364\7N\2\2\u0364"+
		"\u0365\7W\2\2\u0365\u0366\7F\2\2\u0366\u0367\7G\2\2\u0367\u0368\7U\2\2"+
		"\u0368\u00a2\3\2\2\2\u0369\u036a\7-\2\2\u036a\u00a4\3\2\2\2\u036b\u036c"+
		"\7/\2\2\u036c\u00a6\3\2\2\2\u036d\u036e\7,\2\2\u036e\u00a8\3\2\2\2\u036f"+
		"\u0370\7\61\2\2\u0370\u00aa\3\2\2\2\u0371\u0372\7>\2\2\u0372\u00ac\3\2"+
		"\2\2\u0373\u0374\7@\2\2\u0374\u00ae\3\2\2\2\u0375\u0376\7?\2\2\u0376\u0377"+
		"\7?\2\2\u0377\u00b0\3\2\2\2\u0378\u0379\7#\2\2\u0379\u037a\7?\2\2\u037a"+
		"\u00b2\3\2\2\2\u037b\u037c\7>\2\2\u037c\u037d\7?\2\2\u037d\u00b4\3\2\2"+
		"\2\u037e\u037f\7@\2\2\u037f\u0380\7?\2\2\u0380\u00b6\3\2\2\2\u0381\u0382"+
		"\7?\2\2\u0382\u00b8\3\2\2\2\u0383\u0384\7d\2\2\u0384\u0385\7g\2\2\u0385"+
		"\u0386\7n\2\2\u0386\u0387\7q\2\2\u0387\u0388\7p\2\2\u0388\u0389\7i\2\2"+
		"\u0389\u038a\7u\2\2\u038a\u00ba\3\2\2\2\u038b\u038c\7w\2\2\u038c\u038d"+
		"\7r\2\2\u038d\u038e\7q\2\2\u038e\u038f\7p\2\2\u038f\u00bc\3\2\2\2\u0390"+
		"\u0395\5\u00bf`\2\u0391\u0394\t\2\2\2\u0392\u0394\5\u00c1a\2\u0393\u0391"+
		"\3\2\2\2\u0393\u0392\3\2\2\2\u0394\u0397\3\2\2\2\u0395\u0393\3\2\2\2\u0395"+
		"\u0396\3\2\2\2\u0396\u00be\3\2\2\2\u0397\u0395\3\2\2\2\u0398\u0399\t\3"+
		"\2\2\u0399\u00c0\3\2\2\2\u039a\u039b\t\4\2\2\u039b\u00c2\3\2\2\2\u039c"+
		"\u039e\5\u00d9m\2\u039d\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u039d"+
		"\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u00c4\3\2\2\2\u03a1\u03a2\t\5\2\2\u03a2"+
		"\u03a3\5\u00c3b\2\u03a3\u00c6\3\2\2\2\u03a4\u03a5\5\u00c3b\2\u03a5\u03a6"+
		"\7\60\2\2\u03a6\u03a7\5\u00c3b\2\u03a7\u00c8\3\2\2\2\u03a8\u03a9\t\5\2"+
		"\2\u03a9\u03aa\5\u00c7d\2\u03aa\u00ca\3\2\2\2\u03ab\u03ac\7v\2\2\u03ac"+
		"\u03ad\7t\2\2\u03ad\u03ae\7w\2\2\u03ae\u03b5\7g\2\2\u03af\u03b0\7h\2\2"+
		"\u03b0\u03b1\7c\2\2\u03b1\u03b2\7n\2\2\u03b2\u03b3\7u\2\2\u03b3\u03b5"+
		"\7g\2\2\u03b4\u03ab\3\2\2\2\u03b4\u03af\3\2\2\2\u03b5\u00cc\3\2\2\2\u03b6"+
		"\u03b7\7j\2\2\u03b7\u03b8\7v\2\2\u03b8\u03b9\7v\2\2\u03b9\u03c7\7r\2\2"+
		"\u03ba\u03bb\7j\2\2\u03bb\u03bc\7v\2\2\u03bc\u03bd\7v\2\2\u03bd\u03be"+
		"\7r\2\2\u03be\u03c7\7u\2\2\u03bf\u03c0\7h\2\2\u03c0\u03c1\7v\2\2\u03c1"+
		"\u03c7\7r\2\2\u03c2\u03c3\7h\2\2\u03c3\u03c4\7k\2\2\u03c4\u03c5\7n\2\2"+
		"\u03c5\u03c7\7g\2\2\u03c6\u03b6\3\2\2\2\u03c6\u03ba\3\2\2\2\u03c6\u03bf"+
		"\3\2\2\2\u03c6\u03c2\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03c9\7<\2\2\u03c9"+
		"\u03ca\7\61\2\2\u03ca\u03ce\7\61\2\2\u03cb\u03cd\t\6\2\2\u03cc\u03cb\3"+
		"\2\2\2\u03cd\u03d0\3\2\2\2\u03ce\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf"+
		"\u03d1\3\2\2\2\u03d0\u03ce\3\2\2\2\u03d1\u03d2\t\7\2\2\u03d2\u00ce\3\2"+
		"\2\2\u03d3\u03d6\5\u00c3b\2\u03d4\u03d5\7\60\2\2\u03d5\u03d7\5\u00c3b"+
		"\2\u03d6\u03d4\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d8\u03d9"+
		"\3\2\2\2\u03d9\u00d0\3\2\2\2\u03da\u03db\5\u00c3b\2\u03db\u03dc\t\b\2"+
		"\2\u03dc\u03dd\5\u00c3b\2\u03dd\u03de\t\b\2\2\u03de\u03df\5\u00c3b\2\u03df"+
		"\u00d2\3\2\2\2\u03e0\u03e2\5\u00d9m\2\u03e1\u03e0\3\2\2\2\u03e1\u03e2"+
		"\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e4\5\u00d9m\2\u03e4\u03e5\7<\2\2"+
		"\u03e5\u03e6\5\u00d9m\2\u03e6\u03eb\5\u00d9m\2\u03e7\u03e8\7<\2\2\u03e8"+
		"\u03e9\5\u00d9m\2\u03e9\u03ea\5\u00d9m\2\u03ea\u03ec\3\2\2\2\u03eb\u03e7"+
		"\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u00d4\3\2\2\2\u03ed\u03f0\5\u00bd_"+
		"\2\u03ee\u03ef\7\60\2\2\u03ef\u03f1\5\u00bd_\2\u03f0\u03ee\3\2\2\2\u03f1"+
		"\u03f2\3\2\2\2\u03f2\u03f0\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u00d6\3\2"+
		"\2\2\u03f4\u03f9\7\'\2\2\u03f5\u03f6\7o\2\2\u03f6\u03f7\7k\2\2\u03f7\u03f9"+
		"\7p\2\2\u03f8\u03f4\3\2\2\2\u03f8\u03f5\3\2\2\2\u03f9\u00d8\3\2\2\2\u03fa"+
		"\u03fd\7\62\2\2\u03fb\u03fd\5\u00dbn\2\u03fc\u03fa\3\2\2\2\u03fc\u03fb"+
		"\3\2\2\2\u03fd\u00da\3\2\2\2\u03fe\u03ff\t\t\2\2\u03ff\u00dc\3\2\2\2\u0400"+
		"\u0404\7)\2\2\u0401\u0403\n\n\2\2\u0402\u0401\3\2\2\2\u0403\u0406\3\2"+
		"\2\2\u0404\u0402\3\2\2\2\u0404\u0405\3\2\2\2\u0405\u0407\3\2\2\2\u0406"+
		"\u0404\3\2\2\2\u0407\u0411\7)\2\2\u0408\u040c\7$\2\2\u0409\u040b\n\13"+
		"\2\2\u040a\u0409\3\2\2\2\u040b\u040e\3\2\2\2\u040c\u040a\3\2\2\2\u040c"+
		"\u040d\3\2\2\2\u040d\u040f\3\2\2\2\u040e\u040c\3\2\2\2\u040f\u0411\7$"+
		"\2\2\u0410\u0400\3\2\2\2\u0410\u0408\3\2\2\2\u0411\u00de\3\2\2\2\u0412"+
		"\u0414\t\f\2\2\u0413\u0412\3\2\2\2\u0414\u0415\3\2\2\2\u0415\u0413\3\2"+
		"\2\2\u0415\u0416\3\2\2\2\u0416\u0417\3\2\2\2\u0417\u0418\bp\2\2\u0418"+
		"\u00e0\3\2\2\2\u0419\u041a\7\61\2\2\u041a\u041b\7,\2\2\u041b\u041f\3\2"+
		"\2\2\u041c\u041e\13\2\2\2\u041d\u041c\3\2\2\2\u041e\u0421\3\2\2\2\u041f"+
		"\u0420\3\2\2\2\u041f\u041d\3\2\2\2\u0420\u0422\3\2\2\2\u0421\u041f\3\2"+
		"\2\2\u0422\u0423\7,\2\2\u0423\u0424\7\61\2\2\u0424\u0425\3\2\2\2\u0425"+
		"\u0426\bq\3\2\u0426\u00e2\3\2\2\2\u0427\u0428\7\61\2\2\u0428\u0429\7\61"+
		"\2\2\u0429\u042d\3\2\2\2\u042a\u042c\n\r\2\2\u042b\u042a\3\2\2\2\u042c"+
		"\u042f\3\2\2\2\u042d\u042b\3\2\2\2\u042d\u042e\3\2\2\2\u042e\u0430\3\2"+
		"\2\2\u042f\u042d\3\2\2\2\u0430\u0431\br\4\2\u0431\u00e4\3\2\2\2\25\2\u0393"+
		"\u0395\u039f\u03b4\u03c6\u03ce\u03d8\u03e1\u03eb\u03f2\u03f8\u03fc\u0404"+
		"\u040c\u0410\u0415\u041f\u042d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}