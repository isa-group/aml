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

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.noCore.Valid;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.Util;

/**
 * The AgreementManager class is used to handle documents and load your own
 * configurations.
 * 
 * @author jdelafuente
 * 
 */
public class AgreementManager {

	private final Store store;

	/**
	 * Create an AgreementManager with the configuration by default. The default
	 * configuration file is found under the resources folder and the filename
	 * is "defaultConfig.json".
	 * 
	 * @see Config
	 */
	public AgreementManager() {
		Config.load();
		this.store = Store.getInstance();
	}

	/**
	 * Create an AgreementManager with the provided configuration.
	 * 
	 * @param jsonConfig
	 *            Configuration in JSON format
	 */
	public AgreementManager(String jsonConfig) {
		Config.load(jsonConfig);
		this.store = new Store();
	}

	/**
	 * Retrieve the current store manager.
	 * 
	 * @return The Store object
	 * @see Store
	 */
	public Store getStoreManager() {
		return this.store;
	}

	// Start agreement files and model management
	// Creation

	/**
	 * Creates an Agreement object from the path to the agreement file provided.
	 * 
	 * @param path
	 *            The path to the agreement file
	 * @return The Agreement object
	 * @see Agreement
	 */
	public Agreement createAgreementFromFile(String path) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		String content = Util.loadFile(path);
		return store.createAgreement(content, lang, this);
	}

	/**
	 * Creates an Agreement object specifying the path to the agreement file and
	 * the language of the file.
	 * 
	 * @param path
	 *            The path to the agreement file
	 * @param lang
	 *            The language of the agreement file
	 * @return The Agreement object
	 * @see Agreement
	 * @see AgreementLanguage
	 */
	public Agreement createAgreementFromFile(String path, AgreementLanguage lang) {
		String content = Util.loadFile(path);
		return store.createAgreement(content, lang, this);
	}

	/**
	 * Creates an Agreement object from the agreement content provided.
	 * 
	 * @param content
	 *            The content of the agreement
	 * @return The Agreement object
	 * @see Agreement
	 */
	public Agreement createAgreement(String content) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		return store.createAgreement(content, lang, this);
	}

	/**
	 * Creates an AgreementOffer object from the path to the offer file
	 * provided.
	 * 
	 * @param path
	 *            The path to the offer file
	 * @return The AgreementOffer object
	 * @see AgreementOffer
	 */
	public AgreementOffer createAgreementOfferFromFile(String path) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		String content = Util.loadFile(path);
		return store.createAgreementOffer(content, lang, this);
	}

	/**
	 * Creates an AgreementOffer object specifying the path to the offer file
	 * and the language of the file.
	 * 
	 * @param path
	 *            The path to the offer file
	 * @param lang
	 *            The language of the offer file
	 * @return The AgreementOffer object
	 * @see AgreementOffer
	 * @see AgreementLanguage
	 */
	public AgreementOffer createAgreementOfferFromFile(String path,
			AgreementLanguage lang) {
		String content = Util.loadFile(path);
		return store.createAgreementOffer(content, lang, this);
	}

	/**
	 * Creates an AgreementOffer object from the offer content provided.
	 * 
	 * @param content
	 *            The content of the offer
	 * @return The AgreementOffer object
	 * @see AgreementOffer
	 */
	public AgreementOffer createAgreementOffer(String content) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		return store.createAgreementOffer(content, lang, this);
	}

	/**
	 * Creates an AgreementTemplate object from the path to the template file
	 * provided.
	 * 
	 * @param path
	 *            The path to the template file
	 * @return The AgreementTemplate object
	 * @see AgreementTemplate
	 */
	public AgreementTemplate createAgreementTemplateFromFile(String path) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		String content = Util.loadFile(path);
		return store.createAgreementTemplate(content, lang, this);
	}

	/**
	 * Creates an AgreementTemplate object specifying the path to the template
	 * file and the language of the file.
	 * 
	 * @param path
	 *            The path to the template file
	 * @param lang
	 *            The language of the template file
	 * @return The AgreementTemplate object
	 * @see AgreementTemplate
	 * @see AgreementLanguage
	 */
	public AgreementTemplate createAgreementTemplateFromFile(String path,
			AgreementLanguage lang) {
		String content = Util.loadFile(path);
		return store.createAgreementTemplate(content, lang, this);
	}

	/**
	 * Creates an AgreementTemplate object from the template content provided.
	 * 
	 * @param content
	 *            The content of the template
	 * @return The AgreementTemplate object
	 * @see AgreementTemplate
	 */
	public AgreementTemplate createAgreementTemplate(String content) {
		AgreementLanguage lang = Config.getInstance().getDefaultInputFormat();
		return store.createAgreementTemplate(content, lang, this);
	}

	// Registration

	/**
	 * Register the provided AgreementTemplate in the store.
	 * 
	 * @param template
	 *            The AgreementTemplate to register
	 * @see Store
	 */
	public void registerTemplate(AgreementTemplate template) {
		store.register("template", template);
	}

	/**
	 * Register the provided AgreementOffer in the store.
	 * 
	 * @param offer
	 *            The AgreementOffer to register
	 * @see Store
	 */
	public void registerOffer(AgreementOffer offer) {
		store.register("offer", offer);
	}

	/**
	 * Register the provided Agreement in the store.
	 * 
	 * @param agreement
	 *            The Agreement to register
	 * @see Store
	 */
	public void registerAgreement(Agreement agreement) {
		store.register("agreement", agreement);
	}

	// Retrieve
	/**
	 * Retrieve an AgreementTemplate from the store.
	 * 
	 * @return The AgreementTemplate registered with the name "template"
	 */
	public AgreementTemplate getAgreementTemplate() {
		return store.getAgreementTemplate("template");
	}

	/**
	 * Retrieve an AgreementOffer from the store.
	 * 
	 * @return The AgreementOffer registered with the name "offer"
	 */
	public AgreementOffer getAgreementOffer() {
		return store.getAgreementOffer("offer");
	}

	/**
	 * Retrieve an Agreement from the store.
	 * 
	 * @return The Agreement registered with the name "agreement"
	 */
	public Agreement getAgreement() {
		return store.getAgreement("agreement");
	}

	// Operations

	public Boolean isValid(AgreementModel agreementModel) {
		Valid op = new Valid();
		op.analyze(agreementModel);
		return (Boolean) op.getResult().get("valid");
	}

	public OperationResponse isValidFullResponse(AgreementModel agreementModel) {
		Valid op = new Valid();
		op.analyze(agreementModel);
		return op.getResult();
	}
}
