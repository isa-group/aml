/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.ParserFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AntonioGamez
 */
public class Store {

    private final Map<String, AgreementFile> agreementFileMap;
    private final Map<String, AgreementModel> agreementModelMap;
    private final List<AgreementParser> parsers;
    private Boolean isParsed;

    public Store() {
        this.agreementFileMap = new HashMap<>();
        this.agreementModelMap = new HashMap<>();
        this.parsers = new ArrayList<>();
        this.isParsed = false;
    }

    public Map<String, AgreementFile> getAgreementFileMap() {
        return Collections.unmodifiableMap(this.agreementFileMap);
        //instead of make a map copy, it's more memory efficient
    }

    public Map<String, AgreementModel> getAgreementModelMap() {
        return Collections.unmodifiableMap(this.agreementModelMap);
    }

    public AgreementModel getAgreementModel(String name) {
        if (!this.isParsed) {
            this.parseAgreementFileMap();
        }
        return this.agreementModelMap.get(name.toLowerCase());
    }

    public void addAgreementFile(String name, AgreementFile file) {
        this.agreementFileMap.put(name.toLowerCase(), file);
        this.isParsed = false;
    }

    public void deleteAgreementFile(String name) {
        this.agreementFileMap.remove(name);
        this.isParsed = false;
    }

    public void parseAgreementFileMap() {
        for (Map.Entry<String, AgreementFile> entry : this.agreementFileMap.entrySet()) {
            AgreementFile agreementFile = entry.getValue();
            AgreementModel agreementModel = this.parseAgreementFile(agreementFile);
            this.agreementModelMap.put(entry.getKey().toLowerCase(), agreementModel);
        }
        this.isParsed = true;
    }

    public AgreementModel parseAgreementFileElement(String name) {
        AgreementFile agreementFile = this.agreementFileMap.get(name);
        return this.parseAgreementFile(agreementFile);
    }

    private AgreementModel parseAgreementFile(AgreementFile agreementFile) {
        AgreementParser parser = this.getParser(agreementFile.getLang());
        AgreementModel agreementModel = parser.doParse(agreementFile);
        return agreementModel;
    }

    // avoid having multiple instances of the same parser object
    private AgreementParser getParser(AgreementLanguage lang) {
        for (AgreementParser p : this.parsers) {
            if (p.getSupportedLang().equals(lang)) {
                return p;
            }
        }
        AgreementParser parser = ParserFactory.createParser(lang);
        this.parsers.add(parser);
        return parser;
    }

}
