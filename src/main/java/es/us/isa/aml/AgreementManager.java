/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.noCore.ValidOp;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.Util;

/**
 *
 * @author AntonioGamez
 */
public class AgreementManager {

    private static final Logger LOG = Logger.getLogger(AgreementManager.class.getName());
    private final Store store;

    public AgreementManager() {
        try {
            InputStream in = getClass().getResourceAsStream("/defaultConfig.json");
            String config = Util.getStringFromInputStream(in);
            Config.loadConfig(config);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "AgreementManager load config error", ex);
        }
        this.store = Store.getInstance();
    }

    public AgreementManager(String json) {
        try {
            Config.loadConfig(json);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "AgreementManager load config error", ex);
        }
        this.store = new Store();
    }

    public Store getStoreManager() {
        return this.store;
    }

    //   Start agreement files and model management
    // Creation
    
    public Agreement createAgreementFromFile(String path) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        String content = Util.loadFile(path);
        return store.createAgreement(content, lang, this);
    }

    public Agreement createAgreementFromFile(String path, AgreementLanguage lang) {
        String content = Util.loadFile(path);
        return store.createAgreement(content, lang, this);
    }

    public Agreement createAgreement(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        return store.createAgreement(content, lang, this);
    }
    
    public AgreementOffer createAgreementOfferFromFile(String path) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        String content = Util.loadFile(path);
        return store.createAgreementOffer(content, lang, this);
    }

    public AgreementOffer createAgreementOfferFromFile(String path, AgreementLanguage lang) {
        String content = Util.loadFile(path);
        return store.createAgreementOffer(content, lang, this);
    }

    public AgreementOffer createAgreementOffer(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        return store.createAgreementOffer(content, lang, this);
    }

    public AgreementTemplate createAgreementTemplateFromFile(String path) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        String content = Util.loadFile(path);
        return store.createAgreementTemplate(content, lang, this);
    }

    public AgreementTemplate createAgreementTemplateFromFile(String path, AgreementLanguage lang) {
        String content = Util.loadFile(path);
        return store.createAgreementTemplate(content, lang, this);
    }

    public AgreementTemplate createAgreementTemplate(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        return store.createAgreementTemplate(content, lang, this);
    }

    // Registration
    public void registerTemplate(AgreementTemplate template) {
        store.register("template", template);
    }

    public void registerOffer(AgreementOffer offer) {
        store.register("offer", offer);
    }

    // Retrieve
    public AgreementTemplate getAgreementTemplate() {
        return store.getAgreementTemplate("template");
    }

    public AgreementOffer getAgreementOffer() {
        return store.getAgreementOffer("offer");
    }

    // End agreement files and model management
    // Start operations
    public Boolean isValid(AgreementModel agreementModel) {
        ValidOp op = new ValidOp();
        op.analyze(agreementModel);
        return (Boolean) op.getResult().get("valid");
    }

    public OperationResponse isValidFullResponse(AgreementModel agreementModel) {
        ValidOp op = new ValidOp();
        op.analyze(agreementModel);
        return op.getResult();
    }

    //
}
