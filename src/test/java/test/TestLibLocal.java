/**
 *
 */
package test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.Util;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jdelafuente
 *
 */
public class TestLibLocal {

    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());
    private static AgreementManager serv;
    private static AgreementModel model1;

    @BeforeClass
    public static void init() {
        serv = new AgreementManager(Util.loadFile("src/test/resources/config.json"));

        model1 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");
    }

    @Test
    public void testIsValid() {

        LOG.log(Level.INFO, "Showing model: \n{0}", model1);
        LOG.log(Level.INFO, "model1a: {0}", serv.isValid(model1));
        LOG.log(Level.INFO, "model1b: {0}", model1.isValid());

        assertFalse(serv.isValid(model1));
        assertFalse(model1.isValid());
    }

}
