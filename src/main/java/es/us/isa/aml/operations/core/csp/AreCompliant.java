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
package es.us.isa.aml.operations.core.csp;

import java.util.Iterator;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 * Core operation that determines if two agreement models are compliant.
 * @author jdelafuente
 *
 */
public class AreCompliant extends CoreOperation {

	public AreCompliant() {
		result = new OperationResponse();
		this.reasoner = ReasonerFactory.createCSPReasoner();
	}

	public void analyze(AgreementModel template, AgreementModel offer) {

		Translator translator = new Translator(new CSPBuilder());

		// areCompliant(T.GTs, O.GTs) <-> implies(map(T.GTs), map(O.GTs))

		AgreementTemplate template_gts = (AgreementTemplate) template.clone();
		template_gts.getCreationConstraints().clear();

		AgreementOffer offer_gts = (AgreementOffer) offer.clone();
		offer_gts.getAgreementTerms().getService().getConfigurationProperties()
				.clear();
		//No se tiene en cuenta las asignaciones de valores a variables en las MPs de la oferta
		Map<String, MonitorableProperty> mps = offer_gts.getAgreementTerms().getMonitorableProperties();
		Iterator<String> it = mps.keySet().iterator();
		while (it.hasNext()) {
			String mpId = (String) it.next();
			MonitorableProperty mp = mps.get(mpId);
			if (mp.getExpression() != null) {
				mp.setExpression(null);
			}
		}

		Boolean compliant1 = true;

		if ((template.getAgreementTerms().getGuaranteeTerms().size() > 0)
				&& (offer.getAgreementTerms().getGuaranteeTerms().size() > 0)) {
			CSPModel csp_template_gts = (CSPModel) translator
					.translate(template_gts);
			CSPModel csp_offer_gts = (CSPModel) translator.translate(offer_gts);
			compliant1 = reasoner.implies(csp_template_gts, csp_offer_gts);
		}

		// areCompliant(O.Ts, T.CCs) <-> implies(map(O.Terms), map(T.CCs))
		CSPModel csp_offer = (CSPModel) translator.translate(offer);
		AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
		template_ccs.getAgreementTerms().getGuaranteeTerms().clear();
		Boolean compliant2 = true;

		if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
			CSPModel csp_template_ccs = (CSPModel) translator
					.translate(template_ccs);			
			compliant2 = reasoner.implies(csp_offer, csp_template_ccs);
		}

		if (compliant1 != null && compliant2 != null)
			result.put("compliant", compliant1 && compliant2);
		else
			result.put("compliant", null);
	}

	@Override
	public OperationResponse getResult() {
		return result;
	}

}
