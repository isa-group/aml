package es.us.isa.aml.translator.builders.choco;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.translator.builders.choco.model.ChocoModel;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class ChocoBuilder implements IBuilder {

    private ChocoModel model;

    @Override
    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setVersion(Double version) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMetric(Metric metric) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAgreementTerms(AgreementTerms at) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setService(ServiceConfiguration service) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setConfigurationProperty(Property cp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setMonitorableProperty(Property mp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setGuaranteeTerm(GuaranteeTerm gt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCreationConstraint(CreationConstraint cc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	@Override
	public void setContext(Context context) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setDocType(DocType type) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public AbstractModel getModel() {
		return model;
	}

}
