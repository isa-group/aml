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
import es.us.isa.aml.util.OperationResponse;

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
	public OperationResponse solve() {
		
		String url = Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solve";

		Translator translator = new Translator(new OPLBuilder());
		String content = translator.export(model);
		
		OperationResponse res = new OperationResponse();
		try {
			res = sendPost(url, content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public OperationResponse explain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResponse implies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResponse whyNotImplies() {
		// TODO Auto-generated method stub
		return null;
	}

	// HTTP POST request
	private OperationResponse sendPost(String url, String content) throws Exception {

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

		return gson.fromJson(response.toString(), OperationResponse.class);
	}

}
