package isa.us.es.aml.parsers;

import isa.us.es.aml.util.AgreementLanguage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Antonio
 */
public class ParserProxy {

    public static Parser createParser(AgreementLanguage lang) {
        switch (lang) {
            case IAGREE:
                return new IagreeParser();
            case WSAG:
                return new WsagParser();
            default:
                throw new IllegalArgumentException("there is no parser for this language" + lang.toString());
        }
    }

}
