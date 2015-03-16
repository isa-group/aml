package es.us.isa.aml.translators.csp.opl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.Service;
import es.us.isa.aml.translators.IBuilder;
import es.us.isa.aml.translators.csp.opl.model.OPLConstraint;
import es.us.isa.aml.translators.csp.opl.model.OPLModel;
import es.us.isa.aml.translators.csp.opl.model.OPLRange;
import es.us.isa.aml.translators.csp.opl.model.OPLVar;

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
    public Object addResponder(Responder responder) {
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

        sb.append(addService(at.getService()));

        for (MonitorableProperty mp : at.getMonitorableProperties()) {
            sb.append(this.addMonitorableProperty(mp)).append("\n");
        }
        sb.append("subject to {").append("\n");

        Collections.sort(at.getGuaranteeTerms());
        for (GuaranteeTerm gt : at.getGuaranteeTerms()) {
            sb.append("\t").append(this.addGuaranteeTerm(gt)).append("\n");
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    public String addService(Service service) {
        StringBuilder sb = new StringBuilder();
        for (ConfigurationProperty cp : service.getConfigurationProperties()) {
            sb.append(this.addConfigurationProperty(cp)).append("\n");
        }
        return sb.toString();
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
        OPLConstraint cons = null;
        if (gt.getQc() != null) {
            cons = new OPLConstraint(gt.getId(), gt.getSlo(), gt.getQc());
        } else {
            cons = new OPLConstraint(gt.getId(), gt.getSlo());
        }

        this.model.addConstraint(cons);
        return cons.toString();
    }

    @Override
    public String addCreationConstraint(CreationConstraint cc) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        OPLConstraint cons = null;
        if (cc.getQc() != null) {
            cons = new OPLConstraint(cc.getId(), cc.getSlo(), cc.getQc());
        } else {
            cons = new OPLConstraint(cc.getId(), cc.getSlo());
        }

        this.model.addConstraint(cons);
        return cons.toString();
    }

    @Override
    public String generate() {
        return this.model.toString();
    }
}
