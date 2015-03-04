/**
 *
 */
package isa.us.es.aml.model;

import isa.us.es.aml.model.expression.Expression;

/**
 * @author jdelafuente
 *
 */
public class Property extends AgreementElement {

    private Metric metric;
    private Expression expr;
    private Scope scope;

    public Property(String id, Metric metric) {
        super(id);
        this.metric = metric;
        scope = Scope.Global;
    }

    public Property(String id, Metric metric, Scope scope) {
        super(id);
        this.metric = metric;
        this.scope = scope;
    }

    public Property(String id, Metric metric, Expression expr) {
        super(id);
        this.metric = metric;
        this.expr = expr;
        scope = Scope.Global;
    }

    public Property(String id, Metric metric, Expression expr, Scope scope) {
        super(id);
        this.metric = metric;
        this.expr = expr;
        this.scope = scope;
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
}
