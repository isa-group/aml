package isa.us.es.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Template extends AgreementModel {

    List<CreationConstraint> creationConstraints;

    public Template() {
        this.creationConstraints = new ArrayList<>();
    }

    public List<CreationConstraint> getCreationConstraints() {
        return this.creationConstraints;
    }

    public void setCreationConstraints(List<CreationConstraint> creationConstraints) {
        this.creationConstraints = creationConstraints;
    }
}
