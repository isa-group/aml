/**
 *
 */
package es.us.isa.aml.translators.wsag.model;

import java.time.Period;

/**
 * @author jdelafuente
 *
 */
public class AssessmentInterval {

    /**
     * This element when present defines the assessment interval as a duration.
     * For example, a weekly or monthly interval for defining the assessment.
     */
    private Period timeInterval;

    /**
     * This element when present defines the assessment interval as a service
     * specific count, such as number of invocations.
     */
    private Integer count;

    /**
     * @return the timeInterval
     */
    public Period getTimeInterval() {
        return timeInterval;
    }

    /**
     * @param timeInterval the timeInterval to set
     */
    public void setTimeInterval(Period timeInterval) {
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
