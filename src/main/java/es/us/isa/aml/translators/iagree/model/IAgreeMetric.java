package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Metric;

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
        return this.getId() + ": " + this.getType() + this.getDomain();
    }

}
