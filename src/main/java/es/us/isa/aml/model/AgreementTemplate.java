package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * This class represents an agreement template.
 * 
 * @author jdelafuente
 *
 */
public class AgreementTemplate extends AgreementModel {

	protected Map<String, CreationConstraint> creationConstraints = new HashMap<String, CreationConstraint>();

	public AgreementTemplate() {
		this.docType = DocType.TEMPLATE;
	}

	public Map<String, CreationConstraint> getCreationConstraints() {
		return this.creationConstraints;
	}

	public void setCreationConstraints(
			Map<String, CreationConstraint> creationConstraints) {
		this.creationConstraints = creationConstraints;
	}

	public void loadFromFile(String path) {
		AgreementLanguage lang = AgreementLanguage.valueOf(Config
				.getInstance().getDefaultInputFormat());
		loadFromFile(path, lang);
	}

	public void loadFromFile(String path, AgreementLanguage lang) {
		AgreementTemplate newT = (AgreementTemplate) AgreementParser
				.parseAgreementFile(path, lang);
		this.manager = newT.manager;
		this.agreementTerms = newT.agreementTerms;
		this.context = newT.context;
		this.creationConstraints = newT.creationConstraints;
		this.docType = newT.docType;
		this.id = newT.id;
		this.version = newT.version;
	}

	public AgreementOffer generateAgreementOffer(String consumerName) {
		AgreementOffer ao = new AgreementOffer();
		ao.setDocType(DocType.OFFER);
		ao.setID(id + "_" + consumerName);
		ao.setVersion(version);
		ao.setContext(context.clone());
		ao.getContext().setTemplateId(id);
		ao.getContext().setTemplateVersion(version);
		ao.getContext().setConsumer(consumerName);
		ao.setAgreementTerms(agreementTerms.clone());
		ao.setAgreementManager(manager);
		return ao;
	}

	@Override
	public AgreementModel clone() {
		AgreementTemplate model = (AgreementTemplate) super.clone();
		Map<String, CreationConstraint> ccs = this.getCreationConstraints();
		for (CreationConstraint cc : ccs.values())
			((AgreementTemplate) model).getCreationConstraints().put(
					cc.getId(), cc.clone());
		return model;
	}
}
