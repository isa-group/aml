package es.us.isa.aml.model;

import es.us.isa.aml.AgreementManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementModel {

    private String id;
    private Float version;
    private String initiator;
    private Object responder;
    private Object serviceProvider;
    private List<Metric> metrics;
    private AgreementTerms agreementTerms;
    private AgreementManager agreementManager;

    public AgreementModel() {
        this.id = "";
        this.version = 0.0f;
        this.responder = Actor.Provider;
        this.metrics = new ArrayList<>();
        this.agreementTerms = new AgreementTerms();
    }

    public AgreementModel(AgreementManager agreementManager) {
        super();
        this.agreementManager = agreementManager;

    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public Float getVersion() {
        return this.version;
    }

    public void setVersion(Float version) {
        this.version = version;
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

    public AgreementTerms getAgreementTerms() {
        return this.agreementTerms;
    }

    public void setAgreementTerms(AgreementTerms agreementTerms) {
        this.agreementTerms = agreementTerms;
    }

    public void setAgreementManager(AgreementManager agreementManager) {
        this.agreementManager = agreementManager;
    }

    // OPERATIONS -  This should be syncronized with AgreementManager methods
    public Boolean isValid() {
        return agreementManager.isValid(this);
    }

}
