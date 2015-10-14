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
package es.us.isa.aml.model;



/**
 * @author jdelafuente
 *
 */
public class Enumerated extends Domain {

    private Object[] values;

    public Enumerated() {
        this.values = new Object[0];
    }

    public Enumerated(Object[] values) {
        this.values = values;
    }

    /**
     * @return the values
     */
    public Object[] getValues() {
        return this.values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(Object[] values) {
        this.values = values;
    }
}
