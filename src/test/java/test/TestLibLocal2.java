/**
 *
 */
package test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.noCore.ValidOp;
import es.us.isa.aml.util.Util;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jdelafuente
 *
 */
public class TestLibLocal2 {

    private static final Logger LOG = Logger.getLogger(TestLibLocal2.class
            .getName());
    private static AgreementManager serv;
    private static AgreementModel model1, model2, model3;

    @BeforeClass
    public static void init() {
        serv = new AgreementManager(
                Util.loadFile("src/test/resources/config.json"));

        model1 = serv
                .createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");
        model2 = serv
                .createAgreementTemplateFromFile("src/test/resources/samples/deadterms.at");
        model3 = serv
                .createAgreementTemplateFromFile("src/test/resources/samples/iagree-core-dead.at");

    }

    @Test
    public void testIsValid() {

        LOG.info("\n----------------------- MODEL 1 -----------------------");

        LOG.log(Level.INFO, "model1 is valid: {0}", model1.isValid());
        assertTrue(model1.isValid());

        ValidOp op = new ValidOp();
        op.analyze(model1);

        LOG.log(Level.INFO, "existInconsistencies: {0}", op.getResult().get("existInconsistencies"));
        assertFalse((Boolean) op.getResult().get("existInconsistencies"));

        LOG.log(Level.INFO, "existDeadTerms: {0}", op.getResult().get("existDeadTerms"));
        assertFalse((Boolean) op.getResult().get("existDeadTerms"));

        LOG.log(Level.INFO, "result:\n{0}", op.getResult().get("result"));
        LOG.log(Level.INFO, "conflicts:\n{0}", op.getResult().get("conflicts"));

        LOG.info("\n----------------------- MODEL 2 -----------------------");

        LOG.log(Level.INFO, "model2 is valid: {0}", model2.isValid());
        assertFalse(model2.isValid());

        op.analyze(model2);

        LOG.log(Level.INFO, "existInconsistencies: {0}", op.getResult().get("existInconsistencies"));
        assertTrue((Boolean) op.getResult().get("existInconsistencies"));

        LOG.log(Level.INFO, "existDeadTerms: {0}", op.getResult().get("existDeadTerms"));
        assertTrue((Boolean) op.getResult().get("existDeadTerms"));

        LOG.log(Level.INFO, "result:\n{0}", op.getResult().get("result"));
        LOG.log(Level.INFO, "conflicts:\n{0}", op.getResult().get("conflicts"));

        LOG.info("\n----------------------- MODEL 3 -----------------------");

        LOG.log(Level.INFO, "model3 is valid: {0}", model3.isValid());
        assertFalse(model3.isValid());

        op.analyze(model3);

        LOG.log(Level.INFO, "existInconsistencies: {0}", op.getResult().get("existInconsistencies"));
        assertTrue((Boolean) op.getResult().get("existInconsistencies"));

        LOG.log(Level.INFO, "existDeadTerms: {0}", op.getResult().get("existDeadTerms"));
        assertTrue((Boolean) op.getResult().get("existDeadTerms"));

        LOG.log(Level.INFO, "result:\n{0}", op.getResult().get("result"));
        LOG.log(Level.INFO, "conflicts:\n{0}", op.getResult().get("conflicts"));
    }

}
