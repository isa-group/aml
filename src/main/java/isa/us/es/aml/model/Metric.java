package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class Metric extends AgreementElement {

    String type;
    Domain domain;

    public Metric(String id) {
        super(id);
        type = "int";
        domain = new Range(0, 100);
    }

    public Metric(String id, String type, Domain domain) {
        super(id);
        this.type = type;
        this.domain = domain;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Domain getDomain() {
        return this.domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
