/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.ServiceRole;

/**
 * @author jdelafuente
 *
 */
public class IAgreeResponder extends Responder {

    public IAgreeResponder(String id, ServiceRole roleType) {
        super(id, roleType);
    }

    @Override
    public String toString() {
        return getRoleType() + " " + getId() + " as Responder";
    }
;

}
