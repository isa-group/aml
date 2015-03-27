package es.us.isa.aml.translator.builders.opl.model;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.csp.CSPRange;

/**
 * @author jdelafuente
 *
 */
public class OPLRange extends CSPRange {

	public OPLRange(String id, Domain domain) {
		super(id, domain);
	}
	
	public OPLRange(String id, String domain) {
		super(id);
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "range " + this.getId() + " = " + this.getDomain() + ";";
	}
}
