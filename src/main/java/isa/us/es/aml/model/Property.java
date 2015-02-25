/**
 *
 */
package isa.us.es.aml.model;

import java.beans.Expression;

/**
 * @author jdelafuente
 *
 */
public class Property extends AgreementElement {

    private Metric metric;
    private Expression value;
    private Scope scope;

    public Property(String id, Metric metric) {
        super(id);
        this.metric = metric;
        this.scope = Scope.Global;
    }

    public Property(String id, Metric metric, Scope scope) {
        super(id);
        this.metric = metric;
        this.scope = scope;
    }

    public Property(String id, Metric metric, Expression value) {
        super(id);
        this.metric = metric;
        this.value = value;
        this.scope = Scope.Global;
    }

    public Property(String id, Metric metric, Expression value, Scope scope) {
        super(id);
        this.metric = metric;
        this.value = value;
        this.scope = scope;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

}
