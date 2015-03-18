package es.us.isa.aml.translators.wsag.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Description Terms (SDTs) are a fundamental component of an agreement:
 * the agreement is about the service(s) — existing or not — described by the SDTs.
 * The provisioning of this service may be conditional to specific run-time constraints,
 * and additional service level objectives on how the service is performed may be
 * imposed by the service guarantee; service description terms define the functionality
 * that will be delivered under an agreement. The service description content itself is
 * dependent on the particular domain.
 * @author jdelafuente
 *
 */
public class ServiceDescriptionTerm {
	
	/**
	 * The MANDATORY name attribute (of String) represents the name given
	 * to a term. Since an Agreement MAY encompass multiple
	 * ServiceDescriptionTerms related to the same service each term SHOULD be
	 * given a unique name to make structural referencing of service description terms
	 * more convenient
	 */
	private String name;
	
	/**
	 * This MANDATORY attribute identifies a service across multiple service description
	 * terms. The service description term is defined as “being about” the service
	 * identified by the serviceName attribute. This identifier is scoped within the
	 * agreement i.e. it is not meant to identify the service outside of the agreement.
	 */
	private String serviceName;
	
	private String serviceReference;

	private List<OfferItem> offerItems;

	
	public ServiceDescriptionTerm() {
		name = "";
		offerItems = new ArrayList<OfferItem>();
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	/**
	 * @return the serviceReference
	 */
	public String getServiceReference() {
		return serviceReference;
	}


	/**
	 * @param serviceReference the serviceReference to set
	 */
	public void setServiceReference(String serviceReference) {
		this.serviceReference = serviceReference;
	}
	
	/**
	 * @return the offerItems
	 */
	public List<OfferItem> getOfferItems() {
		return offerItems;
	}

	/**
	 * @param offerItems the offerItems to set
	 */
	public void setOfferItems(List<OfferItem> offerItems) {
		this.offerItems = offerItems;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\t\t\t" + "<wsag:ServiceDescriptionTerm wsag:Name=\"" + getName() + 
				"\" wsag:ServiceName=\""+ getServiceName() + "\" \n\t\t\tiag:ServiceReference=\""+ getServiceReference() + "\">").append("\n");
		
		for(OfferItem oi : getOfferItems())
			sb.append("\t\t\t\t" + oi.toString());
		
		sb.append("\t\t\t" + "</wsag:ServiceDescriptionTerm>");
		
		return sb.toString();
	}

}
