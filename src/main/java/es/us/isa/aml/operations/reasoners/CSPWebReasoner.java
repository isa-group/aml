/**
 * 
 */
package es.us.isa.aml.operations.reasoners;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.translators.csp.opl.OPLBuilder;
import es.us.isa.aml.util.Config;

/**
 * @author jdelafuente
 *
 */
public class CSPWebReasoner extends Reasoner {

	private AgreementModel model;

	@Override
	public void addProblem(AgreementModel model) {
		this.model = model;
	}

	@Override
	public Object solve() {
		
		String url = Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solve";

		Translator translator = new Translator(new OPLBuilder());
		String content = translator.export(model);
		
		CSPResponse res = null;
		try {
			res = sendPost(url, content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public Object explain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object implies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object whyNotImplies() {
		// TODO Auto-generated method stub
		return null;
	}

	// HTTP POST request
	private CSPResponse sendPost(String url, String content) throws Exception {

		Gson gson = new Gson();

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		
		String param = "opl=" + URLEncoder.encode(content, "UTF-8");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(param);
		wr.flush();
		wr.close();

//		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

		return gson.fromJson(response.toString(), CSPResponse.class);
	}

}