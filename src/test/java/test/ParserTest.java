/**
 *
 */
package test;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.util.AgreementFile;
import es.us.isa.aml.util.AgreementLanguage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jdelafuente
 *
 */
public class ParserTest {

    private static final Logger LOG = Logger.getLogger(ParserTest.class.getName());

    public static void main(String[] args) {

        InputStream in = ParserTest.class.getResourceAsStream("/test-simple.at");
        String content = getStringFromInputStream(in);
        AgreementFile sla = new AgreementFile(content, AgreementLanguage.IAGREE);

        IAgreeParser parser = new IAgreeParser();
        AgreementModel model = parser.doParse(sla);

        LOG.log(Level.INFO, model.toString());
    }

    public static String getStringFromInputStream(InputStream in) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(in));
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
