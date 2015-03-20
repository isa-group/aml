package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AgreementTemplate extends AgreementModel {

    protected List<CreationConstraint> creationConstraints;

    public AgreementTemplate() {
        this.docType = DocType.TEMPLATE;
        this.creationConstraints = new ArrayList<>();
    }

    public AgreementTemplate(AgreementModel agreementModel) {
        super(agreementModel);
        if (agreementModel instanceof AgreementTemplate) {
            AgreementTemplate at = (AgreementTemplate) agreementModel;
            this.creationConstraints = at.creationConstraints;
        }
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

    public Agreement generateAgreement(String consumerName) {
        //todo: por ahora es una copia de la template
        Agreement ag = new Agreement(this);
        ag.getContext().setConsumer(consumerName);
        ag.setID(this.id+"_"+consumerName);
        return ag;
    }

}
