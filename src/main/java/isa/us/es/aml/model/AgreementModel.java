package isa.us.es.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementModel {

	String id;
	Float version;
	String initiator;
	Object responder;
	Object serviceProvider;
	List<Metric> metrics;
	AgreementTerms agreementTerms;
	
	public AgreementModel() {
		id = "";
		version = 0.0f;
		responder = Actor.Provider;
		metrics = new ArrayList<Metric>();
		agreementTerms = new AgreementTerms();
	}
	
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;		
	}
	public Float getVersion() {
		return version;
	}
	public void setVersion(Float version) {
		this.version = version;
	}
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public Object getResponder() {
		return responder;
	}
	public void setResponder(Object responder) {
		this.responder = responder;
	}
	public Object getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(Object serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public List<Metric> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
	public AgreementTerms getAgreementTerms() {
		return agreementTerms;
	}
	public void setAgreementTerms(AgreementTerms agreementTerms) {
		this.agreementTerms = agreementTerms;
	}
	
}
