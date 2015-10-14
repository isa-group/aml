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
