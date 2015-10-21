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
// Generated from C:\Users\ISA Group\Desktop\Parsers\iAgree-parser\iAgree\iAgree.g4 by ANTLR 4.1
>>>>>>> Stashed changes
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
		BOOLEAN=38, INTEGER=39, FLOAT=40, NATURAL=41, NUMBER=42, SET=43, ENUM=44, 
		TRUE=45, FALSE=46, WITH=47, END=48, IF=49, ONLY_IF=50, YEARLY=51, MONTHLY=52, 
		WEEKLY=53, DAILY=54, HOURLY=55, MINUTELY=56, SECONDLY=57, YEAR=58, MONTH=59, 
		WEEK=60, DAY=61, HOUR=62, MINUTE=63, SECOND=64, PENALTY=65, REWARD=66, 
		CREATED=67, ON=68, FROM=69, OF=70, FOR=71, AS=72, IN=73, BY=74, RESOURCE=75, 
		CA=76, CC=77, PA=78, PC=79, LLA=80, LLC=81, EXACTLY_ONE=82, ONE_OR_MORE=83, 
		ALL=84, AND=85, OR=86, NOT=87, IMPLIES=88, REQUIRES=89, IFF=90, EXCLUDES=91, 
		ADD=92, SUBTRACT=93, MULTIPLY=94, DIVIDE=95, LT=96, GT=97, EQ=98, NEQ=99, 
		LTE=100, GTE=101, ASSIG=102, BELONGS=103, UPON=104, Identifier=105, Integer=106, 
		S_Integer=107, Float=108, S_Float=109, Boolean=110, Url=111, Version=112, 
		Date=113, Hour=114, Access=115, Unit=116, String=117, WS=118, COMMENT=119, 
		LINE_COMMENT=120;
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
		"'daily'", "'hourly'", "'minutely'", "'secondly'", "YEAR", "MONTH", "WEEK", 
		"DAY", "HOUR", "MINUTE", "SECOND", "'penalty'", "'reward'", "'Created'", 
		"'on'", "'from'", "'of'", "'for'", "'as'", "'in'", "'by'", "'resource'", 
		"'['", "']'", "'('", "')'", "'{'", "'}'", "'exactly one'", "'one or more'", 
		"'all'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'REQUIRES'", "'IFF'", 
		"'EXCLUDES'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "'!='", 
		"'<='", "'>='", "'='", "'belongs'", "'upon'", "Identifier", "Integer", 
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
		RULE_guaranteeTerms = 23, RULE_guaranteeTerm = 24, RULE_guarantee_def = 25, 
		RULE_slo = 26, RULE_serviceScope = 27, RULE_qualifyingCondition = 28, 
		RULE_compensation = 29, RULE_compensationElement = 30, RULE_compensationsInterval = 31, 
		RULE_duringInterval = 32, RULE_versionNumber = 33, RULE_url = 34, RULE_property = 35, 
		RULE_cuantif = 36, RULE_range = 37, RULE_expression = 38, RULE_list = 39, 
		RULE_array = 40, RULE_args = 41, RULE_atom = 42;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "agreement", "template_def", "ag_def", 
		"temp_properties", "agreementTerms", "creationConstraints", "creationConstraint", 
		"context_prop", "partiesRoles_prop", "metrics_prop", "metric", "service", 
		"features", "feature", "feature_operation", "globalDescription", "localDescription", 
		"monitorableProperties", "global_MonitorableProperties", "local_MonitorableProperties", 
		"guaranteeTerms", "guaranteeTerm", "guarantee_def", "slo", "serviceScope", 
		"qualifyingCondition", "compensation", "compensationElement", "compensationsInterval", 
		"duringInterval", "versionNumber", "url", "property", "cuantif", "range", 
		"expression", "list", "array", "args", "atom"
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
			setState(95);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(86); template();
				setState(87); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); agOffer();
				setState(90); match(END_AG_OFFER);
				}
				break;
			case AGREEMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(92); agreement();
				setState(93); match(END_AGREEMENT);
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
			setState(97); match(TEMPLATE);
			setState(98); ((TemplateContext)_localctx).id = match(Identifier);
			setState(99); match(VERSION);
			setState(100); ((TemplateContext)_localctx).version = versionNumber();
			setState(101); template_def();
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
			setState(103); match(AG_OFFER);
			setState(104); ((AgOfferContext)_localctx).id = match(Identifier);
			setState(105); match(VERSION);
			setState(106); ((AgOfferContext)_localctx).version = versionNumber();
			setState(107); match(FOR);
			setState(109);
			_la = _input.LA(1);
			if (_la==TEMPLATE) {
				{
				setState(108); match(TEMPLATE);
				}
			}

			setState(111); ((AgOfferContext)_localctx).templateId = match(Identifier);
			setState(112); match(VERSION);
			setState(113); ((AgOfferContext)_localctx).templateVersion = versionNumber();
			setState(114); ag_def();
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
			setState(116); match(AGREEMENT);
			setState(117); ((AgreementContext)_localctx).id = match(Identifier);
			setState(118); match(VERSION);
			setState(119); ((AgreementContext)_localctx).version = versionNumber();
			setState(120); ag_def();
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
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (METRICS - 19)) | (1L << (PROVIDER - 19)) | (1L << (CONSUMER - 19)) | (1L << (CREATED - 19)))) != 0)) {
				{
				{
				setState(122); temp_properties();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128); agreementTerms();
			setState(130);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(129); creationConstraints();
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
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (METRICS - 19)) | (1L << (PROVIDER - 19)) | (1L << (CONSUMER - 19)) | (1L << (CREATED - 19)))) != 0)) {
				{
				{
				setState(132); temp_properties();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138); agreementTerms();
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
			setState(143);
			switch (_input.LA(1)) {
			case CREATED:
				enterOuterAlt(_localctx, 1);
				{
				setState(140); context_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(141); partiesRoles_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 3);
				{
				setState(142); metrics_prop();
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
			setState(145); match(AGREEMENT_TERMS);
			setState(146); service();
			setState(148);
			_la = _input.LA(1);
			if (_la==MONITORABLEPROPERTIES) {
				{
				setState(147); monitorableProperties();
				}
			}

			setState(151);
			_la = _input.LA(1);
			if (_la==GUARANTEE_TERMS) {
				{
				setState(150); guaranteeTerms();
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
			setState(153); match(CREATION_CONSTRAINTS);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154); creationConstraint();
				}
				}
				setState(157); 
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
			setState(159); match(Identifier);
			}
			setState(160); match(2);
			setState(161); expression(0);
			setState(162); match(3);
			setState(164);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(163); qualifyingCondition();
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
			setState(166); match(CREATED);
			setState(167); match(FROM);
			setState(168);
			((Context_propContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==String) ) {
				((Context_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(171);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(169); match(AVAL_AT);
				setState(170); url();
				}
			}

			setState(173); match(3);
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
			setState(185);
			switch (_input.LA(1)) {
			case PROVIDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(175); ((PartiesRoles_propContext)_localctx).role = match(PROVIDER);
				setState(176);
				((PartiesRoles_propContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==String) ) {
					((PartiesRoles_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(177); match(AS);
				setState(178);
				((PartiesRoles_propContext)_localctx).roleType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INITIATOR || _la==RESPONDER) ) {
					((PartiesRoles_propContext)_localctx).roleType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(179); match(3);
				}
				break;
			case CONSUMER:
				enterOuterAlt(_localctx, 2);
				{
				setState(180); ((PartiesRoles_propContext)_localctx).role = match(CONSUMER);
				setState(181);
				((PartiesRoles_propContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==String) ) {
					((PartiesRoles_propContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(182); match(AS);
				setState(183);
				((PartiesRoles_propContext)_localctx).roleType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INITIATOR || _la==RESPONDER) ) {
					((PartiesRoles_propContext)_localctx).roleType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(184); match(3);
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
			setState(187); match(METRICS);
			setState(188); match(2);
			setState(190); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(189); metric();
				}
				}
				setState(192); 
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
			setState(194); ((MetricContext)_localctx).id = match(Identifier);
			setState(195); match(2);
			setState(213);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(196); ((MetricContext)_localctx).type = match(SET);
				setState(199);
				switch (_input.LA(1)) {
				case CA:
					{
					setState(197); list();
					}
					break;
				case LLA:
					{
					setState(198); array();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ENUM:
				{
				setState(201); ((MetricContext)_localctx).type = match(ENUM);
				setState(204);
				switch (_input.LA(1)) {
				case CA:
					{
					setState(202); list();
					}
					break;
				case LLA:
					{
					setState(203); array();
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
				setState(206);
				((MetricContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((MetricContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(208);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(207); range();
					}
					break;
				}
				setState(211);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(210); list();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(215); match(3);
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
			setState(217); match(SERVICE);
			setState(218); match(Identifier);
			setState(221);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(219); match(AVAL_AT);
				setState(220); ((ServiceContext)_localctx).endpointUrl = url();
				}
			}

			setState(224);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(223); features();
				}
			}

			setState(226); globalDescription();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(227); localDescription();
				}
				}
				setState(232);
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
			setState(233); match(FEATURES);
			setState(234); match(2);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(235); feature();
				}
				}
				setState(240);
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
			setState(241); feature_operation();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(242); match(1);
				setState(243); feature_operation();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249); match(3);
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
			setState(251); ((Feature_operationContext)_localctx).id = match(Identifier);
			setState(262);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(252); match(PA);
				setState(253); match(Identifier);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(254); match(1);
					setState(255); match(Identifier);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261); match(PC);
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
			setState(264); match(GLOBALDESCRIPTION);
			setState(266); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(265); property();
				}
				}
				setState(268); 
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
			setState(270); match(DESCRIPTION);
			setState(271); match(FOR);
			setState(272); match(Identifier);
			setState(273); match(2);
			setState(275); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(274); property();
				}
				}
				setState(277); 
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
			setState(279); match(MONITORABLEPROPERTIES);
			setState(281);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(280); match(Identifier);
				}
			}

			setState(284);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(283); global_MonitorableProperties();
				}
			}

			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(286); local_MonitorableProperties();
				}
				}
				setState(291);
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
			setState(292); match(GLOBAL);
			setState(293); match(2);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier || _la==Access) {
				{
				{
				setState(294); property();
				}
				}
				setState(299);
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
			setState(300); match(FOR);
			setState(301); match(Identifier);
			setState(302); match(2);
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(303); property();
				}
				}
				setState(306); 
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
			setState(308); match(GUARANTEE_TERMS);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(309); guaranteeTerm();
				}
				}
				setState(314);
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
			setState(315); match(Identifier);
			setState(316); match(2);
			setState(317); guarantee_def();
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
			setState(319);
			((Guarantee_defContext)_localctx).ob = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
				((Guarantee_defContext)_localctx).ob = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(320); match(GUARANTEES);
			setState(321); slo();
			setState(322); match(3);
			setState(324);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(323); serviceScope();
				}
			}

			setState(327);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(326); qualifyingCondition();
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(329); compensation();
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
			setState(335); expression(0);
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
			setState(337); match(UPON);
			setState(338); match(Identifier);
			setState(339); match(3);
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
			setState(341); match(ONLY_IF);
			setState(342); match(PA);
			setState(343); expression(0);
			setState(344); match(PC);
			setState(345); match(3);
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
			setState(347); match(WITH);
			setState(348); ((CompensationContext)_localctx).interv = compensationsInterval();
			setState(349);
			((CompensationContext)_localctx).compType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PENALTY || _la==REWARD) ) {
				((CompensationContext)_localctx).compType = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(351); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(350); compensationElement();
				}
				}
				setState(353); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OF );
			setState(355); match(END);
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
			setState(357); match(OF);
			setState(358); ((CompensationElementContext)_localctx).exp = expression(0);
			setState(359); match(IF);
			setState(360); ((CompensationElementContext)_localctx).cond = expression(0);
			setState(361); match(3);
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
		enterRule(_localctx, 62, RULE_compensationsInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
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
		enterRule(_localctx, 64, RULE_duringInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (YEAR - 58)) | (1L << (MONTH - 58)) | (1L << (WEEK - 58)) | (1L << (DAY - 58)) | (1L << (HOUR - 58)) | (1L << (MINUTE - 58)) | (1L << (SECOND - 58)))) != 0)) ) {
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
		enterRule(_localctx, 66, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
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
		enterRule(_localctx, 68, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
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
		public TerminalNode RESOURCE() { return getToken(iAgreeParser.RESOURCE, 0); }
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
		enterRule(_localctx, 70, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			((PropertyContext)_localctx).id = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==Access) ) {
				((PropertyContext)_localctx).id = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(372); match(2);
			setState(373);
			((PropertyContext)_localctx).met = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==RESOURCE || _la==Identifier) ) {
				((PropertyContext)_localctx).met = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(376);
			_la = _input.LA(1);
			if (_la==ASSIG) {
				{
				setState(374); match(ASSIG);
				setState(375); ((PropertyContext)_localctx).value = expression(0);
				}
			}

			setState(378); match(3);
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
		enterRule(_localctx, 72, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_la = _input.LA(1);
			if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (EXACTLY_ONE - 82)) | (1L << (ONE_OR_MORE - 82)) | (1L << (ALL - 82)))) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); match(CA);
			setState(383);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(384); match(4);
			setState(385);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(386); match(CC);
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
		int _startState = 76;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new AssigExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(389); match(Identifier);
				setState(390); match(ASSIG);
				setState(391); expression(17);
				}
				break;

			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(392); match(NOT);
				setState(393); expression(16);
				}
				break;

			case 3:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(394); match(PA);
				setState(395); expression(0);
				setState(396); match(PC);
				}
				break;

			case 4:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(398); list();
				}
				break;

			case 5:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(399); array();
				}
				break;

			case 6:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(400); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(446);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(444);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(403);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(404);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(405); expression(16);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(406);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(407);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUBTRACT) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(408); expression(15);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(409);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(410);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (LT - 96)) | (1L << (GT - 96)) | (1L << (LTE - 96)) | (1L << (GTE - 96)))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(411); expression(14);
						}
						break;

					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(412);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(413);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(414); expression(13);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(415);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(416); match(AND);
						setState(417); expression(12);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(418);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(419); match(OR);
						setState(420); expression(11);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(421);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(422);
						_la = _input.LA(1);
						if ( !(_la==IMPLIES || _la==REQUIRES) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(423); expression(10);
						}
						break;

					case 8:
						{
						_localctx = new IffExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(424);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(425); match(IFF);
						setState(426); expression(9);
						}
						break;

					case 9:
						{
						_localctx = new ExcludesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(427);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(428); match(EXCLUDES);
						setState(429); expression(8);
						}
						break;

					case 10:
						{
						_localctx = new DuringExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(430);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(431); match(IN);
						setState(432); ((DuringExprContext)_localctx).state = expression(0);
						setState(433); ((DuringExprContext)_localctx).op = match(BY);
						setState(434); ((DuringExprContext)_localctx).dur = expression(0);
						setState(435); ((DuringExprContext)_localctx).durInt = duringInterval();
						}
						break;

					case 11:
						{
						_localctx = new FreqExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(438); match(IN);
						setState(439); ((FreqExprContext)_localctx).state = expression(0);
						setState(440);
						((FreqExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (LT - 96)) | (1L << (GT - 96)) | (1L << (EQ - 96)) | (1L << (LTE - 96)) | (1L << (GTE - 96)))) != 0)) ) {
							((FreqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(441); ((FreqExprContext)_localctx).ntimes = expression(0);
						setState(442); ((FreqExprContext)_localctx).compInt = compensationsInterval();
						}
						break;
					}
					} 
				}
				setState(448);
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
		enterRule(_localctx, 78, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449); match(CA);
			setState(450); ((ListContext)_localctx).l1 = args();
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(451); match(1);
				setState(452); ((ListContext)_localctx).l2 = args();
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(458); match(CC);
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
		enterRule(_localctx, 80, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); match(LLA);
			setState(461); ((ArrayContext)_localctx).l1 = args();
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(462); match(1);
				setState(463); ((ArrayContext)_localctx).l2 = args();
				}
				}
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(469); match(LLC);
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
		enterRule(_localctx, 82, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			((ArgsContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (Identifier - 105)) | (1L << (Integer - 105)) | (1L << (S_Integer - 105)) | (1L << (Float - 105)) | (1L << (S_Float - 105)) | (1L << (String - 105)))) != 0)) ) {
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
		enterRule(_localctx, 84, RULE_atom);
		int _la;
		try {
			setState(481);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				_la = _input.LA(1);
				if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (Integer - 106)) | (1L << (S_Integer - 106)) | (1L << (Float - 106)) | (1L << (S_Float - 106)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 2:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
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
				setState(475); ((ArrayAtomContext)_localctx).id = match(Identifier);
				setState(476); match(CA);
				setState(477); ((ArrayAtomContext)_localctx).value = match(String);
				setState(478); match(CC);
				}
				break;

			case 4:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(479); match(Identifier);
				}
				break;

			case 5:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(480); match(String);
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
		case 38: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3z\u01e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2b\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\6\3\6\5\6\u0085\n\6\3"+
		"\7\7\7\u0088\n\7\f\7\16\7\u008b\13\7\3\7\3\7\3\b\3\b\3\b\5\b\u0092\n\b"+
		"\3\t\3\t\3\t\5\t\u0097\n\t\3\t\5\t\u009a\n\t\3\n\3\n\6\n\u009e\n\n\r\n"+
		"\16\n\u009f\3\13\3\13\3\13\3\13\3\13\5\13\u00a7\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00ae\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bc"+
		"\n\r\3\16\3\16\3\16\6\16\u00c1\n\16\r\16\16\16\u00c2\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u00ca\n\17\3\17\3\17\3\17\5\17\u00cf\n\17\3\17\3\17\5\17"+
		"\u00d3\n\17\3\17\5\17\u00d6\n\17\5\17\u00d8\n\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\5\20\u00e0\n\20\3\20\5\20\u00e3\n\20\3\20\3\20\7\20\u00e7\n\20"+
		"\f\20\16\20\u00ea\13\20\3\21\3\21\3\21\7\21\u00ef\n\21\f\21\16\21\u00f2"+
		"\13\21\3\22\3\22\3\22\7\22\u00f7\n\22\f\22\16\22\u00fa\13\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u0103\n\23\f\23\16\23\u0106\13\23\3\23"+
		"\5\23\u0109\n\23\3\24\3\24\6\24\u010d\n\24\r\24\16\24\u010e\3\25\3\25"+
		"\3\25\3\25\3\25\6\25\u0116\n\25\r\25\16\25\u0117\3\26\3\26\5\26\u011c"+
		"\n\26\3\26\5\26\u011f\n\26\3\26\7\26\u0122\n\26\f\26\16\26\u0125\13\26"+
		"\3\27\3\27\3\27\7\27\u012a\n\27\f\27\16\27\u012d\13\27\3\30\3\30\3\30"+
		"\3\30\6\30\u0133\n\30\r\30\16\30\u0134\3\31\3\31\7\31\u0139\n\31\f\31"+
		"\16\31\u013c\13\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0147"+
		"\n\33\3\33\5\33\u014a\n\33\3\33\7\33\u014d\n\33\f\33\16\33\u0150\13\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\6\37\u0162\n\37\r\37\16\37\u0163\3\37\3\37\3 \3 \3 \3 \3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\5%\u017b\n%\3%\3%\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0194\n"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u01bf\n(\f"+
		"(\16(\u01c2\13(\3)\3)\3)\3)\7)\u01c8\n)\f)\16)\u01cb\13)\3)\3)\3*\3*\3"+
		"*\3*\7*\u01d3\n*\f*\16*\u01d6\13*\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\5,\u01e4\n,\3,\2-\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTV\2\30\4\2kkww\3\2\r\16\3\2(,\3\2#$\3\2CD\3\2"+
		"\65;\3\2<B\4\2nnrr\4\2qqww\4\2kkuu\5\2((MMkk\3\2TV\3\2lm\3\2`a\3\2^_\4"+
		"\2bcfg\3\2de\3\2Z[\4\2bdfg\4\2koww\3\2lo\3\2/\60\u01f9\2a\3\2\2\2\4c\3"+
		"\2\2\2\6i\3\2\2\2\bv\3\2\2\2\n\177\3\2\2\2\f\u0089\3\2\2\2\16\u0091\3"+
		"\2\2\2\20\u0093\3\2\2\2\22\u009b\3\2\2\2\24\u00a1\3\2\2\2\26\u00a8\3\2"+
		"\2\2\30\u00bb\3\2\2\2\32\u00bd\3\2\2\2\34\u00c4\3\2\2\2\36\u00db\3\2\2"+
		"\2 \u00eb\3\2\2\2\"\u00f3\3\2\2\2$\u00fd\3\2\2\2&\u010a\3\2\2\2(\u0110"+
		"\3\2\2\2*\u0119\3\2\2\2,\u0126\3\2\2\2.\u012e\3\2\2\2\60\u0136\3\2\2\2"+
		"\62\u013d\3\2\2\2\64\u0141\3\2\2\2\66\u0151\3\2\2\28\u0153\3\2\2\2:\u0157"+
		"\3\2\2\2<\u015d\3\2\2\2>\u0167\3\2\2\2@\u016d\3\2\2\2B\u016f\3\2\2\2D"+
		"\u0171\3\2\2\2F\u0173\3\2\2\2H\u0175\3\2\2\2J\u017e\3\2\2\2L\u0180\3\2"+
		"\2\2N\u0193\3\2\2\2P\u01c3\3\2\2\2R\u01ce\3\2\2\2T\u01d9\3\2\2\2V\u01e3"+
		"\3\2\2\2XY\5\4\3\2YZ\7\b\2\2Zb\3\2\2\2[\\\5\6\4\2\\]\7\n\2\2]b\3\2\2\2"+
		"^_\5\b\5\2_`\7\f\2\2`b\3\2\2\2aX\3\2\2\2a[\3\2\2\2a^\3\2\2\2b\3\3\2\2"+
		"\2cd\7\7\2\2de\7k\2\2ef\7%\2\2fg\5D#\2gh\5\n\6\2h\5\3\2\2\2ij\7\t\2\2"+
		"jk\7k\2\2kl\7%\2\2lm\5D#\2mo\7I\2\2np\7\7\2\2on\3\2\2\2op\3\2\2\2pq\3"+
		"\2\2\2qr\7k\2\2rs\7%\2\2st\5D#\2tu\5\f\7\2u\7\3\2\2\2vw\7\13\2\2wx\7k"+
		"\2\2xy\7%\2\2yz\5D#\2z{\5\f\7\2{\t\3\2\2\2|~\5\16\b\2}|\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0082\u0084\5\20\t\2\u0083\u0085\5\22\n\2\u0084\u0083\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\13\3\2\2\2\u0086\u0088\5\16\b\2\u0087\u0086"+
		"\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\5\20\t\2\u008d\r\3\2\2"+
		"\2\u008e\u0092\5\26\f\2\u008f\u0092\5\30\r\2\u0090\u0092\5\32\16\2\u0091"+
		"\u008e\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\17\3\2\2"+
		"\2\u0093\u0094\7\26\2\2\u0094\u0096\5\36\20\2\u0095\u0097\5*\26\2\u0096"+
		"\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u009a\5\60"+
		"\31\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\21\3\2\2\2\u009b\u009d"+
		"\7\27\2\2\u009c\u009e\5\24\13\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2"+
		"\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\23\3\2\2\2\u00a1\u00a2"+
		"\7k\2\2\u00a2\u00a3\7\4\2\2\u00a3\u00a4\5N(\2\u00a4\u00a6\7\5\2\2\u00a5"+
		"\u00a7\5:\36\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\25\3\2\2"+
		"\2\u00a8\u00a9\7E\2\2\u00a9\u00aa\7G\2\2\u00aa\u00ad\t\2\2\2\u00ab\u00ac"+
		"\7 \2\2\u00ac\u00ae\5F$\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\7\5\2\2\u00b0\27\3\2\2\2\u00b1\u00b2\7#\2\2"+
		"\u00b2\u00b3\t\2\2\2\u00b3\u00b4\7J\2\2\u00b4\u00b5\t\3\2\2\u00b5\u00bc"+
		"\7\5\2\2\u00b6\u00b7\7$\2\2\u00b7\u00b8\t\2\2\2\u00b8\u00b9\7J\2\2\u00b9"+
		"\u00ba\t\3\2\2\u00ba\u00bc\7\5\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00b6\3\2"+
		"\2\2\u00bc\31\3\2\2\2\u00bd\u00be\7\25\2\2\u00be\u00c0\7\4\2\2\u00bf\u00c1"+
		"\5\34\17\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2"+
		"\u00c2\u00c3\3\2\2\2\u00c3\33\3\2\2\2\u00c4\u00c5\7k\2\2\u00c5\u00d7\7"+
		"\4\2\2\u00c6\u00c9\7-\2\2\u00c7\u00ca\5P)\2\u00c8\u00ca\5R*\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00d8\3\2\2\2\u00cb\u00ce\7.\2\2\u00cc"+
		"\u00cf\5P)\2\u00cd\u00cf\5R*\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2"+
		"\u00cf\u00d8\3\2\2\2\u00d0\u00d2\t\4\2\2\u00d1\u00d3\5L\'\2\u00d2\u00d1"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d6\5P)\2\u00d5"+
		"\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00c6\3\2"+
		"\2\2\u00d7\u00cb\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\7\5\2\2\u00da\35\3\2\2\2\u00db\u00dc\7\31\2\2\u00dc\u00df\7k\2"+
		"\2\u00dd\u00de\7 \2\2\u00de\u00e0\5F$\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00e3\5 \21\2\u00e2\u00e1\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e8\5&\24\2\u00e5\u00e7\5("+
		"\25\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\37\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7\32\2"+
		"\2\u00ec\u00f0\7\4\2\2\u00ed\u00ef\5\"\22\2\u00ee\u00ed\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1!\3\2\2\2"+
		"\u00f2\u00f0\3\2\2\2\u00f3\u00f8\5$\23\2\u00f4\u00f5\7\3\2\2\u00f5\u00f7"+
		"\5$\23\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\5"+
		"\2\2\u00fc#\3\2\2\2\u00fd\u0108\7k\2\2\u00fe\u00ff\7P\2\2\u00ff\u0104"+
		"\7k\2\2\u0100\u0101\7\3\2\2\u0101\u0103\7k\2\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2"+
		"\2\2\u0106\u0104\3\2\2\2\u0107\u0109\7Q\2\2\u0108\u00fe\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109%\3\2\2\2\u010a\u010c\7\33\2\2\u010b\u010d\5H%\2\u010c"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\'\3\2\2\2\u0110\u0111\7\34\2\2\u0111\u0112\7I\2\2\u0112\u0113"+
		"\7k\2\2\u0113\u0115\7\4\2\2\u0114\u0116\5H%\2\u0115\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118)\3\2\2\2"+
		"\u0119\u011b\7\36\2\2\u011a\u011c\7k\2\2\u011b\u011a\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011f\5,\27\2\u011e\u011d\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0123\3\2\2\2\u0120\u0122\5.\30\2\u0121\u0120\3\2"+
		"\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"+\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7\35\2\2\u0127\u012b\7\4\2\2"+
		"\u0128\u012a\5H%\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129"+
		"\3\2\2\2\u012b\u012c\3\2\2\2\u012c-\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"\u012f\7I\2\2\u012f\u0130\7k\2\2\u0130\u0132\7\4\2\2\u0131\u0133\5H%\2"+
		"\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135/\3\2\2\2\u0136\u013a\7\30\2\2\u0137\u0139\5\62\32\2\u0138"+
		"\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013b\61\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\7k\2\2\u013e\u013f"+
		"\7\4\2\2\u013f\u0140\5\64\33\2\u0140\63\3\2\2\2\u0141\u0142\t\5\2\2\u0142"+
		"\u0143\7\37\2\2\u0143\u0144\5\66\34\2\u0144\u0146\7\5\2\2\u0145\u0147"+
		"\58\35\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u014a\5:\36\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014e\3\2"+
		"\2\2\u014b\u014d\5<\37\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\65\3\2\2\2\u0150\u014e\3\2\2"+
		"\2\u0151\u0152\5N(\2\u0152\67\3\2\2\2\u0153\u0154\7j\2\2\u0154\u0155\7"+
		"k\2\2\u0155\u0156\7\5\2\2\u01569\3\2\2\2\u0157\u0158\7\64\2\2\u0158\u0159"+
		"\7P\2\2\u0159\u015a\5N(\2\u015a\u015b\7Q\2\2\u015b\u015c\7\5\2\2\u015c"+
		";\3\2\2\2\u015d\u015e\7\61\2\2\u015e\u015f\5@!\2\u015f\u0161\t\6\2\2\u0160"+
		"\u0162\5> \2\u0161\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0161\3\2\2"+
		"\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\7\62\2\2\u0166"+
		"=\3\2\2\2\u0167\u0168\7H\2\2\u0168\u0169\5N(\2\u0169\u016a\7\63\2\2\u016a"+
		"\u016b\5N(\2\u016b\u016c\7\5\2\2\u016c?\3\2\2\2\u016d\u016e\t\7\2\2\u016e"+
		"A\3\2\2\2\u016f\u0170\t\b\2\2\u0170C\3\2\2\2\u0171\u0172\t\t\2\2\u0172"+
		"E\3\2\2\2\u0173\u0174\t\n\2\2\u0174G\3\2\2\2\u0175\u0176\t\13\2\2\u0176"+
		"\u0177\7\4\2\2\u0177\u017a\t\f\2\2\u0178\u0179\7h\2\2\u0179\u017b\5N("+
		"\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d"+
		"\7\5\2\2\u017dI\3\2\2\2\u017e\u017f\t\r\2\2\u017fK\3\2\2\2\u0180\u0181"+
		"\7N\2\2\u0181\u0182\t\16\2\2\u0182\u0183\7\6\2\2\u0183\u0184\t\16\2\2"+
		"\u0184\u0185\7O\2\2\u0185M\3\2\2\2\u0186\u0187\b(\1\2\u0187\u0188\7k\2"+
		"\2\u0188\u0189\7h\2\2\u0189\u0194\5N(\2\u018a\u018b\7Y\2\2\u018b\u0194"+
		"\5N(\2\u018c\u018d\7P\2\2\u018d\u018e\5N(\2\u018e\u018f\7Q\2\2\u018f\u0194"+
		"\3\2\2\2\u0190\u0194\5P)\2\u0191\u0194\5R*\2\u0192\u0194\5V,\2\u0193\u0186"+
		"\3\2\2\2\u0193\u018a\3\2\2\2\u0193\u018c\3\2\2\2\u0193\u0190\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0194\u01c0\3\2\2\2\u0195\u0196\6("+
		"\2\3\u0196\u0197\t\17\2\2\u0197\u01bf\5N(\2\u0198\u0199\6(\3\3\u0199\u019a"+
		"\t\20\2\2\u019a\u01bf\5N(\2\u019b\u019c\6(\4\3\u019c\u019d\t\21\2\2\u019d"+
		"\u01bf\5N(\2\u019e\u019f\6(\5\3\u019f\u01a0\t\22\2\2\u01a0\u01bf\5N(\2"+
		"\u01a1\u01a2\6(\6\3\u01a2\u01a3\7W\2\2\u01a3\u01bf\5N(\2\u01a4\u01a5\6"+
		"(\7\3\u01a5\u01a6\7X\2\2\u01a6\u01bf\5N(\2\u01a7\u01a8\6(\b\3\u01a8\u01a9"+
		"\t\23\2\2\u01a9\u01bf\5N(\2\u01aa\u01ab\6(\t\3\u01ab\u01ac\7\\\2\2\u01ac"+
		"\u01bf\5N(\2\u01ad\u01ae\6(\n\3\u01ae\u01af\7]\2\2\u01af\u01bf\5N(\2\u01b0"+
		"\u01b1\6(\13\3\u01b1\u01b2\7K\2\2\u01b2\u01b3\5N(\2\u01b3\u01b4\7L\2\2"+
		"\u01b4\u01b5\5N(\2\u01b5\u01b6\5B\"\2\u01b6\u01bf\3\2\2\2\u01b7\u01b8"+
		"\6(\f\3\u01b8\u01b9\7K\2\2\u01b9\u01ba\5N(\2\u01ba\u01bb\t\24\2\2\u01bb"+
		"\u01bc\5N(\2\u01bc\u01bd\5@!\2\u01bd\u01bf\3\2\2\2\u01be\u0195\3\2\2\2"+
		"\u01be\u0198\3\2\2\2\u01be\u019b\3\2\2\2\u01be\u019e\3\2\2\2\u01be\u01a1"+
		"\3\2\2\2\u01be\u01a4\3\2\2\2\u01be\u01a7\3\2\2\2\u01be\u01aa\3\2\2\2\u01be"+
		"\u01ad\3\2\2\2\u01be\u01b0\3\2\2\2\u01be\u01b7\3\2\2\2\u01bf\u01c2\3\2"+
		"\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1O\3\2\2\2\u01c2\u01c0"+
		"\3\2\2\2\u01c3\u01c4\7N\2\2\u01c4\u01c9\5T+\2\u01c5\u01c6\7\3\2\2\u01c6"+
		"\u01c8\5T+\2\u01c7\u01c5\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd"+
		"\7O\2\2\u01cdQ\3\2\2\2\u01ce\u01cf\7R\2\2\u01cf\u01d4\5T+\2\u01d0\u01d1"+
		"\7\3\2\2\u01d1\u01d3\5T+\2\u01d2\u01d0\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4"+
		"\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d4\3\2"+
		"\2\2\u01d7\u01d8\7S\2\2\u01d8S\3\2\2\2\u01d9\u01da\t\25\2\2\u01daU\3\2"+
		"\2\2\u01db\u01e4\t\26\2\2\u01dc\u01e4\t\27\2\2\u01dd\u01de\7k\2\2\u01de"+
		"\u01df\7N\2\2\u01df\u01e0\7w\2\2\u01e0\u01e4\7O\2\2\u01e1\u01e4\7k\2\2"+
		"\u01e2\u01e4\7w\2\2\u01e3\u01db\3\2\2\2\u01e3\u01dc\3\2\2\2\u01e3\u01dd"+
		"\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e2\3\2\2\2\u01e4W\3\2\2\2.ao\177"+
		"\u0084\u0089\u0091\u0096\u0099\u009f\u00a6\u00ad\u00bb\u00c2\u00c9\u00ce"+
		"\u00d2\u00d5\u00d7\u00df\u00e2\u00e8\u00f0\u00f8\u0104\u0108\u010e\u0117"+
		"\u011b\u011e\u0123\u012b\u0134\u013a\u0146\u0149\u014e\u0163\u017a\u0193"+
		"\u01be\u01c0\u01c9\u01d4\u01e3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}