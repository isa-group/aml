/**
 *
 */
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
