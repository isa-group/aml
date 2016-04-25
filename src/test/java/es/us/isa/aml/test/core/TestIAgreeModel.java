/**
 * *****************************************************************************
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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */
package es.us.isa.aml.test.core;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.AgreementTerms;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Feature;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.ResourceProperty;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.Scope;
import es.us.isa.aml.model.ServiceConfiguration;
import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.translator.builders.iagree.model.IAgreeAgreementOffer;
import es.us.isa.aml.util.Util;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 * @author jdelafuente
 *
 */
public class TestIAgreeModel {

    private static AgreementManager manager;
    private static AgreementModel model, modelResources, modelDefReference;
    private static AgreementTemplate multiplanTemplate;

    @BeforeClass
    public static void init() {
        manager = new AgreementManager();
        model = manager.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");
        modelResources = manager.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-resources.at");
        modelDefReference = manager.createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-defref.at");
        multiplanTemplate = manager.createAgreementTemplateFromFile("src/test/resources/core-pack/multiplan.at");
    }

    /**
     * Parse a document and retrieve the model. Then, compare each model element
     * with a new one of the same type from a given model. <br>
     * <br>
     * Lifecycle: <br>
     * Document 1 - Model 1 - Element 1 <br>
     * Model 2 - Element 2 <br>
     * Element 1 vs Element 2
     */
    @Test
    public void testModel() {
        // Asserts ID y Version
        assertEquals(model.getID(), "IAgreeCore");
        assertEquals(model.getVersion(), 1.0f, 0.0);

        // Asserts actors
        assertEquals(model.getContext().getResponder().getRole(), Role.Provider);
        assertEquals(model.getContext().getInitiator().getRole(), Role.Consumer);

        // Metrics
        Metric met1 = new Metric("met1", "integer", new Range(0, 23));
        Metric met2 = new Metric("met2", "integer", new Range(0, 512));
        Metric met3 = new Metric("met3", "float", new Range(0, 128));

        // Asserts metrics
        assertEquals(model.getContext().getMetrics().get(met1.getId()), met1);
        assertEquals(model.getContext().getMetrics().get(met2.getId()), met2);
        assertEquals(model.getContext().getMetrics().get(met3.getId()), met3);

        // Agreement Terms
        AgreementTerms at = new AgreementTerms();

        // Service reference
        ServiceConfiguration service = new ServiceConfiguration();
        service.setServiceName("TTS");
        service.setEndpointReference("test.template.com/service");
        at.setService(service);

        // Configuration properties
        ConfigurationProperty ConfProp1 = new ConfigurationProperty("ConfProp1", met1);
        ConfProp1.setExpression(new Atomic(9));
        ConfProp1.setScope(Scope.Global);
        at.getService().getConfigurationProperties().put(ConfProp1.getId(), ConfProp1);
        
        ConfigurationProperty ConfProp3 = new ConfigurationProperty("ConfProp3", new Metric("string", "string", new Domain()));
        ConfProp3.setExpression(new Atomic("1a2B3c4D"));
        ConfProp3.setScope(Scope.Global);
        at.getService().getConfigurationProperties().put(ConfProp3.getId(), ConfProp3);
        
        assertEquals(model.getAgreementTerms().getService().getConfigurationProperties().get(ConfProp1.getId()), ConfProp1);
        assertEquals(model.getAgreementTerms().getService().getConfigurationProperties().get(ConfProp3.getId()), ConfProp3);

        // Monitorable properties
        MonitorableProperty MonitProp1 = new MonitorableProperty("MonitProp1", met2);
        MonitProp1.setScope(Scope.Global);
        at.getMonitorableProperties().put(MonitProp1.getId(), MonitProp1);

        MonitorableProperty MonitProp2 = new MonitorableProperty("MonitProp2", met3);
        MonitProp2.setScope(Scope.Local);
        MonitProp2.setFeature(new Feature("testFeature1"));
        at.getMonitorableProperties().put(MonitProp2.getId(), MonitProp2);
        
        assertEquals(model.getAgreementTerms().getMonitorableProperties().get(MonitProp1.getId()), MonitProp1);
        assertEquals(model.getAgreementTerms().getMonitorableProperties().get(MonitProp2.getId()), MonitProp2);

        // Guarantee terms
        Expression exp = new RelationalExpression(new Var(MonitProp1), new Atomic(64), RelationalOperator.LTE);
        SLO slo = new SLO(exp);
        GuaranteeTerm g1 = new GuaranteeTerm("G1", Role.Provider, slo);

        Expression exp2 = new RelationalExpression(new Var(MonitProp2), new Atomic(256), RelationalOperator.LT);
        SLO slo2 = new SLO(exp2);
        GuaranteeTerm g2 = new GuaranteeTerm("G2", Role.Consumer, slo2);

        at.getGuaranteeTerms().put(g1.getId(), g1);
        at.getGuaranteeTerms().put(g2.getId(), g2);

        // Asserts Agreement Terms
        assertEquals(model.getAgreementTerms().getService().getConfigurationProperties().get("ConfProp1"), at.getService().getConfigurationProperties().get("ConfProp1"));
        assertEquals(model.getAgreementTerms().getMonitorableProperties().get("MonitProp1"), at.getMonitorableProperties().get("MonitProp1"));
        assertEquals(model.getAgreementTerms().getGuaranteeTerms(), at.getGuaranteeTerms());

        // Creation constraints
        Expression e = new ArithmeticExpression(new Var(MonitProp1), new Atomic(2), ArithmeticOperator.MULTIPLY);
        Expression exp3 = new RelationalExpression(new Var(ConfProp1), e, RelationalOperator.EQ);
        SLO slo3 = new SLO(exp3);
        CreationConstraint cc = new CreationConstraint("C1", slo3);

        // Assert Creation Constraint
        assertEquals(((AgreementTemplate) model).getCreationConstraints().get(cc.getId()), cc);
    }

