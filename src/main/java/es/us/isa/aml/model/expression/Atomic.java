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
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.model.expression;

import es.us.isa.aml.model.AgreementElement;

/**
 * @author jdelafuente
 *
 */
public class Atomic extends Expression {

    public Atomic(Object n) {
        this.value = n;
    }

    @Override
    public Object calculate() {
        return this.value;
    }

    @Override
    public String toString() {
        if (value instanceof AgreementElement) {
            return ((AgreementElement) this.value).getId();
        } else {
            return this.value.toString();
        }
    }

    public void setValue(Object o) {
        this.value = o;
    }

    public void setDoubleValue(Double n) {
        this.value = n;
    }

    public void setIntegerValue(Integer n) {
        this.value = n;
    }

    public void setBooleanValue(Boolean b) {
        this.value = b;
    }
}
