// Generated from C:\Users\ISA Group\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package isa.us.es.aml.parsers.iagree;
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
		END_AG_OFFER=8, INITIATOR=9, RESPONDER=10, SERVICEPROVIDER=11, EXPIRATIONTIME=12, 
		DATEFORMAT=13, GMTZONE=14, GLOBALPERIOD=15, DEFINEDPERIOD=16, METRICS=17, 
		AGREEMENT_TERMS=18, CREATION_CONSTRAINTS=19, GUARANTEE_TERMS=20, SERVICE=21, 
		FEATURES=22, GLOBALDESCRIPTION=23, DESCRIPTION=24, GLOBAL=25, MONITORABLEPROPERTIES=26, 
		GUARANTEES=27, AVAL_AT=28, PROVIDER=29, CONSUMER=30, VERSION=31, EXCEPT=32, 
		DURING=33, BOOLEAN=34, INTEGER=35, FLOAT=36, NATURAL=37, NUMBER=38, SET=39, 
		ENUM=40, TRUE=41, FALSE=42, WITH=43, END=44, IF=45, YEARLY=46, MONTHLY=47, 
		WEEKLY=48, DAILY=49, HOURLY=50, MINUTELY=51, PENALTY=52, REWARD=53, ON=54, 
		FROM=55, OF=56, FOR=57, AS=58, CA=59, CC=60, PA=61, PC=62, LLA=63, LLC=64, 
		AND=65, OR=66, NOT=67, IMPLIES=68, ONLY_IF=69, EXACTLY_ONE=70, ONE_OR_MORE=71, 
		ALL=72, LT=73, GT=74, EQ=75, NEQ=76, LTE=77, GTE=78, ADD=79, SUBTRACT=80, 
		MULTIPLY=81, DIVIDE=82, ASSIG=83, BELONGS=84, UPON=85, Identifier=86, 
		Integer=87, S_Integer=88, Float=89, S_Float=90, Boolean=91, Url=92, Version=93, 
		Date=94, Hour=95, Access=96, Unit=97, String=98, WS=99, COMMENT=100, LINE_COMMENT=101;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "':'", "';'", "'..'", "'Template'", "'EndTemplate'", "'AgreementOffer'", 
		"'EndAgreementOffer'", "'Initiator'", "'Responder'", "'ServiceProvider'", 
		"'ExpirationTime'", "'DateFormat'", "'GMTZone'", "'GlobalPeriod'", "'DefinedPeriod'", 
		"'Metrics'", "'AgreementTerms'", "'CreationConstraints'", "'GuaranteeTerms'", 
		"'Service'", "'Features/Operations'", "'GlobalDescription'", "'Description'", 
		"'global'", "'MonitorableProperties'", "'guarantees'", "'availableAt.'", 
		"'Provider'", "'Consumer'", "'version'", "'except'", "'during'", "'boolean'", 
		"'integer'", "'float'", "'natural'", "'number'", "'set'", "'enum'", "'true'", 
		"'false'", "'with'", "'end'", "'if'", "'yearly'", "'monthly'", "'weekly'", 
		"'daily'", "'hourly'", "'minutely'", "'penalty'", "'reward'", "'on'", 
		"'from'", "'of'", "'for'", "'as'", "'['", "']'", "'('", "')'", "'{'", 
		"'}'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'onlyIf'", "'exactly one'", 
		"'one or more'", "'all'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", 
		"'+'", "'-'", "'*'", "'/'", "'='", "'belongs'", "'upon'", "Identifier", 
		"Integer", "S_Integer", "Float", "S_Float", "Boolean", "Url", "Version", 
		"Date", "Hour", "Access", "Unit", "String", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "TEMPLATE", "END_TEMPLATE", "AG_OFFER", 
		"END_AG_OFFER", "INITIATOR", "RESPONDER", "SERVICEPROVIDER", "EXPIRATIONTIME", 
		"DATEFORMAT", "GMTZONE", "GLOBALPERIOD", "DEFINEDPERIOD", "METRICS", "AGREEMENT_TERMS", 
		"CREATION_CONSTRAINTS", "GUARANTEE_TERMS", "SERVICE", "FEATURES", "GLOBALDESCRIPTION", 
		"DESCRIPTION", "GLOBAL", "MONITORABLEPROPERTIES", "GUARANTEES", "AVAL_AT", 
		"PROVIDER", "CONSUMER", "VERSION", "EXCEPT", "DURING", "BOOLEAN", "INTEGER", 
		"FLOAT", "NATURAL", "NUMBER", "SET", "ENUM", "TRUE", "FALSE", "WITH", 
		"END", "IF", "YEARLY", "MONTHLY", "WEEKLY", "DAILY", "HOURLY", "MINUTELY", 
		"PENALTY", "REWARD", "ON", "FROM", "OF", "FOR", "AS", "CA", "CC", "PA", 
		"PC", "LLA", "LLC", "AND", "OR", "NOT", "IMPLIES", "ONLY_IF", "EXACTLY_ONE", 
		"ONE_OR_MORE", "ALL", "LT", "GT", "EQ", "NEQ", "LTE", "GTE", "ADD", "SUBTRACT", 
		"MULTIPLY", "DIVIDE", "ASSIG", "BELONGS", "UPON", "Identifier", "Letter", 
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
		case 102: WS_action((RuleContext)_localctx, actionIndex); break;

		case 103: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 104: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2g\u03de\b\1\4\2\t"+
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
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%"+
		"\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3"+
		",\3,\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\38\38\39\39\39\3:\3"+
		":\3:\3:\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3B\3C\3"+
		"C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3G\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3"+
		"I\3I\3I\3J\3J\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3Q\3Q\3"+
		"R\3R\3S\3S\3T\3T\3U\3U\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3W\3W\3W\7W\u0345"+
		"\nW\fW\16W\u0348\13W\3X\3X\3Y\3Y\3Z\6Z\u034f\nZ\rZ\16Z\u0350\3[\3[\3["+
		"\3\\\3\\\3\\\3\\\3]\3]\3]\3^\3^\3^\3^\3^\3^\3^\3^\3^\5^\u0366\n^\3_\3"+
		"_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\5_\u0378\n_\3_\3_\3_\3_\7"+
		"_\u037e\n_\f_\16_\u0381\13_\3_\3_\3`\3`\3`\6`\u0388\n`\r`\16`\u0389\3"+
		"a\3a\3a\3a\3a\3a\3b\5b\u0393\nb\3b\3b\3b\3b\3b\3c\3c\3c\6c\u039d\nc\r"+
		"c\16c\u039e\3d\3d\3d\3d\5d\u03a5\nd\3e\3e\5e\u03a9\ne\3f\3f\3g\3g\7g\u03af"+
		"\ng\fg\16g\u03b2\13g\3g\3g\3g\7g\u03b7\ng\fg\16g\u03ba\13g\3g\5g\u03bd"+
		"\ng\3h\6h\u03c0\nh\rh\16h\u03c1\3h\3h\3i\3i\3i\3i\7i\u03ca\ni\fi\16i\u03cd"+
		"\13i\3i\3i\3i\3i\3i\3j\3j\3j\3j\7j\u03d8\nj\fj\16j\u03db\13j\3j\3j\3\u03cb"+
		"k\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177"+
		"A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089F\1\u008bG\1\u008dH\1\u008f"+
		"I\1\u0091J\1\u0093K\1\u0095L\1\u0097M\1\u0099N\1\u009bO\1\u009dP\1\u009f"+
		"Q\1\u00a1R\1\u00a3S\1\u00a5T\1\u00a7U\1\u00a9V\1\u00abW\1\u00adX\1\u00af"+
		"\2\1\u00b1\2\1\u00b3Y\1\u00b5Z\1\u00b7[\1\u00b9\\\1\u00bb]\1\u00bd^\1"+
		"\u00bf_\1\u00c1`\1\u00c3a\1\u00c5b\1\u00c7c\1\u00c9\2\1\u00cb\2\1\u00cd"+
		"d\1\u00cfe\2\u00d1f\3\u00d3g\4\3\2\16\4\2/\60aa\6\2&&C\\aac|\7\2&&\62"+
		";C\\aac|\4\2--//\f\2##%%\'(-=??A\\aac|~~\u0080\u0080\r\2%%\'(--//\61;"+
		"??B\\aac|~~\u0080\u0080\4\2//\61\61\3\2\63;\3\2))\3\2$$\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\u03ec\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2"+
		"\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00b3"+
		"\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2"+
		"\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5"+
		"\3\2\2\2\2\u00c7\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2"+
		"\2\2\u00d3\3\2\2\2\3\u00d5\3\2\2\2\5\u00d7\3\2\2\2\7\u00d9\3\2\2\2\t\u00db"+
		"\3\2\2\2\13\u00de\3\2\2\2\r\u00e7\3\2\2\2\17\u00f3\3\2\2\2\21\u0102\3"+
		"\2\2\2\23\u0114\3\2\2\2\25\u011e\3\2\2\2\27\u0128\3\2\2\2\31\u0138\3\2"+
		"\2\2\33\u0147\3\2\2\2\35\u0152\3\2\2\2\37\u015a\3\2\2\2!\u0167\3\2\2\2"+
		"#\u0175\3\2\2\2%\u017d\3\2\2\2\'\u018c\3\2\2\2)\u01a0\3\2\2\2+\u01af\3"+
		"\2\2\2-\u01b7\3\2\2\2/\u01cb\3\2\2\2\61\u01dd\3\2\2\2\63\u01e9\3\2\2\2"+
		"\65\u01f0\3\2\2\2\67\u0206\3\2\2\29\u0211\3\2\2\2;\u021e\3\2\2\2=\u0227"+
		"\3\2\2\2?\u0230\3\2\2\2A\u0238\3\2\2\2C\u023f\3\2\2\2E\u0246\3\2\2\2G"+
		"\u024e\3\2\2\2I\u0256\3\2\2\2K\u025c\3\2\2\2M\u0264\3\2\2\2O\u026b\3\2"+
		"\2\2Q\u026f\3\2\2\2S\u0274\3\2\2\2U\u0279\3\2\2\2W\u027f\3\2\2\2Y\u0284"+
		"\3\2\2\2[\u0288\3\2\2\2]\u028b\3\2\2\2_\u0292\3\2\2\2a\u029a\3\2\2\2c"+
		"\u02a1\3\2\2\2e\u02a7\3\2\2\2g\u02ae\3\2\2\2i\u02b7\3\2\2\2k\u02bf\3\2"+
		"\2\2m\u02c6\3\2\2\2o\u02c9\3\2\2\2q\u02ce\3\2\2\2s\u02d1\3\2\2\2u\u02d5"+
		"\3\2\2\2w\u02d8\3\2\2\2y\u02da\3\2\2\2{\u02dc\3\2\2\2}\u02de\3\2\2\2\177"+
		"\u02e0\3\2\2\2\u0081\u02e2\3\2\2\2\u0083\u02e4\3\2\2\2\u0085\u02e8\3\2"+
		"\2\2\u0087\u02eb\3\2\2\2\u0089\u02ef\3\2\2\2\u008b\u02f7\3\2\2\2\u008d"+
		"\u02fe\3\2\2\2\u008f\u030a\3\2\2\2\u0091\u0316\3\2\2\2\u0093\u031a\3\2"+
		"\2\2\u0095\u031c\3\2\2\2\u0097\u031e\3\2\2\2\u0099\u0321\3\2\2\2\u009b"+
		"\u0324\3\2\2\2\u009d\u0327\3\2\2\2\u009f\u032a\3\2\2\2\u00a1\u032c\3\2"+
		"\2\2\u00a3\u032e\3\2\2\2\u00a5\u0330\3\2\2\2\u00a7\u0332\3\2\2\2\u00a9"+
		"\u0334\3\2\2\2\u00ab\u033c\3\2\2\2\u00ad\u0341\3\2\2\2\u00af\u0349\3\2"+
		"\2\2\u00b1\u034b\3\2\2\2\u00b3\u034e\3\2\2\2\u00b5\u0352\3\2\2\2\u00b7"+
		"\u0355\3\2\2\2\u00b9\u0359\3\2\2\2\u00bb\u0365\3\2\2\2\u00bd\u0377\3\2"+
		"\2\2\u00bf\u0384\3\2\2\2\u00c1\u038b\3\2\2\2\u00c3\u0392\3\2\2\2\u00c5"+
		"\u0399\3\2\2\2\u00c7\u03a4\3\2\2\2\u00c9\u03a8\3\2\2\2\u00cb\u03aa\3\2"+
		"\2\2\u00cd\u03bc\3\2\2\2\u00cf\u03bf\3\2\2\2\u00d1\u03c5\3\2\2\2\u00d3"+
		"\u03d3\3\2\2\2\u00d5\u00d6\7.\2\2\u00d6\4\3\2\2\2\u00d7\u00d8\7<\2\2\u00d8"+
		"\6\3\2\2\2\u00d9\u00da\7=\2\2\u00da\b\3\2\2\2\u00db\u00dc\7\60\2\2\u00dc"+
		"\u00dd\7\60\2\2\u00dd\n\3\2\2\2\u00de\u00df\7V\2\2\u00df\u00e0\7g\2\2"+
		"\u00e0\u00e1\7o\2\2\u00e1\u00e2\7r\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4"+
		"\7c\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7g\2\2\u00e6\f\3\2\2\2\u00e7\u00e8"+
		"\7G\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7f\2\2\u00ea\u00eb\7V\2\2\u00eb"+
		"\u00ec\7g\2\2\u00ec\u00ed\7o\2\2\u00ed\u00ee\7r\2\2\u00ee\u00ef\7n\2\2"+
		"\u00ef\u00f0\7c\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7g\2\2\u00f2\16\3\2"+
		"\2\2\u00f3\u00f4\7C\2\2\u00f4\u00f5\7i\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7o\2\2\u00f9\u00fa\7g\2\2\u00fa"+
		"\u00fb\7p\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7Q\2\2\u00fd\u00fe\7h\2\2"+
		"\u00fe\u00ff\7h\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7t\2\2\u0101\20\3\2"+
		"\2\2\u0102\u0103\7G\2\2\u0103\u0104\7p\2\2\u0104\u0105\7f\2\2\u0105\u0106"+
		"\7C\2\2\u0106\u0107\7i\2\2\u0107\u0108\7t\2\2\u0108\u0109\7g\2\2\u0109"+
		"\u010a\7g\2\2\u010a\u010b\7o\2\2\u010b\u010c\7g\2\2\u010c\u010d\7p\2\2"+
		"\u010d\u010e\7v\2\2\u010e\u010f\7Q\2\2\u010f\u0110\7h\2\2\u0110\u0111"+
		"\7h\2\2\u0111\u0112\7g\2\2\u0112\u0113\7t\2\2\u0113\22\3\2\2\2\u0114\u0115"+
		"\7K\2\2\u0115\u0116\7p\2\2\u0116\u0117\7k\2\2\u0117\u0118\7v\2\2\u0118"+
		"\u0119\7k\2\2\u0119\u011a\7c\2\2\u011a\u011b\7v\2\2\u011b\u011c\7q\2\2"+
		"\u011c\u011d\7t\2\2\u011d\24\3\2\2\2\u011e\u011f\7T\2\2\u011f\u0120\7"+
		"g\2\2\u0120\u0121\7u\2\2\u0121\u0122\7r\2\2\u0122\u0123\7q\2\2\u0123\u0124"+
		"\7p\2\2\u0124\u0125\7f\2\2\u0125\u0126\7g\2\2\u0126\u0127\7t\2\2\u0127"+
		"\26\3\2\2\2\u0128\u0129\7U\2\2\u0129\u012a\7g\2\2\u012a\u012b\7t\2\2\u012b"+
		"\u012c\7x\2\2\u012c\u012d\7k\2\2\u012d\u012e\7e\2\2\u012e\u012f\7g\2\2"+
		"\u012f\u0130\7R\2\2\u0130\u0131\7t\2\2\u0131\u0132\7q\2\2\u0132\u0133"+
		"\7x\2\2\u0133\u0134\7k\2\2\u0134\u0135\7f\2\2\u0135\u0136\7g\2\2\u0136"+
		"\u0137\7t\2\2\u0137\30\3\2\2\2\u0138\u0139\7G\2\2\u0139\u013a\7z\2\2\u013a"+
		"\u013b\7r\2\2\u013b\u013c\7k\2\2\u013c\u013d\7t\2\2\u013d\u013e\7c\2\2"+
		"\u013e\u013f\7v\2\2\u013f\u0140\7k\2\2\u0140\u0141\7q\2\2\u0141\u0142"+
		"\7p\2\2\u0142\u0143\7V\2\2\u0143\u0144\7k\2\2\u0144\u0145\7o\2\2\u0145"+
		"\u0146\7g\2\2\u0146\32\3\2\2\2\u0147\u0148\7F\2\2\u0148\u0149\7c\2\2\u0149"+
		"\u014a\7v\2\2\u014a\u014b\7g\2\2\u014b\u014c\7H\2\2\u014c\u014d\7q\2\2"+
		"\u014d\u014e\7t\2\2\u014e\u014f\7o\2\2\u014f\u0150\7c\2\2\u0150\u0151"+
		"\7v\2\2\u0151\34\3\2\2\2\u0152\u0153\7I\2\2\u0153\u0154\7O\2\2\u0154\u0155"+
		"\7V\2\2\u0155\u0156\7\\\2\2\u0156\u0157\7q\2\2\u0157\u0158\7p\2\2\u0158"+
		"\u0159\7g\2\2\u0159\36\3\2\2\2\u015a\u015b\7I\2\2\u015b\u015c\7n\2\2\u015c"+
		"\u015d\7q\2\2\u015d\u015e\7d\2\2\u015e\u015f\7c\2\2\u015f\u0160\7n\2\2"+
		"\u0160\u0161\7R\2\2\u0161\u0162\7g\2\2\u0162\u0163\7t\2\2\u0163\u0164"+
		"\7k\2\2\u0164\u0165\7q\2\2\u0165\u0166\7f\2\2\u0166 \3\2\2\2\u0167\u0168"+
		"\7F\2\2\u0168\u0169\7g\2\2\u0169\u016a\7h\2\2\u016a\u016b\7k\2\2\u016b"+
		"\u016c\7p\2\2\u016c\u016d\7g\2\2\u016d\u016e\7f\2\2\u016e\u016f\7R\2\2"+
		"\u016f\u0170\7g\2\2\u0170\u0171\7t\2\2\u0171\u0172\7k\2\2\u0172\u0173"+
		"\7q\2\2\u0173\u0174\7f\2\2\u0174\"\3\2\2\2\u0175\u0176\7O\2\2\u0176\u0177"+
		"\7g\2\2\u0177\u0178\7v\2\2\u0178\u0179\7t\2\2\u0179\u017a\7k\2\2\u017a"+
		"\u017b\7e\2\2\u017b\u017c\7u\2\2\u017c$\3\2\2\2\u017d\u017e\7C\2\2\u017e"+
		"\u017f\7i\2\2\u017f\u0180\7t\2\2\u0180\u0181\7g\2\2\u0181\u0182\7g\2\2"+
		"\u0182\u0183\7o\2\2\u0183\u0184\7g\2\2\u0184\u0185\7p\2\2\u0185\u0186"+
		"\7v\2\2\u0186\u0187\7V\2\2\u0187\u0188\7g\2\2\u0188\u0189\7t\2\2\u0189"+
		"\u018a\7o\2\2\u018a\u018b\7u\2\2\u018b&\3\2\2\2\u018c\u018d\7E\2\2\u018d"+
		"\u018e\7t\2\2\u018e\u018f\7g\2\2\u018f\u0190\7c\2\2\u0190\u0191\7v\2\2"+
		"\u0191\u0192\7k\2\2\u0192\u0193\7q\2\2\u0193\u0194\7p\2\2\u0194\u0195"+
		"\7E\2\2\u0195\u0196\7q\2\2\u0196\u0197\7p\2\2\u0197\u0198\7u\2\2\u0198"+
		"\u0199\7v\2\2\u0199\u019a\7t\2\2\u019a\u019b\7c\2\2\u019b\u019c\7k\2\2"+
		"\u019c\u019d\7p\2\2\u019d\u019e\7v\2\2\u019e\u019f\7u\2\2\u019f(\3\2\2"+
		"\2\u01a0\u01a1\7I\2\2\u01a1\u01a2\7w\2\2\u01a2\u01a3\7c\2\2\u01a3\u01a4"+
		"\7t\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7p\2\2\u01a6\u01a7\7v\2\2\u01a7"+
		"\u01a8\7g\2\2\u01a8\u01a9\7g\2\2\u01a9\u01aa\7V\2\2\u01aa\u01ab\7g\2\2"+
		"\u01ab\u01ac\7t\2\2\u01ac\u01ad\7o\2\2\u01ad\u01ae\7u\2\2\u01ae*\3\2\2"+
		"\2\u01af\u01b0\7U\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7t\2\2\u01b2\u01b3"+
		"\7x\2\2\u01b3\u01b4\7k\2\2\u01b4\u01b5\7e\2\2\u01b5\u01b6\7g\2\2\u01b6"+
		",\3\2\2\2\u01b7\u01b8\7H\2\2\u01b8\u01b9\7g\2\2\u01b9\u01ba\7c\2\2\u01ba"+
		"\u01bb\7v\2\2\u01bb\u01bc\7w\2\2\u01bc\u01bd\7t\2\2\u01bd\u01be\7g\2\2"+
		"\u01be\u01bf\7u\2\2\u01bf\u01c0\7\61\2\2\u01c0\u01c1\7Q\2\2\u01c1\u01c2"+
		"\7r\2\2\u01c2\u01c3\7g\2\2\u01c3\u01c4\7t\2\2\u01c4\u01c5\7c\2\2\u01c5"+
		"\u01c6\7v\2\2\u01c6\u01c7\7k\2\2\u01c7\u01c8\7q\2\2\u01c8\u01c9\7p\2\2"+
		"\u01c9\u01ca\7u\2\2\u01ca.\3\2\2\2\u01cb\u01cc\7I\2\2\u01cc\u01cd\7n\2"+
		"\2\u01cd\u01ce\7q\2\2\u01ce\u01cf\7d\2\2\u01cf\u01d0\7c\2\2\u01d0\u01d1"+
		"\7n\2\2\u01d1\u01d2\7F\2\2\u01d2\u01d3\7g\2\2\u01d3\u01d4\7u\2\2\u01d4"+
		"\u01d5\7e\2\2\u01d5\u01d6\7t\2\2\u01d6\u01d7\7k\2\2\u01d7\u01d8\7r\2\2"+
		"\u01d8\u01d9\7v\2\2\u01d9\u01da\7k\2\2\u01da\u01db\7q\2\2\u01db\u01dc"+
		"\7p\2\2\u01dc\60\3\2\2\2\u01dd\u01de\7F\2\2\u01de\u01df\7g\2\2\u01df\u01e0"+
		"\7u\2\2\u01e0\u01e1\7e\2\2\u01e1\u01e2\7t\2\2\u01e2\u01e3\7k\2\2\u01e3"+
		"\u01e4\7r\2\2\u01e4\u01e5\7v\2\2\u01e5\u01e6\7k\2\2\u01e6\u01e7\7q\2\2"+
		"\u01e7\u01e8\7p\2\2\u01e8\62\3\2\2\2\u01e9\u01ea\7i\2\2\u01ea\u01eb\7"+
		"n\2\2\u01eb\u01ec\7q\2\2\u01ec\u01ed\7d\2\2\u01ed\u01ee\7c\2\2\u01ee\u01ef"+
		"\7n\2\2\u01ef\64\3\2\2\2\u01f0\u01f1\7O\2\2\u01f1\u01f2\7q\2\2\u01f2\u01f3"+
		"\7p\2\2\u01f3\u01f4\7k\2\2\u01f4\u01f5\7v\2\2\u01f5\u01f6\7q\2\2\u01f6"+
		"\u01f7\7t\2\2\u01f7\u01f8\7c\2\2\u01f8\u01f9\7d\2\2\u01f9\u01fa\7n\2\2"+
		"\u01fa\u01fb\7g\2\2\u01fb\u01fc\7R\2\2\u01fc\u01fd\7t\2\2\u01fd\u01fe"+
		"\7q\2\2\u01fe\u01ff\7r\2\2\u01ff\u0200\7g\2\2\u0200\u0201\7t\2\2\u0201"+
		"\u0202\7v\2\2\u0202\u0203\7k\2\2\u0203\u0204\7g\2\2\u0204\u0205\7u\2\2"+
		"\u0205\66\3\2\2\2\u0206\u0207\7i\2\2\u0207\u0208\7w\2\2\u0208\u0209\7"+
		"c\2\2\u0209\u020a\7t\2\2\u020a\u020b\7c\2\2\u020b\u020c\7p\2\2\u020c\u020d"+
		"\7v\2\2\u020d\u020e\7g\2\2\u020e\u020f\7g\2\2\u020f\u0210\7u\2\2\u0210"+
		"8\3\2\2\2\u0211\u0212\7c\2\2\u0212\u0213\7x\2\2\u0213\u0214\7c\2\2\u0214"+
		"\u0215\7k\2\2\u0215\u0216\7n\2\2\u0216\u0217\7c\2\2\u0217\u0218\7d\2\2"+
		"\u0218\u0219\7n\2\2\u0219\u021a\7g\2\2\u021a\u021b\7C\2\2\u021b\u021c"+
		"\7v\2\2\u021c\u021d\7\60\2\2\u021d:\3\2\2\2\u021e\u021f\7R\2\2\u021f\u0220"+
		"\7t\2\2\u0220\u0221\7q\2\2\u0221\u0222\7x\2\2\u0222\u0223\7k\2\2\u0223"+
		"\u0224\7f\2\2\u0224\u0225\7g\2\2\u0225\u0226\7t\2\2\u0226<\3\2\2\2\u0227"+
		"\u0228\7E\2\2\u0228\u0229\7q\2\2\u0229\u022a\7p\2\2\u022a\u022b\7u\2\2"+
		"\u022b\u022c\7w\2\2\u022c\u022d\7o\2\2\u022d\u022e\7g\2\2\u022e\u022f"+
		"\7t\2\2\u022f>\3\2\2\2\u0230\u0231\7x\2\2\u0231\u0232\7g\2\2\u0232\u0233"+
		"\7t\2\2\u0233\u0234\7u\2\2\u0234\u0235\7k\2\2\u0235\u0236\7q\2\2\u0236"+
		"\u0237\7p\2\2\u0237@\3\2\2\2\u0238\u0239\7g\2\2\u0239\u023a\7z\2\2\u023a"+
		"\u023b\7e\2\2\u023b\u023c\7g\2\2\u023c\u023d\7r\2\2\u023d\u023e\7v\2\2"+
		"\u023eB\3\2\2\2\u023f\u0240\7f\2\2\u0240\u0241\7w\2\2\u0241\u0242\7t\2"+
		"\2\u0242\u0243\7k\2\2\u0243\u0244\7p\2\2\u0244\u0245\7i\2\2\u0245D\3\2"+
		"\2\2\u0246\u0247\7d\2\2\u0247\u0248\7q\2\2\u0248\u0249\7q\2\2\u0249\u024a"+
		"\7n\2\2\u024a\u024b\7g\2\2\u024b\u024c\7c\2\2\u024c\u024d\7p\2\2\u024d"+
		"F\3\2\2\2\u024e\u024f\7k\2\2\u024f\u0250\7p\2\2\u0250\u0251\7v\2\2\u0251"+
		"\u0252\7g\2\2\u0252\u0253\7i\2\2\u0253\u0254\7g\2\2\u0254\u0255\7t\2\2"+
		"\u0255H\3\2\2\2\u0256\u0257\7h\2\2\u0257\u0258\7n\2\2\u0258\u0259\7q\2"+
		"\2\u0259\u025a\7c\2\2\u025a\u025b\7v\2\2\u025bJ\3\2\2\2\u025c\u025d\7"+
		"p\2\2\u025d\u025e\7c\2\2\u025e\u025f\7v\2\2\u025f\u0260\7w\2\2\u0260\u0261"+
		"\7t\2\2\u0261\u0262\7c\2\2\u0262\u0263\7n\2\2\u0263L\3\2\2\2\u0264\u0265"+
		"\7p\2\2\u0265\u0266\7w\2\2\u0266\u0267\7o\2\2\u0267\u0268\7d\2\2\u0268"+
		"\u0269\7g\2\2\u0269\u026a\7t\2\2\u026aN\3\2\2\2\u026b\u026c\7u\2\2\u026c"+
		"\u026d\7g\2\2\u026d\u026e\7v\2\2\u026eP\3\2\2\2\u026f\u0270\7g\2\2\u0270"+
		"\u0271\7p\2\2\u0271\u0272\7w\2\2\u0272\u0273\7o\2\2\u0273R\3\2\2\2\u0274"+
		"\u0275\7v\2\2\u0275\u0276\7t\2\2\u0276\u0277\7w\2\2\u0277\u0278\7g\2\2"+
		"\u0278T\3\2\2\2\u0279\u027a\7h\2\2\u027a\u027b\7c\2\2\u027b\u027c\7n\2"+
		"\2\u027c\u027d\7u\2\2\u027d\u027e\7g\2\2\u027eV\3\2\2\2\u027f\u0280\7"+
		"y\2\2\u0280\u0281\7k\2\2\u0281\u0282\7v\2\2\u0282\u0283\7j\2\2\u0283X"+
		"\3\2\2\2\u0284\u0285\7g\2\2\u0285\u0286\7p\2\2\u0286\u0287\7f\2\2\u0287"+
		"Z\3\2\2\2\u0288\u0289\7k\2\2\u0289\u028a\7h\2\2\u028a\\\3\2\2\2\u028b"+
		"\u028c\7{\2\2\u028c\u028d\7g\2\2\u028d\u028e\7c\2\2\u028e\u028f\7t\2\2"+
		"\u028f\u0290\7n\2\2\u0290\u0291\7{\2\2\u0291^\3\2\2\2\u0292\u0293\7o\2"+
		"\2\u0293\u0294\7q\2\2\u0294\u0295\7p\2\2\u0295\u0296\7v\2\2\u0296\u0297"+
		"\7j\2\2\u0297\u0298\7n\2\2\u0298\u0299\7{\2\2\u0299`\3\2\2\2\u029a\u029b"+
		"\7y\2\2\u029b\u029c\7g\2\2\u029c\u029d\7g\2\2\u029d\u029e\7m\2\2\u029e"+
		"\u029f\7n\2\2\u029f\u02a0\7{\2\2\u02a0b\3\2\2\2\u02a1\u02a2\7f\2\2\u02a2"+
		"\u02a3\7c\2\2\u02a3\u02a4\7k\2\2\u02a4\u02a5\7n\2\2\u02a5\u02a6\7{\2\2"+
		"\u02a6d\3\2\2\2\u02a7\u02a8\7j\2\2\u02a8\u02a9\7q\2\2\u02a9\u02aa\7w\2"+
		"\2\u02aa\u02ab\7t\2\2\u02ab\u02ac\7n\2\2\u02ac\u02ad\7{\2\2\u02adf\3\2"+
		"\2\2\u02ae\u02af\7o\2\2\u02af\u02b0\7k\2\2\u02b0\u02b1\7p\2\2\u02b1\u02b2"+
		"\7w\2\2\u02b2\u02b3\7v\2\2\u02b3\u02b4\7g\2\2\u02b4\u02b5\7n\2\2\u02b5"+
		"\u02b6\7{\2\2\u02b6h\3\2\2\2\u02b7\u02b8\7r\2\2\u02b8\u02b9\7g\2\2\u02b9"+
		"\u02ba\7p\2\2\u02ba\u02bb\7c\2\2\u02bb\u02bc\7n\2\2\u02bc\u02bd\7v\2\2"+
		"\u02bd\u02be\7{\2\2\u02bej\3\2\2\2\u02bf\u02c0\7t\2\2\u02c0\u02c1\7g\2"+
		"\2\u02c1\u02c2\7y\2\2\u02c2\u02c3\7c\2\2\u02c3\u02c4\7t\2\2\u02c4\u02c5"+
		"\7f\2\2\u02c5l\3\2\2\2\u02c6\u02c7\7q\2\2\u02c7\u02c8\7p\2\2\u02c8n\3"+
		"\2\2\2\u02c9\u02ca\7h\2\2\u02ca\u02cb\7t\2\2\u02cb\u02cc\7q\2\2\u02cc"+
		"\u02cd\7o\2\2\u02cdp\3\2\2\2\u02ce\u02cf\7q\2\2\u02cf\u02d0\7h\2\2\u02d0"+
		"r\3\2\2\2\u02d1\u02d2\7h\2\2\u02d2\u02d3\7q\2\2\u02d3\u02d4\7t\2\2\u02d4"+
		"t\3\2\2\2\u02d5\u02d6\7c\2\2\u02d6\u02d7\7u\2\2\u02d7v\3\2\2\2\u02d8\u02d9"+
		"\7]\2\2\u02d9x\3\2\2\2\u02da\u02db\7_\2\2\u02dbz\3\2\2\2\u02dc\u02dd\7"+
		"*\2\2\u02dd|\3\2\2\2\u02de\u02df\7+\2\2\u02df~\3\2\2\2\u02e0\u02e1\7}"+
		"\2\2\u02e1\u0080\3\2\2\2\u02e2\u02e3\7\177\2\2\u02e3\u0082\3\2\2\2\u02e4"+
		"\u02e5\7C\2\2\u02e5\u02e6\7P\2\2\u02e6\u02e7\7F\2\2\u02e7\u0084\3\2\2"+
		"\2\u02e8\u02e9\7Q\2\2\u02e9\u02ea\7T\2\2\u02ea\u0086\3\2\2\2\u02eb\u02ec"+
		"\7P\2\2\u02ec\u02ed\7Q\2\2\u02ed\u02ee\7V\2\2\u02ee\u0088\3\2\2\2\u02ef"+
		"\u02f0\7K\2\2\u02f0\u02f1\7O\2\2\u02f1\u02f2\7R\2\2\u02f2\u02f3\7N\2\2"+
		"\u02f3\u02f4\7K\2\2\u02f4\u02f5\7G\2\2\u02f5\u02f6\7U\2\2\u02f6\u008a"+
		"\3\2\2\2\u02f7\u02f8\7q\2\2\u02f8\u02f9\7p\2\2\u02f9\u02fa\7n\2\2\u02fa"+
		"\u02fb\7{\2\2\u02fb\u02fc\7K\2\2\u02fc\u02fd\7h\2\2\u02fd\u008c\3\2\2"+
		"\2\u02fe\u02ff\7g\2\2\u02ff\u0300\7z\2\2\u0300\u0301\7c\2\2\u0301\u0302"+
		"\7e\2\2\u0302\u0303\7v\2\2\u0303\u0304\7n\2\2\u0304\u0305\7{\2\2\u0305"+
		"\u0306\7\"\2\2\u0306\u0307\7q\2\2\u0307\u0308\7p\2\2\u0308\u0309\7g\2"+
		"\2\u0309\u008e\3\2\2\2\u030a\u030b\7q\2\2\u030b\u030c\7p\2\2\u030c\u030d"+
		"\7g\2\2\u030d\u030e\7\"\2\2\u030e\u030f\7q\2\2\u030f\u0310\7t\2\2\u0310"+
		"\u0311\7\"\2\2\u0311\u0312\7o\2\2\u0312\u0313\7q\2\2\u0313\u0314\7t\2"+
		"\2\u0314\u0315\7g\2\2\u0315\u0090\3\2\2\2\u0316\u0317\7c\2\2\u0317\u0318"+
		"\7n\2\2\u0318\u0319\7n\2\2\u0319\u0092\3\2\2\2\u031a\u031b\7>\2\2\u031b"+
		"\u0094\3\2\2\2\u031c\u031d\7@\2\2\u031d\u0096\3\2\2\2\u031e\u031f\7?\2"+
		"\2\u031f\u0320\7?\2\2\u0320\u0098\3\2\2\2\u0321\u0322\7#\2\2\u0322\u0323"+
		"\7?\2\2\u0323\u009a\3\2\2\2\u0324\u0325\7>\2\2\u0325\u0326\7?\2\2\u0326"+
		"\u009c\3\2\2\2\u0327\u0328\7@\2\2\u0328\u0329\7?\2\2\u0329\u009e\3\2\2"+
		"\2\u032a\u032b\7-\2\2\u032b\u00a0\3\2\2\2\u032c\u032d\7/\2\2\u032d\u00a2"+
		"\3\2\2\2\u032e\u032f\7,\2\2\u032f\u00a4\3\2\2\2\u0330\u0331\7\61\2\2\u0331"+
		"\u00a6\3\2\2\2\u0332\u0333\7?\2\2\u0333\u00a8\3\2\2\2\u0334\u0335\7d\2"+
		"\2\u0335\u0336\7g\2\2\u0336\u0337\7n\2\2\u0337\u0338\7q\2\2\u0338\u0339"+
		"\7p\2\2\u0339\u033a\7i\2\2\u033a\u033b\7u\2\2\u033b\u00aa\3\2\2\2\u033c"+
		"\u033d\7w\2\2\u033d\u033e\7r\2\2\u033e\u033f\7q\2\2\u033f\u0340\7p\2\2"+
		"\u0340\u00ac\3\2\2\2\u0341\u0346\5\u00afX\2\u0342\u0345\t\2\2\2\u0343"+
		"\u0345\5\u00b1Y\2\u0344\u0342\3\2\2\2\u0344\u0343\3\2\2\2\u0345\u0348"+
		"\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u00ae\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0349\u034a\t\3\2\2\u034a\u00b0\3\2\2\2\u034b\u034c\t\4"+
		"\2\2\u034c\u00b2\3\2\2\2\u034d\u034f\5\u00c9e\2\u034e\u034d\3\2\2\2\u034f"+
		"\u0350\3\2\2\2\u0350\u034e\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u00b4\3\2"+
		"\2\2\u0352\u0353\t\5\2\2\u0353\u0354\5\u00b3Z\2\u0354\u00b6\3\2\2\2\u0355"+
		"\u0356\5\u00b3Z\2\u0356\u0357\7\60\2\2\u0357\u0358\5\u00b3Z\2\u0358\u00b8"+
		"\3\2\2\2\u0359\u035a\t\5\2\2\u035a\u035b\5\u00b7\\\2\u035b\u00ba\3\2\2"+
		"\2\u035c\u035d\7v\2\2\u035d\u035e\7t\2\2\u035e\u035f\7w\2\2\u035f\u0366"+
		"\7g\2\2\u0360\u0361\7h\2\2\u0361\u0362\7c\2\2\u0362\u0363\7n\2\2\u0363"+
		"\u0364\7u\2\2\u0364\u0366\7g\2\2\u0365\u035c\3\2\2\2\u0365\u0360\3\2\2"+
		"\2\u0366\u00bc\3\2\2\2\u0367\u0368\7j\2\2\u0368\u0369\7v\2\2\u0369\u036a"+
		"\7v\2\2\u036a\u0378\7r\2\2\u036b\u036c\7j\2\2\u036c\u036d\7v\2\2\u036d"+
		"\u036e\7v\2\2\u036e\u036f\7r\2\2\u036f\u0378\7u\2\2\u0370\u0371\7h\2\2"+
		"\u0371\u0372\7v\2\2\u0372\u0378\7r\2\2\u0373\u0374\7h\2\2\u0374\u0375"+
		"\7k\2\2\u0375\u0376\7n\2\2\u0376\u0378\7g\2\2\u0377\u0367\3\2\2\2\u0377"+
		"\u036b\3\2\2\2\u0377\u0370\3\2\2\2\u0377\u0373\3\2\2\2\u0378\u0379\3\2"+
		"\2\2\u0379\u037a\7<\2\2\u037a\u037b\7\61\2\2\u037b\u037f\7\61\2\2\u037c"+
		"\u037e\t\6\2\2\u037d\u037c\3\2\2\2\u037e\u0381\3\2\2\2\u037f\u037d\3\2"+
		"\2\2\u037f\u0380\3\2\2\2\u0380\u0382\3\2\2\2\u0381\u037f\3\2\2\2\u0382"+
		"\u0383\t\7\2\2\u0383\u00be\3\2\2\2\u0384\u0387\5\u00b3Z\2\u0385\u0386"+
		"\7\60\2\2\u0386\u0388\5\u00b3Z\2\u0387\u0385\3\2\2\2\u0388\u0389\3\2\2"+
		"\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u00c0\3\2\2\2\u038b\u038c"+
		"\5\u00b3Z\2\u038c\u038d\t\b\2\2\u038d\u038e\5\u00b3Z\2\u038e\u038f\t\b"+
		"\2\2\u038f\u0390\5\u00b3Z\2\u0390\u00c2\3\2\2\2\u0391\u0393\5\u00c9e\2"+
		"\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0395"+
		"\5\u00c9e\2\u0395\u0396\7<\2\2\u0396\u0397\5\u00c9e\2\u0397\u0398\5\u00c9"+
		"e\2\u0398\u00c4\3\2\2\2\u0399\u039c\5\u00adW\2\u039a\u039b\7\60\2\2\u039b"+
		"\u039d\5\u00adW\2\u039c\u039a\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u039c"+
		"\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u00c6\3\2\2\2\u03a0\u03a5\7\'\2\2\u03a1"+
		"\u03a2\7o\2\2\u03a2\u03a3\7k\2\2\u03a3\u03a5\7p\2\2\u03a4\u03a0\3\2\2"+
		"\2\u03a4\u03a1\3\2\2\2\u03a5\u00c8\3\2\2\2\u03a6\u03a9\7\62\2\2\u03a7"+
		"\u03a9\5\u00cbf\2\u03a8\u03a6\3\2\2\2\u03a8\u03a7\3\2\2\2\u03a9\u00ca"+
		"\3\2\2\2\u03aa\u03ab\t\t\2\2\u03ab\u00cc\3\2\2\2\u03ac\u03b0\7)\2\2\u03ad"+
		"\u03af\n\n\2\2\u03ae\u03ad\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae\3\2"+
		"\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b3\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3"+
		"\u03bd\7)\2\2\u03b4\u03b8\7$\2\2\u03b5\u03b7\n\13\2\2\u03b6\u03b5\3\2"+
		"\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9"+
		"\u03bb\3\2\2\2\u03ba\u03b8\3\2\2\2\u03bb\u03bd\7$\2\2\u03bc\u03ac\3\2"+
		"\2\2\u03bc\u03b4\3\2\2\2\u03bd\u00ce\3\2\2\2\u03be\u03c0\t\f\2\2\u03bf"+
		"\u03be\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c1\u03c2\3\2"+
		"\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c4\bh\2\2\u03c4\u00d0\3\2\2\2\u03c5"+
		"\u03c6\7\61\2\2\u03c6\u03c7\7,\2\2\u03c7\u03cb\3\2\2\2\u03c8\u03ca\13"+
		"\2\2\2\u03c9\u03c8\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cb"+
		"\u03c9\3\2\2\2\u03cc\u03ce\3\2\2\2\u03cd\u03cb\3\2\2\2\u03ce\u03cf\7,"+
		"\2\2\u03cf\u03d0\7\61\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d2\bi\3\2\u03d2"+
		"\u00d2\3\2\2\2\u03d3\u03d4\7\61\2\2\u03d4\u03d5\7\61\2\2\u03d5\u03d9\3"+
		"\2\2\2\u03d6\u03d8\n\r\2\2\u03d7\u03d6\3\2\2\2\u03d8\u03db\3\2\2\2\u03d9"+
		"\u03d7\3\2\2\2\u03d9\u03da\3\2\2\2\u03da\u03dc\3\2\2\2\u03db\u03d9\3\2"+
		"\2\2\u03dc\u03dd\bj\4\2\u03dd\u00d4\3\2\2\2\24\2\u0344\u0346\u0350\u0365"+
		"\u0377\u037f\u0389\u0392\u039e\u03a4\u03a8\u03b0\u03b8\u03bc\u03c1\u03cb"+
		"\u03d9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}