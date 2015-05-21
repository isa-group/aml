/**
 *
 */
package test;

import java.util.logging.Logger;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
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
		
		Translator t = new Translator(new CSPBuilder());
		CSPModel model = (CSPModel) t.translate(model1);
		System.out.println(model);
		CSPModel model2 = model.negate();
		System.out.println(model2);

	}

	// @Test
	// public void testModifyGT() {
	// assertNotNull(model1.getContext());
	// assertNotNull(model1.getAgreementTerms());
	// assertNotNull(model1.getCreationConstraints());
	// for (CreationConstraint c : model1.getCreationConstraints()) {
	// assertNotNull(c);
	// CompoundExpression ce = (CompoundExpression) c.getSlo().getExpression();
	// assertNotNull(ce.getExpression1());
	// assertNotNull(ce.getExpression2());
	// assertNotNull(ce.getExpressions());
	// assertNotNull(ce.getOperator());
	//
	// }
	// }
	//
	// @Test
	// public void testRegisterFromFolder() {
	// assertTrue(serv.getStoreManager().getAgreementMap().keySet().isEmpty());
	// serv.getStoreManager().registerFromFolder("src/test/resources/samples",
	// false);
	// assertFalse(serv.getStoreManager().getAgreementMap().keySet().isEmpty());
	// }
}
