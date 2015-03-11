/**
 *
 */
package es.us.isa.aml.model;

import es.us.isa.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class Property extends AgreementElement {

    private Metric metric;
    private Expression expr;
    private Scope scope;
    private Feature feature;

    public Property(String id, Metric metric) {
        super(id);
        this.metric = metric;
        scope = Scope.Global;
    }

    public Metric getMetric() {
        return this.metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public void setExpression(Expression expr) {
        this.expr = expr;
    }

    public Scope getScope() {
        return this.scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
