/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.ParserFactory;
import es.us.isa.aml.util.Util;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author AntonioGamez
 */
public class Store {

    private static Store instance = null;

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    protected static Store getInstance(String json) {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }
    private final Map<String, AgreementModel> agreementModelMap;

    protected Store() {
        agreementModelMap = new HashMap<>();
    }

    //main methods
    //creation
    public AgreementOffer createAgreementOffer(String content, AgreementLanguage lang, AgreementManager manager) {
        AgreementOffer offer = (AgreementOffer) parseAgreementFile(content, lang);
        offer.setAgreementManager(manager);
        return offer;
    }

    public AgreementTemplate createAgreementTemplate(String content, AgreementLanguage lang, AgreementManager manager) {
        AgreementTemplate template = (AgreementTemplate) parseAgreementFile(content, lang);
        template.setAgreementManager(manager);
        return template;
    }

    // Registration
    public void registerFromFile(String path) {
        register(parseAgreementFile(Util.loadFile(path)));
    }

    public void registerFromFile(File file) {
        registerFromFile(file.getPath());
    }

    public void registerFromFolder(String folderPath, Boolean recursive) {
        registerFromFolder(new File(folderPath), recursive);
    }

    public void registerFromFolder(File folder, Boolean recursive) {
        if (folder.isDirectory()) {
            for (File fileEntry : folder.listFiles()) {
                if (recursive && fileEntry.isDirectory()) {
                    registerFromFolder(folder, true);
                } else if (fileEntry.getName().contains(".at") || fileEntry.getName().contains(".ag")) {
                    register(parseAgreementFile(Util.loadFile(fileEntry.getPath())));
                }
            }
        }
    }

    public void register(AgreementModel model) {
        register(model.getID(), model);
    }

    public void register(String name, AgreementModel model) {
        instance.agreementModelMap.put(name, model);
    }

    // Retrieve
    public AgreementTemplate getAgreementTemplate(String name) {
        return (AgreementTemplate) instance.agreementModelMap.get(name);
    }

    public AgreementOffer getAgreementOffer(String name) {
        return (AgreementOffer) instance.agreementModelMap.get(name);
    }

    // Parsing
    public AgreementModel parseAgreementFile(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        AgreementParser parser = ParserFactory.createParser(lang);
        return parser.doParse(content);
    }

    public AgreementModel parseAgreementFile(String content, AgreementLanguage lang) {
        AgreementParser parser = ParserFactory.createParser(lang);
        return parser.doParse(content);
    }

    //other methods
    public Map<String, AgreementModel> getAgreementMap() {
        return Collections.unmodifiableMap(instance.agreementModelMap);
    }

    public void removeAgreement(String name) {
        instance.agreementModelMap.remove(name);
    }

}
