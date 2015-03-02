package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Domain;
import isa.us.es.aml.model.Metric;

/**
 * @author jdelafuente
 *
 */
public class IAgreeMetric extends Metric {

    
	public IAgreeMetric(String id) {
		super(id);
	}
	
	public IAgreeMetric(String id, String type, Domain domain) {
		super(id, type, domain);
	}

	@Override
    public String toString() {
        return getId() + ": " + getType() + getDomain();
    }

}
