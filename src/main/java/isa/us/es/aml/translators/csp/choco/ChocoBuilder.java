package isa.us.es.aml.translators.csp.choco;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.AgreementTerms;
import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.GuaranteeTerm;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.Property;
import isa.us.es.aml.model.Service;
import isa.us.es.aml.translators.IBuilder;
import isa.us.es.aml.translators.csp.choco.model.CHOCOModel;

/**
 * @author jdelafuente
 *
 */
public class ChocoBuilder implements IBuilder {

    private CHOCOModel model;
    
    @Override
    public String addId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float addVersion(Float version) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object addResponder(Object responder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addMetric(Metric metric) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addAgreementTerms(AgreementTerms at) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addService(Service service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addConfigurationProperty(Property cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addMonitorableProperty(Property mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addGuaranteeTerm(GuaranteeTerm gt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addCreationConstraint(CreationConstraint cc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setModel(AgreementModel model) {
        // TODO Auto-generated method stub
    }

}
