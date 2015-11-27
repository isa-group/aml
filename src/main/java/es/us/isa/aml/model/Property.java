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
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jdelafuente
 *
 */
public class Property extends AgreementElement {

	private static final Logger LOG = Logger
			.getLogger(Property.class.getName());

	protected Metric metric;
	protected Expression expr;
	protected Scope scope;
	protected Feature feature;
	protected String definitionReference;
	protected String monitorReference;

	public Property(String id) {
		super(id);
		scope = Scope.Global;
	}

	public Property(String id, Metric metric) {
		super(id);
		this.metric = metric;
		scope = Scope.Global;
	}

	public Property(String id, Metric metric, Expression expression,
			Scope scope, Feature feature) {
		super(id);
		this.metric = metric;
		this.expr = expression;
		this.scope = scope;
		this.feature = feature;
	}

	public Metric getMetric() {
		return this.metric;
	}

	public void setMetric(Metric metric) {
		this.metric = metric;
	}

	public Expression getExpression() {
		return this.expr;
	}

	public void setExpression(Expression expr) {
		this.expr = expr;
	}

	public Scope getScope() {
		return this.scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public String getDefinitionReference() {
		return definitionReference;
	}

	public void setDefinitionReference(String definitionReference) {
		this.definitionReference = definitionReference;
	}

	public String getMonitorReference() {
		return monitorReference;
	}

	public void setMonitorReference(String monitorReference) {
		this.monitorReference = monitorReference;
	}

	public Object getValue() {
		if (expr == null) {
			LOG.log(Level.INFO, "Property {0} has not been initialized",
					this.id);
			return null;
		} else {
			return expr.calculate();
		}
	}

	public Integer intValue() {
		if (expr != null) {
			Object value = expr.calculate();
			if (value instanceof String) {
				return Integer.valueOf((String) value);
			} else if (value instanceof Number) {
				return ((Number) value).intValue();
			}
		}

		return null;
	}

	public Double doubleValue() {
		if (expr != null) {
			Object value = expr.calculate();
			if (value instanceof String) {
				return Double.valueOf((String) value);
			} else if (value instanceof Number) {
				return ((Number) value).doubleValue();
			}
		}

		return null;
	}

	public Boolean booleanValue() {
		if (expr != null) {
			Object value = expr.calculate();
			if (value instanceof String) {
				return Boolean.valueOf((String) value);
			} else if (value instanceof Boolean) {
				return (Boolean) value;
			}
		}

		return null;
	}

	@Override
	public Property clone() {
		Property p = new Property(id, metric.clone());
		if (expr != null)
			p.setExpression(Expression.parse(expr.toString()));
		if (feature != null)
			p.setFeature(feature.clone());
		p.setScope(scope);
		return p;
	}
}
