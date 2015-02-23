/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.util;

/**
 *
 * @author Antonio
 */
public class SLAFile {

    private String content;
    private AgreementLanguage lang;

    public SLAFile(String content, AgreementLanguage lang) {
        this.content = content;
        this.lang = lang;
    }

    public SLAFile() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AgreementLanguage getLang() {
        return lang;
    }

    public void setLang(AgreementLanguage lang) {
        this.lang = lang;
    }

}
