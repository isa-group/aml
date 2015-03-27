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

import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
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
				.getResourceAsStream("/samples/iagree-core.at");

		// InputStream in = ParserTest.class
		// .getResourceAsStream("/samples/wsag.xml");
		String content = getStringFromInputStream(in);

		IAgreeParser parser = new IAgreeParser();
		AgreementTemplate model = null;
		try {
			model = (AgreementTemplate) parser.doParse(content);
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

		Translator t2 = new Translator(new IAgreeBuilder());
		LOG.log(Level.INFO, t2.print(model));

		Translator t3 = new Translator(new OPLBuilder());
		LOG.log(Level.INFO, t3.print(model));

		Property monitProp1 = model.getProperty("MonitProp1");

		// Type Integer
		model.setProperty("MonitProp1", 10);

		Integer mp1_value = monitProp1.intValue();
		LOG.log(Level.INFO, "MonitProp1''s value = {0}", mp1_value);

		Boolean evaluation = model.evaluateGT("G1");
		LOG.log(Level.INFO, "Evaluate G1: {0} --> {1}\n", new Object[] {
				model.getGuaranteeTerm("G1").getSlo().getExpression(),
				evaluation });

		LOG.log(Level.INFO, "Setting MonitProp1's value to 65...\n");
		model.setProperty("MonitProp1", 65);

		LOG.log(Level.INFO, "New MonitProp1''s value = {0}",
				monitProp1.intValue());
		Boolean new_evaluation = model.evaluateGT("G1");
		LOG.log(Level.INFO, "Evaluate G1: {0} --> {1}\n", new Object[] {
				model.getGuaranteeTerm("G1").getSlo().getExpression(),
				new_evaluation });

		Property monitProp2 = model.getProperty("MonitProp2");

		LOG.log(Level.INFO, "Setting MonitProp2's value to MonitProp1 * 2...\n");

		model.setProperty("MonitProp2", "MonitProp1 * 2");

		Integer mp2_value = monitProp2.intValue();
		LOG.log(Level.INFO, "MonitProp2''s value = {0}\n", mp2_value);

		LOG.log(Level.INFO, "Setting MonitProp2's value to MonitProp1 * 3...\n");

		model.setProperty("MonitProp2", new ArithmeticExpression(new Var(
				"MonitProp1"), new Atomic(3), ArithmeticOperator.multiply));

		LOG.log(Level.INFO, "New MonitProp2''s value = {0}",
				monitProp2.intValue());

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
