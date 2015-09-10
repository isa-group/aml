package es.us.isa.aml.model;

import es.us.isa.aml.generator.AgreementGenerator;
import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.GeneratorFactory;

/**
 * This class represents an agreement offer.
 * 
 * @author jdelafuente
 *
 */
public class AgreementOffer extends AgreementModel {

	public AgreementOffer() {
		this.docType = DocType.OFFER;
	}

	public void loadFromFile(String path) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		loadFromFile(path, lang);
	}

	public void loadFromFile(String path, AgreementLanguage lang) {
		AgreementOffer newT = (AgreementOffer) AgreementParser
				.parseAgreementFile(path, lang);
		this.manager = newT.manager;
		this.agreementTerms = newT.agreementTerms;
		this.context = newT.context;
		this.docType = newT.docType;
		this.id = newT.id;
		this.version = newT.version;
	}

	public Agreement generateAgreement(String consumerName) {
		AgreementGenerator generator = GeneratorFactory.createGenerator();
		Agreement ag = generator.generateAgreementFromAgreementOffer(
				consumerName, this);
		return ag;
	}
}
