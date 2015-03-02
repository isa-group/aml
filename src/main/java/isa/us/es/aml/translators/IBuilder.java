package isa.us.es.aml.translators;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.AgreementTerms;
import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.GuaranteeTerm;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Service;

/**
 * @author jdelafuente
 *
 */
public interface IBuilder {

    public String addId(String id);

    public Float addVersion(Float version);

    public Object addResponder(Object responder);

    public String addMetric(Metric metric);

    public String addAgreementTerms(AgreementTerms at);

    public String addService(Service service);

    public String addConfigurationProperty(Property cp);

    public String addMonitorableProperty(Property mp);

    public String addGuaranteeTerm(GuaranteeTerm gt);

    public String addCreationConstraint(CreationConstraint cc);

    public String generate();

}
