package es.us.isa.aml.model.csp;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.translator.AbstractModel;

/**
 * @author jdelafuente
 *
 */
public class CSPModel extends AbstractModel {

	protected List<CSPRange> ranges;
	protected List<CSPVar> variables;
	protected CSPObjectiveFunction objectiveFunction;
	protected List<CSPConstraint> constraints;

	public CSPModel() {
		ranges = new ArrayList<>();
		variables = new ArrayList<>();
		constraints = new ArrayList<>();
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

		if(model.getObjectiveFunction() != null)
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
		List<String> arr = new ArrayList<String>();
		for (CSPConstraint cons : model.getConstraints()) {
			Expression e = cons.getExpr();
			Expression neg = new LogicalExpression(
					new ParenthesisExpression(e), LogicalOperator.NOT);
			arr.add(neg.toString());
		}
		
		// Java 8
//		String str_expr = String.join(
//				" " + LogicalOperator.OR.toString() + " ", arr);
		
		String str_expr = arr.toString().replaceAll("[\\[\\]]", "")
				.replaceAll(", ", " " + LogicalOperator.OR.toString() + " ");
		Expression expr = Expression.parse(str_expr);

		CSPConstraint constraint = new CSPConstraint("C", expr);
		model.getConstraints().clear();
		model.getConstraints().add(constraint);
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
//			Collections.sort(ordered);
			for (CSPConstraint cons : ordered) {
				sb.append("\t").append(cons.toString()).append("\n");
			}
			sb.append("}");
		}

		return sb.toString();
	}

}
