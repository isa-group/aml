/**
 *
 */
package es.us.isa.tests.core;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Feature;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;

/**
 * @author jdelafuente
 *
 */
public class TestIAgreeModel {

	private static final Logger LOG = Logger.getLogger(TestIAgreeModel.class
			.getName());
	private static AgreementManager service;
	private static AgreementModel model;

	@BeforeClass
	public static void init() {
		service = new AgreementManager();
		model = service
				.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");
	}

	/**
	 * Parse a document and retrieve the model. Then, compare each model element
	 * with a new one of the same type from a given model. <br>
	 * <br>
	 * Lifecycle: <br>
	 * Document 1 -> Model 1 -> Element 1 <br>
	 * Model 2 -> Element 2 <br>
	 * Element 1 vs Element 2
	 */
	@Test
	public void testModel() {
		// Asserts ID y Version
		assertEquals(model.getID(), "IAgreeCore");
		assertEquals(model.getVersion(), 1.0f, 0.0);

		// Asserts actors
		assertEquals(model.getContext().getResponder().getRole(),
				Role.Provider);
		assertEquals(model.getContext().getInitiator().getRole(),
				Role.Consumer);

		// Metrics
		Metric met1 = new Metric("met1", "integer", new Range(0, 23));
		Metric met2 = new Metric("met2", "integer", new Range(0, 512));
		Metric met3 = new Metric("met3", "float", new Range(0, 128));

		// Asserts metrics
		assertEquals(model.getContext().getMetrics().get(met1.getId()), met1);
		assertEquals(model.getContext().getMetrics().get(met2.getId()), met2);
		assertEquals(model.getContext().getMetrics().get(met3.getId()), met3);

		// Agreement Terms
		AgreementTerms at = new AgreementTerms();

		// Service reference
		ServiceConfiguration service = new ServiceConfiguration();
		service.setServiceName("TTS");
		service.setEndpointReference("test.template.com/service");
		at.setService(service);

		// Configuration properties
		ConfigurationProperty ConfProp1 = new ConfigurationProperty(
				"ConfProp1", met1);
		ConfProp1.setScope(Scope.Global);
		at.getService().getConfigurationProperties().put(ConfProp1.getId(), ConfProp1);

		// Monitorable properties
		MonitorableProperty MonitProp1 = new MonitorableProperty("MonitProp1",
				met2);
		MonitProp1.setScope(Scope.Global);
		at.getMonitorableProperties().put(MonitProp1.getId(), MonitProp1);

		MonitorableProperty MonitProp2 = new MonitorableProperty("MonitProp2",
				met3);
		MonitProp2.setScope(Scope.Local);
		MonitProp2.setFeature(new Feature("testFeature1"));
		at.getMonitorableProperties().put(MonitProp2.getId(), MonitProp2);

		// Guarantee terms
		Expression exp = new RelationalExpression(new Var(MonitProp1),
				new Atomic(64), RelationalOperator.LTE);
		SLO slo = new SLO(exp);
		GuaranteeTerm g1 = new GuaranteeTerm("G1", Role.Provider, slo);

		Expression exp2 = new RelationalExpression(new Var(MonitProp2),
				new Atomic(256), RelationalOperator.LT);
		SLO slo2 = new SLO(exp2);
		GuaranteeTerm g2 = new GuaranteeTerm("G2", Role.Consumer, slo2);

		at.getGuaranteeTerms().put(g1.getId(), g1);
		at.getGuaranteeTerms().put(g2.getId(), g2);

		// Asserts Agreement Terms
		assertEquals(model.getAgreementTerms().getService()
				.getConfigurationProperties().get(0), at.getService()
				.getConfigurationProperties().get(0));
		assertEquals(model.getAgreementTerms().getMonitorableProperties()
				.get(0), at.getMonitorableProperties().get(0));
		assertEquals(model.getAgreementTerms().getGuaranteeTerms(),
				at.getGuaranteeTerms());

		// Creation constraints
		Expression e = new ArithmeticExpression(new Var(MonitProp1),
				new Atomic(2), ArithmeticOperator.MULTIPLY);
		Expression exp3 = new RelationalExpression(new Var(ConfProp1), e,
				RelationalOperator.EQ);
		SLO slo3 = new SLO(exp3);

		CreationConstraint cc = new CreationConstraint("C1", slo3);

		// Assert Creation Constraint
		assertEquals(
				((AgreementTemplate) model).getCreationConstraints().get(
						cc.getId()), cc);
	}

}
