package es.us.isa.aml.model;


/**
 * @author jdelafuente
 *
 */
public abstract class AgreementModel {

    String id;
    Float version;
    Context context;
    AgreementTerms agreementTerms;

    public AgreementModel() {
        this.id = "";
        this.version = 0.0f;
        context = new Context();
        this.agreementTerms = new AgreementTerms();
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

}
