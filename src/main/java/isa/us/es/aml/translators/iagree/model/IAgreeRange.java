package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class IAgreeRange extends Range {

    /**
     * @param valueOf
     * @param valueOf2
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
