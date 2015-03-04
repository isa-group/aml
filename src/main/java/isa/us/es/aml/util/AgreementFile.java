/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.util;

/**
 *
 * @author AntonioGamez
 */
public class AgreementFile {

    private String content;
    private AgreementLanguage lang;

    public AgreementFile(String content, AgreementLanguage lang) {
        this.content = content;
        this.lang = lang;
    }

    public AgreementFile() {
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AgreementLanguage getLang() {
        return this.lang;
    }

    public void setLang(AgreementLanguage lang) {
        this.lang = lang;
    }

}
