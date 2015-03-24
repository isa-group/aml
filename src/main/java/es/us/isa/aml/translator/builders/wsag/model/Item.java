/**
 * 
 */
package es.us.isa.aml.translator.builders.wsag.model;

/**
 * An offer item specifies the requirement for the presence in the agreement offer
 * terms of a field and a value for that field.
 * 
 * @author jdelafuente
 *
 */
public class Item {

	/**
	 * The MANDATORY name is a label of the field that MUST be unique and identifies
	 * the field in the offer and can be used to refer to the restriction item in a
	 * convenient way.
	 */
	private String name;
	
	/**
	 * The location is a structural reference which
	 * points to the location in the terms of the Agreement that can be changed and
	 * filled in.
	 */
	private String location;
	
	/**
	 * A constraint on the value that initiators can fill in at the point of the item’s
	 * location.
	 */
	private ItemConstraint itemConstraint;

}
