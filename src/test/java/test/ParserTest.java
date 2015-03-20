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

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.translators.csp.opl.OPLBuilder;
import es.us.isa.aml.translators.iagree.IAgreeBuilder;

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
		AgreementModel model = parser.doParse(content);

		// if (parser.getErrorListener().hasErrors()) {
		// LOG.severe(parser.getErrorListener().getErrors().toString());
		// } else {
		// System.out.println(model.toString()); /* LOG.info(model.toString());
		// */
		// }

		// Translator t = new Translator(new WSAGBuilder());
		// System.out.println(t.export(model));

		// Translator t = new Translator(new WSAGBuilder());
		// String newcontent = t.export(model);
		// System.out.println(newcontent);
		//
		// WsagParser parser2 = new WsagParser();
		// AgreementModel model2 = parser2.doParse(newcontent);

		Translator t2 = new Translator(new IAgreeBuilder());
		System.out.println(t2.export(model));	
		
		Translator t3 = new Translator(new OPLBuilder());
		System.out.println(t3.export(model));
		
		
		Property monitProp1 = model.getProperty("MonitProp1");

		// Type Integer
		model.setProperty("MonitProp1", 10);

		Integer mp1_value = monitProp1.intValue();
		System.out.println("MonitProp1's value = " + mp1_value);

		Boolean evaluation = model.evaluateGT("G1");
		System.out.println("Evaluate G1: "
				+ model.getGuaranteeTerm("G1").getSlo().getExpression()
				+ " --> " + evaluation + "\n");

		System.out.println("Setting MonitProp1's value to 65...\n");
		model.setProperty("MonitProp1", 65);

		System.out.println("New MonitProp1's value = " + monitProp1.intValue());
		Boolean new_evaluation = model.evaluateGT("G1");
		System.out.println("Evaluate G1: "
				+ model.getGuaranteeTerm("G1").getSlo().getExpression()
				+ " --> " + new_evaluation + "\n");

		Property monitProp2 = model.getProperty("MonitProp2");

		System.out.println("Setting MonitProp2's value to MonitProp1 * 2...\n");

		model.setProperty("MonitProp2", "MonitProp1 * 2");

		Integer mp2_value = monitProp2.intValue();
		System.out.println("MonitProp2's value = " + mp2_value + "\n");

		System.out.println("Setting MonitProp2's value to MonitProp1 * 3...\n");

		model.setProperty("MonitProp2", new ArithmeticExpression(new Var(
				"MonitProp1"), new Atomic(3), ArithmeticOperator.multiply));

		System.out.println("New MonitProp2's value = " + monitProp2.intValue());

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
