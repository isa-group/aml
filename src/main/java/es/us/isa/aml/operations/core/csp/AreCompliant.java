/**
 * *****************************************************************************
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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */
package es.us.isa.aml.operations.core.csp;

import java.util.Iterator;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.reasoners.cspwebreasoner.Solution;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.operations.core.OperationResult;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.ReasonerFactory;
import java.util.concurrent.TimeoutException;

/**
 * Core operation that determines if two agreement models are compliant.
 *
 * @author jdelafuente
 *
 */
public class AreCompliant extends CoreOperation {

    public AreCompliant() {
        result = new OperationResult();
        reasoner = ReasonerFactory.createCSPReasoner();
    }

    public void analyze(AgreementModel model1, AgreementModel model2) {

        Translator translator = new Translator(new CSPBuilder());
        
        AgreementTemplate template;
        AgreementOffer offer;
        if(model1.getDocType().equals(DocType.TEMPLATE)){
            template = (AgreementTemplate) model1;            
            offer = (AgreementOffer) model2;
        } else {
            template = (AgreementTemplate) model2;            
            offer = (AgreementOffer) model1;
        }

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

        try {
            Boolean compliant1 = true;
            if ((template.getAgreementTerms().getGuaranteeTerms().size() > 0)
                    && (offer.getAgreementTerms().getGuaranteeTerms().size() > 0)) {
                CSPModel csp_template_gts = (CSPModel) translator
                        .translate(template_gts);
                CSPModel csp_offer_gts = (CSPModel) translator.translate(offer_gts);
                Solution sol = reasoner.implies(csp_template_gts, csp_offer_gts);
                compliant1 = sol.getFeasibility();
                if(sol.getError() != null)
                    result.setError(sol.getError());
            }

            // areCompliant(O.Ts, T.CCs) <-> implies(map(O.Terms), map(T.CCs))
            CSPModel csp_offer = (CSPModel) translator.translate(offer);
            AgreementTemplate template_ccs = (AgreementTemplate) template.clone();
            template_ccs.getAgreementTerms().getGuaranteeTerms().clear();
            Boolean compliant2 = true;

            if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
                CSPModel csp_template_ccs = (CSPModel) translator
                        .translate(template_ccs);
                Solution sol = reasoner.implies(csp_offer, csp_template_ccs);
                compliant2 = sol.getFeasibility();
                if(sol.getError() != null)
                    result.setError(sol.getError());
            }

            if (compliant1 != null && compliant2 != null) {
                result.setCompliant(compliant1 && compliant2);
            }
        } catch (TimeoutException ex) {
            result.setError(ex.getMessage());
        }
    }

    @Override
    public OperationResult getResult() {
        return result;
    }

}
