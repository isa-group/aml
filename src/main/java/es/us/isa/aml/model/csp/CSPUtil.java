/**
 *
 */
package es.us.isa.aml.model.csp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class CSPUtil {

    public static Map<String, String> CP_DATATYPES = new HashMap<String, String>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            this.put("integer", "int");
            this.put("real", "int");
            this.put("float", "int");
            this.put("set", "int");
            this.put("enum", "{string}");
            this.put("Boolean", "boolean");
        }
    };
    
    public static Map<String, String> CPLEX_DATATYPES = new HashMap<String, String>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            this.put("integer", "int");
            this.put("real", "float");
            this.put("set", "int");
            this.put("enum", "{string}");
            this.put("Boolean", "boolean");
        }
    };
}
