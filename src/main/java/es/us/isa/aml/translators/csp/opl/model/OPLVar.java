package es.us.isa.aml.translators.csp.opl.model;

import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public final class OPLVar {

    private String id;
    private String type;
    private OPLRange range;
    private Expression value;
    private Boolean dvar;

    public OPLVar(String id, Metric metric, OPLRange range, boolean dvar) {
        this.id = id;
        this.setType(metric.getType());
        this.range = range;
        this.dvar = dvar;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = OPLUtil.DATATYPES.get(type);
    }

    public OPLRange getRange() {
        return this.range;
    }

    public void setRange(OPLRange range) {
        this.range = range;
    }

    public Expression getExpression() {
        return this.value;
    }

    public void setExpression(Expression value) {
        this.value = value;
    }

    public Boolean getDvar() {
        return this.dvar;
    }

    public void setDvar(Boolean dvar) {
        this.dvar = dvar;
    }

    @Override
    public String toString() {
        if (this.dvar) {
            return "dvar " + this.getType() + " " + this.getId() + " in " + this.getRange().getId() + ";";
        } else {
            return this.getType() + " " + this.getId() + " = " + this.getExpression();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OPLVar) {
            OPLVar elem = (OPLVar) obj;
            return id.equals(elem.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

}
