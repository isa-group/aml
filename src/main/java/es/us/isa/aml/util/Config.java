/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AntonioGamez
 */
public class Config {

    private static Config instance = null;

    protected static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    protected static Config getInstance(String json) throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        loadConfig(json);
        return instance;
    }

    public static String getProperty(String prop) {    	
        if (instance.propertiesyMap.containsKey(prop)) {
            return instance.propertiesyMap.get(prop);
        }
        return "";
    }

    public static void setProperty(String prop, String value) {
        getInstance().propertiesyMap.put(prop, value);
    }

    public static void loadConfig(String json) throws IOException {
        getInstance().propertiesyMap = new ObjectMapper().readValue(json, new TypeReference<Map<String, String>>() {
        });
    }
    private Map<String, String> propertiesyMap = new HashMap<>();

    protected Config() {
    }
}
