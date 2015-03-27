/**
 *
 */
package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.util.DocType;

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
        model1 = serv.createAgreementTemplateFromFile("src/test/resources/samples/papamoscas.at");

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

        AgreementTemplate at = model1;
        AgreementOffer ao = model1.generateAgreementOffer("clienteFurioso");
        Agreement ag = ao.generateAgreement("agreement");

        assertTrue(at instanceof AgreementTemplate);
        assertTrue(ao instanceof AgreementOffer);
        assertTrue(ag instanceof Agreement);

        assertTrue(at.getDocType().equals(DocType.TEMPLATE));
        assertTrue(ao.getDocType().equals(DocType.OFFER));
        assertTrue(ag.getDocType().equals(DocType.AGREEMENT));

        String expAt = t.print(at);
        String expAo = t.print(ao);
        String expAg = t.print(ag);

        assertTrue(expAt.contains("Template"));
        assertTrue(expAo.contains("Offer"));
        assertTrue(expAg.contains("Agreement"));

        assertTrue(expAt.contains("CreationConstraints"));
        assertFalse(expAo.contains("CreationConstraints"));
        assertFalse(expAg.contains("CreationConstraints"));

        LOG.log(Level.INFO, "\n{0}", expAt);
        LOG.log(Level.INFO, "\n-------------------\n{0}", expAo);
        LOG.log(Level.INFO, "\n-------------------\n{0}", expAg);
    }
}
