package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Actor;
import isa.us.es.aml.model.GuaranteeTerm;
import isa.us.es.aml.model.SLO;

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
