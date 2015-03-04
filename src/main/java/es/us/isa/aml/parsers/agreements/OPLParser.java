/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;

/**
 *
 * @author AntonioGamez
 */
public class OPLParser implements AgreementParser {

    public OPLParser() {
    }

    @Override
    public AgreementModel doParse(AgreementFile file) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.OPL;
    }

}
