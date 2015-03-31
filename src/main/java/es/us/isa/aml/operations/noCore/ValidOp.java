/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.util.OperationResponse;

/**
 *
 * @author AntonioGamez
 */
public class ValidOp extends NoCoreOperation {

	private final ExistInconsistenciesOp existsInconsistenciesOp;
	private final ExistDeadTermsOp existDeadTermsOp;
	private final ExistCondInconsTermsOp existCondInconsTermsOp;

	public ValidOp() {
		this.existsInconsistenciesOp = new ExistInconsistenciesOp();
		this.existDeadTermsOp = new ExistDeadTermsOp();
		this.existCondInconsTermsOp = new ExistCondInconsTermsOp();
		this.result = new OperationResponse();
	}

	public void analyze(AgreementModel model) {

		Boolean existInconsistencies = false, existDeadTerms = false, existCondInconsTerms = false;

		existsInconsistenciesOp.analyze(model);
		existInconsistencies = (Boolean) existsInconsistenciesOp.getResult()
				.get("existInconsistencies");
		result.put("existInconsistencies", existInconsistencies);

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

		Boolean valid = !existInconsistencies && !existDeadTerms
				&& !existCondInconsTerms;

		result.put("valid", valid);
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
