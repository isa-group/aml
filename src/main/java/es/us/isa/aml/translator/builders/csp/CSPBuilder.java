/**
 * *****************************************************************************
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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 ******************************************************************************
 */
package es.us.isa.aml.translator.builders.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.ListExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;
import java.util.logging.Logger;

/**
 * Builds a CSPModel from an AgreementModel.
 *
 * @author jdelafuente
 *
 */
public class CSPBuilder implements IBuilder {

    private static final Logger LOG = Logger.getLogger(CSPBuilder.class.getName());

    private CSPModel model;
    private DocType docType;

    private final Map<String, CSPVar> vars = new HashMap<>();

    public CSPBuilder() {
        this.model = new CSPModel();
    }

    @Override
    public void setDocType(DocType type) {
        docType = type;
    }

    @Override
    public void setContext(Context context) {
        for (Metric m : context.getMetrics().values()) {
            setMetric(m);
        }
    }

    @Override
    public void setMetric(Metric metric) {
        if (this.model == null) {
            this.model = new CSPModel();
        }

        if (metric.getType().equals("enum")) {
            CSPVar domain = new CSPVar("domain_" + metric.getId(),
                    metric.getType(), false);
            domain.setExpression(new ListExpression(((Enumerated) metric
                    .getDomain()).getValues()));

            Integer max_size = ((Enumerated) metric.getDomain()).getValues().length;
            CSPRange range_enum = new CSPRange(domain.getId(), new Range(0,
                    max_size - 1));
            CSPVar _enum = new CSPVar("enum_" + metric.getId(), "integer",
                    false);
            _enum.setRange(range_enum);
            List<Integer> range = new ArrayList<>();
            for (int i = 0; i < max_size; i++) {
                range.add(i);
            }
            _enum.setExpression(new ListExpression(range));
            this.model.addVar(domain);
            vars.put(domain.getId(), domain);
            this.model.addVar(_enum);
            vars.put(_enum.getId(), _enum);
        } else {
            if (metric.getType().equals("boolean") || metric.getType().equals("string")) {
                return;
            }
            CSPRange range = new CSPRange("range_" + metric.getId(),
                    metric.getDomain());
            this.model.addRange(range);
        }
    }

    @Override
    public void setAgreementTerms(AgreementTerms at) {
        if (this.model == null) {
            this.model = new CSPModel();
        }

        setService(at.getService());

        for (MonitorableProperty mp : at.getMonitorableProperties().values()) {
            this.setMonitorableProperty(mp);
        }

        for (GuaranteeTerm gt : at.getGuaranteeTerms().values()) {
            this.setGuaranteeTerm(gt);
        }
    }

    @Override
    public void setService(ServiceConfiguration service) {
        for (ConfigurationProperty cp : service.getConfigurationProperties()
                .values()) {
            this.setConfigurationProperty(cp);
        }
    }

    @Override
    public void setConfigurationProperty(Property cp) {
        if (this.model == null) {
            this.model = new CSPModel();
        }
        
        switch (cp.getMetric().getType()) {
            case "string":
                {
                    CSPVar var = new CSPVar(cp.getId(), getTypeByOpt(cp.getMetric()
                            .getType(), model.getUseCP()), false);
                    this.model.addVar(var);
                    vars.put(var.getId(), var);
                    break;
                }
            case "enum":
                {
                    CSPVar var = new CSPVar(cp.getId(), getTypeByOpt(cp.getMetric()
                            .getType(), model.getUseCP()), vars.get(
                                    "enum_" + cp.getMetric().getId()).getRange(), true);
                    this.model.addVar(var);
                    vars.put(var.getId(), var);
                    break;
                }
            default:
                {
                    Map<String, CSPRange> ranges = new HashMap<>();
                    for (CSPRange range : this.model.getRanges()) {
                        ranges.put(range.getId(), range);
                    }       CSPVar var = new CSPVar(cp.getId(), getTypeByOpt(cp.getMetric()
                            .getType(), model.getUseCP()), ranges.get("range_"
                                    + cp.getMetric().getId()), true);
                    this.model.addVar(var);
                    vars.put(var.getId(), var);
                    break;
                }
        }

        if (docType == DocType.OFFER) {
            if (cp.getExpression() != null) {
                String assig = "ASSIG_" + cp.getId();
                for (CSPConstraint cons : model.getConstraints()) {
                    if (cons.getId().contains("ASSIG")) {
                        assig = "ASSIG_" + cp.getId();
                    }
                }

                if (cp.getMetric().getType().equals("enum")) {
                    Expression exp = new Atomic("enum_"
                            + cp.getMetric().getId()
                            + "["
                            + "\""
                            + Util.withoutDoubleQuotes(cp.getExpression()
                                    .toString()) + "\"" + "]");
                    Expression expr = new RelationalExpression(new Var(cp),
                            exp, RelationalOperator.EQ);
                    CSPConstraint constraint = new CSPConstraint(assig, expr);
                    this.model.addConstraint(constraint);
                } else {
                    Expression expr = new RelationalExpression(new Var(cp),
                            cp.getExpression(), RelationalOperator.EQ);
                    CSPConstraint constraint = new CSPConstraint(assig, expr);
                    this.model.addConstraint(constraint);
                }
            }
        }
    }

