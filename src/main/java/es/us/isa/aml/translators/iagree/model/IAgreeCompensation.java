/**
 *
 */
package es.us.isa.aml.translators.iagree.model;

import es.us.isa.aml.model.Compensation;
import es.us.isa.aml.model.CompensationElement;

/**
 * @author jdelafuente
 *
 */
public class IAgreeCompensation extends Compensation {

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("with " + getAssessmentInterval().toString().toLowerCase()
                + " " + getCompensationType().toString().toLowerCase() + "\n");
        for (CompensationElement elem : getElements()) {
            sb.append("\t\t\t" + "of " + elem.getExpression().toString() + " if " + elem.getCondition().toString() + ";" + "\n");
        }
        sb.append("\t\t" + "end");

        return sb.toString();
    }

}
