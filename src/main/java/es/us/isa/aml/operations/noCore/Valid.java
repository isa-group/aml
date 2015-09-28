package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.util.OperationResponse;

/**
 * No core operation that determines if an agreement model is valid (it does not
 * contain inconsistencies, nor dead terms, nor conditionally inconsistent terms).
 * 
 * @author jdelafuente
 *
 */
public class Valid extends NoCoreOperation {

	private final ExistInconsistencies existInconsistenciesOp;
	private final ExistDeadTerms existDeadTermsOp;
	private final ExistCondInconsTerms existCondInconsTermsOp;

	public Valid() {
		this.existInconsistenciesOp = new ExistInconsistencies();
		this.existDeadTermsOp = new ExistDeadTerms();
		this.existCondInconsTermsOp = new ExistCondInconsTerms();
		this.result = new OperationResponse();
	}

	public void analyze(AgreementModel model) {

		Boolean existInconsistencies = false, existDeadTerms = false, existCondInconsTerms = false;

		existInconsistenciesOp.analyze(model);
		existInconsistencies = (Boolean) existInconsistenciesOp.getResult()
				.get("existInconsistencies");
		result.putAll(existInconsistenciesOp.getResult());

		try {
			if (existInconsistencies) {
				result.put("existDeadTerms", false);
				result.put("existCondInconsTerms", false);
			} else {
				existDeadTermsOp.analyze(model);
				existDeadTerms = (Boolean) existDeadTermsOp.getResult().get(
						"existDeadTerms");
				result.putAll(existDeadTermsOp.getResult());

				if (existDeadTerms) {
					result.put("existCondInconsTerms", false);
				} else {
					existCondInconsTermsOp.analyze(model);
					existCondInconsTerms = (Boolean) existCondInconsTermsOp
							.getResult().get("existCondInconsTerms");
					result.putAll(existCondInconsTermsOp.getResult());
				}
			}
		} catch (Exception e) {
			result = new OperationResponse();
			result.put("result", null);
			result.put("conflicts", "There was an error: " + e.getMessage());
			result.put("existInconsistencies", false);
			result.put("existDeadTerms", false);
			result.put("existCondInconsTerms", false);
			existInconsistencies = true;
			existDeadTerms = true;
			existCondInconsTerms = true;
		}

		Boolean valid = !existInconsistencies && !existDeadTerms
				&& !existCondInconsTerms;
		result.put("valid", valid);
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
