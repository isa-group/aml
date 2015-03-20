package es.us.isa.aml.translators.wsag;

import java.net.URI;
import java.net.URISyntaxException;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Service;
import es.us.isa.aml.translators.IBuilder;
import es.us.isa.aml.translators.wsag.model.Agreement;
import es.us.isa.aml.translators.wsag.model.Constraint;
import es.us.isa.aml.translators.wsag.model.CustomServiceLevel;
import es.us.isa.aml.translators.wsag.model.Document;
import es.us.isa.aml.translators.wsag.model.GuaranteeTerm;
import es.us.isa.aml.translators.wsag.model.Metric;
import es.us.isa.aml.translators.wsag.model.Offer;
import es.us.isa.aml.translators.wsag.model.OfferItem;
import es.us.isa.aml.translators.wsag.model.QualifyingCondition;
import es.us.isa.aml.translators.wsag.model.ServiceLevelObjective;
import es.us.isa.aml.translators.wsag.model.Template;
import es.us.isa.aml.translators.wsag.model.Variable;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class WSAGBuilder implements IBuilder {

	private Document wsagDoc;
	
	@Override
	public void setDocType(DocType docType) {
		switch(docType){
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

	public WSAGBuilder(AgreementModel model) {
		if (model.getDocType() == DocType.TEMPLATE)
			wsagDoc = new Template();
		else
			wsagDoc = new Offer();
	}

	public String addId(String id) {
		wsagDoc.setName(id);
		return id;
	}

	public Double addVersion(Double version) {
		wsagDoc.setId(version.toString());
		return version;
	}
	
	@Override
	public Object addContext(Context context) {
		wsagDoc.getContext().setAgreementInitiator(context.getInitiator());
		wsagDoc.getContext().setAgreementResponder(context.getResponder());
		return null;
	}

	@Override
	public String addMetric(es.us.isa.aml.model.Metric metric) {

		Metric m = new Metric(metric.getId());
		m.setType(metric.getType());
		m.setDomain(metric.getDomain());

		wsagDoc.getContext().getMetrics().add(m);
		return m.toString();
	}

	@Override
	public String addAgreementTerms(AgreementTerms at) {
		addService(at.getService());

		for (Property p : at.getMonitorableProperties()) {
			addMonitorableProperty(p);
		}

		for (es.us.isa.aml.model.GuaranteeTerm gt : at.getGuaranteeTerms())
			addGuaranteeTerm(gt);

		return null;
	}

	@Override
	public String addService(Service service) {
		wsagDoc.getTerms().getServiceDescriptionTerm()
				.setName("SDT_" + service.getServiceName());

		wsagDoc.getTerms().getServiceDescriptionTerm()
				.setServiceName(service.getServiceName());

		wsagDoc.getTerms().getServiceDescriptionTerm()
				.setServiceReference(service.getServiceReference());

		wsagDoc.getTerms().getServiceProperties()
				.setName("SP_" + service.getServiceName());
		wsagDoc.getTerms().getServiceProperties()
				.setServiceName(service.getServiceName());

		for (Property p : service.getConfigurationProperties()) {
			addConfigurationProperty(p);
		}

		return wsagDoc.getTerms().getServiceDescriptionTerm().toString();
	}

	@Override
	public String addConfigurationProperty(Property cp) {
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
		return oi.toString();
	}

	@Override
	public String addMonitorableProperty(Property mp) {
		Variable v = new Variable();
		v.setName(mp.getId());
		try {
			v.setMetric(new URI(mp.getMetric().getId()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		v.setLocation("/" + mp.getId());

		wsagDoc.getTerms().getServiceProperties().getVariableSet().add(v);
		return v.toString();
	}

	@Override
	public String addGuaranteeTerm(es.us.isa.aml.model.GuaranteeTerm gt2) {

		GuaranteeTerm gt = new GuaranteeTerm();
		gt.setName(gt2.getId());
		gt.setObligated(gt2.getServiceRole());
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
		return gt.toString();
	}

	@Override
	public String addCreationConstraint(CreationConstraint cc) {
		Constraint c = new Constraint(cc.getId(), cc.getSlo());

		if (cc.getQc() != null) {
			QualifyingCondition qc = new QualifyingCondition(cc.getQc()
					.getCondition());
			c.setQc(qc);
		}

		((Template) wsagDoc).getCreationConstraints().getConstraints().add(c);

		return c.toString();
	}

	@Override
	public String generate() {
		return wsagDoc.toString();
	}
}
