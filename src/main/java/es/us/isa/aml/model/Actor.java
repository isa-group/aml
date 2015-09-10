/**
 *
 */
package es.us.isa.aml.model;

/**
 * @author jdelafuente
 *
 */
public class Actor {

    private String id;
    private Role role;
    private RoleType roleType;

    public Actor() {
        id = "";
        role = null;
        roleType = null;
    }

    public Actor(String id, Role role, RoleType roleType) {
        this.id = id;
        this.role = role;
        this.roleType = roleType;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
     * @return the roleType
     */
    public RoleType getRoleType() {
        return roleType;
    }

    /**
     * @param roleType the roleType to set
     */
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
    @Override
    public Actor clone() {
    	Actor a = new Actor();
    	a.setId(id);
    	a.setRole(role);
    	a.setRoleType(roleType);
    	return a;
    }

}
