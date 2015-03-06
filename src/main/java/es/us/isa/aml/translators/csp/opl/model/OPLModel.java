package es.us.isa.aml.translators.csp.opl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jdelafuente
 *
 */
public class OPLModel {

    private Set<OPLRange> ranges;
    private Set<OPLVar> variables;
    private Set<OPLConstraint> constraints;

    public OPLModel() {
        ranges = new HashSet<>();
        variables = new HashSet<>();
        constraints = new HashSet<>();
    }

    public void addRange(OPLRange range) {
        if (!ranges.contains(range)) {
            ranges.add(range);
        }
    }

    public void addVar(OPLVar var) {
        variables.add(var);
    }

    public void addConstraint(OPLConstraint constraint) {
        constraints.add(constraint);
    }

    public Set<OPLRange> getRanges() {
        return ranges;
    }

    public void setRanges(Set<OPLRange> ranges) {
        this.ranges = ranges;
    }

    public Set<OPLVar> getVariables() {
        return variables;
    }

    public void setVariables(Set<OPLVar> variables) {
        this.variables = variables;
    }

    public Set<OPLConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(Set<OPLConstraint> constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("using CP;" + "\n\n");

        for (OPLRange range : getRanges()) {
            sb.append(range.toString()).append("\n");
        }
        sb.append("\n");

        for (OPLVar var : getVariables()) {
            sb.append(var.toString()).append("\n");
        }
        sb.append("\n");

        sb.append("subject to {" + "\n");

        List<OPLConstraint> ordered = new ArrayList<>(getConstraints());
        Collections.sort(ordered);
        for (OPLConstraint cons : ordered) {
            sb.append("\t").append(cons.toString()).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }

}
