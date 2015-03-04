/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.parsers.agreements;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.util.AgreementFile;
import isa.us.es.aml.util.AgreementLanguage;

/**
 *
 * @author AntonioGamez
 */
public interface AgreementParser {

    AgreementModel doParse(AgreementFile file);

    AgreementLanguage getSupportedLang();
}
