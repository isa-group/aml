package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class ServiceConfiguration {

    private String serviceName;
    private String endpointReference;
    private String definitionReference;
    private String monitorReference;
    private Map<String, Feature> features;
    private Map<String, ConfigurationProperty> cps;

    public ServiceConfiguration() {
        serviceName = "";
        endpointReference = "";
        features = new HashMap<>();
        cps = new HashMap<>();
    }

    public ServiceConfiguration(String serviceName, String serviceReference) {
        this.serviceName = serviceName;
        this.endpointReference = serviceReference;
        features = new HashMap<>();
        cps = new HashMap<>();
    }

	public ServiceConfiguration(String serviceName, String serviceReference,
			Map<String, Feature> features,
			Map<String, ConfigurationProperty> configurationProperties) {
		this.serviceName = serviceName;
        this.endpointReference = serviceReference;
        this.features = features;
        cps = configurationProperties;
	}

	public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public String getEndpointReference() {
		return endpointReference;
	}

	public void setEndpointReference(String endpointReference) {
		this.endpointReference = endpointReference;
	}

	public String getDefinitionReference() {
		return definitionReference;
	}

	public void setDefinitionReference(String definitionReference) {
		this.definitionReference = definitionReference;
	}

	public String getMonitorReference() {
		return monitorReference;
	}

	public void setMonitorReference(String monitorReference) {
		this.monitorReference = monitorReference;
	}

    public Map<String, Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, Feature> features) {
        this.features = features;
    }

    public Map<String, ConfigurationProperty> getConfigurationProperties() {
        return this.cps;
    }

    public void setConfigurationProperties(Map<String, ConfigurationProperty> cps) {
        this.cps = cps;
    }
    
    @Override
    public ServiceConfiguration clone(){
    	ServiceConfiguration sc = new ServiceConfiguration();
    	sc.setServiceName(serviceName);
    	sc.setEndpointReference(endpointReference);
    	for(Feature feature : features.values()){
    		Feature f = feature.clone();
    		sc.getFeatures().put(f.getId(), f);
    	}
    	for(ConfigurationProperty cp : getConfigurationProperties().values())
    		sc.getConfigurationProperties().put(cp.getId(), cp.clone());
    	
    	return sc;
    }
}
