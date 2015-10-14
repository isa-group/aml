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
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.test.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;

/**
 * @author jdelafuente
 *
 */
public class TestCSPModel {

	private static AgreementManager service;
	private static AgreementTemplate iagreeModel;
	private static AgreementOffer iagreeEnumModel;
	private static CSPModel model, enumModel;

	@BeforeClass
	public static void init() {
		service = new AgreementManager();
		iagreeModel = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");

		iagreeEnumModel = service
				.createAgreementOfferFromFile("src/test/resources/core-pack/iagree-enum.ao");

		Translator t = new Translator(new CSPBuilder());
		model = (CSPModel) t.translate(iagreeModel);
		enumModel = (CSPModel) t.translate(iagreeEnumModel);		
	}

	/**
	 * Parse a document and retrieve the model. Then, compare each model element
	 * with a new one of the same type from a given model. <br>
	 * <br>
	 * Lifecycle: <br>
	 * Document 1 - Model 1 - Element 1 <br>
	 * Model 2 - Element 2 <br>
	 * Element 1 vs Element 2
	 */
	@Test
	public void testModel() {

		// Ranges
		CSPRange r1 = new CSPRange("range_met1", new Range(0, 23));
		CSPRange r2 = new CSPRange("range_met2", new Range(0, 512));
		CSPRange r3 = new CSPRange("range_met3", new Range(0, 128));

		Map<String, CSPRange> ranges = new HashMap<String, CSPRange>();
		ranges.put("range_met1", r1);
		ranges.put("range_met2", r2);
		ranges.put("range_met3", r3);

		// Asserts ranges
		for (int i = 0; i < 3; i++) {
			CSPRange range = model.getRanges().get(i);
			CSPRange other = ranges.get(range.getId());
			assertTrue(other != null);
			assertEquals(range.getId(), other.getId());
		}

		// Vars
		CSPVar var1 = new CSPVar("ConfProp1", "int", r1, true);
		CSPVar var2 = new CSPVar("ConfProp2", "int", r2, true);
		CSPVar var3 = new CSPVar("ConfProp3", "int", r3, true);
		CSPVar var4 = new CSPVar("MonitProp1", "int", r3, true);

		Map<String, CSPVar> vars = new HashMap<String, CSPVar>();
		vars.put("ConfProp1", var1);
		vars.put("ConfProp2", var2);
		vars.put("ConfProp3", var3);
		vars.put("MonitProp1", var4);

		// Asserts vars
		for (int i = 0; i < 4; i++) {
			CSPVar var = model.getVariables().get(i);
			CSPVar other = vars.get(var.getId());
			assertTrue(other != null);
			assertEquals(var.getId(), other.getId());
			assertEquals(var.getRange(), other.getRange());
		}

		// Constraints
		CSPConstraint cons1 = new CSPConstraint("G1", iagreeModel
				.getAgreementTerms().getGuaranteeTerms().get("G1").getSlo(),
				iagreeModel.getAgreementTerms().getGuaranteeTerms().get("G1")
						.getQc());
		CSPConstraint cons2 = new CSPConstraint("G2", iagreeModel
				.getAgreementTerms().getGuaranteeTerms().get("G2").getSlo(),
				iagreeModel.getAgreementTerms().getGuaranteeTerms().get("G2")
						.getQc());
		CSPConstraint cons3 = new CSPConstraint("C1", iagreeModel
				.getCreationConstraints().get("C1").getSlo(), iagreeModel
				.getCreationConstraints().get("C1").getQc());
		CSPConstraint cons4 = new CSPConstraint("C2", iagreeModel
				.getCreationConstraints().get("C2").getSlo(), iagreeModel
				.getCreationConstraints().get("C2").getQc());
		CSPConstraint cons5 = new CSPConstraint("C3", iagreeModel
				.getCreationConstraints().get("C3").getSlo(), iagreeModel
				.getCreationConstraints().get("C3").getQc());

		Map<String, CSPConstraint> consts = new HashMap<String, CSPConstraint>();
		consts.put("G1", cons1);
		consts.put("G2", cons2);
		consts.put("C1", cons3);
		consts.put("C2", cons4);
		consts.put("C3", cons5);

		// Asserts constraints
		for (int i = 0; i < model.getConstraints().size(); i++) {
			CSPConstraint cons = model.getConstraints().get(i);
			CSPConstraint other = consts.get(cons.getId());
			assertTrue(other != null);
			assertEquals(cons.getId(), other.getId());
			assertEquals(cons.getExpr(), other.getExpr());
		}
	}

