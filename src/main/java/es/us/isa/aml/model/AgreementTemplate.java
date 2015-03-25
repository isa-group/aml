package es.us.isa.aml.model;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class AgreementTemplate extends AgreementModel {

    protected List<CreationConstraint> creationConstraints = new ArrayList<>();

    public AgreementTemplate() {
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

    public AgreementOffer generateAgreementOffer(String consumerName) {
        //todo: por ahora es una copia de la template
        AgreementOffer ao = new AgreementOffer();
        ao.setDocType(DocType.OFFER);
        ao.setID(this.id + "_" + consumerName);
        ao.setVersion(version);
        ao.setContext(new Context());
        ao.getContext().setConsumer(consumerName);
        ao.getContext().setInitiator(context.getInitiator());
        ao.getContext().setMetrics(context.getMetrics());
        ao.getContext().setProvider(context.getProvider());
        ao.getContext().setResponder(context.getResponder());
        ao.getContext().setServiceProvider(context.getServiceProvider());
        ao.getContext().setTemplateId(context.getTemplateId());
        ao.getContext().setTemplateVersion(context.getTemplateVersion());

        ao.setAgreementManager(agreementManager);

        AgreementTerms at = new AgreementTerms();
        at.setService(agreementTerms.getService());
        at.setGuaranteeTerms(agreementTerms.getGuaranteeTerms());

        for (int i = 0; i < agreementTerms.getMonitorableProperties().size(); i++) {
            MonitorableProperty mt = agreementTerms.getMonitorableProperties().get(i);
            MonitorableProperty mtCopy = new MonitorableProperty(mt.id, mt.getMetric(), mt.getExpression(), mt.getScope(), mt.getFeature());
            if (mtCopy.getExpression() != null) {
                Expression ex = Expression.parse(mtCopy.getExpression().toString());
                mtCopy.setExpression(ex);
            }
            at.getMonitorableProperties().add(mtCopy);
        }
        ao.setAgreementTerms(at);
        return ao;
    }

}
