package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.AgreementTerms;
import isa.us.es.aml.model.ConfigurationProperty;
import isa.us.es.aml.model.GuaranteeTerm;
import isa.us.es.aml.model.MonitorableProperty;
import isa.us.es.aml.model.Scope;

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
        sb.append("\t" + ((IAgreeService) getService()).toString() + "\n");

        sb.append("\t\t" + "GlobalDescription" + "\n");
        List<ConfigurationProperty> cps = getConfigurationProperties();
        for (ConfigurationProperty cp : cps) {
            if (cp.getScope() == Scope.Global) {
                sb.append("\t\t\t" + ((IAgreeConfigurationProperty) cp).toString() + "\n");
            }
        }
        sb.append("\n" + "\t" + "MonitorableProperties" + "\n");
        sb.append("\t\t" + "global:" + "\n");
        List<MonitorableProperty> mps = getMonitorableProperties();
        for (MonitorableProperty mp : mps) {
            if (mp.getScope() == Scope.Global) {
                sb.append("\t\t\t" + ((IAgreeMonitorableProperty) mp).toString() + "\n");
            }
        }

        sb.append("\n" + "\t" + "GuaranteeTerms" + "\n");
        List<GuaranteeTerm> gts = getGuaranteeTerms();
        for (GuaranteeTerm gt : gts) {
            sb.append("\t\t" + gt.toString() + "\n");
        }

        return sb.toString();
    }

}
