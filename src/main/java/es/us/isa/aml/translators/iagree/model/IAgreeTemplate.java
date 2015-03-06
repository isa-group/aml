package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Template;

/**
 * @author jdelafuente
 *
 */
public class IAgreeTemplate extends Template {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Template ").append(this.getID()).append(" version ").append(this.getVersion()).append("\n");
        sb.append(getContext()).append("\n");
        sb.append(getAgreementTerms());

        sb.append("CreationConstraints" + "\n");
        for (CreationConstraint cc : this.getCreationConstraints()) {
            sb.append("\t").append(cc).append("\n");
        }

        sb.append("\n" + "EndTemplate");

        return sb.toString();
    }
}