    @Override
    public void setMonitorableProperty(Property mp) {
        if (this.model == null) {
            this.model = new CSPModel();
        }
        
        switch (mp.getMetric().getType()) {
            case "string":
                {
                    CSPVar var = new CSPVar(mp.getId(), getTypeByOpt(mp.getMetric()
                            .getType(), model.getUseCP()), false);
                    this.model.addVar(var);
                    vars.put(var.getId(), var);
                    break;
                }
            case "enum":
                {
                    CSPVar var = new CSPVar(mp.getId(), getTypeByOpt(mp.getMetric()
                            .getType(), model.getUseCP()), vars.get(
                                    "enum_" + mp.getMetric().getId()).getRange(), true);
                    this.model.addVar(var);
                    vars.put(var.getId(), var);
                    break;
                }
            default:
                {
                    Map<String, CSPRange> ranges = new HashMap<>();
                    for (CSPRange range : this.model.getRanges()) {
                        ranges.put(range.getId(), range);
                    }       CSPVar var = new CSPVar(mp.getId(), getTypeByOpt(mp.getMetric()
                            .getType(), model.getUseCP()), ranges.get("range_"
                                    + mp.getMetric().getId()), true);
                    this.model.addVar(var);
                    vars.put(var.getId(), var);
                    break;
                }
        }

        if (docType == DocType.OFFER) {
            if (mp.getExpression() != null) {
                /*
				 * int i = 1; String assig = "ASSIG"; for (CSPConstraint cons :
				 * model.getConstraints()) { if (cons.getId().contains("ASSIG"))
				 * { i++; } } assig = "ASSIG_" + i;
                 */
                String assig = "ASSIG_" + mp.getId();
                for (CSPConstraint cons : model.getConstraints()) {
                    if (cons.getId().contains("ASSIG")) {
                        assig = "ASSIG_" + mp.getId();
                    }
                }
                if (mp.getMetric().getType().equals("enum")) {
                    Expression exp = new Atomic("enum_"
                            + mp.getMetric().getId() + "[" + mp.getExpression()
                            + "]");
                    Expression expr = new RelationalExpression(new Var(mp),
                            exp, RelationalOperator.EQ);
                    CSPConstraint constraint = new CSPConstraint(assig, expr);
                    this.model.addConstraint(constraint);
                } else {
                    Expression expr = new RelationalExpression(new Var(mp),
                            mp.getExpression(), RelationalOperator.EQ);
                    CSPConstraint constraint = new CSPConstraint(assig, expr);
                    this.model.addConstraint(constraint);
                }
            }
        }
    }

