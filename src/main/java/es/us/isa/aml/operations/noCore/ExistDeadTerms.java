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
        result = new OperationResult();
    }

    public void analyze(AgreementModel model) {

        existInconsistenciesOp.analyze(model);
        OperationResult incOpResult = existInconsistenciesOp.getResult();
        result = incOpResult;
        
        if (!incOpResult.hasErrors()) {
            Boolean existInconsistencies = incOpResult.getExistInconsistencies();
            
            if (existInconsistencies) {
                result.setExistDeadTerms(false);
                return;
            }

            Map<String, GuaranteeTerm> gtOriginal = new HashMap<>(model
                    .getAgreementTerms().getGuaranteeTerms());
            Map<String, GuaranteeTerm> gtCopy = new HashMap<>(gtOriginal);

            if (gtCopy.isEmpty()) {
                result.setExistDeadTerms(false);
            } else {
                for (GuaranteeTerm gt : gtOriginal.values()) {
                    if (gt.getQc() != null) {
                        GuaranteeTerm newgt = new IAgreeGuaranteeTerm(gt.getId(), gt.getRole(), new IAgreeSLO(gt.getQc().getCondition()));
                        gtCopy.put(gt.getId(), newgt);

                        model.getAgreementTerms().setGuaranteeTerms(gtCopy);

                        existInconsistenciesOp.analyze(model);
                        incOpResult = existInconsistenciesOp.getResult();
                        existInconsistencies = incOpResult.getExistInconsistencies();

                        if (existInconsistencies) {
                            result.setExplaining("The document has dead terms");
                            result.setConflicts(incOpResult.getConflicts());
                            result.setExistDeadTerms(true);
                            break;
                        } else {
                            gtCopy.clear();
                            gtCopy.putAll(gtOriginal);

                            model.getAgreementTerms().setGuaranteeTerms(gtOriginal);
                            result.setExistDeadTerms(false);
                        }
                    } else {
                        result.setExistDeadTerms(false);
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
