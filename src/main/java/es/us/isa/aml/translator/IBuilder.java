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
package es.us.isa.aml.translator;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.util.DocType;

/**
 * Builds a model from an AgreementModel.
 * @author jdelafuente
 *
 */
public interface IBuilder {
	
	void setDocType(DocType type);

	void setId(String id);

	void setVersion(Double version);

	void setContext(Context context);

	void setMetric(Metric metric);

	void setAgreementTerms(AgreementTerms at);

	void setService(ServiceConfiguration service);

	void setConfigurationProperty(Property cp);

	void setMonitorableProperty(Property mp);

	void setGuaranteeTerm(GuaranteeTerm gt);

	void setCreationConstraint(CreationConstraint cc);

    String generate();
    
    AbstractModel getModel();
}
