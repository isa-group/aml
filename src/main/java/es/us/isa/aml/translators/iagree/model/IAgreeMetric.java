package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Range;

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

	public IAgreeMetric(Metric m) {
		super(m.getId(), m.getType(), m.getDomain());
	}

	@Override
    public String toString() {
		String res = "";
		if(getDomain() instanceof Range){
			IAgreeRange range = new IAgreeRange(((Range) getDomain()).getMin(), ((Range) getDomain()).getMax());
			res = this.getId() + ": " + this.getType() + range + ";";
		} else if(getDomain() instanceof Enumerated){
			IAgreeEnumerated enume = new IAgreeEnumerated();
			enume.setValues(((Enumerated) getDomain()).getValues());
			res = this.getId() + ": " + this.getType() + enume + ";";
		}
        return res;
    }

}
