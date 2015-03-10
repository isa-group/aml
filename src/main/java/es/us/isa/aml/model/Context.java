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
    private Responder responder;
    private String provider;
    private String consumer;
    private Object serviceProvider;
    private List<Metric> metrics;

    /**
     *
     */
    public Context() {
        initiator = "";
        responder = null;
        provider = "";
        consumer = "";
        serviceProvider = null;
        metrics = new ArrayList<>();
    }

    public String getInitiator() {
        return this.initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Responder getResponder() {
        return this.responder;
    }

    public void setResponder(Responder responder) {
        this.responder = responder;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
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
