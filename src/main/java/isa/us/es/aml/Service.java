/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml;

import isa.us.es.aml.util.SLAFile;
import isa.us.es.aml.slamodel.AgreementModel;
import isa.us.es.aml.subsystems.DocumentService;
import isa.us.es.aml.util.AgreementLanguage;

/**
 *
 * @author Antonio
 */
public class Service {

    private final DocumentService adaDocumentService;

    public Service() {
        adaDocumentService = new DocumentService();
    }

    protected DocumentService getAdaDocumentService() {
        return adaDocumentService;
    }

    public void addTemplate(String template, AgreementLanguage lang) {
        addSLAFile("template", template, lang);
    }

    public void addOffer(String offer, AgreementLanguage lang) {
        addSLAFile("template", offer, lang);
    }

    public AgreementModel getTemplateModel() {
        return getSLAModel("template");
    }

    public AgreementModel getOfferModel() {
        return getSLAModel("offer");
    }

    public void addSLAFile(String name, String content, AgreementLanguage lang) {
        SLAFile file = new SLAFile(content, lang);
        adaDocumentService.addSLAFile(name, file);
    }

    public AgreementModel getSLAModel(String name) {
        return adaDocumentService.getSLAModel(name);
    }

}
