/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Enumerated;

/**
 * @author jdelafuente
 *
 */
public class IAgreeEnumerated extends Enumerated {

    @Override
    public String toString() {
        return this.getValues().toString().replace("[", "{").replace("]", "}");
    }

}
