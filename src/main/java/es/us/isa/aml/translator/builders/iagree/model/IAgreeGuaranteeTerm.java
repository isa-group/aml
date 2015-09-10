package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class IAgreeGuaranteeTerm extends GuaranteeTerm {

    public IAgreeGuaranteeTerm(String id) {
        super(id);
    }

    public IAgreeGuaranteeTerm(String id, Role role, SLO slo) {
        super(id, role, slo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t").append(getId()).append(": ").append(getRole()).append(" guarantees ").append(getSlo()).append(";" + "\n");

        if (getServiceScope() != null && !getServiceScope().isEmpty()) {
            sb.append("\t\t\t" + "upon ").append(getServiceScope());
        }

        if (getQc() != null) {
            sb.append("\t\t\t").append(Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])).append("(").append(getQc().getCondition()).append(")" + ";");
            sb.append("\n");
        }

        if (getCompensations().size() > 0) {
            for (Compensation comp : getCompensations()) {
                IAgreeCompensation compensation = (IAgreeCompensation) comp;
                sb.append("\t\t\t").append(compensation.toString());
            }
        }

        return sb.toString();
    }

}
