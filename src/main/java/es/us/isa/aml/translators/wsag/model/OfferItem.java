/**
 * 
 */
package es.us.isa.aml.translators.wsag.model;

/**
 * @author jdelafuente
 *
 */
public class OfferItem extends Variable {

	@Override
	public String toString() {

		if (getLocation() == null)
			return "<OfferItem name=\"" + getName() + "\" wsag:Metric=\""
					+ getMetric().toString() + "\">" + "</OfferItem>" + "\n";
		else
			return "<OfferItem name=\"" + getName() + "\" wsag:Metric=\""
					+ getMetric().toString() + "\">" + getLocation()
					+ "</OfferItem>" + "\n";
	}

}
