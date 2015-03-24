package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class Service {

    private String serviceName;
    private String serviceReference;
    private Map<String, Feature> features;
    private List<ConfigurationProperty> cps;

    public Service() {
        serviceName = "";
        serviceReference = "";
        features = new HashMap<>();
        cps = new ArrayList<>();
    }

    public Service(String serviceName, String serviceReference) {
        this.serviceName = serviceName;
        this.serviceReference = serviceReference;
        features = new HashMap<>();
        cps = new ArrayList<>();
    }

    public Service(String serviceName, String serviceReference,
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
}
