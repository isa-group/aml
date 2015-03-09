/**
 * 
 */
package es.us.isa.aml.model;

import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class Compensation {
	
	public enum AssessmentInterval {
		YEARLY, MONTHLY, WEEKLY, DAILY, HOURLY, MINUTELY
	}
	
	public enum CompensationType {
		PENALTY, REWARD
	}
	
	private AssessmentInterval assessmentInterval;
	private CompensationType compensationType;
	private List<CompensationElement> elements;
	
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
