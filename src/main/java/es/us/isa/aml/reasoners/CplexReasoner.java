/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.reasoners;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import es.us.isa.aml.model.csp.CSPModel;
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
				content = content.replaceAll("\\+", "%2B");
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
				content = content.replaceAll("\\+", "%2B");
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
				String content = model.toString().replaceAll("\\+", "%2B");
				implies = !(new Gson().fromJson(ch.solve(content),
						Boolean.class));
			} catch (Exception e) {
				implies = null;
				LOG.log(Level.SEVERE, "There was an error: ",
						e);
			}
		} else {
			LOG.log(Level.SEVERE, "One of the CSPModels is not valid");
		}
		return implies;
	}

	@Override
	public OperationResponse whyNotImplies() {
		throw new UnsupportedOperationException("Not supported yet."); // Todo
	}

	@Override
	public ReasonerType getType() {
		return ReasonerType.CPLEX;
	}
}
