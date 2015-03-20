package es.us.isa.aml.model;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.Store;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 * 
 */
public abstract class AgreementModel {

	protected String id;
	protected Double version;
	protected Context context;
	protected AgreementTerms agreementTerms;
	protected AgreementManager agreementManager;
	protected DocType docType;
	protected final Store store = Store.getInstance();

	public AgreementModel() {
		this.id = "";
		this.version = 0.0;
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

	public Double getVersion() {
		return this.version;
	}

	public void setVersion(Double version) {
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

	public void register() {
		store.register(this);
	}

	public void register(String name) {
		store.register(name, this);
	}

	public abstract void loadFromFile(String path, AgreementLanguage lang);

	// OPERATIONS - This should be syncronized with AgreementManager methods
	public Boolean isValid() {
		return agreementManager.isValid(this);
	}

	public OperationResponse isValidFullResponse() {
		return agreementManager.isValidFullResponse(this);
	}

	// Model operations

	public Property getProperty(String propName) {
		for (ConfigurationProperty cp : this.getAgreementTerms().getService()
				.getConfigurationProperties()) {
			if (cp.getId().equals(propName))
				return cp;
		}

		for (MonitorableProperty mp : this.getAgreementTerms()
				.getMonitorableProperties()) {
			if (mp.getId().equals(propName))
				return mp;
		}

		return null;
	}

	public void setProperty(String propName, Object value) {
		Property p = getProperty(propName);
		p.setExpression(new Atomic(value));
	}

	public Boolean evaluateGT(String gtName) {
		GuaranteeTerm gt = null;
		for (GuaranteeTerm g : this.getAgreementTerms().getGuaranteeTerms()) {
			if (g.getId().equals(gtName))
				gt = g;
		}
		if (gt != null) {
			Expression expr = gt.getSlo().getExpression();
			for (Var v : Expression.getVars(expr)) {
				Property p = getProperty(v.getId().toString());
				if (p != null) {
					v.setValue(p.getExpression().calculate());
				}
			}
			return (Boolean) expr.calculate();
		} else {
			throw new NullPointerException("Guarantee term " + gtName + " not found. "
					+ "Are you sure you have declared it?");
		}
	}

}
