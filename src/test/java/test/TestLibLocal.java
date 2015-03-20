/**
 *
 */
package test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.translators.iagree.IAgreeBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
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
    private static AgreementTemplate model1, model2, model3;

    @BeforeClass
    public static void init() {
        //serv = new AgreementManager(Util.loadFile("src/test/resources/config.json"));
        serv = new AgreementManager();

        model1 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");
        model2 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core-dead.at");
        model3 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core-condIncs.at");
    }

    @Test
    public void testIsValid() {

//        LOG.log(Level.INFO, "\n-----------------TEST_1-----------------");
//        LOG.log(Level.INFO, "\n{0}", model1.isValidFullResponse().toString());
        assertTrue(model1.isValid());
        assertFalse((Boolean) model1.isValidFullResponse().get("existInconsistencies"));
        assertFalse((Boolean) model1.isValidFullResponse().get("existDeadTerms"));
        assertFalse((Boolean) model1.isValidFullResponse().get("existCondInconsTerms"));

//        LOG.log(Level.INFO, "\n-----------------TEST_2-----------------");
//        LOG.log(Level.INFO, "\n{0}", model2.isValidFullResponse().toString());
        assertFalse(model2.isValid());
        assertTrue((Boolean) model2.isValidFullResponse().get("existInconsistencies"));
        assertTrue((Boolean) model2.isValidFullResponse().get("existDeadTerms"));
        assertTrue((Boolean) model2.isValidFullResponse().get("existCondInconsTerms"));

//        LOG.log(Level.INFO, "\n-----------------TEST_3-----------------");
//        LOG.log(Level.INFO, "\n{0}", model3.isValidFullResponse().toString());
        assertFalse(model3.isValid());
        assertTrue((Boolean) model3.isValidFullResponse().get("existInconsistencies"));
        assertFalse((Boolean) model3.isValidFullResponse().get("existDeadTerms"));
        assertTrue((Boolean) model3.isValidFullResponse().get("existCondInconsTerms"));
    }

    @Test
    public void testAgreementToString() {
        Translator t = new Translator(new IAgreeBuilder());

        AgreementTemplate at = new AgreementTemplate(model1);
        AgreementOffer ao = model1.generateAgreement("clienteFurioso");
        Agreement ag = new Agreement(ao);

        assertTrue(at instanceof AgreementTemplate);
        assertTrue(ao instanceof AgreementOffer);
        assertTrue(ag instanceof Agreement);

        assertTrue(t.export(at).contains("Template"));
        assertTrue(t.export(ao).contains("Offer"));
        assertTrue(t.export(ag).contains("Agreement"));

        assertTrue(t.export(at).contains("CreationConstraints"));
        assertFalse(t.export(ao).contains("CreationConstraints"));
        assertFalse(t.export(ag).contains("CreationConstraints"));

        LOG.log(Level.INFO, "\n{0}", t.export(at));
        LOG.log(Level.INFO, "\n{0}", t.export(ao));
        LOG.log(Level.INFO, "\n{0}", t.export(ag));
    }
}
