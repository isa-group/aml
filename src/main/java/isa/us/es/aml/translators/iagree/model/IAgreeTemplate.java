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
        sb.append("Template ").append(getID()).append(" version ").append(getVersion()).append("\n");
        sb.append("\t").append(getResponder()).append(" as Responder" + "\n");

        sb.append("\t" + "Metrics:" + "\n");

        List<Metric> metrics = getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric.toString()).append("\n");
        }

        sb.append(getAgreementTerms().toString());

        sb.append("\n" + "CreationConstraints" + "\n");
        for (CreationConstraint cc : getCreationConstraints()) {
            sb.append("\t").append(cc.toString()).append("\n");
        }

        sb.append("\n" + "EndTemplate");

        return sb.toString();
    }
}
