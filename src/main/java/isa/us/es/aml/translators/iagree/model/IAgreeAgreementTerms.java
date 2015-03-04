package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.*;

import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementTerms extends AgreementTerms {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n" + "AgreementTerms" + "\n");
        sb.append("\t").append(this.getService()).append("\n");

        sb.append("\t\t" + "GlobalDescription" + "\n");
        List<ConfigurationProperty> cps = this.getConfigurationProperties();
        for (ConfigurationProperty cp : cps) {
            if (cp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(cp).append("\n");
            }
        }
        sb.append("\n" + "\t" + "MonitorableProperties" + "\n");
        sb.append("\t\t" + "global:" + "\n");
        List<MonitorableProperty> mps = this.getMonitorableProperties();
        for (MonitorableProperty mp : mps) {
            if (mp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(mp).append("\n");
            }
        }

        sb.append("\n" + "\t" + "GuaranteeTerms" + "\n");
        List<GuaranteeTerm> gts = this.getGuaranteeTerms();
        for (GuaranteeTerm gt : gts) {
            sb.append("\t\t").append(gt).append("\n");
        }

        return sb.toString();
    }

}
