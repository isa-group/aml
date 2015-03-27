package es.us.isa.aml.model.csp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.us.isa.aml.translator.AbstractModel;

/**
 * @author jdelafuente
 *
 */
public class CSPModel extends AbstractModel {

	protected Set<CSPRange> ranges;
	protected Set<CSPVar> variables;
	protected Set<CSPConstraint> constraints;

	public CSPModel() {
		ranges = new HashSet<>();
		variables = new HashSet<>();
		constraints = new HashSet<>();
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

	public Set<CSPRange> getRanges() {
		return ranges;
	}

	public void setRanges(Set<CSPRange> ranges) {
		this.ranges = ranges;
	}

	public Set<CSPVar> getVariables() {
		return variables;
	}

	public void setVariables(Set<CSPVar> variables) {
		this.variables = variables;
	}

	public Set<CSPConstraint> getConstraints() {
		return constraints;
	}

	public void setConstraints(Set<CSPConstraint> constraints) {
		this.constraints = constraints;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("using CP;" + "\n\n");

		for (CSPRange range : getRanges()) {
			sb.append(range.toString()).append("\n");
		}
		sb.append("\n");

		for (CSPVar var : getVariables()) {
			sb.append(var.toString()).append("\n");
		}
		sb.append("\n");

		if (getConstraints().size() > 0) {
			sb.append("subject to {" + "\n");

			List<CSPConstraint> ordered = new ArrayList<>(getConstraints());
			Collections.sort(ordered);
			for (CSPConstraint cons : ordered) {
				sb.append("\t").append(cons.toString()).append("\n");
			}
			sb.append("}");
		}

		return sb.toString();
	}

}
