/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeLexer;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.translators.iagree.IAgreeBuilder;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author AntonioGamez
 */
public class IAgreeParser implements AgreementParser {

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

        // TODO implementar error listener
        // IAgreeErrorListener errorListener = new IAgreeErrorListener();
        // parser.addErrorListener(errorListener);
        // Specify our entry point
        iAgreeParser.EntryContext context = parser.entry();

        // Walk it and attach our listener
        IAgreeBuilder visitor = new IAgreeBuilder();
        model = visitor.visitEntry(context);

        return model;
    }

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.IAGREE;
    }

}
