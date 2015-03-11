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
    private Actor roleType;

    public Responder() {
        id = "";
        roleType = null;
    }

    public Responder(String id, Actor roleType) {
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
    public Actor getRoleType() {
        return roleType;
    }

    /**
     * @param roleType the roleType to set
     */
    public void setRoleType(Actor roleType) {
        this.roleType = roleType;
    }

}
