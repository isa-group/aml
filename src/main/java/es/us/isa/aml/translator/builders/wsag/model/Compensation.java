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
 * @author jdelafuente
 *
 */
public class Compensation {

    /**
     * This element defines the interval over which a penalty is assessed.
     */
    private AssessmentInterval assessmentInterval;

    /**
     * This element defines the unit for assessing penalty, such as USD. This is
     * an optional element since in some cases a default unit MAY be assumed.
     */
    private String valueUnit;

    /**
     * This element defines the assessment amount, which can be an integer, a
     * float or an arbitrary domain-specific expression.
     */
    private Object valueExpression;

    /**
     * @return the assessmentInterval
     */
    public AssessmentInterval getAssessmentInterval() {
        return assessmentInterval;
    }

    /**
     * @param assessmentInterval the assessmentInterval to set
     */
    public void setAssessmentInterval(AssessmentInterval assessmentInterval) {
        this.assessmentInterval = assessmentInterval;
    }

    /**
     * @return the valueUnit
     */
    public String getValueUnit() {
        return valueUnit;
    }

    /**
     * @param valueUnit the valueUnit to set
     */
    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    /**
     * @return the valueExpression
     */
    public Object getValueExpression() {
        return valueExpression;
    }

    /**
     * @param valueExpression the valueExpression to set
     */
    public void setValueExpression(Object valueExpression) {
        this.valueExpression = valueExpression;
    }

}
