/**
 *
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.Feature;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.Template;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.translators.iagree.model.IAgreeAgreementTerms;
import es.us.isa.aml.translators.iagree.model.IAgreeConfigurationProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeCreationConstraint;
import es.us.isa.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translators.iagree.model.IAgreeMetric;
import es.us.isa.aml.translators.iagree.model.IAgreeMonitorableProperty;
import es.us.isa.aml.translators.iagree.model.IAgreeSLO;
import es.us.isa.aml.translators.iagree.model.IAgreeService;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;

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
        InputStream in = getClass().getResourceAsStream("/test-simple.at");
        String content = getStringFromInputStream(in);
        AgreementFile sla = new AgreementFile(content, AgreementLanguage.IAGREE);

        IAgreeParser parser = new IAgreeParser();
        AgreementModel model = parser.doParse(sla);

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

        InputStream in = getClass().getResourceAsStream("/test-simple.at");
        String content = getStringFromInputStream(in);
        AgreementFile sla = new AgreementFile(content, AgreementLanguage.IAGREE);

        IAgreeParser parser = new IAgreeParser();
        AgreementModel model = parser.doParse(sla);

        // Asserts ID y Version
        assertEquals(model.getID(), "TestTemplate");
        assertEquals(model.getVersion(), 1.0f, 0.0);

        // Asserts Responder
        assertEquals(model.getContext().getResponder(), Actor.Provider);

        // Metrics
        IAgreeMetric met1 = new IAgreeMetric("met1", "integer", new Range(0, 23));
        IAgreeMetric met2 = new IAgreeMetric("met2", "integer", new Range(0, 23));
        IAgreeMetric met3 = new IAgreeMetric("met3", "float", new Range(0, 128));

        // Asserts metrics
        assertEquals(model.getContext().getMetrics().get(0), met1);
        assertEquals(model.getContext().getMetrics().get(1), met2);
        assertEquals(model.getContext().getMetrics().get(2), met3);

        // Agreement Terms
        IAgreeAgreementTerms at = new IAgreeAgreementTerms();

        // Service reference
        IAgreeService service = new IAgreeService();
        service.setServiceName("TTS");
        service.setServiceReference("test.template.com/service");
        at.setService(service);

     // Configuration properties
        IAgreeConfigurationProperty ConfProp1 = new IAgreeConfigurationProperty("ConfProp1", met1);
        ConfProp1.setScope(Scope.Global);
        at.getService().getConfigurationProperties().add(ConfProp1);

        // Monitorable properties
        IAgreeMonitorableProperty MonitProp1 = new IAgreeMonitorableProperty("MonitProp1", met2);
        MonitProp1.setScope(Scope.Global);
        at.getMonitorableProperties().add(MonitProp1);

        IAgreeMonitorableProperty MonitProp2 = new IAgreeMonitorableProperty("MonitProp2", met3);
        MonitProp2.setScope(Scope.Local);
        MonitProp2.setFeature(new Feature("testFeature1"));
        at.getMonitorableProperties().add(MonitProp2);

        // Guarantee terms
        Expression exp = new RelationalExpression(new Var(MonitProp1), new Atomic(64), RelationalOperator.lte);
        IAgreeSLO slo = new IAgreeSLO(exp);
        IAgreeGuaranteeTerm g1 = new IAgreeGuaranteeTerm("G1", Actor.Provider, slo);

        Expression exp2 = new RelationalExpression(new Var(MonitProp2), new Atomic(256), RelationalOperator.lt);
        IAgreeSLO slo2 = new IAgreeSLO(exp2);
        IAgreeGuaranteeTerm g2 = new IAgreeGuaranteeTerm("G2", Actor.Consumer, slo2);

        at.getGuaranteeTerms().add(g1);
        at.getGuaranteeTerms().add(g2);

        // Asserts Agreement Terms
        assertEquals(model.getAgreementTerms().getService().getConfigurationProperties().get(0), at.getService().getConfigurationProperties().get(0));
        assertEquals(model.getAgreementTerms().getMonitorableProperties().get(0), at.getMonitorableProperties().get(0));
        assertEquals(model.getAgreementTerms().getGuaranteeTerms(), at.getGuaranteeTerms());

        // Creation constraints
        Expression e = new ArithmeticExpression(new Var(MonitProp1), new Atomic(2), ArithmeticOperator.multiply);
        Expression exp3 = new RelationalExpression(new Var(ConfProp1), e, RelationalOperator.eq);
        IAgreeSLO slo3 = new IAgreeSLO(exp3);

        IAgreeCreationConstraint cc = new IAgreeCreationConstraint("C1", slo3);

        // Assert Creation Constraint
        assertEquals(((Template) model).getCreationConstraints().get(0), cc);
    }

    String getStringFromInputStream(InputStream in) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line.replaceAll("	", "\t")).append("\n");
            }
        } catch (IOException e) {
            LOG.log(Level.WARNING, null, e);
        }
        return sb.toString();
    }

}
