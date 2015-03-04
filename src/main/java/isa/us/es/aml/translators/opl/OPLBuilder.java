package isa.us.es.aml.translators.opl;

import isa.us.es.aml.model.*;
import isa.us.es.aml.translators.IBuilder;
import isa.us.es.aml.translators.opl.model.OPLConstraint;
import isa.us.es.aml.translators.opl.model.OPLModel;
import isa.us.es.aml.translators.opl.model.OPLRange;
import isa.us.es.aml.translators.opl.model.OPLVar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class OPLBuilder implements IBuilder {

    private OPLModel model;

    public OPLModel getModel() {
        return this.model;
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
        if (this.model == null) {
            this.model = new OPLModel();
        }

        Range bool_domain = new Range(0, 1);
        OPLRange bool = new OPLRange("range_boolean", bool_domain);
        this.model.addRange(bool);

        OPLRange range = new OPLRange("range_" + metric.getId(), metric.getDomain());
        this.model.addRange(range);

        return range.toString();
    }

    @Override
    public String addAgreementTerms(AgreementTerms at) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        StringBuilder sb = new StringBuilder();
        for (ConfigurationProperty cp : at.getConfigurationProperties()) {
            sb.append(this.addConfigurationProperty(cp)).append("\n");
        }
        for (MonitorableProperty mp : at.getMonitorableProperties()) {
            sb.append(this.addMonitorableProperty(mp)).append("\n");
        }
        sb.append("subject to {" + "\n");

        Collections.sort(at.getGuaranteeTerms());
        for (GuaranteeTerm gt : at.getGuaranteeTerms()) {
            sb.append("\t").append(this.addGuaranteeTerm(gt)).append("\n");
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public String addService(Service service) {
        return "";
    }

    @Override
    public String addConfigurationProperty(Property cp) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        Map<String, OPLRange> ranges = new HashMap<>();
        for (OPLRange range : this.model.getRanges()) {
            ranges.put(range.getId(), range);
        }

        OPLVar var = new OPLVar(cp.getId(), cp.getMetric(), ranges.get("range_" + cp.getMetric().getId()), true);
        this.model.addVar(var);
        return var.toString();
    }

    @Override
    public String addMonitorableProperty(Property mp) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        Map<String, OPLRange> ranges = new HashMap<>();
        for (OPLRange range : this.model.getRanges()) {
            ranges.put(range.getId(), range);
        }

        OPLVar var = new OPLVar(mp.getId(), mp.getMetric(), ranges.get("range_" + mp.getMetric().getId()), true);
        this.model.addVar(var);
        return var.toString();
    }

    @Override
    public String addGuaranteeTerm(GuaranteeTerm gt) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        OPLConstraint cons = new OPLConstraint(gt.getId(), gt.getSlo());
        this.model.addConstraint(cons);
        return cons.toString();
    }

    @Override
    public String addCreationConstraint(CreationConstraint cc) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        OPLConstraint cons = new OPLConstraint(cc.getId(), cc.getSlo());
        this.model.addConstraint(cons);
        return cons.toString();
    }

    @Override
    public String generate() {
        return this.model.toString();
    }
}
