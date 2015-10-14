/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Util;

/**
 * The Store class stores all the templates, offers and agreements in a map.
 * @author jdelafuente
 */
public class Store {

	private static Store instance = null;

	public static Store getInstance() {
		if (instance == null) {
			instance = new Store();
		}
		return instance;
	}

	private final Map<String, AgreementModel> agreementModelMap;

	/**
	 * Creates an Store object.
	 */
	protected Store() {
		agreementModelMap = new HashMap<>();
	}

	/**
	 * Create an Agreement object from the agreement content, the language type
	 * and the AgreementManager.
	 * 
	 * @param content
	 *            The agreement content
	 * @param lang
	 *            The language of the agreement
	 * @param manager
	 *            The current agreement manager
	 * @return The Agreement object
	 * @see Agreement
	 * @see AgreementLanguage
	 * @see AgreementManager
	 */
	public Agreement createAgreement(String content, AgreementLanguage lang,
			AgreementManager manager) {
		Agreement agreement = (Agreement) AgreementParser.parseAgreementFile(content, lang);
		if (agreement != null) {
			agreement.setAgreementManager(manager);
		}
		return agreement;
	}

	/**
	 * Create an AgreementOffer object from the offer content, the language type
	 * and the agreement manager.
	 * 
	 * @param content
	 *            The offer content
	 * @param lang
	 *            The language of the offer
	 * @param manager
	 *            The current agreement manager
	 * @return The AgreementOffer object
	 * @see AgreementOffer
	 * @see AgreementLanguage
	 * @see AgreementManager
	 */
	public AgreementOffer createAgreementOffer(String content,
			AgreementLanguage lang, AgreementManager manager) {
		AgreementOffer offer = (AgreementOffer) AgreementParser.parseAgreementFile(content,
				lang);
		if (offer != null) {
			offer.setAgreementManager(manager);
		}
		return offer;
	}

	/**
	 * Create an AgreementTemplate object from the template content, the
	 * language type and the agreement manager.
	 * 
	 * @param content
	 *            The template content
	 * @param lang
	 *            The language of the template
	 * @param manager
	 *            The current agreement manager
	 * @return The AgreementTemplate object
	 * @see AgreementTemplate
	 * @see AgreementLanguage
	 * @see AgreementManager
	 */
	public AgreementTemplate createAgreementTemplate(String content,
			AgreementLanguage lang, AgreementManager manager) {
		AgreementTemplate template = (AgreementTemplate) AgreementParser.parseAgreementFile(
				content, lang);
		if (template != null) {
			template.setAgreementManager(manager);
		}
		return template;
	}

	// Registration

	/**
	 * Parse and register a file in the store map.
	 * 
	 * @param path
	 *            The path to the file
	 */
	public void registerFromFile(String path) {
		register(AgreementParser.parseAgreementFile(Util.loadFile(path)));
	}

	/**
	 * Parse and register a file in the store map.
	 * 
	 * @param file
	 *            The File object to register
	 */
	public void registerFromFile(File file) {
		registerFromFile(file.getPath());
	}

	/**
	 * Parse and register all the files contained in the folder provided.
	 * You can specify a boolean to determine if a recursive search is needed or
	 * not.
	 * 
	 * @param folderPath
	 *            The path to the folder that contains all the files
	 * @param recursive 	The Boolean that determines if a recursive search is needed
	 */
	public void registerFromFolder(String folderPath, Boolean recursive) {
		registerFromFolder(new File(folderPath), recursive);
	}

	public void registerFromFolder(File folder, Boolean recursive) {
		if (folder.isDirectory()) {
			for (File fileEntry : folder.listFiles()) {
				if (recursive && fileEntry.isDirectory()) {
					registerFromFolder(folder, true);
				} else if (fileEntry.getName().contains(".at")
						|| fileEntry.getName().contains(".ao")
						|| fileEntry.getName().contains(".ag")) {
					register(AgreementParser.parseAgreementFile(Util.loadFile(fileEntry
							.getPath())));
				}
			}
		}
	}

	/**
	 * Register an AgreementModel in the store map.
	 * @param model	The AgreementModel to register
	 */
	public void register(AgreementModel model) {
		register(model.getID(), model);
	}

	/**
	 * Register an AgreementModel using the name provided as the key of the store map.
	 * @param name	The name to use as the key of this entry
	 * @param model	The AgreementModel to register
	 */
	public void register(String name, AgreementModel model) {
		instance.agreementModelMap.put(name, model);
	}

	// Retrieve
	
	/**
	 * Retrieve an AgreementTemplate by name.
	 * @param name	The key of the store map entry to retrieve
	 * @return The AgreementTemplate
	 */
	public AgreementTemplate getAgreementTemplate(String name) {
		try {
			return (AgreementTemplate) instance.agreementModelMap.get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	/**
	 * Retrieve an AgreementOffer by name.
	 * @param name	The key of the store map entry to retrieve
	 * @return The AgreementOffer
	 */
	public AgreementOffer getAgreementOffer(String name) {
		try {
			return (AgreementOffer) instance.agreementModelMap.get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	/**
	 * Retrieve an Agreement by name.
	 * @param name	The key of the store map entry to retrieve
	 * @return The Agreement
	 */
	public Agreement getAgreement(String name) {
		try {
			return (Agreement) instance.agreementModelMap.get(name);
		} catch (ClassCastException e) {
			return null;
		}
	}

	/**
	 * Retrieve the map of the store.
	 * @return An unmodifiable view of the map that contains all the agreement models
	 */
	public Map<String, AgreementModel> getAgreementMap() {
		return Collections.unmodifiableMap(instance.agreementModelMap);
	}

	/**
	 * Remove an AgreementModel of the store map by its name.
	 * @param name	The key of the entry to remove
	 */
	public void removeAgreement(String name) {
		instance.agreementModelMap.remove(name);
	}

}
