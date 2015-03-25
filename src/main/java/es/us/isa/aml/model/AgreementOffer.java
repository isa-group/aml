package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class AgreementOffer extends AgreementModel {

    public AgreementOffer() {
        this.docType = DocType.OFFER;
    }

    public void loadFromFile(String path) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        loadFromFile(path, lang);
    }

    @Override
    public void loadFromFile(String path, AgreementLanguage lang) {
        AgreementOffer newT = (AgreementOffer) store.parseAgreementFile(path, lang);
        this.agreementManager = newT.agreementManager;
        this.agreementTerms = newT.agreementTerms;
        this.context = newT.context;
        this.docType = newT.docType;
        this.id = newT.id;
        this.version = newT.version;
    }

    public Agreement generateAgreement(String consumerName) {
        //todo: por ahora es una copia de la offer
    	
        Agreement ag = new Agreement();
        ag.setDocType(DocType.AGREEMENT);
        ag.setID(this.id + "_" + consumerName);
        ag.setVersion(version);
        ag.setContext(context.clone());
        ag.getContext().setConsumer(consumerName);
        ag.setAgreementTerms(agreementTerms.clone());
        return ag;
    }
}
