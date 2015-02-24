// Generated from C:\Users\ISA Group\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package isa.us.es.aml.parsers.iagree;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class iAgreeParser extends Parser {
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
		ALL=72, LT=73, GT=74, EQ=75, LTE=76, GTE=77, BELONGS=78, UPON=79, Identifier=80, 
		Integer=81, S_Integer=82, Float=83, S_Float=84, Boolean=85, Url=86, Version=87, 
		Date=88, Hour=89, Access=90, Unit=91, Operador=92, String=93, WS=94, COMMENT=95, 
		LINE_COMMENT=96;
	public static final String[] tokenNames = {
		"<INVALID>", "':'", "';'", "','", "'..'", "'Template'", "'EndTemplate'", 
		"'AgreementOffer'", "'EndAgreementOffer'", "'Initiator'", "'Responder'", 
		"'ServiceProvider'", "'ExpirationTime'", "'DateFormat'", "'GMTZone'", 
		"'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", "'AgreementTerms'", 
		"'CreationConstraints'", "'GuaranteeTerms'", "'Service'", "'Features/Operations'", 
		"'GlobalDescription'", "'Description'", "'global'", "'MonitorableProperties'", 
		"'guarantees'", "'availableAt.'", "'Provider'", "'Consumer'", "'version'", 
		"'except'", "'during'", "'boolean'", "'integer'", "'float'", "'natural'", 
		"'number'", "'set'", "'enum'", "'true'", "'false'", "'with'", "'end'", 
		"'if'", "'yearly'", "'monthly'", "'weekly'", "'daily'", "'hourly'", "'minutely'", 
		"'penalty'", "'reward'", "'on'", "'from'", "'of'", "'for'", "'as'", "'['", 
		"']'", "'('", "')'", "'{'", "'}'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", 
		"'onlyIf'", "'exactly one'", "'one or more'", "'all'", "'<'", "'>'", "'='", 
		"'<='", "'>='", "'belongs'", "'upon'", "Identifier", "Integer", "S_Integer", 
		"Float", "S_Float", "Boolean", "Url", "Version", "Date", "Hour", "Access", 
		"Unit", "Operador", "String", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_entry = 0, RULE_template = 1, RULE_agOffer = 2, RULE_template_def = 3, 
		RULE_ag_def = 4, RULE_temp_properties = 5, RULE_agreementTerms = 6, RULE_creationConstraints = 7, 
		RULE_agreementTerms_def = 8, RULE_creationConstraints_def = 9, RULE_creationConstraint = 10, 
		RULE_initiator_prop = 11, RULE_responder_prop = 12, RULE_serviceProvider_prop = 13, 
		RULE_expirationTime_prop = 14, RULE_dateFormat_prop = 15, RULE_gmtZone_prop = 16, 
		RULE_globalPeriod_prop = 17, RULE_definedPeriod_prop = 18, RULE_metrics_prop = 19, 
		RULE_datePeriod_def = 20, RULE_temporality = 21, RULE_period = 22, RULE_period_def = 23, 
		RULE_service = 24, RULE_features = 25, RULE_globalDescription = 26, RULE_descriptions = 27, 
		RULE_feature = 28, RULE_description = 29, RULE_monitorableProperties = 30, 
		RULE_global_MonitorableProperties = 31, RULE_local_MonitorableProperties = 32, 
		RULE_guaranteeTerms = 33, RULE_guaranteeTerm = 34, RULE_grouped_guaranteeTerm = 35, 
		RULE_guarantee_def = 36, RULE_slo = 37, RULE_serviceScope = 38, RULE_qualifyingCondition = 39, 
		RULE_compensations = 40, RULE_compensationsInterval = 41, RULE_compensation = 42, 
		RULE_id = 43, RULE_versionNumber = 44, RULE_url = 45, RULE_key_value_prop = 46, 
		RULE_assig_value = 47, RULE_operation = 48, RULE_expression = 49, RULE_op = 50, 
		RULE_cuantif = 51, RULE_type = 52, RULE_list = 53, RULE_listArg = 54, 
		RULE_range = 55;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "template_def", "ag_def", "temp_properties", 
		"agreementTerms", "creationConstraints", "agreementTerms_def", "creationConstraints_def", 
		"creationConstraint", "initiator_prop", "responder_prop", "serviceProvider_prop", 
		"expirationTime_prop", "dateFormat_prop", "gmtZone_prop", "globalPeriod_prop", 
		"definedPeriod_prop", "metrics_prop", "datePeriod_def", "temporality", 
		"period", "period_def", "service", "features", "globalDescription", "descriptions", 
		"feature", "description", "monitorableProperties", "global_MonitorableProperties", 
		"local_MonitorableProperties", "guaranteeTerms", "guaranteeTerm", "grouped_guaranteeTerm", 
		"guarantee_def", "slo", "serviceScope", "qualifyingCondition", "compensations", 
		"compensationsInterval", "compensation", "id", "versionNumber", "url", 
		"key_value_prop", "assig_value", "operation", "expression", "op", "cuantif", 
		"type", "list", "listArg", "range"
	};

	@Override
	public String getGrammarFileName() { return "iAgree.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public iAgreeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntryContext extends ParserRuleContext {
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public TerminalNode END_TEMPLATE() { return getToken(iAgreeParser.END_TEMPLATE, 0); }
		public AgOfferContext agOffer() {
			return getRuleContext(AgOfferContext.class,0);
		}
		public TerminalNode END_AG_OFFER() { return getToken(iAgreeParser.END_AG_OFFER, 0); }
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		try {
			setState(118);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(112); template();
				setState(113); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(115); agOffer();
				setState(116); match(END_AG_OFFER);
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

	public static class TemplateContext extends ParserRuleContext {
		public Template_defContext template_def() {
			return getRuleContext(Template_defContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode VERSION() { return getToken(iAgreeParser.VERSION, 0); }
		public TerminalNode TEMPLATE() { return getToken(iAgreeParser.TEMPLATE, 0); }
		public VersionNumberContext versionNumber() {
			return getRuleContext(VersionNumberContext.class,0);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_template);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(TEMPLATE);
			setState(121); match(Identifier);
			setState(122); match(VERSION);
			setState(123); versionNumber();
			setState(124); template_def();
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

	public static class AgOfferContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public List<TerminalNode> VERSION() { return getTokens(iAgreeParser.VERSION); }
		public Ag_defContext ag_def() {
			return getRuleContext(Ag_defContext.class,0);
		}
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public TerminalNode VERSION(int i) {
			return getToken(iAgreeParser.VERSION, i);
		}
		public VersionNumberContext versionNumber(int i) {
			return getRuleContext(VersionNumberContext.class,i);
		}
		public TerminalNode TEMPLATE() { return getToken(iAgreeParser.TEMPLATE, 0); }
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<VersionNumberContext> versionNumber() {
			return getRuleContexts(VersionNumberContext.class);
		}
		public TerminalNode AG_OFFER() { return getToken(iAgreeParser.AG_OFFER, 0); }
		public AgOfferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agOffer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAgOffer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgOfferContext agOffer() throws RecognitionException {
		AgOfferContext _localctx = new AgOfferContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_agOffer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(AG_OFFER);
			setState(127); match(Identifier);
			setState(128); match(VERSION);
			setState(129); versionNumber();
			setState(130); match(FOR);
			setState(132);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(131); match(TEMPLATE);
				}
			}

			setState(134); match(Identifier);
			setState(135); match(VERSION);
			setState(136); versionNumber();
			setState(137); ag_def();
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

	public static class Template_defContext extends ParserRuleContext {
		public Temp_propertiesContext temp_properties(int i) {
			return getRuleContext(Temp_propertiesContext.class,i);
		}
		public List<Temp_propertiesContext> temp_properties() {
			return getRuleContexts(Temp_propertiesContext.class);
		}
		public AgreementTermsContext agreementTerms() {
			return getRuleContext(AgreementTermsContext.class,0);
		}
		public CreationConstraintsContext creationConstraints() {
			return getRuleContext(CreationConstraintsContext.class,0);
		}
		public Template_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitTemplate_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Template_defContext template_def() throws RecognitionException {
		Template_defContext _localctx = new Template_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_template_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(139); temp_properties();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145); agreementTerms();
			setState(147);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(146); creationConstraints();
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

	public static class Ag_defContext extends ParserRuleContext {
		public Temp_propertiesContext temp_properties(int i) {
			return getRuleContext(Temp_propertiesContext.class,i);
		}
		public List<Temp_propertiesContext> temp_properties() {
			return getRuleContexts(Temp_propertiesContext.class);
		}
		public AgreementTermsContext agreementTerms() {
			return getRuleContext(AgreementTermsContext.class,0);
		}
		public Ag_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ag_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAg_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ag_defContext ag_def() throws RecognitionException {
		Ag_defContext _localctx = new Ag_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ag_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(149); temp_properties();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155); agreementTerms();
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

	public static class Temp_propertiesContext extends ParserRuleContext {
		public GlobalPeriod_propContext globalPeriod_prop() {
			return getRuleContext(GlobalPeriod_propContext.class,0);
		}
		public DefinedPeriod_propContext definedPeriod_prop() {
			return getRuleContext(DefinedPeriod_propContext.class,0);
		}
		public ExpirationTime_propContext expirationTime_prop() {
			return getRuleContext(ExpirationTime_propContext.class,0);
		}
		public ServiceProvider_propContext serviceProvider_prop() {
			return getRuleContext(ServiceProvider_propContext.class,0);
		}
		public DateFormat_propContext dateFormat_prop() {
			return getRuleContext(DateFormat_propContext.class,0);
		}
		public Initiator_propContext initiator_prop() {
			return getRuleContext(Initiator_propContext.class,0);
		}
		public GmtZone_propContext gmtZone_prop() {
			return getRuleContext(GmtZone_propContext.class,0);
		}
		public Metrics_propContext metrics_prop() {
			return getRuleContext(Metrics_propContext.class,0);
		}
		public Responder_propContext responder_prop() {
			return getRuleContext(Responder_propContext.class,0);
		}
		public Temp_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temp_properties; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitTemp_properties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Temp_propertiesContext temp_properties() throws RecognitionException {
		Temp_propertiesContext _localctx = new Temp_propertiesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_temp_properties);
		try {
			setState(166);
			switch (_input.LA(1)) {
			case INITIATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(157); initiator_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); responder_prop();
				}
				break;
			case SERVICEPROVIDER:
				enterOuterAlt(_localctx, 3);
				{
				setState(159); serviceProvider_prop();
				}
				break;
			case EXPIRATIONTIME:
				enterOuterAlt(_localctx, 4);
				{
				setState(160); expirationTime_prop();
				}
				break;
			case DATEFORMAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(161); dateFormat_prop();
				}
				break;
			case GMTZONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(162); gmtZone_prop();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 7);
				{
				setState(163); globalPeriod_prop();
				}
				break;
			case DEFINEDPERIOD:
				enterOuterAlt(_localctx, 8);
				{
				setState(164); definedPeriod_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 9);
				{
				setState(165); metrics_prop();
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

	public static class AgreementTermsContext extends ParserRuleContext {
		public TerminalNode AGREEMENT_TERMS() { return getToken(iAgreeParser.AGREEMENT_TERMS, 0); }
		public AgreementTerms_defContext agreementTerms_def() {
			return getRuleContext(AgreementTerms_defContext.class,0);
		}
		public AgreementTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agreementTerms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAgreementTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgreementTermsContext agreementTerms() throws RecognitionException {
		AgreementTermsContext _localctx = new AgreementTermsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_agreementTerms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(AGREEMENT_TERMS);
			setState(169); agreementTerms_def();
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

	public static class CreationConstraintsContext extends ParserRuleContext {
		public CreationConstraints_defContext creationConstraints_def() {
			return getRuleContext(CreationConstraints_defContext.class,0);
		}
		public TerminalNode CREATION_CONSTRAINTS() { return getToken(iAgreeParser.CREATION_CONSTRAINTS, 0); }
		public CreationConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creationConstraints; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCreationConstraints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreationConstraintsContext creationConstraints() throws RecognitionException {
		CreationConstraintsContext _localctx = new CreationConstraintsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_creationConstraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(CREATION_CONSTRAINTS);
			setState(172); creationConstraints_def();
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

	public static class AgreementTerms_defContext extends ParserRuleContext {
		public ServiceContext service() {
			return getRuleContext(ServiceContext.class,0);
		}
		public MonitorablePropertiesContext monitorableProperties() {
			return getRuleContext(MonitorablePropertiesContext.class,0);
		}
		public GuaranteeTermsContext guaranteeTerms() {
			return getRuleContext(GuaranteeTermsContext.class,0);
		}
		public AgreementTerms_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agreementTerms_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAgreementTerms_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgreementTerms_defContext agreementTerms_def() throws RecognitionException {
		AgreementTerms_defContext _localctx = new AgreementTerms_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_agreementTerms_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); service();
			setState(175); monitorableProperties();
			setState(176); guaranteeTerms();
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

	public static class CreationConstraints_defContext extends ParserRuleContext {
		public CreationConstraintContext creationConstraint(int i) {
			return getRuleContext(CreationConstraintContext.class,i);
		}
		public List<CreationConstraintContext> creationConstraint() {
			return getRuleContexts(CreationConstraintContext.class);
		}
		public CreationConstraints_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creationConstraints_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCreationConstraints_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreationConstraints_defContext creationConstraints_def() throws RecognitionException {
		CreationConstraints_defContext _localctx = new CreationConstraints_defContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_creationConstraints_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178); creationConstraint();
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
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

	public static class CreationConstraintContext extends ParserRuleContext {
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CreationConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creationConstraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCreationConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreationConstraintContext creationConstraint() throws RecognitionException {
		CreationConstraintContext _localctx = new CreationConstraintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_creationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(183); match(Identifier);
			}
			setState(184); match(1);
			setState(185); expression();
			setState(186); match(2);
			setState(188);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(187); qualifyingCondition();
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

	public static class Initiator_propContext extends ParserRuleContext {
		public TerminalNode INITIATOR() { return getToken(iAgreeParser.INITIATOR, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public Initiator_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initiator_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitInitiator_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initiator_propContext initiator_prop() throws RecognitionException {
		Initiator_propContext _localctx = new Initiator_propContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_initiator_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(INITIATOR);
			setState(191); match(1);
			setState(192); match(String);
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

	public static class Responder_propContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public TerminalNode AS() { return getToken(iAgreeParser.AS, 0); }
		public TerminalNode RESPONDER() { return getToken(iAgreeParser.RESPONDER, 0); }
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public Responder_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_responder_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitResponder_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Responder_propContext responder_prop() throws RecognitionException {
		Responder_propContext _localctx = new Responder_propContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_responder_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !(((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (PROVIDER - 29)) | (1L << (CONSUMER - 29)) | (1L << (Identifier - 29)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(195); match(AS);
			setState(196); match(RESPONDER);
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

	public static class ServiceProvider_propContext extends ParserRuleContext {
		public TerminalNode SERVICEPROVIDER() { return getToken(iAgreeParser.SERVICEPROVIDER, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public ServiceProvider_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceProvider_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitServiceProvider_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceProvider_propContext serviceProvider_prop() throws RecognitionException {
		ServiceProvider_propContext _localctx = new ServiceProvider_propContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_serviceProvider_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); match(SERVICEPROVIDER);
			setState(199); match(1);
			setState(200); match(String);
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

	public static class ExpirationTime_propContext extends ParserRuleContext {
		public TerminalNode EXPIRATIONTIME() { return getToken(iAgreeParser.EXPIRATIONTIME, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public ExpirationTime_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expirationTime_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitExpirationTime_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpirationTime_propContext expirationTime_prop() throws RecognitionException {
		ExpirationTime_propContext _localctx = new ExpirationTime_propContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expirationTime_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(EXPIRATIONTIME);
			setState(203); match(1);
			setState(204); match(String);
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

	public static class DateFormat_propContext extends ParserRuleContext {
		public TerminalNode DATEFORMAT() { return getToken(iAgreeParser.DATEFORMAT, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public DateFormat_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateFormat_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDateFormat_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateFormat_propContext dateFormat_prop() throws RecognitionException {
		DateFormat_propContext _localctx = new DateFormat_propContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dateFormat_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(DATEFORMAT);
			setState(207); match(1);
			setState(208); match(String);
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

	public static class GmtZone_propContext extends ParserRuleContext {
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode GMTZONE() { return getToken(iAgreeParser.GMTZONE, 0); }
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public GmtZone_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gmtZone_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGmtZone_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GmtZone_propContext gmtZone_prop() throws RecognitionException {
		GmtZone_propContext _localctx = new GmtZone_propContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_gmtZone_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(GMTZONE);
			setState(211); match(1);
			setState(212);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class GlobalPeriod_propContext extends ParserRuleContext {
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
		public DatePeriod_defContext datePeriod_def() {
			return getRuleContext(DatePeriod_defContext.class,0);
		}
		public GlobalPeriod_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalPeriod_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGlobalPeriod_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalPeriod_propContext globalPeriod_prop() throws RecognitionException {
		GlobalPeriod_propContext _localctx = new GlobalPeriod_propContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_globalPeriod_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(GLOBALPERIOD);
			setState(215); match(1);
			setState(216); datePeriod_def();
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

	public static class DefinedPeriod_propContext extends ParserRuleContext {
		public PeriodContext period(int i) {
			return getRuleContext(PeriodContext.class,i);
		}
		public TerminalNode DEFINEDPERIOD() { return getToken(iAgreeParser.DEFINEDPERIOD, 0); }
		public List<PeriodContext> period() {
			return getRuleContexts(PeriodContext.class);
		}
		public DefinedPeriod_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definedPeriod_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDefinedPeriod_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinedPeriod_propContext definedPeriod_prop() throws RecognitionException {
		DefinedPeriod_propContext _localctx = new DefinedPeriod_propContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_definedPeriod_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(DEFINEDPERIOD);
			setState(219); match(1);
			setState(221); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(220); period();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(223); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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

	public static class Metrics_propContext extends ParserRuleContext {
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode METRICS() { return getToken(iAgreeParser.METRICS, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public Metrics_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metrics_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitMetrics_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Metrics_propContext metrics_prop() throws RecognitionException {
		Metrics_propContext _localctx = new Metrics_propContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_metrics_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225); match(METRICS);
			setState(226); match(1);
			setState(228); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(227); key_value_prop();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(230); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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

	public static class DatePeriod_defContext extends ParserRuleContext {
		public List<TerminalNode> Date() { return getTokens(iAgreeParser.Date); }
		public TerminalNode DURING() { return getToken(iAgreeParser.DURING, 0); }
		public TerminalNode Date(int i) {
			return getToken(iAgreeParser.Date, i);
		}
		public DatePeriod_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datePeriod_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDatePeriod_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatePeriod_defContext datePeriod_def() throws RecognitionException {
		DatePeriod_defContext _localctx = new DatePeriod_defContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_datePeriod_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(DURING);
			setState(233); match(Date);
			setState(234); match(4);
			setState(235); match(Date);
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

	public static class TemporalityContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public TemporalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitTemporality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalityContext temporality() throws RecognitionException {
		TemporalityContext _localctx = new TemporalityContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_temporality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(ON);
			setState(238); match(Identifier);
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

	public static class PeriodContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode AND(int i) {
			return getToken(iAgreeParser.AND, i);
		}
		public List<Period_defContext> period_def() {
			return getRuleContexts(Period_defContext.class);
		}
		public TerminalNode EXCEPT(int i) {
			return getToken(iAgreeParser.EXCEPT, i);
		}
		public List<TerminalNode> AND() { return getTokens(iAgreeParser.AND); }
		public Period_defContext period_def(int i) {
			return getRuleContext(Period_defContext.class,i);
		}
		public List<TerminalNode> EXCEPT() { return getTokens(iAgreeParser.EXCEPT); }
		public PeriodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_period; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitPeriod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PeriodContext period() throws RecognitionException {
		PeriodContext _localctx = new PeriodContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_period);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); match(Identifier);
			setState(241); match(1);
			setState(242); period_def();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==AND) {
				{
				{
				setState(243);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(244); period_def();
				}
				}
				setState(249);
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

	public static class Period_defContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode FROM() { return getToken(iAgreeParser.FROM, 0); }
		public DatePeriod_defContext datePeriod_def() {
			return getRuleContext(DatePeriod_defContext.class,0);
		}
		public List<TerminalNode> Hour() { return getTokens(iAgreeParser.Hour); }
		public TerminalNode Hour(int i) {
			return getToken(iAgreeParser.Hour, i);
		}
		public Period_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_period_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitPeriod_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Period_defContext period_def() throws RecognitionException {
		Period_defContext _localctx = new Period_defContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_period_def);
		int _la;
		try {
			setState(261);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(250); match(FROM);
				setState(251); match(Hour);
				setState(252); match(4);
				setState(253); match(Hour);
				setState(256);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(254); match(ON);
					setState(255); match(Identifier);
					}
				}

				setState(258); datePeriod_def();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(259); id();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(260); match(GLOBALPERIOD);
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

	public static class ServiceContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public GlobalDescriptionContext globalDescription() {
			return getRuleContext(GlobalDescriptionContext.class,0);
		}
		public TerminalNode AVAL_AT() { return getToken(iAgreeParser.AVAL_AT, 0); }
		public TerminalNode SERVICE() { return getToken(iAgreeParser.SERVICE, 0); }
		public DescriptionsContext descriptions() {
			return getRuleContext(DescriptionsContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
		}
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(SERVICE);
			setState(264); match(Identifier);
			setState(267);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(265); match(AVAL_AT);
				setState(266); url();
				}
			}

			setState(270);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(269); features();
				}
			}

			setState(272); globalDescription();
			setState(273); descriptions();
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

	public static class FeaturesContext extends ParserRuleContext {
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public TerminalNode FEATURES() { return getToken(iAgreeParser.FEATURES, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_features; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitFeatures(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeaturesContext features() throws RecognitionException {
		FeaturesContext _localctx = new FeaturesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(FEATURES);
			setState(276); match(1);
			setState(277); feature();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(278); match(3);
				setState(279); feature();
				}
				}
				setState(284);
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

	public static class GlobalDescriptionContext extends ParserRuleContext {
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode GLOBALDESCRIPTION() { return getToken(iAgreeParser.GLOBALDESCRIPTION, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public GlobalDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDescription; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGlobalDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDescriptionContext globalDescription() throws RecognitionException {
		GlobalDescriptionContext _localctx = new GlobalDescriptionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_globalDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(GLOBALDESCRIPTION);
			setState(287); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(286); key_value_prop();
				}
				}
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0) );
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

	public static class DescriptionsContext extends ParserRuleContext {
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDescriptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionsContext descriptions() throws RecognitionException {
		DescriptionsContext _localctx = new DescriptionsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_descriptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(291); description();
				}
				}
				setState(296);
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

	public static class FeatureContext extends ParserRuleContext {
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_feature);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297); op();
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(298); match(3);
					setState(299); op();
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class DescriptionContext extends ParserRuleContext {
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public TerminalNode DESCRIPTION() { return getToken(iAgreeParser.DESCRIPTION, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(DESCRIPTION);
			setState(306); match(FOR);
			setState(307); feature();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(308); match(3);
				setState(309); feature();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(315); key_value_prop();
				}
				}
				setState(318); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0) );
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

	public static class MonitorablePropertiesContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public Global_MonitorablePropertiesContext global_MonitorableProperties() {
			return getRuleContext(Global_MonitorablePropertiesContext.class,0);
		}
		public TerminalNode MONITORABLEPROPERTIES() { return getToken(iAgreeParser.MONITORABLEPROPERTIES, 0); }
		public List<Local_MonitorablePropertiesContext> local_MonitorableProperties() {
			return getRuleContexts(Local_MonitorablePropertiesContext.class);
		}
		public Local_MonitorablePropertiesContext local_MonitorableProperties(int i) {
			return getRuleContext(Local_MonitorablePropertiesContext.class,i);
		}
		public MonitorablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monitorableProperties; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitMonitorableProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MonitorablePropertiesContext monitorableProperties() throws RecognitionException {
		MonitorablePropertiesContext _localctx = new MonitorablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_monitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(MONITORABLEPROPERTIES);
			setState(322);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(321); match(Identifier);
				}
			}

			setState(325);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(324); global_MonitorableProperties();
				}
			}

			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(327); local_MonitorableProperties();
				}
				}
				setState(332);
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

	public static class Global_MonitorablePropertiesContext extends ParserRuleContext {
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public TerminalNode GLOBAL() { return getToken(iAgreeParser.GLOBAL, 0); }
		public Global_MonitorablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_MonitorableProperties; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGlobal_MonitorableProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_MonitorablePropertiesContext global_MonitorableProperties() throws RecognitionException {
		Global_MonitorablePropertiesContext _localctx = new Global_MonitorablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_global_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); match(GLOBAL);
			setState(334); match(1);
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0)) {
				{
				{
				setState(335); key_value_prop();
				}
				}
				setState(340);
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

	public static class Local_MonitorablePropertiesContext extends ParserRuleContext {
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public Local_MonitorablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_MonitorableProperties; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitLocal_MonitorableProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_MonitorablePropertiesContext local_MonitorableProperties() throws RecognitionException {
		Local_MonitorablePropertiesContext _localctx = new Local_MonitorablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_local_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); match(FOR);
			setState(342); match(Identifier);
			setState(343); match(1);
			setState(345); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(344); key_value_prop();
				}
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0) );
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

	public static class GuaranteeTermsContext extends ParserRuleContext {
		public GuaranteeTermContext guaranteeTerm(int i) {
			return getRuleContext(GuaranteeTermContext.class,i);
		}
		public TerminalNode GUARANTEE_TERMS() { return getToken(iAgreeParser.GUARANTEE_TERMS, 0); }
		public List<GuaranteeTermContext> guaranteeTerm() {
			return getRuleContexts(GuaranteeTermContext.class);
		}
		public GuaranteeTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guaranteeTerms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGuaranteeTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuaranteeTermsContext guaranteeTerms() throws RecognitionException {
		GuaranteeTermsContext _localctx = new GuaranteeTermsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_guaranteeTerms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); match(GUARANTEE_TERMS);
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(350); guaranteeTerm();
				}
				}
				setState(355);
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

	public static class GuaranteeTermContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
		public Grouped_guaranteeTermContext grouped_guaranteeTerm() {
			return getRuleContext(Grouped_guaranteeTermContext.class,0);
		}
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
		public CuantifContext cuantif() {
			return getRuleContext(CuantifContext.class,0);
		}
		public Guarantee_defContext guarantee_def() {
			return getRuleContext(Guarantee_defContext.class,0);
		}
		public GuaranteeTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guaranteeTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGuaranteeTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuaranteeTermContext guaranteeTerm() throws RecognitionException {
		GuaranteeTermContext _localctx = new GuaranteeTermContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_guaranteeTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356); match(Identifier);
			setState(357); match(1);
			setState(363);
			switch (_input.LA(1)) {
			case PROVIDER:
			case CONSUMER:
				{
				setState(358); guarantee_def();
				}
				break;
			case EXACTLY_ONE:
			case ONE_OR_MORE:
			case ALL:
				{
				setState(359); cuantif();
				setState(360); match(OF);
				setState(361); grouped_guaranteeTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(366);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(365); match(END);
				}
				break;
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

	public static class Grouped_guaranteeTermContext extends ParserRuleContext {
		public GuaranteeTermContext guaranteeTerm(int i) {
			return getRuleContext(GuaranteeTermContext.class,i);
		}
		public List<GuaranteeTermContext> guaranteeTerm() {
			return getRuleContexts(GuaranteeTermContext.class);
		}
		public Grouped_guaranteeTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouped_guaranteeTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGrouped_guaranteeTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grouped_guaranteeTermContext grouped_guaranteeTerm() throws RecognitionException {
		Grouped_guaranteeTermContext _localctx = new Grouped_guaranteeTermContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_grouped_guaranteeTerm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(369); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(368); guaranteeTerm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(371); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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

	public static class Guarantee_defContext extends ParserRuleContext {
		public Token ob;
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
		}
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public CompensationsContext compensations(int i) {
			return getRuleContext(CompensationsContext.class,i);
		}
		public TemporalityContext temporality() {
			return getRuleContext(TemporalityContext.class,0);
		}
		public ServiceScopeContext serviceScope() {
			return getRuleContext(ServiceScopeContext.class,0);
		}
		public List<CompensationsContext> compensations() {
			return getRuleContexts(CompensationsContext.class);
		}
		public TerminalNode GUARANTEES() { return getToken(iAgreeParser.GUARANTEES, 0); }
		public SloContext slo() {
			return getRuleContext(SloContext.class,0);
		}
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public Guarantee_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guarantee_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitGuarantee_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Guarantee_defContext guarantee_def() throws RecognitionException {
		Guarantee_defContext _localctx = new Guarantee_defContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_guarantee_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			((Guarantee_defContext)_localctx).ob = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
				((Guarantee_defContext)_localctx).ob = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(374); match(GUARANTEES);
			setState(375); slo();
			setState(377);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(376); temporality();
				}
			}

			setState(379); match(2);
			setState(381);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(380); serviceScope();
				}
			}

			setState(384);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(383); qualifyingCondition();
				}
			}

			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(386); compensations();
				}
				}
				setState(391);
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

	public static class SloContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitSlo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SloContext slo() throws RecognitionException {
		SloContext _localctx = new SloContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_slo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); expression();
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

	public static class ServiceScopeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode UPON() { return getToken(iAgreeParser.UPON, 0); }
		public ServiceScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceScope; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitServiceScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceScopeContext serviceScope() throws RecognitionException {
		ServiceScopeContext _localctx = new ServiceScopeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_serviceScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394); match(UPON);
			setState(395); match(Identifier);
			setState(396); match(2);
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

	public static class QualifyingConditionContext extends ParserRuleContext {
		public TerminalNode ONLY_IF() { return getToken(iAgreeParser.ONLY_IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QualifyingConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifyingCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitQualifyingCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifyingConditionContext qualifyingCondition() throws RecognitionException {
		QualifyingConditionContext _localctx = new QualifyingConditionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_qualifyingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); match(ONLY_IF);
			setState(399); match(PA);
			setState(400); expression();
			setState(401); match(PC);
			setState(402); match(2);
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

	public static class CompensationsContext extends ParserRuleContext {
		public CompensationsIntervalContext interv;
		public Token compType;
		public TerminalNode WITH() { return getToken(iAgreeParser.WITH, 0); }
		public TerminalNode REWARD() { return getToken(iAgreeParser.REWARD, 0); }
		public CompensationsIntervalContext compensationsInterval() {
			return getRuleContext(CompensationsIntervalContext.class,0);
		}
		public List<CompensationContext> compensation() {
			return getRuleContexts(CompensationContext.class);
		}
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
		public CompensationContext compensation(int i) {
			return getRuleContext(CompensationContext.class,i);
		}
		public TerminalNode PENALTY() { return getToken(iAgreeParser.PENALTY, 0); }
		public CompensationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCompensations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompensationsContext compensations() throws RecognitionException {
		CompensationsContext _localctx = new CompensationsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_compensations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404); match(WITH);
			setState(405); ((CompensationsContext)_localctx).interv = compensationsInterval();
			setState(406);
			((CompensationsContext)_localctx).compType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PENALTY || _la==REWARD) ) {
				((CompensationsContext)_localctx).compType = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(408); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(407); compensation();
				}
				}
				setState(410); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OF );
			setState(412); match(END);
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

	public static class CompensationsIntervalContext extends ParserRuleContext {
		public TerminalNode WEEKLY() { return getToken(iAgreeParser.WEEKLY, 0); }
		public TerminalNode MINUTELY() { return getToken(iAgreeParser.MINUTELY, 0); }
		public TerminalNode MONTHLY() { return getToken(iAgreeParser.MONTHLY, 0); }
		public TerminalNode HOURLY() { return getToken(iAgreeParser.HOURLY, 0); }
		public TerminalNode YEARLY() { return getToken(iAgreeParser.YEARLY, 0); }
		public TerminalNode DAILY() { return getToken(iAgreeParser.DAILY, 0); }
		public CompensationsIntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensationsInterval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCompensationsInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompensationsIntervalContext compensationsInterval() throws RecognitionException {
		CompensationsIntervalContext _localctx = new CompensationsIntervalContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_compensationsInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << YEARLY) | (1L << MONTHLY) | (1L << WEEKLY) | (1L << DAILY) | (1L << HOURLY) | (1L << MINUTELY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class CompensationContext extends ParserRuleContext {
		public ExpressionContext e1;
		public ExpressionContext e2;
		public TerminalNode IF() { return getToken(iAgreeParser.IF, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CompensationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCompensation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompensationContext compensation() throws RecognitionException {
		CompensationContext _localctx = new CompensationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_compensation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416); match(OF);
			setState(417); ((CompensationContext)_localctx).e1 = expression();
			setState(418); match(IF);
			setState(419); ((CompensationContext)_localctx).e2 = expression();
			setState(420); match(2);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422); match(Identifier);
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

	public static class VersionNumberContext extends ParserRuleContext {
		public TerminalNode Version() { return getToken(iAgreeParser.Version, 0); }
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public VersionNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionNumber; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitVersionNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionNumberContext versionNumber() throws RecognitionException {
		VersionNumberContext _localctx = new VersionNumberContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			_la = _input.LA(1);
			if ( !(_la==Float || _la==Version) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class UrlContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Url() { return getToken(iAgreeParser.Url, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_la = _input.LA(1);
			if ( !(_la==Url || _la==String) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Key_value_propContext extends ParserRuleContext {
		public Token k;
		public Token v;
		public TypeContext v2;
		public Assig_valueContext a;
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode INTEGER() { return getToken(iAgreeParser.INTEGER, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(iAgreeParser.EQ, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public Key_value_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitKey_value_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Key_value_propContext key_value_prop() throws RecognitionException {
		Key_value_propContext _localctx = new Key_value_propContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_key_value_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			((Key_value_propContext)_localctx).k = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0)) ) {
				((Key_value_propContext)_localctx).k = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(429); match(1);
			setState(432);
			switch (_input.LA(1)) {
			case String:
				{
				setState(430); ((Key_value_propContext)_localctx).v = match(String);
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
			case SET:
			case ENUM:
			case Identifier:
				{
				setState(431); ((Key_value_propContext)_localctx).v2 = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(438);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(434); match(EQ);
				setState(435); ((Key_value_propContext)_localctx).a = assig_value();
				setState(436); match(2);
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

	public static class Assig_valueContext extends ParserRuleContext {
		public Token val;
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public TerminalNode FALSE() { return getToken(iAgreeParser.FALSE, 0); }
		public TerminalNode Integer(int i) {
			return getToken(iAgreeParser.Integer, i);
		}
		public TerminalNode TRUE() { return getToken(iAgreeParser.TRUE, 0); }
		public List<TerminalNode> String() { return getTokens(iAgreeParser.String); }
		public TerminalNode String(int i) {
			return getToken(iAgreeParser.String, i);
		}
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode Unit() { return getToken(iAgreeParser.Unit, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Integer() { return getTokens(iAgreeParser.Integer); }
		public Assig_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assig_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAssig_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assig_valueContext assig_value() throws RecognitionException {
		Assig_valueContext _localctx = new Assig_valueContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_assig_value);
		int _la;
		try {
			setState(471);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(441); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(440);
					((Assig_valueContext)_localctx).val = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Integer - 80)) | (1L << (String - 80)))) != 0)) ) {
						((Assig_valueContext)_localctx).val = (Token)_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(443); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Integer - 80)) | (1L << (String - 80)))) != 0) );
				setState(446);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(445); operation();
					}
				}

				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(449); match(Float);
				setState(451);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(450); match(Unit);
					}
				}

				setState(454);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(453); operation();
					}
				}

				}
				break;
			case S_Float:
				enterOuterAlt(_localctx, 4);
				{
				setState(456); match(S_Float);
				setState(458);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(457); match(Unit);
					}
				}

				setState(461);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(460); operation();
					}
				}

				}
				break;
			case S_Integer:
				enterOuterAlt(_localctx, 5);
				{
				setState(463); match(S_Integer);
				setState(465);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(464); match(Unit);
					}
				}

				setState(468);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(467); operation();
					}
				}

				}
				break;
			case LLA:
				enterOuterAlt(_localctx, 6);
				{
				setState(470); list();
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

	public static class OperationContext extends ParserRuleContext {
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode Operador() { return getToken(iAgreeParser.Operador, 0); }
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473); match(Operador);
			setState(474); assig_value();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext e1;
		public Token log;
		public ExpressionContext e2;
		public Token ident;
		public Token cmp;
		public Assig_valueContext val;
		public ListContext l;
		public TerminalNode LT() { return getToken(iAgreeParser.LT, 0); }
		public TerminalNode GTE() { return getToken(iAgreeParser.GTE, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode GT() { return getToken(iAgreeParser.GT, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(iAgreeParser.OR, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode LTE() { return getToken(iAgreeParser.LTE, 0); }
		public TerminalNode NOT() { return getToken(iAgreeParser.NOT, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode IMPLIES() { return getToken(iAgreeParser.IMPLIES, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode AND() { return getToken(iAgreeParser.AND, 0); }
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode EQ() { return getToken(iAgreeParser.EQ, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode BELONGS() { return getToken(iAgreeParser.BELONGS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_expression);
		int _la;
		try {
			setState(501);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(476); match(NOT);
				setState(477); ((ExpressionContext)_localctx).e1 = expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(478); match(PA);
				setState(479); ((ExpressionContext)_localctx).e1 = expression();
				setState(480); match(PC);
				setState(483);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) {
					{
					setState(481);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(482); ((ExpressionContext)_localctx).e2 = expression();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(485);
				((ExpressionContext)_localctx).ident = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Access - 80)) | (1L << (String - 80)))) != 0)) ) {
					((ExpressionContext)_localctx).ident = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(488);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LT - 73)) | (1L << (GT - 73)) | (1L << (EQ - 73)) | (1L << (LTE - 73)) | (1L << (GTE - 73)))) != 0)) {
					{
					setState(486);
					((ExpressionContext)_localctx).cmp = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LT - 73)) | (1L << (GT - 73)) | (1L << (EQ - 73)) | (1L << (LTE - 73)) | (1L << (GTE - 73)))) != 0)) ) {
						((ExpressionContext)_localctx).cmp = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(487); ((ExpressionContext)_localctx).val = assig_value();
					}
				}

				setState(492);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) {
					{
					setState(490);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(491); ((ExpressionContext)_localctx).e1 = expression();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(494);
				((ExpressionContext)_localctx).ident = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==Access) ) {
					((ExpressionContext)_localctx).ident = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(495); match(BELONGS);
				setState(496); ((ExpressionContext)_localctx).l = list();
				setState(499);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) {
					{
					setState(497);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(498); ((ExpressionContext)_localctx).e1 = expression();
					}
				}

				}
				break;
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

	public static class OpContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); match(Identifier);
			setState(514);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(504); match(PA);
				setState(505); match(Identifier);
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(506); match(3);
					setState(507); match(Identifier);
					}
					}
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(513); match(PC);
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

	public static class CuantifContext extends ParserRuleContext {
		public TerminalNode EXACTLY_ONE() { return getToken(iAgreeParser.EXACTLY_ONE, 0); }
		public TerminalNode ONE_OR_MORE() { return getToken(iAgreeParser.ONE_OR_MORE, 0); }
		public TerminalNode ALL() { return getToken(iAgreeParser.ALL, 0); }
		public CuantifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantif; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCuantif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuantifContext cuantif() throws RecognitionException {
		CuantifContext _localctx = new CuantifContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_la = _input.LA(1);
			if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (EXACTLY_ONE - 70)) | (1L << (ONE_OR_MORE - 70)) | (1L << (ALL - 70)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class TypeContext extends ParserRuleContext {
		public Token v;
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode INTEGER() { return getToken(iAgreeParser.INTEGER, 0); }
		public TerminalNode ENUM() { return getToken(iAgreeParser.ENUM, 0); }
		public TerminalNode NATURAL() { return getToken(iAgreeParser.NATURAL, 0); }
		public TerminalNode NUMBER() { return getToken(iAgreeParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode SET() { return getToken(iAgreeParser.SET, 0); }
		public TerminalNode FLOAT() { return getToken(iAgreeParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_type);
		int _la;
		try {
			setState(527);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(518); match(Identifier);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(519); match(SET);
				setState(520); list();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(521); match(ENUM);
				setState(522); list();
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
				enterOuterAlt(_localctx, 4);
				{
				setState(523);
				((TypeContext)_localctx).v = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((TypeContext)_localctx).v = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(525);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(524); range();
					}
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

	public static class ListContext extends ParserRuleContext {
		public ListArgContext l1;
		public ListArgContext l2;
		public ListArgContext listArg(int i) {
			return getRuleContext(ListArgContext.class,i);
		}
		public List<ListArgContext> listArg() {
			return getRuleContexts(ListArgContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); match(LLA);
			setState(530); ((ListContext)_localctx).l1 = listArg();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(531); match(3);
				setState(532); ((ListContext)_localctx).l2 = listArg();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538); match(LLC);
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

	public static class ListArgContext extends ParserRuleContext {
		public Token l1;
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public ListArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listArg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitListArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListArgContext listArg() throws RecognitionException {
		ListArgContext _localctx = new ListArgContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_listArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			((ListArgContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Integer - 80)) | (1L << (S_Integer - 80)) | (1L << (Float - 80)) | (1L << (S_Float - 80)) | (1L << (String - 80)))) != 0)) ) {
				((ListArgContext)_localctx).l1 = (Token)_errHandler.recoverInline(this);
			}
			consume();
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

	public static class RangeContext extends ParserRuleContext {
		public Token min;
		public Token max;
		public TerminalNode S_Integer(int i) {
			return getToken(iAgreeParser.S_Integer, i);
		}
		public List<TerminalNode> S_Integer() { return getTokens(iAgreeParser.S_Integer); }
		public TerminalNode Integer(int i) {
			return getToken(iAgreeParser.Integer, i);
		}
		public List<TerminalNode> Integer() { return getTokens(iAgreeParser.Integer); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542); match(CA);
			setState(543);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(544); match(4);
			setState(545);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(546); match(CC);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3b\u0227\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2y\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0087\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\7\5\u008f\n\5\f\5\16\5\u0092\13\5\3\5\3\5\5"+
		"\5\u0096\n\5\3\6\7\6\u0099\n\6\f\6\16\6\u009c\13\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a9\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\13\6\13\u00b6\n\13\r\13\16\13\u00b7\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00bf\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\6\24\u00e0\n\24\r\24\16\24\u00e1\3\25\3\25\3\25\6"+
		"\25\u00e7\n\25\r\25\16\25\u00e8\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u00f8\n\30\f\30\16\30\u00fb\13\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0103\n\31\3\31\3\31\3\31\5\31\u0108\n"+
		"\31\3\32\3\32\3\32\3\32\5\32\u010e\n\32\3\32\5\32\u0111\n\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u011b\n\33\f\33\16\33\u011e\13\33"+
		"\3\34\3\34\6\34\u0122\n\34\r\34\16\34\u0123\3\35\7\35\u0127\n\35\f\35"+
		"\16\35\u012a\13\35\3\36\3\36\3\36\7\36\u012f\n\36\f\36\16\36\u0132\13"+
		"\36\3\37\3\37\3\37\3\37\3\37\7\37\u0139\n\37\f\37\16\37\u013c\13\37\3"+
		"\37\6\37\u013f\n\37\r\37\16\37\u0140\3 \3 \5 \u0145\n \3 \5 \u0148\n "+
		"\3 \7 \u014b\n \f \16 \u014e\13 \3!\3!\3!\7!\u0153\n!\f!\16!\u0156\13"+
		"!\3\"\3\"\3\"\3\"\6\"\u015c\n\"\r\"\16\"\u015d\3#\3#\7#\u0162\n#\f#\16"+
		"#\u0165\13#\3$\3$\3$\3$\3$\3$\3$\5$\u016e\n$\3$\5$\u0171\n$\3%\6%\u0174"+
		"\n%\r%\16%\u0175\3&\3&\3&\3&\5&\u017c\n&\3&\3&\5&\u0180\n&\3&\5&\u0183"+
		"\n&\3&\7&\u0186\n&\f&\16&\u0189\13&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3"+
		")\3)\3*\3*\3*\3*\6*\u019b\n*\r*\16*\u019c\3*\3*\3+\3+\3,\3,\3,\3,\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\5\60\u01b3\n\60\3\60\3\60\3\60"+
		"\3\60\5\60\u01b9\n\60\3\61\6\61\u01bc\n\61\r\61\16\61\u01bd\3\61\5\61"+
		"\u01c1\n\61\3\61\3\61\3\61\5\61\u01c6\n\61\3\61\5\61\u01c9\n\61\3\61\3"+
		"\61\5\61\u01cd\n\61\3\61\5\61\u01d0\n\61\3\61\3\61\5\61\u01d4\n\61\3\61"+
		"\5\61\u01d7\n\61\3\61\5\61\u01da\n\61\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\5\63\u01e6\n\63\3\63\3\63\3\63\5\63\u01eb\n\63\3\63"+
		"\3\63\5\63\u01ef\n\63\3\63\3\63\3\63\3\63\3\63\5\63\u01f6\n\63\5\63\u01f8"+
		"\n\63\3\64\3\64\3\64\3\64\3\64\7\64\u01ff\n\64\f\64\16\64\u0202\13\64"+
		"\3\64\5\64\u0205\n\64\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66"+
		"\u0210\n\66\5\66\u0212\n\66\3\67\3\67\3\67\3\67\7\67\u0218\n\67\f\67\16"+
		"\67\u021b\13\67\3\67\3\67\38\38\39\39\39\39\39\39\39\2:\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnp\2\24\4\2\37 RR\3\2ST\4\2\"\"CC\3\2\37 \3\2\66\67\3\2\60\65\4\2"+
		"UUYY\4\2XX__\5\2$%RR\\\\\4\2RS__\3\2+,\4\2CDFF\5\2RR\\\\__\3\2KO\4\2R"+
		"R\\\\\3\2HJ\3\2$(\4\2RV__\u0236\2x\3\2\2\2\4z\3\2\2\2\6\u0080\3\2\2\2"+
		"\b\u0090\3\2\2\2\n\u009a\3\2\2\2\f\u00a8\3\2\2\2\16\u00aa\3\2\2\2\20\u00ad"+
		"\3\2\2\2\22\u00b0\3\2\2\2\24\u00b5\3\2\2\2\26\u00b9\3\2\2\2\30\u00c0\3"+
		"\2\2\2\32\u00c4\3\2\2\2\34\u00c8\3\2\2\2\36\u00cc\3\2\2\2 \u00d0\3\2\2"+
		"\2\"\u00d4\3\2\2\2$\u00d8\3\2\2\2&\u00dc\3\2\2\2(\u00e3\3\2\2\2*\u00ea"+
		"\3\2\2\2,\u00ef\3\2\2\2.\u00f2\3\2\2\2\60\u0107\3\2\2\2\62\u0109\3\2\2"+
		"\2\64\u0115\3\2\2\2\66\u011f\3\2\2\28\u0128\3\2\2\2:\u012b\3\2\2\2<\u0133"+
		"\3\2\2\2>\u0142\3\2\2\2@\u014f\3\2\2\2B\u0157\3\2\2\2D\u015f\3\2\2\2F"+
		"\u0166\3\2\2\2H\u0173\3\2\2\2J\u0177\3\2\2\2L\u018a\3\2\2\2N\u018c\3\2"+
		"\2\2P\u0190\3\2\2\2R\u0196\3\2\2\2T\u01a0\3\2\2\2V\u01a2\3\2\2\2X\u01a8"+
		"\3\2\2\2Z\u01aa\3\2\2\2\\\u01ac\3\2\2\2^\u01ae\3\2\2\2`\u01d9\3\2\2\2"+
		"b\u01db\3\2\2\2d\u01f7\3\2\2\2f\u01f9\3\2\2\2h\u0206\3\2\2\2j\u0211\3"+
		"\2\2\2l\u0213\3\2\2\2n\u021e\3\2\2\2p\u0220\3\2\2\2rs\5\4\3\2st\7\b\2"+
		"\2ty\3\2\2\2uv\5\6\4\2vw\7\n\2\2wy\3\2\2\2xr\3\2\2\2xu\3\2\2\2y\3\3\2"+
		"\2\2z{\7\7\2\2{|\7R\2\2|}\7!\2\2}~\5Z.\2~\177\5\b\5\2\177\5\3\2\2\2\u0080"+
		"\u0081\7\t\2\2\u0081\u0082\7R\2\2\u0082\u0083\7!\2\2\u0083\u0084\5Z.\2"+
		"\u0084\u0086\7;\2\2\u0085\u0087\7\7\2\2\u0086\u0085\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7R\2\2\u0089\u008a\7!\2\2\u008a"+
		"\u008b\5Z.\2\u008b\u008c\5\n\6\2\u008c\7\3\2\2\2\u008d\u008f\5\f\7\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\5\16\b\2\u0094"+
		"\u0096\5\20\t\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\t\3\2\2"+
		"\2\u0097\u0099\5\f\7\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u009e\5\16\b\2\u009e\13\3\2\2\2\u009f\u00a9\5\30\r\2\u00a0\u00a9\5\32"+
		"\16\2\u00a1\u00a9\5\34\17\2\u00a2\u00a9\5\36\20\2\u00a3\u00a9\5 \21\2"+
		"\u00a4\u00a9\5\"\22\2\u00a5\u00a9\5$\23\2\u00a6\u00a9\5&\24\2\u00a7\u00a9"+
		"\5(\25\2\u00a8\u009f\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8"+
		"\u00a2\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\r\3\2\2\2\u00aa\u00ab"+
		"\7\24\2\2\u00ab\u00ac\5\22\n\2\u00ac\17\3\2\2\2\u00ad\u00ae\7\25\2\2\u00ae"+
		"\u00af\5\24\13\2\u00af\21\3\2\2\2\u00b0\u00b1\5\62\32\2\u00b1\u00b2\5"+
		"> \2\u00b2\u00b3\5D#\2\u00b3\23\3\2\2\2\u00b4\u00b6\5\26\f\2\u00b5\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\25\3\2\2\2\u00b9\u00ba\7R\2\2\u00ba\u00bb\7\3\2\2\u00bb\u00bc\5d\63\2"+
		"\u00bc\u00be\7\4\2\2\u00bd\u00bf\5P)\2\u00be\u00bd\3\2\2\2\u00be\u00bf"+
		"\3\2\2\2\u00bf\27\3\2\2\2\u00c0\u00c1\7\13\2\2\u00c1\u00c2\7\3\2\2\u00c2"+
		"\u00c3\7_\2\2\u00c3\31\3\2\2\2\u00c4\u00c5\t\2\2\2\u00c5\u00c6\7<\2\2"+
		"\u00c6\u00c7\7\f\2\2\u00c7\33\3\2\2\2\u00c8\u00c9\7\r\2\2\u00c9\u00ca"+
		"\7\3\2\2\u00ca\u00cb\7_\2\2\u00cb\35\3\2\2\2\u00cc\u00cd\7\16\2\2\u00cd"+
		"\u00ce\7\3\2\2\u00ce\u00cf\7_\2\2\u00cf\37\3\2\2\2\u00d0\u00d1\7\17\2"+
		"\2\u00d1\u00d2\7\3\2\2\u00d2\u00d3\7_\2\2\u00d3!\3\2\2\2\u00d4\u00d5\7"+
		"\20\2\2\u00d5\u00d6\7\3\2\2\u00d6\u00d7\t\3\2\2\u00d7#\3\2\2\2\u00d8\u00d9"+
		"\7\21\2\2\u00d9\u00da\7\3\2\2\u00da\u00db\5*\26\2\u00db%\3\2\2\2\u00dc"+
		"\u00dd\7\22\2\2\u00dd\u00df\7\3\2\2\u00de\u00e0\5.\30\2\u00df\u00de\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\'\3\2\2\2\u00e3\u00e4\7\23\2\2\u00e4\u00e6\7\3\2\2\u00e5\u00e7\5^\60"+
		"\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9)\3\2\2\2\u00ea\u00eb\7#\2\2\u00eb\u00ec\7Z\2\2\u00ec\u00ed"+
		"\7\6\2\2\u00ed\u00ee\7Z\2\2\u00ee+\3\2\2\2\u00ef\u00f0\78\2\2\u00f0\u00f1"+
		"\7R\2\2\u00f1-\3\2\2\2\u00f2\u00f3\7R\2\2\u00f3\u00f4\7\3\2\2\u00f4\u00f9"+
		"\5\60\31\2\u00f5\u00f6\t\4\2\2\u00f6\u00f8\5\60\31\2\u00f7\u00f5\3\2\2"+
		"\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa/"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\79\2\2\u00fd\u00fe\7[\2\2\u00fe"+
		"\u00ff\7\6\2\2\u00ff\u0102\7[\2\2\u0100\u0101\78\2\2\u0101\u0103\7R\2"+
		"\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0108"+
		"\5*\26\2\u0105\u0108\5X-\2\u0106\u0108\7\21\2\2\u0107\u00fc\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108\61\3\2\2\2\u0109\u010a\7\27\2"+
		"\2\u010a\u010d\7R\2\2\u010b\u010c\7\36\2\2\u010c\u010e\5\\/\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u0111\5\64\33\2"+
		"\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113"+
		"\5\66\34\2\u0113\u0114\58\35\2\u0114\63\3\2\2\2\u0115\u0116\7\30\2\2\u0116"+
		"\u0117\7\3\2\2\u0117\u011c\5:\36\2\u0118\u0119\7\5\2\2\u0119\u011b\5:"+
		"\36\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\65\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0121\7\31\2"+
		"\2\u0120\u0122\5^\60\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\67\3\2\2\2\u0125\u0127\5<\37\2\u0126"+
		"\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u01299\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0130\5f\64\2\u012c\u012d"+
		"\7\5\2\2\u012d\u012f\5f\64\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131;\3\2\2\2\u0132\u0130\3\2\2\2"+
		"\u0133\u0134\7\32\2\2\u0134\u0135\7;\2\2\u0135\u013a\5:\36\2\u0136\u0137"+
		"\7\5\2\2\u0137\u0139\5:\36\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u013f\5^\60\2\u013e\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141=\3\2\2\2\u0142\u0144\7\34\2\2"+
		"\u0143\u0145\7R\2\2\u0144\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147"+
		"\3\2\2\2\u0146\u0148\5@!\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u014c\3\2\2\2\u0149\u014b\5B\"\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d?\3\2\2\2\u014e\u014c"+
		"\3\2\2\2\u014f\u0150\7\33\2\2\u0150\u0154\7\3\2\2\u0151\u0153\5^\60\2"+
		"\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155A\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158\7;\2\2\u0158\u0159"+
		"\7R\2\2\u0159\u015b\7\3\2\2\u015a\u015c\5^\60\2\u015b\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015eC\3\2\2\2"+
		"\u015f\u0163\7\26\2\2\u0160\u0162\5F$\2\u0161\u0160\3\2\2\2\u0162\u0165"+
		"\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164E\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0167\7R\2\2\u0167\u016d\7\3\2\2\u0168\u016e\5J&"+
		"\2\u0169\u016a\5h\65\2\u016a\u016b\7:\2\2\u016b\u016c\5H%\2\u016c\u016e"+
		"\3\2\2\2\u016d\u0168\3\2\2\2\u016d\u0169\3\2\2\2\u016e\u0170\3\2\2\2\u016f"+
		"\u0171\7.\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171G\3\2\2\2\u0172"+
		"\u0174\5F$\2\u0173\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0173\3\2\2"+
		"\2\u0175\u0176\3\2\2\2\u0176I\3\2\2\2\u0177\u0178\t\5\2\2\u0178\u0179"+
		"\7\35\2\2\u0179\u017b\5L\'\2\u017a\u017c\5,\27\2\u017b\u017a\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\7\4\2\2\u017e\u0180\5N"+
		"(\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181"+
		"\u0183\5P)\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0187\3\2\2"+
		"\2\u0184\u0186\5R*\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188K\3\2\2\2\u0189\u0187\3\2\2\2\u018a"+
		"\u018b\5d\63\2\u018bM\3\2\2\2\u018c\u018d\7Q\2\2\u018d\u018e\7R\2\2\u018e"+
		"\u018f\7\4\2\2\u018fO\3\2\2\2\u0190\u0191\7G\2\2\u0191\u0192\7?\2\2\u0192"+
		"\u0193\5d\63\2\u0193\u0194\7@\2\2\u0194\u0195\7\4\2\2\u0195Q\3\2\2\2\u0196"+
		"\u0197\7-\2\2\u0197\u0198\5T+\2\u0198\u019a\t\6\2\2\u0199\u019b\5V,\2"+
		"\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d"+
		"\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7.\2\2\u019fS\3\2\2\2\u01a0\u01a1"+
		"\t\7\2\2\u01a1U\3\2\2\2\u01a2\u01a3\7:\2\2\u01a3\u01a4\5d\63\2\u01a4\u01a5"+
		"\7/\2\2\u01a5\u01a6\5d\63\2\u01a6\u01a7\7\4\2\2\u01a7W\3\2\2\2\u01a8\u01a9"+
		"\7R\2\2\u01a9Y\3\2\2\2\u01aa\u01ab\t\b\2\2\u01ab[\3\2\2\2\u01ac\u01ad"+
		"\t\t\2\2\u01ad]\3\2\2\2\u01ae\u01af\t\n\2\2\u01af\u01b2\7\3\2\2\u01b0"+
		"\u01b3\7_\2\2\u01b1\u01b3\5j\66\2\u01b2\u01b0\3\2\2\2\u01b2\u01b1\3\2"+
		"\2\2\u01b3\u01b8\3\2\2\2\u01b4\u01b5\7M\2\2\u01b5\u01b6\5`\61\2\u01b6"+
		"\u01b7\7\4\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b4\3\2\2\2\u01b8\u01b9\3\2"+
		"\2\2\u01b9_\3\2\2\2\u01ba\u01bc\t\13\2\2\u01bb\u01ba\3\2\2\2\u01bc\u01bd"+
		"\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf"+
		"\u01c1\5b\62\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01da\3\2"+
		"\2\2\u01c2\u01da\t\f\2\2\u01c3\u01c5\7U\2\2\u01c4\u01c6\7]\2\2\u01c5\u01c4"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c9\5b\62\2\u01c8"+
		"\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01da\3\2\2\2\u01ca\u01cc\7V"+
		"\2\2\u01cb\u01cd\7]\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01cf\3\2\2\2\u01ce\u01d0\5b\62\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2"+
		"\2\2\u01d0\u01da\3\2\2\2\u01d1\u01d3\7T\2\2\u01d2\u01d4\7]\2\2\u01d3\u01d2"+
		"\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d7\5b\62\2\u01d6"+
		"\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01da\5l"+
		"\67\2\u01d9\u01bb\3\2\2\2\u01d9\u01c2\3\2\2\2\u01d9\u01c3\3\2\2\2\u01d9"+
		"\u01ca\3\2\2\2\u01d9\u01d1\3\2\2\2\u01d9\u01d8\3\2\2\2\u01daa\3\2\2\2"+
		"\u01db\u01dc\7^\2\2\u01dc\u01dd\5`\61\2\u01ddc\3\2\2\2\u01de\u01df\7E"+
		"\2\2\u01df\u01f8\5d\63\2\u01e0\u01e1\7?\2\2\u01e1\u01e2\5d\63\2\u01e2"+
		"\u01e5\7@\2\2\u01e3\u01e4\t\r\2\2\u01e4\u01e6\5d\63\2\u01e5\u01e3\3\2"+
		"\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01f8\3\2\2\2\u01e7\u01ea\t\16\2\2\u01e8"+
		"\u01e9\t\17\2\2\u01e9\u01eb\5`\61\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3"+
		"\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ed\t\r\2\2\u01ed\u01ef\5d\63\2\u01ee"+
		"\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f8\3\2\2\2\u01f0\u01f1\t\20"+
		"\2\2\u01f1\u01f2\7P\2\2\u01f2\u01f5\5l\67\2\u01f3\u01f4\t\r\2\2\u01f4"+
		"\u01f6\5d\63\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2"+
		"\2\2\u01f7\u01de\3\2\2\2\u01f7\u01e0\3\2\2\2\u01f7\u01e7\3\2\2\2\u01f7"+
		"\u01f0\3\2\2\2\u01f8e\3\2\2\2\u01f9\u0204\7R\2\2\u01fa\u01fb\7?\2\2\u01fb"+
		"\u0200\7R\2\2\u01fc\u01fd\7\5\2\2\u01fd\u01ff\7R\2\2\u01fe\u01fc\3\2\2"+
		"\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0203"+
		"\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0205\7@\2\2\u0204\u01fa\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205g\3\2\2\2\u0206\u0207\t\21\2\2\u0207i\3\2\2\2\u0208"+
		"\u0212\7R\2\2\u0209\u020a\7)\2\2\u020a\u0212\5l\67\2\u020b\u020c\7*\2"+
		"\2\u020c\u0212\5l\67\2\u020d\u020f\t\22\2\2\u020e\u0210\5p9\2\u020f\u020e"+
		"\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0212\3\2\2\2\u0211\u0208\3\2\2\2\u0211"+
		"\u0209\3\2\2\2\u0211\u020b\3\2\2\2\u0211\u020d\3\2\2\2\u0212k\3\2\2\2"+
		"\u0213\u0214\7A\2\2\u0214\u0219\5n8\2\u0215\u0216\7\5\2\2\u0216\u0218"+
		"\5n8\2\u0217\u0215\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u021d\7B"+
		"\2\2\u021dm\3\2\2\2\u021e\u021f\t\23\2\2\u021fo\3\2\2\2\u0220\u0221\7"+
		"=\2\2\u0221\u0222\t\3\2\2\u0222\u0223\7\6\2\2\u0223\u0224\t\3\2\2\u0224"+
		"\u0225\7>\2\2\u0225q\3\2\2\2:x\u0086\u0090\u0095\u009a\u00a8\u00b7\u00be"+
		"\u00e1\u00e8\u00f9\u0102\u0107\u010d\u0110\u011c\u0123\u0128\u0130\u013a"+
		"\u0140\u0144\u0147\u014c\u0154\u015d\u0163\u016d\u0170\u0175\u017b\u017f"+
		"\u0182\u0187\u019c\u01b2\u01b8\u01bd\u01c0\u01c5\u01c8\u01cc\u01cf\u01d3"+
		"\u01d6\u01d9\u01e5\u01ea\u01ee\u01f5\u01f7\u0200\u0204\u020f\u0211\u0219";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}