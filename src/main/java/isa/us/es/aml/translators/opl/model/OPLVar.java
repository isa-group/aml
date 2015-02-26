package isa.us.es.aml.translators.opl.model;

import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class OPLVar {

    private String id;
    private String type;
    private Metric metric;
    private Expression value;
    private Boolean dvar;

    public OPLVar(String id, Metric metric, Boolean dvar) {
        super();
        this.id = id;
        this.type = metric.getType();
        this.metric = metric;
        this.dvar = dvar;
    }

    public OPLVar(String id, Metric metric, Expression value, Boolean dvar) {
        super();
        this.id = id;
        this.type = metric.getType();
        this.metric = metric;
        this.value = value;
        this.dvar = dvar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Expression getExpression() {
        return value;
    }

    public void setExpression(Expression value) {
        this.value = value;
    }

    public Boolean getDvar() {
        return dvar;
    }

    public void setDvar(Boolean dvar) {
        this.dvar = dvar;
    }

    @Override
    public String toString() {
        if (dvar) {
            return "dvar " + getType() + " " + getId() + " in " + getMetric().getId() + ";";
        } else {
            return getType() + " " + getId() + " = " + getExpression();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OPLVar) {
            OPLVar elem = (OPLVar) obj;
            return this.id.equals(elem.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
