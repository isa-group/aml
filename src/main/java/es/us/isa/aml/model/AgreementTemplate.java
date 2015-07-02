package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class AgreementTemplate extends AgreementModel {

    protected List<CreationConstraint> creationConstraints = new ArrayList<>();

    public AgreementTemplate() {
        this.docType = DocType.TEMPLATE;
    }

    public List<CreationConstraint> getCreationConstraints() {
        return this.creationConstraints;
    }

    public void setCreationConstraints(List<CreationConstraint> creationConstraints) {
        this.creationConstraints = creationConstraints;
    }

    public void loadFromFile(String path) {
        AgreementLanguage lang = AgreementLanguage.valueOf((String) Config.getProperty("defaultInputFormat"));
        loadFromFile(path, lang);
    }

    @Override
    public void loadFromFile(String path, AgreementLanguage lang) {
        AgreementTemplate newT = (AgreementTemplate) manager.getStoreManager().parseAgreementFile(path, lang);
        this.manager = newT.manager;
        this.agreementTerms = newT.agreementTerms;
        this.context = newT.context;
        this.creationConstraints = newT.creationConstraints;
        this.docType = newT.docType;
        this.id = newT.id;
        this.version = newT.version;
    }

    public AgreementOffer generateAgreementOffer(String consumerName) {    	    	
        AgreementOffer ao = new AgreementOffer();        
        ao.setDocType(DocType.OFFER);
        ao.setID(this.id + "_" + consumerName);
        ao.setVersion(version);
        ao.setContext(context.clone());
        ao.getContext().setConsumer(consumerName);
        ao.setAgreementTerms(agreementTerms.clone());
        ao.setAgreementManager(manager);
        return ao;
    }
    
    @Override
    public AgreementModel clone() {
    	AgreementTemplate model = (AgreementTemplate) super.clone();
    	List<CreationConstraint> ccs = this.getCreationConstraints();
    	for(CreationConstraint cc : ccs)
    		((AgreementTemplate) model).getCreationConstraints().add(cc.clone());
    	return model;
    }
}
