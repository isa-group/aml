package es.us.isa.aml.translator.builders.opl.model;

import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;

/**
 * @author jdelafuente
 *
 */
public class OPLVar extends CSPVar {
    
	
	public OPLVar(String id, Metric metric, CSPRange range, boolean dvar) {
		super(id, metric, range, dvar);
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
