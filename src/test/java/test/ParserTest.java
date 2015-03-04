/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;

/**
 * @author jdelafuente
 *
 */
public class ParserTest {
	
	public static void main(String[] args) {
		
		InputStream in = ParserTest.class.getResourceAsStream("/test-simple.at");
        String content = getStringFromInputStream(in);		
		AgreementFile sla = new AgreementFile(content, AgreementLanguage.IAGREE);
		
		IAgreeParser parser = new IAgreeParser();
		AgreementModel model = parser.doParse(sla);
		
		System.out.println(model.toString());
	}
	

	
	static String getStringFromInputStream(InputStream in){
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
