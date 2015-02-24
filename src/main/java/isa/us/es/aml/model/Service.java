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
		super();
		this.serviceName = serviceName;
		this.serviceReference = serviceReference;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceReference() {
		return serviceReference;
	}

	public void setServiceReference(String serviceReference) {
		this.serviceReference = serviceReference;
	}
	
	@Override
	public String toString() {
		return "Service " + getServiceName() + " availableAt. "  + "\"" + getServiceReference() + "\"";
	}

}
