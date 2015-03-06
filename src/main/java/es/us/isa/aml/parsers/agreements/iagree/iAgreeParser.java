// Generated from C:\Users\ISA Group\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package es.us.isa.aml.parsers.agreements.iagree;
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
		ALL=72, LT=73, GT=74, EQ=75, NEQ=76, LTE=77, GTE=78, ADD=79, SUBTRACT=80, 
		MULTIPLY=81, DIVIDE=82, ASSIG=83, BELONGS=84, UPON=85, Identifier=86, 
		Integer=87, S_Integer=88, Float=89, S_Float=90, Boolean=91, Url=92, Version=93, 
		Date=94, Hour=95, Access=96, Unit=97, String=98, WS=99, COMMENT=100, LINE_COMMENT=101;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "':'", "';'", "'..'", "'Template'", "'EndTemplate'", 
		"'AgreementOffer'", "'EndAgreementOffer'", "'Initiator'", "'Responder'", 
		"'ServiceProvider'", "'ExpirationTime'", "'DateFormat'", "'GMTZone'", 
		"'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", "'AgreementTerms'", 
		"'CreationConstraints'", "'GuaranteeTerms'", "'Service'", "'Features'", 
		"'GlobalDescription'", "'Description'", "'global'", "'MonitorableProperties'", 
		"'guarantees'", "'availableAt.'", "'Provider'", "'Consumer'", "'version'", 
		"'except'", "'during'", "'boolean'", "'integer'", "'float'", "'natural'", 
		"'number'", "'set'", "'enum'", "'true'", "'false'", "'with'", "'end'", 
		"'if'", "'yearly'", "'monthly'", "'weekly'", "'daily'", "'hourly'", "'minutely'", 
		"'penalty'", "'reward'", "'on'", "'from'", "'of'", "'for'", "'as'", "'['", 
		"']'", "'('", "')'", "'{'", "'}'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", 
		"'onlyIf'", "'exactly one'", "'one or more'", "'all'", "'<'", "'>'", "'=='", 
		"'!='", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'='", "'belongs'", 
		"'upon'", "Identifier", "Integer", "S_Integer", "Float", "S_Float", "Boolean", 
		"Url", "Version", "Date", "Hour", "Access", "Unit", "String", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_entry = 0, RULE_template = 1, RULE_agOffer = 2, RULE_template_def = 3, 
		RULE_ag_def = 4, RULE_temp_properties = 5, RULE_agreementTerms = 6, RULE_creationConstraints = 7, 
		RULE_creationConstraint = 8, RULE_initiator_prop = 9, RULE_responder_prop = 10, 
		RULE_serviceProvider_prop = 11, RULE_expirationTime_prop = 12, RULE_dateFormat_prop = 13, 
		RULE_gmtZone_prop = 14, RULE_globalPeriod_prop = 15, RULE_definedPeriod_prop = 16, 
		RULE_metrics_prop = 17, RULE_metric = 18, RULE_datePeriod_def = 19, RULE_temporality = 20, 
		RULE_period = 21, RULE_period_def = 22, RULE_service = 23, RULE_features = 24, 
		RULE_feature = 25, RULE_feature_operation = 26, RULE_globalDescription = 27, 
		RULE_localDescription = 28, RULE_monitorableProperties = 29, RULE_global_MonitorableProperties = 30, 
		RULE_local_MonitorableProperties = 31, RULE_guaranteeTerms = 32, RULE_guaranteeTerm = 33, 
		RULE_guarantee_def = 34, RULE_slo = 35, RULE_serviceScope = 36, RULE_qualifyingCondition = 37, 
		RULE_compensations = 38, RULE_compensationsInterval = 39, RULE_compensation = 40, 
		RULE_versionNumber = 41, RULE_url = 42, RULE_property = 43, RULE_expression = 44, 
		RULE_atom = 45, RULE_cuantif = 46, RULE_list = 47, RULE_listArg = 48, 
		RULE_range = 49;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "template_def", "ag_def", "temp_properties", 
		"agreementTerms", "creationConstraints", "creationConstraint", "initiator_prop", 
		"responder_prop", "serviceProvider_prop", "expirationTime_prop", "dateFormat_prop", 
		"gmtZone_prop", "globalPeriod_prop", "definedPeriod_prop", "metrics_prop", 
		"metric", "datePeriod_def", "temporality", "period", "period_def", "service", 
		"features", "feature", "feature_operation", "globalDescription", "localDescription", 
		"monitorableProperties", "global_MonitorableProperties", "local_MonitorableProperties", 
		"guaranteeTerms", "guaranteeTerm", "guarantee_def", "slo", "serviceScope", 
		"qualifyingCondition", "compensations", "compensationsInterval", "compensation", 
		"versionNumber", "url", "property", "expression", "atom", "cuantif", "list", 
		"listArg", "range"
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
		public TerminalNode END_TEMPLATE() { return getToken(iAgreeParser.END_TEMPLATE, 0); }
		public TerminalNode END_AG_OFFER() { return getToken(iAgreeParser.END_AG_OFFER, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public AgOfferContext agOffer() {
			return getRuleContext(AgOfferContext.class,0);
		}
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
			setState(106);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(100); template();
				setState(101); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(103); agOffer();
				setState(104); match(END_AG_OFFER);
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
		public Token id;
		public VersionNumberContext version;
		public VersionNumberContext versionNumber() {
			return getRuleContext(VersionNumberContext.class,0);
		}
		public Template_defContext template_def() {
			return getRuleContext(Template_defContext.class,0);
		}
		public TerminalNode VERSION() { return getToken(iAgreeParser.VERSION, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode TEMPLATE() { return getToken(iAgreeParser.TEMPLATE, 0); }
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
			setState(108); match(TEMPLATE);
			setState(109); ((TemplateContext)_localctx).id = match(Identifier);
			setState(110); match(VERSION);
			setState(111); ((TemplateContext)_localctx).version = versionNumber();
			setState(112); template_def();
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
		public Token id;
		public VersionNumberContext version;
		public Token templateId;
		public VersionNumberContext templateVersion;
		public List<VersionNumberContext> versionNumber() {
			return getRuleContexts(VersionNumberContext.class);
		}
		public Ag_defContext ag_def() {
			return getRuleContext(Ag_defContext.class,0);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<TerminalNode> VERSION() { return getTokens(iAgreeParser.VERSION); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public TerminalNode AG_OFFER() { return getToken(iAgreeParser.AG_OFFER, 0); }
		public VersionNumberContext versionNumber(int i) {
			return getRuleContext(VersionNumberContext.class,i);
		}
		public TerminalNode TEMPLATE() { return getToken(iAgreeParser.TEMPLATE, 0); }
		public TerminalNode VERSION(int i) {
			return getToken(iAgreeParser.VERSION, i);
		}
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
			setState(114); match(AG_OFFER);
			setState(115); ((AgOfferContext)_localctx).id = match(Identifier);
			setState(116); match(VERSION);
			setState(117); ((AgOfferContext)_localctx).version = versionNumber();
			setState(118); match(FOR);
			setState(120);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(119); match(TEMPLATE);
				}
			}

			setState(122); ((AgOfferContext)_localctx).templateId = match(Identifier);
			setState(123); match(VERSION);
			setState(124); ((AgOfferContext)_localctx).templateVersion = versionNumber();
			setState(125); ag_def();
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
		public CreationConstraintsContext creationConstraints() {
			return getRuleContext(CreationConstraintsContext.class,0);
		}
		public Temp_propertiesContext temp_properties(int i) {
			return getRuleContext(Temp_propertiesContext.class,i);
		}
		public AgreementTermsContext agreementTerms() {
			return getRuleContext(AgreementTermsContext.class,0);
		}
		public List<Temp_propertiesContext> temp_properties() {
			return getRuleContexts(Temp_propertiesContext.class);
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
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(127); temp_properties();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133); agreementTerms();
			setState(135);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(134); creationConstraints();
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
		public AgreementTermsContext agreementTerms() {
			return getRuleContext(AgreementTermsContext.class,0);
		}
		public List<Temp_propertiesContext> temp_properties() {
			return getRuleContexts(Temp_propertiesContext.class);
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
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(137); temp_properties();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143); agreementTerms();
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
		public Responder_propContext responder_prop() {
			return getRuleContext(Responder_propContext.class,0);
		}
		public Initiator_propContext initiator_prop() {
			return getRuleContext(Initiator_propContext.class,0);
		}
		public Metrics_propContext metrics_prop() {
			return getRuleContext(Metrics_propContext.class,0);
		}
		public DefinedPeriod_propContext definedPeriod_prop() {
			return getRuleContext(DefinedPeriod_propContext.class,0);
		}
		public DateFormat_propContext dateFormat_prop() {
			return getRuleContext(DateFormat_propContext.class,0);
		}
		public GmtZone_propContext gmtZone_prop() {
			return getRuleContext(GmtZone_propContext.class,0);
		}
		public ServiceProvider_propContext serviceProvider_prop() {
			return getRuleContext(ServiceProvider_propContext.class,0);
		}
		public ExpirationTime_propContext expirationTime_prop() {
			return getRuleContext(ExpirationTime_propContext.class,0);
		}
		public GlobalPeriod_propContext globalPeriod_prop() {
			return getRuleContext(GlobalPeriod_propContext.class,0);
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
			setState(154);
			switch (_input.LA(1)) {
			case INITIATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(145); initiator_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(146); responder_prop();
				}
				break;
			case SERVICEPROVIDER:
				enterOuterAlt(_localctx, 3);
				{
				setState(147); serviceProvider_prop();
				}
				break;
			case EXPIRATIONTIME:
				enterOuterAlt(_localctx, 4);
				{
				setState(148); expirationTime_prop();
				}
				break;
			case DATEFORMAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(149); dateFormat_prop();
				}
				break;
			case GMTZONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(150); gmtZone_prop();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 7);
				{
				setState(151); globalPeriod_prop();
				}
				break;
			case DEFINEDPERIOD:
				enterOuterAlt(_localctx, 8);
				{
				setState(152); definedPeriod_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 9);
				{
				setState(153); metrics_prop();
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
		public ServiceContext service() {
			return getRuleContext(ServiceContext.class,0);
		}
		public MonitorablePropertiesContext monitorableProperties() {
			return getRuleContext(MonitorablePropertiesContext.class,0);
		}
		public TerminalNode AGREEMENT_TERMS() { return getToken(iAgreeParser.AGREEMENT_TERMS, 0); }
		public GuaranteeTermsContext guaranteeTerms() {
			return getRuleContext(GuaranteeTermsContext.class,0);
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
			setState(156); match(AGREEMENT_TERMS);
			setState(157); service();
			setState(158); monitorableProperties();
			setState(159); guaranteeTerms();
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
		public CreationConstraintContext creationConstraint(int i) {
			return getRuleContext(CreationConstraintContext.class,i);
		}
		public TerminalNode CREATION_CONSTRAINTS() { return getToken(iAgreeParser.CREATION_CONSTRAINTS, 0); }
		public List<CreationConstraintContext> creationConstraint() {
			return getRuleContexts(CreationConstraintContext.class);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); match(CREATION_CONSTRAINTS);
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162); creationConstraint();
				}
				}
				setState(165); 
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
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
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
		enterRule(_localctx, 16, RULE_creationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(167); match(Identifier);
			}
			setState(168); match(2);
			setState(169); expression(0);
			setState(170); match(3);
			setState(172);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(171); qualifyingCondition();
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
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode INITIATOR() { return getToken(iAgreeParser.INITIATOR, 0); }
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
		enterRule(_localctx, 18, RULE_initiator_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(INITIATOR);
			setState(175); match(2);
			setState(176); match(String);
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
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode AS() { return getToken(iAgreeParser.AS, 0); }
		public TerminalNode RESPONDER() { return getToken(iAgreeParser.RESPONDER, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
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
		enterRule(_localctx, 20, RULE_responder_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !(((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (PROVIDER - 29)) | (1L << (CONSUMER - 29)) | (1L << (Identifier - 29)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(179); match(AS);
			setState(180); match(RESPONDER);
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
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode SERVICEPROVIDER() { return getToken(iAgreeParser.SERVICEPROVIDER, 0); }
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
		enterRule(_localctx, 22, RULE_serviceProvider_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); match(SERVICEPROVIDER);
			setState(183); match(2);
			setState(184); match(String);
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
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode EXPIRATIONTIME() { return getToken(iAgreeParser.EXPIRATIONTIME, 0); }
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
		enterRule(_localctx, 24, RULE_expirationTime_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); match(EXPIRATIONTIME);
			setState(187); match(2);
			setState(188); match(String);
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
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode DATEFORMAT() { return getToken(iAgreeParser.DATEFORMAT, 0); }
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
		enterRule(_localctx, 26, RULE_dateFormat_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(DATEFORMAT);
			setState(191); match(2);
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

	public static class GmtZone_propContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode GMTZONE() { return getToken(iAgreeParser.GMTZONE, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
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
		enterRule(_localctx, 28, RULE_gmtZone_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(GMTZONE);
			setState(195); match(2);
			setState(196);
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
		public DatePeriod_defContext datePeriod_def() {
			return getRuleContext(DatePeriod_defContext.class,0);
		}
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
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
		enterRule(_localctx, 30, RULE_globalPeriod_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); match(GLOBALPERIOD);
			setState(199); match(2);
			setState(200); datePeriod_def();
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
		public List<PeriodContext> period() {
			return getRuleContexts(PeriodContext.class);
		}
		public TerminalNode DEFINEDPERIOD() { return getToken(iAgreeParser.DEFINEDPERIOD, 0); }
		public PeriodContext period(int i) {
			return getRuleContext(PeriodContext.class,i);
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
		enterRule(_localctx, 32, RULE_definedPeriod_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(DEFINEDPERIOD);
			setState(203); match(2);
			setState(205); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(204); period();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(207); 
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
		public MetricContext metric(int i) {
			return getRuleContext(MetricContext.class,i);
		}
		public List<MetricContext> metric() {
			return getRuleContexts(MetricContext.class);
		}
		public TerminalNode METRICS() { return getToken(iAgreeParser.METRICS, 0); }
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
		enterRule(_localctx, 34, RULE_metrics_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(METRICS);
			setState(210); match(2);
			setState(212); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(211); metric();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(214); 
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

	public static class MetricContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public TerminalNode SET() { return getToken(iAgreeParser.SET, 0); }
		public TerminalNode NATURAL() { return getToken(iAgreeParser.NATURAL, 0); }
		public TerminalNode ENUM() { return getToken(iAgreeParser.ENUM, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public TerminalNode FLOAT() { return getToken(iAgreeParser.FLOAT, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(iAgreeParser.NUMBER, 0); }
		public TerminalNode INTEGER() { return getToken(iAgreeParser.INTEGER, 0); }
		public MetricContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metric; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitMetric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetricContext metric() throws RecognitionException {
		MetricContext _localctx = new MetricContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_metric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); ((MetricContext)_localctx).id = match(Identifier);
			setState(217); match(2);
			setState(229);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(218); ((MetricContext)_localctx).type = match(SET);
				setState(219); list();
				}
				break;
			case ENUM:
				{
				setState(220); ((MetricContext)_localctx).type = match(ENUM);
				setState(221); list();
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
				{
				setState(222);
				((MetricContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((MetricContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(224);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(223); range();
					}
				}

				setState(227);
				_la = _input.LA(1);
				if (_la==LLA) {
					{
					setState(226); list();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DatePeriod_defContext extends ParserRuleContext {
		public TerminalNode DURING() { return getToken(iAgreeParser.DURING, 0); }
		public List<TerminalNode> Date() { return getTokens(iAgreeParser.Date); }
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
		enterRule(_localctx, 38, RULE_datePeriod_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(DURING);
			setState(232); match(Date);
			setState(233); match(4);
			setState(234); match(Date);
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
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
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
		enterRule(_localctx, 40, RULE_temporality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(ON);
			setState(237); match(Identifier);
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
		public List<TerminalNode> EXCEPT() { return getTokens(iAgreeParser.EXCEPT); }
		public TerminalNode EXCEPT(int i) {
			return getToken(iAgreeParser.EXCEPT, i);
		}
		public List<TerminalNode> AND() { return getTokens(iAgreeParser.AND); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public List<Period_defContext> period_def() {
			return getRuleContexts(Period_defContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(iAgreeParser.AND, i);
		}
		public Period_defContext period_def(int i) {
			return getRuleContext(Period_defContext.class,i);
		}
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
		enterRule(_localctx, 42, RULE_period);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(Identifier);
			setState(240); match(2);
			setState(241); period_def();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==AND) {
				{
				{
				setState(242);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(243); period_def();
				}
				}
				setState(248);
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
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public DatePeriod_defContext datePeriod_def() {
			return getRuleContext(DatePeriod_defContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode Hour(int i) {
			return getToken(iAgreeParser.Hour, i);
		}
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
		public TerminalNode FROM() { return getToken(iAgreeParser.FROM, 0); }
		public List<TerminalNode> Hour() { return getTokens(iAgreeParser.Hour); }
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
		enterRule(_localctx, 44, RULE_period_def);
		int _la;
		try {
			setState(260);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(249); match(FROM);
				setState(250); match(Hour);
				setState(251); match(4);
				setState(252); match(Hour);
				setState(255);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(253); match(ON);
					setState(254); match(Identifier);
					}
				}

				setState(257); datePeriod_def();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(258); match(Identifier);
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(259); match(GLOBALPERIOD);
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
		public GlobalDescriptionContext globalDescription() {
			return getRuleContext(GlobalDescriptionContext.class,0);
		}
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode SERVICE() { return getToken(iAgreeParser.SERVICE, 0); }
		public TerminalNode AVAL_AT() { return getToken(iAgreeParser.AVAL_AT, 0); }
		public List<LocalDescriptionContext> localDescription() {
			return getRuleContexts(LocalDescriptionContext.class);
		}
		public LocalDescriptionContext localDescription(int i) {
			return getRuleContext(LocalDescriptionContext.class,i);
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
		enterRule(_localctx, 46, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(SERVICE);
			setState(263); match(Identifier);
			setState(266);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(264); match(AVAL_AT);
				setState(265); url();
				}
			}

			setState(269);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(268); features();
				}
			}

			setState(271); globalDescription();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(272); localDescription();
				}
				}
				setState(277);
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

	public static class FeaturesContext extends ParserRuleContext {
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public TerminalNode FEATURES() { return getToken(iAgreeParser.FEATURES, 0); }
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
		enterRule(_localctx, 48, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278); match(FEATURES);
			setState(279); match(2);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(280); feature();
				}
				}
				setState(285);
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
		public Feature_operationContext feature_operation(int i) {
			return getRuleContext(Feature_operationContext.class,i);
		}
		public List<Feature_operationContext> feature_operation() {
			return getRuleContexts(Feature_operationContext.class);
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
		enterRule(_localctx, 50, RULE_feature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); feature_operation();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(287); match(1);
				setState(288); feature_operation();
				}
				}
				setState(293);
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

	public static class Feature_operationContext extends ParserRuleContext {
		public Token id;
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public Feature_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_operation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitFeature_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Feature_operationContext feature_operation() throws RecognitionException {
		Feature_operationContext _localctx = new Feature_operationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_feature_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); ((Feature_operationContext)_localctx).id = match(Identifier);
			setState(305);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(295); match(PA);
				setState(296); match(Identifier);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(297); match(1);
					setState(298); match(Identifier);
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(304); match(PC);
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

	public static class GlobalDescriptionContext extends ParserRuleContext {
		public TerminalNode GLOBALDESCRIPTION() { return getToken(iAgreeParser.GLOBALDESCRIPTION, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
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
		enterRule(_localctx, 54, RULE_globalDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(GLOBALDESCRIPTION);
			setState(309); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(308); property();
				}
				}
				setState(311); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier || _la==Access );
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

	public static class LocalDescriptionContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public TerminalNode DESCRIPTION() { return getToken(iAgreeParser.DESCRIPTION, 0); }
		public LocalDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDescription; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitLocalDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDescriptionContext localDescription() throws RecognitionException {
		LocalDescriptionContext _localctx = new LocalDescriptionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_localDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(DESCRIPTION);
			setState(314); match(FOR);
			setState(315); match(Identifier);
			setState(316); match(2);
			setState(318); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(317); property();
				}
				}
				setState(320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier || _la==Access );
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
		public Local_MonitorablePropertiesContext local_MonitorableProperties(int i) {
			return getRuleContext(Local_MonitorablePropertiesContext.class,i);
		}
		public Global_MonitorablePropertiesContext global_MonitorableProperties() {
			return getRuleContext(Global_MonitorablePropertiesContext.class,0);
		}
		public TerminalNode MONITORABLEPROPERTIES() { return getToken(iAgreeParser.MONITORABLEPROPERTIES, 0); }
		public List<Local_MonitorablePropertiesContext> local_MonitorableProperties() {
			return getRuleContexts(Local_MonitorablePropertiesContext.class);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
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
		enterRule(_localctx, 58, RULE_monitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(MONITORABLEPROPERTIES);
			setState(324);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(323); match(Identifier);
				}
			}

			setState(327);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(326); global_MonitorableProperties();
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(329); local_MonitorableProperties();
				}
				}
				setState(334);
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
		public TerminalNode GLOBAL() { return getToken(iAgreeParser.GLOBAL, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
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
		enterRule(_localctx, 60, RULE_global_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335); match(GLOBAL);
			setState(336); match(2);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier || _la==Access) {
				{
				{
				setState(337); property();
				}
				}
				setState(342);
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
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
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
		enterRule(_localctx, 62, RULE_local_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); match(FOR);
			setState(344); match(Identifier);
			setState(345); match(2);
			setState(347); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(346); property();
				}
				}
				setState(349); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier || _la==Access );
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
		public List<GuaranteeTermContext> guaranteeTerm() {
			return getRuleContexts(GuaranteeTermContext.class);
		}
		public TerminalNode GUARANTEE_TERMS() { return getToken(iAgreeParser.GUARANTEE_TERMS, 0); }
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
		enterRule(_localctx, 64, RULE_guaranteeTerms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351); match(GUARANTEE_TERMS);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(352); guaranteeTerm();
				}
				}
				setState(357);
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
		public CuantifContext cuantif() {
			return getRuleContext(CuantifContext.class,0);
		}
		public GuaranteeTermContext guaranteeTerm(int i) {
			return getRuleContext(GuaranteeTermContext.class,i);
		}
		public List<GuaranteeTermContext> guaranteeTerm() {
			return getRuleContexts(GuaranteeTermContext.class);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
		public Guarantee_defContext guarantee_def() {
			return getRuleContext(Guarantee_defContext.class,0);
		}
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
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
		enterRule(_localctx, 66, RULE_guaranteeTerm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358); match(Identifier);
			setState(359); match(2);
			setState(368);
			switch (_input.LA(1)) {
			case PROVIDER:
			case CONSUMER:
				{
				setState(360); guarantee_def();
				}
				break;
			case EXACTLY_ONE:
			case ONE_OR_MORE:
			case ALL:
				{
				setState(361); cuantif();
				setState(362); match(OF);
				setState(364); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(363); guaranteeTerm();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(366); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(371);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(370); match(END);
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

	public static class Guarantee_defContext extends ParserRuleContext {
		public Token ob;
		public List<CompensationsContext> compensations() {
			return getRuleContexts(CompensationsContext.class);
		}
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public SloContext slo() {
			return getRuleContext(SloContext.class,0);
		}
		public CompensationsContext compensations(int i) {
			return getRuleContext(CompensationsContext.class,i);
		}
		public TerminalNode GUARANTEES() { return getToken(iAgreeParser.GUARANTEES, 0); }
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
		}
		public ServiceScopeContext serviceScope() {
			return getRuleContext(ServiceScopeContext.class,0);
		}
		public TemporalityContext temporality() {
			return getRuleContext(TemporalityContext.class,0);
		}
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
		enterRule(_localctx, 68, RULE_guarantee_def);
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

			setState(379); match(3);
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
		enterRule(_localctx, 70, RULE_slo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); expression(0);
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
		enterRule(_localctx, 72, RULE_serviceScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394); match(UPON);
			setState(395); match(Identifier);
			setState(396); match(3);
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
		enterRule(_localctx, 74, RULE_qualifyingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); match(ONLY_IF);
			setState(399); match(PA);
			setState(400); expression(0);
			setState(401); match(PC);
			setState(402); match(3);
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
		public CompensationsIntervalContext compensationsInterval() {
			return getRuleContext(CompensationsIntervalContext.class,0);
		}
		public TerminalNode PENALTY() { return getToken(iAgreeParser.PENALTY, 0); }
		public TerminalNode WITH() { return getToken(iAgreeParser.WITH, 0); }
		public List<CompensationContext> compensation() {
			return getRuleContexts(CompensationContext.class);
		}
		public CompensationContext compensation(int i) {
			return getRuleContext(CompensationContext.class,i);
		}
		public TerminalNode REWARD() { return getToken(iAgreeParser.REWARD, 0); }
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
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
		enterRule(_localctx, 76, RULE_compensations);
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
		public TerminalNode MONTHLY() { return getToken(iAgreeParser.MONTHLY, 0); }
		public TerminalNode DAILY() { return getToken(iAgreeParser.DAILY, 0); }
		public TerminalNode MINUTELY() { return getToken(iAgreeParser.MINUTELY, 0); }
		public TerminalNode HOURLY() { return getToken(iAgreeParser.HOURLY, 0); }
		public TerminalNode WEEKLY() { return getToken(iAgreeParser.WEEKLY, 0); }
		public TerminalNode YEARLY() { return getToken(iAgreeParser.YEARLY, 0); }
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
		enterRule(_localctx, 78, RULE_compensationsInterval);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IF() { return getToken(iAgreeParser.IF, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
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
		enterRule(_localctx, 80, RULE_compensation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416); match(OF);
			setState(417); ((CompensationContext)_localctx).e1 = expression(0);
			setState(418); match(IF);
			setState(419); ((CompensationContext)_localctx).e2 = expression(0);
			setState(420); match(3);
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
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode Version() { return getToken(iAgreeParser.Version, 0); }
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
		enterRule(_localctx, 82, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
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
		enterRule(_localctx, 84, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
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

	public static class PropertyContext extends ParserRuleContext {
		public Token id;
		public Token met;
		public ExpressionContext value;
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIG() { return getToken(iAgreeParser.ASSIG, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			((PropertyContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==Access) ) {
				((PropertyContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(427); match(2);
			setState(428);
			((PropertyContext)_localctx).met = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==Identifier) ) {
				((PropertyContext)_localctx).met = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(433);
			_la = _input.LA(1);
			if (_la==ASSIG) {
				{
				setState(429); match(ASSIG);
				setState(430); ((PropertyContext)_localctx).value = expression(0);
				setState(431); match(3);
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

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class AssigExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIG() { return getToken(iAgreeParser.ASSIG, 0); }
		public AssigExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAssigExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(iAgreeParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(iAgreeParser.PC, 0); }
		public ParExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(iAgreeParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTE() { return getToken(iAgreeParser.GTE, 0); }
		public TerminalNode LT() { return getToken(iAgreeParser.LT, 0); }
		public TerminalNode LTE() { return getToken(iAgreeParser.LTE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode GT() { return getToken(iAgreeParser.GT, 0); }
		public RelationalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SUBTRACT() { return getToken(iAgreeParser.SUBTRACT, 0); }
		public TerminalNode ADD() { return getToken(iAgreeParser.ADD, 0); }
		public AdditiveExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExprContext extends ExpressionContext {
		public Token op;
		public TerminalNode NEQ() { return getToken(iAgreeParser.NEQ, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQ() { return getToken(iAgreeParser.EQ, 0); }
		public EqualityExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(iAgreeParser.MULTIPLY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode DIVIDE() { return getToken(iAgreeParser.DIVIDE, 0); }
		public MultiplicationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(iAgreeParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(iAgreeParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				_localctx = new AssigExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(436); match(Identifier);
				setState(437); match(ASSIG);
				setState(438); expression(10);
				}
				break;

			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(439); match(NOT);
				setState(440); expression(9);
				}
				break;

			case 3:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(441); match(PA);
				setState(442); expression(0);
				setState(443); match(PC);
				}
				break;

			case 4:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(445); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(468);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(466);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(448);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(449);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(450); expression(9);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(451);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(452);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(453); expression(8);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(454);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(455);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LT - 73)) | (1L << (GT - 73)) | (1L << (LTE - 73)) | (1L << (GTE - 73)))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(456); expression(7);
						}
						break;

					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(457);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(458);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(459); expression(6);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(460);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(461); match(AND);
						setState(462); expression(5);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(463);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(464); match(OR);
						setState(465); expression(4);
						}
						break;
					}
					} 
				}
				setState(470);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitNumberAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(iAgreeParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(iAgreeParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_atom);
		int _la;
		try {
			setState(475);
			switch (_input.LA(1)) {
			case Integer:
			case S_Integer:
			case Float:
			case S_Float:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(471);
				_la = _input.LA(1);
				if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (Integer - 87)) | (1L << (S_Integer - 87)) | (1L << (Float - 87)) | (1L << (S_Float - 87)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case Identifier:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(473); match(Identifier);
				}
				break;
			case String:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(474); match(String);
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

	public static class CuantifContext extends ParserRuleContext {
		public TerminalNode ONE_OR_MORE() { return getToken(iAgreeParser.ONE_OR_MORE, 0); }
		public TerminalNode ALL() { return getToken(iAgreeParser.ALL, 0); }
		public TerminalNode EXACTLY_ONE() { return getToken(iAgreeParser.EXACTLY_ONE, 0); }
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
		enterRule(_localctx, 92, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
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
		enterRule(_localctx, 94, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479); match(LLA);
			setState(480); ((ListContext)_localctx).l1 = listArg();
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(481); match(1);
				setState(482); ((ListContext)_localctx).l2 = listArg();
				}
				}
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(488); match(LLC);
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
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
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
		enterRule(_localctx, 96, RULE_listArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			((ListArgContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (Identifier - 86)) | (1L << (Integer - 86)) | (1L << (S_Integer - 86)) | (1L << (Float - 86)) | (1L << (S_Float - 86)) | (1L << (String - 86)))) != 0)) ) {
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
		public List<TerminalNode> Integer() { return getTokens(iAgreeParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(iAgreeParser.Integer, i);
		}
		public List<TerminalNode> S_Integer() { return getTokens(iAgreeParser.S_Integer); }
		public TerminalNode S_Integer(int i) {
			return getToken(iAgreeParser.S_Integer, i);
		}
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
		enterRule(_localctx, 98, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492); match(CA);
			setState(493);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(494); match(4);
			setState(495);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(496); match(CC);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 44: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 8 >= _localctx._p;

		case 1: return 7 >= _localctx._p;

		case 2: return 6 >= _localctx._p;

		case 3: return 5 >= _localctx._p;

		case 4: return 4 >= _localctx._p;

		case 5: return 3 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3g\u01f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2m\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\3\4\3\5\7\5\u0083\n\5\f\5\16\5\u0086\13"+
		"\5\3\5\3\5\5\5\u008a\n\5\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009d\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\6\t\u00a6\n\t\r\t\16\t\u00a7\3\n\3\n\3\n\3\n\3\n\5\n\u00af\n"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\6\22\u00d0\n\22\r\22\16\22\u00d1\3\23\3\23\3\23\6\23\u00d7"+
		"\n\23\r\23\16\23\u00d8\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e3"+
		"\n\24\3\24\5\24\u00e6\n\24\5\24\u00e8\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u00f7\n\27\f\27\16\27\u00fa"+
		"\13\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0102\n\30\3\30\3\30\3\30\5"+
		"\30\u0107\n\30\3\31\3\31\3\31\3\31\5\31\u010d\n\31\3\31\5\31\u0110\n\31"+
		"\3\31\3\31\7\31\u0114\n\31\f\31\16\31\u0117\13\31\3\32\3\32\3\32\7\32"+
		"\u011c\n\32\f\32\16\32\u011f\13\32\3\33\3\33\3\33\7\33\u0124\n\33\f\33"+
		"\16\33\u0127\13\33\3\34\3\34\3\34\3\34\3\34\7\34\u012e\n\34\f\34\16\34"+
		"\u0131\13\34\3\34\5\34\u0134\n\34\3\35\3\35\6\35\u0138\n\35\r\35\16\35"+
		"\u0139\3\36\3\36\3\36\3\36\3\36\6\36\u0141\n\36\r\36\16\36\u0142\3\37"+
		"\3\37\5\37\u0147\n\37\3\37\5\37\u014a\n\37\3\37\7\37\u014d\n\37\f\37\16"+
		"\37\u0150\13\37\3 \3 \3 \7 \u0155\n \f \16 \u0158\13 \3!\3!\3!\3!\6!\u015e"+
		"\n!\r!\16!\u015f\3\"\3\"\7\"\u0164\n\"\f\"\16\"\u0167\13\"\3#\3#\3#\3"+
		"#\3#\3#\6#\u016f\n#\r#\16#\u0170\5#\u0173\n#\3#\5#\u0176\n#\3$\3$\3$\3"+
		"$\5$\u017c\n$\3$\3$\5$\u0180\n$\3$\5$\u0183\n$\3$\7$\u0186\n$\f$\16$\u0189"+
		"\13$\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\6(\u019b\n"+
		"(\r(\16(\u019c\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3"+
		"-\3-\3-\5-\u01b4\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u01c1\n.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u01d5\n.\f.\16.\u01d8"+
		"\13.\3/\3/\3/\3/\5/\u01de\n/\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u01e6"+
		"\n\61\f\61\16\61\u01e9\13\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\2\64\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\25\4\2\37 XX\3\2YZ\3\2$(\4\2\"\"C"+
		"C\3\2\37 \3\2\66\67\3\2\60\65\4\2[[__\4\2^^dd\4\2XXbb\4\2$$XX\3\2ST\3"+
		"\2QR\4\2KLOP\3\2MN\3\2Y\\\3\2+,\3\2HJ\4\2X\\dd\u0200\2l\3\2\2\2\4n\3\2"+
		"\2\2\6t\3\2\2\2\b\u0084\3\2\2\2\n\u008e\3\2\2\2\f\u009c\3\2\2\2\16\u009e"+
		"\3\2\2\2\20\u00a3\3\2\2\2\22\u00a9\3\2\2\2\24\u00b0\3\2\2\2\26\u00b4\3"+
		"\2\2\2\30\u00b8\3\2\2\2\32\u00bc\3\2\2\2\34\u00c0\3\2\2\2\36\u00c4\3\2"+
		"\2\2 \u00c8\3\2\2\2\"\u00cc\3\2\2\2$\u00d3\3\2\2\2&\u00da\3\2\2\2(\u00e9"+
		"\3\2\2\2*\u00ee\3\2\2\2,\u00f1\3\2\2\2.\u0106\3\2\2\2\60\u0108\3\2\2\2"+
		"\62\u0118\3\2\2\2\64\u0120\3\2\2\2\66\u0128\3\2\2\28\u0135\3\2\2\2:\u013b"+
		"\3\2\2\2<\u0144\3\2\2\2>\u0151\3\2\2\2@\u0159\3\2\2\2B\u0161\3\2\2\2D"+
		"\u0168\3\2\2\2F\u0177\3\2\2\2H\u018a\3\2\2\2J\u018c\3\2\2\2L\u0190\3\2"+
		"\2\2N\u0196\3\2\2\2P\u01a0\3\2\2\2R\u01a2\3\2\2\2T\u01a8\3\2\2\2V\u01aa"+
		"\3\2\2\2X\u01ac\3\2\2\2Z\u01c0\3\2\2\2\\\u01dd\3\2\2\2^\u01df\3\2\2\2"+
		"`\u01e1\3\2\2\2b\u01ec\3\2\2\2d\u01ee\3\2\2\2fg\5\4\3\2gh\7\b\2\2hm\3"+
		"\2\2\2ij\5\6\4\2jk\7\n\2\2km\3\2\2\2lf\3\2\2\2li\3\2\2\2m\3\3\2\2\2no"+
		"\7\7\2\2op\7X\2\2pq\7!\2\2qr\5T+\2rs\5\b\5\2s\5\3\2\2\2tu\7\t\2\2uv\7"+
		"X\2\2vw\7!\2\2wx\5T+\2xz\7;\2\2y{\7\7\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2"+
		"\2|}\7X\2\2}~\7!\2\2~\177\5T+\2\177\u0080\5\n\6\2\u0080\7\3\2\2\2\u0081"+
		"\u0083\5\f\7\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\5\16\b\2\u0088\u008a\5\20\t\2\u0089\u0088\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\t\3\2\2\2\u008b\u008d\5\f\7\2\u008c\u008b\3\2\2\2\u008d\u0090"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\5\16\b\2\u0092\13\3\2\2\2\u0093\u009d\5\24"+
		"\13\2\u0094\u009d\5\26\f\2\u0095\u009d\5\30\r\2\u0096\u009d\5\32\16\2"+
		"\u0097\u009d\5\34\17\2\u0098\u009d\5\36\20\2\u0099\u009d\5 \21\2\u009a"+
		"\u009d\5\"\22\2\u009b\u009d\5$\23\2\u009c\u0093\3\2\2\2\u009c\u0094\3"+
		"\2\2\2\u009c\u0095\3\2\2\2\u009c\u0096\3\2\2\2\u009c\u0097\3\2\2\2\u009c"+
		"\u0098\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2"+
		"\2\2\u009d\r\3\2\2\2\u009e\u009f\7\24\2\2\u009f\u00a0\5\60\31\2\u00a0"+
		"\u00a1\5<\37\2\u00a1\u00a2\5B\"\2\u00a2\17\3\2\2\2\u00a3\u00a5\7\25\2"+
		"\2\u00a4\u00a6\5\22\n\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\21\3\2\2\2\u00a9\u00aa\7X\2\2"+
		"\u00aa\u00ab\7\4\2\2\u00ab\u00ac\5Z.\2\u00ac\u00ae\7\5\2\2\u00ad\u00af"+
		"\5L\'\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\23\3\2\2\2\u00b0"+
		"\u00b1\7\13\2\2\u00b1\u00b2\7\4\2\2\u00b2\u00b3\7d\2\2\u00b3\25\3\2\2"+
		"\2\u00b4\u00b5\t\2\2\2\u00b5\u00b6\7<\2\2\u00b6\u00b7\7\f\2\2\u00b7\27"+
		"\3\2\2\2\u00b8\u00b9\7\r\2\2\u00b9\u00ba\7\4\2\2\u00ba\u00bb\7d\2\2\u00bb"+
		"\31\3\2\2\2\u00bc\u00bd\7\16\2\2\u00bd\u00be\7\4\2\2\u00be\u00bf\7d\2"+
		"\2\u00bf\33\3\2\2\2\u00c0\u00c1\7\17\2\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3"+
		"\7d\2\2\u00c3\35\3\2\2\2\u00c4\u00c5\7\20\2\2\u00c5\u00c6\7\4\2\2\u00c6"+
		"\u00c7\t\3\2\2\u00c7\37\3\2\2\2\u00c8\u00c9\7\21\2\2\u00c9\u00ca\7\4\2"+
		"\2\u00ca\u00cb\5(\25\2\u00cb!\3\2\2\2\u00cc\u00cd\7\22\2\2\u00cd\u00cf"+
		"\7\4\2\2\u00ce\u00d0\5,\27\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2#\3\2\2\2\u00d3\u00d4\7\23\2\2"+
		"\u00d4\u00d6\7\4\2\2\u00d5\u00d7\5&\24\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9%\3\2\2\2\u00da"+
		"\u00db\7X\2\2\u00db\u00e7\7\4\2\2\u00dc\u00dd\7)\2\2\u00dd\u00e8\5`\61"+
		"\2\u00de\u00df\7*\2\2\u00df\u00e8\5`\61\2\u00e0\u00e2\t\4\2\2\u00e1\u00e3"+
		"\5d\63\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e6\5`\61\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2"+
		"\2\2\u00e7\u00dc\3\2\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e0\3\2\2\2\u00e8"+
		"\'\3\2\2\2\u00e9\u00ea\7#\2\2\u00ea\u00eb\7`\2\2\u00eb\u00ec\7\6\2\2\u00ec"+
		"\u00ed\7`\2\2\u00ed)\3\2\2\2\u00ee\u00ef\78\2\2\u00ef\u00f0\7X\2\2\u00f0"+
		"+\3\2\2\2\u00f1\u00f2\7X\2\2\u00f2\u00f3\7\4\2\2\u00f3\u00f8\5.\30\2\u00f4"+
		"\u00f5\t\5\2\2\u00f5\u00f7\5.\30\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9-\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fb\u00fc\79\2\2\u00fc\u00fd\7a\2\2\u00fd\u00fe\7\6\2\2\u00fe"+
		"\u0101\7a\2\2\u00ff\u0100\78\2\2\u0100\u0102\7X\2\2\u0101\u00ff\3\2\2"+
		"\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0107\5(\25\2\u0104\u0107"+
		"\7X\2\2\u0105\u0107\7\21\2\2\u0106\u00fb\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0105\3\2\2\2\u0107/\3\2\2\2\u0108\u0109\7\27\2\2\u0109\u010c\7X\2\2"+
		"\u010a\u010b\7\36\2\2\u010b\u010d\5V,\2\u010c\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u0110\5\62\32\2\u010f\u010e\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0115\58\35\2\u0112\u0114"+
		"\5:\36\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\61\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7\30\2"+
		"\2\u0119\u011d\7\4\2\2\u011a\u011c\5\64\33\2\u011b\u011a\3\2\2\2\u011c"+
		"\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\63\3\2\2"+
		"\2\u011f\u011d\3\2\2\2\u0120\u0125\5\66\34\2\u0121\u0122\7\3\2\2\u0122"+
		"\u0124\5\66\34\2\u0123\u0121\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126\65\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u0133\7X\2\2\u0129\u012a\7?\2\2\u012a\u012f\7X\2\2\u012b\u012c\7\3\2"+
		"\2\u012c\u012e\7X\2\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u0134\7@\2\2\u0133\u0129\3\2\2\2\u0133\u0134\3\2\2\2\u0134\67\3\2\2\2"+
		"\u0135\u0137\7\31\2\2\u0136\u0138\5X-\2\u0137\u0136\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a9\3\2\2\2\u013b"+
		"\u013c\7\32\2\2\u013c\u013d\7;\2\2\u013d\u013e\7X\2\2\u013e\u0140\7\4"+
		"\2\2\u013f\u0141\5X-\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143;\3\2\2\2\u0144\u0146\7\34\2\2\u0145"+
		"\u0147\7X\2\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2"+
		"\2\2\u0148\u014a\5> \2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014e"+
		"\3\2\2\2\u014b\u014d\5@!\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f=\3\2\2\2\u0150\u014e\3\2\2\2"+
		"\u0151\u0152\7\33\2\2\u0152\u0156\7\4\2\2\u0153\u0155\5X-\2\u0154\u0153"+
		"\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"?\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7;\2\2\u015a\u015b\7X\2\2\u015b"+
		"\u015d\7\4\2\2\u015c\u015e\5X-\2\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2"+
		"\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160A\3\2\2\2\u0161\u0165"+
		"\7\26\2\2\u0162\u0164\5D#\2\u0163\u0162\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166C\3\2\2\2\u0167\u0165\3\2\2\2"+
		"\u0168\u0169\7X\2\2\u0169\u0172\7\4\2\2\u016a\u0173\5F$\2\u016b\u016c"+
		"\5^\60\2\u016c\u016e\7:\2\2\u016d\u016f\5D#\2\u016e\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2"+
		"\2\2\u0172\u016a\3\2\2\2\u0172\u016b\3\2\2\2\u0173\u0175\3\2\2\2\u0174"+
		"\u0176\7.\2\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176E\3\2\2\2\u0177"+
		"\u0178\t\6\2\2\u0178\u0179\7\35\2\2\u0179\u017b\5H%\2\u017a\u017c\5*\26"+
		"\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f"+
		"\7\5\2\2\u017e\u0180\5J&\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u0182\3\2\2\2\u0181\u0183\5L\'\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0187\3\2\2\2\u0184\u0186\5N(\2\u0185\u0184\3\2\2\2\u0186\u0189"+
		"\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188G\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u018a\u018b\5Z.\2\u018bI\3\2\2\2\u018c\u018d\7W\2\2\u018d"+
		"\u018e\7X\2\2\u018e\u018f\7\5\2\2\u018fK\3\2\2\2\u0190\u0191\7G\2\2\u0191"+
		"\u0192\7?\2\2\u0192\u0193\5Z.\2\u0193\u0194\7@\2\2\u0194\u0195\7\5\2\2"+
		"\u0195M\3\2\2\2\u0196\u0197\7-\2\2\u0197\u0198\5P)\2\u0198\u019a\t\7\2"+
		"\2\u0199\u019b\5R*\2\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a"+
		"\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7.\2\2\u019f"+
		"O\3\2\2\2\u01a0\u01a1\t\b\2\2\u01a1Q\3\2\2\2\u01a2\u01a3\7:\2\2\u01a3"+
		"\u01a4\5Z.\2\u01a4\u01a5\7/\2\2\u01a5\u01a6\5Z.\2\u01a6\u01a7\7\5\2\2"+
		"\u01a7S\3\2\2\2\u01a8\u01a9\t\t\2\2\u01a9U\3\2\2\2\u01aa\u01ab\t\n\2\2"+
		"\u01abW\3\2\2\2\u01ac\u01ad\t\13\2\2\u01ad\u01ae\7\4\2\2\u01ae\u01b3\t"+
		"\f\2\2\u01af\u01b0\7U\2\2\u01b0\u01b1\5Z.\2\u01b1\u01b2\7\5\2\2\u01b2"+
		"\u01b4\3\2\2\2\u01b3\u01af\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4Y\3\2\2\2"+
		"\u01b5\u01b6\b.\1\2\u01b6\u01b7\7X\2\2\u01b7\u01b8\7U\2\2\u01b8\u01c1"+
		"\5Z.\2\u01b9\u01ba\7E\2\2\u01ba\u01c1\5Z.\2\u01bb\u01bc\7?\2\2\u01bc\u01bd"+
		"\5Z.\2\u01bd\u01be\7@\2\2\u01be\u01c1\3\2\2\2\u01bf\u01c1\5\\/\2\u01c0"+
		"\u01b5\3\2\2\2\u01c0\u01b9\3\2\2\2\u01c0\u01bb\3\2\2\2\u01c0\u01bf\3\2"+
		"\2\2\u01c1\u01d6\3\2\2\2\u01c2\u01c3\6.\2\3\u01c3\u01c4\t\r\2\2\u01c4"+
		"\u01d5\5Z.\2\u01c5\u01c6\6.\3\3\u01c6\u01c7\t\16\2\2\u01c7\u01d5\5Z.\2"+
		"\u01c8\u01c9\6.\4\3\u01c9\u01ca\t\17\2\2\u01ca\u01d5\5Z.\2\u01cb\u01cc"+
		"\6.\5\3\u01cc\u01cd\t\20\2\2\u01cd\u01d5\5Z.\2\u01ce\u01cf\6.\6\3\u01cf"+
		"\u01d0\7C\2\2\u01d0\u01d5\5Z.\2\u01d1\u01d2\6.\7\3\u01d2\u01d3\7D\2\2"+
		"\u01d3\u01d5\5Z.\2\u01d4\u01c2\3\2\2\2\u01d4\u01c5\3\2\2\2\u01d4\u01c8"+
		"\3\2\2\2\u01d4\u01cb\3\2\2\2\u01d4\u01ce\3\2\2\2\u01d4\u01d1\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7[\3\2\2\2"+
		"\u01d8\u01d6\3\2\2\2\u01d9\u01de\t\21\2\2\u01da\u01de\t\22\2\2\u01db\u01de"+
		"\7X\2\2\u01dc\u01de\7d\2\2\u01dd\u01d9\3\2\2\2\u01dd\u01da\3\2\2\2\u01dd"+
		"\u01db\3\2\2\2\u01dd\u01dc\3\2\2\2\u01de]\3\2\2\2\u01df\u01e0\t\23\2\2"+
		"\u01e0_\3\2\2\2\u01e1\u01e2\7A\2\2\u01e2\u01e7\5b\62\2\u01e3\u01e4\7\3"+
		"\2\2\u01e4\u01e6\5b\62\2\u01e5\u01e3\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7"+
		"\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e7\3\2"+
		"\2\2\u01ea\u01eb\7B\2\2\u01eba\3\2\2\2\u01ec\u01ed\t\24\2\2\u01edc\3\2"+
		"\2\2\u01ee\u01ef\7=\2\2\u01ef\u01f0\t\3\2\2\u01f0\u01f1\7\6\2\2\u01f1"+
		"\u01f2\t\3\2\2\u01f2\u01f3\7>\2\2\u01f3e\3\2\2\2/lz\u0084\u0089\u008e"+
		"\u009c\u00a7\u00ae\u00d1\u00d8\u00e2\u00e5\u00e7\u00f8\u0101\u0106\u010c"+
		"\u010f\u0115\u011d\u0125\u012f\u0133\u0139\u0142\u0146\u0149\u014e\u0156"+
		"\u015f\u0165\u0170\u0172\u0175\u017b\u017f\u0182\u0187\u019c\u01b3\u01c0"+
		"\u01d4\u01d6\u01dd\u01e7";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}