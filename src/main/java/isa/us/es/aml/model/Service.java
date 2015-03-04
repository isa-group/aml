package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class Service {

    private String serviceName;
    private String serviceReference;

    public Service() {
    }

    public Service(String serviceName, String serviceReference) {
        this.serviceName = serviceName;
        this.serviceReference = serviceReference;
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
}
