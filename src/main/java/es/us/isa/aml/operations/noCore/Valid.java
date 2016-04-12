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

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.operations.core.OperationResult;
import java.util.ArrayList;
import java.util.List;

/**
 * No core operation that determines if an agreement model is valid (it does not
 * contain inconsistencies, nor dead terms, nor conditionally inconsistent
 * terms).
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
        this.result = new OperationResult();
    }

    public void analyze(AgreementModel model) {

        Boolean existInconsistencies = false, existDeadTerms = false, existCondInconsTerms = false;
        String error = "", explaining = "", conflictType = "";
        List<String> conflicts = new ArrayList<>();

        existInconsistenciesOp.analyze(model);
        OperationResult iOpResult = existInconsistenciesOp.getResult();
        if (iOpResult.hasErrors()) {
            error = iOpResult.getError();
        } else {
            existInconsistencies = iOpResult.getExistInconsistencies();
            if (existInconsistencies) {
                explaining = iOpResult.getExplaining();
                conflictType = iOpResult.getConflictType();
                conflicts = iOpResult.getConflicts();
            } else {
                existDeadTermsOp.analyze(model);
                OperationResult dtOpResult = existDeadTermsOp.getResult();
                if (dtOpResult.hasErrors()) {
                    error = dtOpResult.getError();
                } else {
                    existDeadTerms = dtOpResult.getExistDeadTerms();
                    if (existDeadTerms) {
                        explaining = dtOpResult.getExplaining();
                        conflictType = dtOpResult.getConflictType();
                        conflicts = dtOpResult.getConflicts();
                    } else {
                        existCondInconsTermsOp.analyze(model);
                        OperationResult citOpResult = existCondInconsTermsOp.getResult();
                        if (citOpResult.hasErrors()) {
                            error = citOpResult.getError();
                        } else {
                            existCondInconsTerms = citOpResult.getExistCondInconsTerms();
                            if (existCondInconsTerms) {
                                explaining = citOpResult.getExplaining();
                                conflictType = citOpResult.getConflictType();
                                conflicts = citOpResult.getConflicts();
                            }
                        }
                    }
                }
            }
        }

        result.setExistInconsistencies(existInconsistencies);
        result.setExistDeadTerms(existDeadTerms);
        result.setExistCondInconsTerms(existCondInconsTerms);
        result.setExplaining(explaining);
        result.setConflictType(conflictType);
        result.setConflicts(conflicts);
        result.setError(error);
    }

    @Override
    public OperationResult getResult() {
        return result;
    }

}