    /**
     * Parse a document and retrieve the model. Then, compare each model element
     * with a new one of the same type from a given model. <br>
     * <br>
     * Lifecycle: <br>
     * Document 1 - Model 1 - Element 1 <br>
     * Model 2 - Element 2 <br>
     * Element 1 vs Element 2
     */
    @Test
    public void testModelResourcesExtension() {
        // Asserts ID y Version
        assertEquals(modelResources.getID(), "ResearchPlanT");
        assertEquals(modelResources.getVersion(), 1.0f, 0.0);

        // Asserts actors
        assertEquals(modelResources.getContext().getResponder().getRole(), Role.Provider);
        assertEquals(modelResources.getContext().getInitiator().getRole(), Role.Consumer);

        // Metrics
        Metric met1 = new Metric("num", "integer", new Range(0, 100));
        Metric met2 = new Metric("boolean", "Boolean", new Enumerated(new Object[]{true, false}));

        // Asserts metrics
        assertEquals(modelResources.getContext().getMetrics().get(met1.getId()), met1);

        // Agreement Terms
        AgreementTerms at = new AgreementTerms();

        // Service reference
        ServiceConfiguration service = new ServiceConfiguration();
        service.setServiceName("Research");
        service.setEndpointReference("www.isa.us.es/people/pablo.fernandez");
        at.setService(service);

        // Configuration properties
        ConfigurationProperty ConfProp1 = new ConfigurationProperty(
                "Seniority", met1);
        ConfProp1.setScope(Scope.Global);
        ConfProp1.setExpression(new Atomic(12));
        at.getService().getConfigurationProperties().put(ConfProp1.getId(), ConfProp1);

        ConfigurationProperty ConfProp2 = new ConfigurationProperty("phd", met2);
        ConfProp2.setScope(Scope.Global);
        ConfProp2.setExpression(new Atomic(true));
        at.getService().getConfigurationProperties().put(ConfProp2.getId(), ConfProp2);

        // Monitorable properties
        ResourceProperty MonitProp1 = new ResourceProperty("papers");
        MonitProp1.setScope(Scope.Global);
        at.getMonitorableProperties().put(MonitProp1.getId(), MonitProp1);

        ResourceProperty MonitProp2 = new ResourceProperty("conferences");
        MonitProp2.setScope(Scope.Global);
        at.getMonitorableProperties().put(MonitProp2.getId(), MonitProp2);

        // Guarantee terms
        Expression exp = Expression.parse("papers in acceptance > 3 monthly");
        SLO slo = new SLO(exp);
        GuaranteeTerm gt = new GuaranteeTerm("G1", Role.Provider, slo);
        at.getGuaranteeTerms().put(gt.getId(), gt);

        exp = Expression.parse("papers in revision by 10 second");
        slo = new SLO(exp);
        gt = new GuaranteeTerm("G2", Role.Provider, slo);
        at.getGuaranteeTerms().put(gt.getId(), gt);

        exp = Expression.parse("conferences in acceptance > 1 minutely");
        slo = new SLO(exp);
        gt = new GuaranteeTerm("G3", Role.Provider, slo);
        at.getGuaranteeTerms().put(gt.getId(), gt);

        exp = Expression.parse("conferences in revision by 1 minute");
        slo = new SLO(exp);
        gt = new GuaranteeTerm("G4", Role.Provider, slo);
        at.getGuaranteeTerms().put(gt.getId(), gt);

        // Asserts Agreement Terms
        assertEquals(modelResources.getAgreementTerms().getService().getConfigurationProperties().get("Seniority"), at.getService().getConfigurationProperties().get("Seniority"));
        assertEquals(modelResources.getAgreementTerms().getMonitorableProperties().get("papers"), at.getMonitorableProperties().get("papers"));
        assertEquals(modelResources.getAgreementTerms().getGuaranteeTerms(), at.getGuaranteeTerms());
    }

