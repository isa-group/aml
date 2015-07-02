package es.us.isa.aml.model;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.translator.AbstractModel;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementModel extends AbstractModel {

    protected String id;
    protected Double version;
    protected Context context;
    protected AgreementTerms agreementTerms;
    protected AgreementManager manager;
    protected DocType docType;

    public AgreementModel() {
        this.id = "";
        this.version = 0.0;
        this.context = new Context();
        this.agreementTerms = new AgreementTerms();
        this.docType = DocType.TEMPLATE;
    }

    public AgreementModel(AgreementManager agreementManager) {
        super();
        this.manager = agreementManager;
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
        this.manager = agreementManager;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public abstract void loadFromFile(String path, AgreementLanguage lang);

    // OPERATIONS - This should be syncronized with AgreementManager methods
    public Boolean isValid() {
        return manager.isValid(this);
    }

    public OperationResponse isValidFullResponse() {
        return manager.isValidFullResponse(this);
    }

    // Model operations
    public Property getProperty(String propName) {
        for (ConfigurationProperty cp : this.getAgreementTerms().getService()
                .getConfigurationProperties()) {
            if (cp.getId().equals(propName)) {
                return cp;
            }
        }

        for (MonitorableProperty mp : this.getAgreementTerms()
                .getMonitorableProperties()) {
            if (mp.getId().equals(propName)) {
                return mp;
            }
        }

        return null;
    }

    public void setProperty(String propName, Object value) {
        Property p = getProperty(propName);
        if (value instanceof String) {
            Expression expr = Expression.parse((String) value);
            for (Var v : Expression.getVars(expr)) {
                Property prop = getProperty(v.getId().toString());
                if (prop != null) {
                    if (prop.getExpression() != null) {
                        v.setValue(prop.getExpression().calculate());
                    }
                }
            }
            p.setExpression(expr);
        } else if (value instanceof Integer || value instanceof Double) {
            if (p.getMetric().getType().equals("integer")
                    || p.getMetric().getType().equals("float")) {
                p.setExpression(new Atomic(value));
            } else {
                throw new IllegalArgumentException("Property " + propName
                        + " is a property of type " + p.getMetric().getType()
                        + " but " + value.getClass().getSimpleName()
                        + " was found.");
            }
        } else if (value instanceof Boolean) {
            if (p.getMetric().getType().equals("boolean")) {
                p.setExpression(new Atomic(value));
            } else {
                throw new IllegalArgumentException("Property " + propName
                        + " is a property of type " + p.getMetric().getType()
                        + " but " + value.getClass().getSimpleName()
                        + " was found.");
            }
        } else if (value instanceof Expression) {
            for (Var v : Expression.getVars((Expression) value)) {
                Property prop = getProperty(v.getId().toString());
                if (prop != null) {
                    if (prop.getExpression() != null) {
                        v.setValue(prop.getExpression().calculate());
                    }
                }
            }
            p.setExpression((Expression) value);
        }
    }

    public GuaranteeTerm getGuaranteeTerm(String gtName) {
        GuaranteeTerm gt = null;
        for (GuaranteeTerm g : this.getAgreementTerms().getGuaranteeTerms()) {
            if (g.getId().equals(gtName)) {
                gt = g;
            }
        }
        return gt;
    }

    public Boolean evaluateGT(String gtName) {
        GuaranteeTerm gt = getGuaranteeTerm(gtName);
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
            throw new NullPointerException("Guarantee term " + gtName
                    + " not found. " + "Are you sure you have declared it?");
        }
    }
    
    @Override
    public AgreementModel clone() {
    	AgreementModel model = null;
    	
        if(docType == DocType.TEMPLATE){
        	model = new AgreementTemplate();
        } else if(docType == DocType.OFFER){
        	model = new AgreementOffer();
        } else if(docType == DocType.AGREEMENT){
        	model = new Agreement();
        }
        
        model.setID(id);
    	model.setVersion(version);
    	model.setContext(context.clone());
    	model.setAgreementTerms(agreementTerms.clone());
    	model.setAgreementManager(manager);
    	model.setDocType(docType);
        
        return model;
    }

}
