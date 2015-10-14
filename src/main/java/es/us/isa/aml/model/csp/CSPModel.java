/*******************************************************************************
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
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.model.csp;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;

/**
 * This class represents a Constraint Satisfaction Problem model.
 * @author jdelafuente
 *
 */
public class CSPModel extends AbstractModel {

	protected List<CSPRange> ranges;
	protected List<CSPVar> variables;
	protected CSPObjectiveFunction objectiveFunction;
	protected List<CSPConstraint> constraints;
	protected Boolean useCP;

	public CSPModel() {		
		ranges = new ArrayList<>();
		variables = new ArrayList<>();
		constraints = new ArrayList<>();
		useCP = true;
	}

	public void addRange(CSPRange range) {
		if (!ranges.contains(range)) {
			ranges.add(range);
		}
	}

	public void addVar(CSPVar var) {
		variables.add(var);
	}

	public void addConstraint(CSPConstraint constraint) {
		constraints.add(constraint);
	}

	public void addConstraintOnTop(CSPConstraint constraint) {
		constraints.add(0, constraint);
	}

	public List<CSPRange> getRanges() {
		return ranges;
	}

	public void setRanges(List<CSPRange> ranges) {
		this.ranges = ranges;
	}

	public List<CSPVar> getVariables() {
		return variables;
	}

	public void setVariables(List<CSPVar> variables) {
		this.variables = variables;
	}

	public CSPObjectiveFunction getObjectiveFunction() {
		return objectiveFunction;
	}

	public void setObjectiveFunction(CSPObjectiveFunction objectiveFunction) {
		this.objectiveFunction = objectiveFunction;
	}

	public List<CSPConstraint> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<CSPConstraint> constraints) {
		this.constraints = constraints;
	}

	public Boolean getUseCP() {
		return useCP;
	}

	public void setUseCP(Boolean useCP) {
		this.useCP = useCP;
	}

	public CSPModel add(CSPModel model) {
		CSPModel newModel = this.clone();

		for (CSPRange range : model.getRanges()) {
			if (!newModel.getRanges().contains(range))
				newModel.addRange(range.clone());
		}

		for (CSPVar var : model.getVariables()) {
			if (!newModel.getVariables().contains(var))
				newModel.addVar(var.clone());
		}

		if (model.getObjectiveFunction() != null)
			newModel.setObjectiveFunction(model.getObjectiveFunction().clone());

		for (CSPConstraint cons : model.getConstraints()) {
			if (!newModel.getConstraints().contains(cons)) {
				Integer index = 0;
				for (CSPConstraint cons2 : newModel.getConstraints()) {
					if (cons2.getId().equals(cons.getId())) {
						index++;
					}
				}
				if (index > 0)
					cons.setId(cons.getId() + "_" + 2);
				newModel.getConstraints().add(cons);
			}
		}

		return newModel;
	}

	public CSPModel negate() {
		CSPModel model = this.clone();
		List<Expression> stack = new ArrayList<Expression>();

		if (model.getConstraints().size() > 0) {
			for (CSPConstraint cons : model.getConstraints()) {
				Expression neg = new LogicalExpression(
						new ParenthesisExpression(cons.getExpr()),
						LogicalOperator.NOT);
				stack.add(neg);
			}

			Expression expr1 = stack.get(0);
			Expression expr2 = stack.get(stack.size() / 2);
			for (int i = 1; i < stack.size() / 2; i++)
				expr1 = new LogicalExpression(expr1, stack.get(i),
						LogicalOperator.OR);
			for (int i = (stack.size() / 2) + 1; i < stack.size(); i++)
				expr2 = new LogicalExpression(expr2, stack.get(i),
						LogicalOperator.OR);

			Expression expr = new LogicalExpression(expr1, expr2,
					LogicalOperator.OR);

			CSPConstraint constraint = new CSPConstraint("C", expr);
			model.getConstraints().clear();
			model.getConstraints().add(constraint);
		}
		return model;
	}

	@Override
	public CSPModel clone() {
		CSPModel newModel = new CSPModel();

		for (CSPRange range : this.getRanges()) {
			newModel.addRange(range.clone());
		}

		for (CSPVar var : this.getVariables()) {
			newModel.addVar(var.clone());
		}

		for (CSPConstraint cons : this.getConstraints()) {
			newModel.addConstraint(cons.clone());
		}

		return newModel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (useCP)
			sb.append("using CP;").append("\n").append("\n");

		for (CSPRange range : getRanges()) {
			sb.append(range.toString()).append("\n");
		}
		sb.append("\n");

		for (CSPVar var : getVariables()) {
			if (!var.getDvar())
				sb.append(var.toString()).append("\n");
		}
		sb.append("\n");

		for (CSPVar var : getVariables()) {
			if (var.getDvar())
				sb.append(var.toString()).append("\n");
		}
		sb.append("\n");

		if (getObjectiveFunction() != null) {
			String type = (getObjectiveFunction().getMinimize()) ? "minimize"
					: "maximize";
			sb.append(
					type + " "
							+ getObjectiveFunction().getExpression().toString()
							+ ";").append("\n").append("\n");
		}

		if (getConstraints().size() > 0) {
			sb.append("subject to {").append("\n");

			List<CSPConstraint> ordered = new ArrayList<>(getConstraints());
			// Collections.sort(ordered);
			for (CSPConstraint cons : ordered) {
				sb.append("\t").append(cons.toString()).append("\n");
			}
			sb.append("}");
		}

		return sb.toString();
	}

}
