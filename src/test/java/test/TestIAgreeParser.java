/**
 *
 */
package test;

import static es.us.isa.aml.util.Util.getStringFromInputStream;
import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.logging.Logger;

import org.junit.Test;

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
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.Service;
import es.us.isa.aml.model.ServiceRole;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.IAgreeParser;

/**
 * @author jdelafuente
 *
 */
public class TestIAgreeParser {

    private static final Logger LOG = Logger.getLogger(TestIAgreeParser.class.getName());

    /**
     * Retrieve the model returned by parsing the provided document. Then,
     * translate the model to the original document's language (iAgree) and
     * compare it with the original document.
     * <br>
     * <br>
     * Test lifecycle:
     * <br>
     * Document 1 -> Model -> Document 2 -> Document 1 vs Document 2
     */
    @Test
    public void testParser() {
        InputStream in = getClass().getResourceAsStream("/samples/iagree-core.at");
        String content = getStringFromInputStream(in);

        IAgreeParser parser = new IAgreeParser();
        AgreementModel model = parser.doParse(content);

//        assertEquals(content.replaceAll("\\s+", ""), model.toString().replaceAll("\\s+", ""));
    }

    /**
     * Parse a document and retrieve the model. Then, compare each model element
     * with a new one, equivalent to the original element, created by hand.
     * <br>
     * <br>
     * Test lifecycle:
     * <br>
     * Document 1 -> Model 1 -> Element 1
     * <br>
     * Model 2 -> Element 2
     * <br>
     * Element 1 vs Element 2
     */
    @Test
    public void testModel() {

        InputStream in = getClass().getResourceAsStream("/samples/iagree-core.at");
        String content = getStringFromInputStream(in);

        IAgreeParser parser = new IAgreeParser();
        AgreementModel model = parser.doParse(content);

        // Asserts ID y Version
        assertEquals(model.getID(), "IAgreeCore");
        assertEquals(model.getVersion(), 1.0f, 0.0);

        // Asserts Responder
        assertEquals(model.getContext().getResponder().getRoleType(), ServiceRole.Provider);

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
        Service service = new Service();
        service.setServiceName("TTS");
        service.setServiceReference("test.template.com/service");
        at.setService(service);

        // Configuration properties
        ConfigurationProperty ConfProp1 = new ConfigurationProperty("ConfProp1", met1);
        ConfProp1.setScope(Scope.Global);
        at.getService().getConfigurationProperties().add(ConfProp1);

        // Monitorable properties
        MonitorableProperty MonitProp1 = new MonitorableProperty("MonitProp1", met2);
        MonitProp1.setScope(Scope.Global);
        at.getMonitorableProperties().add(MonitProp1);

        MonitorableProperty MonitProp2 = new MonitorableProperty("MonitProp2", met3);
        MonitProp2.setScope(Scope.Local);
        MonitProp2.setFeature(new Feature("testFeature1"));
        at.getMonitorableProperties().add(MonitProp2);

        // Guarantee terms
        Expression exp = new RelationalExpression(new Var(MonitProp1), new Atomic(64), RelationalOperator.lte);
        SLO slo = new SLO(exp);
        GuaranteeTerm g1 = new GuaranteeTerm("G1", ServiceRole.Provider, slo);

        Expression exp2 = new RelationalExpression(new Var(MonitProp2), new Atomic(256), RelationalOperator.lt);
        SLO slo2 = new SLO(exp2);
        GuaranteeTerm g2 = new GuaranteeTerm("G2", ServiceRole.Consumer, slo2);

        at.getGuaranteeTerms().add(g1);
        at.getGuaranteeTerms().add(g2);

        // Asserts Agreement Terms
        assertEquals(model.getAgreementTerms().getService().getConfigurationProperties().get(0), at.getService().getConfigurationProperties().get(0));
        assertEquals(model.getAgreementTerms().getMonitorableProperties().get(0), at.getMonitorableProperties().get(0));
        assertEquals(model.getAgreementTerms().getGuaranteeTerms(), at.getGuaranteeTerms());

        // Creation constraints
        Expression e = new ArithmeticExpression(new Var(MonitProp1), new Atomic(2), ArithmeticOperator.multiply);
        Expression exp3 = new RelationalExpression(new Var(ConfProp1), e, RelationalOperator.eq);
        SLO slo3 = new SLO(exp3);

        CreationConstraint cc = new CreationConstraint("C1", slo3);

        // Assert Creation Constraint
        assertEquals(((AgreementTemplate) model).getCreationConstraints().get(0), cc);
    }

}
