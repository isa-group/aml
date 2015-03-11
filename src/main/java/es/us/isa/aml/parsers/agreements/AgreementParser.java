/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.AgreementLanguage;

/**
 *
 * @author AntonioGamez
 */
public interface AgreementParser {

    public AgreementModel doParse(String content);

    public AgreementLanguage getSupportedLang();
}
