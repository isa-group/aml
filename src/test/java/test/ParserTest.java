/**
 * 
 */
package test;

import isa.us.es.aml.AgreementService;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.translators.Translator;
import isa.us.es.aml.translators.opl.OPLBuilder;
import isa.us.es.aml.util.AgreementLanguage;
import isa.us.es.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class ParserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AgreementService serv = new AgreementService();

		String SLA = Util.loadFile("samples/iagree/AmazonS3.at");
		serv.addTemplateFile(SLA, AgreementLanguage.IAGREE);
		AgreementModel model = serv.getTemplateModel();
		System.out.println(model.toString());
		
		System.out.println("==========================================================");
		System.out.println("\n");
		
		Translator t = new Translator(new OPLBuilder());
		System.out.println(t.export(model));
		
		
//		Expression e = model.getAgreementTerms().getGuaranteeTerms().get(0).getSlo().getExpression();
//		Expression.printTree(e, 0);
		
		
//		serv.addOffer(SLA, AgreementLanguage.IAGREE);
//		AgreementModel model = serv.getOfferModel();	
                
                System.out.println("==========================================================");
		System.out.println("\n");
                System.err.println(serv.isValidTemplate());

	}

}
