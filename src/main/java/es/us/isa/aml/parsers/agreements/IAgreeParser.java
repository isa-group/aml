/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:src/main/java/es/us/isa/aml/parsers/agreements/IAgreeParser.java
package es.us.isa.aml.parsers.agreements;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeLexer;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.translators.iagree.IAgreeBuilder;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;
=======
package isa.us.es.aml.parsers.agreements;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.parsers.agreements.iagree.IAgreeErrorListener;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeLexer;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.EntryContext;
import isa.us.es.aml.translators.iagree.IAgreeBuilder;
import isa.us.es.aml.util.AgreementFile;
import isa.us.es.aml.util.AgreementLanguage;

>>>>>>> 56ce2d3e8953ccb3c64f8b2cd58faa66438081fd:src/main/java/isa/us/es/aml/parsers/agreements/IAgreeParser.java
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author AntonioGamez
 */
public class IAgreeParser implements AgreementParser {

	private IAgreeErrorListener errorListener;
	
	public IAgreeParser() {
	}

	@Override
	public AgreementModel doParse(AgreementFile file) {

		AgreementModel model;

		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(
				file.getContent()));

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		iAgreeParser parser = new iAgreeParser(tokens);

		errorListener = new IAgreeErrorListener();
		parser.addErrorListener(errorListener);

		// Specify our entry point
		EntryContext context = parser.entry();

		// Walk it and attach our listener
		IAgreeBuilder visitor = new IAgreeBuilder();
		model = visitor.visitEntry(context);

		return model;
	}

	@Override
	public AgreementLanguage getSupportedLang() {
		return AgreementLanguage.IAGREE;
	}
	
	public IAgreeErrorListener getErrorListener() {
		return errorListener;
	}

}
