package isa.us.es.aml.translators.iagree.model;

import isa.us.es.aml.model.Agreement;
import isa.us.es.aml.model.Metric;

import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreement extends Agreement {

    public IAgreeAgreement() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agreement ").append(getID()).append(" version ").append(getVersion()).append("\n");
        sb.append("\t").append(getResponder()).append(" as Responder" + "\n");

        sb.append("\t" + "Metrics:" + "\n");

        List<Metric> metrics = getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(((IAgreeMetric) (metric)).toString()).append("\n");
        }

        sb.append(((IAgreeAgreementTerms) getAgreementTerms()).toString());

        sb.append("\n" + "EndAgreement");

        return sb.toString();
    }

}
