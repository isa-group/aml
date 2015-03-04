package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.CreationConstraint;
import isa.us.es.aml.model.Metric;
import isa.us.es.aml.model.Template;

import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class IAgreeTemplate extends Template {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Template ").append(this.getID()).append(" version ").append(this.getVersion()).append("\n");
        sb.append("\t").append(this.getResponder()).append(" as Responder" + "\n");

        sb.append("\t" + "Metrics:" + "\n");

        List<Metric> metrics = this.getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric).append("\n");
        }

        sb.append(this.getAgreementTerms());

        sb.append("\n" + "CreationConstraints" + "\n");
        for (CreationConstraint cc : this.getCreationConstraints()) {
            sb.append("\t").append(cc).append("\n");
        }

        sb.append("\n" + "EndTemplate");

        return sb.toString();
    }
}
