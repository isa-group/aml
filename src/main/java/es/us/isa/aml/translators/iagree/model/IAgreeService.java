package es.us.isa.aml.translators.iagree.model;

import java.util.List;

import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.Service;

/**
 * @author jdelafuente
 *
 */
public class IAgreeService extends Service {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Service " + this.getServiceName() + " availableAt " + "\"" + this.getServiceReference() + "\"").append("\n");

        if (getFeatures().size() > 0) {
            sb.append("\t\t" + "Features: " + getFeatures().values().toString().replace("[", "").replace("]", "")).append("\n");
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
                sb.append("\t\t" + "Description for " + cp.getFeature().getId() + ":" + "\n");
                sb.append("\t\t\t").append(cp).append("\n");
            }
        }

        return sb.toString();
    }

}
