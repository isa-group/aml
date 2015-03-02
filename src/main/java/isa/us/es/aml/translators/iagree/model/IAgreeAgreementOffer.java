/**
 * 
 */
package isa.us.es.aml.translators.iagree.model;

import java.util.List;

import isa.us.es.aml.model.AgreementOffer;
import isa.us.es.aml.model.Metric;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementOffer extends AgreementOffer {
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agreement ").append(getID()).append(" version ").append(getVersion()).append("\n");
        sb.append("\t").append(getResponder()).append(" as Responder" + "\n");

        sb.append("\t" + "Metrics:" + "\n");

        List<Metric> metrics = getMetrics();
        for (Metric metric : metrics) {
            sb.append("\t\t").append(metric.toString()).append("\n");
        }

        sb.append(getAgreementTerms().toString());

        sb.append("\n" + "EndAgreement");

        return sb.toString();
    }

}
