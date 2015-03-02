/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import isa.us.es.aml.model.Actor;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.model.Range;
import isa.us.es.aml.model.Scope;
import isa.us.es.aml.model.expression.Atomic;
import isa.us.es.aml.model.expression.Expression;
import isa.us.es.aml.model.expression.RelationalExpression;
import isa.us.es.aml.model.expression.RelationalOperator;
import isa.us.es.aml.model.expression.Var;
import isa.us.es.aml.parsers.agreements.IAgreeParser;
import isa.us.es.aml.translators.iagree.model.IAgreeAgreementTerms;
import isa.us.es.aml.translators.iagree.model.IAgreeConfigurationProperty;
import isa.us.es.aml.translators.iagree.model.IAgreeCreationConstraint;
import isa.us.es.aml.translators.iagree.model.IAgreeGuaranteeTerm;
import isa.us.es.aml.translators.iagree.model.IAgreeMetric;
import isa.us.es.aml.translators.iagree.model.IAgreeMonitorableProperty;
import isa.us.es.aml.translators.iagree.model.IAgreeSLO;
import isa.us.es.aml.translators.iagree.model.IAgreeService;
import isa.us.es.aml.translators.iagree.model.IAgreeTemplate;
import isa.us.es.aml.util.AgreementFile;
import isa.us.es.aml.util.AgreementLanguage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * @author jdelafuente
 *
 */
public class TestIAgreeParser {
	
	@Test
	public void testParser() {
		InputStream in = getClass().getResourceAsStream("/test-simple.at");
        String content = getStringFromInputStream(in);		
		AgreementFile sla = new AgreementFile(content, AgreementLanguage.IAGREE);
		
		IAgreeParser parser = new IAgreeParser();
		AgreementModel model = parser.doParse(sla);
		
		assertEquals(content.replaceAll("\\s+", ""), model.toString().replaceAll("\\s+", ""));
	}
	
	@Test
	public void testModel() {

		InputStream in = getClass().getResourceAsStream("/test-simple.at");
        String content = getStringFromInputStream(in);		
		AgreementFile sla = new AgreementFile(content, AgreementLanguage.IAGREE);
		
		IAgreeParser parser = new IAgreeParser();
		AgreementModel model = parser.doParse(sla);
		
		// ID y Version
		assertEquals(model.getID(), "AmazonS3");
		assertEquals(model.getVersion(), 1.0f, 0.0);
		
		// Responder
		assertEquals(model.getResponder(), Actor.Provider);
		
		
		// Metrics
		IAgreeMetric metric_time = new IAgreeMetric("time", "integer", new Range(0, 23));
		assertEquals(model.getMetrics().get(0), metric_time);
		
		IAgreeMetric metric_size = new IAgreeMetric("size", "integer", new Range(0, 512));
		assertEquals(model.getMetrics().get(1), metric_size);
		
		IAgreeMetric metric_percent = new IAgreeMetric("percent", "float", new Range(0, 100));
		assertEquals(model.getMetrics().get(2), metric_percent);
		
		// Agreement Terms
		
		IAgreeAgreementTerms at = new IAgreeAgreementTerms();
		
		IAgreeService service = new IAgreeService();
		service.setServiceName("AWS-S3");
		service.setServiceReference("aws.amazon.com/s3");
		at.setService(service);
		
		IAgreeConfigurationProperty storage_size = new IAgreeConfigurationProperty("StorageSize", metric_size, Scope.Global);
		at.getConfigurationProperties().add(storage_size);
		
		assertEquals(model.getAgreementTerms().getConfigurationProperties(), at.getConfigurationProperties());
		
				
		IAgreeMonitorableProperty response_time = new IAgreeMonitorableProperty("ResponseTime", metric_time, Scope.Global);
		at.getMonitorableProperties().add(response_time);
		
		IAgreeMonitorableProperty mup = new IAgreeMonitorableProperty("MUP", metric_percent, Scope.Global);
		at.getMonitorableProperties().add(mup);
		
		assertEquals(model.getAgreementTerms().getMonitorableProperties(), at.getMonitorableProperties());
		
		
		Expression exp = new RelationalExpression(new Var(response_time), new Atomic(100), RelationalOperator.lte);
		IAgreeSLO slo = new IAgreeSLO(exp);
		IAgreeGuaranteeTerm g1 = new IAgreeGuaranteeTerm("G1", Actor.Provider, slo);
		
		Expression exp2 = new RelationalExpression(new Var(mup), new Atomic(99.95), RelationalOperator.lt);
		IAgreeSLO slo2 = new IAgreeSLO(exp2);
		IAgreeGuaranteeTerm g2 = new IAgreeGuaranteeTerm("G2", Actor.Consumer, slo2);
		
		at.getGuaranteeTerms().add(g1);
		at.getGuaranteeTerms().add(g2);		
		
		assertEquals(model.getAgreementTerms().getGuaranteeTerms(), at.getGuaranteeTerms());
		
		
		// Creation constraints
		
		Expression exp3 = new RelationalExpression(new Var(mup), new Atomic(99.95), RelationalOperator.lt);
		IAgreeSLO slo3 = new IAgreeSLO(exp3);
		
		IAgreeCreationConstraint cc = new IAgreeCreationConstraint("C1", slo3);
		((IAgreeTemplate) model).getCreationConstraints().add(cc);
		
		assertEquals(((IAgreeTemplate) model).getCreationConstraints().get(0), cc);
	}
	
	String getStringFromInputStream(InputStream in){
		BufferedReader reader = new BufferedReader(
                new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
			while ((line = reader.readLine()) != null) {
			    sb.append(line.replaceAll("	", "\t")).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return sb.toString();
	}
	

}
