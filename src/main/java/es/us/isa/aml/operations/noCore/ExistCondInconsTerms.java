/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.operations.noCore;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
import es.us.isa.aml.util.OperationResponse;

/**
 * No core operation that determines if an agreement model contains conditionally
 * inconsistent terms.
 * 
 * @author jdelafuente
 *
 */
public class ExistCondInconsTerms extends NoCoreOperation {

	private final ExistInconsistencies existInconsistenciesOp;

	public ExistCondInconsTerms() {
		this.existInconsistenciesOp = new ExistInconsistencies();
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
			result.put("existCondInconsTerms", false);
			return;
		}
		Map<String, GuaranteeTerm> gtOriginal = new HashMap<>(model
				.getAgreementTerms().getGuaranteeTerms());
		Map<String, GuaranteeTerm> gtCopy = new HashMap<>(gtOriginal);

		if (gtCopy.size() == 0) {
			result.put("existCondInconsTerms", false);
		} else {
			for (GuaranteeTerm gti : gtOriginal.values()) {
				if (gti.getQc() != null && gti.getSlo() != null) {
					GuaranteeTerm newGtQc = new IAgreeGuaranteeTerm(gti.getId()
							+ "_QC", gti.getRole(), new IAgreeSLO(gti
							.getQc().getCondition()));
					GuaranteeTerm newGtSlo = new IAgreeGuaranteeTerm(
							gti.getId() + "_SLO", gti.getRole(),
							new IAgreeSLO(gti.getSlo().getExpression()));
					gtCopy.put(gti.getId(), newGtQc);
					gtCopy.put(gti.getId() + "_slo", newGtSlo);

					model.getAgreementTerms().setGuaranteeTerms(gtCopy);

					existInconsistenciesOp.analyze(model);
					existInconsistencies = (Boolean) existInconsistenciesOp
							.getResult().get("existInconsistencies");

					if (existInconsistencies) {
						String conflicts = existInconsistenciesOp.getResult()
								.get("conflicts").toString()
								.replaceAll("_QC", "").replaceAll("_SLO", "");
						result.put("result",
								"The document has conditionally inconsistent terms");
						result.put("conflicts_condIncons", conflicts);
						result.put("existCondInconsTerms", true);
						break;
					} else {
						gtCopy.clear();
						gtCopy.putAll(gtOriginal);

						model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
						result.put("existCondInconsTerms", false);
					}
				} else {
					result.put("existCondInconsTerms", false);
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
