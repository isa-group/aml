package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AgreementTerms {

    private Service service;
    private List<MonitorableProperty> mps;
    private List<GuaranteeTerm> gts;

    public AgreementTerms() {
        this.service = new Service();
        this.mps = new ArrayList<>();
        this.gts = new ArrayList<>();
    }

    public AgreementTerms(Service service,
            List<MonitorableProperty> monitorableProperties,
            List<GuaranteeTerm> guaranteeTerms) {
        this.service = service;
        this.mps = monitorableProperties;
        this.gts = guaranteeTerms;
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
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
