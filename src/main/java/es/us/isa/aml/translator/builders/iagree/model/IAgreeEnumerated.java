/**
 *
 */
package es.us.isa.aml.translator.builders.iagree.model;

import java.util.Arrays;

import es.us.isa.aml.model.Enumerated;

/**
 * @author jdelafuente
 *
 */
public class IAgreeEnumerated extends Enumerated {

	
	public IAgreeEnumerated(Object[] values) {
		super(values);
	}

	@Override
    public String toString() {
        return Arrays.asList(getValues()).toString().replace("[", "{").replace("]", "}");
    }

}
