/**
 *
 */
package es.us.isa.aml.reasoners;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 *
 */
public class CSPWebReasoner extends Reasoner {

	private static final Logger LOG = Logger.getLogger(CSPWebReasoner.class
			.getName());

	@Override
	public Boolean solve(CSPModel model) {

		String url = Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solver/solve";

		String content = model.toString();
		Boolean res = null;
		
		try {
			String response = sendPost(url, content);
			res = new Gson().fromJson(response.toString(), Boolean.class);
		} catch (Exception e) {
			LOG.log(Level.WARNING, null, e);
		}

		return res;
	}

	@Override
	public OperationResponse explain(CSPModel model) {
		String url = Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solver/explain";

		String content = model.toString();
		OperationResponse res = null;
		
		try {
			String response = sendPost(url, content);
			res = new Gson().fromJson(response.toString(), OperationResponse.class);
		} catch (Exception e) {
			LOG.log(Level.WARNING, null, e);
		}
		return res;
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
	private String sendPost(String url, String content)
			throws Exception {

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");

		String param = "content=" + URLEncoder.encode(content, "UTF-8");

		// Send post request
		con.setDoOutput(true);
		try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
			wr.writeBytes(param);
			wr.flush();
		}

		StringBuilder response;
		try (// int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()))) {
			String inputLine;
			response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		}

		return response.toString();
	}

}