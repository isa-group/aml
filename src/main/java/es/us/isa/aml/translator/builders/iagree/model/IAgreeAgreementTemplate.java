package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;

/**
 * @author jdelafuente
 *
 */
public class IAgreeAgreementTemplate extends AgreementTemplate {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Template ").append(this.getID()).append(" version ")
				.append(this.getVersion()).append("\n");
		sb.append(getContext()).append("\n");
		sb.append(getAgreementTerms());

		if (this.getCreationConstraints().size() > 0) {
			sb.append("CreationConstraints" + "\n");
			for (CreationConstraint cc : this.getCreationConstraints().values()) {
				sb.append("\t").append(cc).append("\n");
			}
		}

		sb.append("\n" + "EndTemplate");

		return sb.toString();
	}
}
