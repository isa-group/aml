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

import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.GeneratorType;
import es.us.isa.aml.util.ReasonerType;

/**
 * @author jdelafuente
 *
 */
public class TestConfig {
	
	@BeforeClass
	public static void init() {
		Config.load();
	}

	@Test
	public void testProperties() {
		assertEquals(Config.getInstance().getDefaultInputFormat(),
				AgreementLanguage.IAGREE);
		assertEquals(Config.getInstance().getCSPReasoner(), ReasonerType.CPLEX);
		assertEquals(Config.getInstance().getCSPWebReasonerEndpoint(),
				"http://150.214.188.130:8080/CSPWebReasoner");
		assertEquals(Config.getInstance().getDLReasoner(), "NONE");
		assertEquals(Config.getInstance().getANDConstraintsBreaking(), true);
		assertEquals(Config.getInstance().getAgreementGenerator(),
				GeneratorType.BASIC);
	}

}
