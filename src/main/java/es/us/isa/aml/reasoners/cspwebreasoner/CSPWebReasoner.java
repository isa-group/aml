/**
 * *****************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */
package es.us.isa.aml.reasoners.cspwebreasoner;

import java.util.ArrayList;
import java.util.Iterator;

import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.reasoners.Reasoner;
import es.us.isa.aml.util.Config;
import java.util.concurrent.TimeoutException;

/**
 * @author jdelafuente
 *
 */
public class CSPWebReasoner extends Reasoner {

    public final String PROBLEMS_ENDPOINT = "/problems";

    public CSPWebReasoner() {

    }

    @Override
    public Solution solve(CSPModel model) throws TimeoutException {
        return solve(model, Config.getInstance().getTimeout());
    }

    @Override
    public Solution solve(CSPModel model, long timeout) throws TimeoutException {
        String url = Config.getInstance().getCSPWebReasonerEndpoint() + PROBLEMS_ENDPOINT;
        Problem problem = new Problem();
        problem.setType("solve");
        problem.setDefinition(model.toString());
        problem = CSPWebReasonerUtils.pollService(url, problem, timeout);
        return problem.getSolution();
    }

    @Override
    public Solution explain(CSPModel model) throws TimeoutException {
        return explain(model, Config.getInstance().getTimeout());
    }

    @Override
    public Solution explain(CSPModel model, long timeout) throws TimeoutException {
        String url = Config.getInstance().getCSPWebReasonerEndpoint() + PROBLEMS_ENDPOINT;
        Problem problem = new Problem();
        problem.setType("explain");
        problem.setDefinition(model.toString());
        problem = CSPWebReasonerUtils.pollService(url, problem, timeout);
        return problem.getSolution();
    }

    @Override
    public Solution implies(CSPModel antecedent, CSPModel consequent) throws TimeoutException {
        return implies(antecedent, consequent, Config.getInstance().getTimeout());
    }

    @Override
    public Solution implies(CSPModel antecedent, CSPModel consequent, long timeout) throws TimeoutException {
        String url = Config.getInstance().getCSPWebReasonerEndpoint() + PROBLEMS_ENDPOINT;
        CSPModel model = antecedent.add(consequent.negate());
        String content = model.toString();
        Problem problem = new Problem();
        problem.setType("solve");
        problem.setDefinition(content);
        problem = CSPWebReasonerUtils.pollService(url, problem, timeout);
        Solution sol = problem.getSolution();
        sol.setFeasibility(!sol.getFeasibility());
        return sol;
    }

    @Override
    public Solution whyNotImplies(CSPModel antecedent,
            CSPModel consequent) throws TimeoutException {
        return whyNotImplies(antecedent, consequent, Config.getInstance().getTimeout());
    }

    @Override
    public Solution whyNotImplies(CSPModel antecedent,
            CSPModel consequent, long timeout) throws TimeoutException {

        Solution sol = implies(antecedent, consequent);
        Boolean precondition = !sol.getFeasibility();

        CSPModel antecedentOriginal = antecedent.clone();
        String url = Config.getInstance().getCSPWebReasonerEndpoint() + PROBLEMS_ENDPOINT;

        if (precondition) {
            // creamos el modelo para obtener el "problem" V, D, Antec y no
            // Conseq
            CSPModel modelForProblem = antecedent.add(consequent.negate());
            String stringForProblem = modelForProblem.toString();

            Problem problem = new Problem();
            problem.setType("explain");
            problem.setDefinition(stringForProblem);
            problem = CSPWebReasonerUtils.pollService(url, problem, timeout);
            String result = problem.getSolution().getExplaining();

            Expression problemExpr = null;

            if (result.length() > 0) {
                result = result.substring(result.indexOf("\n"));
                ArrayList<RelationalExpression> assignments = new ArrayList<>();

                while (result != null) {
                    if (!result.isEmpty()) {
                        String v = result.substring(0, result.indexOf("=") - 1);
                        Var var = new Var(v.trim());
                        String a = result.substring(result.indexOf("=") + 1, result.indexOf(";"));
                        Atomic at = new Atomic(a.trim());
                        RelationalExpression assg = new RelationalExpression(var, at, RelationalOperator.EQ);
                        assignments.add(assg);

                        if ((result.indexOf(";") + 1) < result.length()) {
                            result = result.substring(result.indexOf(";") + 1);
                            result = result.trim();
                        } else {
                            result = null;
                        }
                    } else {
                        result = null;
                    }
                }

                Iterator<RelationalExpression> it = assignments.iterator();
                while (it.hasNext()) {
                    RelationalExpression exp = (RelationalExpression) it.next();
                    if (problemExpr == null) {
                        problemExpr = exp;
                    } else {
                        problemExpr = new LogicalExpression(problemExpr, exp, LogicalOperator.AND);
                    }
                }
            }

            CSPConstraint problemConst = new CSPConstraint("Problem", problemExpr);
            CSPModel background = antecedentOriginal.clone();
            background.addConstraintOnTop(problemConst);
            CSPModel modelForExplain = background.add(consequent);
            String stringForExplain = modelForExplain.toString();
            problem = new Problem();
            problem.setType("explain");
            problem.setDefinition(stringForExplain);
            problem = CSPWebReasonerUtils.pollService(url, problem, timeout);
            sol = problem.getSolution();
        }

        return sol;
    }
}
