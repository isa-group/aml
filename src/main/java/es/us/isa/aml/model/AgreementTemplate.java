package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

import java.util.ArrayList;
import java.util.List;

import com.rits.cloning.Cloner;

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
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        loadFromFile(path, lang);
    }

    @Override
    public void loadFromFile(String path, AgreementLanguage lang) {
        AgreementTemplate newT = (AgreementTemplate) store.parseAgreementFile(path, lang);
        this.agreementManager = newT.agreementManager;
        this.agreementTerms = newT.agreementTerms;
        this.context = newT.context;
        this.creationConstraints = newT.creationConstraints;
        this.docType = newT.docType;
        this.id = newT.id;
        this.version = newT.version;
    }

    public AgreementOffer generateAgreementOffer(String consumerName) {
        //todo: por ahora es una copia de la template
    	
    	Cloner cloner = new Cloner();
    	
        AgreementOffer ao = new AgreementOffer();        
        ao.setDocType(DocType.OFFER);
        ao.setID(this.id + "_" + consumerName);
        ao.setVersion(version);
        Context ctx = cloner.deepClone(context);
        ao.setContext(ctx);
        ao.getContext().setConsumer(consumerName);
        AgreementTerms at = cloner.deepClone(agreementTerms);
        ao.setAgreementTerms(at);
        ao.setAgreementManager(agreementManager);
        return ao;
    }

}
