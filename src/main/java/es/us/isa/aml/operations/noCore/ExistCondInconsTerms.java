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
package es.us.isa.aml.operations.noCore;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeGuaranteeTerm;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeSLO;
import es.us.isa.aml.operations.core.OperationResult;
import es.us.isa.aml.reasoners.cspwebreasoner.Solution;

/**
 * No core operation that determines if an agreement model contains
 * conditionally inconsistent terms.
 *
 * @author jdelafuente
 *
 */
public class ExistCondInconsTerms extends NoCoreOperation {

    private final ExistInconsistencies existInconsistenciesOp;

    public ExistCondInconsTerms() {
        this.existInconsistenciesOp = new ExistInconsistencies();
        result = new OperationResult();
    }

    public void analyze(AgreementModel model) {

        existInconsistenciesOp.analyze(model);
        OperationResult incOpResult = existInconsistenciesOp.getResult();
        result = incOpResult;

        if (!incOpResult.hasErrors()) {
            Boolean existInconsistencies = incOpResult.getExistInconsistencies();

            if (existInconsistencies) {
                result.setExistCondInconsTerms(false);
                return;
            }

            Map<String, GuaranteeTerm> gtOriginal = new HashMap<>(model
                    .getAgreementTerms().getGuaranteeTerms());
            Map<String, GuaranteeTerm> gtCopy = new HashMap<>(gtOriginal);

            if (gtCopy.isEmpty()) {
                result.setExistCondInconsTerms(false);
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
                        incOpResult = existInconsistenciesOp.getResult();

                        if (!incOpResult.hasErrors()) {
                            if (incOpResult.getExistInconsistencies()) {
                                for (int i = 0; i < incOpResult.getConflicts().size(); i++) {
                                    incOpResult.getConflicts().set(i, incOpResult.getConflicts().get(i).replaceAll("_QC", "").replaceAll("_SLO", ""));
                                }
                                result.setExplaining("The document has conditionally inconsistent terms");
                                result.setConflicts(incOpResult.getConflicts());
                                result.setExistCondInconsTerms(true);
                                break;
                            } else {
                                gtCopy.clear();
                                gtCopy.putAll(gtOriginal);

                                model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
                                result.setExistCondInconsTerms(false);
                            }
                        }
                    } else {
                        result.setExistCondInconsTerms(false);
                    }
                }
            }

            model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
        }
    }

    @Override
    public OperationResult getResult() {
        return this.result;
    }

}
