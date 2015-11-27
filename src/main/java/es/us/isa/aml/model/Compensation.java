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

import java.util.List;

import es.us.isa.aml.util.AssessmentInterval;
import es.us.isa.aml.util.CompensationType;

/**
 * This class represents a compensation of an agreement.
 * @author jdelafuente
 *
 */
public class Compensation {

    private AssessmentInterval assessmentInterval;
    private CompensationType compensationType;
    private List<CompensationElement> elements;

    public Compensation() {

    }

    public Compensation(AssessmentInterval assessmentInterval,
            CompensationType compensationType,
            List<CompensationElement> elements) {
        super();
        this.assessmentInterval = assessmentInterval;
        this.compensationType = compensationType;
        this.elements = elements;
    }

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
     * @return the compensationType
     */
    public CompensationType getCompensationType() {
        return compensationType;
    }

    /**
     * @param compensationType the compensationType to set
     */
    public void setCompensationType(CompensationType compensationType) {
        this.compensationType = compensationType;
    }

    /**
     * @return the elements
     */
    public List<CompensationElement> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(List<CompensationElement> elements) {
        this.elements = elements;
    }
}
