/**
 * 
 */
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Range;

/**
 * @author jdelafuente
 *
 */
public class Metric {
	
	private String id;
	private String type;
    private Domain domain;

    public Metric(String id) {
    	this.id = id;
        type = "int";
        domain = new Range(0, 100);
    }

    public Metric(String id, String type, Domain domain) {
    	this.id = id;
        this.type = type;
        this.domain = domain;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
