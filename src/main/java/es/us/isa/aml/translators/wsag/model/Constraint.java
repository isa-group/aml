/**
 *
 */
package es.us.isa.aml.translators.wsag.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class Constraint extends CreationConstraint {

    /**
     * @param id
     * @param slo
     */
    public Constraint(String id, SLO slo) {
        super(id, slo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t" + "<wsag:Constraint>").append("\n");
        sb.append("\t\t\t" + "<Name>").append(getId()).append("</Name>").append("\n");

        if (getQc() != null) {
            sb.append("\t\t\t" + "<Content>").append(getQc().getCondition()).append(" IMPLIES ").append(getSlo().getExpression()).append("</Content>").append("\n");
        } else {
            sb.append("\t\t\t" + "<Content>").append(getSlo().getExpression()).append("</Content>").append("\n");
        }

        sb.append("\t\t" + "</wsag:Constraint>").append("\n");
        return sb.toString();
    }

}
