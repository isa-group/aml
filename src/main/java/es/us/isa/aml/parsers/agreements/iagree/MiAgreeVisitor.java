/**
 *
 */
package es.us.isa.aml.parsers.agreements.iagree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.Compensation.AssessmentInterval;
import es.us.isa.aml.model.Compensation.CompensationType;
import es.us.isa.aml.model.CompensationElement;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Feature;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.QualifyingCondition;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.ServiceRole;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.AssignmentExpression;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.ListExpression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.AdditiveExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.AgreementContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.AndExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ArgsContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ArrayAtomContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ArrayContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ArrayExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.AssigExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.AtomExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.BooleanAtomContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CompensationContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CompensationElementContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CompensationsIntervalContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Consumer_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Context_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CuantifContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.EqualityExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ExcludesExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ExpressionContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.FeatureContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Feature_operationContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.FeaturesContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.IdAtomContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.IffExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ImpliesExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ListExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.LocalDescriptionContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Local_MonitorablePropertiesContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.MultiplicationExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.NotExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.NumberAtomContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.OrExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ParExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.PartiesRoles_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Provider_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.QualifyingConditionContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.RelationalExprContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ServiceProvider_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.StringAtomContext;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class MiAgreeVisitor implements iAgreeVisitor<Object> {

	private iAgreeParser parser;
	public AgreementModel model;
	public long timeStamp;

	public MiAgreeVisitor(iAgreeParser parser) {
		this.parser = parser;
	}

	@Override
	public AgreementModel visitEntry(iAgreeParser.EntryContext ctx) {

		try {
			this.timeStamp = Calendar.getInstance().getTimeInMillis();

			Context context = new Context();

			if (ctx.template() != null) {
				this.model = new AgreementTemplate();
				model.setDocType(DocType.TEMPLATE);
				model.setContext(context);
				this.visitTemplate(ctx.template());
			} else if (ctx.agOffer() != null) {
				this.model = new AgreementOffer();
				model.setDocType(DocType.OFFER);
				model.setContext(context);
				this.visitAgOffer(ctx.agOffer());
			} else if (ctx.agreement() != null) {
				this.model = new Agreement();
				model.setDocType(DocType.AGREEMENT);
				model.setContext(context);
				this.visitAgreement(ctx.agreement());
			}
		} catch (Exception e) {
			this.model = null;
			throw new IllegalArgumentException(
					"There was an error parsing the file. "
							+ "Please, check the syntax of the document.");

		}

		return this.model;
	}

	@Override
	public Object visitTemplate(iAgreeParser.TemplateContext ctx) {

		this.model.setID(ctx.id.getText());
		this.model.setVersion(Double.valueOf(ctx.version.getText()));

		this.visitTemplate_def(ctx.template_def());

		return null;
	}

	@Override
	public Object visitAgOffer(iAgreeParser.AgOfferContext ctx) {

		this.model.setID(ctx.id.getText());
		this.model.setVersion(Double.valueOf(ctx.version.getText()));

		this.model.getContext().setTemplateId(ctx.templateId.getText());
		this.model.getContext().setTemplateVersion(
				Double.valueOf(ctx.templateVersion.getText()));

		this.visitAg_def(ctx.ag_def());

		return null;
	}

	@Override
	public Object visitAgreement(AgreementContext ctx) {
		this.model.setID(ctx.id.getText());
		this.model.setVersion(Double.valueOf(ctx.version.getText()));

		this.visitAg_def(ctx.ag_def());
		return null;
	}

	@Override
	public Object visitTemplate_def(iAgreeParser.Template_defContext ctx) {

		for (iAgreeParser.Temp_propertiesContext tempCtx : ctx
				.temp_properties()) {
			this.visitTemp_properties(tempCtx);
		}

		this.visitAgreementTerms(ctx.agreementTerms());

		if (ctx.creationConstraints() != null)
			this.visitCreationConstraints(ctx.creationConstraints());

		return null;
	}

	@Override
	public Object visitAg_def(iAgreeParser.Ag_defContext ctx) {

		for (iAgreeParser.Temp_propertiesContext tp : ctx.temp_properties()) {
			this.visitTemp_properties(tp);
		}

		this.visitAgreementTerms(ctx.agreementTerms());

		return null;
	}

	@Override
	public Object visitAgreementTerms(iAgreeParser.AgreementTermsContext ctx) {

		AgreementTerms at = new AgreementTerms();
		this.model.setAgreementTerms(at);

		this.visitService(ctx.service());

		if (ctx.monitorableProperties() != null)
			this.visitMonitorableProperties(ctx.monitorableProperties());

		if (ctx.guaranteeTerms() != null)
			this.visitGuaranteeTerms(ctx.guaranteeTerms());

		return null;
	}

	@Override
	public Object visitCreationConstraints(
			iAgreeParser.CreationConstraintsContext ctx) {

		for (iAgreeParser.CreationConstraintContext cc : ctx
				.creationConstraint()) {
			this.visitCreationConstraint(cc);
		}

		return null;
	}

	@Override
	public Object visitCreationConstraint(
			iAgreeParser.CreationConstraintContext ctx) {

		Expression exp = this.visitExpression(ctx.expression());
		SLO slo = new SLO(exp);
		CreationConstraint cc = new CreationConstraint(ctx.Identifier()
				.getText(), slo);

		if (ctx.qualifyingCondition() != null) {
			QualifyingCondition qc = visitQualifyingCondition(ctx
					.qualifyingCondition());
			cc.setQc(qc);
		}

		((AgreementTemplate) this.model).getCreationConstraints().put(
				cc.getId(), cc);

		return null;
	}

	@Override
	public Object visitService(iAgreeParser.ServiceContext ctx) {

		ServiceConfiguration service = new ServiceConfiguration();
		model.getAgreementTerms().setService(service);
		model.getAgreementTerms().getService()
				.setServiceName(ctx.Identifier().getText());

		if (ctx.AVAL_AT() != null) {
			model.getAgreementTerms()
					.getService()
					.setEndpointReference(
							Util.withoutDoubleQuotes(ctx.endpointUrl.getText()));
		}

		if (ctx.DEFINED_AT() != null) {
			model.getAgreementTerms()
					.getService()
					.setDefinitionReference(
							Util.withoutDoubleQuotes(ctx.definitionUrl
									.getText()));
		}

		if (ctx.MONITORED_AT() != null) {
			model.getAgreementTerms()
					.getService()
					.setMonitorReference(
							Util.withoutDoubleQuotes(ctx.monitorUrl.getText()));
		}

		if (ctx.features() != null) {
			visitFeatures(ctx.features());
		}

		this.visitGlobalDescription(ctx.globalDescription());
		for (LocalDescriptionContext desc : ctx.localDescription()) {
			this.visitLocalDescription(desc);
		}

		return null;
	}

	@Override
	public Object visitFeatures(FeaturesContext ctx) {
		for (FeatureContext _ctx : ctx.feature()) {
			visitFeature(_ctx);
		}
		return null;
	}

	@Override
	public Object visitFeature(FeatureContext ctx) {
		for (Feature_operationContext _ctx : ctx.feature_operation()) {
			Feature feature = visitFeature_operation(_ctx);
			model.getAgreementTerms().getService().getFeatures()
					.put(feature.getId(), feature);
		}
		return null;
	}

	@Override
	public Feature visitFeature_operation(Feature_operationContext ctx) {
		Feature feature = new Feature();
		feature.setId(ctx.id.getText());
		List<String> parameters = new ArrayList<String>();
		for (TerminalNode param : ctx.Identifier()) {
			if (!param.getText().equals(ctx.id.getText())) {
				parameters.add(param.getText());
			}
		}
		feature.setParameters(parameters);
		return feature;
	}

	@Override
	public Object visitTemp_properties(iAgreeParser.Temp_propertiesContext ctx) {

		if (ctx.context_prop() != null) {
			visitContext_prop(ctx.context_prop());
		} else if (ctx.initiator_prop() != null) {
			visitInitiator_prop(ctx.initiator_prop());
		} else if (ctx.partiesRoles_prop() != null) {
			visitPartiesRoles_prop(ctx.partiesRoles_prop());
		} else if (ctx.serviceProvider_prop() != null) {
			visitServiceProvider_prop(ctx.serviceProvider_prop());
		} else if (ctx.expirationTime_prop() != null) {
			// TODO Definir temporalidad

		} else if (ctx.dateFormat_prop() != null) {
			// TODO Definir temporalidad

		} else if (ctx.gmtZone_prop() != null) {
			if (ctx.gmtZone_prop().S_Integer() != null) {

				// TODO Definir temporalidad
				ctx.gmtZone_prop().S_Integer().getText();

			} else if (ctx.gmtZone_prop().Integer() != null) {

				// TODO Definir temporalidad
				ctx.gmtZone_prop().Integer().getText();

			}
		} else if (ctx.globalPeriod_prop() != null) {
			// TODO Definir temporalidad

		} else if (ctx.definedPeriod_prop() != null) {
			// TODO Definir temporalidad

		} else if (ctx.metrics_prop() != null) {

			// TODO implementar metricas
			this.visitMetrics_prop(ctx.metrics_prop());

		}

		return null;
	}

	@Override
	public Object visitContext_prop(Context_propContext ctx) {
		if (ctx.FROM() != null)
			this.model.getContext().setTemplateId(ctx.id.getText());
		// if(ctx.ON() != null)
		// TODO Agregar propiedad 'fecha de creación' al agreement
		return null;
	}

	@Override
	public Object visitInitiator_prop(iAgreeParser.Initiator_propContext ctx) {
		String initiator = Util.withoutDoubleQuotes(ctx.String().getText());
		this.model.getContext().setInitiator(initiator);
		return null;
	}

	@Override
	public Object visitPartiesRoles_prop(PartiesRoles_propContext ctx) {
		Responder r = null;

		if (ctx.responder != null) {
			if (ServiceRole.valueOf(ctx.responder.getText()) == ServiceRole.Provider) {
				r = new Responder(ctx.id.getText(), ServiceRole.Provider);
			} else if (ServiceRole.valueOf(ctx.responder.getText()) == ServiceRole.Consumer) {
				r = new Responder(ctx.id.getText(), ServiceRole.Consumer);
			}
		} else {
			if (ctx.provider_prop() != null) {
				visitProvider_prop(ctx.provider_prop());
			} else if (ctx.consumer_prop() != null) {
				visitConsumer_prop(ctx.consumer_prop());
			}
		}

		if (r != null) {
			this.model.getContext().setResponder(r);
		}

		return null;
	}

	@Override
	public Object visitProvider_prop(Provider_propContext ctx) {
		this.model.getContext().setProvider(ctx.id.getText());
		return null;
	}

	@Override
	public Object visitConsumer_prop(Consumer_propContext ctx) {
		this.model.getContext().setConsumer(ctx.id.getText());
		return null;
	}

	@Override
	public Object visitServiceProvider_prop(ServiceProvider_propContext ctx) {
		this.model.getContext().setServiceProvider(
				Util.withoutDoubleQuotes(ctx.String().getText()));
		return null;
	}

	@Override
	public Object visitMonitorableProperties(
			iAgreeParser.MonitorablePropertiesContext ctx) {

		if (ctx.global_MonitorableProperties() != null) {
			this.visitGlobal_MonitorableProperties(ctx
					.global_MonitorableProperties());
		}

		if (ctx.local_MonitorableProperties() != null) {
			for (Local_MonitorablePropertiesContext _ctx : ctx
					.local_MonitorableProperties()) {
				visitLocal_MonitorableProperties(_ctx);
			}
		}

		return null;
	}

	@Override
	public Object visitGuaranteeTerms(iAgreeParser.GuaranteeTermsContext ctx) {

		for (iAgreeParser.GuaranteeTermContext GT : ctx.guaranteeTerm()) {
			this.visitGuaranteeTerm(GT);
		}

		return null;
	}

	@Override
	public Object visitGlobalDescription(
			iAgreeParser.GlobalDescriptionContext ctx) {

		for (iAgreeParser.PropertyContext prop : ctx.property()) {
			Property p = this.visitProperty(prop);
			if (prop.MONITORED_AT() != null) {
				parser.notifyErrorListeners(
						prop.start,
						"Monitoring is not allowed for service description properties.",
						null);
			} else {
				if (p != null) {
					ConfigurationProperty cp = new ConfigurationProperty(
							p.getId(), p.getMetric());
					cp.setExpression(p.getExpression());
					cp.setScope(Scope.Global);
					this.model.getAgreementTerms().getService()
							.getConfigurationProperties().put(cp.getId(), cp);
				}
			}
		}

		return null;
	}

	@Override
	public Object visitLocalDescription(LocalDescriptionContext ctx) {
		for (iAgreeParser.PropertyContext prop : ctx.property()) {
			Property p = this.visitProperty(prop);
			if (p != null) {
				ConfigurationProperty cp = new ConfigurationProperty(p.getId(),
						p.getMetric());
				cp.setExpression(p.getExpression());
				cp.setScope(Scope.Local);

				Map<String, Feature> features = model.getAgreementTerms()
						.getService().getFeatures();
				if (features.containsKey(ctx.Identifier().getText())) {
					cp.setFeature(features.get(ctx.Identifier().getText()));
					this.model.getAgreementTerms().getService()
							.getConfigurationProperties().put(cp.getId(), cp);
				} else {
					parser.notifyErrorListeners(ctx.start, "Feature \""
							+ ctx.Identifier().getText()
							+ "\" has not been declared.", null);
				}
			}
		}

		return null;
	}

	@Override
	public Object visitGlobal_MonitorableProperties(
			iAgreeParser.Global_MonitorablePropertiesContext ctx) {

		for (iAgreeParser.PropertyContext prop : ctx.property()) {
			Property p = this.visitProperty(prop);
			if (p != null) {
				MonitorableProperty mp = new MonitorableProperty(p.getId(),
						p.getMetric());
				mp.setExpression(p.getExpression());
				mp.setScope(Scope.Global);
				this.model.getAgreementTerms().getMonitorableProperties()
						.put(mp.getId(), mp);
			}
		}

		return null;
	}

	@Override
	public Object visitLocal_MonitorableProperties(
			Local_MonitorablePropertiesContext ctx) {

		for (iAgreeParser.PropertyContext prop : ctx.property()) {
			Property p = this.visitProperty(prop);
			if (p != null) {
				MonitorableProperty mp = new MonitorableProperty(p.getId(),
						p.getMetric());
				mp.setExpression(p.getExpression());
				mp.setScope(Scope.Local);

				Map<String, Feature> features = model.getAgreementTerms()
						.getService().getFeatures();
				if (features.containsKey(ctx.Identifier().getText())) {
					mp.setFeature(features.get(ctx.Identifier().getText()));
					this.model.getAgreementTerms().getMonitorableProperties()
							.put(mp.getId(), mp);
				} else {
					parser.notifyErrorListeners(ctx.start, "Feature \""
							+ ctx.Identifier().getText()
							+ "\" has not been declared.", null);
				}
			}
		}

		return null;
	}

	@Override
	public Object visitGuaranteeTerm(iAgreeParser.GuaranteeTermContext ctx) {
		if (ctx.guarantee_def() != null) {
			GuaranteeTerm GT = this.visitGuarantee_def(ctx.guarantee_def());
			GT.setId(ctx.Identifier().getText());
			this.model.getAgreementTerms().getGuaranteeTerms()
					.put(GT.getId(), GT);
		} else if (ctx.cuantif() != null) {
			// TODO
		}
		return null;
	}

	@Override
	public GuaranteeTerm visitGuarantee_def(
			iAgreeParser.Guarantee_defContext ctx) {

		Expression exp = this.visitSlo(ctx.slo());

		SLO slo = new SLO(exp);
		ServiceRole actor = ServiceRole.valueOf(ctx.ob.getText());

		GuaranteeTerm GT = new GuaranteeTerm("", actor, slo);

		if (ctx.serviceScope() != null) {
			String serviceScope = visitServiceScope(ctx.serviceScope());
			GT.setServiceScope(serviceScope);
		}

		if (ctx.qualifyingCondition() != null) {
			QualifyingCondition qc = visitQualifyingCondition(ctx
					.qualifyingCondition());
			GT.setQc(qc);
		}

		List<Compensation> compensations = new ArrayList<Compensation>();
		for (CompensationContext comp : ctx.compensation()) {
			Compensation c = visitCompensation(comp);
			compensations.add(c);
		}
		GT.setCompensations(compensations);

		return GT;
	}

	@Override
	public Compensation visitCompensation(CompensationContext ctx) {
		Compensation c = new Compensation();

		AssessmentInterval interval = visitCompensationsInterval(ctx.interv);
		CompensationType compType = CompensationType.valueOf(ctx.compType
				.getText().toUpperCase());
		c.setAssessmentInterval(interval);
		c.setCompensationType(compType);

		List<CompensationElement> elements = new ArrayList<CompensationElement>();
		for (CompensationElementContext compElem : ctx.compensationElement()) {
			CompensationElement elem = visitCompensationElement(compElem);
			elements.add(elem);
		}
		c.setElements(elements);

		return c;
	}

	@Override
	public CompensationElement visitCompensationElement(
			CompensationElementContext ctx) {
		Expression exp = visitExpression(ctx.exp);
		Expression condition = visitExpression(ctx.cond);
		CompensationElement elem = new CompensationElement();
		elem.setExpression(exp);
		elem.setCondition(condition);
		return elem;
	}

	@Override
	public Expression visitSlo(iAgreeParser.SloContext ctx) {
		Expression exp = null;
		exp = this.visitExpression(ctx.expression());
		return exp;
	}

	@Override
	public QualifyingCondition visitQualifyingCondition(
			QualifyingConditionContext ctx) {
		Expression exp_qc = visitExpression(ctx.expression());
		QualifyingCondition qc = new QualifyingCondition(exp_qc);
		return qc;
	}

	@Override
	public Property visitProperty(iAgreeParser.PropertyContext ctx) {
		Property p = null;

		String id = ctx.id.getText();
		String metric_id = ctx.met.getText();
		Metric m = model.getContext().getMetrics().get(metric_id);

		if (m != null) {

			p = new Property(id, m);

			if (ctx.DEFINED_AT() != null) {
				p.setDefinitionReference(Util
						.withoutDoubleQuotes(ctx.definitionUrl.getText()));
			}

			if (ctx.MONITORED_AT() != null) {
				p.setMonitorReference(Util.withoutDoubleQuotes(ctx.monitorUrl
						.getText()));
			}

			if (ctx.value != null) {
				Expression expr = this.visitExpression(ctx.expression());
				p.setExpression(expr);
			}

		} else {
			parser.notifyErrorListeners(ctx.start, "Metric \"" + metric_id
					+ "\" has not been declared.", null);
		}

		return p;
	}

	// expr overrides
	public Expression visitExpression(ExpressionContext ctx) {
		Expression res = null;

		switch (ctx.getClass().getSimpleName()) {
		case "AssigExprContext":
			res = this.visitAssigExpr((AssigExprContext) ctx);
			break;
		case "NotExprContext":
			res = this.visitNotExpr((NotExprContext) ctx);
			break;
		case "MultiplicationExprContext":
			res = this.visitMultiplicationExpr((MultiplicationExprContext) ctx);
			break;
		case "AdditiveExprContext":
			res = this.visitAdditiveExpr((AdditiveExprContext) ctx);
			break;
		case "RelationalExprContext":
			res = this.visitRelationalExpr((RelationalExprContext) ctx);
			break;
		case "EqualityExprContext":
			res = this.visitEqualityExpr((EqualityExprContext) ctx);
			break;
		case "AndExprContext":
			res = this.visitAndExpr((AndExprContext) ctx);
			break;
		case "OrExprContext":
			res = this.visitOrExpr((OrExprContext) ctx);
			break;
		case "ImpliesExprContext":
			res = this.visitImpliesExpr((ImpliesExprContext) ctx);
			break;
		case "ExcludesExprContext":
			res = this.visitExcludesExpr((ExcludesExprContext) ctx);
			break;
		case "IffExprContext":
			res = this.visitIffExpr((IffExprContext) ctx);
			break;
		case "ParExprContext":
			res = this.visitParExpr((ParExprContext) ctx);
			break;
		case "ListExprContext":
			res = this.visitListExpr((ListExprContext) ctx);
			break;
		case "ArrayExprContext":
			res = this.visitArrayExpr((ArrayExprContext) ctx);
			break;
		case "AtomExprContext":
			res = this.visitAtomExpr((AtomExprContext) ctx);
			break;
		}

		return res;
	}

	@Override
	public Expression visitAssigExpr(AssigExprContext ctx) {
		Var v = new Var(ctx.Identifier().getText());
		Expression e2 = this.visitExpression(ctx.expression());
		Expression res = new AssignmentExpression(v, e2);
		return res;
	}

	@Override
	public Expression visitNotExpr(NotExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression());
		Expression res = new LogicalExpression(e1, LogicalOperator.NOT);
		return res;
	}

	@Override
	public Expression visitMultiplicationExpr(
			@NotNull MultiplicationExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.MULTIPLY:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.MULTIPLY);
		case iAgreeParser.DIVIDE:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.DIVIDE);
		default:
			throw new RuntimeException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAdditiveExpr(@NotNull AdditiveExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.ADD:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.ADD);
		case iAgreeParser.SUBTRACT:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.SUBTRACT);
		default:
			throw new RuntimeException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitRelationalExpr(@NotNull RelationalExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.LTE:
			return new RelationalExpression(e1, e2, RelationalOperator.LTE);
		case iAgreeParser.GTE:
			return new RelationalExpression(e1, e2, RelationalOperator.GTE);
		case iAgreeParser.LT:
			return new RelationalExpression(e1, e2, RelationalOperator.LT);
		case iAgreeParser.GT:
			return new RelationalExpression(e1, e2, RelationalOperator.GT);
		default:
			throw new RuntimeException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitEqualityExpr(@NotNull EqualityExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.EQ:
			return new RelationalExpression(e1, e2, RelationalOperator.EQ);
		default:
			throw new IllegalArgumentException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAndExpr(AndExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.AND);
	}

	@Override
	public Expression visitOrExpr(OrExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.OR);
	}

	@Override
	public Expression visitImpliesExpr(ImpliesExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
	}

	@Override
	public Expression visitExcludesExpr(ExcludesExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression _e2 = this.visitExpression(ctx.expression(1));
		Expression e2 = new LogicalExpression(_e2, LogicalOperator.NOT);
		return new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
	}

	@Override
	public Expression visitIffExpr(IffExprContext ctx) {
		Expression e1_1 = this.visitExpression(ctx.expression(0));
		Expression e1_2 = this.visitExpression(ctx.expression(1));
		Expression e1 = new LogicalExpression(e1_1, e1_2,
				LogicalOperator.IMPLIES);
		Expression e2 = new LogicalExpression(e1_2, e1_1,
				LogicalOperator.IMPLIES);
		return new LogicalExpression(new ParenthesisExpression(e1),
				new ParenthesisExpression(e2), LogicalOperator.AND);
	}

	@Override
	public Expression visitListExpr(ListExprContext ctx) {
		return visitList(ctx.list());
	}

	@Override
	public Expression visitList(iAgreeParser.ListContext ctx) {
		List<Object> ls = new ArrayList<Object>();
		for (ArgsContext actx : ctx.args()) {
			ls.add(actx.getText());
		}
		return new ListExpression(ls);
	}

	@Override
	public Expression visitArrayExpr(ArrayExprContext ctx) {
		return visitArray(ctx.array());
	}

	@Override
	public Expression visitArray(ArrayContext ctx) {
		Object[] ls = new Object[ctx.args().size()];
		for (int i = 0; i < ctx.args().size(); i++) {
			ls[i] = ctx.args(i);
		}
		return new ListExpression(ls);
	}

	@Override
	public Expression visitAtomExpr(AtomExprContext ctx) {
		Expression res = null;

		switch (ctx.atom().getClass().getSimpleName()) {
		case "NumberAtomContext":
			res = this.visitNumberAtom((NumberAtomContext) ctx.atom());
			break;
		case "BooleanAtomContext":
			res = this.visitBooleanAtom((BooleanAtomContext) ctx.atom());
			break;
		case "ArrayAtomContext":
			res = this.visitArrayAtom((ArrayAtomContext) ctx.atom());
			break;
		case "IdAtomContext":
			res = this.visitIdAtom((IdAtomContext) ctx.atom());
			break;
		case "StringAtomContext":
			res = this.visitStringAtom((StringAtomContext) ctx.atom());
			break;
		}

		return res;
	}

	@Override
	public Expression visitParExpr(ParExprContext ctx) {
		return new ParenthesisExpression(this.visitExpression(ctx.expression()));
	}

	@Override
	public Expression visitNumberAtom(NumberAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Expression visitBooleanAtom(BooleanAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Expression visitArrayAtom(ArrayAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Expression visitIdAtom(IdAtomContext ctx) {
		return new Var(ctx.getText());
	}

	@Override
	public Expression visitStringAtom(StringAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Metric visitMetrics_prop(iAgreeParser.Metrics_propContext ctx) {
		Enumerated en = new Enumerated();
		Object[] ls = new Object[] { true, false };
		en.setValues(ls);
		Metric m = new Metric("boolean", "Boolean", en);

		model.getContext().getMetrics().put(m.getId(), m);

		for (iAgreeParser.MetricContext met : ctx.metric()) {
			this.visitMetric(met);
		}
		return null;
	}

	@Override
	public Object visitMetric(iAgreeParser.MetricContext ctx) {
		Metric m = null;
		String id = ctx.id.getText();
		String type = ctx.type.getText();
		Domain domain = null;
		if (ctx.range() != null) {
			domain = this.visitRange(ctx.range());
		} else if (ctx.list() != null) {
			Enumerated e = new Enumerated();
			List<Object> values = new ArrayList<Object>();
			for (ArgsContext actx : ctx.list().args())
				values.add(actx.getText());
			e.setValues(values.toArray());
			domain = e;
		} else if (ctx.array() != null) {
			Enumerated e = new Enumerated();
			List<Object> values = new ArrayList<Object>();
			for (ArgsContext actx : ctx.array().args())
				values.add(actx.getText());
			e.setValues(values.toArray());
			domain = e;
		}
		m = new Metric(id, type, domain);
		this.model.getContext().getMetrics().put(id, m);
		return m;
	}

	@Override
	public Domain visitRange(iAgreeParser.RangeContext ctx) {
		Range r = null;
		r = new Range(Integer.valueOf(ctx.min.getText()),
				Integer.valueOf(ctx.max.getText()));
		return r;
	}

	@Override
	public String visitServiceScope(iAgreeParser.ServiceScopeContext ctx) {
		return ctx.Identifier().getText();
	}

	@Override
	public AssessmentInterval visitCompensationsInterval(
			CompensationsIntervalContext ctx) {
		return AssessmentInterval.valueOf(ctx.getText().toUpperCase());
	}

	@Override
	public Object visitTemporality(iAgreeParser.TemporalityContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPeriod(iAgreeParser.PeriodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitUrl(iAgreeParser.UrlContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVersionNumber(iAgreeParser.VersionNumberContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDateFormat_prop(iAgreeParser.DateFormat_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitExpirationTime_prop(
			iAgreeParser.ExpirationTime_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPeriod_def(iAgreeParser.Period_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGlobalPeriod_prop(
			iAgreeParser.GlobalPeriod_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGmtZone_prop(iAgreeParser.GmtZone_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDatePeriod_def(iAgreeParser.DatePeriod_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDefinedPeriod_prop(
			iAgreeParser.DefinedPeriod_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitChildren(RuleNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCuantif(CuantifContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitArgs(ArgsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
