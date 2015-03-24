/**
 *
 */
package es.us.isa.aml.translators.wsag.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This optional element of an Agreement expresses the constraints for
 * creating/negotiating an agreement. It contains any number of offer items and
 * constraints in any order.
 *
 * @author jdelafuente
 *
 */
public class CreationConstraints {

    /**
     * This element specifies that a particular field of the agreement must be
     * present with a value in the agreement offer, and which values are
     * possible.
     */
    private Item item;

    /**
     * A constraint defines any constraint involving the values of one or more
     * terms.
     */
    private List<Constraint> constraints = new ArrayList<>();

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the constraint
     */
    public List<Constraint> getConstraints() {
        return constraints;
    }

    /**
     * @param constraint the constraint to set
     */
    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t" + "<wsag:CreationConstraints>").append("\n");

        for (Constraint c : getConstraints()) {
            sb.append(c.toString());
        }

        sb.append("\t" + "</wsag:CreationConstraints>").append("\n");

        return sb.toString();
    }

}
