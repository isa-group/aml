package es.us.isa.aml.util;

import es.us.isa.aml.generator.AgreementGenerator;
import es.us.isa.aml.generator.BasicAgreementGenerator;

/**
 * Provides a generator according to the configuration property:
 * AgreementGenerator.
 * 
 * @author jdelafuente
 *
 */
public class GeneratorFactory {

	public static AgreementGenerator createGenerator() {
		GeneratorType type = Config.getInstance().getAgreementGenerator();
		switch (type) {
		case BASIC:
			return new BasicAgreementGenerator();
		default:
			throw new IllegalArgumentException(
					"there is no generator for this type: " + type);
		}
	}
}
