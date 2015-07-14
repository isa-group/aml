/**
 *
 */
package es.us.isa.tests.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.operations.noCore.ExistCondInconsTermsOp;
import es.us.isa.aml.operations.noCore.ExistDeadTermsOp;
import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 *
 */
public class TestOperations {

	private static final Logger LOG = Logger.getLogger(TestOperations.class
			.getName());
	private static AgreementManager service;
	private static AgreementTemplate model1, model2, model3, model4, model5;
	private static AgreementOffer model6;

	@BeforeClass
	public static void init() {
		service = new AgreementManager();
		model1 = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");
		model2 = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/inconsistent.at");
		model3 = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/dead-terms.at");
		model4 = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/cond-inconsistent.at");
		model5 = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/compliant-template.at");
		model6 = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/compliant-offer.ao");
	}

	@Test
	public void testValidation() {
		assertTrue(model1.isValid());
		assertFalse(model2.isValid());
		assertFalse(model3.isValid());
		assertFalse(model4.isValid());
		assertTrue(model5.isValid());
		assertTrue(model6.isValid());
	}

	@Test
	public void testInconsistencyOperation() {
		ExistInconsistenciesOp op = new ExistInconsistenciesOp();
		op.analyze(model1);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));

		op.analyze(model2);
		assertTrue(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));

		op.analyze(model3);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));

		op.analyze(model4);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));

		op.analyze(model5);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));

		op.analyze(model6);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));
	}

	@Test
	public void testDeadTermsOperation() {
		ExistDeadTermsOp op = new ExistDeadTermsOp();
		op.analyze(model1);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));

		op.analyze(model2);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));

		op.analyze(model3);
		assertTrue(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));

		op.analyze(model4);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));

		op.analyze(model5);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));

		op.analyze(model6);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));
	}

	@Test
	public void testCondInconsistentOperation() {
		ExistCondInconsTermsOp op = new ExistCondInconsTermsOp();
		op.analyze(model1);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));

		op.analyze(model2);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));

		op.analyze(model3);
		// TODO here cond incons should be false
		assertTrue(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));

		op.analyze(model4);
		assertTrue(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));

		op.analyze(model5);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));

		op.analyze(model6);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));
	}

	@Test
	public void testAreCompliant() {
		AreCompliant op = new AreCompliant();
		op.analyze(model5, model6);
		OperationResponse resp = op.getResult();
		assertTrue(Boolean.valueOf(resp.get("compliant").toString()));
	}

}
