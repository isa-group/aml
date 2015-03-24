package es.us.isa.aml.translator;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public interface IBuilder {
	
	void setDocType(DocType type);

	Object addId(String id);

	Object addVersion(Double version);

	Object addContext(Context context);

    Object addMetric(Metric metric);

    Object addAgreementTerms(AgreementTerms at);

    Object addService(ServiceConfiguration service);

    Object addConfigurationProperty(Property cp);

    Object addMonitorableProperty(Property mp);

    Object addGuaranteeTerm(GuaranteeTerm gt);

    Object addCreationConstraint(CreationConstraint cc);

    String generate();

}
