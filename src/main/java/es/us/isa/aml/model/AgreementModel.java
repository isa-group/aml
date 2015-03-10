package es.us.isa.aml.model;

import es.us.isa.aml.util.DocType;
import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.Store;
import es.us.isa.aml.util.AgreementLanguage;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementModel {

    protected String id;
    protected Float version;
    protected Context context;
    protected AgreementTerms agreementTerms;
    protected AgreementManager agreementManager;
    protected DocType docType;
    protected final Store store = Store.getInstance();

    public AgreementModel() {
        this.id = "";
        this.version = 0.0f;
        this.context = new Context();
        this.agreementTerms = new AgreementTerms();
        this.docType = DocType.TEMPLATE;
    }

    public AgreementModel(AgreementManager agreementManager) {
        super();
        this.agreementManager = agreementManager;
    }

    public AgreementModel(AgreementModel agreementModel) {
        super();
        this.id = agreementModel.getID();
        this.version = agreementModel.getVersion();
        this.agreementManager = agreementModel.agreementManager;
        this.context = agreementModel.getContext();
        this.agreementTerms = agreementModel.getAgreementTerms();
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public Float getVersion() {
        return this.version;
    }

    public void setVersion(Float version) {
        this.version = version;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public AgreementTerms getAgreementTerms() {
        return this.agreementTerms;
    }

    public void setAgreementTerms(AgreementTerms agreementTerms) {
        this.agreementTerms = agreementTerms;
    }

    public void setAgreementManager(AgreementManager agreementManager) {
        this.agreementManager = agreementManager;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    @Override
    public AgreementModel clone() {
        if (this.getDocType().equals(DocType.OFFER)) {
            return new AgreementOffer(this);
        }
        return new AgreementOffer(this);
    }

    public void register() {
        store.register(this);
    }

    public void register(String name) {
        store.register(name, this);
    }

    public abstract void loadFromFile(String path, AgreementLanguage lang);

    // OPERATIONS -  This should be syncronized with AgreementManager methods
    public Boolean isValid() {
        return agreementManager.isValid(this);
    }

}
