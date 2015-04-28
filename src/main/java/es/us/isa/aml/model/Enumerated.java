/**
 *
 */
package es.us.isa.aml.model;



/**
 * @author jdelafuente
 *
 */
public class Enumerated extends Domain {

    private Object[] values;

    public Enumerated() {
        this.values = new Object[0];
    }

    public Enumerated(Object[] values) {
        this.values = values;
    }

    /**
     * @return the values
     */
    public Object[] getValues() {
        return this.values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(Object[] values) {
        this.values = values;
    }
}
