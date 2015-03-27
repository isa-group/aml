///**
// *
// */
//package es.us.isa.aml.translator.builders.iagree;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import es.us.isa.aml.model.AgreementModel;
//import es.us.isa.aml.model.AgreementTerms;
//import es.us.isa.aml.model.Compensation;
//import es.us.isa.aml.model.ConfigurationProperty;
//import es.us.isa.aml.model.Context;
//import es.us.isa.aml.model.CreationConstraint;
//import es.us.isa.aml.model.Feature;
//import es.us.isa.aml.model.GuaranteeTerm;
//import es.us.isa.aml.model.Metric;
//import es.us.isa.aml.model.MonitorableProperty;
//import es.us.isa.aml.model.Property;
//import es.us.isa.aml.model.ServiceConfiguration;
//import es.us.isa.aml.translator.IBuilder;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreement;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementOffer;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementTemplate;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementTerms;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeCompensation;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeConfigurationProperty;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeContext;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeCreationConstraint;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeFeature;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeMetric;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeMonitorableProperty;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeResponder;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
//import es.us.isa.aml.translator.builders.iagree.model.IAgreeService;
//import es.us.isa.aml.util.DocType;
//
///**
// * @author jdelafuente
// *
// */
//public class CopyOfIAgreeBuilder implements IBuilder {
//
//	AgreementModel model;
//
//	public CopyOfIAgreeBuilder() {
//	}
//
//	@Override
//	public void setDocType(DocType type) {
//		switch (type) {
//		case TEMPLATE:
//			model = new IAgreeAgreementTemplate();
//			break;
//		case OFFER:
//			model = new IAgreeAgreementOffer();
//			break;
//		case AGREEMENT:
//			model = new IAgreeAgreement();
//			break;
//		}
//	}
//
//	@Override
//	public String addId(String id) {
//		model.setID(id);
//		return id;
//	}
//
//	@Override
//	public Double addVersion(Double version) {
//		model.setVersion(version);
//		return version;
//	}
//
//	@Override
//	public Object addContext(Context ctx) {
//		IAgreeContext context = new IAgreeContext();
//		if (ctx.getResponder() != null) {
//			IAgreeResponder responder = new IAgreeResponder(ctx.getResponder());
//			context.setResponder(responder);
//		}
//		context.setTemplateId(ctx.getTemplateId());
//		context.setTemplateVersion(ctx.getTemplateVersion());
//		context.setInitiator(ctx.getInitiator());
//		context.setProvider(ctx.getProvider());
//		context.setConsumer(ctx.getConsumer());
//		model.setContext(context);
//
//		return context;
//	}
//
//	@Override
//	public String addMetric(Metric m) {
//		if (!m.getId().equals("boolean")) {
//			IAgreeMetric metric = new IAgreeMetric(m);
//			model.getContext().getMetrics().put(metric.getId(), metric);
//			return metric.toString();
//		}
//		return null;
//	}
//
//	@Override
//	public String addAgreementTerms(AgreementTerms at) {
//		IAgreeAgreementTerms agTerms = new IAgreeAgreementTerms();
//		model.setAgreementTerms(agTerms);
//
//		addService(at.getService());
//		for (MonitorableProperty mp : at.getMonitorableProperties())
//			addMonitorableProperty(mp);
//		for (GuaranteeTerm gt : at.getGuaranteeTerms())
//			addGuaranteeTerm(gt);
//
//		return agTerms.toString();
//	}
//
//	@Override
//	public String addService(ServiceConfiguration s) {
//		IAgreeService service = new IAgreeService();
//		service.setServiceName(s.getServiceName());
//		service.setServiceReference(s.getServiceReference());
//		Map<String, Feature> features = new HashMap<String, Feature>();
//		for (Feature f : s.getFeatures().values()) {
//			IAgreeFeature iaf = new IAgreeFeature();
//			iaf.setId(f.getId());
//			iaf.setParameters(f.getParameters());
//			features.put(iaf.getId(), iaf);
//		}
//		service.setFeatures(features);
//		model.getAgreementTerms().setService(service);
//
//		for (ConfigurationProperty cp : s.getConfigurationProperties())
//			addConfigurationProperty(cp);
//
//		return service.toString();
//	}
//
//	@Override
//	public String addConfigurationProperty(Property cp) {
//		IAgreeConfigurationProperty icp = new IAgreeConfigurationProperty(cp);
//		model.getAgreementTerms().getService().getConfigurationProperties()
//				.add(icp);
//		return icp.toString();
//	}
//
//	@Override
//	public String addMonitorableProperty(Property mp) {
//		IAgreeMonitorableProperty imp = new IAgreeMonitorableProperty(mp);
//		model.getAgreementTerms().getMonitorableProperties().add(imp);
//		return null;
//	}
//
//	@Override
//	public String addGuaranteeTerm(GuaranteeTerm gt) {
//		IAgreeGuaranteeTerm igt = new IAgreeGuaranteeTerm(gt.getId());
//		igt.setServiceRole(gt.getServiceRole());
//
//		IAgreeSLO slo = new IAgreeSLO(gt.getSlo().getExpression());
//		igt.setSlo(slo);
//
//		if (gt.getQc() != null) {
//			igt.setQc(gt.getQc());
//		}
//
//		if (gt.getCompensations().size() > 0) {
//			for (Compensation c : gt.getCompensations()) {
//				IAgreeCompensation ic = new IAgreeCompensation(c);
//				igt.getCompensations().add(ic);
//			}
//		}
//
//		model.getAgreementTerms().getGuaranteeTerms().add(igt);
//		return igt.toString();
//	}
//
//	@Override
//	public String addCreationConstraint(CreationConstraint cc) {
//
//		IAgreeSLO slo = new IAgreeSLO(cc.getSlo().getExpression());
//		IAgreeCreationConstraint icc = new IAgreeCreationConstraint(cc.getId(),
//				slo);
//		if (cc.getQc() != null) {
//			icc.setQc(cc.getQc());
//		}
//
//		((IAgreeAgreementTemplate) model).getCreationConstraints().add(icc);
//
//		return icc.toString();
//	}
//
//	@Override
//	public String generate() {
//		return model.toString();
//	}
//
//	@Override
//	public AgreementModel getModel() {
//		return model;
//	}
//}