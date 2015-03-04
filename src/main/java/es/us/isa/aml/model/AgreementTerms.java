package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AgreementTerms {

    private Service service;
    private List<ConfigurationProperty> cps;
    private List<MonitorableProperty> mps;
    private List<GuaranteeTerm> gts;

    public AgreementTerms() {
        this.service = new Service();
        this.cps = new ArrayList<>();
        this.mps = new ArrayList<>();
        this.gts = new ArrayList<>();
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ConfigurationProperty> getConfigurationProperties() {
        return this.cps;
    }

    public void setConfigurationProperties(List<ConfigurationProperty> cps) {
        this.cps = cps;
    }

    public List<MonitorableProperty> getMonitorableProperties() {
        return this.mps;
    }

    public void setMonitorableProperties(List<MonitorableProperty> mps) {
        this.mps = mps;
    }

    public List<GuaranteeTerm> getGuaranteeTerms() {
        return this.gts;
    }

    public void setGuaranteeTerms(List<GuaranteeTerm> gts) {
        this.gts = gts;
    }
}
