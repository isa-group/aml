package es.us.isa.classes;

import java.io.Serializable;

/**
 * Applied Software Engineering Research Group (ISA Group)
 * University of Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */


public class Property implements Serializable {


    private static final long serialVersionUID = -495977788092510032L;

    private String id;
    private Object value;
    private String metric;
    private String scope;

    public Property() {
        super();
        this.id = null;
        this.value = null;
        this.metric = null;
        this.scope = null;
    }


    public Property(String id, Object value, String metric, String scope) {
        super();
        this.id = id;
        this.value = value;
        this.metric = metric;
        this.scope = scope;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


}
