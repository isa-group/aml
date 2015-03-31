/**
 *
 */
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.util.Util;

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
            sb.append("\t\t\t" + "<Content>").append(Util.encodeEntities(getQc().getCondition().toString())).append(" IMPLIES ").append(Util.encodeEntities(getSlo().getExpression().toString())).append("</Content>").append("\n");
        } else {
            sb.append("\t\t\t" + "<Content>").append(Util.encodeEntities(getSlo().getExpression().toString())).append("</Content>").append("\n");
        }

        sb.append("\t\t" + "</wsag:Constraint>").append("\n");
        return sb.toString();
    }

}
