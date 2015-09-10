package es.us.isa.aml.parsers.agreements;

import java.io.File;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.ParserFactory;

/**
 * Abstract class to parse an agreement file.
 * 
 * @author jdelafuente
 *
 */
public abstract class AgreementParser {

	public abstract AgreementModel doParse(String content);

	public abstract AgreementModel doParse(String content, File[] metrics);

	public abstract AgreementLanguage getSupportedLang();

	// Parsing
	public static AgreementModel parseAgreementFile(String content) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		AgreementParser parser = ParserFactory.createParser(lang);
		return parser.doParse(content);
	}

	public static AgreementModel parseAgreementFile(String content,
			AgreementLanguage lang) {
		AgreementParser parser = ParserFactory.createParser(lang);
		AgreementModel model = parser.doParse(content);
		return model;
	}

	public static AgreementModel parseAgreementFile(String content,
			File[] metrics, AgreementLanguage lang) {
		AgreementParser parser = ParserFactory.createParser(lang);
		AgreementModel model = parser.doParse(content, metrics);
		return model;
	}
}
