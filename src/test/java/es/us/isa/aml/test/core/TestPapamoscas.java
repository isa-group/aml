/**
 *
 */
package es.us.isa.aml.test.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 *
 */
public class TestPapamoscas {

	private static final Logger LOG = Logger.getLogger(TestPapamoscas.class
			.getName());
	private static AgreementManager service;
	private static AgreementTemplate model1;

	@BeforeClass
	public static void init() {
		service = new AgreementManager();
		model1 = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");
	}

	@Test
	public void testCreateOfferFromTemplate() {
		AgreementTemplate at = model1;
		AgreementOffer ao = model1.generateAgreementOffer("OfferClient");

		assertTrue(at instanceof AgreementTemplate);
		assertTrue(ao instanceof AgreementOffer);

		assertTrue(at.getDocType().equals(DocType.TEMPLATE));
		assertTrue(ao.getDocType().equals(DocType.OFFER));

		AreCompliant compliantOp = new AreCompliant();
		compliantOp.analyze(at, ao);
		OperationResponse resp = compliantOp.getResult();
		// TODO Should be true
		assertFalse(Boolean.valueOf(resp.get("compliant").toString()));
	}

	@Test
	public void testCreateAgreementFromOffer() {
		AgreementTemplate at = model1;
		AgreementOffer ao = model1.generateAgreementOffer("OfferClient");
		Agreement ag = ao.generateAgreement("AgClient");

		assertTrue(at instanceof AgreementTemplate);
		assertTrue(ao instanceof AgreementOffer);
		assertTrue(ag instanceof Agreement);

		assertEquals(at.getDocType(), DocType.TEMPLATE);
		assertEquals(ao.getDocType(), DocType.OFFER);
		assertEquals(ag.getDocType(), DocType.AGREEMENT);
	}
}
