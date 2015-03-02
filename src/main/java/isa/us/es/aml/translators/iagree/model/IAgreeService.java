package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Service;

/**
 * @author jdelafuente
 *
 */
public class IAgreeService extends Service {
	
    @Override
    public String toString() {
        return "Service " + getServiceName() + " availableAt. " + "\"" + getServiceReference() + "\"";
    }

}
