package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.generator.AgreementGenerator;
import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.GeneratorFactory;

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
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
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
		AgreementGenerator generator = GeneratorFactory.createGenerator();
		AgreementOffer ao = generator.generateAgreementOfferFromTemplate(
				consumerName, this);
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
