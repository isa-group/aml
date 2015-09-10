/**
 *
 */
package es.us.isa.aml.translator.builders.iagree;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Feature;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeActor;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreement;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementOffer;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementTemplate;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementTerms;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeCompensation;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeConfigurationProperty;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeContext;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeCreationConstraint;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeFeature;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeMetric;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeMonitorableProperty;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeService;
import es.us.isa.aml.util.DocType;

/**
 * Builds an iAgreeModel from an AgreementModel.
 * 
 * @author jdelafuente
 *
 */
public class IAgreeBuilder implements IBuilder {

	AgreementModel model;

	public IAgreeBuilder() {
	}

	@Override
	public void setDocType(DocType type) {
		switch (type) {
		case TEMPLATE:
			model = new IAgreeAgreementTemplate();
			break;
		case OFFER:
			model = new IAgreeAgreementOffer();
			break;
		case AGREEMENT:
			model = new IAgreeAgreement();
			break;
		}
	}

	@Override
	public void setId(String id) {
		model.setID(id);
	}

	@Override
	public void setVersion(Double version) {
		model.setVersion(version);
	}

	@Override
	public void setContext(Context ctx) {
		IAgreeContext context = new IAgreeContext();
		
		if (ctx.getInitiator() != null) {
			IAgreeActor initiator = new IAgreeActor(ctx.getInitiator());
			context.setInitiator(initiator);
		}
		
		if (ctx.getResponder() != null) {
			IAgreeActor responder = new IAgreeActor(ctx.getResponder());
			context.setResponder(responder);
		}
		context.setTemplateId(ctx.getTemplateId());
		context.setTemplateVersion(ctx.getTemplateVersion());
		context.setInitiator(ctx.getInitiator());
		model.setContext(context);

		for (Metric m : ctx.getMetrics().values())
			setMetric(m);
	}

	@Override
	public void setMetric(Metric m) {
		if (!m.getId().equals("boolean")) {
			IAgreeMetric metric = new IAgreeMetric(m);
			model.getContext().getMetrics().put(metric.getId(), metric);
		}
	}

	@Override
	public void setAgreementTerms(AgreementTerms at) {
		IAgreeAgreementTerms agTerms = new IAgreeAgreementTerms();
		model.setAgreementTerms(agTerms);

		setService(at.getService());
		for (MonitorableProperty mp : at.getMonitorableProperties().values())
			setMonitorableProperty(mp);
		for (GuaranteeTerm gt : at.getGuaranteeTerms().values())
			setGuaranteeTerm(gt);
	}

	@Override
	public void setService(ServiceConfiguration s) {
		IAgreeService service = new IAgreeService();
		service.setServiceName(s.getServiceName());
		service.setEndpointReference(s.getEndpointReference());
		Map<String, Feature> features = new HashMap<String, Feature>();
		for (Feature f : s.getFeatures().values()) {
			IAgreeFeature iaf = new IAgreeFeature();
			iaf.setId(f.getId());
			iaf.setParameters(f.getParameters());
			features.put(iaf.getId(), iaf);
		}
		service.setFeatures(features);
		model.getAgreementTerms().setService(service);

		for (ConfigurationProperty cp : s.getConfigurationProperties().values())
			setConfigurationProperty(cp);
	}

	@Override
	public void setConfigurationProperty(Property cp) {
		IAgreeConfigurationProperty icp = new IAgreeConfigurationProperty(cp);
		model.getAgreementTerms().getService().getConfigurationProperties()
				.put(icp.getId(), icp);
	}

	@Override
	public void setMonitorableProperty(Property mp) {
		IAgreeMonitorableProperty imp = new IAgreeMonitorableProperty(mp);
		model.getAgreementTerms().getMonitorableProperties()
				.put(imp.getId(), imp);
	}

	@Override
	public void setGuaranteeTerm(GuaranteeTerm gt) {
		IAgreeGuaranteeTerm igt = new IAgreeGuaranteeTerm(gt.getId());
		igt.setRole(gt.getRole());

		IAgreeSLO slo = new IAgreeSLO(gt.getSlo().getExpression());
		igt.setSlo(slo);

		if (gt.getQc() != null) {
			igt.setQc(gt.getQc());
		}

		if (gt.getCompensations().size() > 0) {
			for (Compensation c : gt.getCompensations()) {
				IAgreeCompensation ic = new IAgreeCompensation(c);
				igt.getCompensations().add(ic);
			}
		}

		model.getAgreementTerms().getGuaranteeTerms().put(igt.getId(), igt);
	}

	@Override
	public void setCreationConstraint(CreationConstraint cc) {

		IAgreeSLO slo = new IAgreeSLO(cc.getSlo().getExpression());
		IAgreeCreationConstraint icc = new IAgreeCreationConstraint(cc.getId(),
				slo);
		if (cc.getQc() != null) {
			icc.setQc(cc.getQc());
		}

		((IAgreeAgreementTemplate) model).getCreationConstraints().put(
				icc.getId(), icc);
	}

	@Override
	public String generate() {
		return model.toString();
	}

	@Override
	public AbstractModel getModel() {
		return model;
	}
}
