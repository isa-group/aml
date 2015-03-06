package es.us.isa.aml.model;

import es.us.isa.aml.AgreementManager;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementModel {

    private String id;
    private Float version;
    private Context context;
    private AgreementTerms agreementTerms;
    private AgreementManager agreementManager;

    public AgreementModel() {
        this.id = "";
        this.version = 0.0f;
        context = new Context();
        this.agreementTerms = new AgreementTerms();
    }

    public AgreementModel(AgreementManager agreementManager) {
        super();
        this.agreementManager = agreementManager;

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

    // OPERATIONS -  This should be syncronized with AgreementManager methods
    public Boolean isValid() {
        return agreementManager.isValid(this);
    }

}
