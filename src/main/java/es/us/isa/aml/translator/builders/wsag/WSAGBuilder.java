package es.us.isa.aml.translator.builders.wsag;

import java.net.URI;
import java.net.URISyntaxException;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.translator.builders.wsag.model.Agreement;
import es.us.isa.aml.translator.builders.wsag.model.AgreementRole;
import es.us.isa.aml.translator.builders.wsag.model.Constraint;
import es.us.isa.aml.translator.builders.wsag.model.CustomServiceLevel;
import es.us.isa.aml.translator.builders.wsag.model.Document;
import es.us.isa.aml.translator.builders.wsag.model.GuaranteeTerm;
import es.us.isa.aml.translator.builders.wsag.model.Metric;
import es.us.isa.aml.translator.builders.wsag.model.Offer;
import es.us.isa.aml.translator.builders.wsag.model.OfferItem;
import es.us.isa.aml.translator.builders.wsag.model.QualifyingCondition;
import es.us.isa.aml.translator.builders.wsag.model.ServiceLevelObjective;
import es.us.isa.aml.translator.builders.wsag.model.ServiceReference;
import es.us.isa.aml.translator.builders.wsag.model.ServiceRole;
import es.us.isa.aml.translator.builders.wsag.model.Template;
import es.us.isa.aml.translator.builders.wsag.model.Variable;
import es.us.isa.aml.util.DocType;

/**
 * Builds an WSAGModel from an AgreementModel.
 * 
 * @author jdelafuente
 *
 */
public class WSAGBuilder implements IBuilder {

	private Document wsagDoc;

	public WSAGBuilder() {
	}

	@Override
	public void setDocType(DocType type) {
		switch (type) {
		case TEMPLATE:
			wsagDoc = new Template();
			break;
		case OFFER:
			wsagDoc = new Offer();
			break;
		case AGREEMENT:
			wsagDoc = new Agreement();
			break;
		}
	}

	public void setId(String id) {
		wsagDoc.setName(id);
	}

	public void setVersion(Double version) {
		wsagDoc.setId(version.toString());
	}

	@Override
	public void setContext(Context context) {
		wsagDoc.getContext().setAgreementInitiator(context.getInitiator().getId());
		wsagDoc.getContext().setAgreementResponder(context.getResponder().getId());
		if(context.getInitiator().getRole() == Role.Provider){
			wsagDoc.getContext().setServiceProvider(AgreementRole.Initiator);
		} else if(context.getResponder().getRole() == Role.Provider){
			wsagDoc.getContext().setServiceProvider(AgreementRole.Responder);
		}
		
		if (context.getTemplateId() != null
				&& context.getTemplateVersion() != null) {
			wsagDoc.getContext().setTemplateId(
					context.getTemplateVersion().toString());
			wsagDoc.getContext().setTemplateName(context.getTemplateId());
		}

		for (es.us.isa.aml.model.Metric m : context.getMetrics().values())
			setMetric(m);
	}

	@Override
	public void setMetric(es.us.isa.aml.model.Metric metric) {

		Metric m = new Metric(metric.getId());
		m.setType(metric.getType());
		m.setDomain(metric.getDomain());

		wsagDoc.getContext().getMetrics().add(m);
	}

	@Override
	public void setAgreementTerms(AgreementTerms at) {
		setService(at.getService());

		for (Property p : at.getMonitorableProperties().values()) {
			setMonitorableProperty(p);
		}

		for (es.us.isa.aml.model.GuaranteeTerm gt : at.getGuaranteeTerms()
				.values())
			setGuaranteeTerm(gt);
	}

	@Override
	public void setService(ServiceConfiguration service) {

		wsagDoc.getTerms().setServiceReference(
				new ServiceReference(service.getServiceName()));

		wsagDoc.getTerms().getServiceDescriptionTerm()
				.setName("SDT_" + service.getServiceName());
		wsagDoc.getTerms().getServiceDescriptionTerm()
				.setServiceName(service.getServiceName());

		wsagDoc.getTerms().getServiceDescriptionTerm()
				.setServiceReference(service.getEndpointReference());

		wsagDoc.getTerms().getServiceProperties()
				.setName("SP_" + service.getServiceName());
		wsagDoc.getTerms().getServiceProperties()
				.setServiceName(service.getServiceName());

		for (Property p : service.getConfigurationProperties().values()) {
			setConfigurationProperty(p);
		}
	}

	@Override
	public void setConfigurationProperty(Property cp) {
		OfferItem oi = new OfferItem();
		oi.setName(cp.getId());
		try {
			oi.setMetric(new URI(cp.getMetric().getId()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		if (cp.getExpression() != null) {
			oi.setLocation(cp.getExpression().toString());
		}

		wsagDoc.getTerms().getServiceDescriptionTerm().getOfferItems().add(oi);
	}

	@Override
	public void setMonitorableProperty(Property mp) {
		Variable v = new Variable();
		v.setName(mp.getId());
		try {
			v.setMetric(new URI(mp.getMetric().getId()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		if (mp.getExpression() != null) {
			v.setLocation(mp.getExpression().toString());
		}

		wsagDoc.getTerms().getServiceProperties().getVariableSet().add(v);
	}

	@Override
	public void setGuaranteeTerm(es.us.isa.aml.model.GuaranteeTerm gt2) {

		GuaranteeTerm gt = new GuaranteeTerm();
		gt.setName(gt2.getId());
		if (gt2.getRole() == Role.Provider)
			gt.setObligated(ServiceRole.ServiceProvider);
		else if (gt2.getRole() == Role.Consumer)
			gt.setObligated(ServiceRole.ServiceConsumer);
		ServiceLevelObjective slo = new ServiceLevelObjective();
		slo.setCustomServiceLevel(new CustomServiceLevel(gt2.getSlo()
				.getExpression()));
		gt.setSlo(slo);
		if (gt2.getQc() != null) {
			QualifyingCondition qc = new QualifyingCondition(gt2.getQc()
					.getCondition());
			gt.setQualifyingCondition(qc);
		}
		wsagDoc.getTerms().getGuaranteeTerms().add(gt);
	}

	@Override
	public void setCreationConstraint(CreationConstraint cc) {
		Constraint c = new Constraint(cc.getId(), cc.getSlo());

		if (cc.getQc() != null) {
			QualifyingCondition qc = new QualifyingCondition(cc.getQc()
					.getCondition());
			c.setQc(qc);
		}

		((Template) wsagDoc).getCreationConstraints().getConstraints().add(c);
	}

	@Override
	public String generate() {
		return wsagDoc.toString();
	}

	@Override
	public AbstractModel getModel() {
		return wsagDoc;
	}
}
