/**
 *
 */
package isa.us.es.aml.translators.iagree;

import isa.us.es.aml.model.Actor;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.Domain;
import isa.us.es.aml.model.Enumerated;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Scope;
import isa.us.es.aml.model.Template;
import isa.us.es.aml.model.expression.ArithmeticExpression;
import isa.us.es.aml.model.expression.ArithmeticOperator;
import isa.us.es.aml.model.expression.AssignmentExpression;
import isa.us.es.aml.model.expression.Atomic;
import isa.us.es.aml.model.expression.Expression;
import isa.us.es.aml.model.expression.LogicalExpression;
import isa.us.es.aml.model.expression.LogicalOperator;
import isa.us.es.aml.model.expression.RelationalExpression;
import isa.us.es.aml.model.expression.RelationalOperator;
import isa.us.es.aml.model.expression.Var;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.AdditiveExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.AgOfferContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Ag_defContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.AgreementTermsContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.AndExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.AssigExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.AtomExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.BooleanAtomContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.CompensationContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.CompensationsContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.CompensationsIntervalContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.CreationConstraintContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.CreationConstraintsContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.CuantifContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.DateFormat_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.DatePeriod_defContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.DefinedPeriod_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.DescriptionContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.DescriptionsContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.EntryContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.EqualityExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ExpirationTime_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ExpressionContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.FeatureContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Feature_operationContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.FeaturesContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.GlobalDescriptionContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.GlobalPeriod_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Global_MonitorablePropertiesContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.GmtZone_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.GuaranteeTermContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.GuaranteeTermsContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Guarantee_defContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.IdAtomContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Initiator_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ListArgContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ListContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Local_MonitorablePropertiesContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.MetricContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Metrics_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.MonitorablePropertiesContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.MultiplicationExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.NotExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.NumberAtomContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.OrExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ParExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.PeriodContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Period_defContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.PropertyContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.QualifyingConditionContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.RangeContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.RelationalExprContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Responder_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ServiceContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ServiceProvider_propContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.ServiceScopeContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.SloContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.StringAtomContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Temp_propertiesContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.TemplateContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.Template_defContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.TemporalityContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.UrlContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.VersionNumberContext;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeVisitor;
import isa.us.es.aml.translators.iagree.model.IAgreeAgreementOffer;
import isa.us.es.aml.translators.iagree.model.IAgreeAgreementTerms;
import isa.us.es.aml.translators.iagree.model.IAgreeConfigurationProperty;
import isa.us.es.aml.translators.iagree.model.IAgreeCreationConstraint;
import isa.us.es.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import isa.us.es.aml.translators.iagree.model.IAgreeMetric;
import isa.us.es.aml.translators.iagree.model.IAgreeMonitorableProperty;
import isa.us.es.aml.translators.iagree.model.IAgreeRange;
import isa.us.es.aml.translators.iagree.model.IAgreeSLO;
import isa.us.es.aml.translators.iagree.model.IAgreeService;
import isa.us.es.aml.translators.iagree.model.IAgreeTemplate;
import isa.us.es.aml.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * @author jdelafuente
 *
 */
public class IAgreeBuilder implements iAgreeVisitor<Object> {

	public AgreementModel model;
	public Map<String, Metric> metrics;
	public long timeStamp;

	@Override
	public AgreementModel visitEntry(EntryContext ctx) {

		try {
			timeStamp = Calendar.getInstance().getTimeInMillis();
			metrics = new HashMap<String, Metric>();

			if (ctx.template() != null) {
				model = new IAgreeTemplate();
				visitTemplate(ctx.template());

			} else if (ctx.agOffer() != null) {
				model = new IAgreeAgreementOffer();
				visitAgOffer(ctx.agOffer());
			}
		} catch (IllegalArgumentException e) {
			model = null;
		}

		return model;
	}

	@Override
	public Object visitTemplate(TemplateContext ctx) {
		try {
			model.setID(ctx.id.getText());
			model.setVersion(new Float(ctx.version.getText()));

			visitTemplate_def(ctx.template_def());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterTemplate");
			throw new IllegalArgumentException();
		}

		return null;
	}

