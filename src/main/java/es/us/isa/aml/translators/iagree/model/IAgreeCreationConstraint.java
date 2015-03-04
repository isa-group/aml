package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class IAgreeCreationConstraint extends CreationConstraint {

    public IAgreeCreationConstraint(String id, SLO slo) {
        super(id, slo);
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getSlo() + ";";
    }

}
