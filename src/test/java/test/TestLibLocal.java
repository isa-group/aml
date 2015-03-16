/**
 *
 */
package test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.util.Util;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author AntonioGamez
 *
 */
public class TestLibLocal {

    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());
    private static AgreementManager serv;
    private static AgreementModel model1, model2;

    @BeforeClass
    public static void init() {
        serv = new AgreementManager(Util.loadFile("src/test/resources/config.json"));

        model1 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");
        model2 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core-dead.at");
    }

    @Test
    public void testIsValid() {

//        assertTrue(model1.isValid());
//        assertTrue(model2.isValid());

    }

}
