/**
 * 
 */
package es.us.isa.aml.translator.builders.wsag.model;

/**
 * Associated with each wsag:ServiceLevelObjective is a wsag:BusinessValueList that
 * contains multiple business values, each expressing a different value aspect of the
 * objective. Depending on the scenario and value type, each value represents an
 * assertion by one or both parties.
 * 
 * @author jdelafuente
 *
 */
public class BusinessValueList {
	
	/**
	 * This element when present expresses relative importance (defined below) of
	 * meeting an objective.
	 */
	private Integer importance;
	
	/**
	 * This element (defined below) when present expresses the penalty to be assessed
	 * for not meeting an objective. If multiple Penalty statements are present, for
	 * example penalty statements expressed per week and per month basis for an
	 * availability objective, the longest assessment duration resulting in highest
	 * assessment value will be applied.
	 */
	private Penalty penalty;
	
	/**
	 * This element (defined below) when present expresses reward to be assessed for
	 * meeting an objective. If multiple Reward statements are present, they are
	 * applied alternatively, depending on the longest assessment interval applicable.
	 */
	private Reward reward;
	
	/**
	 * This element specifies a list of fine-granularity business values for different
	 * alternatives, where each alternative refers to a Service Description Term and its
	 * associated utility.
	 */
	private Preference preference;
	
	/**
	 * Zero or more domain specific customized business values can be defined.
	 */
	private CustomBusinessValue customBusinessValue;
	
	

}
