/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
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
