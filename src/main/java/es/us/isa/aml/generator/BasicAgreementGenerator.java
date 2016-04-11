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
package es.us.isa.aml.generator;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.RoleType;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class BasicAgreementGenerator extends AgreementGenerator {

    @Override
    public AgreementOffer generateAgreementOfferFromTemplate(String consumerName, AgreementTemplate template) {
        AgreementOffer ao = new AgreementOffer();
        ao.setDocType(DocType.OFFER);
        ao.setID(template.getID() + "_" + consumerName);
        ao.setVersion(template.getVersion());
        ao.setContext(template.getContext().clone());
        ao.getContext().setTemplateId(template.getID());
        ao.getContext().setTemplateVersion(template.getVersion());
        ao.getContext().setInitiator(new Actor(consumerName, Role.Consumer, RoleType.Initiator));
        ao.setAgreementTerms(template.getAgreementTerms().clone());
        return ao;
    }
    
    @Override
    public AgreementOffer generateAgreementOfferFromTemplate(AgreementTemplate template, String consumerName, String variableName, String variableValue) {
        AgreementOffer offer = null;
        for (Map.Entry<String, CreationConstraint> ccEntry : template.getCreationConstraints().entrySet()) {
            if (null == ccEntry.getValue().getQc() || !ccEntry.getValue().getQc().getCondition().toString().contains("==")) {
                continue;
            }
            AgreementTemplate generatedTemplate = template.clone();
            generatedTemplate.getCreationConstraints().clear();
            generatedTemplate.setID(template.getID().concat("_").concat(ccEntry.getKey()));
            String QCText = ccEntry.getValue().getQc().getCondition().toString().replaceAll("\\s", "");
            String QCPropertyName = QCText.split("==")[0];
            String QCPropertyValue = Util.withoutDoubleQuotes(QCText.split("==")[1]);

            if (QCPropertyName.equalsIgnoreCase((variableName)) && QCPropertyValue.equalsIgnoreCase(variableValue)) {
                for (Expression e : Expression.splitANDExpressions(ccEntry.getValue().getSlo().getExpression())) {
                    String SLOText = e.toString().replaceAll("\\s", "");
                    String SLOPropertyName = SLOText.split("==")[0];
                    String SLOPropertyValue = SLOText.split("==")[1];
                    
                    for (Map.Entry<String, ConfigurationProperty> cpEntry : generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().entrySet()) {
                        String servicePropertyName = cpEntry.getKey();
                        if (servicePropertyName.equalsIgnoreCase(SLOPropertyName)) {
                            ConfigurationProperty newCp = new ConfigurationProperty(cpEntry.getValue().getId(), cpEntry.getValue().getMetric(), Expression.parse(SLOPropertyValue), cpEntry.getValue().getScope(), cpEntry.getValue().getFeature());
                            generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().put(servicePropertyName, newCp);
                        } else if (servicePropertyName.equalsIgnoreCase(QCPropertyName)) {
                            ConfigurationProperty newCp = new ConfigurationProperty(cpEntry.getValue().getId(), cpEntry.getValue().getMetric(), Expression.parse(QCPropertyValue), cpEntry.getValue().getScope(), cpEntry.getValue().getFeature());
                            generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().put(servicePropertyName, newCp);
                        }
                    }
                    generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().get("MaxResponseTime").getExpression();
                }
                offer = generateAgreementOfferFromTemplate(consumerName, generatedTemplate);
            }
        }
        return offer;
    }
    
    @Override
    public Agreement generateAgreementFromAgreementOffer(AgreementOffer offer) {
        Agreement ag = new Agreement();
        ag.setDocType(DocType.AGREEMENT);
        ag.setID(offer.getID() + "_ag");
        ag.setVersion(offer.getVersion());
        ag.setContext(offer.getContext().clone());
        ag.setAgreementTerms(offer.getAgreementTerms().clone());
        return ag;
    }

    @Override
    public Agreement generateAgreementFromAgreementOffer(String consumerName, AgreementOffer offer) {
        Agreement ag = new Agreement();
        ag.setDocType(DocType.AGREEMENT);
        ag.setID(offer.getID() + "_" + consumerName + "_ag");
        ag.setVersion(offer.getVersion());
        ag.setContext(offer.getContext().clone());
        ag.getContext().setInitiator(new Actor(consumerName, Role.Consumer, RoleType.Initiator));
        ag.setAgreementTerms(offer.getAgreementTerms().clone());
        return ag;
    }

    public Agreement generateAgreementFromCompliantAgreementOffer(String consumerName, AgreementOffer offer, AgreementTemplate template) {
        Agreement ag = new Agreement();
        AreCompliant op = new AreCompliant();
        op.analyze(template, offer);
        if ((Boolean) op.getResult().get("compliant")) {
            ag.setDocType(DocType.AGREEMENT);
            ag.setID(offer.getID() + "_" + consumerName + "_ag");
            ag.setVersion(offer.getVersion());
            ag.setContext(offer.getContext().clone());
            ag.getContext().setInitiator(new Actor(consumerName, Role.Consumer, RoleType.Initiator));
            ag.setAgreementTerms(offer.getAgreementTerms().clone());
            return ag;
        } else {
            throw new IllegalArgumentException("AgreementOffer must be compliant with the AgreementTemplated passed");
        }
    }
}
