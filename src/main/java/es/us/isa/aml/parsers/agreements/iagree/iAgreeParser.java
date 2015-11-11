
package es.us.isa.aml.parsers.agreements.iagree;
// Generated from C:\Users\Usuario\parser\iAgree.g4 by ANTLR 4.1
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
	public static final String[] tokenNames = {
		"<INVALID>", "','", "':'", "';'", "'..'", "'Template'", "'EndTemplate'", 
		"'AgreementOffer'", "'EndAgreementOffer'", "'Agreement'", "'EndAgreement'", 
		"'Initiator'", "'Responder'", "'ServiceProvider'", "'ExpirationTime'", 
		"'DateFormat'", "'GMTZone'", "'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", 
		"'AgreementTerms'", "'CreationConstraints'", "'GuaranteeTerms'", "'Service'", 
		"'Features'", "'GlobalDescription'", "'Description'", "'global'", "'MonitorableProperties'", 
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
	public static final int
		RULE_entry = 0, RULE_template = 1, RULE_agOffer = 2, RULE_agreement = 3, 
		RULE_template_def = 4, RULE_ag_def = 5, RULE_temp_properties = 6, RULE_agreementTerms = 7, 
		RULE_creationConstraints = 8, RULE_creationConstraint = 9, RULE_context_prop = 10, 
		RULE_partiesRoles_prop = 11, RULE_metrics_prop = 12, RULE_metric = 13, 
		RULE_service = 14, RULE_features = 15, RULE_feature = 16, RULE_feature_operation = 17, 
		RULE_globalDescription = 18, RULE_localDescription = 19, RULE_monitorableProperties = 20, 
		RULE_global_MonitorableProperties = 21, RULE_local_MonitorableProperties = 22, 
		RULE_guaranteeTerms = 23, RULE_guaranteeTerm = 24, RULE_guarantee_def = 25, 
		RULE_slo = 26, RULE_serviceScope = 27, RULE_qualifyingCondition = 28, 
		RULE_compensation = 29, RULE_compensationElement = 30, RULE_compensationsInterval = 31, 
		RULE_versionNumber = 32, RULE_url = 33, RULE_property = 34, RULE_cuantif = 35, 
		RULE_range = 36, RULE_expression = 37, RULE_list = 38, RULE_array = 39, 
		RULE_args = 40, RULE_atom = 41;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "agreement", "template_def", "ag_def", 
		"temp_properties", "agreementTerms", "creationConstraints", "creationConstraint", 
		"context_prop", "partiesRoles_prop", "metrics_prop", "metric", "service", 
		"features", "feature", "feature_operation", "globalDescription", "localDescription", 
		"monitorableProperties", "global_MonitorableProperties", "local_MonitorableProperties", 
		"guaranteeTerms", "guaranteeTerm", "guarantee_def", "slo", "serviceScope", 
		"qualifyingCondition", "compensation", "compensationElement", "compensationsInterval", 
		"versionNumber", "url", "property", "cuantif", "range", "expression", 
		"list", "array", "args", "atom"
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
			setState(93);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); template();
				setState(85); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); agOffer();
				setState(88); match(END_AG_OFFER);
				}
				break;
			case AGREEMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(90); agreement();
				setState(91); match(END_AGREEMENT);
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
			setState(95); match(TEMPLATE);
			setState(96); ((TemplateContext)_localctx).id = match(Identifier);
			setState(97); match(VERSION);
			setState(98); ((TemplateContext)_localctx).version = versionNumber();
			setState(99); template_def();
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
			setState(101); match(AG_OFFER);
			setState(102); ((AgOfferContext)_localctx).id = match(Identifier);
			setState(103); match(VERSION);
			setState(104); ((AgOfferContext)_localctx).version = versionNumber();
			setState(105); match(FOR);
			setState(107);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(106); match(TEMPLATE);
				}
			}

			setState(109); ((AgOfferContext)_localctx).templateId = match(Identifier);
			setState(110); match(VERSION);
			setState(111); ((AgOfferContext)_localctx).templateVersion = versionNumber();
			setState(112); ag_def();
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
			setState(114); match(AGREEMENT);
			setState(115); ((AgreementContext)_localctx).id = match(Identifier);
			setState(116); match(VERSION);
			setState(117); ((AgreementContext)_localctx).version = versionNumber();
			setState(118); ag_def();
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
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER) | (1L << CREATED))) != 0)) {
				{
				{
				setState(120); temp_properties();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126); agreementTerms();
			setState(128);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(127); creationConstraints();
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
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER) | (1L << CREATED))) != 0)) {
				{
				{
				setState(130); temp_properties();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); agreementTerms();
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
			setState(141);
			switch (_input.LA(1)) {
			case CREATED:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); context_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); partiesRoles_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 3);
				{
				setState(140); metrics_prop();
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
			setState(143); match(AGREEMENT_TERMS);
			setState(144); service();
			setState(146);
			_la = _input.LA(1);
			if (_la==MONITORABLEPROPERTIES) {
				{
				setState(145); monitorableProperties();
				}
			}

			setState(149);
			_la = _input.LA(1);
			if (_la==GUARANTEE_TERMS) {
				{
				setState(148); guaranteeTerms();
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
			setState(151); match(CREATION_CONSTRAINTS);
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152); creationConstraint();
				}
				}
				setState(155); 
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
			setState(157); match(Identifier);
			}
			setState(158); match(2);
			setState(159); expression(0);
			setState(160); match(3);
			setState(162);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(161); qualifyingCondition();
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
			setState(164); match(CREATED);
			setState(165); match(FROM);
			setState(166);
			((Context_propContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==String) ) {
				((Context_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(169);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(167); match(AVAL_AT);
				setState(168); url();
				}
			}

			setState(171); match(3);
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
			setState(183);
			switch (_input.LA(1)) {
			case PROVIDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(173); ((PartiesRoles_propContext)_localctx).role = match(PROVIDER);
				setState(174);
				((PartiesRoles_propContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==String) ) {
					((PartiesRoles_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(175); match(AS);
				setState(176);
				((PartiesRoles_propContext)_localctx).roleType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INITIATOR || _la==RESPONDER) ) {
					((PartiesRoles_propContext)_localctx).roleType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(177); match(3);
				}
				break;
			case CONSUMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(178); ((PartiesRoles_propContext)_localctx).role = match(CONSUMER);
				setState(179);
				((PartiesRoles_propContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==String) ) {
					((PartiesRoles_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(180); match(AS);
				setState(181);
				((PartiesRoles_propContext)_localctx).roleType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INITIATOR || _la==RESPONDER) ) {
					((PartiesRoles_propContext)_localctx).roleType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(182); match(3);
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
			setState(185); match(METRICS);
			setState(186); match(2);
			setState(188); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(187); metric();
				}
				}
				setState(190); 
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
			setState(192); ((MetricContext)_localctx).id = match(Identifier);
			setState(193); match(2);
			setState(211);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(194); ((MetricContext)_localctx).type = match(SET);
				setState(197);
				switch (_input.LA(1)) {
				case CA:
					{
					setState(195); list();
					}
					break;
				case LLA:
					{
					setState(196); array();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ENUM:
				{
				setState(199); ((MetricContext)_localctx).type = match(ENUM);
				setState(202);
				switch (_input.LA(1)) {
				case CA:
					{
					setState(200); list();
					}
					break;
				case LLA:
					{
					setState(201); array();
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
				setState(204);
				((MetricContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((MetricContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(206);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(205); range();
					}
					break;
				}
				setState(209);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(208); list();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(213); match(3);
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
			setState(215); match(SERVICE);
			setState(216); match(Identifier);
			setState(219);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(217); match(AVAL_AT);
				setState(218); ((ServiceContext)_localctx).endpointUrl = url();
				}
			}

			setState(222);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(221); features();
				}
			}

			setState(224); globalDescription();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(225); localDescription();
				}
				}
				setState(230);
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
			setState(231); match(FEATURES);
			setState(232); match(2);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(233); feature();
				}
				}
				setState(238);
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
			setState(239); feature_operation();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(240); match(1);
				setState(241); feature_operation();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247); match(3);
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
			setState(249); ((Feature_operationContext)_localctx).id = match(Identifier);
			setState(260);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(250); match(PA);
				setState(251); match(Identifier);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(252); match(1);
					setState(253); match(Identifier);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(259); match(PC);
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
			setState(262); match(GLOBALDESCRIPTION);
			setState(264); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(263); property();
				}
				}
				setState(266); 
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
			setState(268); match(DESCRIPTION);
			setState(269); match(FOR);
			setState(270); match(Identifier);
			setState(271); match(2);
			setState(273); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(272); property();
				}
				}
				setState(275); 
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
			setState(277); match(MONITORABLEPROPERTIES);
			setState(279);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(278); match(Identifier);
				}
			}

			setState(282);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(281); global_MonitorableProperties();
				}
			}

			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(284); local_MonitorableProperties();
				}
				}
				setState(289);
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
			setState(290); match(GLOBAL);
			setState(291); match(2);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier || _la==Access) {
				{
				{
				setState(292); property();
				}
				}
				setState(297);
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
			setState(298); match(FOR);
			setState(299); match(Identifier);
			setState(300); match(2);
			setState(302); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(301); property();
				}
				}
				setState(304); 
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
		enterRule(_localctx, 46, RULE_guaranteeTerms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); match(GUARANTEE_TERMS);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(307); guaranteeTerm();
				}
				}
				setState(312);
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
		enterRule(_localctx, 48, RULE_guaranteeTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(Identifier);
			setState(314); match(2);
			setState(315); guarantee_def();
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
		enterRule(_localctx, 50, RULE_guarantee_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			((Guarantee_defContext)_localctx).ob = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
				((Guarantee_defContext)_localctx).ob = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(318); match(GUARANTEES);
			setState(319); slo();
			setState(320); match(3);
			setState(322);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(321); serviceScope();
				}
			}

			setState(325);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(324); qualifyingCondition();
				}
			}

			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(327); compensation();
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
		enterRule(_localctx, 52, RULE_slo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); expression(0);
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
		enterRule(_localctx, 54, RULE_serviceScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335); match(UPON);
			setState(336); match(Identifier);
			setState(337); match(3);
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
		enterRule(_localctx, 56, RULE_qualifyingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); match(ONLY_IF);
			setState(340); match(PA);
			setState(341); expression(0);
			setState(342); match(PC);
			setState(343); match(3);
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
		public CompensationElementContext compensationElement(int i) {
			return getRuleContext(CompensationElementContext.class,i);
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
		enterRule(_localctx, 58, RULE_compensation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); match(WITH);
			setState(346); ((CompensationContext)_localctx).interv = compensationsInterval();
			setState(347);
			((CompensationContext)_localctx).compType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PENALTY || _la==REWARD) ) {
				((CompensationContext)_localctx).compType = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(349); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(348); compensationElement();
				}
				}
				setState(351); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OF );
			setState(353); match(END);
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
		enterRule(_localctx, 60, RULE_compensationElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355); match(OF);
			setState(356); ((CompensationElementContext)_localctx).exp = expression(0);
			setState(357); match(IF);
			setState(358); ((CompensationElementContext)_localctx).cond = expression(0);
			setState(359); match(3);
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
		enterRule(_localctx, 62, RULE_compensationsInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
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
		enterRule(_localctx, 64, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
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
		enterRule(_localctx, 66, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
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
		public UrlContext defineAT;
		public TerminalNode DEFINED_AT() { return getToken(iAgreeParser.DEFINED_AT, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
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
		enterRule(_localctx, 68, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			((PropertyContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==Access) ) {
				((PropertyContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(368); match(2);
			setState(369);
			((PropertyContext)_localctx).met = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==Identifier) ) {
				((PropertyContext)_localctx).met = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(374);
			switch (_input.LA(1)) {
			case ASSIG:
				{
				setState(370); match(ASSIG);
				setState(371); ((PropertyContext)_localctx).value = expression(0);
				}
				break;
			case DEFINED_AT:
				{
				setState(372); match(DEFINED_AT);
				setState(373); ((PropertyContext)_localctx).defineAT = url();
				}
				break;
			case 3:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(376); match(3);
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
		enterRule(_localctx, 70, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_la = _input.LA(1);
			if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXACTLY_ONE - 71)) | (1L << (ONE_OR_MORE - 71)) | (1L << (ALL - 71)))) != 0)) ) {
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
		enterRule(_localctx, 72, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); match(CA);
			setState(381);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(382); match(4);
			setState(383);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(384); match(CC);
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
		int _startState = 74;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new AssigExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(387); match(Identifier);
				setState(388); match(ASSIG);
				setState(389); expression(15);
				}
				break;

			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(390); match(NOT);
				setState(391); expression(14);
				}
				break;

			case 3:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(392); match(PA);
				setState(393); expression(0);
				setState(394); match(PC);
				}
				break;

			case 4:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(396); list();
				}
				break;

			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(397); array();
				}
				break;

			case 6:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(398); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(428);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(401);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(402);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(403); expression(14);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(404);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(405);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(406); expression(13);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(407);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(408);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (LT - 85)) | (1L << (GT - 85)) | (1L << (LTE - 85)) | (1L << (GTE - 85)))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(409); expression(12);
						}
						break;

					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(411);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(412); expression(11);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(414); match(AND);
						setState(415); expression(10);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(416);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(417); match(OR);
						setState(418); expression(9);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(420);
						_la = _input.LA(1);
						if ( !(_la==IMPLIES || _la==REQUIRES) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(421); expression(8);
						}
						break;

					case 8:
						{
						_localctx = new IffExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(423); match(IFF);
						setState(424); expression(7);
						}
						break;

					case 9:
						{
						_localctx = new ExcludesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(426); match(EXCLUDES);
						setState(427); expression(6);
						}
						break;
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
		enterRule(_localctx, 76, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433); match(CA);
			setState(434); ((ListContext)_localctx).l1 = args();
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(435); match(1);
				setState(436); ((ListContext)_localctx).l2 = args();
				}
				}
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(442); match(CC);
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
		enterRule(_localctx, 78, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444); match(LLA);
			setState(445); ((ArrayContext)_localctx).l1 = args();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(446); match(1);
				setState(447); ((ArrayContext)_localctx).l2 = args();
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(453); match(LLC);
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
		enterRule(_localctx, 80, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			((ArgsContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (Identifier - 94)) | (1L << (Integer - 94)) | (1L << (S_Integer - 94)) | (1L << (Float - 94)) | (1L << (S_Float - 94)) | (1L << (String - 94)))) != 0)) ) {
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
		enterRule(_localctx, 82, RULE_atom);
		int _la;
		try {
			setState(465);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				_la = _input.LA(1);
				if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (Integer - 95)) | (1L << (S_Integer - 95)) | (1L << (Float - 95)) | (1L << (S_Float - 95)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 2:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
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
				setState(459); ((ArrayAtomContext)_localctx).id = match(Identifier);
				setState(460); match(CA);
				setState(461); ((ArrayAtomContext)_localctx).value = match(String);
				setState(462); match(CC);
				}
				break;

			case 4:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(463); match(Identifier);
				}
				break;

			case 5:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(464); match(String);
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
		case 37: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 13 >= _localctx._p;

		case 1: return 12 >= _localctx._p;

		case 2: return 11 >= _localctx._p;

		case 3: return 10 >= _localctx._p;

		case 4: return 9 >= _localctx._p;

		case 5: return 8 >= _localctx._p;

		case 6: return 7 >= _localctx._p;

		case 7: return 6 >= _localctx._p;

		case 8: return 5 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3o\u01d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2`\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4n\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\7\6|\n\6\f\6\16\6\177\13\6\3\6\3\6\5\6\u0083\n\6\3\7\7\7\u0086"+
		"\n\7\f\7\16\7\u0089\13\7\3\7\3\7\3\b\3\b\3\b\5\b\u0090\n\b\3\t\3\t\3\t"+
		"\5\t\u0095\n\t\3\t\5\t\u0098\n\t\3\n\3\n\6\n\u009c\n\n\r\n\16\n\u009d"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00a5\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u00ac"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ba\n\r\3\16"+
		"\3\16\3\16\6\16\u00bf\n\16\r\16\16\16\u00c0\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00c8\n\17\3\17\3\17\3\17\5\17\u00cd\n\17\3\17\3\17\5\17\u00d1\n\17"+
		"\3\17\5\17\u00d4\n\17\5\17\u00d6\n\17\3\17\3\17\3\20\3\20\3\20\3\20\5"+
		"\20\u00de\n\20\3\20\5\20\u00e1\n\20\3\20\3\20\7\20\u00e5\n\20\f\20\16"+
		"\20\u00e8\13\20\3\21\3\21\3\21\7\21\u00ed\n\21\f\21\16\21\u00f0\13\21"+
		"\3\22\3\22\3\22\7\22\u00f5\n\22\f\22\16\22\u00f8\13\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u0101\n\23\f\23\16\23\u0104\13\23\3\23\5\23"+
		"\u0107\n\23\3\24\3\24\6\24\u010b\n\24\r\24\16\24\u010c\3\25\3\25\3\25"+
		"\3\25\3\25\6\25\u0114\n\25\r\25\16\25\u0115\3\26\3\26\5\26\u011a\n\26"+
		"\3\26\5\26\u011d\n\26\3\26\7\26\u0120\n\26\f\26\16\26\u0123\13\26\3\27"+
		"\3\27\3\27\7\27\u0128\n\27\f\27\16\27\u012b\13\27\3\30\3\30\3\30\3\30"+
		"\6\30\u0131\n\30\r\30\16\30\u0132\3\31\3\31\7\31\u0137\n\31\f\31\16\31"+
		"\u013a\13\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0145\n"+
		"\33\3\33\5\33\u0148\n\33\3\33\7\33\u014b\n\33\f\33\16\33\u014e\13\33\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\6\37\u0160\n\37\r\37\16\37\u0161\3\37\3\37\3 \3 \3 \3 \3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\5$\u0179\n$\3$\3$\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'"+
		"\u0192\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01af\n\'\f\'\16"+
		"\'\u01b2\13\'\3(\3(\3(\3(\7(\u01b8\n(\f(\16(\u01bb\13(\3(\3(\3)\3)\3)"+
		"\3)\7)\u01c3\n)\f)\16)\u01c6\13)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\5"+
		"+\u01d4\n+\3+\2,\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRT\2\26\4\2``ll\3\2\r\16\3\2(,\3\2#$\3\2;<\3\2\65:"+
		"\4\2ccgg\4\2ffll\4\2``jj\4\2((``\3\2IK\3\2ab\3\2UV\3\2ST\4\2WX[\\\3\2"+
		"YZ\3\2OP\4\2`dll\3\2ad\3\2/\60\u01e9\2_\3\2\2\2\4a\3\2\2\2\6g\3\2\2\2"+
		"\bt\3\2\2\2\n}\3\2\2\2\f\u0087\3\2\2\2\16\u008f\3\2\2\2\20\u0091\3\2\2"+
		"\2\22\u0099\3\2\2\2\24\u009f\3\2\2\2\26\u00a6\3\2\2\2\30\u00b9\3\2\2\2"+
		"\32\u00bb\3\2\2\2\34\u00c2\3\2\2\2\36\u00d9\3\2\2\2 \u00e9\3\2\2\2\"\u00f1"+
		"\3\2\2\2$\u00fb\3\2\2\2&\u0108\3\2\2\2(\u010e\3\2\2\2*\u0117\3\2\2\2,"+
		"\u0124\3\2\2\2.\u012c\3\2\2\2\60\u0134\3\2\2\2\62\u013b\3\2\2\2\64\u013f"+
		"\3\2\2\2\66\u014f\3\2\2\28\u0151\3\2\2\2:\u0155\3\2\2\2<\u015b\3\2\2\2"+
		">\u0165\3\2\2\2@\u016b\3\2\2\2B\u016d\3\2\2\2D\u016f\3\2\2\2F\u0171\3"+
		"\2\2\2H\u017c\3\2\2\2J\u017e\3\2\2\2L\u0191\3\2\2\2N\u01b3\3\2\2\2P\u01be"+
		"\3\2\2\2R\u01c9\3\2\2\2T\u01d3\3\2\2\2VW\5\4\3\2WX\7\b\2\2X`\3\2\2\2Y"+
		"Z\5\6\4\2Z[\7\n\2\2[`\3\2\2\2\\]\5\b\5\2]^\7\f\2\2^`\3\2\2\2_V\3\2\2\2"+
		"_Y\3\2\2\2_\\\3\2\2\2`\3\3\2\2\2ab\7\7\2\2bc\7`\2\2cd\7%\2\2de\5B\"\2"+
		"ef\5\n\6\2f\5\3\2\2\2gh\7\t\2\2hi\7`\2\2ij\7%\2\2jk\5B\"\2km\7A\2\2ln"+
		"\7\7\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7`\2\2pq\7%\2\2qr\5B\"\2rs\5"+
		"\f\7\2s\7\3\2\2\2tu\7\13\2\2uv\7`\2\2vw\7%\2\2wx\5B\"\2xy\5\f\7\2y\t\3"+
		"\2\2\2z|\5\16\b\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3"+
		"\2\2\2\177}\3\2\2\2\u0080\u0082\5\20\t\2\u0081\u0083\5\22\n\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\13\3\2\2\2\u0084\u0086\5\16\b\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\5\20\t\2\u008b"+
		"\r\3\2\2\2\u008c\u0090\5\26\f\2\u008d\u0090\5\30\r\2\u008e\u0090\5\32"+
		"\16\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\17\3\2\2\2\u0091\u0092\7\26\2\2\u0092\u0094\5\36\20\2\u0093\u0095\5*"+
		"\26\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0098\5\60\31\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\21\3\2"+
		"\2\2\u0099\u009b\7\27\2\2\u009a\u009c\5\24\13\2\u009b\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\23\3\2\2"+
		"\2\u009f\u00a0\7`\2\2\u00a0\u00a1\7\4\2\2\u00a1\u00a2\5L\'\2\u00a2\u00a4"+
		"\7\5\2\2\u00a3\u00a5\5:\36\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\25\3\2\2\2\u00a6\u00a7\7=\2\2\u00a7\u00a8\7?\2\2\u00a8\u00ab\t\2\2\2"+
		"\u00a9\u00aa\7 \2\2\u00aa\u00ac\5D#\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\5\2\2\u00ae\27\3\2\2\2\u00af"+
		"\u00b0\7#\2\2\u00b0\u00b1\t\2\2\2\u00b1\u00b2\7B\2\2\u00b2\u00b3\t\3\2"+
		"\2\u00b3\u00ba\7\5\2\2\u00b4\u00b5\7$\2\2\u00b5\u00b6\t\2\2\2\u00b6\u00b7"+
		"\7B\2\2\u00b7\u00b8\t\3\2\2\u00b8\u00ba\7\5\2\2\u00b9\u00af\3\2\2\2\u00b9"+
		"\u00b4\3\2\2\2\u00ba\31\3\2\2\2\u00bb\u00bc\7\25\2\2\u00bc\u00be\7\4\2"+
		"\2\u00bd\u00bf\5\34\17\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\33\3\2\2\2\u00c2\u00c3\7`\2\2"+
		"\u00c3\u00d5\7\4\2\2\u00c4\u00c7\7-\2\2\u00c5\u00c8\5N(\2\u00c6\u00c8"+
		"\5P)\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00d6\3\2\2\2\u00c9"+
		"\u00cc\7.\2\2\u00ca\u00cd\5N(\2\u00cb\u00cd\5P)\2\u00cc\u00ca\3\2\2\2"+
		"\u00cc\u00cb\3\2\2\2\u00cd\u00d6\3\2\2\2\u00ce\u00d0\t\4\2\2\u00cf\u00d1"+
		"\5J&\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d4\5N(\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2"+
		"\2\u00d5\u00c4\3\2\2\2\u00d5\u00c9\3\2\2\2\u00d5\u00ce\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d8\7\5\2\2\u00d8\35\3\2\2\2\u00d9\u00da\7\31\2\2\u00da"+
		"\u00dd\7`\2\2\u00db\u00dc\7 \2\2\u00dc\u00de\5D#\2\u00dd\u00db\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\5 \21\2\u00e0\u00df"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\5&\24\2\u00e3"+
		"\u00e5\5(\25\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\37\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea"+
		"\7\32\2\2\u00ea\u00ee\7\4\2\2\u00eb\u00ed\5\"\22\2\u00ec\u00eb\3\2\2\2"+
		"\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef!\3"+
		"\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f6\5$\23\2\u00f2\u00f3\7\3\2\2\u00f3"+
		"\u00f5\5$\23\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fa\7\5\2\2\u00fa#\3\2\2\2\u00fb\u0106\7`\2\2\u00fc\u00fd\7E\2\2\u00fd"+
		"\u0102\7`\2\2\u00fe\u00ff\7\3\2\2\u00ff\u0101\7`\2\2\u0100\u00fe\3\2\2"+
		"\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0107\7F\2\2\u0106\u00fc\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107%\3\2\2\2\u0108\u010a\7\33\2\2\u0109\u010b\5F$\2\u010a"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\'\3\2\2\2\u010e\u010f\7\34\2\2\u010f\u0110\7A\2\2\u0110\u0111"+
		"\7`\2\2\u0111\u0113\7\4\2\2\u0112\u0114\5F$\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116)\3\2\2\2"+
		"\u0117\u0119\7\36\2\2\u0118\u011a\7`\2\2\u0119\u0118\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u011d\5,\27\2\u011c\u011b\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u0121\3\2\2\2\u011e\u0120\5.\30\2\u011f\u011e\3\2"+
		"\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"+\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7\35\2\2\u0125\u0129\7\4\2\2"+
		"\u0126\u0128\5F$\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a-\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u012d\7A\2\2\u012d\u012e\7`\2\2\u012e\u0130\7\4\2\2\u012f\u0131\5F$\2"+
		"\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133/\3\2\2\2\u0134\u0138\7\30\2\2\u0135\u0137\5\62\32\2\u0136"+
		"\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\61\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7`\2\2\u013c\u013d"+
		"\7\4\2\2\u013d\u013e\5\64\33\2\u013e\63\3\2\2\2\u013f\u0140\t\5\2\2\u0140"+
		"\u0141\7\37\2\2\u0141\u0142\5\66\34\2\u0142\u0144\7\5\2\2\u0143\u0145"+
		"\58\35\2\u0144\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146"+
		"\u0148\5:\36\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014c\3\2"+
		"\2\2\u0149\u014b\5<\37\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\65\3\2\2\2\u014e\u014c\3\2\2"+
		"\2\u014f\u0150\5L\'\2\u0150\67\3\2\2\2\u0151\u0152\7_\2\2\u0152\u0153"+
		"\7`\2\2\u0153\u0154\7\5\2\2\u01549\3\2\2\2\u0155\u0156\7\64\2\2\u0156"+
		"\u0157\7E\2\2\u0157\u0158\5L\'\2\u0158\u0159\7F\2\2\u0159\u015a\7\5\2"+
		"\2\u015a;\3\2\2\2\u015b\u015c\7\61\2\2\u015c\u015d\5@!\2\u015d\u015f\t"+
		"\6\2\2\u015e\u0160\5> \2\u015f\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7\62"+
		"\2\2\u0164=\3\2\2\2\u0165\u0166\7@\2\2\u0166\u0167\5L\'\2\u0167\u0168"+
		"\7\63\2\2\u0168\u0169\5L\'\2\u0169\u016a\7\5\2\2\u016a?\3\2\2\2\u016b"+
		"\u016c\t\7\2\2\u016cA\3\2\2\2\u016d\u016e\t\b\2\2\u016eC\3\2\2\2\u016f"+
		"\u0170\t\t\2\2\u0170E\3\2\2\2\u0171\u0172\t\n\2\2\u0172\u0173\7\4\2\2"+
		"\u0173\u0178\t\13\2\2\u0174\u0175\7]\2\2\u0175\u0179\5L\'\2\u0176\u0177"+
		"\7!\2\2\u0177\u0179\5D#\2\u0178\u0174\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\7\5\2\2\u017bG\3\2\2\2"+
		"\u017c\u017d\t\f\2\2\u017dI\3\2\2\2\u017e\u017f\7C\2\2\u017f\u0180\t\r"+
		"\2\2\u0180\u0181\7\6\2\2\u0181\u0182\t\r\2\2\u0182\u0183\7D\2\2\u0183"+
		"K\3\2\2\2\u0184\u0185\b\'\1\2\u0185\u0186\7`\2\2\u0186\u0187\7]\2\2\u0187"+
		"\u0192\5L\'\2\u0188\u0189\7N\2\2\u0189\u0192\5L\'\2\u018a\u018b\7E\2\2"+
		"\u018b\u018c\5L\'\2\u018c\u018d\7F\2\2\u018d\u0192\3\2\2\2\u018e\u0192"+
		"\5N(\2\u018f\u0192\5P)\2\u0190\u0192\5T+\2\u0191\u0184\3\2\2\2\u0191\u0188"+
		"\3\2\2\2\u0191\u018a\3\2\2\2\u0191\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0191"+
		"\u0190\3\2\2\2\u0192\u01b0\3\2\2\2\u0193\u0194\6\'\2\3\u0194\u0195\t\16"+
		"\2\2\u0195\u01af\5L\'\2\u0196\u0197\6\'\3\3\u0197\u0198\t\17\2\2\u0198"+
		"\u01af\5L\'\2\u0199\u019a\6\'\4\3\u019a\u019b\t\20\2\2\u019b\u01af\5L"+
		"\'\2\u019c\u019d\6\'\5\3\u019d\u019e\t\21\2\2\u019e\u01af\5L\'\2\u019f"+
		"\u01a0\6\'\6\3\u01a0\u01a1\7L\2\2\u01a1\u01af\5L\'\2\u01a2\u01a3\6\'\7"+
		"\3\u01a3\u01a4\7M\2\2\u01a4\u01af\5L\'\2\u01a5\u01a6\6\'\b\3\u01a6\u01a7"+
		"\t\22\2\2\u01a7\u01af\5L\'\2\u01a8\u01a9\6\'\t\3\u01a9\u01aa\7Q\2\2\u01aa"+
		"\u01af\5L\'\2\u01ab\u01ac\6\'\n\3\u01ac\u01ad\7R\2\2\u01ad\u01af\5L\'"+
		"\2\u01ae\u0193\3\2\2\2\u01ae\u0196\3\2\2\2\u01ae\u0199\3\2\2\2\u01ae\u019c"+
		"\3\2\2\2\u01ae\u019f\3\2\2\2\u01ae\u01a2\3\2\2\2\u01ae\u01a5\3\2\2\2\u01ae"+
		"\u01a8\3\2\2\2\u01ae\u01ab\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1M\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4"+
		"\7C\2\2\u01b4\u01b9\5R*\2\u01b5\u01b6\7\3\2\2\u01b6\u01b8\5R*\2\u01b7"+
		"\u01b5\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2"+
		"\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd\7D\2\2\u01bd"+
		"O\3\2\2\2\u01be\u01bf\7G\2\2\u01bf\u01c4\5R*\2\u01c0\u01c1\7\3\2\2\u01c1"+
		"\u01c3\5R*\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2"+
		"\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8"+
		"\7H\2\2\u01c8Q\3\2\2\2\u01c9\u01ca\t\23\2\2\u01caS\3\2\2\2\u01cb\u01d4"+
		"\t\24\2\2\u01cc\u01d4\t\25\2\2\u01cd\u01ce\7`\2\2\u01ce\u01cf\7C\2\2\u01cf"+
		"\u01d0\7l\2\2\u01d0\u01d4\7D\2\2\u01d1\u01d4\7`\2\2\u01d2\u01d4\7l\2\2"+
		"\u01d3\u01cb\3\2\2\2\u01d3\u01cc\3\2\2\2\u01d3\u01cd\3\2\2\2\u01d3\u01d1"+
		"\3\2\2\2\u01d3\u01d2\3\2\2\2\u01d4U\3\2\2\2._m}\u0082\u0087\u008f\u0094"+
		"\u0097\u009d\u00a4\u00ab\u00b9\u00c0\u00c7\u00cc\u00d0\u00d3\u00d5\u00dd"+
		"\u00e0\u00e6\u00ee\u00f6\u0102\u0106\u010c\u0115\u0119\u011c\u0121\u0129"+
		"\u0132\u0138\u0144\u0147\u014c\u0161\u0178\u0191\u01ae\u01b0\u01b9\u01c4"+
		"\u01d3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}