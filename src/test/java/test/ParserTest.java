/**
 * 
 */
package test;

import isa.us.es.aml.Service;
import isa.us.es.aml.model.AgreementModel;
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

		Service serv = new Service();

		String SLA = Util.loadFile("samples/iagree/AmazonS3.at");
		serv.addTemplate(SLA, AgreementLanguage.IAGREE);
		
		AgreementModel model = serv.getTemplateModel();

		System.out.println(model.toString());

	}

}
