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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
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
 * No core operation that determines if an agreement model contains dead terms.
 * 
 * @author jdelafuente
 *
 */
public class ExistDeadTerms extends NoCoreOperation {

	private final ExistInconsistencies existInconsistenciesOp;

	public ExistDeadTerms() {
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
							gt.getRole(), new IAgreeSLO(gt.getQc()
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
