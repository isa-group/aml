/**
 *
 */
package test;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.Template;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

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

        assertEquals(content.replaceAll("\\s+", ""), model.toString().replaceAll("\\s+", ""));
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
        assertEquals(model.getID(), "AmazonS3");
        assertEquals(model.getVersion(), 1.0f, 0.0);

        // Asserts Responder
        assertEquals(model.getResponder(), Actor.Provider);

        // Metrics
        IAgreeMetric metric_time = new IAgreeMetric("time", "integer", new Range(0, 23));
        IAgreeMetric metric_size = new IAgreeMetric("size", "integer", new Range(0, 512));
        IAgreeMetric metric_percent = new IAgreeMetric("percent", "float", new Range(0, 100));

        // Asserts metrics
        assertEquals(model.getMetrics().get(0), metric_time);
        assertEquals(model.getMetrics().get(1), metric_size);
        assertEquals(model.getMetrics().get(2), metric_percent);

        // Agreement Terms
        IAgreeAgreementTerms at = new IAgreeAgreementTerms();

        // Service reference
        IAgreeService service = new IAgreeService();
        service.setServiceName("AWS-S3");
        service.setServiceReference("aws.amazon.com/s3");
        at.setService(service);

        // Configuration properties
        IAgreeConfigurationProperty storage_size = new IAgreeConfigurationProperty("StorageSize", metric_size, Scope.Global);
        at.getConfigurationProperties().add(storage_size);

        // Monitorable properties
        IAgreeMonitorableProperty response_time = new IAgreeMonitorableProperty("ResponseTime", metric_time, Scope.Global);
        at.getMonitorableProperties().add(response_time);

        IAgreeMonitorableProperty mup = new IAgreeMonitorableProperty("MUP", metric_percent, Scope.Global);
        at.getMonitorableProperties().add(mup);

        // Guarantee terms
        Expression exp = new RelationalExpression(new Var(response_time), new Atomic(100), RelationalOperator.lte);
        IAgreeSLO slo = new IAgreeSLO(exp);
        IAgreeGuaranteeTerm g1 = new IAgreeGuaranteeTerm("G1", Actor.Provider, slo);

        Expression exp2 = new RelationalExpression(new Var(mup), new Atomic(99.95), RelationalOperator.lt);
        IAgreeSLO slo2 = new IAgreeSLO(exp2);
        IAgreeGuaranteeTerm g2 = new IAgreeGuaranteeTerm("G2", Actor.Consumer, slo2);

        at.getGuaranteeTerms().add(g1);
        at.getGuaranteeTerms().add(g2);

        // Asserts Agreement Terms
        assertEquals(model.getAgreementTerms().getConfigurationProperties(), at.getConfigurationProperties());
        assertEquals(model.getAgreementTerms().getMonitorableProperties(), at.getMonitorableProperties());
        assertEquals(model.getAgreementTerms().getGuaranteeTerms(), at.getGuaranteeTerms());

        // Creation constraints
        Expression exp3 = new RelationalExpression(new Var(mup), new Atomic(99.95), RelationalOperator.lt);
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
