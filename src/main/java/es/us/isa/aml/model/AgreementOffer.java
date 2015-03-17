package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class AgreementOffer extends AgreementModel {

    private String templateId;
    private Float templateVersion;

    public AgreementOffer() {
    	this.docType = DocType.OFFER;
    }

    public AgreementOffer(String templateId, Float templateVersion) {
    	this.docType = DocType.OFFER;
        this.templateId = templateId;
        this.templateVersion = templateVersion;
        
    }

    public AgreementOffer(AgreementModel agreementModel) {
        super(agreementModel);
        this.docType = DocType.OFFER;
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

}
