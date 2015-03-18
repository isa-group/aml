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

    
	public IAgreeCompensation(Compensation c) {
		super(c.getAssessmentInterval(), c.getCompensationType(), c.getElements());
	}

	@Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("with ").append(getAssessmentInterval().toString().toLowerCase()).append(" ").append(getCompensationType().toString().toLowerCase()).append("\n");
        for (CompensationElement elem : getElements()) {
            sb.append("\t\t\t" + "of ").append(elem.getExpression().toString()).append(" if ").append(elem.getCondition().toString()).append(";" + "\n");
        }
        sb.append("\t\t" + "end");

        return sb.toString();
    }

}
