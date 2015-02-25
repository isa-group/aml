/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.subsystems.AnalyzerService;
import isa.us.es.aml.subsystems.DocumentService;
import isa.us.es.aml.util.AgreementLanguage;
import isa.us.es.aml.util.AgreementFile;

/**
 *
 * @author AntonioGamez
 */
public class AgreementService {

    private final DocumentService documentService;
    private final AnalyzerService analyzerService;

    public AgreementService() {
        documentService = new DocumentService();
        analyzerService = new AnalyzerService();
    }

//   Start agreement files and model management
    protected DocumentService getDocumentService() {
        return documentService;
    }

    public void addTemplateFile(String template, AgreementLanguage lang) {
        addAgreementFile("template", template, lang);
    }

    public void addOfferFile(String offer, AgreementLanguage lang) {
        addAgreementFile("offer", offer, lang);
    }

    public AgreementModel getTemplateModel() {
        return getAgreementModel("template");
    }

    public AgreementModel getOfferModel() {
        return getAgreementModel("offer");
    }

    public void addAgreementFile(String name, String content, AgreementLanguage lang) {
        AgreementFile file = new AgreementFile(content, lang);
        documentService.addAgreementFile(name, file);
    }

    public AgreementModel getAgreementModel(String name) {
        return documentService.getAgreementModel(name);
    }

//   End agreement files and model management
//   Start agreement operations management
    public Boolean isConsistentTemplate() {
        return isConsistent("template");
    }

    public Boolean isConsistentOffer() {
        return isConsistent("offer");
    }

    public Boolean isConsistent(String name) {
        return analyzerService.existCondInconsTerms(getAgreementModel(name));
    }

//   End agreement operations management
}
