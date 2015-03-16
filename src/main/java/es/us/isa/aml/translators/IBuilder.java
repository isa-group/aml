package es.us.isa.aml.translators;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.Service;

/**
 * @author jdelafuente
 *
 */
public interface IBuilder {

    String addId(String id);

    Float addVersion(Float version);

    Object addResponder(Responder responder);

    String addMetric(Metric metric);

    String addAgreementTerms(AgreementTerms at);

    String addService(Service service);

    String addConfigurationProperty(Property cp);

    String addMonitorableProperty(Property mp);

    String addGuaranteeTerm(GuaranteeTerm gt);

    String addCreationConstraint(CreationConstraint cc);

    String generate();

}
