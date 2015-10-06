/**
 *
 */
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
