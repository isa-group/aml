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


/**
 * @author jdelafuente
 *
 */
public class AssessmentInterval {

    /**
     * This element when present defines the assessment interval as a duration.
     * For example, a weekly or monthly interval for defining the assessment.
     */
    private es.us.isa.aml.util.AssessmentInterval timeInterval;

    /**
     * This element when present defines the assessment interval as a service
     * specific count, such as number of invocations.
     */
    private Integer count;

    /**
     * @return the timeInterval
     */
    public es.us.isa.aml.util.AssessmentInterval getTimeInterval() {
        return timeInterval;
    }

    /**
     * @param timeInterval the timeInterval to set
     */
    public void setTimeInterval(es.us.isa.aml.util.AssessmentInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }

}
