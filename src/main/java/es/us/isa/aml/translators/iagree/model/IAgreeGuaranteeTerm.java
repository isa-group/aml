package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.QualifyingCondition;
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
    
    public IAgreeGuaranteeTerm(String id, Actor actor, SLO slo, QualifyingCondition qc) {
        super(id, actor, slo, qc);
    }

    @Override
    public String toString() {
    	if(getQc() == null)
    		return getId() + ": " + getActor() + " guarantees " + getSlo() + ";";
    	else {
    		StringBuilder sb = new StringBuilder();
    		sb.append(getId() + ": " + getActor() + " guarantees " + getSlo() + ";" + "\n");
    		sb.append(Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF]) + "(" + getQc().getCondition() + ")" + ";");
    		return sb.toString();
    	}		
    }

}
