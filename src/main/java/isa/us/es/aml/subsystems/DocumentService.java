/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.subsystems;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.parsers.agreements.AgreementParser;
import isa.us.es.aml.util.ParserProxy;
import isa.us.es.aml.util.AgreementFile;
import isa.us.es.aml.util.AgreementLanguage;
import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author AntonioGamez
 */
public class DocumentService {

    private final Map<String, AgreementFile> agreementFileMap;
    private final Map<String, AgreementModel> agreementModelMap;
    private final List<AgreementParser> parsers;
    private Boolean isParsed;

    public DocumentService() {
        agreementFileMap = new HashMap<>();
        agreementModelMap = new HashMap<>();
        parsers = new ArrayList<>();
        isParsed = false;
    }

    public Map<String, AgreementFile> getAgreementFileMap() {
        return Collections.unmodifiableMap(agreementFileMap);
        //instead of make a map copy, it's more memory efficient
    }

    public Map<String, AgreementModel> getAgreementModelMap() {
        return Collections.unmodifiableMap(agreementModelMap);
    }

    public AgreementModel getAgreementModel(String name) {
        if (!isParsed) {
            parseAgreementFileMap();
        }
        return agreementModelMap.get(name.toLowerCase());
    }

    public void addAgreementFile(String name, AgreementFile file) {
        agreementFileMap.put(name.toLowerCase(), file);
        isParsed = false;
    }

    public void deleteAgreementFile(String name) {
        agreementFileMap.remove(name);
        isParsed = false;

    }

    public void parseAgreementFileMap() {
        for (Entry<String, AgreementFile> entry : agreementFileMap.entrySet()) {
            AgreementFile agreementFile = entry.getValue();
            AgreementModel agreementModel = parseAgreementFile(agreementFile);
            agreementModelMap.put(entry.getKey().toLowerCase(), agreementModel);
        }
        isParsed = true;
    }

    public AgreementModel parseAgreementFileElement(String name) {
        AgreementFile agreementFile = agreementFileMap.get(name);
        return parseAgreementFile(agreementFile);
    }

    private AgreementModel parseAgreementFile(AgreementFile agreementFile) {
        AgreementParser parser = getParser(agreementFile.getLang());
        AgreementModel agreementModel = parser.doParse(agreementFile);
        return agreementModel;
    }

    // avoid having multiple instances of the same parser object
    private AgreementParser getParser(AgreementLanguage lang) {
        for (AgreementParser p : parsers) {
            if (p.getSupportedLang().equals(lang)) {
                return p;
            }
        }
        AgreementParser parser = ParserProxy.createParser(lang);
        parsers.add(parser);
        return parser;
    }

}
