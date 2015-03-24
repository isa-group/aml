package es.us.isa.aml.translator.builders.iagree.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class IAgreeCreationConstraint extends CreationConstraint {

	public IAgreeCreationConstraint(String id, SLO slo) {
		super(id, slo);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getId() + ": " + this.getSlo() + ";").append("\n");

		if (getQc() != null) {
			sb.append("\t"
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
					+ "(" + getQc().getCondition() + ")" + ";");
			sb.append("\n");
		}

		return sb.toString();
	}

}
