package es.us.isa.classes;

import java.io.Serializable;

/**
 * Applied Software Engineering Research Group (ISA Group)
 * University of Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */


public class Guarantee implements Serializable {

    private static final long serialVersionUID = -4331521110615550457L;

    private String id;
    private String rol;
    private String expresion;

    public Guarantee() {
        super();
        this.id = null;
        this.rol = null;
        this.expresion = null;
    }


    public Guarantee(String id, String rol, String expresion) {
        super();
        this.id = id;
        this.rol = rol;
        this.expresion = expresion;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

}
