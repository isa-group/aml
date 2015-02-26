/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.parsers.agreements;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.parsers.agreements.iagree.MiAgreeVisitor;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeLexer;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser;
import isa.us.es.aml.parsers.agreements.iagree.iAgreeParser.EntryContext;
import isa.us.es.aml.util.AgreementFile;
import isa.us.es.aml.util.AgreementLanguage;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;



/**
 *
 * @author AntonioGamez
 */
public class IagreeParser implements AgreementParser {

    public IagreeParser() {
    }

    @Override
    public AgreementModel doParse(AgreementFile file) {

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

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.IAGREE;
    }

}
