/**
 *
 */
package es.us.isa.aml.translators.wsag.model;

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
