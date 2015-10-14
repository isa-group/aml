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
public class Range extends Domain {

    protected Number min;
    protected Number max;

    public Range() {
        this.min = 0.0;
        this.max = 100.0;
    }

    public Range(Number min, Number max) {
        this.min = min;
        this.max = max;
    }

	public Number getMin() {
        return this.min;
    }

    public void setMin(Number min) {
        this.min = min;
    }

    public Number getMax() {
        return this.max;
    }

    public void setMax(Number max) {
        this.max = max;
    }
}
