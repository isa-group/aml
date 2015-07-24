/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerType;

/**
 * @author jdelafuente
 *
 */
public class CplexReasoner extends Reasoner { // CSPReasoner

	private static final Logger LOG = Logger.getLogger(CplexReasoner.class
			.getName());

	@Override
	public Boolean solve(CSPModel model) {
		Boolean solve = false;

		if (model != null) {
			try {
				String content = model.toString();
				CplexHandler ch = new CplexHandler();
				ch.init();
				solve = new Gson().fromJson(ch.solve(content), Boolean.class);
			} catch (Exception e) {
				solve = null;
				LOG.log(Level.SEVERE, "There was an error processing the file",
						e);
			}
		} else {
			solve = null;
			LOG.log(Level.SEVERE, "There was an error processing the file");
		}
		return solve;
	}

	@Override
	public OperationResponse explain(CSPModel model) {
		OperationResponse response = null;

		if (model != null) {
			try {
				String content = model.toString();
				CplexHandler ch = new CplexHandler();
				ch.init();
				response = new Gson().fromJson(ch.explain(content),
						OperationResponse.class);
			} catch (Exception e) {
				response = null;
				LOG.log(Level.SEVERE, "There was an error processing the file",
						e);
			}
		} else {
			response = null;
			LOG.log(Level.SEVERE, "There was an error processing the file");
		}
		return response;
	}

	@Override
	public Boolean implies(CSPModel antecedent, CSPModel consequent) {
		Boolean implies = false;

		if (antecedent != null && consequent != null) {
			try {
				CSPModel model = antecedent.add(consequent.negate());
				CplexHandler ch = new CplexHandler();
				ch.init();
				String content = model.toString();
				implies = !(new Gson().fromJson(ch.solve(content),
						Boolean.class));
			} catch (Exception e) {
				implies = null;
				LOG.log(Level.SEVERE, "There was an error: ", e);
			}
		} else {
			LOG.log(Level.SEVERE, "One of the CSPModels is not valid");
		}
		return implies;
	}

	@Override
	public OperationResponse whyNotImplies(CSPModel antecedent,
			CSPModel consequent) {
		Boolean precondition = !implies(antecedent, consequent);

		CSPModel antecedentOriginal = antecedent.clone();
		OperationResponse problem = null;
		OperationResponse res = null;

		CplexHandler ch = new CplexHandler();
		ch.init();

		if (precondition) {
			CSPModel modelForProblem = antecedent.add(consequent.negate());
			String stringForProblem = modelForProblem.toString();
			problem = new Gson().fromJson(ch.explain(stringForProblem)
					.toString(), OperationResponse.class);

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

			res = new Gson().fromJson(ch.explain(stringForExplain).toString(),
					OperationResponse.class);

			res.put("compliant", false);
		} else {
			res = new OperationResponse();
			res.put("compliant", true);
			res.put("conflicts", null);
			res.put("conflictType", null);
		}

		return res;
	}

	@Override
	public ReasonerType getType() {
		return ReasonerType.CPLEX;
	}
}