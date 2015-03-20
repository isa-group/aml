/**
 *
 */
package test;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.noCore.ValidOp;
import es.us.isa.aml.util.Util;

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
		
		LOG.info("model1 is valid: " + model1.isValid());
		assertTrue(model1.isValid());
		
		ValidOp op = new ValidOp();
		op.analyze(model1);
		
		LOG.info("existInconsistencies: "
				+ op.getResult().get("existInconsistencies"));
		assertFalse((Boolean) op.getResult().get("existInconsistencies"));
		
		LOG.info("existDeadTerms: "
				+ op.getResult().get("existDeadTerms"));
		assertFalse((Boolean) op.getResult().get("existDeadTerms"));
		
		LOG.info("result:\n" + op.getResult().get("result"));
		LOG.info("conflicts:\n" + op.getResult().get("conflicts"));

		LOG.info("\n----------------------- MODEL 2 -----------------------");
		
		LOG.info("model2 is valid: " + model2.isValid());
		assertFalse(model2.isValid());

		op.analyze(model2);
		
		LOG.info("existInconsistencies: "
				+ op.getResult().get("existInconsistencies"));
		assertTrue((Boolean) op.getResult().get("existInconsistencies"));
		
		LOG.info("existDeadTerms: "
				+ op.getResult().get("existDeadTerms"));
		assertTrue((Boolean) op.getResult().get("existDeadTerms"));
		
		LOG.info("result:\n" + op.getResult().get("result"));
		LOG.info("conflicts:\n" + op.getResult().get("conflicts"));

		LOG.info("\n----------------------- MODEL 3 -----------------------");
		
		LOG.info("model3 is valid: " + model3.isValid());
		assertFalse(model3.isValid());

		op.analyze(model3);
		
		LOG.info("existInconsistencies: "
				+ op.getResult().get("existInconsistencies"));
		assertTrue((Boolean) op.getResult().get("existInconsistencies"));
		
		LOG.info("existDeadTerms: "
				+ op.getResult().get("existDeadTerms"));
		assertTrue((Boolean) op.getResult().get("existDeadTerms"));
		
		LOG.info("result:\n" + op.getResult().get("result"));
		LOG.info("conflicts:\n" + op.getResult().get("conflicts"));
    }

}