	@Override
	public Object visitAgOffer(AgOfferContext ctx) {
		try {
			model.setID(ctx.id.getText());
			model.setVersion(new Float(ctx.version.getText()));

			((IAgreeAgreementOffer) model).setTemplateId(ctx.templateId
					.getText());
			((IAgreeAgreementOffer) model).setTemplateVersion(new Float(
					ctx.templateVersion.getText()));

			visitAg_def(ctx.ag_def());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterAgOffer");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitTemplate_def(Template_defContext ctx) {
		try {
			for (Temp_propertiesContext tempCtx : ctx.temp_properties()) {
				visitTemp_properties(tempCtx);
			}

			visitAgreementTerms(ctx.agreementTerms());

			visitCreationConstraints(ctx.creationConstraints());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterTemplate_def");
			throw new IllegalArgumentException();
		}

		return null;
	}

	@Override
	public Object visitAg_def(Ag_defContext ctx) {
		try {
			for (Temp_propertiesContext tp : ctx.temp_properties()) {
				visitTemp_properties(tp);
			}

			visitAgreementTerms(ctx.agreementTerms());

		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: enterAg_def");
			throw new IllegalArgumentException();
		}

		return null;
	}

	@Override
	public Object visitAgreementTerms(AgreementTermsContext ctx) {
		try {

			IAgreeAgreementTerms at = new IAgreeAgreementTerms();
			model.setAgreementTerms(at);

			visitService(ctx.service());

			visitMonitorableProperties(ctx.monitorableProperties());

			visitGuaranteeTerms(ctx.guaranteeTerms());

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterAgreementTerms");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitCreationConstraints(CreationConstraintsContext ctx) {
		try {
			for (CreationConstraintContext cc : ctx.creationConstraint()) {
				visitCreationConstraint(cc);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterCreationConstraints");
			throw new IllegalArgumentException();
		}

		return null;
	}

	@Override
	public Object visitCreationConstraint(CreationConstraintContext ctx) {
		try {
			Expression exp = visitExpression(ctx.expression());
			IAgreeSLO slo = new IAgreeSLO(exp);
			IAgreeCreationConstraint cc = new IAgreeCreationConstraint(ctx
					.Identifier().getText(), slo);

			((Template) model).getCreationConstraints().add(cc);

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterCreationConstraint");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitService(ServiceContext ctx) {
		try {
			visitGlobalDescription(ctx.globalDescription());
			visitDescriptions(ctx.descriptions());

			IAgreeService service = new IAgreeService();
			service.setServiceName(ctx.Identifier().getText());
			service.setServiceReference(Util.withoutDoubleQuotes(ctx.url()
					.getText()));

			model.getAgreementTerms().setService(service);

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: enterService");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitTemp_properties(Temp_propertiesContext ctx) {
		try {
			if (ctx.initiator_prop() != null) {

				String initiator = Util.withoutDoubleQuotes(ctx
						.initiator_prop().String().getText());
				model.setInitiator(initiator);
			} else if (ctx.responder_prop() != null) {
				if (ctx.responder_prop().PROVIDER() != null) {

					model.setResponder(Actor.valueOf(ctx.responder_prop()
							.PROVIDER().getText()));

				} else if (ctx.responder_prop().CONSUMER() != null) {

					model.setResponder(Actor.valueOf(ctx.responder_prop()
							.CONSUMER().getText()));

				} else if (ctx.responder_prop().Identifier() != null) {

					model.setResponder(ctx.responder_prop().Identifier()
							.getText());

				}
			} else if (ctx.serviceProvider_prop() != null) {

				model.setServiceProvider(Util.withoutDoubleQuotes(ctx
						.serviceProvider_prop().String().getText()));

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
				visitMetrics_prop(ctx.metrics_prop());

			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitTemp_properties");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitMonitorableProperties(MonitorablePropertiesContext ctx) {
		try {
			if (ctx.global_MonitorableProperties() != null) {
				visitGlobal_MonitorableProperties(ctx
						.global_MonitorableProperties());
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitMonitorableProperties");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitGuaranteeTerms(GuaranteeTermsContext ctx) {
		try {
			for (GuaranteeTermContext gt : ctx.guaranteeTerm()) {
				visitGuaranteeTerm(gt);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitGuaranteeTerms");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitGlobalDescription(GlobalDescriptionContext ctx) {
		try {
			for (PropertyContext prop : ctx.property()) {
				IAgreeConfigurationProperty cp = new IAgreeConfigurationProperty(
						visitProperty(prop));
				cp.setScope(Scope.Global);
				model.getAgreementTerms().getConfigurationProperties().add(cp);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitGlobalDescription");
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Object visitGlobal_MonitorableProperties(
			Global_MonitorablePropertiesContext ctx) {
		try {
			for (PropertyContext prop : ctx.property()) {
				IAgreeMonitorableProperty mp = new IAgreeMonitorableProperty(
						visitProperty(prop));
				mp.setScope(Scope.Global);
				model.getAgreementTerms().getMonitorableProperties().add(mp);
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitGlobal_MonitorableProperties");
			throw new IllegalArgumentException();
		}
		return null;

	}

	@Override
	public Object visitGuaranteeTerm(GuaranteeTermContext ctx) {
		try {

			if (ctx.guarantee_def() != null) {

				IAgreeGuaranteeTerm gt = visitGuarantee_def(ctx.guarantee_def());
				gt.setId(ctx.Identifier().getText());

				model.getAgreementTerms().getGuaranteeTerms().add(gt);

			} else if (ctx.cuantif() != null) {
				// TODO
			}

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitProperty");
			throw new IllegalArgumentException();
		}

		return null;
	}

	@Override
	public IAgreeGuaranteeTerm visitGuarantee_def(Guarantee_defContext ctx) {
		IAgreeGuaranteeTerm gt = null;
		try {
			Expression exp = visitSlo(ctx.slo());

			IAgreeSLO slo = new IAgreeSLO(exp);
			Actor actor = Actor.valueOf(ctx.ob.getText());

			gt = new IAgreeGuaranteeTerm("", actor, slo);

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitProperty");
			throw new IllegalArgumentException();
		}

		return gt;
	}

	@Override
	public Expression visitSlo(SloContext ctx) {
		Expression exp = null;
		try {
			exp = visitExpression(ctx.expression());
		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: visitSlo");
			throw new IllegalArgumentException();
		}

		return exp;
	}

	@Override
	public Property visitProperty(PropertyContext ctx) {
		Property p = null;
		try {
			String id = ctx.id.getText();
			String metric_id = ctx.met.getText();
			Metric m = metrics.get(metric_id);

			p = new Property(id, m);

			if (ctx.value != null) {
				Expression expr = visitExpression(ctx.expression());
				p.setExpression(expr);
				;
			}

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitProperty");
			throw new IllegalArgumentException();
		}
		return p;
	}

	// expr overrides
	public Expression visitExpression(ExpressionContext ctx) {
		Expression res = null;
		try {
			switch (ctx.getClass().getSimpleName()) {
			case "AssigExprContext":
				res = visitAssigExpr((AssigExprContext) ctx);
				break;
			case "NotExprContext":
				res = visitNotExpr((NotExprContext) ctx);
				break;
			case "MultiplicationExprContext":
				res = visitMultiplicationExpr((MultiplicationExprContext) ctx);
				break;
			case "AdditiveExprContext":
				res = visitAdditiveExpr((AdditiveExprContext) ctx);
				break;
			case "RelationalExprContext":
				res = visitRelationalExpr((RelationalExprContext) ctx);
				break;
			case "EqualityExprContext":
				res = visitEqualityExpr((EqualityExprContext) ctx);
				break;
			case "AndExprContext":
				res = visitAndExpr((AndExprContext) ctx);
				break;
			case "OrExprContext":
				res = visitOrExpr((OrExprContext) ctx);
				break;
			case "AtomExprContext":
				res = (Expression) visitAtomExpr((AtomExprContext) ctx);
				break;
			}
		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitExpression");
			throw new IllegalArgumentException();
		}

		return res;
	}

	@Override
	public Expression visitAssigExpr(AssigExprContext ctx) {
		Var v = new Var(ctx.Identifier().getText());
		Expression e2 = visitExpression(ctx.expression());
		Expression res = new AssignmentExpression(v, e2);
		return res;
	}

	@Override
	public Expression visitNotExpr(NotExprContext ctx) {
		Expression e1 = visitExpression(ctx.expression());
		Expression res = new LogicalExpression(e1, LogicalOperator.not);
		return res;
	}

	@Override
	public Expression visitMultiplicationExpr(
			@NotNull MultiplicationExprContext ctx) {

		Expression e1 = visitExpression(ctx.expression(0));
		Expression e2 = visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.MULTIPLY:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.multiply);
		case iAgreeParser.DIVIDE:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.divide);
		default:
			throw new RuntimeException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAdditiveExpr(@NotNull AdditiveExprContext ctx) {

		Expression e1 = visitExpression(ctx.expression(0));
		Expression e2 = visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.ADD:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.add);
		case iAgreeParser.SUBTRACT:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.subtract);
		default:
			throw new RuntimeException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitRelationalExpr(@NotNull RelationalExprContext ctx) {

		Expression e1 = visitExpression(ctx.expression(0));
		Expression e2 = visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.LTE:
			return new RelationalExpression(e1, e2, RelationalOperator.lte);
		case iAgreeParser.GTE:
			return new RelationalExpression(e1, e2, RelationalOperator.gte);
		case iAgreeParser.LT:
			return new RelationalExpression(e1, e2, RelationalOperator.lt);
		case iAgreeParser.GT:
			return new RelationalExpression(e1, e2, RelationalOperator.gt);
		default:
			throw new RuntimeException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitEqualityExpr(@NotNull EqualityExprContext ctx) {

		Expression e1 = visitExpression(ctx.expression(0));
		Expression e2 = visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case iAgreeParser.EQ:
			return new RelationalExpression(e1, e2, RelationalOperator.eq);
		default:
			throw new IllegalArgumentException("unknown operator: "
					+ iAgreeParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAndExpr(AndExprContext ctx) {
		Expression e1 = visitExpression(ctx.expression(0));
		Expression e2 = visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.and);
	}

	@Override
	public Expression visitOrExpr(OrExprContext ctx) {
		Expression e1 = visitExpression(ctx.expression(0));
		Expression e2 = visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.or);
	}

	// atom overrides
	@Override
	public Expression visitAtomExpr(AtomExprContext ctx) {
		Expression res = null;

		switch (ctx.atom().getClass().getSimpleName()) {
		case "ParExprContext":
			res = visitParExpr((ParExprContext) ctx.atom());
			break;
		case "NumberAtomContext":
			res = visitNumberAtom((NumberAtomContext) ctx.atom());
			break;
		case "BooleanAtomContext":
			res = visitBooleanAtom((BooleanAtomContext) ctx.atom());
			break;
		case "IdAtomContext":
			res = visitIdAtom((IdAtomContext) ctx.atom());
			break;
		case "StringAtomContext":
			res = visitStringAtom((StringAtomContext) ctx.atom());
			break;
		}

		return res;
	}

	@Override
	public Expression visitParExpr(ParExprContext ctx) {
		return visitExpression(ctx.expression());
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
	public Expression visitIdAtom(IdAtomContext ctx) {
		return new Var(ctx.getText());
	}

	@Override
	public Expression visitStringAtom(StringAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Metric visitMetrics_prop(Metrics_propContext ctx) {
		try {
			Enumerated en = new Enumerated();
			List<Object> ls = new ArrayList<Object>();
			ls.add(true);
			ls.add(false);
			IAgreeMetric m = new IAgreeMetric("boolean", "Boolean", en);
			metrics.put(m.getId(), m);

			for (MetricContext met : ctx.metric()) {
				visitMetric(met);
			}

		} catch (Exception e) {
			System.out
					.println("iAgree parsing exception catched: visitMetrics_prop");
			throw new IllegalArgumentException();
		}

		return null;
	}

	@Override
	public Object visitMetric(MetricContext ctx) {
		IAgreeMetric m = null;

		try {
			String id = ctx.id.getText();
			String type = ctx.type.getText();

			Domain domain = null;
			if (ctx.range() != null) {
				domain = visitRange(ctx.range());
			} else if (ctx.list() != null) {
				domain = visitList(ctx.list());
			}

			m = new IAgreeMetric(id, type, domain);
			metrics.put(id, m);

			model.getMetrics().add(m);

		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: visitMetric");
			throw new IllegalArgumentException();
		}

		return m;
	}

	@Override
	public Domain visitRange(RangeContext ctx) {
		IAgreeRange r = null;
		try {
			r = new IAgreeRange(Integer.valueOf(ctx.min.getText()),
					Integer.valueOf(ctx.max.getText()));
		} catch (Exception e) {
			System.out.println("iAgree parsing exception catched: visitRange");
			throw new IllegalArgumentException();
		}

		return r;
	}

	@Override
	public Domain visitList(ListContext ctx) {
		Enumerated e = new Enumerated();
		try {

			List<Object> ls = new ArrayList<Object>();
			for (ListArgContext lctx : ctx.listArg()) {
				ls.add(lctx.getText());
			}

			e.setValues(ls);

		} catch (Exception ex) {
			System.out.println("iAgree parsing exception catched: visitList");
			throw new IllegalArgumentException();
		}

		return e;
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
	public Object visitServiceProvider_prop(ServiceProvider_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDescriptions(DescriptionsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLocal_MonitorableProperties(
			Local_MonitorablePropertiesContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTemporality(TemporalityContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDescription(DescriptionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFeatures(FeaturesContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFeature(FeatureContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCompensationsInterval(CompensationsIntervalContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitResponder_prop(Responder_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitServiceScope(ServiceScopeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPeriod(PeriodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitUrl(UrlContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVersionNumber(VersionNumberContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCuantif(CuantifContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDateFormat_prop(DateFormat_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitExpirationTime_prop(ExpirationTime_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPeriod_def(Period_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFeature_operation(Feature_operationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitQualifyingCondition(QualifyingConditionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGlobalPeriod_prop(GlobalPeriod_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGmtZone_prop(GmtZone_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCompensation(CompensationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDatePeriod_def(DatePeriod_defContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDefinedPeriod_prop(DefinedPeriod_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitInitiator_prop(Initiator_propContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitListArg(ListArgContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCompensations(CompensationsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
