/**
 *
 */
package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Enumerated extends Domain {

    private List<Object> values;

    public Enumerated() {
        this.values = new ArrayList<>();
    }
    
    public Enumerated(List<Object> values) {
        this.values = values;
    }

    /**
     * @return the values
     */
    public List<Object> getValues() {
        return this.values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<Object> values) {
        this.values = values;
    }
}
