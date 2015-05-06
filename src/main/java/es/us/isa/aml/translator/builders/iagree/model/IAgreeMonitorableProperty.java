/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;

/**
 * @author jdelafuente
 *
 */
public class IAgreeMonitorableProperty extends MonitorableProperty {

    public IAgreeMonitorableProperty(String id, Metric metric) {
        super(id, metric);
    }

    public IAgreeMonitorableProperty(Property mp) {
        super(mp.getId(), mp.getMetric(), mp.getExpression(), mp.getScope(), mp.getFeature());
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getId() + ": " + this.getMetric().getId());
    	
    	if(this.getDefinitionReference() != null){
        	sb.append(" definedAt " + getDefinitionReference());
        }
        
        if(this.getMonitorReference() != null){
        	sb.append( " monitoredAt " + getMonitorReference());
        }
    	
        if (this.getExpression() != null) {
            sb.append(" = " + this.getExpression());
        }
        
        sb.append(";");
        return sb.toString();
    }
}
