package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.util.Util;

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
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t" + getId() + ": " + getActor() + " guarantees " + getSlo() + ";" + "\n");

        if (!getServiceScope().isEmpty()) {
            sb.append("\t\t" + "upon " + getServiceScope());
        }

        if (getQc() != null) {
            sb.append("\t\t" + Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
                    + "(" + getQc().getCondition() + ")" + ";");
            sb.append("\n");
        }

        if (getCompensations().size() > 0) {
            for (Compensation comp : getCompensations()) {
                IAgreeCompensation compensation = (IAgreeCompensation) comp;
                sb.append("\t\t" + compensation.toString());
            }
        }

        return sb.toString();
    }

}
