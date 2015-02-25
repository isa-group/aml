package isa.us.es.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AgreementTerms {

    private Service service;
    private List<Property> cps;
    private List<Property> mps;
    private List<GuaranteeTerm> gts;

    public AgreementTerms() {
        service = new Service();
        cps = new ArrayList<>();
        mps = new ArrayList<>();
        gts = new ArrayList<>();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Property> getConfigurationProperties() {
        return cps;
    }

    public void setConfigurationProperties(List<Property> cps) {
        this.cps = cps;
    }

    public List<Property> getMonitorableProperties() {
        return mps;
    }

    public void setMonitorableProperties(List<Property> mps) {
        this.mps = mps;
    }

    public List<GuaranteeTerm> getGuaranteeTerms() {
        return gts;
    }

    public void setGuaranteeTerms(List<GuaranteeTerm> gts) {
        this.gts = gts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n" + "AgreementTerms" + "\n");
        sb.append("\t").append(getService().toString()).append("\n");

        sb.append("\t\t" + "GlobalDescription" + "\n");
        List<Property> cps = getConfigurationProperties();
        for (Property cp : cps) {
            if (cp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(cp.toString()).append("\n");
            }
        }
        sb.append("\n" + "\t" + "MonitorableProperties" + "\n");
        sb.append("\t\t" + "global:" + "\n");
        List<Property> mps = getMonitorableProperties();
        for (Property mp : mps) {
            if (mp.getScope() == Scope.Global) {
                sb.append("\t\t\t").append(mp.toString()).append("\n");
            }
        }

        sb.append("\n" + "\t" + "GuaranteeTerms" + "\n");
        List<GuaranteeTerm> gts = getGuaranteeTerms();
        for (GuaranteeTerm gt : gts) {
            sb.append("\t\t").append(gt.toString()).append("\n");
        }

        return sb.toString();
    }

}
