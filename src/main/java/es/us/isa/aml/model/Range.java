package es.us.isa.aml.model;

/**
 * @author jdelafuente
 *
 */
public class Range extends Domain {

    protected Number min;
    protected Number max;

    public Range() {
        this.min = 0.0;
        this.max = 100.0;
    }

    public Range(Number min, Number max) {
        this.min = min;
        this.max = max;
    }

	public Number getMin() {
        return this.min;
    }

    public void setMin(Number min) {
        this.min = min;
    }

    public Number getMax() {
        return this.max;
    }

    public void setMax(Number max) {
        this.max = max;
    }
}
