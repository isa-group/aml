/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml;

import isa.us.es.aml.util.AgreementLanguage;

/**
 *
 * @author Antonio
 */
public class mainTest {

    public static void main(String[] args) {

        Service serv = new Service();
        String SLA = "algoQueVieneDeOtroLado";

        serv.addTemplate(SLA, AgreementLanguage.IAGREE);
        //serv.getTemplateModel();

        //serv.isConsistent()
    }
}
