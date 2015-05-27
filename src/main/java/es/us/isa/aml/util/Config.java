/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author AntonioGamez
 */
public class Config {

	private static Config instance = null;
	protected final String CONFIG_PATH = "/defaultConfig.json";

	private Map<String, String> propertiesyMap = new HashMap<>();

	protected Config() {
		InputStream in = Config.class.getResourceAsStream(CONFIG_PATH);
		String config = Util.getStringFromInputStream(in);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.getFactory().enable(Feature.ALLOW_COMMENTS);
			Map<String, String> map = mapper.readValue(config,
					new TypeReference<Map<String, String>>() {
					});
			for (String key : map.keySet())
				propertiesyMap.put(key, map.get(key));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public static Config getInstance(String json) throws IOException {
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
		return null;
	}

	public static void setProperty(String prop, String value) {
		getInstance().propertiesyMap.put(prop, value);
	}

	public static void loadConfig(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getFactory().enable(Feature.ALLOW_COMMENTS);
		Map<String, String> map = mapper.readValue(json,
				new TypeReference<Map<String, String>>() {
				});
		for (String key : map.keySet())
			getInstance().propertiesyMap.put(key, map.get(key));
	}

	public Map<String, String> getPropertiesMap() {
		return propertiesyMap;
	}
}
