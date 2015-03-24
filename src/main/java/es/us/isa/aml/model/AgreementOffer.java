package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class AgreementOffer extends AgreementModel {

    protected String templateId;
    protected Float templateVersion;

    public AgreementOffer() {
        this.docType = DocType.OFFER;
    }

    public AgreementOffer(String templateId, Float templateVersion) {
        this.docType = DocType.OFFER;
        this.templateId = templateId;
        this.templateVersion = templateVersion;

    }

    /**
     * @return the templateId
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the templateVersion
     */
    public Float getTemplateVersion() {
        return this.templateVersion;
    }

    /**
     * @param templateVersion the templateVersion to set
     */
    public void setTemplateVersion(Float templateVersion) {
        this.templateVersion = templateVersion;
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
        this.templateId = newT.templateId;
        this.templateVersion = newT.templateVersion;
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
        ag.setContext(context);
        ag.getContext().setConsumer(consumerName);
        ag.setAgreementTerms(agreementTerms);
        ag.setAgreementManager(agreementManager);
        ag.templateId = id;
        ag.templateVersion = new Float(version);
        return ag;
    }
}
