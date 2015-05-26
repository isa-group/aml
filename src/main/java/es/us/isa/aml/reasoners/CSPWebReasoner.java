/**
 *
 */
package es.us.isa.aml.reasoners;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class CSPWebReasoner extends Reasoner {

	private static final Logger LOG = Logger.getLogger(CSPWebReasoner.class
			.getName());

	@Override
	public Boolean solve(CSPModel model) {
		return solve(model.toString());
	}

	public Boolean solve(String cspModel) {
		String url = (String) Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solver/solve";

		System.out.println("AML webreasonerendpint: " + url);
		
		Boolean res = null;

		try {
			String response = Util.sendPost(url, cspModel);
			res = new Gson().fromJson(response.toString(), Boolean.class);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}

		return res;
	}

	@Override
	public OperationResponse explain(CSPModel model) {
		return explain(model.toString());
	}

	public OperationResponse explain(String cspModel) {
		String url = (String) Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solver/explain";

		OperationResponse res = null;

		try {
			String response = Util.sendPost(url, cspModel);
			res = new Gson().fromJson(response.toString(),
					OperationResponse.class);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return res;
	}

	@Override
	public Boolean implies(CSPModel antecedent, CSPModel consequent) {
		String url = (String) Config.getProperty("CSPWebReasonerEndpoint");
		url += "/solver/implies";

		CSPModel model = antecedent.add(consequent.negate());
		String content = model.toString();
		Boolean res = false;

		try {
			String response = Util.sendPost(url, content);
			res = new Gson().fromJson(response.toString(), Boolean.class);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return res;
	}

	@Override
	public OperationResponse whyNotImplies() {
		// TODO Auto-generated method stub
		return null;
	}
}
