/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.AgreementOffer;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementOffer extends AgreementOffer {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agreement ").append(this.getID()).append(" version ").append(this.getVersion()).append("\n");
        
        sb.append(getContext()).append("\n");

        sb.append(this.getAgreementTerms());

        sb.append("\n" + "EndAgreement");

        return sb.toString();
    }

}
