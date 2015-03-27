package es.us.isa.aml.translator.builders.opl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;

/**
 * @author jdelafuente
 *
 */
public class OPLModel extends CSPModel {

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

		sb.append("subject to {" + "\n");

		List<CSPConstraint> ordered = new ArrayList<>(getConstraints());
		Collections.sort(ordered);
		for (CSPConstraint cons : ordered) {
			sb.append("\t").append(cons.toString()).append("\n");
		}
		sb.append("}");

		return sb.toString();
	}

}
