// Generated from C:\Users\ISA Group\Desktop\Parsers\iAgree-parser\iAgree\iAgree.g4 by ANTLR 4.1
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
		END_AG_OFFER=8, AGREEMENT=9, END_AGREEMENT=10, INITIATOR=11, RESPONDER=12, 
		SERVICEPROVIDER=13, EXPIRATIONTIME=14, DATEFORMAT=15, GMTZONE=16, GLOBALPERIOD=17, 
		DEFINEDPERIOD=18, METRICS=19, AGREEMENT_TERMS=20, CREATION_CONSTRAINTS=21, 
		GUARANTEE_TERMS=22, SERVICE=23, FEATURES=24, GLOBALDESCRIPTION=25, DESCRIPTION=26, 
		GLOBAL=27, MONITORABLEPROPERTIES=28, GUARANTEES=29, AVAL_AT=30, DEFINED_AT=31, 
		MONITORED_AT=32, PROVIDER=33, CONSUMER=34, VERSION=35, EXCEPT=36, DURING=37, 
		STRING=38, BOOLEAN=39, INTEGER=40, FLOAT=41, NATURAL=42, NUMBER=43, SET=44, 
		ENUM=45, TRUE=46, FALSE=47, WITH=48, END=49, IF=50, ONLY_IF=51, YEARLY=52, 
		MONTHLY=53, WEEKLY=54, DAILY=55, HOURLY=56, MINUTELY=57, SECONDLY=58, 
		YEAR=59, MONTH=60, WEEK=61, DAY=62, HOUR=63, MINUTE=64, SECOND=65, PENALTY=66, 
		REWARD=67, CREATED=68, ON=69, FROM=70, OF=71, FOR=72, AS=73, UPTO=74, 
		IN=75, BY=76, RESOURCE=77, CA=78, CC=79, PA=80, PC=81, LLA=82, LLC=83, 
		EXACTLY_ONE=84, ONE_OR_MORE=85, ALL=86, AND=87, OR=88, NOT=89, IMPLIES=90, 
		REQUIRES=91, IFF=92, EXCLUDES=93, ADD=94, SUBTRACT=95, MULTIPLY=96, DIVIDE=97, 
		LT=98, GT=99, EQ=100, NEQ=101, LTE=102, GTE=103, ASSIG=104, BELONGS=105, 
		UPON=106, Identifier=107, Integer=108, S_Integer=109, Float=110, S_Float=111, 
		Boolean=112, Url=113, Version=114, Date=115, Hour=116, Access=117, Unit=118, 
		String=119, WS=120, COMMENT=121, LINE_COMMENT=122;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "':'", "';'", "'..'", "'Template'", "'EndTemplate'", 
		"'AgreementOffer'", "'EndAgreementOffer'", "'Agreement'", "'EndAgreement'", 
		"'Initiator'", "'Responder'", "'ServiceProvider'", "'ExpirationTime'", 
		"'DateFormat'", "'GMTZone'", "'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", 
		"'AgreementTerms'", "'CreationConstraints'", "'GuaranteeTerms'", "'Service'", 
		"'Features'", "'GlobalDescription'", "'Description'", "'global'", "'MonitorableProperties'", 
		"'guarantees'", "'availableAt'", "'definedAt'", "'monitoredAt'", "'Provider'", 
		"'Consumer'", "'version'", "'except'", "'during'", "'string'", "'boolean'", 
		"'integer'", "'float'", "'natural'", "'number'", "'set'", "'enum'", "'true'", 
		"'false'", "'with'", "'end'", "'if'", "'onlyIf'", "'yearly'", "'monthly'", 
		"'weekly'", "'daily'", "'hourly'", "'minutely'", "'secondly'", "YEAR", 
		"MONTH", "WEEK", "DAY", "HOUR", "MINUTE", "SECOND", "'penalty'", "'reward'", 
		"'Created'", "'on'", "'from'", "'of'", "'for'", "'as'", "'upTo'", "'in'", 
		"'by'", "'resource'", "'['", "']'", "'('", "')'", "'{'", "'}'", "'exactly one'", 
		"'one or more'", "'all'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'REQUIRES'", 
		"'IFF'", "'EXCLUDES'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", 
		"'!='", "'<='", "'>='", "'='", "'belongs'", "'upon'", "Identifier", "Integer", 
		"S_Integer", "Float", "S_Float", "Boolean", "Url", "Version", "Date", 
		"Hour", "Access", "Unit", "String", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_entry = 0, RULE_template = 1, RULE_agOffer = 2, RULE_agreement = 3, 
		RULE_template_def = 4, RULE_ag_def = 5, RULE_temp_properties = 6, RULE_agreementTerms = 7, 
		RULE_creationConstraints = 8, RULE_creationConstraint = 9, RULE_context_prop = 10, 
		RULE_partiesRoles_prop = 11, RULE_metrics_prop = 12, RULE_metric = 13, 
		RULE_service = 14, RULE_features = 15, RULE_feature = 16, RULE_feature_operation = 17, 
		RULE_globalDescription = 18, RULE_localDescription = 19, RULE_monitorableProperties = 20, 
		RULE_global_MonitorableProperties = 21, RULE_local_MonitorableProperties = 22, 
		RULE_property = 23, RULE_guaranteeTerms = 24, RULE_guaranteeTerm = 25, 
		RULE_guarantee_def = 26, RULE_slo = 27, RULE_serviceScope = 28, RULE_qualifyingCondition = 29, 
		RULE_compensation = 30, RULE_compensationElement = 31, RULE_compensationLimit = 32, 
		RULE_compensationsInterval = 33, RULE_duringInterval = 34, RULE_versionNumber = 35, 
		RULE_url = 36, RULE_cuantif = 37, RULE_range = 38, RULE_expression = 39, 
		RULE_list = 40, RULE_array = 41, RULE_args = 42, RULE_atom = 43;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "agreement", "template_def", "ag_def", 
		"temp_properties", "agreementTerms", "creationConstraints", "creationConstraint", 
		"context_prop", "partiesRoles_prop", "metrics_prop", "metric", "service", 
		"features", "feature", "feature_operation", "globalDescription", "localDescription", 
		"monitorableProperties", "global_MonitorableProperties", "local_MonitorableProperties", 
		"property", "guaranteeTerms", "guaranteeTerm", "guarantee_def", "slo", 
		"serviceScope", "qualifyingCondition", "compensation", "compensationElement", 
		"compensationLimit", "compensationsInterval", "duringInterval", "versionNumber", 
		"url", "cuantif", "range", "expression", "list", "array", "args", "atom"
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
		public TerminalNode END_AGREEMENT() { return getToken(iAgreeParser.END_AGREEMENT, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public AgOfferContext agOffer() {
			return getRuleContext(AgOfferContext.class,0);
		}
		public AgreementContext agreement() {
			return getRuleContext(AgreementContext.class,0);
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
			setState(97);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(88); template();
				setState(89); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); agOffer();
				setState(92); match(END_AG_OFFER);
				}
				break;
			case AGREEMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(94); agreement();
				setState(95); match(END_AGREEMENT);
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
			setState(99); match(TEMPLATE);
			setState(100); ((TemplateContext)_localctx).id = match(Identifier);
			setState(101); match(VERSION);
			setState(102); ((TemplateContext)_localctx).version = versionNumber();
			setState(103); template_def();
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
			setState(105); match(AG_OFFER);
			setState(106); ((AgOfferContext)_localctx).id = match(Identifier);
			setState(107); match(VERSION);
			setState(108); ((AgOfferContext)_localctx).version = versionNumber();
			setState(109); match(FOR);
			setState(111);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(110); match(TEMPLATE);
				}
			}

			setState(113); ((AgOfferContext)_localctx).templateId = match(Identifier);
			setState(114); match(VERSION);
			setState(115); ((AgOfferContext)_localctx).templateVersion = versionNumber();
			setState(116); ag_def();
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

	public static class AgreementContext extends ParserRuleContext {
		public Token id;
		public VersionNumberContext version;
		public VersionNumberContext versionNumber() {
			return getRuleContext(VersionNumberContext.class,0);
		}
		public Ag_defContext ag_def() {
			return getRuleContext(Ag_defContext.class,0);
		}
		public TerminalNode AGREEMENT() { return getToken(iAgreeParser.AGREEMENT, 0); }
		public TerminalNode VERSION() { return getToken(iAgreeParser.VERSION, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public AgreementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agreement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitAgreement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgreementContext agreement() throws RecognitionException {
		AgreementContext _localctx = new AgreementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_agreement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(AGREEMENT);
			setState(119); ((AgreementContext)_localctx).id = match(Identifier);
			setState(120); match(VERSION);
			setState(121); ((AgreementContext)_localctx).version = versionNumber();
			setState(122); ag_def();
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
		enterRule(_localctx, 8, RULE_template_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (METRICS - 19)) | (1L << (PROVIDER - 19)) | (1L << (CONSUMER - 19)) | (1L << (CREATED - 19)))) != 0)) {
				{
				{
				setState(124); temp_properties();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130); agreementTerms();
			setState(132);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(131); creationConstraints();
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
		enterRule(_localctx, 10, RULE_ag_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (METRICS - 19)) | (1L << (PROVIDER - 19)) | (1L << (CONSUMER - 19)) | (1L << (CREATED - 19)))) != 0)) {
				{
				{
				setState(134); temp_properties();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140); agreementTerms();
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
		public Metrics_propContext metrics_prop() {
			return getRuleContext(Metrics_propContext.class,0);
		}
		public PartiesRoles_propContext partiesRoles_prop() {
			return getRuleContext(PartiesRoles_propContext.class,0);
		}
		public Context_propContext context_prop() {
			return getRuleContext(Context_propContext.class,0);
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
		enterRule(_localctx, 12, RULE_temp_properties);
		try {
			setState(145);
			switch (_input.LA(1)) {
			case CREATED:
				enterOuterAlt(_localctx, 1);
				{
				setState(142); context_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(143); partiesRoles_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 3);
				{
				setState(144); metrics_prop();
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
		enterRule(_localctx, 14, RULE_agreementTerms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(AGREEMENT_TERMS);
			setState(148); service();
			setState(150);
			_la = _input.LA(1);
			if (_la==MONITORABLEPROPERTIES) {
				{
				setState(149); monitorableProperties();
				}
			}

			setState(153);
			_la = _input.LA(1);
			if (_la==GUARANTEE_TERMS) {
				{
				setState(152); guaranteeTerms();
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
		enterRule(_localctx, 16, RULE_creationConstraints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); match(CREATION_CONSTRAINTS);
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156); creationConstraint();
				}
				}
				setState(159); 
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
		enterRule(_localctx, 18, RULE_creationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(161); match(Identifier);
			}
			setState(162); match(2);
			setState(163); expression(0);
			setState(164); match(3);
			setState(166);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(165); qualifyingCondition();
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

	public static class Context_propContext extends ParserRuleContext {
		public Token id;
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode CREATED() { return getToken(iAgreeParser.CREATED, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode AVAL_AT() { return getToken(iAgreeParser.AVAL_AT, 0); }
		public TerminalNode FROM() { return getToken(iAgreeParser.FROM, 0); }
		public Context_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitContext_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Context_propContext context_prop() throws RecognitionException {
		Context_propContext _localctx = new Context_propContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_context_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(CREATED);
			setState(169); match(FROM);
			setState(170);
			((Context_propContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==String) ) {
				((Context_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(173);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(171); match(AVAL_AT);
				setState(172); url();
				}
			}

			setState(175); match(3);
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

	public static class PartiesRoles_propContext extends ParserRuleContext {
		public Token role;
		public Token id;
		public Token roleType;
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode AS() { return getToken(iAgreeParser.AS, 0); }
		public TerminalNode RESPONDER() { return getToken(iAgreeParser.RESPONDER, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode INITIATOR() { return getToken(iAgreeParser.INITIATOR, 0); }
		public PartiesRoles_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partiesRoles_prop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitPartiesRoles_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartiesRoles_propContext partiesRoles_prop() throws RecognitionException {
		PartiesRoles_propContext _localctx = new PartiesRoles_propContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_partiesRoles_prop);
		int _la;
		try {
			setState(187);
			switch (_input.LA(1)) {
			case PROVIDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(177); ((PartiesRoles_propContext)_localctx).role = match(PROVIDER);
				setState(178);
				((PartiesRoles_propContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==String) ) {
					((PartiesRoles_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(179); match(AS);
				setState(180);
				((PartiesRoles_propContext)_localctx).roleType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INITIATOR || _la==RESPONDER) ) {
					((PartiesRoles_propContext)_localctx).roleType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(181); match(3);
				}
				break;
			case CONSUMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); ((PartiesRoles_propContext)_localctx).role = match(CONSUMER);
				setState(183);
				((PartiesRoles_propContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==String) ) {
					((PartiesRoles_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(184); match(AS);
				setState(185);
				((PartiesRoles_propContext)_localctx).roleType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INITIATOR || _la==RESPONDER) ) {
					((PartiesRoles_propContext)_localctx).roleType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(186); match(3);
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
		enterRule(_localctx, 24, RULE_metrics_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(METRICS);
			setState(190); match(2);
			setState(192); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(191); metric();
				}
				}
				setState(194); 
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
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_metric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); ((MetricContext)_localctx).id = match(Identifier);
			setState(197); match(2);
			setState(215);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(198); ((MetricContext)_localctx).type = match(SET);
				setState(201);
				switch (_input.LA(1)) {
				case CA:
					{
					setState(199); list();
					}
					break;
				case LLA:
					{
					setState(200); array();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ENUM:
				{
				setState(203); ((MetricContext)_localctx).type = match(ENUM);
				setState(206);
				switch (_input.LA(1)) {
				case CA:
					{
					setState(204); list();
					}
					break;
				case LLA:
					{
					setState(205); array();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
				{
				setState(208);
				((MetricContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((MetricContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(210);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(209); range();
					}
					break;
				}
				setState(213);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(212); list();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(217); match(3);
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
		public UrlContext endpointUrl;
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
		enterRule(_localctx, 28, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(SERVICE);
			setState(220); match(Identifier);
			setState(223);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(221); match(AVAL_AT);
				setState(222); ((ServiceContext)_localctx).endpointUrl = url();
				}
			}

			setState(226);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(225); features();
				}
			}

			setState(228); globalDescription();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(229); localDescription();
				}
				}
				setState(234);
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
		enterRule(_localctx, 30, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(FEATURES);
			setState(236); match(2);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(237); feature();
				}
				}
				setState(242);
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
		enterRule(_localctx, 32, RULE_feature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); feature_operation();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(244); match(1);
				setState(245); feature_operation();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251); match(3);
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
		enterRule(_localctx, 34, RULE_feature_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); ((Feature_operationContext)_localctx).id = match(Identifier);
			setState(264);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(254); match(PA);
				setState(255); match(Identifier);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(256); match(1);
					setState(257); match(Identifier);
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(263); match(PC);
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
		enterRule(_localctx, 36, RULE_globalDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(GLOBALDESCRIPTION);
			setState(268); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(267); property();
				}
				}
				setState(270); 
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
		enterRule(_localctx, 38, RULE_localDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(DESCRIPTION);
			setState(273); match(FOR);
			setState(274); match(Identifier);
			setState(275); match(2);
			setState(277); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276); property();
				}
				}
				setState(279); 
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
		enterRule(_localctx, 40, RULE_monitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(MONITORABLEPROPERTIES);
			setState(283);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(282); match(Identifier);
				}
			}

			setState(286);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(285); global_MonitorableProperties();
				}
			}

			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(288); local_MonitorableProperties();
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
		enterRule(_localctx, 42, RULE_global_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(GLOBAL);
			setState(295); match(2);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier || _la==Access) {
				{
				{
				setState(296); property();
				}
				}
				setState(301);
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
		enterRule(_localctx, 44, RULE_local_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); match(FOR);
			setState(303); match(Identifier);
			setState(304); match(2);
			setState(306); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(305); property();
				}
				}
				setState(308); 
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

	public static class PropertyContext extends ParserRuleContext {
		public Token id;
		public Token met;
		public UrlContext definitionUrl;
		public ExpressionContext value;
		public TerminalNode DEFINED_AT() { return getToken(iAgreeParser.DEFINED_AT, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public TerminalNode RESOURCE() { return getToken(iAgreeParser.RESOURCE, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIG() { return getToken(iAgreeParser.ASSIG, 0); }
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
		enterRule(_localctx, 46, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			((PropertyContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==Access) ) {
				((PropertyContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(311); match(2);
			setState(312);
			((PropertyContext)_localctx).met = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==BOOLEAN || _la==RESOURCE || _la==Identifier) ) {
				((PropertyContext)_localctx).met = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(315);
			_la = _input.LA(1);
			if (_la==DEFINED_AT) {
				{
				setState(313); match(DEFINED_AT);
				setState(314); ((PropertyContext)_localctx).definitionUrl = url();
				}
			}

			setState(319);
			_la = _input.LA(1);
			if (_la==ASSIG) {
				{
				setState(317); match(ASSIG);
				setState(318); ((PropertyContext)_localctx).value = expression(0);
				}
			}

			setState(321); match(3);
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
		enterRule(_localctx, 48, RULE_guaranteeTerms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); match(GUARANTEE_TERMS);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(324); guaranteeTerm();
				}
				}
				setState(329);
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
		enterRule(_localctx, 50, RULE_guaranteeTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(Identifier);
			setState(331); match(2);
			setState(332); guarantee_def();
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
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public SloContext slo() {
			return getRuleContext(SloContext.class,0);
		}
		public List<CompensationContext> compensation() {
			return getRuleContexts(CompensationContext.class);
		}
		public TerminalNode GUARANTEES() { return getToken(iAgreeParser.GUARANTEES, 0); }
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
		}
		public CompensationContext compensation(int i) {
			return getRuleContext(CompensationContext.class,i);
		}
		public ServiceScopeContext serviceScope() {
			return getRuleContext(ServiceScopeContext.class,0);
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
		enterRule(_localctx, 52, RULE_guarantee_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			((Guarantee_defContext)_localctx).ob = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
				((Guarantee_defContext)_localctx).ob = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(335); match(GUARANTEES);
			setState(336); slo();
			setState(337); match(3);
			setState(339);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(338); serviceScope();
				}
			}

			setState(342);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(341); qualifyingCondition();
				}
			}

			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(344); compensation();
				}
				}
				setState(349);
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
		enterRule(_localctx, 54, RULE_slo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); expression(0);
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
		enterRule(_localctx, 56, RULE_serviceScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352); match(UPON);
			setState(353); match(Identifier);
			setState(354); match(3);
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
		enterRule(_localctx, 58, RULE_qualifyingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356); match(ONLY_IF);
			setState(357); match(PA);
			setState(358); expression(0);
			setState(359); match(PC);
			setState(360); match(3);
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
		public CompensationsIntervalContext interv;
		public Token compType;
		public List<CompensationLimitContext> compensationLimit() {
			return getRuleContexts(CompensationLimitContext.class);
		}
		public CompensationElementContext compensationElement(int i) {
			return getRuleContext(CompensationElementContext.class,i);
		}
		public CompensationLimitContext compensationLimit(int i) {
			return getRuleContext(CompensationLimitContext.class,i);
		}
		public CompensationsIntervalContext compensationsInterval() {
			return getRuleContext(CompensationsIntervalContext.class,0);
		}
		public TerminalNode PENALTY() { return getToken(iAgreeParser.PENALTY, 0); }
		public TerminalNode WITH() { return getToken(iAgreeParser.WITH, 0); }
		public List<CompensationElementContext> compensationElement() {
			return getRuleContexts(CompensationElementContext.class);
		}
		public TerminalNode REWARD() { return getToken(iAgreeParser.REWARD, 0); }
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
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
		enterRule(_localctx, 60, RULE_compensation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362); match(WITH);
			setState(363); ((CompensationContext)_localctx).interv = compensationsInterval();
			setState(364);
			((CompensationContext)_localctx).compType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PENALTY || _la==REWARD) ) {
				((CompensationContext)_localctx).compType = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(366); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(365); compensationElement();
				}
				}
				setState(368); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OF );
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UPTO) {
				{
				{
				setState(370); compensationLimit();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376); match(END);
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

	public static class CompensationElementContext extends ParserRuleContext {
		public ExpressionContext exp;
		public ExpressionContext cond;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IF() { return getToken(iAgreeParser.IF, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CompensationElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensationElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCompensationElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompensationElementContext compensationElement() throws RecognitionException {
		CompensationElementContext _localctx = new CompensationElementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compensationElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); match(OF);
			setState(379); ((CompensationElementContext)_localctx).exp = expression(0);
			setState(380); match(IF);
			setState(381); ((CompensationElementContext)_localctx).cond = expression(0);
			setState(382); match(3);
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

	public static class CompensationLimitContext extends ParserRuleContext {
		public ExpressionContext exp;
		public TerminalNode UPTO() { return getToken(iAgreeParser.UPTO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompensationLimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensationLimit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitCompensationLimit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompensationLimitContext compensationLimit() throws RecognitionException {
		CompensationLimitContext _localctx = new CompensationLimitContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_compensationLimit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); match(UPTO);
			setState(385); ((CompensationLimitContext)_localctx).exp = expression(0);
			setState(386); match(3);
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
		public TerminalNode SECONDLY() { return getToken(iAgreeParser.SECONDLY, 0); }
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
		enterRule(_localctx, 66, RULE_compensationsInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << YEARLY) | (1L << MONTHLY) | (1L << WEEKLY) | (1L << DAILY) | (1L << HOURLY) | (1L << MINUTELY) | (1L << SECONDLY))) != 0)) ) {
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

	public static class DuringIntervalContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(iAgreeParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(iAgreeParser.MONTH, 0); }
		public TerminalNode HOUR() { return getToken(iAgreeParser.HOUR, 0); }
		public TerminalNode SECOND() { return getToken(iAgreeParser.SECOND, 0); }
		public TerminalNode DAY() { return getToken(iAgreeParser.DAY, 0); }
		public TerminalNode WEEK() { return getToken(iAgreeParser.WEEK, 0); }
		public TerminalNode MINUTE() { return getToken(iAgreeParser.MINUTE, 0); }
		public DuringIntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duringInterval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDuringInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DuringIntervalContext duringInterval() throws RecognitionException {
		DuringIntervalContext _localctx = new DuringIntervalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_duringInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (YEAR - 59)) | (1L << (MONTH - 59)) | (1L << (WEEK - 59)) | (1L << (DAY - 59)) | (1L << (HOUR - 59)) | (1L << (MINUTE - 59)) | (1L << (SECOND - 59)))) != 0)) ) {
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
		enterRule(_localctx, 70, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
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
		enterRule(_localctx, 72, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
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
		enterRule(_localctx, 74, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (EXACTLY_ONE - 84)) | (1L << (ONE_OR_MORE - 84)) | (1L << (ALL - 84)))) != 0)) ) {
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
		enterRule(_localctx, 76, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); match(CA);
			setState(399);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(400); match(4);
			setState(401);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(402); match(CC);
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
	public static class ListExprContext extends ExpressionContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitListExpr(this);
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
	public static class DuringExprContext extends ExpressionContext {
		public ExpressionContext state;
		public Token op;
		public ExpressionContext dur;
		public DuringIntervalContext durInt;
		public TerminalNode IN() { return getToken(iAgreeParser.IN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DuringIntervalContext duringInterval() {
			return getRuleContext(DuringIntervalContext.class,0);
		}
		public TerminalNode BY() { return getToken(iAgreeParser.BY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public DuringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitDuringExpr(this);
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
	public static class IffExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IFF() { return getToken(iAgreeParser.IFF, 0); }
		public IffExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitIffExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExpressionContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitArrayExpr(this);
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
	public static class FreqExprContext extends ExpressionContext {
		public ExpressionContext state;
		public Token op;
		public ExpressionContext ntimes;
		public CompensationsIntervalContext compInt;
		public TerminalNode IN() { return getToken(iAgreeParser.IN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTE() { return getToken(iAgreeParser.GTE, 0); }
		public TerminalNode LT() { return getToken(iAgreeParser.LT, 0); }
		public TerminalNode LTE() { return getToken(iAgreeParser.LTE, 0); }
		public CompensationsIntervalContext compensationsInterval() {
			return getRuleContext(CompensationsIntervalContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode GT() { return getToken(iAgreeParser.GT, 0); }
		public TerminalNode EQ() { return getToken(iAgreeParser.EQ, 0); }
		public FreqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitFreqExpr(this);
			else return visitor.visitChildren(this);
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
	public static class ExcludesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EXCLUDES() { return getToken(iAgreeParser.EXCLUDES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExcludesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitExcludesExpr(this);
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
	public static class ImpliesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REQUIRES() { return getToken(iAgreeParser.REQUIRES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IMPLIES() { return getToken(iAgreeParser.IMPLIES, 0); }
		public ImpliesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitImpliesExpr(this);
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

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				_localctx = new AssigExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(405); match(Identifier);
				setState(406); match(ASSIG);
				setState(407); expression(17);
				}
				break;

			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408); match(NOT);
				setState(409); expression(16);
				}
				break;

			case 3:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410); match(PA);
				setState(411); expression(0);
				setState(412); match(PC);
				}
				break;

			case 4:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414); list();
				}
				break;

			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(415); array();
				}
				break;

			case 6:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(460);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(420);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(421); expression(16);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(423);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(424); expression(15);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(426);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (LT - 98)) | (1L << (GT - 98)) | (1L << (LTE - 98)) | (1L << (GTE - 98)))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(427); expression(14);
						}
						break;

					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(428);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(429);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(430); expression(13);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(432); match(AND);
						setState(433); expression(12);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(434);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(435); match(OR);
						setState(436); expression(11);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(438);
						_la = _input.LA(1);
						if ( !(_la==IMPLIES || _la==REQUIRES) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(439); expression(10);
						}
						break;

					case 8:
						{
						_localctx = new IffExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(440);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(441); match(IFF);
						setState(442); expression(9);
						}
						break;

					case 9:
						{
						_localctx = new ExcludesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(444); match(EXCLUDES);
						setState(445); expression(8);
						}
						break;

					case 10:
						{
						_localctx = new DuringExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(446);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(447); match(IN);
						setState(448); ((DuringExprContext)_localctx).state = expression(0);
						setState(449); ((DuringExprContext)_localctx).op = match(BY);
						setState(450); ((DuringExprContext)_localctx).dur = expression(0);
						setState(451); ((DuringExprContext)_localctx).durInt = duringInterval();
						}
						break;

					case 11:
						{
						_localctx = new FreqExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(453);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(454); match(IN);
						setState(455); ((FreqExprContext)_localctx).state = expression(0);
						setState(456);
						((FreqExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (LT - 98)) | (1L << (GT - 98)) | (1L << (EQ - 98)) | (1L << (LTE - 98)) | (1L << (GTE - 98)))) != 0)) ) {
							((FreqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(457); ((FreqExprContext)_localctx).ntimes = expression(0);
						setState(458); ((FreqExprContext)_localctx).compInt = compensationsInterval();
						}
						break;
					}
					} 
				}
				setState(464);
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

	public static class ListContext extends ParserRuleContext {
		public ArgsContext l1;
		public ArgsContext l2;
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public TerminalNode CC() { return getToken(iAgreeParser.CC, 0); }
		public TerminalNode CA() { return getToken(iAgreeParser.CA, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
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
		enterRule(_localctx, 80, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465); match(CA);
			setState(466); ((ListContext)_localctx).l1 = args();
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(467); match(1);
				setState(468); ((ListContext)_localctx).l2 = args();
				}
				}
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(474); match(CC);
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

	public static class ArrayContext extends ParserRuleContext {
		public ArgsContext l1;
		public ArgsContext l2;
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public TerminalNode LLA() { return getToken(iAgreeParser.LLA, 0); }
		public TerminalNode LLC() { return getToken(iAgreeParser.LLC, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476); match(LLA);
			setState(477); ((ArrayContext)_localctx).l1 = args();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(478); match(1);
				setState(479); ((ArrayContext)_localctx).l2 = args();
				}
				}
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(485); match(LLC);
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

	public static class ArgsContext extends ParserRuleContext {
		public Token l1;
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			((ArgsContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Identifier - 107)) | (1L << (Integer - 107)) | (1L << (S_Integer - 107)) | (1L << (Float - 107)) | (1L << (S_Float - 107)) | (1L << (String - 107)))) != 0)) ) {
				((ArgsContext)_localctx).l1 = (Token)_errHandler.recoverInline(this);
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
	public static class ArrayAtomContext extends AtomContext {
		public Token id;
		public Token value;
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode CC() { return getToken(iAgreeParser.CC, 0); }
		public TerminalNode CA() { return getToken(iAgreeParser.CA, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ArrayAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof iAgreeVisitor ) return ((iAgreeVisitor<? extends T>)visitor).visitArrayAtom(this);
			else return visitor.visitChildren(this);
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
		enterRule(_localctx, 86, RULE_atom);
		int _la;
		try {
			setState(497);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				_la = _input.LA(1);
				if ( !(((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (Integer - 108)) | (1L << (S_Integer - 108)) | (1L << (Float - 108)) | (1L << (S_Float - 108)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 2:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 3:
				_localctx = new ArrayAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(491); ((ArrayAtomContext)_localctx).id = match(Identifier);
				setState(492); match(CA);
				setState(493); ((ArrayAtomContext)_localctx).value = match(String);
				setState(494); match(CC);
				}
				break;

			case 4:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(495); match(Identifier);
				}
				break;

			case 5:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(496); match(String);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 39: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 15 >= _localctx._p;

		case 1: return 14 >= _localctx._p;

		case 2: return 13 >= _localctx._p;

		case 3: return 12 >= _localctx._p;

		case 4: return 11 >= _localctx._p;

		case 5: return 10 >= _localctx._p;

		case 6: return 9 >= _localctx._p;

		case 7: return 8 >= _localctx._p;

		case 8: return 7 >= _localctx._p;

		case 9: return 6 >= _localctx._p;

		case 10: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3|\u01f6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2d\n\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4r\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\7\6\u0080\n\6\f\6\16\6\u0083\13\6\3\6\3\6\5\6\u0087"+
		"\n\6\3\7\7\7\u008a\n\7\f\7\16\7\u008d\13\7\3\7\3\7\3\b\3\b\3\b\5\b\u0094"+
		"\n\b\3\t\3\t\3\t\5\t\u0099\n\t\3\t\5\t\u009c\n\t\3\n\3\n\6\n\u00a0\n\n"+
		"\r\n\16\n\u00a1\3\13\3\13\3\13\3\13\3\13\5\13\u00a9\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u00b0\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00be\n\r\3\16\3\16\3\16\6\16\u00c3\n\16\r\16\16\16\u00c4\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00cc\n\17\3\17\3\17\3\17\5\17\u00d1\n\17\3\17\3"+
		"\17\5\17\u00d5\n\17\3\17\5\17\u00d8\n\17\5\17\u00da\n\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\5\20\u00e2\n\20\3\20\5\20\u00e5\n\20\3\20\3\20\7\20\u00e9"+
		"\n\20\f\20\16\20\u00ec\13\20\3\21\3\21\3\21\7\21\u00f1\n\21\f\21\16\21"+
		"\u00f4\13\21\3\22\3\22\3\22\7\22\u00f9\n\22\f\22\16\22\u00fc\13\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u0105\n\23\f\23\16\23\u0108\13\23"+
		"\3\23\5\23\u010b\n\23\3\24\3\24\6\24\u010f\n\24\r\24\16\24\u0110\3\25"+
		"\3\25\3\25\3\25\3\25\6\25\u0118\n\25\r\25\16\25\u0119\3\26\3\26\5\26\u011e"+
		"\n\26\3\26\5\26\u0121\n\26\3\26\7\26\u0124\n\26\f\26\16\26\u0127\13\26"+
		"\3\27\3\27\3\27\7\27\u012c\n\27\f\27\16\27\u012f\13\27\3\30\3\30\3\30"+
		"\3\30\6\30\u0135\n\30\r\30\16\30\u0136\3\31\3\31\3\31\3\31\3\31\5\31\u013e"+
		"\n\31\3\31\3\31\5\31\u0142\n\31\3\31\3\31\3\32\3\32\7\32\u0148\n\32\f"+
		"\32\16\32\u014b\13\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0156\n\34\3\34\5\34\u0159\n\34\3\34\7\34\u015c\n\34\f\34\16\34\u015f"+
		"\13\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 "+
		"\3 \3 \3 \6 \u0171\n \r \16 \u0172\3 \7 \u0176\n \f \16 \u0179\13 \3 "+
		"\3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01a4\n)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u01cf\n)\f)"+
		"\16)\u01d2\13)\3*\3*\3*\3*\7*\u01d8\n*\f*\16*\u01db\13*\3*\3*\3+\3+\3"+
		"+\3+\7+\u01e3\n+\f+\16+\u01e6\13+\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\5-\u01f4\n-\3-\2.\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVX\2\30\4\2mmyy\3\2\r\16\3\2)-\4\2mmww\5\2()O"+
		"Omm\3\2#$\3\2DE\3\2\66<\3\2=C\4\2pptt\4\2ssyy\3\2VX\3\2no\3\2bc\3\2`a"+
		"\4\2dehi\3\2fg\3\2\\]\4\2dfhi\4\2mqyy\3\2nq\3\2\60\61\u020a\2c\3\2\2\2"+
		"\4e\3\2\2\2\6k\3\2\2\2\bx\3\2\2\2\n\u0081\3\2\2\2\f\u008b\3\2\2\2\16\u0093"+
		"\3\2\2\2\20\u0095\3\2\2\2\22\u009d\3\2\2\2\24\u00a3\3\2\2\2\26\u00aa\3"+
		"\2\2\2\30\u00bd\3\2\2\2\32\u00bf\3\2\2\2\34\u00c6\3\2\2\2\36\u00dd\3\2"+
		"\2\2 \u00ed\3\2\2\2\"\u00f5\3\2\2\2$\u00ff\3\2\2\2&\u010c\3\2\2\2(\u0112"+
		"\3\2\2\2*\u011b\3\2\2\2,\u0128\3\2\2\2.\u0130\3\2\2\2\60\u0138\3\2\2\2"+
		"\62\u0145\3\2\2\2\64\u014c\3\2\2\2\66\u0150\3\2\2\28\u0160\3\2\2\2:\u0162"+
		"\3\2\2\2<\u0166\3\2\2\2>\u016c\3\2\2\2@\u017c\3\2\2\2B\u0182\3\2\2\2D"+
		"\u0186\3\2\2\2F\u0188\3\2\2\2H\u018a\3\2\2\2J\u018c\3\2\2\2L\u018e\3\2"+
		"\2\2N\u0190\3\2\2\2P\u01a3\3\2\2\2R\u01d3\3\2\2\2T\u01de\3\2\2\2V\u01e9"+
		"\3\2\2\2X\u01f3\3\2\2\2Z[\5\4\3\2[\\\7\b\2\2\\d\3\2\2\2]^\5\6\4\2^_\7"+
		"\n\2\2_d\3\2\2\2`a\5\b\5\2ab\7\f\2\2bd\3\2\2\2cZ\3\2\2\2c]\3\2\2\2c`\3"+
		"\2\2\2d\3\3\2\2\2ef\7\7\2\2fg\7m\2\2gh\7%\2\2hi\5H%\2ij\5\n\6\2j\5\3\2"+
		"\2\2kl\7\t\2\2lm\7m\2\2mn\7%\2\2no\5H%\2oq\7J\2\2pr\7\7\2\2qp\3\2\2\2"+
		"qr\3\2\2\2rs\3\2\2\2st\7m\2\2tu\7%\2\2uv\5H%\2vw\5\f\7\2w\7\3\2\2\2xy"+
		"\7\13\2\2yz\7m\2\2z{\7%\2\2{|\5H%\2|}\5\f\7\2}\t\3\2\2\2~\u0080\5\16\b"+
		"\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\5\20\t\2\u0085"+
		"\u0087\5\22\n\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\13\3\2\2"+
		"\2\u0088\u008a\5\16\b\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\5\20\t\2\u008f\r\3\2\2\2\u0090\u0094\5\26\f\2\u0091\u0094"+
		"\5\30\r\2\u0092\u0094\5\32\16\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2"+
		"\2\u0093\u0092\3\2\2\2\u0094\17\3\2\2\2\u0095\u0096\7\26\2\2\u0096\u0098"+
		"\5\36\20\2\u0097\u0099\5*\26\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2"+
		"\u0099\u009b\3\2\2\2\u009a\u009c\5\62\32\2\u009b\u009a\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\21\3\2\2\2\u009d\u009f\7\27\2\2\u009e\u00a0\5\24\13\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\23\3\2\2\2\u00a3\u00a4\7m\2\2\u00a4\u00a5\7\4\2\2\u00a5\u00a6"+
		"\5P)\2\u00a6\u00a8\7\5\2\2\u00a7\u00a9\5<\37\2\u00a8\u00a7\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\25\3\2\2\2\u00aa\u00ab\7F\2\2\u00ab\u00ac\7H\2\2"+
		"\u00ac\u00af\t\2\2\2\u00ad\u00ae\7 \2\2\u00ae\u00b0\5J&\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\5\2\2\u00b2"+
		"\27\3\2\2\2\u00b3\u00b4\7#\2\2\u00b4\u00b5\t\2\2\2\u00b5\u00b6\7K\2\2"+
		"\u00b6\u00b7\t\3\2\2\u00b7\u00be\7\5\2\2\u00b8\u00b9\7$\2\2\u00b9\u00ba"+
		"\t\2\2\2\u00ba\u00bb\7K\2\2\u00bb\u00bc\t\3\2\2\u00bc\u00be\7\5\2\2\u00bd"+
		"\u00b3\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00c0\7\25\2"+
		"\2\u00c0\u00c2\7\4\2\2\u00c1\u00c3\5\34\17\2\u00c2\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\33\3\2\2"+
		"\2\u00c6\u00c7\7m\2\2\u00c7\u00d9\7\4\2\2\u00c8\u00cb\7.\2\2\u00c9\u00cc"+
		"\5R*\2\u00ca\u00cc\5T+\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc"+
		"\u00da\3\2\2\2\u00cd\u00d0\7/\2\2\u00ce\u00d1\5R*\2\u00cf\u00d1\5T+\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00da\3\2\2\2\u00d2\u00d4"+
		"\t\4\2\2\u00d3\u00d5\5N(\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d7\3\2\2\2\u00d6\u00d8\5R*\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2"+
		"\2\u00d8\u00da\3\2\2\2\u00d9\u00c8\3\2\2\2\u00d9\u00cd\3\2\2\2\u00d9\u00d2"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7\5\2\2\u00dc\35\3\2\2\2\u00dd"+
		"\u00de\7\31\2\2\u00de\u00e1\7m\2\2\u00df\u00e0\7 \2\2\u00e0\u00e2\5J&"+
		"\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e5"+
		"\5 \21\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00ea\5&\24\2\u00e7\u00e9\5(\25\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\37\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ed\u00ee\7\32\2\2\u00ee\u00f2\7\4\2\2\u00ef\u00f1\5\"\22\2"+
		"\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3!\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00fa\5$\23\2\u00f6"+
		"\u00f7\7\3\2\2\u00f7\u00f9\5$\23\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2"+
		"\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u00fe\7\5\2\2\u00fe#\3\2\2\2\u00ff\u010a\7m\2\2\u0100"+
		"\u0101\7R\2\2\u0101\u0106\7m\2\2\u0102\u0103\7\3\2\2\u0103\u0105\7m\2"+
		"\2\u0104\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010b\7S\2\2\u010a"+
		"\u0100\3\2\2\2\u010a\u010b\3\2\2\2\u010b%\3\2\2\2\u010c\u010e\7\33\2\2"+
		"\u010d\u010f\5\60\31\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\'\3\2\2\2\u0112\u0113\7\34\2\2\u0113"+
		"\u0114\7J\2\2\u0114\u0115\7m\2\2\u0115\u0117\7\4\2\2\u0116\u0118\5\60"+
		"\31\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a)\3\2\2\2\u011b\u011d\7\36\2\2\u011c\u011e\7m\2\2"+
		"\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u0121"+
		"\5,\27\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0125\3\2\2\2\u0122"+
		"\u0124\5.\30\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126+\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129"+
		"\7\35\2\2\u0129\u012d\7\4\2\2\u012a\u012c\5\60\31\2\u012b\u012a\3\2\2"+
		"\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e-"+
		"\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7J\2\2\u0131\u0132\7m\2\2\u0132"+
		"\u0134\7\4\2\2\u0133\u0135\5\60\31\2\u0134\u0133\3\2\2\2\u0135\u0136\3"+
		"\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137/\3\2\2\2\u0138\u0139"+
		"\t\5\2\2\u0139\u013a\7\4\2\2\u013a\u013d\t\6\2\2\u013b\u013c\7!\2\2\u013c"+
		"\u013e\5J&\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0141\3\2\2"+
		"\2\u013f\u0140\7j\2\2\u0140\u0142\5P)\2\u0141\u013f\3\2\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\7\5\2\2\u0144\61\3\2\2\2\u0145"+
		"\u0149\7\30\2\2\u0146\u0148\5\64\33\2\u0147\u0146\3\2\2\2\u0148\u014b"+
		"\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\63\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014d\7m\2\2\u014d\u014e\7\4\2\2\u014e\u014f\5\66"+
		"\34\2\u014f\65\3\2\2\2\u0150\u0151\t\7\2\2\u0151\u0152\7\37\2\2\u0152"+
		"\u0153\58\35\2\u0153\u0155\7\5\2\2\u0154\u0156\5:\36\2\u0155\u0154\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0159\5<\37\2\u0158"+
		"\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015d\3\2\2\2\u015a\u015c\5>"+
		" \2\u015b\u015a\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\67\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161\5P)\2"+
		"\u01619\3\2\2\2\u0162\u0163\7l\2\2\u0163\u0164\7m\2\2\u0164\u0165\7\5"+
		"\2\2\u0165;\3\2\2\2\u0166\u0167\7\65\2\2\u0167\u0168\7R\2\2\u0168\u0169"+
		"\5P)\2\u0169\u016a\7S\2\2\u016a\u016b\7\5\2\2\u016b=\3\2\2\2\u016c\u016d"+
		"\7\62\2\2\u016d\u016e\5D#\2\u016e\u0170\t\b\2\2\u016f\u0171\5@!\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173\u0177\3\2\2\2\u0174\u0176\5B\"\2\u0175\u0174\3\2\2\2\u0176"+
		"\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2"+
		"\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7\63\2\2\u017b?\3\2\2\2\u017c\u017d"+
		"\7I\2\2\u017d\u017e\5P)\2\u017e\u017f\7\64\2\2\u017f\u0180\5P)\2\u0180"+
		"\u0181\7\5\2\2\u0181A\3\2\2\2\u0182\u0183\7L\2\2\u0183\u0184\5P)\2\u0184"+
		"\u0185\7\5\2\2\u0185C\3\2\2\2\u0186\u0187\t\t\2\2\u0187E\3\2\2\2\u0188"+
		"\u0189\t\n\2\2\u0189G\3\2\2\2\u018a\u018b\t\13\2\2\u018bI\3\2\2\2\u018c"+
		"\u018d\t\f\2\2\u018dK\3\2\2\2\u018e\u018f\t\r\2\2\u018fM\3\2\2\2\u0190"+
		"\u0191\7P\2\2\u0191\u0192\t\16\2\2\u0192\u0193\7\6\2\2\u0193\u0194\t\16"+
		"\2\2\u0194\u0195\7Q\2\2\u0195O\3\2\2\2\u0196\u0197\b)\1\2\u0197\u0198"+
		"\7m\2\2\u0198\u0199\7j\2\2\u0199\u01a4\5P)\2\u019a\u019b\7[\2\2\u019b"+
		"\u01a4\5P)\2\u019c\u019d\7R\2\2\u019d\u019e\5P)\2\u019e\u019f\7S\2\2\u019f"+
		"\u01a4\3\2\2\2\u01a0\u01a4\5R*\2\u01a1\u01a4\5T+\2\u01a2\u01a4\5X-\2\u01a3"+
		"\u0196\3\2\2\2\u01a3\u019a\3\2\2\2\u01a3\u019c\3\2\2\2\u01a3\u01a0\3\2"+
		"\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01d0\3\2\2\2\u01a5"+
		"\u01a6\6)\2\3\u01a6\u01a7\t\17\2\2\u01a7\u01cf\5P)\2\u01a8\u01a9\6)\3"+
		"\3\u01a9\u01aa\t\20\2\2\u01aa\u01cf\5P)\2\u01ab\u01ac\6)\4\3\u01ac\u01ad"+
		"\t\21\2\2\u01ad\u01cf\5P)\2\u01ae\u01af\6)\5\3\u01af\u01b0\t\22\2\2\u01b0"+
		"\u01cf\5P)\2\u01b1\u01b2\6)\6\3\u01b2\u01b3\7Y\2\2\u01b3\u01cf\5P)\2\u01b4"+
		"\u01b5\6)\7\3\u01b5\u01b6\7Z\2\2\u01b6\u01cf\5P)\2\u01b7\u01b8\6)\b\3"+
		"\u01b8\u01b9\t\23\2\2\u01b9\u01cf\5P)\2\u01ba\u01bb\6)\t\3\u01bb\u01bc"+
		"\7^\2\2\u01bc\u01cf\5P)\2\u01bd\u01be\6)\n\3\u01be\u01bf\7_\2\2\u01bf"+
		"\u01cf\5P)\2\u01c0\u01c1\6)\13\3\u01c1\u01c2\7M\2\2\u01c2\u01c3\5P)\2"+
		"\u01c3\u01c4\7N\2\2\u01c4\u01c5\5P)\2\u01c5\u01c6\5F$\2\u01c6\u01cf\3"+
		"\2\2\2\u01c7\u01c8\6)\f\3\u01c8\u01c9\7M\2\2\u01c9\u01ca\5P)\2\u01ca\u01cb"+
		"\t\24\2\2\u01cb\u01cc\5P)\2\u01cc\u01cd\5D#\2\u01cd\u01cf\3\2\2\2\u01ce"+
		"\u01a5\3\2\2\2\u01ce\u01a8\3\2\2\2\u01ce\u01ab\3\2\2\2\u01ce\u01ae\3\2"+
		"\2\2\u01ce\u01b1\3\2\2\2\u01ce\u01b4\3\2\2\2\u01ce\u01b7\3\2\2\2\u01ce"+
		"\u01ba\3\2\2\2\u01ce\u01bd\3\2\2\2\u01ce\u01c0\3\2\2\2\u01ce\u01c7\3\2"+
		"\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"Q\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\7P\2\2\u01d4\u01d9\5V,\2\u01d5"+
		"\u01d6\7\3\2\2\u01d6\u01d8\5V,\2\u01d7\u01d5\3\2\2\2\u01d8\u01db\3\2\2"+
		"\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01d9"+
		"\3\2\2\2\u01dc\u01dd\7Q\2\2\u01ddS\3\2\2\2\u01de\u01df\7T\2\2\u01df\u01e4"+
		"\5V,\2\u01e0\u01e1\7\3\2\2\u01e1\u01e3\5V,\2\u01e2\u01e0\3\2\2\2\u01e3"+
		"\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7\3\2"+
		"\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e8\7U\2\2\u01e8U\3\2\2\2\u01e9\u01ea"+
		"\t\25\2\2\u01eaW\3\2\2\2\u01eb\u01f4\t\26\2\2\u01ec\u01f4\t\27\2\2\u01ed"+
		"\u01ee\7m\2\2\u01ee\u01ef\7P\2\2\u01ef\u01f0\7y\2\2\u01f0\u01f4\7Q\2\2"+
		"\u01f1\u01f4\7m\2\2\u01f2\u01f4\7y\2\2\u01f3\u01eb\3\2\2\2\u01f3\u01ec"+
		"\3\2\2\2\u01f3\u01ed\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4"+
		"Y\3\2\2\2\60cq\u0081\u0086\u008b\u0093\u0098\u009b\u00a1\u00a8\u00af\u00bd"+
		"\u00c4\u00cb\u00d0\u00d4\u00d7\u00d9\u00e1\u00e4\u00ea\u00f2\u00fa\u0106"+
		"\u010a\u0110\u0119\u011d\u0120\u0125\u012d\u0136\u013d\u0141\u0149\u0155"+
		"\u0158\u015d\u0172\u0177\u01a3\u01ce\u01d0\u01d9\u01e4\u01f3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}