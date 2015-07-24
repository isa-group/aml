/**
 * 
 */
package es.us.isa.aml.translator.builders.iagree.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class IAgreeUtils {
	
	public static Map<String, String> DATATYPES = new HashMap<String, String>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            this.put("int", "integer");
            this.put("float", "float");
            this.put("enumerated", "enum");
        }
    };

}
