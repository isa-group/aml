/**
 * 
 */
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
	 * This element defines the unit for assessing penalty, such as USD. This is an
	 * optional element since in some cases a default unit MAY be assumed.
	 */
	private String valueUnit;
	
	/**
	 * This element defines the assessment amount, which can be an integer, a float or
	 * an arbitrary domain-specific expression.
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