    @Test
    public void testDefinitionReference() {
        Assert.assertNotNull(modelDefReference.getProperty("Time2").getDefinitionReference());
    }

    @Test
    public void testTemplateFlattener() {
        List<AgreementTemplate> templateList = multiplanTemplate.flattenTemplate();
        for (AgreementTemplate template : templateList) {
            for (Map.Entry<String, CreationConstraint> ccEntry : template.getCreationConstraints().entrySet()) {
                if (null == ccEntry.getValue().getQc() || !ccEntry.getValue().getQc().getCondition().toString().contains("==")) {
                    continue;
                }
                for (Expression e : Expression.splitANDExpressions(ccEntry.getValue().getSlo().getExpression())) {
                    String SLOText = e.toString().replaceAll("\\s", "");
                    String SLOPropertyName = SLOText.split("==")[0];
                    String SLOPropertyValue = SLOText.split("==")[1].replaceAll("\"", "");
                    for (Map.Entry<String, ConfigurationProperty> cpEntry : template.getAgreementTerms().getService().getConfigurationProperties().entrySet()) {
                        String servicePropertyName = cpEntry.getKey();
                        if (servicePropertyName.equalsIgnoreCase(SLOPropertyName)) {
                            assertEquals(template.getAgreementTerms().getService().getConfigurationProperties().get(servicePropertyName).toString(), Expression.parse(SLOPropertyValue).toString());
                            break;
                        }
                    }
                }
            }
        }
    }

    @Test
    public void testGenerateOfferFromTemplate() {
        AgreementOffer offer = multiplanTemplate.generateAgreementOffer("Consumer", "PlanType", "pro");
        for (Map.Entry<String, CreationConstraint> ccEntry : multiplanTemplate.getCreationConstraints().entrySet()) {
            if (null == ccEntry.getValue().getQc() || !ccEntry.getValue().getQc().getCondition().toString().contains("==")) {
                continue;
            }
            String QCText = ccEntry.getValue().getQc().getCondition().toString().replaceAll("\\s", "");
            String QCPropertyName = QCText.split("==")[0];
            String QCPropertyValue = Util.withoutDoubleQuotes(QCText.split("==")[1]);
            if (QCPropertyName.equals("PlanType") && QCPropertyValue.equals("pro")) {
                for (Expression e : Expression.splitANDExpressions(ccEntry.getValue().getSlo().getExpression())) {
                    String SLOText = e.toString().replaceAll("\\s", "");
                    String SLOPropertyName = SLOText.split("==")[0];
                    String SLOPropertyValue = SLOText.split("==")[1].replaceAll("\"", "");
                    for (Map.Entry<String, ConfigurationProperty> cpEntry : offer.getAgreementTerms().getService().getConfigurationProperties().entrySet()) {
                        String servicePropertyName = cpEntry.getKey();
                        if (servicePropertyName.equalsIgnoreCase(SLOPropertyName)) {
                            assertEquals(offer.getAgreementTerms().getService().getConfigurationProperties().get(servicePropertyName).getValue(), SLOPropertyValue);
                            break;
                        }
                    }
                }
            }

        }
    }
}
