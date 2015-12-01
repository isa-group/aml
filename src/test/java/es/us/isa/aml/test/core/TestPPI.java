/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.test.core;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class TestPPI {

    private static AgreementManager service;
    private static AgreementModel model;

    @BeforeClass
    public static void init() {
        service = new AgreementManager();
        model = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/novo.at");
    }

    @Test
    public void testCreation1() {
        AgreementManager m = new AgreementManager();
        Translator t = new Translator(new IAgreeBuilder());
        System.out.println(t.translate(model));
        Assert.assertNotNull(model.getProperty("Time2").getDefinitionReference());

        List<Entry<String, Number>> listaA = new LinkedList();
        Entry<String, Number> par = new AbstractMap.SimpleEntry<String, Number>("Requests", 9);
        listaA.add(par);
        Assert.assertEquals(model.evaluateGTByValues("RequestTerm", listaA), true);

        List<Entry<String, Number>> listaB = new LinkedList();
        Entry<String, Number> par2 = new AbstractMap.SimpleEntry<String, Number>("Requests", 11);
        listaB.add(par2);
        Assert.assertEquals(model.evaluateGTByValues("RequestTerm", listaB), false);

    }
}
