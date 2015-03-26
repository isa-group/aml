/**
 *
 */
package es.us.isa.aml.reasoners;

import com.google.gson.Gson;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.opl.OPLBuilder;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author jdelafuente
 *
 */
public class CSPWebReasoner extends Reasoner {

	private static final Logger LOG = Logger.getLogger(CSPWebReasoner.class
			.getName());
	private AgreementModel model;

	@Override
	public void addProblem(AgreementModel model) {
		this.model = model;
	}

	@Override
	public OperationResponse solve() {

		String url = Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solver/solve";

		Translator translator = new Translator(new OPLBuilder());
		String content = translator.export(model);

		OperationResponse res = new OperationResponse();
		try {
			res = sendPost(url, content);
		} catch (Exception e) {
			LOG.log(Level.WARNING, null, e);
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
	private OperationResponse sendPost(String url, String content)
			throws Exception {

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");

		String param = "opl=" + URLEncoder.encode(content, "UTF-8");

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

		return new Gson()
				.fromJson(response.toString(), OperationResponse.class);
	}

}
