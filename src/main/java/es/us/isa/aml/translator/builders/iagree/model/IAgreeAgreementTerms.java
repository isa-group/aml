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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.translator.builders.iagree.model;

import java.util.Map;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Scope;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementTerms extends AgreementTerms {

	public IAgreeAgreementTerms() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("AgreementTerms").append("\n");
		sb.append("\t").append(this.getService()).append("\n");

		Map<String, MonitorableProperty> mps = this.getMonitorableProperties();
		if (mps.size() > 0) {
			sb.append("\t").append("MonitorableProperties").append("\n");
			sb.append("\t\t").append("global:").append("\n");
			for (MonitorableProperty mp : mps.values()) {
				if (mp.getScope() == Scope.Global) {
					sb.append("\t\t\t").append(mp).append("\n");
				}
			}

			for (MonitorableProperty mp : mps.values()) {
				if (mp.getScope() == Scope.Local) {
					sb.append("\t\t").append("for ")
							.append(mp.getFeature().getId()).append(":" + "\n");
					sb.append("\t\t\t").append(mp).append("\n");
				}
			}
		}

		Map<String, GuaranteeTerm> gts = this.getGuaranteeTerms();
		if (gts.size() > 0) {
			sb.append("\n").append("\t").append("GuaranteeTerms").append("\n");
			for (GuaranteeTerm gt : gts.values()) {
				sb.append(gt).append("\n");
			}
		}

		return sb.toString();
	}
}
