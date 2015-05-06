/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;

/**
 * @author jdelafuente
 *
 */
public class IAgreeConfigurationProperty extends ConfigurationProperty {

    public IAgreeConfigurationProperty(String id, Metric metric) {
        super(id, metric);
    }

    public IAgreeConfigurationProperty(Property cp) {
        super(cp.getId(), cp.getMetric(), cp.getExpression(), cp.getScope(), cp.getFeature());
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getId() + ": " + this.getMetric().getId());
    	
    	if(this.getDefinitionReference() != null){
        	sb.append(" definedAt " + getDefinitionReference());
        }
        
    	if (this.getExpression() != null) {
            sb.append(" = " + this.getExpression());
        }
        
        sb.append(";");
        return sb.toString();
    }
}
