/**
 *
 */
package es.us.isa.aml.reasoners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class CSPWebReasoner extends Reasoner {

	private static final Logger LOGGER = Logger.getLogger(CSPWebReasoner.class
			.getName());

	@Override
	public Boolean solve(CSPModel model) {
		return solve(model.toString());
	}

	public Boolean solve(String cspModel) {
		String url = Config.getInstance().getCSPWebReasonerEndpoint();
		url += "/solver/solve";
		
		Boolean res = null;
		try {
			String response = Util.sendPost(url, cspModel);
			res = new Gson().fromJson(response.toString(), Boolean.class);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

		return res;
	}

	@Override
	public OperationResponse explain(CSPModel model) {
		return explain(model.toString());
	}

	public OperationResponse explain(String cspModel) {
		String url = Config.getInstance().getCSPWebReasonerEndpoint();
		url += "/solver/explain";
		
		OperationResponse res = null;
		try {
			String response = Util.sendPost(url, cspModel);
			res = new Gson().fromJson(response.toString(),
					OperationResponse.class);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return res;
	}

	@Override
	public Boolean implies(CSPModel antecedent, CSPModel consequent) {
		String url = Config.getInstance().getCSPWebReasonerEndpoint();
		url += "/solver/implies";

		CSPModel model = antecedent.add(consequent.negate());
		String content = model.toString();
		Boolean res = false;
		try {
			String response = Util.sendPost(url, content);
			res = (new Gson().fromJson(response.toString(), Boolean.class));

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return res;
	}

	@Override
	public OperationResponse whyNotImplies(CSPModel antecedent,
			CSPModel consequent) {

		Boolean precondition = !implies(antecedent, consequent);

		CSPModel antecedentOriginal = antecedent.clone();
		OperationResponse problem = null;
		OperationResponse res = null;

		String explainUrl = Config.getInstance().getCSPWebReasonerEndpoint();
		explainUrl += "/solver/explain";

		if (precondition) {
			// creamos el modelo para obtener el "problem" V, D, Antec y no
			// Conseq
			CSPModel modelForProblem = antecedent.add(consequent.negate());
			String stringForProblem = modelForProblem.toString();

			try {
				String response = Util.sendPost(explainUrl, stringForProblem);
				problem = new Gson().fromJson(response.toString(),
						OperationResponse.class);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.getMessage());
			}

			Map<String, Object> test = problem.getResult();
			String result = (String) test.get("result");

			Expression problemExpr = null;

			if (result.length() > 0) {
				result = result.substring(result.indexOf("\n"));
				ArrayList<RelationalExpression> assignments = new ArrayList<RelationalExpression>();

				while (result != null) {
					String v = result.substring(0, result.indexOf("=") - 1);
					Var var = new Var(v.trim());
					String a = result.substring(result.indexOf("=") + 1,
							result.indexOf(";"));
					Atomic at = new Atomic(a.trim());
					RelationalExpression assg = new RelationalExpression(var,
							at, RelationalOperator.EQ);
					assignments.add(assg);
					if ((result.indexOf(";") + 1) < result.length()) {
						result = result.substring(result.indexOf(";") + 1);
						result.trim();
					} else
						result = null;
					if (result.indexOf(";") < 0)
						result = null;
				}

				Iterator<RelationalExpression> it = assignments.iterator();
				while (it.hasNext()) {
					RelationalExpression exp = (RelationalExpression) it.next();
					if (problemExpr == null) {
						problemExpr = exp;
					} else {
						problemExpr = new LogicalExpression(problemExpr, exp,
								LogicalOperator.AND);
					}
				}
			}

			CSPConstraint problemConst = new CSPConstraint("Problem",
					problemExpr);
			CSPModel background = antecedentOriginal.clone();
			background.addConstraintOnTop(problemConst);
			CSPModel modelForExplain = background.add(consequent);
			String stringForExplain = modelForExplain.toString();
			try {
				String response2 = Util.sendPost(explainUrl, stringForExplain);
				res = new Gson().fromJson(response2.toString(),
						OperationResponse.class);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.getMessage());
			}

			res.put("compliant", false);
		} else {
			res = new OperationResponse();
			res.put("compliant", true);
			res.put("conflicts", null);
			res.put("conflictType", null);
		}

		return res;
	}
}
