/**
 *
 */
package es.us.isa.aml.operations.noCore;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
import es.us.isa.aml.util.OperationResponse;

/**
 * No core operation that determines if an agreement model contains dead terms.
 * 
 * @author jdelafuente
 *
 */
public class ExistDeadTermsOp extends NoCoreOperation {

	private final ExistInconsistenciesOp existInconsistenciesOp;

	public ExistDeadTermsOp() {
		this.existInconsistenciesOp = new ExistInconsistenciesOp();
		result = new OperationResponse();
	}

	public void analyze(AgreementModel model) {

		existInconsistenciesOp.analyze(model);
		Boolean existInconsistencies = (Boolean) existInconsistenciesOp
				.getResult().get("existInconsistencies");

		result.put("result", existInconsistenciesOp.getResult().get("result"));
		result.put("conflicts",
				existInconsistenciesOp.getResult().get("conflicts"));

		if (existInconsistencies) {
			result.put("existDeadTerms", false);
			return;
		}

		Map<String, GuaranteeTerm> gtOriginal = new HashMap<>(model
				.getAgreementTerms().getGuaranteeTerms());
		Map<String, GuaranteeTerm> gtCopy = new HashMap<>(gtOriginal);

		if (gtCopy.size() == 0) {
			result.put("existDeadTerms", false);
		} else {
			for (GuaranteeTerm gt : gtOriginal.values()) {
				if (gt.getQc() != null) {
					GuaranteeTerm newgt = new IAgreeGuaranteeTerm(gt.getId(),
							gt.getServiceRole(), new IAgreeSLO(gt.getQc()
									.getCondition()));
					gtCopy.put(gt.getId(), newgt);

					model.getAgreementTerms().setGuaranteeTerms(gtCopy);

					existInconsistenciesOp.analyze(model);
					existInconsistencies = (Boolean) existInconsistenciesOp
							.getResult().get("existInconsistencies");

					if (existInconsistencies) {
						result.put("result", "The document has dead terms");
						result.put(
								"conflicts_deadterms",
								existInconsistenciesOp.getResult().get(
										"conflicts"));
						result.put("existDeadTerms", true);
						break;
					} else {
						gtCopy.clear();
						gtCopy.putAll(gtOriginal);

						model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
						result.put("existDeadTerms", false);
					}
				} else {
					result.put("existDeadTerms", false);
				}
			}
		}

		model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
	}

	@Override
	public OperationResponse getResult() {
		return this.result;
	}

}
