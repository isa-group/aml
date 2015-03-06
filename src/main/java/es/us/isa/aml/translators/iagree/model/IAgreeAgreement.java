package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Agreement;

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
        
        sb.append(getContext()).append("\n");

        sb.append(getAgreementTerms());

        sb.append("\n" + "EndAgreement");

        return sb.toString();
    }

}
