package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class IAgreeGuaranteeTerm extends GuaranteeTerm {

    public IAgreeGuaranteeTerm(String id, Actor actor, SLO slo) {
        super(id, actor, slo);
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getActor() + " guarantees " + this.getSlo() + ";";
    }

}
