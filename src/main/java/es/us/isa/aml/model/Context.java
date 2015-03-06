/**
 * 
 */
package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Context {
	
	private String initiator;
	private Object responder;
	private Object serviceProvider;
	private List<Metric> metrics;
    
    /**
	 * 
	 */
	public Context() {
		initiator = "";
		responder = null;
		serviceProvider = null;
        metrics = new ArrayList<>();
	}
	
	public String getInitiator() {
        return this.initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Object getResponder() {
        return this.responder;
    }

    public void setResponder(Object responder) {
        this.responder = responder;
    }

    public Object getServiceProvider() {
        return this.serviceProvider;
    }

    public void setServiceProvider(Object serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public List<Metric> getMetrics() {
        return this.metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

}
