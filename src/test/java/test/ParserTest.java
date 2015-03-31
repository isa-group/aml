/**
 *
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.opl.OPLBuilder;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class ParserTest {

	private static final Logger LOG = Logger.getLogger(ParserTest.class
			.getName());

	public static void main(String[] args) {

		InputStream in = ParserTest.class
				.getResourceAsStream("/samples/compliant_template.at");
		
		InputStream in2 = ParserTest.class
				.getResourceAsStream("/samples/compliant_offer.ao");

		// InputStream in = ParserTest.class
		// .getResourceAsStream("/samples/wsag.xml");
		String content = getStringFromInputStream(in);
		
		String content2 = getStringFromInputStream(in2);

		IAgreeParser parser = new IAgreeParser();
		AgreementTemplate model = null;
		AgreementOffer model2 = null;
		try {
			model = (AgreementTemplate) parser.doParse(content);
			model2 = (AgreementOffer) parser.doParse(content2);
		} catch (Exception e) {
			LOG.severe(e.getMessage());
			return;
		}

		InputStream ins = ParserTest.class
				.getResourceAsStream("/defaultConfig.json");
		String config = Util.getStringFromInputStream(ins);
		try {
			Config.loadConfig(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Translator t3 = new Translator(new OPLBuilder());
//		LOG.log(Level.INFO, t3.print(model));
		
//		model.getCreationConstraints().clear();
//		model.getAgreementTerms().getGuaranteeTerms().clear();
//		
//		CSPModel antecedent = (CSPModel) t3.translate(model);
//		
//		CSPModel consequent = (CSPModel) t3.translate(model2);
//		
//		CSPModel finalmodel = antecedent.add(consequent.negate());
//		System.out.println(finalmodel);
		
		AreCompliant op = new AreCompliant();
		op.analyze(model, model2);
		System.out.println(op.getResult().get("compliant"));
		
		

//		Property monitProp1 = model.getProperty("MonitProp1");
//
//		// Type Integer
//		model.setProperty("MonitProp1", 10);
//
//		Integer mp1_value = monitProp1.intValue();
//		LOG.log(Level.INFO, "MonitProp1''s value = {0}", mp1_value);
//
//		Boolean evaluation = model.evaluateGT("G1");
//		LOG.log(Level.INFO, "Evaluate G1: {0} --> {1}\n", new Object[] {
//				model.getGuaranteeTerm("G1").getSlo().getExpression(),
//				evaluation });
//
//		LOG.log(Level.INFO, "Setting MonitProp1's value to 65...\n");
//		model.setProperty("MonitProp1", 65);
//
//		LOG.log(Level.INFO, "New MonitProp1''s value = {0}",
//				monitProp1.intValue());
//		Boolean new_evaluation = model.evaluateGT("G1");
//		LOG.log(Level.INFO, "Evaluate G1: {0} --> {1}\n", new Object[] {
//				model.getGuaranteeTerm("G1").getSlo().getExpression(),
//				new_evaluation });
//
//		Property monitProp2 = model.getProperty("MonitProp2");
//
//		LOG.log(Level.INFO, "Setting MonitProp2's value to MonitProp1 * 2...\n");
//
//		model.setProperty("MonitProp2", "MonitProp1 * 2");
//
//		Integer mp2_value = monitProp2.intValue();
//		LOG.log(Level.INFO, "MonitProp2''s value = {0}\n", mp2_value);
//
//		LOG.log(Level.INFO, "Setting MonitProp2's value to MonitProp1 * 3...\n");
//
//		model.setProperty("MonitProp2", new ArithmeticExpression(new Var(
//				"MonitProp1"), new Atomic(3), ArithmeticOperator.multiply));
//
//		LOG.log(Level.INFO, "New MonitProp2''s value = {0}",
//				monitProp2.intValue());

	}

	public static String getStringFromInputStream(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
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
