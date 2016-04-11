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
package es.us.isa.aml.generator;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementGenerator {

	public abstract AgreementOffer generateAgreementOfferFromTemplate(String consumerName, AgreementTemplate template);
        
        public abstract AgreementOffer generateAgreementOfferFromTemplate(AgreementTemplate template, String consumerName, String variableName, String variableValue);

        public abstract Agreement generateAgreementFromAgreementOffer(AgreementOffer offer);
        
	public abstract Agreement generateAgreementFromAgreementOffer(String consumerName, AgreementOffer offer);

}
