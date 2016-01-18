/**
 * *****************************************************************************
 * AML is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * AML is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015 Licensed under GPL
 * (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */

package es.us.isa.aml.parsers.agreements.yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */

public class ParserYAMLUtil {

    public static String convertToJson(String yamlString) {
        Yaml yaml = new Yaml();
        Map<String, String> obj = (Map<String, String>) yaml.load(yamlString);

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);
        return json;
    }

    public static String convertToYaml(String jsonContent){
        Map<String, String> propertyMap = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            propertyMap = mapper.readValue(jsonContent, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(ParserYAMLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
                Yaml yaml = new Yaml();
        String output = yaml.dump(propertyMap);
        return output;
    }
}
