package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AgreementTerms {

    private ServiceConfiguration service;
    private List<MonitorableProperty> mps;
    private List<GuaranteeTerm> gts;

    public AgreementTerms() {
        this.service = new ServiceConfiguration();
        this.mps = new ArrayList<>();
        this.gts = new ArrayList<>();
    }

	public AgreementTerms(ServiceConfiguration service,
			List<MonitorableProperty> monitorableProperties,
			List<GuaranteeTerm> guaranteeTerms) {
		this.service = service; // ServiceReference
        this.mps = monitorableProperties;
        this.gts = guaranteeTerms;
	}

	public ServiceConfiguration getService() {
        return this.service;
    }

    public void setService(ServiceConfiguration service) {
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
    
    @Override
    public AgreementTerms clone() {
    	AgreementTerms at = new AgreementTerms();
    	ServiceConfiguration sc = service.clone();
    	at.setService(sc);
    	for(MonitorableProperty mp : mps)
    		at.getMonitorableProperties().add(mp.clone());
    	
    	for(GuaranteeTerm gt : gts)
    		at.getGuaranteeTerms().add(gt.clone());
    	
    	return at;    	
    }
}
