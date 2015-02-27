package isa.us.es.aml.translators.csp.opl.model;

import isa.us.es.aml.model.Domain;
import isa.us.es.aml.model.Enumerated;
import isa.us.es.aml.model.Range;

import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class OPLRange {

    private String id;
    private String domain;

    public OPLRange(String id, Domain domain) {
        this.id = id;        
        setDomain(domain);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
    	Range range = null;
    	
    	if (domain instanceof Enumerated) {
            // TODO mapear enumerado
            List<Object> values = ((Enumerated) domain).getValues();
            range = new Range(0, values.size() - 1);
        } else if (domain instanceof Range) {
        	range = (Range) domain;
        }
    	
        this.domain = range.getMin() + ".." + range.getMax();
    }

    @Override
    public String toString() {
        return "range " + getId() + " = " + getDomain() + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OPLRange) {
            OPLRange elem = (OPLRange) obj;
            return this.id.equals(elem.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
