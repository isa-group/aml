/**
 *
 */
package es.us.isa.aml.parsers.agreements.iagree;

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

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.Compensation.AssessmentInterval;
import es.us.isa.aml.model.Compensation.CompensationType;
import es.us.isa.aml.model.CompensationElement;
import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Feature;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.QualifyingCondition;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceRole;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.AssignmentExpression;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CompensationContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CompensationElementContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CompensationsIntervalContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Consumer_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.CuantifContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.FeatureContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Feature_operationContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.FeaturesContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.LocalDescriptionContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Local_MonitorablePropertiesContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.PartiesRoles_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.Provider_propContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.QualifyingConditionContext;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.ServiceProvider_propContext;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementOffer;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementTemplate;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementTerms;
import es.us.isa.aml.translators.iagree.model.IAgreeCompensation;
import es.us.isa.aml.translators.iagree.model.IAgreeConfigurationProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeContext;
import es.us.isa.aml.translators.iagree.model.IAgreeCreationConstraint;
import es.us.isa.aml.translators.iagree.model.IAgreeFeature;
import es.us.isa.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translators.iagree.model.IAgreeMetric;
import es.us.isa.aml.translators.iagree.model.IAgreeMonitorableProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeRange;
import es.us.isa.aml.translators.iagree.model.IAgreeResponder;
import es.us.isa.aml.translators.iagree.model.IAgreeSLO;
import es.us.isa.aml.translators.iagree.model.IAgreeService;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class MiAgreeVisitor implements iAgreeVisitor<Object> {

    private iAgreeParser parser;
    public AgreementModel model;
    public Map<String, Metric> metrics;
    public long timeStamp;

    public MiAgreeVisitor(iAgreeParser parser) {
        this.parser = parser;
    }

    @Override
    public AgreementModel visitEntry(iAgreeParser.EntryContext ctx) {

        try {
            this.timeStamp = Calendar.getInstance().getTimeInMillis();
            this.metrics = new HashMap<String, Metric>();

            IAgreeContext context = new IAgreeContext();

            if (ctx.template() != null) {
                this.model = new IAgreeAgreementTemplate();
                model.setDocType(DocType.TEMPLATE);
                model.setContext(context);
                this.visitTemplate(ctx.template());

            } else if (ctx.agOffer() != null) {
                this.model = new IAgreeAgreementOffer();
                model.setDocType(DocType.OFFER);
                model.setContext(context);
                this.visitAgOffer(ctx.agOffer());
            }
        } catch (Exception e) {
            this.model = null;
        }

        return this.model;
    }

    @Override
    public Object visitTemplate(iAgreeParser.TemplateContext ctx) {

        this.model.setID(ctx.id.getText());
        this.model.setVersion(new Float(ctx.version.getText()));

        this.visitTemplate_def(ctx.template_def());

        return null;
    }

    @Override
    public Object visitAgOffer(iAgreeParser.AgOfferContext ctx) {

        this.model.setID(ctx.id.getText());
        this.model.setVersion(new Float(ctx.version.getText()));

        ((IAgreeAgreementOffer) this.model).setTemplateId(ctx.templateId
                .getText());
        ((IAgreeAgreementOffer) this.model).setTemplateVersion(new Float(
                ctx.templateVersion.getText()));

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

        IAgreeAgreementTerms at = new IAgreeAgreementTerms();
        this.model.setAgreementTerms(at);

        this.visitService(ctx.service());

        this.visitMonitorableProperties(ctx.monitorableProperties());

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
        IAgreeSLO slo = new IAgreeSLO(exp);
        IAgreeCreationConstraint cc = new IAgreeCreationConstraint(ctx
                .Identifier().getText(), slo);

        if (ctx.qualifyingCondition() != null) {
            QualifyingCondition qc = visitQualifyingCondition(ctx
                    .qualifyingCondition());
            cc.setQc(qc);
        }

        ((AgreementTemplate) this.model).getCreationConstraints().add(cc);

        return null;
    }

    @Override
    public Object visitService(iAgreeParser.ServiceContext ctx) {

        IAgreeService service = new IAgreeService();
        model.getAgreementTerms().setService(service);
        model.getAgreementTerms().getService()
                .setServiceName(ctx.Identifier().getText());
        model.getAgreementTerms()
                .getService()
                .setServiceReference(
                        Util.withoutDoubleQuotes(ctx.url().getText()));

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
        IAgreeFeature feature = new IAgreeFeature();
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

        if (ctx.initiator_prop() != null) {
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
    public Object visitInitiator_prop(iAgreeParser.Initiator_propContext ctx) {
        String initiator = Util.withoutDoubleQuotes(ctx.String().getText());
        this.model.getContext().setInitiator(initiator);
        return null;
    }

    @Override
    public Object visitPartiesRoles_prop(PartiesRoles_propContext ctx) {
        IAgreeResponder r = null;

        if (ServiceRole.valueOf(ctx.responder.getText()) == ServiceRole.Provider) {
            r = new IAgreeResponder(ctx.id.getText(), ServiceRole.Provider);
            visitConsumer_prop(ctx.consumer_prop());
        } else if (ServiceRole.valueOf(ctx.responder.getText()) == ServiceRole.Consumer) {
            visitProvider_prop(ctx.provider_prop());
            r = new IAgreeResponder(ctx.id.getText(), ServiceRole.Consumer);
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

        for (iAgreeParser.GuaranteeTermContext gt : ctx.guaranteeTerm()) {
            this.visitGuaranteeTerm(gt);
        }

        return null;
    }

    @Override
    public Object visitGlobalDescription(
            iAgreeParser.GlobalDescriptionContext ctx) {

        for (iAgreeParser.PropertyContext prop : ctx.property()) {
            Property p = this.visitProperty(prop);
            if (p != null) {
                IAgreeConfigurationProperty cp = new IAgreeConfigurationProperty(
                        p.getId(), p.getMetric());
                cp.setExpression(p.getExpression());
                cp.setScope(Scope.Global);
                this.model.getAgreementTerms().getService()
                        .getConfigurationProperties().add(cp);
            }
        }

        return null;
    }

    @Override
    public Object visitLocalDescription(LocalDescriptionContext ctx) {
        for (iAgreeParser.PropertyContext prop : ctx.property()) {
            Property p = this.visitProperty(prop);
            if (p != null) {
                IAgreeConfigurationProperty cp = new IAgreeConfigurationProperty(
                        p.getId(), p.getMetric());
                cp.setExpression(p.getExpression());
                cp.setScope(Scope.Local);

                Map<String, Feature> features = model.getAgreementTerms()
                        .getService().getFeatures();
                if (features.containsKey(ctx.Identifier().getText())) {
                    cp.setFeature(features.get(ctx.Identifier().getText()));
                    this.model.getAgreementTerms().getService()
                            .getConfigurationProperties().add(cp);
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
                IAgreeMonitorableProperty mp = new IAgreeMonitorableProperty(
                        p.getId(), p.getMetric());
                mp.setExpression(p.getExpression());
                mp.setScope(Scope.Global);
                this.model.getAgreementTerms().getMonitorableProperties()
                        .add(mp);
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
                IAgreeMonitorableProperty mp = new IAgreeMonitorableProperty(
                        p.getId(), p.getMetric());
                mp.setExpression(p.getExpression());
                mp.setScope(Scope.Local);

                Map<String, Feature> features = model.getAgreementTerms()
                        .getService().getFeatures();
                if (features.containsKey(ctx.Identifier().getText())) {
                    mp.setFeature(features.get(ctx.Identifier().getText()));
                    this.model.getAgreementTerms().getMonitorableProperties()
                            .add(mp);
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

            IAgreeGuaranteeTerm gt = this.visitGuarantee_def(ctx
                    .guarantee_def());
            gt.setId(ctx.Identifier().getText());

            this.model.getAgreementTerms().getGuaranteeTerms().add(gt);

        } else if (ctx.cuantif() != null) {
            // TODO
        }

        return null;
    }

    @Override
    public IAgreeGuaranteeTerm visitGuarantee_def(
            iAgreeParser.Guarantee_defContext ctx) {

        Expression exp = this.visitSlo(ctx.slo());

        IAgreeSLO slo = new IAgreeSLO(exp);
        ServiceRole actor = ServiceRole.valueOf(ctx.ob.getText());

        IAgreeGuaranteeTerm gt = new IAgreeGuaranteeTerm("", actor, slo);

        if (ctx.serviceScope() != null) {
            String serviceScope = visitServiceScope(ctx.serviceScope());
            gt.setServiceScope(serviceScope);
        }

        if (ctx.qualifyingCondition() != null) {
            QualifyingCondition qc = visitQualifyingCondition(ctx
                    .qualifyingCondition());
            gt.setQc(qc);
        }

        List<Compensation> compensations = new ArrayList<Compensation>();
        for (CompensationContext comp : ctx.compensation()) {
            IAgreeCompensation c = visitCompensation(comp);
            compensations.add(c);
        }
        gt.setCompensations(compensations);

        return gt;
    }

    @Override
    public IAgreeCompensation visitCompensation(CompensationContext ctx) {
        IAgreeCompensation c = new IAgreeCompensation();

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
        Metric m = this.metrics.get(metric_id);

        if (m != null) {

            p = new Property(id, m);

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
    public Expression visitExpression(iAgreeParser.ExpressionContext ctx) {
        Expression res = null;

        switch (ctx.getClass().getSimpleName()) {
            case "AssigExprContext":
                res = this.visitAssigExpr((iAgreeParser.AssigExprContext) ctx);
                break;
            case "NotExprContext":
                res = this.visitNotExpr((iAgreeParser.NotExprContext) ctx);
                break;
            case "MultiplicationExprContext":
                res = this
                        .visitMultiplicationExpr((iAgreeParser.MultiplicationExprContext) ctx);
                break;
            case "AdditiveExprContext":
                res = this
                        .visitAdditiveExpr((iAgreeParser.AdditiveExprContext) ctx);
                break;
            case "RelationalExprContext":
                res = this
                        .visitRelationalExpr((iAgreeParser.RelationalExprContext) ctx);
                break;
            case "EqualityExprContext":
                res = this
                        .visitEqualityExpr((iAgreeParser.EqualityExprContext) ctx);
                break;
            case "AndExprContext":
                res = this.visitAndExpr((iAgreeParser.AndExprContext) ctx);
                break;
            case "OrExprContext":
                res = this.visitOrExpr((iAgreeParser.OrExprContext) ctx);
                break;
            case "ParExprContext":
                res = this.visitParExpr((iAgreeParser.ParExprContext) ctx);
                break;
            case "AtomExprContext":
                res = this.visitAtomExpr((iAgreeParser.AtomExprContext) ctx);
                break;
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
    public Expression visitAdditiveExpr(
            @NotNull iAgreeParser.AdditiveExprContext ctx) {

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
    public Expression visitRelationalExpr(
            @NotNull iAgreeParser.RelationalExprContext ctx) {

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
    public Expression visitEqualityExpr(
            @NotNull iAgreeParser.EqualityExprContext ctx) {

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
            case "NumberAtomContext":
                res = this.visitNumberAtom((iAgreeParser.NumberAtomContext) ctx
                        .atom());
                break;
            case "BooleanAtomContext":
                res = this.visitBooleanAtom((iAgreeParser.BooleanAtomContext) ctx
                        .atom());
                break;
            case "IdAtomContext":
                res = this.visitIdAtom((iAgreeParser.IdAtomContext) ctx.atom());
                break;
            case "StringAtomContext":
                res = this.visitStringAtom((iAgreeParser.StringAtomContext) ctx
                        .atom());
                break;
        }

        return res;
    }

    @Override
    public Expression visitParExpr(iAgreeParser.ParExprContext ctx) {
        return new ParenthesisExpression(this.visitExpression(ctx.expression()));
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
        Enumerated en = new Enumerated();
        List<Object> ls = new ArrayList<Object>();
        ls.add(true);
        ls.add(false);
        IAgreeMetric m = new IAgreeMetric("boolean", "Boolean", en);
        this.metrics.put(m.getId(), m);

        for (iAgreeParser.MetricContext met : ctx.metric()) {
            this.visitMetric(met);
        }
        return null;
    }

    @Override
    public Object visitMetric(iAgreeParser.MetricContext ctx) {
        IAgreeMetric m = null;
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
        this.model.getContext().getMetrics().add(m);
        return m;
    }

    @Override
    public Domain visitRange(iAgreeParser.RangeContext ctx) {
        IAgreeRange r = null;
        r = new IAgreeRange(Integer.valueOf(ctx.min.getText()),
                Integer.valueOf(ctx.max.getText()));
        return r;
    }

    @Override
    public Domain visitList(iAgreeParser.ListContext ctx) {
        Enumerated e = new Enumerated();
        List<Object> ls = new ArrayList<Object>();
        for (iAgreeParser.ListArgContext lctx : ctx.listArg()) {
            ls.add(lctx.getText());
        }
        e.setValues(ls);
        return e;
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
    public Object visitListArg(iAgreeParser.ListArgContext ctx) {
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
}
