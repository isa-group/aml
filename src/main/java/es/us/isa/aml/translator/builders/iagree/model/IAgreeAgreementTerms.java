package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Scope;
import java.util.List;

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

        sb.append("\n" + "AgreementTerms" + "\n");
        sb.append("\t").append(this.getService()).append("\n");

        sb.append("\t" + "MonitorableProperties" + "\n");
        List<MonitorableProperty> mps = this.getMonitorableProperties();

        sb.append("\t\t" + "global:" + "\n");
        for (MonitorableProperty mp : mps) {
            if (mp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(mp).append("\n");
            }
        }

        for (MonitorableProperty mp : mps) {
            if (mp.getScope() == Scope.Local) {
                sb.append("\t\t" + "for ").append(mp.getFeature().getId()).append(":" + "\n");
                sb.append("\t\t\t").append(mp).append("\n");
            }
        }

        sb.append("\n" + "\t" + "GuaranteeTerms" + "\n");
        List<GuaranteeTerm> gts = this.getGuaranteeTerms();
        for (GuaranteeTerm gt : gts) {
            sb.append(gt).append("\n");
        }

        return sb.toString();
    }
}
