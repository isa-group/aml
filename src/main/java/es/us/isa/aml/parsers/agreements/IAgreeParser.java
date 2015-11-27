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
package es.us.isa.aml.parsers.agreements;

import java.io.File;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.parsers.agreements.iagree.MiAgreeVisitor;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeLexer;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser.EntryContext;
import es.us.isa.aml.util.AgreementLanguage;

/**
 * Parser for iAgree documents.
 * 
 * @author jdelafuente
 *
 */
public class IAgreeParser extends AgreementParser {

	private IAgreeErrorListener errorListener;

	@Override
	public AgreementModel doParse(String content) {

		AgreementModel model;

		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(content));

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		iAgreeParser parser = new iAgreeParser(tokens);

		errorListener = new IAgreeErrorListener();
		parser.addErrorListener(errorListener);

		// Specify our entry point
		EntryContext context = parser.entry();

		// Walk it and attach our listener
		MiAgreeVisitor visitor = new MiAgreeVisitor(parser);
		model = visitor.visitEntry(context);

		if (errorListener.getErrors().size() > 0) {
			throw new IllegalArgumentException(
					"There was an error parsing the file. Please, check the syntax of the document.");
		}

		return model;
	}

	@Override
	public AgreementLanguage getSupportedLang() {
		return AgreementLanguage.IAGREE;
	}

	public IAgreeErrorListener getErrorListener() {
		return errorListener;
	}

	@Override
	public AgreementModel doParse(String content, File[] metrics) {
		return doParse(content);
	}

}
