package es.us.isa.aml.translator.builders.wsag.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * An agreement is scoped by its associated context that SHOULD include parties
 * to an agreement. Additionally, the agreement context contains various
 * metadata about the agreement such as the duration of the agreement, and
 * optionally, the template name from which the agreement is created.
 *
 * @author jdelafuente
 *
 */
public class Context {

	/**
	 * This optional element identifies the initiator of the agreement creation
	 * request.
	 */
	private Object agreementInitiator;

	/**
	 * This optional element identifies the agreement responder, i.e. the entity
	 * that responds to the agreement creation request.
	 */
	private Object agreementResponder;

	/**
	 * This element identifies the service provider and is either
	 * AgreementInitiator or AgreementResponder. The default is
	 * AgreementResponder.
	 */
	private AgreementRole serviceProvider;

	/**
	 * This optional element specifies the time at which this agreement is no
	 * longer valid. Agreement initiators MAY use this mechanism to specify an
	 * Agreement service lifetime.
	 */
	private Date expirationTime;

	/**
	 * This OPTIONAL element refers to the specific identifier of the template
	 * from which this offer or agreement is created. If a template was used to
	 * create an offer, the TemplateId in the Context MUST be set.
	 */
	private String templateId;

	/**
	 * This OPTIONAL element specifies the name of the template from which this
	 * agreement is created. The reference to template is useful both for future
	 * modification of the agreement as well as provisioning of the service
	 * environment by the service provider. The template name MUST be included
	 * in an offer if the offer is based on a template
	 */
	private String templateName;

	private List<Metric> metrics = new ArrayList<>();

	/**
	 * @return the agreementInitiator
	 */
	public Object getAgreementInitiator() {
		return agreementInitiator;
	}

	/**
	 * @param agreementInitiator
	 *            the agreementInitiator to set
	 */
	public void setAgreementInitiator(Object agreementInitiator) {
		this.agreementInitiator = agreementInitiator;
	}

	/**
	 * @return the agreementResponder
	 */
	public Object getAgreementResponder() {
		return agreementResponder;
	}

	/**
	 * @param agreementResponder
	 *            the agreementResponder to set
	 */
	public void setAgreementResponder(Object agreementResponder) {
		this.agreementResponder = agreementResponder;
	}

	/**
	 * @return the serviceProvider
	 */
	public AgreementRole getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * @param serviceProvider
	 *            the serviceProvider to set
	 */
	public void setServiceProvider(AgreementRole serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	/**
	 * @return the expirationTime
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}

	/**
	 * @param expirationTime
	 *            the expirationTime to set
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId
	 *            the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @param templateName
	 *            the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the metrics
	 */
	public List<Metric> getMetrics() {
		return metrics;
	}

	/**
	 * @param metrics
	 *            the metrics to set
	 */
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t" + "<wsag:Context>").append("\n");

		if (getTemplateName() != null && getTemplateId() != null) {
			sb.append("\t\t" + "<wsag:TemplateId>").append(getTemplateId())
					.append("</wsag:TemplateId>").append("\n");
			sb.append("\t\t" + "<wsag:TemplateName>").append(getTemplateName())
					.append("</wsag:TemplateName>").append("\n");
		}

		if (getAgreementInitiator() != null) {
			sb.append("\t\t" + "<wsag:AgreementInitiator>")
					.append(getAgreementInitiator().toString())
					.append("</wsag:AgreementInitiator>").append("\n");
		}

		if (getAgreementResponder() != null) {
			sb.append("\t\t" + "<wsag:AgreementResponder>")
					.append(getAgreementResponder().toString())
					.append("</wsag:AgreementResponder>").append("\n");
		}

		if (getServiceProvider() != null) {
			sb.append("\t\t" + "<wsag:ServiceProvider>")
					.append(getServiceProvider().toString())
					.append("</wsag:ServiceProvider>").append("\n");
		}

		if (getExpirationTime() != null) {
			sb.append("\t\t" + "<wsag:ExpirationTime>")
					.append(getExpirationTime().toString())
					.append("</wsag:ExpirationTime>").append("\n");
		}

		if (getTemplateId() != null) {
			sb.append("\t\t" + "<wsag:TemplateId>").append(getTemplateId())
					.append("</wsag:TemplateId>").append("\n");
		}

		if (getTemplateName() != null) {
			sb.append("\t\t" + "<wsag:TemplateName>").append(getTemplateName())
					.append("</wsag:TemplateName>").append("\n");
		}

		if (getMetrics().size() > 0) {
			sb.append("\t\t" + "<iag:Metrics>").append("\n");
			for (Metric m : getMetrics()) {
				sb.append("\t\t\t" + m.toString());
			}
			sb.append("\t\t" + "</iag:Metrics>").append("\n");
		}

		sb.append("\t" + "</wsag:Context>").append("\n");

		return sb.toString();
	}

}
