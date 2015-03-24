/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Feature;

/**
 * @author jdelafuente
 *
 */
public class IAgreeFeature extends Feature {

    @Override
    public String toString() {
        if (getParameters().size() > 0) {
            return getId() + "(" + getParameters().toString().replace("[", "").replace("]", "") + ")";
        } else {
            return getId();
        }
    }

}
