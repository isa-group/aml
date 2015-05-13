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
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.noCore.ValidOp;

/**
 * @author jdelafuente
 *
 */
public class TestLibLocal2 {

	private static final Logger LOG = Logger.getLogger(TestLibLocal2.class
			.getName());
	private static AgreementManager serv;
	private static AgreementModel model1, model2, model3, model4;

	@BeforeClass
	public static void init() {
		serv = new AgreementManager();

		model1 = serv
				.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");
		model2 = serv
				.createAgreementTemplateFromFile("src/test/resources/samples/deadterms.at");
		model3 = serv
				.createAgreementTemplateFromFile("src/test/resources/samples/compliant_template.at");
		
		model4 = serv
				.createAgreementOfferFromFile("src/test/resources/samples/compliant_offer.ao");

		// Translator t = new Translator(new CSPBuilder());
		// // CSPModel m = (CSPModel) t.translate(model1);
		// System.out.println(t.print(model1));
		//
		// Translator t2 = new Translator(new IAgreeBuilder());
		// // IAgreeAgreementTemplate at = (IAgreeAgreementTemplate)
		// // t2.translate(model1);
		// System.out.println(t2.print(model1));
		//
		// Translator t3 = new Translator(new WSAGBuilder());
		// // IAgreeAgreementTemplate at = (IAgreeAgreementTemplate)
		// // t2.translate(model1);
		// System.out.println(t3.print(model1));
		
		
	}
	
	@Test
	public void testCompliant() {
		AreCompliant op = new AreCompliant();
		op.analyze(model3, model4);
		System.out.println(op.getResult());
	}

	//@Test
	public void testIsValid() {

		LOG.info("\n----------------------- MODEL 1 -----------------------");

		LOG.log(Level.INFO, "model1 is valid: {0}", model1.isValid());
		assertTrue(model1.isValid());

		ValidOp op = new ValidOp();
		op.analyze(model1);

		LOG.log(Level.INFO, "existInconsistencies: {0}",
				op.getResult().get("existInconsistencies"));
		assertFalse((Boolean) op.getResult().get("existInconsistencies"));

		LOG.log(Level.INFO, "existDeadTerms: {0}",
				op.getResult().get("existDeadTerms"));
		assertFalse((Boolean) op.getResult().get("existDeadTerms"));

		LOG.log(Level.INFO, "existCondInconsTerms: {0}",
				op.getResult().get("existCondInconsTerms"));
		assertFalse((Boolean) op.getResult().get("existCondInconsTerms"));

		LOG.log(Level.INFO, "result:\n{0}", op.getResult().get("result"));
		LOG.log(Level.INFO, "conflicts:\n{0}", op.getResult().get("conflicts"));

		LOG.info("\n----------------------- MODEL 2 -----------------------");

		LOG.log(Level.INFO, "model2 is valid: {0}", model2.isValid());
		
		assertFalse(model2.isValid());

		op.analyze(model2);

		LOG.log(Level.INFO, "existInconsistencies: {0}",
				op.getResult().get("existInconsistencies"));
		assertFalse((Boolean) op.getResult().get("existInconsistencies"));

		LOG.log(Level.INFO, "existDeadTerms: {0}",
				op.getResult().get("existDeadTerms"));
		assertTrue((Boolean) op.getResult().get("existDeadTerms"));

		LOG.log(Level.INFO, "existCondInconsTerms: {0}",
				op.getResult().get("existCondInconsTerms"));
		assertFalse((Boolean) op.getResult().get("existCondInconsTerms"));

		LOG.log(Level.INFO, "result:\n{0}", op.getResult().get("result"));
		LOG.log(Level.INFO, "conflicts:\n{0}", op.getResult().get("conflicts_deadterms"));

		LOG.info("\n----------------------- MODEL 3 -----------------------");

		LOG.log(Level.INFO, "model3 is valid: {0}", model3.isValid());
		assertFalse(model3.isValid());

		op.analyze(model3);

		LOG.log(Level.INFO, "existInconsistencies: {0}",
				op.getResult().get("existInconsistencies"));
		assertFalse((Boolean) op.getResult().get("existInconsistencies"));

		LOG.log(Level.INFO, "existDeadTerms: {0}",
				op.getResult().get("existDeadTerms"));
		assertFalse((Boolean) op.getResult().get("existDeadTerms"));

		LOG.log(Level.INFO, "existCondInconsTerms: {0}",
				op.getResult().get("existCondInconsTerms"));
		assertTrue((Boolean) op.getResult().get("existCondInconsTerms"));

		LOG.log(Level.INFO, "result:\n{0}", op.getResult().get("result"));
		LOG.log(Level.INFO, "conflicts:\n{0}", op.getResult().get("conflicts_condIncons"));
	}
}