    @Override
    public void setGuaranteeTerm(GuaranteeTerm gt) {
        try {
            if (this.model == null) {
                this.model = new CSPModel();
            }

            GuaranteeTerm gt_clon = gt.clone();

            Expression expr_slo = gt_clon.getSlo().getExpression();
            List<Expression> expressions = Expression
                    .splitExpressions(expr_slo);
            for (Expression expr : expressions) {
                for (Var v : Expression.getVars(expr)) {
                    if (vars.containsKey(v.getId().toString())) {
                        CSPVar var = vars.get(v.getId().toString());
                        if (var.getType().equals("{string}")) {
                            for (Atomic atom : Expression.getAtomics(expr)) {
                                if (atom.calculate() instanceof String) {
                                    String range_id = var.getRange().getId()
                                            .split("domain_")[1];
                                    Expression ex = new Atomic("enum_"
                                            + range_id + "[" + atom + "]");
                                    atom.setValue(ex);
                                }
                            }
                        }
                    }
                }
            }

            if (gt.getQc() != null) {
                Expression expr_qc = gt_clon.getQc().getCondition();
                List<Expression> expressions_qc = Expression
                        .splitExpressions(expr_qc);
                for (Expression expr : expressions_qc) {
                    for (Var v : Expression.getVars(expr)) {
                        if (vars.containsKey(v.getId().toString())) {
                            CSPVar var = vars.get(v.getId().toString());
                            if (var.getType().equals("{string}")) {
                                for (Atomic atom : Expression.getAtomics(expr)) {
                                    if (atom.calculate() instanceof String) {
                                        String range_id = var.getRange()
                                                .getId().split("domain_")[1];
                                        Expression ex = new Atomic("enum_"
                                                + range_id + "[" + atom + "]");
                                        atom.setValue(ex);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (Config.getInstance().getANDConstraintsBreaking()) {
                List<Expression> expressions_slo = Expression
                        .splitANDExpressions(expr_slo);
                Integer i = 1;
                for (Expression exp : expressions_slo) {
                    String id = (expressions.size() > 1) ? gt.getId() + "_" + i
                            : gt.getId();
                    CSPConstraint cons;
                    if (gt.getQc() != null) {
                        cons = new CSPConstraint(id, new SLO(exp),
                                gt_clon.getQc());
                    } else {
                        cons = new CSPConstraint(id, new SLO(exp));
                    }
                    this.model.addConstraint(cons);
                    i++;
                }
            } else {
                CSPConstraint cons;
                if (gt.getQc() != null) {
                    cons = new CSPConstraint(gt.getId(), gt_clon.getSlo(),
                            gt_clon.getQc());
                } else {
                    cons = new CSPConstraint(gt.getId(), gt_clon.getSlo());
                }
                this.model.addConstraint(cons);
            }
        } catch (Exception e) {
            LOG.severe("[CSPBuilder.setGuaranteeTerm()] There was an error: " + e.getMessage());
        }
    }

    @Override
    public void setCreationConstraint(CreationConstraint cc) {
        if (this.model == null) {
            this.model = new CSPModel();
        }

        CSPConstraint cons;
        CreationConstraint cc_clon = cc.clone();
        Expression expr_slo = cc_clon.getSlo().getExpression();
        List<Expression> expressions = Expression.splitExpressions(expr_slo);

        for (Expression expr : expressions) {
            for (Var v : Expression.getVars(expr)) {
                if (vars.containsKey(v.getId().toString())) {
                    CSPVar var = vars.get(v.getId().toString());
                    if (var.getType().equals("{string}")) {
                        for (Atomic atom : Expression.getAtomics(expr)) {
                            if (atom.calculate() instanceof String) {
                                String range_id = var.getRange().getId()
                                        .split("domain_")[1];
                                Expression ex = new Atomic("enum_" + range_id
                                        + "[" + atom + "]");
                                atom.setValue(ex);
                            }
                        }
                    }
                }
            }
        }

        if (cc.getQc() != null) {
            Expression expr_qc = cc_clon.getQc().getCondition();

            List<Expression> expressions_qc = Expression
                    .splitExpressions(expr_qc);

            for (Expression expr : expressions_qc) {
                for (Var v : Expression.getVars(expr)) {
                    if (vars.containsKey(v.getId().toString())) {
                        CSPVar var = vars.get(v.getId().toString());
                        if (var.getType().equals("{string}")) {
                            for (Atomic atom : Expression.getAtomics(expr)) {
                                if (atom.calculate() instanceof String) {
                                    String range_id = var.getRange().getId()
                                            .split("domain_")[1];
                                    Expression ex = new Atomic("enum_"
                                            + range_id + "[" + atom + "]");
                                    atom.setValue(ex);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (cc.getQc() != null) {
            cons = new CSPConstraint(cc.getId(), cc_clon.getSlo(),
                    cc_clon.getQc());
        } else {
            cons = new CSPConstraint(cc.getId(), cc_clon.getSlo());
        }

        this.model.addConstraint(cons);
    }

    @Override
    public String generate() {
        return this.model.toString();
    }

    @Override
    public AbstractModel getModel() {
        return model;
    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setVersion(Double version) {
        // TODO Auto-generated method stub

    }

    public String getTypeByOpt(String originalType, Boolean useCP) {
        if (originalType.equals("real") || originalType.equals("float")) {
            return "int";
        }
        return originalType;
    }
}
