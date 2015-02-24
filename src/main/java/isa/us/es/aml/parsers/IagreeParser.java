/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.parsers;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.parsers.iagree.MiAgreeVisitor;
import isa.us.es.aml.parsers.iagree.iAgreeLexer;
import isa.us.es.aml.parsers.iagree.iAgreeParser;
import isa.us.es.aml.parsers.iagree.iAgreeParser.EntryContext;
import isa.us.es.aml.util.SLAFile;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author Antonio
 */
public class IagreeParser implements Parser {

	@Override
	public AgreementModel doParse(SLAFile file) {

		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(
				file.getContent()));

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		iAgreeParser parser = new iAgreeParser(tokens);

		// TODO implementar error listener
		// IAgreeErrorListener errorListener = new IAgreeErrorListener();
		// parser.addErrorListener(errorListener);

		// Specify our entry point
		EntryContext context = parser.entry();

		// Walk it and attach our listener
		MiAgreeVisitor visitor = new MiAgreeVisitor();
		AgreementModel model = visitor.visitEntry(context);

		return model;
	}

}
