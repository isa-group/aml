package es.us.isa.util;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group)
 * University of Sevilla, Spain
 *
 * @author Antonio Gamez <agamez2@us.es>
 * @version 1.0
 */

public class Helper {
    private static final Logger LOG = Logger.getLogger(Helper.class.getName());
    private static Helper instance;
    private static AgreementManager agr;

    protected Helper() {
    }

    public static Helper getInstance() {
        if (instance == null) {
            init();
            instance = new Helper();
            loadTestAgreements();
        }
        return instance;
    }

    public static AgreementManager getAgreementManager() {
        return agr;
    }

    private static void init() {
        agr = new AgreementManager();
        agr.getStoreManager().registerFromFolder(new File("templates").getAbsolutePath(), false);
    }

    private static void loadTestAgreements() {
        loadTestAgreement("basicPlanT", "basicUser1");
        loadTestAgreement("basicPlanT", "basicUser2");
        loadTestAgreement("mediumPlanT", "mediumUser1");
        loadTestAgreement("mediumPlanT", "mediumUser2");
        loadTestAgreement("proPlanT", "proUser1");
        loadTestAgreement("proPlanT", "proUser2");
    }

    private static void loadTestAgreement(String templateName, String clientId) {
        try {
            agr.getStoreManager().getAgreementTemplate(templateName).generateAgreementOffer(clientId).generateAgreement(clientId).register(clientId);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Agreement Template " + templateName + " could not be loaded");
        }
    }

    public Translator getIAgreeTranslator() {
        return new Translator(new IAgreeBuilder());
    }
}