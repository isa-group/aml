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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
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
