/**
 * 
 */
package test;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.parsers.agreements.IAgreeParser;
import isa.us.es.aml.util.AgreementFile;
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

		String SLA = Util.loadFile("samples/iagree/AmazonS3.at");
		
//		AgreementService serv = new AgreementService();
//		serv.addTemplateFile(SLA, AgreementLanguage.IAGREE);
		
		IAgreeParser parser = new IAgreeParser();
		AgreementModel model = parser.doParse(new AgreementFile(SLA, AgreementLanguage.IAGREE));
		System.out.println(model.toString());
		
//        System.out.println(serv.isValidTemplate());
                
	}

}
