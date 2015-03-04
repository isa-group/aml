package es.us.isa.aml.translators.iagree.model;


import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Scope;
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
