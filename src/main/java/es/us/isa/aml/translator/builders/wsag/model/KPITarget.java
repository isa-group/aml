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
package es.us.isa.aml.translator.builders.wsag.model;

/**
 * A KPI Target expresses a service level objective by specifying a target for a
 * key performance indicator (KPI) such as average response time, availability,
 * etc. associated with a service.
 *
 * @author jdelafuente
 *
 */
public class KPITarget {

    /**
     * This name of a key performance indicator associated with the service.
     */
    private String KPIName;

    /**
     * This element defines the target value for a KPI.
     */
    private CustomServiceLevel customServiceLevel;

    /**
     * @return the kPIName
     */
    public String getKPIName() {
        return KPIName;
    }

    /**
     * @param kPIName the kPIName to set
     */
    public void setKPIName(String kPIName) {
        KPIName = kPIName;
    }

    /**
     * @return the customServiceLevel
     */
    public CustomServiceLevel getCustomServiceLevel() {
        return customServiceLevel;
    }

    /**
     * @param customServiceLevel the customServiceLevel to set
     */
    public void setCustomServiceLevel(CustomServiceLevel customServiceLevel) {
        this.customServiceLevel = customServiceLevel;
    }

}
