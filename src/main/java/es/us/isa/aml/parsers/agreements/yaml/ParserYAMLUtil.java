/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements.yaml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Usuario
 */
public class ParserYAMLUtil {

    public static String convertToJson(String yamlString) {
        Yaml yaml = new Yaml();
        Map<String, String> obj = (Map<String, String>) yaml.load(yamlString);

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);
        return json;
    }

    public static String convertToYaml(String jsonContent) {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<String, String>();
        map = (Map<String, String>) gson.fromJson(jsonContent, map.getClass());

        Yaml yaml = new Yaml();
        String output = yaml.dump(map);
        return output;
    }
}
