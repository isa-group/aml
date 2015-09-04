package es.us.isa.aml.model;

import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;

/**
 * This class represents an agreement.
 * 
 * @author jdelafuente
 */
public class Agreement extends AgreementOffer {

	public Agreement() {
		super();
		this.docType = DocType.AGREEMENT;
	}

	@Override
	public void loadFromFile(String path) {
		AgreementLanguage lang = AgreementLanguage.valueOf(Config.getInstance()
				.getDefaultInputFormat());
		loadFromFile(path, lang);
	}

	@Override
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
}
