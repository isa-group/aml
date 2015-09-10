package es.us.isa.aml.translator;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.util.DocType;

/**
 * Builds a model from an AgreementModel.
 * @author jdelafuente
 *
 */
public interface IBuilder {
	
	void setDocType(DocType type);

	void setId(String id);

	void setVersion(Double version);

	void setContext(Context context);

	void setMetric(Metric metric);

	void setAgreementTerms(AgreementTerms at);

	void setService(ServiceConfiguration service);

	void setConfigurationProperty(Property cp);

	void setMonitorableProperty(Property mp);

	void setGuaranteeTerm(GuaranteeTerm gt);

	void setCreationConstraint(CreationConstraint cc);

    String generate();
    
    AbstractModel getModel();
}
