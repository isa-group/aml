package es.us.isa.aml.translator.builders.iagree.model;

import java.util.List;

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceConfiguration;

/**
 * @author jdelafuente
 *
 */
public class IAgreeService extends ServiceConfiguration {

	public IAgreeService() {
	}
	
	public IAgreeService(ServiceConfiguration s) {
		super(s.getServiceName(), s.getEndpointReference(), s.getFeatures(), s.getConfigurationProperties());
	}	

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Service ").append(this.getServiceName()).append(" availableAt " + "\"").append(this.getEndpointReference()).append("\"").append("\n");

        if (getFeatures().size() > 0) {
            sb.append("\t\t" + "Features: ").append(getFeatures().values().toString().replace("[", "").replace("]", "")).append("\n");
        }

        List<ConfigurationProperty> cps = this.getConfigurationProperties();

        sb.append("\t\t" + "GlobalDescription").append("\n");
        for (ConfigurationProperty cp : cps) {
            if (cp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(cp).append("\n");
            }
        }

        for (ConfigurationProperty cp : cps) {
            if (cp.getScope() == Scope.Local) {
                sb.append("\t\t" + "Description for ").append(cp.getFeature().getId()).append(":" + "\n");
                sb.append("\t\t\t").append(cp).append("\n");
            }
        }

        return sb.toString();
    }

}
