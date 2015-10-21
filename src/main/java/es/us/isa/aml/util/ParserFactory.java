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
