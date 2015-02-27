/**
 * 
 */
package test;

import isa.us.es.aml.AgreementService;
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
		
		AgreementService serv = new AgreementService();
		serv.addTemplateFile(SLA, AgreementLanguage.IAGREE);		
        System.out.println(serv.isValidTemplate());
                
	}

}
