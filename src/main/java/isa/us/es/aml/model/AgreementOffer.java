package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class AgreementOffer extends AgreementModel {

    private String templateId;
    private Float templateVersion;

    public AgreementOffer() {
    }

    public AgreementOffer(String templateId, Float templateVersion) {
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

}
