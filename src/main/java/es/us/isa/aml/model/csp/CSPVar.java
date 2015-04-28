package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class CSPVar {

	protected Property prop;
	protected String id;
	protected String type;
	protected CSPRange range;
	protected Expression value;
	protected Boolean dvar;

	public CSPVar(Property p, CSPRange range, Boolean dvar) {
		this.prop = p;
		this.id = p.getId();
		this.setType(p.getMetric().getType());
		this.range = range;
		this.dvar = dvar;
	}

	public CSPVar(Property p, String type, Boolean dvar) {
		this.prop = p;
		this.id = p.getId();
		this.setType(type);
		this.dvar = dvar;
	}

	public CSPVar(String id, String type, Boolean dvar) {
		this.id = id;
		this.setType(type);
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
		if (CSPUtil.DATATYPES.containsKey(type))
			this.type = CSPUtil.DATATYPES.get(type);
		else
			this.type = type;
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

	public Property getProp() {
		return prop;
	}

	public void setProp(Property prop) {
		this.prop = prop;
	}

	@Override
	public CSPVar clone() {
		CSPVar var = null;
		if (getProp() != null)
			var = new CSPVar(getProp().clone(), getRange(), getDvar());
		else {
			var = new CSPVar(getId(), getType(), getDvar());
			if(getRange() != null)
				var.setRange(getRange().clone());
		}

		if (var != null && getExpression() != null)
			var.setExpression(Expression.parse(getExpression().toString()));
		return var;
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
		return this.id.hashCode() * 31;
	}

	@Override
	public String toString() {
		if (this.dvar) {
			if (getType().equals("boolean"))
				return "dvar " + this.getType() + " " + this.getId() + ";";
			else if (getType().equals("{string}"))
				return "dvar " + "int " + this.getId() + " in "
						+ this.getRange().getDomain() + ";";
			else {
				return "dvar " + this.getType() + " " + this.getId() + " in "
						+ this.getRange().getId() + ";";
			}
		} else {
			if (getType().equals("{string}")) {
				StringBuilder sb = new StringBuilder();
				if (getExpression() != null) {
					sb.append(this.getType() + " " + this.getId() + " = "
							+ getExpression().toString());
				} else {
					sb.append(this.getType() + " " + this.getId());
				}
				sb.append(";");
				return sb.toString();
			} else {
				if (getRange() != null) {
					if (getExpression() != null)
						return this.getType() + " " + this.getId() + "["
								+ getRange().getId() + "]" + " = "
								+ this.getExpression() + ";";
					else
						return this.getType() + " " + this.getId() + "["
								+ getRange().getId() + "]" + ";";
				} else {
					if (getExpression() != null)
						return this.getType() + " " + this.getId() + " = "
								+ this.getExpression();
					else
						return this.getType() + " " + this.getId() + ";";
				}
			}
		}
	}

}
