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
package es.us.isa.aml.reasoners;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public abstract class Reasoner {

    protected Translator translator;
    protected ReasonerType type;

    public ReasonerType getType() {
        return this.type;
    }

    public Translator getTranslator() {
        return this.translator;
    }

    public abstract Boolean solve(CSPModel model);

    public abstract OperationResponse explain(CSPModel model);

    public abstract Boolean implies(CSPModel antecedent, CSPModel consequent);

    public abstract OperationResponse whyNotImplies(CSPModel antecedent, CSPModel consequent);
}
