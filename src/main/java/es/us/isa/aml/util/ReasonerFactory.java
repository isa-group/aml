package es.us.isa.aml.util;

import es.us.isa.aml.reasoners.CSPWebReasoner;
import es.us.isa.aml.reasoners.ChocoReasoner;
import es.us.isa.aml.reasoners.CplexReasoner;
import es.us.isa.aml.reasoners.Reasoner;

/**
 * Provides a reasoner according to the configuration property: CSPReasoner.
 * 
 * @author jdelafuente
 *
 */
public class ReasonerFactory {

	public static Reasoner createCSPReasoner() {
		ReasonerType type = Config.getInstance().getCSPReasoner();
		switch (type) {
		case CHOCO:
			return new ChocoReasoner();
		case CPLEX:
			return new CplexReasoner();
		case CSPWebReasoner:
			return new CSPWebReasoner();
		default:
			throw new IllegalArgumentException(
					"there is no reasoner for this type: " + type);
		}
	}

	public static Reasoner createDLReasoner() {
		ReasonerType type = ReasonerType.valueOf(Config.getInstance()
				.getDLReasoner());
		switch (type) {
		default:
			throw new IllegalArgumentException(
					"there is no reasoner for this type: " + type);
		}
	}

	private ReasonerFactory() {
	}

}
