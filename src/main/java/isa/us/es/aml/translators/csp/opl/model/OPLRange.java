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
    private Domain domain;

    public OPLRange(String id, Domain domain) {
        this.id = id;
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        String res = "";

        if (Enumerated.class.isAssignableFrom(getDomain().getClass())) {
            // TODO mapear enumerado
            List<Object> values = ((Enumerated) getDomain()).getValues();
            res = "range " + getId() + " in " + new Range(0, values.size() - 1) + ";";
        } else if (Range.class.isAssignableFrom(getDomain().getClass())) {
            res = "range " + getId() + " in " + ((Range) getDomain()) + ";";
        }

        return res;
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
