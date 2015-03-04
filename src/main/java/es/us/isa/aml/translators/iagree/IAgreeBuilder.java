/**
 *
 */
package es.us.isa.aml.translators.iagree;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.Template;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.AssignmentExpression;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeVisitor;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementOffer;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementTerms;
import es.us.isa.aml.translators.iagree.model.IAgreeConfigurationProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeCreationConstraint;
import es.us.isa.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translators.iagree.model.IAgreeMetric;
import es.us.isa.aml.translators.iagree.model.IAgreeMonitorableProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeRange;
import es.us.isa.aml.translators.iagree.model.IAgreeSLO;
import es.us.isa.aml.translators.iagree.model.IAgreeService;
import es.us.isa.aml.translators.iagree.model.IAgreeTemplate;
import es.us.isa.aml.util.Util;
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
    public AgreementModel visitEntry(iAgreeParser.EntryContext ctx) {

        try {
            this.timeStamp = Calendar.getInstance().getTimeInMillis();
            this.metrics = new HashMap<String, Metric>();

            if (ctx.template() != null) {
                this.model = new IAgreeTemplate();
                this.visitTemplate(ctx.template());

            } else if (ctx.agOffer() != null) {
                this.model = new IAgreeAgreementOffer();
                this.visitAgOffer(ctx.agOffer());
            }
        } catch (IllegalArgumentException e) {
            this.model = null;
        }

        return this.model;
    }

    @Override
    public Object visitTemplate(iAgreeParser.TemplateContext ctx) {
        try {
            this.model.setID(ctx.id.getText());
            this.model.setVersion(new Float(ctx.version.getText()));

            this.visitTemplate_def(ctx.template_def());

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterTemplate");
            throw new IllegalArgumentException();
        }

        return null;
    }

    @Override
    public Object visitAgOffer(iAgreeParser.AgOfferContext ctx) {
        try {
            this.model.setID(ctx.id.getText());
            this.model.setVersion(new Float(ctx.version.getText()));

            ((IAgreeAgreementOffer) this.model).setTemplateId(ctx.templateId
                    .getText());
            ((IAgreeAgreementOffer) this.model).setTemplateVersion(new Float(
                    ctx.templateVersion.getText()));

            this.visitAg_def(ctx.ag_def());

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterAgOffer");
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Object visitTemplate_def(iAgreeParser.Template_defContext ctx) {
        try {
            for (iAgreeParser.Temp_propertiesContext tempCtx : ctx.temp_properties()) {
                this.visitTemp_properties(tempCtx);
            }

            this.visitAgreementTerms(ctx.agreementTerms());

            this.visitCreationConstraints(ctx.creationConstraints());

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterTemplate_def");
            throw new IllegalArgumentException();
        }

        return null;
    }

    @Override
    public Object visitAg_def(iAgreeParser.Ag_defContext ctx) {
        try {
            for (iAgreeParser.Temp_propertiesContext tp : ctx.temp_properties()) {
                this.visitTemp_properties(tp);
            }

            this.visitAgreementTerms(ctx.agreementTerms());

        } catch (Exception e) {
            System.out.println("iAgree parsing exception catched: enterAg_def");
            throw new IllegalArgumentException();
        }

        return null;
    }

    @Override
    public Object visitAgreementTerms(iAgreeParser.AgreementTermsContext ctx) {
        try {

            IAgreeAgreementTerms at = new IAgreeAgreementTerms();
            this.model.setAgreementTerms(at);

            this.visitService(ctx.service());

            this.visitMonitorableProperties(ctx.monitorableProperties());

            this.visitGuaranteeTerms(ctx.guaranteeTerms());

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterAgreementTerms");
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Object visitCreationConstraints(iAgreeParser.CreationConstraintsContext ctx) {
        try {
            for (iAgreeParser.CreationConstraintContext cc : ctx.creationConstraint()) {
                this.visitCreationConstraint(cc);
            }
        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterCreationConstraints");
            throw new IllegalArgumentException();
        }

        return null;
    }

    @Override
    public Object visitCreationConstraint(iAgreeParser.CreationConstraintContext ctx) {
        try {
            Expression exp = this.visitExpression(ctx.expression());
            IAgreeSLO slo = new IAgreeSLO(exp);
            IAgreeCreationConstraint cc = new IAgreeCreationConstraint(ctx
                    .Identifier().getText(), slo);

            ((Template) this.model).getCreationConstraints().add(cc);

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterCreationConstraint");
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Object visitService(iAgreeParser.ServiceContext ctx) {
        try {
            this.visitGlobalDescription(ctx.globalDescription());
            this.visitDescriptions(ctx.descriptions());

            IAgreeService service = new IAgreeService();
            service.setServiceName(ctx.Identifier().getText());
            service.setServiceReference(Util.withoutDoubleQuotes(ctx.url()
                    .getText()));

            this.model.getAgreementTerms().setService(service);

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: enterService");
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Object visitTemp_properties(iAgreeParser.Temp_propertiesContext ctx) {
        try {
            if (ctx.initiator_prop() != null) {

                String initiator = Util.withoutDoubleQuotes(ctx
                        .initiator_prop().String().getText());
                this.model.setInitiator(initiator);
            } else if (ctx.responder_prop() != null) {
                if (ctx.responder_prop().PROVIDER() != null) {

                    this.model.setResponder(Actor.valueOf(ctx.responder_prop()
                            .PROVIDER().getText()));

                } else if (ctx.responder_prop().CONSUMER() != null) {

                    this.model.setResponder(Actor.valueOf(ctx.responder_prop()
                            .CONSUMER().getText()));

                } else if (ctx.responder_prop().Identifier() != null) {

                    this.model.setResponder(ctx.responder_prop().Identifier()
                            .getText());

                }
            } else if (ctx.serviceProvider_prop() != null) {

                this.model.setServiceProvider(Util.withoutDoubleQuotes(ctx
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
                this.visitMetrics_prop(ctx.metrics_prop());

            }
        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: visitTemp_properties");
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Object visitMonitorableProperties(iAgreeParser.MonitorablePropertiesContext ctx) {
        try {
            if (ctx.global_MonitorableProperties() != null) {
                this.visitGlobal_MonitorableProperties(ctx
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
    public Object visitGuaranteeTerms(iAgreeParser.GuaranteeTermsContext ctx) {
        try {
            for (iAgreeParser.GuaranteeTermContext gt : ctx.guaranteeTerm()) {
                this.visitGuaranteeTerm(gt);
            }
        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: visitGuaranteeTerms");
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Object visitGlobalDescription(iAgreeParser.GlobalDescriptionContext ctx) {
        try {
            for (iAgreeParser.PropertyContext prop : ctx.property()) {
                IAgreeConfigurationProperty cp = new IAgreeConfigurationProperty(
                        this.visitProperty(prop));
                cp.setScope(Scope.Global);
                this.model.getAgreementTerms().getConfigurationProperties().add(cp);
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
            iAgreeParser.Global_MonitorablePropertiesContext ctx) {
        try {
            for (iAgreeParser.PropertyContext prop : ctx.property()) {
                IAgreeMonitorableProperty mp = new IAgreeMonitorableProperty(
                        this.visitProperty(prop));
                mp.setScope(Scope.Global);
                this.model.getAgreementTerms().getMonitorableProperties().add(mp);
            }
        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: visitGlobal_MonitorableProperties");
            throw new IllegalArgumentException();
        }
        return null;

    }

    @Override
    public Object visitGuaranteeTerm(iAgreeParser.GuaranteeTermContext ctx) {
        try {

            if (ctx.guarantee_def() != null) {

                IAgreeGuaranteeTerm gt = this.visitGuarantee_def(ctx.guarantee_def());
                gt.setId(ctx.Identifier().getText());

                this.model.getAgreementTerms().getGuaranteeTerms().add(gt);

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
    public IAgreeGuaranteeTerm visitGuarantee_def(iAgreeParser.Guarantee_defContext ctx) {
        IAgreeGuaranteeTerm gt = null;
        try {
            Expression exp = this.visitSlo(ctx.slo());

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
    public Expression visitSlo(iAgreeParser.SloContext ctx) {
        Expression exp = null;
        try {
            exp = this.visitExpression(ctx.expression());
        } catch (Exception e) {
            System.out.println("iAgree parsing exception catched: visitSlo");
            throw new IllegalArgumentException();
        }

        return exp;
    }

    @Override
    public Property visitProperty(iAgreeParser.PropertyContext ctx) {
        Property p = null;
        try {
            String id = ctx.id.getText();
            String metric_id = ctx.met.getText();
            Metric m = this.metrics.get(metric_id);

            p = new Property(id, m);

            if (ctx.value != null) {
                Expression expr = this.visitExpression(ctx.expression());
                p.setExpression(expr);
            }

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: visitProperty");
            throw new IllegalArgumentException();
        }
        return p;
    }

    // expr overrides
    public Expression visitExpression(iAgreeParser.ExpressionContext ctx) {
        Expression res = null;
        try {
            switch (ctx.getClass().getSimpleName()) {
                case "AssigExprContext":
                    res = this.visitAssigExpr((iAgreeParser.AssigExprContext) ctx);
                    break;
                case "NotExprContext":
                    res = this.visitNotExpr((iAgreeParser.NotExprContext) ctx);
                    break;
                case "MultiplicationExprContext":
                    res = this.visitMultiplicationExpr((iAgreeParser.MultiplicationExprContext) ctx);
                    break;
                case "AdditiveExprContext":
                    res = this.visitAdditiveExpr((iAgreeParser.AdditiveExprContext) ctx);
                    break;
                case "RelationalExprContext":
                    res = this.visitRelationalExpr((iAgreeParser.RelationalExprContext) ctx);
                    break;
                case "EqualityExprContext":
                    res = this.visitEqualityExpr((iAgreeParser.EqualityExprContext) ctx);
                    break;
                case "AndExprContext":
                    res = this.visitAndExpr((iAgreeParser.AndExprContext) ctx);
                    break;
                case "OrExprContext":
                    res = this.visitOrExpr((iAgreeParser.OrExprContext) ctx);
                    break;
                case "AtomExprContext":
                    res = this.visitAtomExpr((iAgreeParser.AtomExprContext) ctx);
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
    public Expression visitAssigExpr(iAgreeParser.AssigExprContext ctx) {
        Var v = new Var(ctx.Identifier().getText());
        Expression e2 = this.visitExpression(ctx.expression());
        Expression res = new AssignmentExpression(v, e2);
        return res;
    }

    @Override
    public Expression visitNotExpr(iAgreeParser.NotExprContext ctx) {
        Expression e1 = this.visitExpression(ctx.expression());
        Expression res = new LogicalExpression(e1, LogicalOperator.not);
        return res;
    }

    @Override
    public Expression visitMultiplicationExpr(
            @NotNull iAgreeParser.MultiplicationExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

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
    public Expression visitAdditiveExpr(@NotNull iAgreeParser.AdditiveExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

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
    public Expression visitRelationalExpr(@NotNull iAgreeParser.RelationalExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

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
    public Expression visitEqualityExpr(@NotNull iAgreeParser.EqualityExprContext ctx) {

        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));

        switch (ctx.op.getType()) {
            case iAgreeParser.EQ:
                return new RelationalExpression(e1, e2, RelationalOperator.eq);
            default:
                throw new IllegalArgumentException("unknown operator: "
                        + iAgreeParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expression visitAndExpr(iAgreeParser.AndExprContext ctx) {
        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));
        return new LogicalExpression(e1, e2, LogicalOperator.and);
    }

    @Override
    public Expression visitOrExpr(iAgreeParser.OrExprContext ctx) {
        Expression e1 = this.visitExpression(ctx.expression(0));
        Expression e2 = this.visitExpression(ctx.expression(1));
        return new LogicalExpression(e1, e2, LogicalOperator.or);
    }

    // atom overrides
    @Override
    public Expression visitAtomExpr(iAgreeParser.AtomExprContext ctx) {
        Expression res = null;

        switch (ctx.atom().getClass().getSimpleName()) {
            case "ParExprContext":
                res = this.visitParExpr((iAgreeParser.ParExprContext) ctx.atom());
                break;
            case "NumberAtomContext":
                res = this.visitNumberAtom((iAgreeParser.NumberAtomContext) ctx.atom());
                break;
            case "BooleanAtomContext":
                res = this.visitBooleanAtom((iAgreeParser.BooleanAtomContext) ctx.atom());
                break;
            case "IdAtomContext":
                res = this.visitIdAtom((iAgreeParser.IdAtomContext) ctx.atom());
                break;
            case "StringAtomContext":
                res = this.visitStringAtom((iAgreeParser.StringAtomContext) ctx.atom());
                break;
        }

        return res;
    }

    @Override
    public Expression visitParExpr(iAgreeParser.ParExprContext ctx) {
        return this.visitExpression(ctx.expression());
    }

    @Override
    public Expression visitNumberAtom(iAgreeParser.NumberAtomContext ctx) {
        return new Atomic(ctx.getText());
    }

    @Override
    public Expression visitBooleanAtom(iAgreeParser.BooleanAtomContext ctx) {
        return new Atomic(ctx.getText());
    }

    @Override
    public Expression visitIdAtom(iAgreeParser.IdAtomContext ctx) {
        return new Var(ctx.getText());
    }

    @Override
    public Expression visitStringAtom(iAgreeParser.StringAtomContext ctx) {
        return new Atomic(ctx.getText());
    }

    @Override
    public Metric visitMetrics_prop(iAgreeParser.Metrics_propContext ctx) {
        try {
            Enumerated en = new Enumerated();
            List<Object> ls = new ArrayList<Object>();
            ls.add(true);
            ls.add(false);
            IAgreeMetric m = new IAgreeMetric("boolean", "Boolean", en);
            this.metrics.put(m.getId(), m);

            for (iAgreeParser.MetricContext met : ctx.metric()) {
                this.visitMetric(met);
            }

        } catch (Exception e) {
            System.out
                    .println("iAgree parsing exception catched: visitMetrics_prop");
            throw new IllegalArgumentException();
        }

        return null;
    }

    @Override
    public Object visitMetric(iAgreeParser.MetricContext ctx) {
        IAgreeMetric m = null;

        try {
            String id = ctx.id.getText();
            String type = ctx.type.getText();

            Domain domain = null;
            if (ctx.range() != null) {
                domain = this.visitRange(ctx.range());
            } else if (ctx.list() != null) {
                domain = this.visitList(ctx.list());
            }

            m = new IAgreeMetric(id, type, domain);
            this.metrics.put(id, m);

            this.model.getMetrics().add(m);

        } catch (Exception e) {
            System.out.println("iAgree parsing exception catched: visitMetric");
            throw new IllegalArgumentException();
        }

        return m;
    }

    @Override
    public Domain visitRange(iAgreeParser.RangeContext ctx) {
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
    public Domain visitList(iAgreeParser.ListContext ctx) {
        Enumerated e = new Enumerated();
        try {

            List<Object> ls = new ArrayList<Object>();
            for (iAgreeParser.ListArgContext lctx : ctx.listArg()) {
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
    public Object visitServiceProvider_prop(iAgreeParser.ServiceProvider_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDescriptions(iAgreeParser.DescriptionsContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitLocal_MonitorableProperties(
            iAgreeParser.Local_MonitorablePropertiesContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitTemporality(iAgreeParser.TemporalityContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDescription(iAgreeParser.DescriptionContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitFeatures(iAgreeParser.FeaturesContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitFeature(iAgreeParser.FeatureContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitCompensationsInterval(iAgreeParser.CompensationsIntervalContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitResponder_prop(iAgreeParser.Responder_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitServiceScope(iAgreeParser.ServiceScopeContext ctx) {
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
    public Object visitCuantif(iAgreeParser.CuantifContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDateFormat_prop(iAgreeParser.DateFormat_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitExpirationTime_prop(iAgreeParser.ExpirationTime_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitPeriod_def(iAgreeParser.Period_defContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitFeature_operation(iAgreeParser.Feature_operationContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitQualifyingCondition(iAgreeParser.QualifyingConditionContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitGlobalPeriod_prop(iAgreeParser.GlobalPeriod_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitGmtZone_prop(iAgreeParser.GmtZone_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitCompensation(iAgreeParser.CompensationContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDatePeriod_def(iAgreeParser.DatePeriod_defContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDefinedPeriod_prop(iAgreeParser.DefinedPeriod_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitInitiator_prop(iAgreeParser.Initiator_propContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitListArg(iAgreeParser.ListArgContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitCompensations(iAgreeParser.CompensationsContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }
}
