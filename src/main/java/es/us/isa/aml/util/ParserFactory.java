package es.us.isa.aml.util;

import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.WsagParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AntonioGamez
 */
public class ParserFactory {

    public static AgreementParser createParser(AgreementLanguage lang) {
        switch (lang) {
            case IAGREE:
                return new IAgreeParser();
            case WSAG:
                return new WsagParser();
            default:
                throw new IllegalArgumentException("there is no parser for this language: " + lang);
        }
    }

    private ParserFactory() {
    }

}
