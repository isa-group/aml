package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class CSPVar {

	protected String id;
    protected String type;
    protected CSPRange range;
    protected Expression value;
    protected Boolean dvar;

    public CSPVar(String id, Metric metric, CSPRange range, boolean dvar) {
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
        this.type = CSPUtil.DATATYPES.get(type);
    }

    public CSPRange getRange() {
        return this.range;
    }

    public void setRange(CSPRange range) {
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
    public boolean equals(Object obj) {
        if (obj instanceof CSPVar) {
        	CSPVar elem = (CSPVar) obj;
            return id.equals(elem.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    
    @Override
    public String toString() {
        if (this.dvar) {
            return "dvar " + this.getType() + " " + this.getId() + " in " + this.getRange().getId() + ";";
        } else {
            return this.getType() + " " + this.getId() + " = " + this.getExpression();
        }
    }

}
