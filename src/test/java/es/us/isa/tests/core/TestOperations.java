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
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
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
	private static AgreementTemplate model1, model2, model3, model4, model5, azureTemplate, TSCTemplate;
	private static AgreementOffer model6, azureOffer1, azureOffer2, azureOffer3, azureOffer4, TSCCompliant;

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
		azureOffer1 = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/azure-compliantOffer.ao");
		azureOffer2 = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant1.ao");
		azureOffer3 = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant2.ao");
		azureOffer4 = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant3.ao");
		azureTemplate = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/azure-template.at");
		TSCTemplate = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/template-Fig2.at");
		TSCCompliant = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/compliantOffer.ao");
	}

	@Test
	public void testValidation() {
		assertTrue(model1.isValid());
		assertFalse(model2.isValid());
		assertFalse(model3.isValid());
		assertFalse(model4.isValid());
		assertTrue(model5.isValid());
		assertTrue(model6.isValid());
		assertTrue(azureOffer1.isValid()); 
		assertTrue(azureOffer2.isValid()); 
		assertTrue(azureOffer3.isValid());
		assertTrue(azureOffer4.isValid()); 
		assertTrue(azureTemplate.isValid());
		assertTrue(TSCTemplate.isValid());
		assertTrue(TSCCompliant.isValid()); 
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
		
		op.analyze(azureOffer1);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));
		
		op.analyze(azureOffer2);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));
		
		op.analyze(azureOffer3);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));
		
		op.analyze(azureOffer4);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));
		
		op.analyze(azureTemplate);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));
		
		op.analyze(TSCTemplate);
		assertFalse(Boolean.valueOf(op.getResult().get("existInconsistencies")
				.toString()));

		op.analyze(TSCCompliant);
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
		
		op.analyze(azureOffer1);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString())); 
		
		op.analyze(azureOffer2);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString())); 
		
		op.analyze(azureOffer3);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));
		
		op.analyze(azureOffer4);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString())); 
		
		op.analyze(azureTemplate);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));
		
		op.analyze(TSCTemplate);
		assertFalse(Boolean.valueOf(op.getResult().get("existDeadTerms")
				.toString()));
		
		op.analyze(TSCCompliant);
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
		
		op.analyze(azureOffer1);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString())); 
		
		op.analyze(azureOffer2);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString())); 
		
		op.analyze(azureOffer3);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString())); 
		
		op.analyze(azureOffer4);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString())); 
		
		op.analyze(azureTemplate);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));
		
		op.analyze(TSCTemplate);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));

		op.analyze(TSCCompliant);
		assertFalse(Boolean.valueOf(op.getResult().get("existCondInconsTerms")
				.toString()));
	}

	@Test
	public void testAreCompliant1() {
		AreCompliant op = new AreCompliant();
		op.analyze(model5, model6);
		OperationResponse resp = op.getResult();
		assertTrue(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testAreCompliant2() {
		AreCompliant op = new AreCompliant();
		op.analyze(azureTemplate, azureOffer1);
		OperationResponse resp = op.getResult();
		assertTrue(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testAreCompliant3() {
		AreCompliant op = new AreCompliant();
		op.analyze(azureTemplate, azureOffer2);
		OperationResponse resp = op.getResult();
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testAreCompliant4() {
		AreCompliant op = new AreCompliant();
		op.analyze(azureTemplate, azureOffer3);
		OperationResponse resp = op.getResult();
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testAreCompliant5() {
		AreCompliant op = new AreCompliant();
		op.analyze(azureTemplate, azureOffer4);
		OperationResponse resp = op.getResult();
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testAreCompliant6() {
		AreCompliant op = new AreCompliant();
		op.analyze(TSCTemplate, TSCCompliant);
		OperationResponse resp = op.getResult();
		assertTrue(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testWhyAreNotCompliant1() {
		WhyAreNotCompliant op = new WhyAreNotCompliant();
		op.analyze(azureTemplate, azureOffer1);
		OperationResponse resp = op.getResult();
		assertTrue(Boolean.valueOf(resp.get("compliant").toString()));
	}
	
	@Test
	public void testWhyAreNotCompliant2() {
		WhyAreNotCompliant op = new WhyAreNotCompliant();
		op.analyze(azureTemplate, azureOffer2);
		OperationResponse resp = op.getResult();
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
		assertTrue(resp.get("conflicts").toString().equalsIgnoreCase("[G1: MUP < 999;]"));
		assertTrue(resp.get("conflictType").toString().equalsIgnoreCase("contradictory offer term"));
	}
	
	@Test
	public void testWhyAreNotCompliant3() {
		WhyAreNotCompliant op = new WhyAreNotCompliant();
		op.analyze(azureTemplate, azureOffer3);
		OperationResponse resp = op.getResult();
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
		assertTrue(resp.get("conflicts").toString().equalsIgnoreCase("[G1: MUP >= 9999;]"));
		assertTrue(resp.get("conflictType").toString().equalsIgnoreCase("more restrictive offer term"));
	}
	
	@Test
	public void testWhyAreNotCompliant4() {
		WhyAreNotCompliant op = new WhyAreNotCompliant();
		op.analyze(azureTemplate, azureOffer4);
		OperationResponse resp = op.getResult();
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
		assertTrue(resp.get("conflicts").toString().equalsIgnoreCase("[ASSIG_Price: Price == 10000;]"));
		assertTrue(resp.get("conflictType").toString().equalsIgnoreCase("contradictory offer term"));
	}
	
	@Test
	public void testWhyAreNotCompliant5() {
		WhyAreNotCompliant op = new WhyAreNotCompliant();
		op.analyze(TSCTemplate, TSCCompliant);
		OperationResponse resp = op.getResult();
		assertTrue(Boolean.valueOf(resp.get("compliant").toString()));
	}

}
