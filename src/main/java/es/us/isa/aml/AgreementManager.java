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

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.noCore.ValidOp;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
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
        this.store = new Store();
	}
    
    public AgreementManager(String json) {
    	try {
            Config.loadConfig(json);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "AgreementManager load config error", ex);
        }
        this.store = new Store();
    }

    protected Store getStoreManager() {
        return this.store;
    }

    //   Start agreement files and model management
    public AgreementModel createAgreementOffer(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        return createAgreementOffer(content, lang);
    }

    public AgreementModel createAgreementOffer(String content, AgreementLanguage lang) {
        return createAgreement(content, lang, true);
    }

    public AgreementModel createAgreementTemplate(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        return createAgreementOffer(content, lang);
    }

    public AgreementModel createAgreementTemplate(String content, AgreementLanguage lang) {
        return createAgreement(content, lang, false);
    }

    private AgreementModel createAgreement(String content, AgreementLanguage lang, boolean isOffer) {
        AgreementFile file = new AgreementFile(content, lang);
        AgreementModel model;
        if (isOffer) {
            store.addAgreementFile("offer", file);
            model = store.getAgreementModel("offer");
        } else {
            store.addAgreementFile("template", file);
            model = store.getAgreementModel("template");
        }
        model.setAgreementManager(this);
        return model;
    }
    //   End agreement files and model management

    // Start operations
    public Boolean isValid(AgreementModel agreementModel) {
        ValidOp op = new ValidOp();
        op.analyze(agreementModel);
        return op.getResult();
    }

    //
}
