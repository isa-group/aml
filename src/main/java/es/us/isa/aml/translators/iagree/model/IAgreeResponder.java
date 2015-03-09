/**
 * 
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Responder;

/**
 * @author jdelafuente
 *
 */
public class IAgreeResponder extends Responder {
	
	
	public IAgreeResponder(String id, Actor roleType) {
		super(id, roleType);
	}

	@Override
	public String toString() {
		return getRoleType() + " " + getId() + " as Responder";
	};

}
