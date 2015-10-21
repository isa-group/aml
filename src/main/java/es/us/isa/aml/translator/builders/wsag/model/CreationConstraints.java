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
package es.us.isa.aml.translator.builders.wsag.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This optional element of an Agreement expresses the constraints for
 * creating/negotiating an agreement. It contains any number of offer items and
 * constraints in any order.
 *
 * @author jdelafuente
 *
 */
public class CreationConstraints {

    /**
     * This element specifies that a particular field of the agreement must be
     * present with a value in the agreement offer, and which values are
     * possible.
     */
    private Item item;

    /**
     * A constraint defines any constraint involving the values of one or more
     * terms.
     */
    private List<Constraint> constraints = new ArrayList<>();

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return The constraints list
     */
    public List<Constraint> getConstraints() {
        return constraints;
    }

    /**
     * @param constraints the constraint list to set
     */
    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t" + "<wsag:CreationConstraints>").append("\n");

        for (Constraint c : getConstraints()) {
            sb.append(c.toString());
        }

        sb.append("\t" + "</wsag:CreationConstraints>").append("\n");

        return sb.toString();
    }

}
