/**
 *
 */
package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Enumerated;

/**
 * @author jdelafuente
 *
 */
public class IAgreeEnumerated extends Enumerated {

    @Override
    public String toString() {
        return getValues().toString().replace("[", "{").replace("]", "}");
    }

}
