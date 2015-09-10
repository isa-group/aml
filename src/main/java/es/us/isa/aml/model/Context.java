/**
 *
 */
package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class Context {

	private String templateId;
	private Double templateVersion;
	private Actor initiator;
    private Actor responder;
    private Map<String, Metric> metrics;

    /**
     *
     */
    public Context() {
        metrics = new HashMap<>();
    }
    
    /**
     * @return the templateId
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the templateVersion
     */
    public Double getTemplateVersion() {
        return this.templateVersion;
    }

    /**
     * @param templateVersion the templateVersion to set
     */
    public void setTemplateVersion(Double templateVersion) {
        this.templateVersion = templateVersion;
    }

    public Actor getInitiator() {
        return this.initiator;
    }

    public void setInitiator(Actor initiator) {
        this.initiator = initiator;
    }

    public Actor getResponder() {
        return this.responder;
    }

    public void setResponder(Actor responder) {
        this.responder = responder;
    }

    public Map<String, Metric> getMetrics() {
        return this.metrics;
    }

    public void setMetrics(Map<String, Metric> metrics) {
        this.metrics = metrics;
    }
    
    @Override
    public Context clone() {
    	Context ctx = new Context();
    	ctx.setInitiator(initiator);
    	ctx.setResponder(responder);
    	ctx.setTemplateId(templateId);
    	ctx.setTemplateVersion(templateVersion);
    	for(Metric metric : metrics.values()){
    		Metric m = metric.clone();
    		ctx.getMetrics().put(m.getId(), m);
    	}
    	return ctx;
    }

}