	@Test
	public void testEnumModel() {

		// Ranges
		CSPRange r1 = new CSPRange("range_met1", new Range(0, 23));
		CSPRange r2 = new CSPRange("range_met2", new Range(0, 512));
		CSPRange r3 = new CSPRange("range_met3", new Range(0, 128));

		Map<String, CSPRange> ranges = new HashMap<String, CSPRange>();
		ranges.put("range_met1", r1);
		ranges.put("range_met2", r2);
		ranges.put("range_met3", r3);

		// Asserts ranges
		for (int i = 0; i < 3; i++) {
			CSPRange range = enumModel.getRanges().get(i);
			CSPRange other = ranges.get(range.getId());
			assertTrue(other != null);
			assertEquals(range.getId(), other.getId());
		}

		// Vars
		CSPVar var1 = new CSPVar("ConfProp1", "int", r1, true);
		CSPVar var2 = new CSPVar("ConfProp2", "int", r2, true);
		CSPVar var3 = new CSPVar("ConfProp3", "int", r3, true);
		CSPVar var4 = new CSPVar("MonitProp1", "int", r3, true);

		Map<String, CSPVar> vars = new HashMap<String, CSPVar>();
		vars.put("ConfProp1", var1);
		vars.put("ConfProp2", var2);
		vars.put("ConfProp3", var3);
		vars.put("MonitProp1", var4);

		// Asserts vars
		for (int i = 0; i < 4; i++) {
			CSPVar var = model.getVariables().get(i);
			CSPVar other = vars.get(var.getId());
			assertTrue(other != null);
			assertEquals(var.getId(), other.getId());
			assertEquals(var.getRange(), other.getRange());
		}

		// Constraints
		CSPConstraint cons1 = new CSPConstraint("G1", iagreeModel
				.getAgreementTerms().getGuaranteeTerms().get("G1").getSlo(),
				iagreeModel.getAgreementTerms().getGuaranteeTerms().get("G1")
						.getQc());
		CSPConstraint cons2 = new CSPConstraint("G2", iagreeModel
				.getAgreementTerms().getGuaranteeTerms().get("G2").getSlo(),
				iagreeModel.getAgreementTerms().getGuaranteeTerms().get("G2")
						.getQc());
		CSPConstraint cons3 = new CSPConstraint("C1", iagreeModel
				.getCreationConstraints().get("C1").getSlo(), iagreeModel
				.getCreationConstraints().get("C1").getQc());
		CSPConstraint cons4 = new CSPConstraint("C2", iagreeModel
				.getCreationConstraints().get("C2").getSlo(), iagreeModel
				.getCreationConstraints().get("C2").getQc());
		CSPConstraint cons5 = new CSPConstraint("C3", iagreeModel
				.getCreationConstraints().get("C3").getSlo(), iagreeModel
				.getCreationConstraints().get("C3").getQc());

		Map<String, CSPConstraint> consts = new HashMap<String, CSPConstraint>();
		consts.put("G1", cons1);
		consts.put("G2", cons2);
		consts.put("C1", cons3);
		consts.put("C2", cons4);
		consts.put("C3", cons5);

		// Asserts constraints
		for (int i = 0; i < model.getConstraints().size(); i++) {
			CSPConstraint cons = model.getConstraints().get(i);
			CSPConstraint other = consts.get(cons.getId());
			assertTrue(other != null);
			assertEquals(cons.getId(), other.getId());
			assertEquals(cons.getExpr(), other.getExpr());
		}
	}
	
	/**
	 * Negate a CSP Model.
	 */
	@Test
	public void testNegateModel() {
		CSPModel neg_model = model.negate();
		assertTrue(neg_model != null);
	}

}
