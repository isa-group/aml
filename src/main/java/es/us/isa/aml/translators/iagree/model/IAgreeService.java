package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Service;

/**
 * @author jdelafuente
 *
 */
public class IAgreeService extends Service {

    @Override
    public String toString() {
        return "Service " + this.getServiceName() + " availableAt. " + "\"" + this.getServiceReference() + "\"";
    }

}
