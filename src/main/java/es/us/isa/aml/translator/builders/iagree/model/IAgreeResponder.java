/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.ServiceRole;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class IAgreeResponder extends Responder {

    public IAgreeResponder(String id, ServiceRole roleType) {
        super(id, roleType);
    }

    public IAgreeResponder(Responder r) {
        super(r.getId(), r.getRoleType());
    }

    @Override
    public String toString() {
        return getRoleType() + " \"" + Util.withoutDoubleQuotes(getId()) + "\" as Responder";
    }
;

}
