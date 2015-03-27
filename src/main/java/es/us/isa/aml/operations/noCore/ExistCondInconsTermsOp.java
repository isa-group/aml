/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
import es.us.isa.aml.util.OperationResponse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AntonioGamez
 */
public class ExistCondInconsTermsOp extends NoCoreOperation {

	private final ExistInconsistenciesOp existInconsistenciesOp;

	public ExistCondInconsTermsOp() {
		this.existInconsistenciesOp = new ExistInconsistenciesOp();
		result = new OperationResponse();
	}

	public void analyze(AgreementModel model) {

		existInconsistenciesOp.analyze(model);

		Boolean existInconsistencies = (Boolean) existInconsistenciesOp
				.getResult().get("existInconsistencies");

		if (existInconsistencies) {
			result.put("result",
					existInconsistenciesOp.getResult().get("result"));
			result.put("conflicts",
					existInconsistenciesOp.getResult().get("conflicts"));
			result.put("existCondInconsTerms", false);
			return;
		}
		List<GuaranteeTerm> gtOriginal = new ArrayList<>(model
				.getAgreementTerms().getGuaranteeTerms());
		List<GuaranteeTerm> gtCopy = new ArrayList<>(gtOriginal);

		for (int i = 0; i < gtCopy.size(); i++) {
			GuaranteeTerm gti = gtCopy.get(i);
			if (gti.getQc() != null && gti.getSlo() != null) {
				GuaranteeTerm newGtQc = new IAgreeGuaranteeTerm(gti.getId()
						+ "_QC", gti.getServiceRole(), new IAgreeSLO(gti
						.getQc().getCondition()));
				GuaranteeTerm newGtSlo = new IAgreeGuaranteeTerm(gti.getId()
						+ "_SLO", gti.getServiceRole(), new IAgreeSLO(gti
						.getSlo().getExpression()));
				gtCopy.set(gtCopy.indexOf(gti), newGtQc);
				gtCopy.add(gtCopy.indexOf(gti) + 1, newGtSlo);

				model.getAgreementTerms().setGuaranteeTerms(gtCopy);

				existInconsistenciesOp.analyze(model);
				existInconsistencies = (Boolean) existInconsistenciesOp
						.getResult().get("existInconsistencies");

				if (existInconsistencies) {
					String conflicts = existInconsistenciesOp.getResult()
							.get("conflicts").toString().replaceAll("_QC", "")
							.replaceAll("_SLO", "");
					result.put("result", existInconsistenciesOp.getResult()
							.get("result"));
					result.put("conflicts_condIncons", conflicts);
					result.put("existCondInconsTerms", true);
					break;
				} else {
					gtCopy.clear();
					gtCopy.addAll(gtOriginal);

					model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
					result.put("result", existInconsistenciesOp.getResult()
							.get("result"));
					result.put("conflicts", existInconsistenciesOp.getResult()
							.get("conflicts"));
					result.put("existCondInconsTerms", false);
				}
			} else {
				result.put("result",
						existInconsistenciesOp.getResult().get("result"));
				result.put("conflicts",
						existInconsistenciesOp.getResult().get("conflicts"));
				result.put("existCondInconsTerms", false);
			}
		}
		model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
	}

	@Override
	public OperationResponse getResult() {
		return this.result;
	}

}
