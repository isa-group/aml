/**
 *
 */
package es.us.isa.tests.core;

import static org.junit.Assert.*;

import java.util.logging.Logger;

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

	private static final Logger LOG = Logger.getLogger(TestConfig.class
			.getName());
	
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
