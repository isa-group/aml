/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.AgreementOffer;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementOffer extends AgreementOffer {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Offer ").append(this.getID()).append(" version ").append(this.getVersion()).append("\n");

        sb.append(getContext()).append("\n");

        sb.append(getAgreementTerms());

        sb.append("\n" + "EndAgreementOffer");

        return sb.toString();
    }

}
