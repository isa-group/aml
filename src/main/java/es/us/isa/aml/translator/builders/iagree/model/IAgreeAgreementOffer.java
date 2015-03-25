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

		if (getContext().getTemplateId() != null
				&& getContext().getTemplateVersion() != null) {
			sb.append("AgreementOffer ").append(this.getID())
					.append(" version ").append(this.getVersion())
					.append(" for Template ")
					.append(getContext().getTemplateId()).append(" version ")
					.append(getContext().getTemplateVersion()).append("\n");
		} else
			sb.append("AgreementOffer ").append(this.getID())
					.append(" version ").append(this.getVersion()).append("\n");

		sb.append(getContext()).append("\n");

		sb.append(getAgreementTerms());

		sb.append("\n" + "EndAgreementOffer");

		return sb.toString();
	}

}
