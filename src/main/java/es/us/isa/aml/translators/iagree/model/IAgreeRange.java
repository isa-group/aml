package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class IAgreeRange extends Range {

    /**
     * @param min
     * @param max
     */
    public IAgreeRange(Integer min, Integer max) {
        super(min, max);
    }

    @Override
    public String toString() {
        String res = "[" + this.min + ".." + this.max + "]";
        return res;
    }
}
