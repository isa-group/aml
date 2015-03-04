package isa.us.es.aml.translators.opl.model;

import java.util.*;

/**
 * @author jdelafuente
 *
 */
public class OPLModel {

    private Set<OPLRange> ranges;
    private Set<OPLVar> variables;
    private Set<OPLConstraint> constraints;

    public OPLModel() {
        this.ranges = new HashSet<>();
        this.variables = new HashSet<>();
        this.constraints = new HashSet<>();
    }

    public void addRange(OPLRange range) {
        if (!this.ranges.contains(range)) {
            this.ranges.add(range);
        }
    }

    public void addVar(OPLVar var) {
        this.variables.add(var);
    }

    public void addConstraint(OPLConstraint constraint) {
        this.constraints.add(constraint);
    }

    public Set<OPLRange> getRanges() {
        return this.ranges;
    }

    public void setRanges(Set<OPLRange> ranges) {
        this.ranges = ranges;
    }

    public Set<OPLVar> getVariables() {
        return this.variables;
    }

    public void setVariables(Set<OPLVar> variables) {
        this.variables = variables;
    }

    public Set<OPLConstraint> getConstraints() {
        return this.constraints;
    }

    public void setConstraints(Set<OPLConstraint> constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("using CP;" + "\n");

        for (OPLRange range : this.getRanges()) {
            sb.append(range).append("\n");
        }
        sb.append("\n");

        for (OPLVar var : this.getVariables()) {
            sb.append(var).append("\n");
        }
        sb.append("\n");

        sb.append("subject to {" + "\n");

        List<OPLConstraint> ordered = new ArrayList<>(this.getConstraints());
        Collections.sort(ordered);
        for (OPLConstraint cons : ordered) {
            sb.append("\t").append(cons).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }

}
