/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The agreement terms contain information about the agreement like the service
 * configuration, the monitorable properties and the guarantee terms.
 * 
 * @author jdelafuente
 *
 */
public class AgreementTerms {

	private ServiceConfiguration service;
	private Map<String, MonitorableProperty> mps;
	private Map<String, GuaranteeTerm> gts;

	public AgreementTerms() {
		this.service = new ServiceConfiguration();
		this.mps = new HashMap<String, MonitorableProperty>();
		this.gts = new HashMap<String, GuaranteeTerm>();
	}

	public AgreementTerms(ServiceConfiguration service,
			Map<String, MonitorableProperty> monitorableProperties,
			Map<String, GuaranteeTerm> guaranteeTerms) {
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

	public Map<String, MonitorableProperty> getMonitorableProperties() {
		return this.mps;
	}

	public void setMonitorableProperties(Map<String, MonitorableProperty> mps) {
		this.mps = mps;
	}

	public Map<String, GuaranteeTerm> getGuaranteeTerms() {
		return this.gts;
	}

	public void setGuaranteeTerms(Map<String, GuaranteeTerm> gts) {
		this.gts = gts;
	}

	@Override
	public AgreementTerms clone() {
		AgreementTerms at = new AgreementTerms();
		ServiceConfiguration sc = service.clone();
		at.setService(sc);
		for (MonitorableProperty mp : mps.values())
			at.getMonitorableProperties().put(mp.getId(), mp.clone());

		for (GuaranteeTerm gt : gts.values())
			at.getGuaranteeTerms().put(gt.getId(), gt.clone());

		return at;
	}
}
