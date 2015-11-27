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

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AbstractModel;
import es.us.isa.aml.model.AgreementElement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Property;
import es.us.isa.aml.model.ServiceConfiguration;

/**
 * Tanslates an AgreementModel into another kind of model.
 * 
 * @author jdelafuente
 *
 */
public class Translator {

	private static final Logger LOG = Logger.getLogger(Translator.class
			.getName());
	private IBuilder builder;

	public Translator(IBuilder builder) {
		this.builder = builder;
	}

	public IBuilder getBuilder() {
		return builder;
	}

	public AbstractModel translate(AgreementModel model) {
		try {
			IBuilder _builder = builder.getClass().newInstance();
			_builder.setDocType(model.getDocType());
			builder = _builder;
			translate(model, builder);
			return builder.getModel();
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_AgreementModel exception", e);
		}
		return null;
	}

	public void translate(AgreementModel model, IBuilder builder) {
		builder.setId(model.getID());
		builder.setVersion(model.getVersion());
		builder.setContext(model.getContext());

		translate(model.getAgreementTerms(), builder);

		if (model instanceof AgreementTemplate) {
			for (CreationConstraint cc : ((AgreementTemplate) model)
					.getCreationConstraints().values())
				translate(cc, builder);
		}
	}

	public void translate(Metric metric) {
		try {
			translate(metric, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_Metric exception", e);
		}
	}

	public void translate(Metric metric, IBuilder builder) {
		builder.setMetric(metric);
	}

	public void translate(AgreementTerms at) {
		try {
			translate(at, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_AgreementTerms exception", e);
		}
	}

	public void translate(AgreementTerms at, IBuilder builder) {
		builder.setAgreementTerms(at);
	}

	public void translate(ServiceConfiguration service) {
		try {
			translate(service, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_Service exception", e);
		}
	}

	public void translate(ServiceConfiguration service, IBuilder builder) {
		builder.setService(service);
	}

	public void translate(Property p) {
		try {
			translate(p, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_Property exception", e);
		}
	}

	public void translate(Property p, IBuilder builder) {
		if (p instanceof ConfigurationProperty) {
			builder.setConfigurationProperty(p);
		} else if (p instanceof MonitorableProperty) {
			builder.setMonitorableProperty(p);
		} else {
			throw new RuntimeException("unknown property type: " + p);
		}
	}

	public void translate(GuaranteeTerm gt) {
		try {
			translate(gt, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_GuaranteeTerm exception", e);
		}
	}

	public void translate(GuaranteeTerm gt, IBuilder builder) {
		builder.setGuaranteeTerm(gt);
	}

	public void translate(CreationConstraint cc) {
		try {
			translate(cc, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_CreationConstraint exception", e);
		}
	}

	public void translate(CreationConstraint cc, IBuilder builder) {
		builder.setCreationConstraint(cc);
	}

	public void translate(Collection<? extends AgreementElement> objects) {
		try {
			translate(objects, builder.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			LOG.log(Level.WARNING, "translate_AgreementElement exception", e);
		}
	}

	public void translate(Collection<? extends AgreementElement> objects,
			IBuilder builder) {
		for (AgreementElement object : objects) {
			if (object instanceof Metric) {
				translate((Metric) object, builder);
			}
			if (object instanceof Property) {
				translate((Property) object, builder);
			}
			if (object instanceof GuaranteeTerm) {
				translate((GuaranteeTerm) object, builder);
			}
			if (object instanceof CreationConstraint) {
				translate((CreationConstraint) object, builder);
			}
		}
	}

	public String print(AgreementModel model) {
		translate(model);
		return builder.generate();
	}

}
