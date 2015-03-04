package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.Metric;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreement extends Agreement {

    public IAgreeAgreement() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agreement ").append(this.getID()).append(" version ").append(this.getVersion()).append("\n");
        sb.append("\t").append(this.getResponder()).append(" as Responder" + "\n");

        sb.append("\t" + "Metrics:" + "\n");

        List<Metric> metrics = this.getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric).append("\n");
        }

        sb.append(this.getAgreementTerms());

        sb.append("\n" + "EndAgreement");

        return sb.toString();
    }

}
