package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class AgreementOffer extends AgreementModel {

    public AgreementOffer() {
        this.docType = DocType.OFFER;
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
        this.docType = newT.docType;
        this.id = newT.id;
        this.version = newT.version;
    }

    public Agreement generateAgreement(String consumerName) {
        //todo: por ahora es una copia de la offer

        Agreement ag = new Agreement();
        ag.setDocType(DocType.AGREEMENT);
        ag.setID(this.id + "_ag");
        ag.setVersion(version);
        ag.setContext(new Context());
        ag.getContext().setConsumer(consumerName);
        ag.getContext().setInitiator(context.getInitiator());
        ag.getContext().setMetrics(context.getMetrics());
        ag.getContext().setProvider(context.getProvider());
        ag.getContext().setResponder(context.getResponder());
        ag.getContext().setServiceProvider(context.getServiceProvider());
        ag.getContext().setTemplateId(context.getTemplateId());
        ag.getContext().setTemplateVersion(context.getTemplateVersion());

        ag.setAgreementManager(agreementManager);

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
        ag.setAgreementTerms(at);
        return ag;
    }

}
