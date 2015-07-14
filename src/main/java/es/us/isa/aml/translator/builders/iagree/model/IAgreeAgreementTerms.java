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
