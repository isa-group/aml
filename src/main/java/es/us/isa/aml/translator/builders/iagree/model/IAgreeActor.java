/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.RoleType;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class IAgreeActor extends Actor {

	public IAgreeActor(String id, Role role, RoleType roleType) {
		super(id, role, roleType);
	}

	public IAgreeActor(Actor a) {
		super(a.getId(), a.getRole(), a.getRoleType());
	}

	@Override
	public String toString() {
		return getRole() + " \"" + Util.withoutDoubleQuotes(getId()) + "\" as "
				+ getRoleType();
	};

}
