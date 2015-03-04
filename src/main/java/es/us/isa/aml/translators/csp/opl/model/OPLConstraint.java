package es.us.isa.aml.translators.csp.opl.model;

import es.us.isa.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class OPLConstraint implements Comparable<OPLConstraint> {

    private String id;
    private SLO slo;

    public OPLConstraint(String id, SLO slo) {
        this.id = id;
        this.slo = slo;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SLO getSlo() {
        return this.slo;
    }

    public void setSlo(SLO slo) {
        this.slo = slo;
    }

    @Override
    public String toString() {

        String exp = this.getSlo().getExpression().toString();
        if (!exp.contains("<=") && !exp.contains(">=")) {
            exp = exp.replaceAll("=", "==");
        }

        exp = exp.replace("AND", "&&");
        exp = exp.replace("OR", "||");

        return this.getId() + ": " + exp + ";";
    }

    @Override
    public int compareTo(OPLConstraint o) {
        return getId().compareTo(o.getId());
    }

}
