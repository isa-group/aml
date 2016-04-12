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

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.operations.core.OperationResult;
import es.us.isa.aml.reasoners.cspwebreasoner.Solution;
import es.us.isa.aml.util.ReasonerFactory;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * Core operation that determines if an agreement model contains
 * inconsistencies.
 *
 * @author jdelafuente
 *
 */
public class ExistInconsistencies extends CoreOperation {

    private static final Logger LOG = Logger.getLogger(ExistInconsistencies.class.getName());

    public ExistInconsistencies() {
        this.reasoner = ReasonerFactory.createCSPReasoner();
    }

    public void analyze(AgreementModel agModel) {
        try {
            Translator translator = new Translator(new CSPBuilder());
            CSPModel model = (CSPModel) translator.translate(agModel);
            Solution sol = reasoner.solve(model);
            result.setExistInconsistencies(!sol.getFeasibility());
            if(!sol.getFeasibility()){
                sol = reasoner.explain(model);
                result.setExplaining(sol.getExplaining());
                result.setConflicts(sol.getConflicts());
                if(sol.getError() != null)
                    result.setError(sol.getError());
            }
        } catch (TimeoutException ex) {
            result.setError(ex.getMessage());
        }
    }

    @Override
    public OperationResult getResult() {
        return this.result;
    }
}
