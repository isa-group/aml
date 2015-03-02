package isa.us.es.aml.model;

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
        service = new Service();
        cps = new ArrayList<ConfigurationProperty>();
        mps = new ArrayList<MonitorableProperty>();
        gts = new ArrayList<GuaranteeTerm>();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ConfigurationProperty> getConfigurationProperties() {
        return cps;
    }

    public void setConfigurationProperties(List<ConfigurationProperty> cps) {
        this.cps = cps;
    }

    public List<MonitorableProperty> getMonitorableProperties() {
        return mps;
    }

    public void setMonitorableProperties(List<MonitorableProperty> mps) {
        this.mps = mps;
    }

    public List<GuaranteeTerm> getGuaranteeTerms() {
        return gts;
    }

    public void setGuaranteeTerms(List<GuaranteeTerm> gts) {
        this.gts = gts;
    }
}
