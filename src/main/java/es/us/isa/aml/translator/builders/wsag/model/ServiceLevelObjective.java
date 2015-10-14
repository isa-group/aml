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
 * The Service Level Objective element in a guarantee term is also expressed as
 * an assertion over service attributes and/or external factors such as date,
 * time. However, most often a Service Level Objective is expressed as a target
 * for a Key Performance Indicator (KPI) such as average response time,
 * completion time, availability, etc.
 *
 * @author jdelafuente
 *
 */
public class ServiceLevelObjective {

    /**
     * This element defines service level objective as an expression of a target
     * of a key performance indicator associated with the service.
     */
    private KPITarget kpiTarget;

    /**
     * This element can be customized by using a domain specific expression or
     * assertion language which MAY be designed independently of the
     * WS-Agreement specification.
     */
    private CustomServiceLevel customServiceLevel;

    /**
     * @return the kpiTarget
     */
    public KPITarget getKpiTarget() {
        return kpiTarget;
    }

    /**
     * @param kpiTarget the kpiTarget to set
     */
    public void setKpiTarget(KPITarget kpiTarget) {
        this.kpiTarget = kpiTarget;
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
