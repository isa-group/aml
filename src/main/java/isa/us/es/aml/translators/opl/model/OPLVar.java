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
    private OPLRange range;
    private Expression value;
    private Boolean dvar;

  	public OPLVar(String id, Metric metric, OPLRange range, boolean dvar) {
  		super();
          this.id = id;
          setType(metric.getType());
          this.range = range;
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
    	this.type = OPLUtil.DATATYPES.get(type);
    }

    public OPLRange getRange() {
        return range;
    }

    public void setRange(OPLRange range) {
        this.range = range;
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
            return "dvar " + getType() + " " + getId() + " in " + getRange().getId() + ";";
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
