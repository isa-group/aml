/**
 *
 */
package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Feature {

    private String id;
    private List<String> parameters;

    public Feature() {
        id = "";
        parameters = new ArrayList<>();
    }

    public Feature(String id) {
        this.id = id;
        parameters = new ArrayList<>();
    }

    public Feature(String id, List<String> parameters) {
        super();
        this.id = id;
        this.parameters = parameters;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the parameters
     */
    public List<String> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }
    
    @Override
    public Feature clone() {
    	Feature f = new Feature(id);
    	for(String param : parameters)
    		f.getParameters().add(param);
    	return f;
    }

}
