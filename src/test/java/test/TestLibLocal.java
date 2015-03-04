/**
 *
 */
package test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Util;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jdelafuente
 *
 */
public class TestLibLocal {

    /**
     * @param args
     */
    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());

    public static void main(String[] args) {

        String SLA = Util.loadFile("samples/iagree/AmazonS3-medium.at");

        AgreementManager serv = new AgreementManager();
        serv.addTemplateFile(SLA, AgreementLanguage.IAGREE);

        TestLibLocal.LOG.log(Level.INFO, "Valid template: {0}", serv.isValidTemplate());
    }

}
