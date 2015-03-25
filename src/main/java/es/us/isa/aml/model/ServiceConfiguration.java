package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class ServiceConfiguration {

    private String serviceName;
    private String serviceReference;
    private Map<String, Feature> features;
    private List<ConfigurationProperty> cps;

    public ServiceConfiguration() {
        serviceName = "";
        serviceReference = "";
        features = new HashMap<>();
        cps = new ArrayList<>();
    }

    public ServiceConfiguration(String serviceName, String serviceReference) {
        this.serviceName = serviceName;
        this.serviceReference = serviceReference;
        features = new HashMap<>();
        cps = new ArrayList<>();
    }

	public ServiceConfiguration(String serviceName, String serviceReference,
			Map<String, Feature> features,
			List<ConfigurationProperty> configurationProperties) {
		this.serviceName = serviceName;
        this.serviceReference = serviceReference;
        this.features = features;
        cps = configurationProperties;
	}

	public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceReference() {
        return this.serviceReference;
    }

    public void setServiceReference(String serviceReference) {
        this.serviceReference = serviceReference;
    }

    public Map<String, Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, Feature> features) {
        this.features = features;
    }

    public List<ConfigurationProperty> getConfigurationProperties() {
        return this.cps;
    }

    public void setConfigurationProperties(List<ConfigurationProperty> cps) {
        this.cps = cps;
    }
    
    @Override
    public ServiceConfiguration clone(){
    	ServiceConfiguration sc = new ServiceConfiguration();
    	sc.setServiceName(serviceName);
    	sc.setServiceReference(serviceReference);
    	for(Feature feature : features.values()){
    		Feature f = feature.clone();
    		sc.getFeatures().put(f.getId(), f);
    	}
    	for(ConfigurationProperty cp : getConfigurationProperties())
    		sc.getConfigurationProperties().add(cp.clone());
    	
    	return sc;
    }
}
