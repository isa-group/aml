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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n" + "AgreementTerms" + "\n");
		sb.append("\t" + getService().toString() + "\n");
		
		sb.append("\t\t" + "GlobalDescription" + "\n");
		List<ConfigurationProperty> cps = getConfigurationProperties();
		for(ConfigurationProperty cp : cps){
			if(cp.getScope() == Scope.Global)
				sb.append("\t\t\t" + cp.toString() + "\n");
		}
		sb.append("\n" + "\t" + "MonitorableProperties" + "\n");
		sb.append("\t\t" + "global:" + "\n");
		List<MonitorableProperty> mps = getMonitorableProperties();
		for(MonitorableProperty mp : mps){
			if(mp.getScope() == Scope.Global)
				sb.append("\t\t\t" + mp.toString() + "\n");
		}
		
		sb.append("\n" + "\t" + "GuaranteeTerms" + "\n");
		List<GuaranteeTerm> gts = getGuaranteeTerms();
		for(GuaranteeTerm gt : gts)
			sb.append("\t\t" + gt.toString() + "\n");
		
		return sb.toString();
	}



}
