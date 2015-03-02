/**
 * 
 */
package test;

import isa.us.es.aml.AgreementService;
import isa.us.es.aml.translators.Translator;
import isa.us.es.aml.translators.opl.OPLBuilder;
import isa.us.es.aml.util.AgreementLanguage;
import isa.us.es.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class TestLibLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String SLA = Util.loadFile("samples/iagree/AmazonS3-medium.at");
		
		AgreementService serv = new AgreementService();
		serv.addTemplateFile(SLA, AgreementLanguage.IAGREE);
		
//		Translator t = new Translator(new OPLBuilder());
//		System.out.println(t.export(serv.getTemplateModel()));
		
        System.out.println("Valid template: " + serv.isValidTemplate());        
	}

}
