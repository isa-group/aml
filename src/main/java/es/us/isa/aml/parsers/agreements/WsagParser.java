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
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.wsag.WsagParserHelper;
import es.us.isa.aml.util.AgreementLanguage;

/**
 * Parser for WSAG documents.
 * 
 * @author jdelafuente
 *
 */
public class WsagParser extends AgreementParser {

	private static final Logger LOG = Logger.getLogger(WsagParser.class
			.getName());

	@Override
	public AgreementModel doParse(String content) {
		return doParse(content, null);
	}

	@Override
	public AgreementModel doParse(String content, File[] metrics) {
		AgreementModel model = null;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(
					content)));
			doc.getDocumentElement().normalize();
			WsagParserHelper helper = new WsagParserHelper(doc, metrics);
			model = helper.getModel();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			LOG.log(Level.WARNING, null, e);
		}

		return model;
	}

	@Override
	public AgreementLanguage getSupportedLang() {
		return AgreementLanguage.WSAG;
	}

}
