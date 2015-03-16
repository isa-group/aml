/**
 * 
 */
package es.us.isa.aml.translators.wsag.model;

/**
 * The Service Level Objective element in a guarantee term is also expressed as an
 * assertion over service attributes and/or external factors such as date, time.
 * However, most often a Service Level Objective is expressed as a target for a Key
 * Performance Indicator (KPI) such as average response time, completion time,
 * availability, etc.
 * 
 * @author jdelafuente
 *
 */
public class ServiceLevelObjective {
	
	/**
	 * This element defines service level objective as an expression of a target of a key
	 * performance indicator associated with the service.
	 */
	private KPITarget kpiTarget;
	
	/**
	 * This element can be customized by using a domain
	 * specific expression or assertion language which MAY be designed independently
	 * of the WS-Agreement specification.
	 */
	private CustomServiceLevel customServiceLevel;

	/**
	 * @return the kpiTarget
	 */
	public KPITarget getKpiTarget() {
		return kpiTarget;
	}

	/**
	 * @param kpiTarget the kpiTarget to set
	 */
	public void setKpiTarget(KPITarget kpiTarget) {
		this.kpiTarget = kpiTarget;
	}

	/**
	 * @return the customServiceLevel
	 */
	public CustomServiceLevel getCustomServiceLevel() {
		return customServiceLevel;
	}

	/**
	 * @param customServiceLevel the customServiceLevel to set
	 */
	public void setCustomServiceLevel(CustomServiceLevel customServiceLevel) {
		this.customServiceLevel = customServiceLevel;
	}
	
	

}
