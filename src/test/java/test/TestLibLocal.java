/**
 *
 */
package test;

import isa.us.es.aml.AgreementService;
import isa.us.es.aml.util.AgreementLanguage;
import isa.us.es.aml.util.Util;
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

        AgreementService serv = new AgreementService();
        serv.addTemplateFile(SLA, AgreementLanguage.IAGREE);

        TestLibLocal.LOG.log(Level.INFO, "Valid template: {0}", serv.isValidTemplate());
    }

}
