package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;

/**
 * @author jdelafuente
 *
 */
public class Agreement extends AgreementOffer {

    
    //todo: por ahora es una copia de la oferta. En el futuro se modelará de otra forma.
    public Agreement() {
        super();
    }
    public Agreement(AgreementModel model) {
        super(model);
    }
    

    @Override
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
        this.templateId = newT.templateId;
        this.templateVersion = newT.templateVersion;
        this.docType = newT.docType;
        this.id = newT.id;
        this.version = newT.version;
    }
}
