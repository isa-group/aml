package es.us.isa.aml.translators.csp.choco;

import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Service;
import es.us.isa.aml.translators.IBuilder;
import es.us.isa.aml.translators.csp.choco.model.ChocoModel;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class ChocoBuilder implements IBuilder {

    private ChocoModel model;

    @Override
    public String addId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Double addVersion(Double version) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addMetric(Metric metric) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addAgreementTerms(AgreementTerms at) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addService(Service service) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addConfigurationProperty(Property cp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addMonitorableProperty(Property mp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addGuaranteeTerm(GuaranteeTerm gt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String addCreationConstraint(CreationConstraint cc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String generate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDocType(DocType docType) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object addContext(Context context) {
        // TODO Auto-generated method stub
        return null;
    }

}
