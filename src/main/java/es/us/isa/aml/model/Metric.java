package es.us.isa.aml.model;

import es.us.isa.aml.translator.builders.iagree.model.IAgreeUtils;

/**
 * @author jdelafuente
 *
 */
public class Metric extends AgreementElement {

    private String type;
    private Domain domain;

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
    	if (IAgreeUtils.DATATYPES.containsKey(type))
			this.type = IAgreeUtils.DATATYPES.get(type);
		else
			this.type = type;
    }

    public Domain getDomain() {
        return this.domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
    
    @Override
    public Metric clone() {
    	Metric m = new Metric(id);
    	m.setType(type);
    	m.setDomain(domain);
    	return m;
    }
}
