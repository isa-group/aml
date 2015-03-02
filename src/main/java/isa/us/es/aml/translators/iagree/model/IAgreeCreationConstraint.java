package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class IAgreeCreationConstraint extends CreationConstraint {

	
	public IAgreeCreationConstraint(String id, SLO slo) {
		super(id, slo);
	}

	@Override
    public String toString() {
        return getId() + ": " + getSlo().toString() + ";";
    }

}
