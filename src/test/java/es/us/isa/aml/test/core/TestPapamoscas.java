/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.test.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
