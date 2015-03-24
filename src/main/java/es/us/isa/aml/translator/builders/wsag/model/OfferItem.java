/**
 * 
 */
package es.us.isa.aml.translator.builders.wsag.model;

/**
 * @author jdelafuente
 *
 */
public class OfferItem extends Variable {

	@Override
	public String toString() {

		if (getLocation() == null)
			return "<OfferItem name=\"" + getName() + "\" iag:Metric=\""
					+ getMetric().toString() + "\">" + "</OfferItem>" + "\n";
		else
			return "<OfferItem name=\"" + getName() + "\" iag:Metric=\""
					+ getMetric().toString() + "\">" + getLocation()
					+ "</OfferItem>" + "\n";
	}

}
