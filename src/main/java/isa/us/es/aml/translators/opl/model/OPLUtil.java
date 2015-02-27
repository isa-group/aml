/**
 * 
 */
package isa.us.es.aml.translators.opl.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class OPLUtil {
	
	public static Map<String, String> DATATYPES = new HashMap<String, String>(){
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
            put("integer", "int");
            put("float", "int");
            put("set", "int");
        }
    };

}
