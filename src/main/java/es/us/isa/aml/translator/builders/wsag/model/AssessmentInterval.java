/**
 *
 */
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
