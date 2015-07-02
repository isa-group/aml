/**
 *
 */
package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.expression.CompoundExpression;
import es.us.isa.aml.util.Util;

/**
 * @author AntonioGamez
 *
 */
public class OtherTests {

	private static final Logger LOG = Logger.getLogger(TestLibLocal.class
			.getName());
	private static AgreementManager serv;
	private static AgreementTemplate model1;

	public static void main(String[] args) {
		serv = new AgreementManager(
				Util.loadFile("src/main/resources/defaultConfig.json"));

		model1 = serv
				.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");
	}

	@Test
	public void testModifyGT() {
		assertNotNull(model1.getContext());
		assertNotNull(model1.getAgreementTerms());
		assertNotNull(model1.getCreationConstraints());
		for (CreationConstraint c : model1.getCreationConstraints()) {
			assertNotNull(c);
			CompoundExpression ce = (CompoundExpression) c.getSlo()
					.getExpression();
			assertNotNull(ce.getExpression1());
			assertNotNull(ce.getExpression2());
			assertNotNull(ce.getExpressions());
			assertNotNull(ce.getOperator());

		}
	}

	@Test
	public void testRegisterFromFolder() {
		assertTrue(serv.getStoreManager().getAgreementMap().keySet().isEmpty());
		serv.getStoreManager().registerFromFolder("src/test/resources/samples",
				false);
		assertFalse(serv.getStoreManager().getAgreementMap().keySet().isEmpty());
	}
}
