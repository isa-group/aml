/**
 *
 */
package es.us.isa.aml.translators.iagree;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.Service;
import es.us.isa.aml.translators.IBuilder;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementTemplate;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementTerms;
import es.us.isa.aml.translators.iagree.model.IAgreeCompensation;
import es.us.isa.aml.translators.iagree.model.IAgreeConfigurationProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeContext;
import es.us.isa.aml.translators.iagree.model.IAgreeCreationConstraint;
import es.us.isa.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translators.iagree.model.IAgreeMetric;
import es.us.isa.aml.translators.iagree.model.IAgreeMonitorableProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeResponder;
import es.us.isa.aml.translators.iagree.model.IAgreeSLO;
import es.us.isa.aml.translators.iagree.model.IAgreeService;

/**
 * @author jdelafuente
 *
 */
public class IAgreeBuilder implements IBuilder {

	AgreementModel model = new IAgreeAgreementTemplate();

	@Override
	public String addId(String id) {
		model.setID(id);
		return id;
	}

	@Override
	public Double addVersion(Double version) {
		model.setVersion(version);
		return version;
	}

	@Override
	public Object addResponder(Responder r) {
		IAgreeContext context = new IAgreeContext();
		IAgreeResponder responder = new IAgreeResponder(r);
		context.setResponder(responder);
		model.setContext(context);
		return responder;
	}

	@Override
	public String addMetric(Metric m) {
		if(!m.getId().equals("boolean")){
			IAgreeMetric metric = new IAgreeMetric(m);
			model.getContext().getMetrics().put(metric.getId(), metric);
			return metric.toString();
		}
		return null;
	}

	@Override
	public String addAgreementTerms(AgreementTerms at) {
		IAgreeAgreementTerms agTerms = new IAgreeAgreementTerms();
		model.setAgreementTerms(agTerms);
		
		addService(at.getService());
		for(MonitorableProperty mp : at.getMonitorableProperties())
			addMonitorableProperty(mp);
		for(GuaranteeTerm gt : at.getGuaranteeTerms())
			addGuaranteeTerm(gt);
		
		return agTerms.toString();
	}

	@Override
	public String addService(Service s) {
		IAgreeService service = new IAgreeService();
		service.setServiceName(s.getServiceName());
		service.setServiceReference(s.getServiceReference());
		service.setFeatures(s.getFeatures());
		model.getAgreementTerms().setService(service);
		
		for(ConfigurationProperty cp : s.getConfigurationProperties())
			addConfigurationProperty(cp);
		
		return service.toString();
	}

	@Override
	public String addConfigurationProperty(Property cp) {
		IAgreeConfigurationProperty icp = new IAgreeConfigurationProperty(cp);
		model.getAgreementTerms().getService().getConfigurationProperties().add(icp);
		return icp.toString();
	}

	@Override
	public String addMonitorableProperty(Property mp) {
		IAgreeMonitorableProperty imp = new IAgreeMonitorableProperty(mp);
		model.getAgreementTerms().getMonitorableProperties().add(imp);
		return null;
	}

	@Override
	public String addGuaranteeTerm(GuaranteeTerm gt) {
		IAgreeGuaranteeTerm igt = new IAgreeGuaranteeTerm(gt.getId());
		igt.setServiceRole(gt.getServiceRole());
		
		IAgreeSLO slo = new IAgreeSLO(gt.getSlo().getExpression());		
		igt.setSlo(slo);
		
		if(gt.getQc() != null){
			igt.setQc(gt.getQc());
		}
		
		if(gt.getCompensations().size() > 0){
			for(Compensation c : gt.getCompensations()){
				IAgreeCompensation ic = new IAgreeCompensation(c);
				igt.getCompensations().add(ic);
			}
		}
		
		model.getAgreementTerms().getGuaranteeTerms().add(igt);
		return igt.toString();
	}

	@Override
	public String addCreationConstraint(CreationConstraint cc) {
		
		IAgreeSLO slo = new IAgreeSLO(cc.getSlo().getExpression());
		IAgreeCreationConstraint icc = new IAgreeCreationConstraint(cc.getId(), slo);
		if(cc.getQc() != null){
			icc.setQc(cc.getQc());
		}
		
		((IAgreeAgreementTemplate) model).getCreationConstraints().add(icc);
		
		return icc.toString();
	}

	@Override
	public String generate() {
		return model.toString();
	}

}
