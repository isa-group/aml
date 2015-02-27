package isa.us.es.aml.translators.opl.model;

import isa.us.es.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class OPLConstraint implements Comparable<OPLConstraint> {

    private String id;
    private SLO slo;

    public OPLConstraint(String id, SLO slo) {
        super();
        this.id = id;
        this.slo = slo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SLO getSlo() {
        return slo;
    }

    public void setSlo(SLO slo) {
        this.slo = slo;
    }

    @Override
    public String toString() {
    	
    	String exp = getSlo().getExpression().toString();
    	if(!exp.contains("<=") && !exp.contains(">="))
    		exp = exp.replaceAll("=", "==");
    	
        return getId() + ": " + exp + ";";
    }

    @Override
    public int compareTo(OPLConstraint o) {
        return this.getId().compareTo(o.getId());
    }

}
