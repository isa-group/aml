package es.us.isa.aml.util;

import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.WsagParser;

/**
 * Provides a parser according to an agreement language.
 * 
 * @author jdelafuente
 *
 */
public class ParserFactory {

	private static final IAgreeParser iAgreeParser = new IAgreeParser();
	private static final WsagParser wsagParser = new WsagParser();

	public static AgreementParser createParser(AgreementLanguage lang) {
		switch (lang) {
		case IAGREE:
			return iAgreeParser;
		case WSAG:
			return wsagParser;
		default:
			throw new IllegalArgumentException(
					"There is no parser for this language: " + lang);
		}
	}

	private ParserFactory() {
	}

}
