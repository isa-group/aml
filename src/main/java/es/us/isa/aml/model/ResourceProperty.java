/**
 *
 */
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jdelafuente
 *
 */
public class ResourceProperty extends MonitorableProperty {

    private static final Logger LOG = Logger.getLogger(ResourceProperty.class.getName());
    private ResourceState resourceState;

    public ResourceState getResourceState() {
        return resourceState;
    }

    public void setResourceState(ResourceState resourceState) {
        this.resourceState = resourceState;
    }

    public ResourceProperty(String id, ResourceState resourceState) {
        super(id);
        this.resourceState = resourceState;
    }

    public ResourceProperty(String id, Metric metric, ResourceState resourceState) {
        super(id, metric);
        this.resourceState = resourceState;
    }

    public ResourceProperty(Property property) {
        super(property.id, property.metric, property.definitionReference, property.expr, property.scope, property.feature);
        this.monitorReference = property.monitorReference;
        this.resourceState = new ResourceState();
    }

    public ResourceProperty(Property property, ResourceState resourceState) {
        super(property.id, property.metric, property.definitionReference, property.expr, property.scope, property.feature);
        this.monitorReference = property.monitorReference;
        this.resourceState = resourceState;
    }
    
    public ResourceProperty(String id) {
        super(id);
        this.resourceState = new ResourceState();
    }

    public ResourceProperty(String id, Metric metric) {
        super(id, metric);
        this.resourceState = new ResourceState();
    }

    @Override
    public ResourceState getValue() {
        if (resourceState == null) {
            LOG.log(Level.INFO, "Property {0} has not been initialized", this.id);
            return null;
        } else {
            return resourceState;
        }
    }

    public Map<Long, String> getAllResourceStates(String resourceId) {
        return resourceState.getAllResourceStates(resourceId);
    }

    public void addResourceStateChange(String resource, String state, Long timestamp) {
        resourceState.addResourceStateChange(resource, state, timestamp);
    }

    @Override
    public ResourceProperty clone() {

        ResourceProperty mp = new ResourceProperty(new String(getId()), getMetric().clone(), resourceState.clone());
        mp.setExpression(getExpression());
        if (getFeature() != null) {
            mp.setFeature(getFeature().clone());
        }
        mp.setScope(getScope());
        if (getDefinitionReference() != null) {
            mp.setDefinitionReference(getDefinitionReference());
        }
        if (getMonitorReference() != null) {
            mp.setMonitorReference(getMonitorReference());
        }
        return mp;
    }

}
