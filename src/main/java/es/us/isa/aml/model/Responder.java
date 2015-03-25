/**
 *
 */
package es.us.isa.aml.model;

/**
 * @author jdelafuente
 *
 */
public class Responder {

    private String id;
    private ServiceRole roleType;

    public Responder() {
        id = "";
        roleType = null;
    }

    public Responder(String id, ServiceRole roleType) {
        this.id = id;
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
     * @return the roleType
     */
    public ServiceRole getRoleType() {
        return roleType;
    }

    /**
     * @param roleType the roleType to set
     */
    public void setRoleType(ServiceRole roleType) {
        this.roleType = roleType;
    }
    
    @Override
    public Responder clone() {
    	Responder r = new Responder();
    	r.setId(id);
    	r.setRoleType(roleType);
    	return r;
    }

}
