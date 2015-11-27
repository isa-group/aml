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

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.ResourceProperty;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class TestTrelloModel {

	private static AgreementManager service;
	private static AgreementModel model;

	@BeforeClass
	public static void init() {
		service = new AgreementManager();
		model = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/trello.at");
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
		// Asserts ID y Version
		assertEquals(model.getID(), "ResearchPlanT");
		assertEquals(model.getVersion(), 1.0f, 0.0);

		// Asserts actors
		assertEquals(model.getContext().getResponder().getRole(), Role.Provider);
		assertEquals(model.getContext().getInitiator().getRole(), Role.Consumer);

		// Metrics
		Metric met1 = new Metric("num", "integer", new Range(0, 100));
		Metric met2 = new Metric("boolean", "Boolean", new Enumerated(
				new Object[] { true, false }));

		// Asserts metrics
		assertEquals(model.getContext().getMetrics().get(met1.getId()), met1);

		// Agreement Terms
		AgreementTerms at = new AgreementTerms();

		// Service reference
		ServiceConfiguration service = new ServiceConfiguration();
		service.setServiceName("Research");
		service.setEndpointReference("www.isa.us.es/people/pablo.fernandez");
		at.setService(service);

		// Configuration properties
		ConfigurationProperty ConfProp1 = new ConfigurationProperty(
				"Seniority", met1);
		ConfProp1.setScope(Scope.Global);
		ConfProp1.setExpression(new Atomic(12));
		at.getService().getConfigurationProperties()
				.put(ConfProp1.getId(), ConfProp1);

		ConfigurationProperty ConfProp2 = new ConfigurationProperty("phd", met2);
		ConfProp2.setScope(Scope.Global);
		ConfProp2.setExpression(new Atomic(true));
		at.getService().getConfigurationProperties()
				.put(ConfProp2.getId(), ConfProp2);

		// Monitorable properties
		
		ResourceProperty MonitProp1 = new ResourceProperty("papers");
		MonitProp1.setScope(Scope.Global);
		at.getMonitorableProperties().put(MonitProp1.getId(), MonitProp1);

		ResourceProperty MonitProp2 = new ResourceProperty("conferences");
		MonitProp2.setScope(Scope.Global);
		at.getMonitorableProperties().put(MonitProp2.getId(), MonitProp2);

		// Guarantee terms
		
		Expression exp = Expression.parse("papers in acceptance > 3 monthly");
		SLO slo = new SLO(exp);
		GuaranteeTerm gt = new GuaranteeTerm("G1", Role.Provider, slo);
		at.getGuaranteeTerms().put(gt.getId(), gt);
		
		exp = Expression.parse("papers in revision by 10 second");
		slo = new SLO(exp);
		gt = new GuaranteeTerm("G2", Role.Provider, slo);
		at.getGuaranteeTerms().put(gt.getId(), gt);
		
		exp = Expression.parse("conferences in acceptance > 1 minutely");
		slo = new SLO(exp);
		gt = new GuaranteeTerm("G3", Role.Provider, slo);
		at.getGuaranteeTerms().put(gt.getId(), gt);
		
		exp = Expression.parse("conferences in revision by 1 minute");
		slo = new SLO(exp);
		gt = new GuaranteeTerm("G4", Role.Provider, slo);
		at.getGuaranteeTerms().put(gt.getId(), gt);

		// Asserts Agreement Terms
		assertEquals(model.getAgreementTerms().getService()
				.getConfigurationProperties().get(0), at.getService()
				.getConfigurationProperties().get(0));
		assertEquals(model.getAgreementTerms().getMonitorableProperties()
				.get(0), at.getMonitorableProperties().get(0));
		assertEquals(model.getAgreementTerms().getGuaranteeTerms(),
				at.getGuaranteeTerms());
	}

}
