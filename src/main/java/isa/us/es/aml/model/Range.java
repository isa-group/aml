package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class Range extends Domain {

    protected int min;
    protected int max;

    public Range() {
        this.min = 0;
        this.max = 100;
    }

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
