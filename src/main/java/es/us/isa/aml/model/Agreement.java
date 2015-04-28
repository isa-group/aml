package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class Agreement extends AgreementOffer {

    //todo: por ahora es una copia de la oferta. En el futuro se modelará de otra forma.
    public Agreement() {
        super();
        this.docType = DocType.AGREEMENT;
    }

    @Override
    public void loadFromFile(String path) {
        AgreementLanguage lang = AgreementLanguage.valueOf((String) Config.getProperty("defaultInputFormat"));
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
}
