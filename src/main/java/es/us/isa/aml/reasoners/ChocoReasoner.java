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

import java.util.Random;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.choco.ChocoBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public class ChocoReasoner extends Reasoner {

    private String chocoString;

    public ChocoReasoner() {
        this.type = ReasonerType.CHOCO;
        this.translator = new Translator(new ChocoBuilder());
    }

    @Override
    public Boolean solve(CSPModel model) {
        //todo: realizar lo que sea correcto aqui
    	Boolean res = false;
        if (this.chocoString != null) {
            res = new Random().nextBoolean();
        }
        return res;
    }

    @Override
    public OperationResponse explain(CSPModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
	public Boolean implies(CSPModel antecedent, CSPModel consequent) {
    	throw new UnsupportedOperationException("Not supported yet.");
	}

    @Override
    public OperationResponse whyNotImplies(CSPModel antecedent, CSPModel consequent) {
        throw new UnsupportedOperationException("Not supported yet in Choco.");
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CHOCO;
    }

	
}
