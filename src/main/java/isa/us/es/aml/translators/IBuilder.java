package isa.us.es.aml.translators;

import isa.us.es.aml.model.*;

/**
 * @author jdelafuente
 *
 */
public interface IBuilder {

    String addId(String id);

    Float addVersion(Float version);

    Object addResponder(Object responder);

    String addMetric(Metric metric);

    String addAgreementTerms(AgreementTerms at);

    String addService(Service service);

    String addConfigurationProperty(Property cp);

    String addMonitorableProperty(Property mp);

    String addGuaranteeTerm(GuaranteeTerm gt);

    String addCreationConstraint(CreationConstraint cc);

    String generate();

}
