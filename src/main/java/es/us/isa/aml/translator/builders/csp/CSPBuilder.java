package es.us.isa.aml.translator.builders.csp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;
import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.translator.builders.opl.model.OPLModel;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class CSPBuilder implements IBuilder {

	private AgreementModel agModel;
    private CSPModel model;
    
    public AgreementModel getAgreementModel(){
    	return this.agModel;
    }
    
	public CSPBuilder() {
		this.model = new CSPModel();
	}
	
	@Override
	public void setContext(Context context) {
		for(Metric m : context.getMetrics().values())
			setMetric(m);
	}

    @Override
    public void setMetric(Metric metric) {
        if (this.model == null) {
            this.model = new CSPModel();
        }

        Range bool_domain = new Range(0, 1);
        CSPRange bool = new CSPRange("range_boolean", bool_domain);
        if(!model.getRanges().contains(bool))
        	this.model.addRange(bool);

        CSPRange range = new CSPRange("range_" + metric.getId(), metric.getDomain());
        this.model.addRange(range);
    }

    @Override
    public void setAgreementTerms(AgreementTerms at) {
        if (this.model == null) {
            this.model = new CSPModel();
        }

        setService(at.getService());

        for (MonitorableProperty mp : at.getMonitorableProperties()) {
            this.setMonitorableProperty(mp);;
        }

        Collections.sort(at.getGuaranteeTerms());
        for (GuaranteeTerm gt : at.getGuaranteeTerms()) {
            this.setGuaranteeTerm(gt);
        }
    }

    @Override
    public void setService(ServiceConfiguration service) {
        for (ConfigurationProperty cp : service.getConfigurationProperties()) {
            this.setConfigurationProperty(cp);
        }
    }

    @Override
    public void setConfigurationProperty(Property cp) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        Map<String, CSPRange> ranges = new HashMap<>();
        for (CSPRange range : this.model.getRanges()) {
            ranges.put(range.getId(), range);
        }

        CSPVar var = new CSPVar(cp.getId(), cp.getMetric(), ranges.get("range_" + cp.getMetric().getId()), true);
        this.model.addVar(var);
    }

    @Override
    public void setMonitorableProperty(Property mp) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        Map<String, CSPRange> ranges = new HashMap<>();
        for (CSPRange range : this.model.getRanges()) {
            ranges.put(range.getId(), range);
        }

        CSPVar var = new CSPVar(mp.getId(), mp.getMetric(), ranges.get("range_" + mp.getMetric().getId()), true);
        this.model.addVar(var);
    }

    @Override
    public void setGuaranteeTerm(GuaranteeTerm gt) {
        if (this.model == null) {
            this.model = new OPLModel();
        }
        CSPConstraint cons = null;
        if (gt.getQc() != null) {
            cons = new CSPConstraint(gt.getId(), gt.getSlo(), gt.getQc());
        } else {
            cons = new CSPConstraint(gt.getId(), gt.getSlo());
        }

        this.model.addConstraint(cons);
    }

    @Override
    public void setCreationConstraint(CreationConstraint cc) {
        if (this.model == null) {
            this.model = new OPLModel();
        }

        CSPConstraint cons = null;
        if (cc.getQc() != null) {
            cons = new CSPConstraint(cc.getId(), cc.getSlo(), cc.getQc());
        } else {
            cons = new CSPConstraint(cc.getId(), cc.getSlo());
        }

        this.model.addConstraint(cons);
    }

    @Override
    public String generate() {
        return this.model.toString();
    }

	@Override
	public void setDocType(DocType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CSPModel getModel() {
		return model;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVersion(Double version) {
		// TODO Auto-generated method stub
		
	}
}
