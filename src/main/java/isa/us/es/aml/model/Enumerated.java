/**
 *
 */
package isa.us.es.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Enumerated extends Domain {

    private List<Object> values;

    public Enumerated() {
        values = new ArrayList<Object>();
    }

    /**
     * @return the values
     */
    public List<Object> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<Object> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return getValues().toString().replace("[", "{").replace("]", "}");
    }

}
