/**
 * 
 */
package es.us.isa.aml.translator.builders.wsag.model;

/**
 * Preference is used to describe a list of fine-granularity business values for different
 * alternatives, where satisfying each alternative results in a different business value.
 * 
 * @author jdelafuente
 *
 */
public class Preference {
	
	/**
	 * This element can appear multiple times. Each Service Term Reference refers to a
	 * service term and represents an alternative way of achieving the associated
	 * service level objective. The corresponding, utility specifies the
	 * utility gained by achieving this objective.
	 */
	private String serviceTermReference;
	
	/**
	 * This element can appear multiple times, one corresponding to each Service Term
	 * Reference.
	 */
	private Float utility;

	/**
	 * @return the serviceTermReference
	 */
	public String getServiceTermReference() {
		return serviceTermReference;
	}

	/**
	 * @param serviceTermReference the serviceTermReference to set
	 */
	public void setServiceTermReference(String serviceTermReference) {
		this.serviceTermReference = serviceTermReference;
	}

	/**
	 * @return the utility
	 */
	public Float getUtility() {
		return utility;
	}

	/**
	 * @param utility the utility to set
	 */
	public void setUtility(Float utility) {
		this.utility = utility;
	}
	
	

}
