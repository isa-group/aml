package isa.us.es.aml.translators.csp.opl;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.AgreementTerms;
import isa.us.es.aml.model.ConfigurationProperty;
import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.GuaranteeTerm;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.MonitorableProperty;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Service;
import isa.us.es.aml.translators.IBuilder;
import isa.us.es.aml.translators.csp.opl.model.OPLConstraint;
import isa.us.es.aml.translators.csp.opl.model.OPLModel;
import isa.us.es.aml.translators.csp.opl.model.OPLRange;
import isa.us.es.aml.translators.csp.opl.model.OPLVar;
import java.util.Collections;

/**
 * @author jdelafuente
 *
 */
public class OPLBuilder implements IBuilder {

    private OPLModel model;

    public OPLModel getModel() {
        return model;
    }

    @Override
    public String addId(String id) {
        return id;
    }

    @Override
    public Float addVersion(Float version) {
        return version;
    }

    @Override
    public Object addResponder(Object responder) {
        return responder;
    }

    @Override
    public String addMetric(Metric metric) {
        if (model == null) {
            model = new OPLModel();
        }
        OPLRange range = new OPLRange(metric.getId(), metric.getDomain());
        model.addRange(range);
        return range.toString();
    }

    @Override
    public String addAgreementTerms(AgreementTerms at) {
        if (model == null) {
            model = new OPLModel();
        }

        StringBuilder sb = new StringBuilder();
        for (ConfigurationProperty cp : at.getConfigurationProperties()) {
            sb.append(addConfigurationProperty(cp)).append("\n");
        }
        for (MonitorableProperty mp : at.getMonitorableProperties()) {
            sb.append(addMonitorableProperty(mp)).append("\n");
        }
        sb.append("subject to {" + "\n");

        Collections.sort(at.getGuaranteeTerms());
        for (GuaranteeTerm gt : at.getGuaranteeTerms()) {
            sb.append("\t").append(addGuaranteeTerm(gt)).append("\n");
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public String addService(Service service) {
        return "";
    }

    @Override
    public String addMonitorableProperty(Property mp) {
        if (model == null) {
            model = new OPLModel();
        }

        OPLVar var = new OPLVar(mp.getId(), mp.getMetric(), true);
        model.addVar(var);
        return var.toString();
    }

    @Override
    public String addConfigurationProperty(Property cp) {
        if (model == null) {
            model = new OPLModel();
        }

        OPLVar var = new OPLVar(cp.getId(), cp.getMetric(), true);
        model.addVar(var);
        return var.toString();
    }

    @Override
    public String addGuaranteeTerm(GuaranteeTerm gt) {
        if (model == null) {
            model = new OPLModel();
        }

        OPLConstraint cons = new OPLConstraint(gt.getId(), gt.getSlo());
        model.addConstraint(cons);
        return cons.toString();
    }

    @Override
    public String addCreationConstraint(CreationConstraint cc) {
        if (model == null) {
            model = new OPLModel();
        }

        OPLConstraint cons = new OPLConstraint(cc.getId(), cc.getSlo());
        model.addConstraint(cons);
        return cons.toString();
    }

    @Override
    public String generate() {
        return model.toString();
    }

    @Override
    public void setModel(AgreementModel model) {
        // TODO Auto-generated method stub

    }
}
