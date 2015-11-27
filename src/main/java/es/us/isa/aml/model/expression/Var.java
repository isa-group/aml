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
package es.us.isa.aml.model.expression;

import es.us.isa.aml.model.AgreementElement;

/**
 * @author jdelafuente
 *
 */
public class Var extends Expression {

    private Object id;

    public Var(Object n) {
        this.id = n;
    }

    public Var(Object n, Expression e) {
        this.id = n;
        value = e.calculate();
    }

    @Override
    public Object calculate() {
        if (value == null) {
            throw new NullPointerException("Variable " + this.id
                    + " has not been initialized");
        } else {
            return this.value;
        }
    }

    @Override
    public String toString() {
        if (this.id instanceof AgreementElement) {
            return ((AgreementElement) this.id).getId();
        } else {
            return this.id.toString();
        }
    }

    public Object getValue() {
        if (this.value == null) {
            throw new NullPointerException("Variable " + this.id
                    + " has not been initialized");
        } else {
            return value;
        }
    }

    public Double getDoubleValue() {
        if (value instanceof String) {
            return Double.valueOf((String) value);
        } else if (value instanceof Number) {
            return ((Number) this.value).doubleValue();
        } else {
            return null;
        }
    }

    public Integer getIntegerValue() {
        if (value instanceof String) {
            return Integer.valueOf((String) value);
        } else if (value instanceof Number) {
            return ((Number) this.value).intValue();
        } else {
            return null;
        }
    }

    public Boolean getBooleanValue() {
        if (value instanceof String) {
            return Boolean.valueOf((String) value);
        } else if (value instanceof Boolean) {
            return ((Boolean) this.value);
        } else {
            return null;
        }
    }

    public void setValue(Object o) {
        this.value = o;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }
}
