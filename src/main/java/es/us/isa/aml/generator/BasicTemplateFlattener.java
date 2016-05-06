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

import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.expression.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author AntonioGamez
 *
 */
public class BasicTemplateFlattener extends TemplateFlattener {

    @Override
    public List<AgreementTemplate> flattenMultiplanTemplate(AgreementTemplate template) {
        List<AgreementTemplate> templates = new ArrayList<>();
        for (Entry<String, CreationConstraint> ccEntry : template.getCreationConstraints().entrySet()) {
            if (null == ccEntry.getValue().getQc() || !ccEntry.getValue().getQc().getCondition().toString().contains("==")) {
                continue;
            }
            AgreementTemplate generatedTemplate = template.clone();
            generatedTemplate.getCreationConstraints().clear();
            generatedTemplate.setID(template.getID().concat("_").concat(ccEntry.getKey()));
            String QCText = ccEntry.getValue().getQc().getCondition().toString().replaceAll("\\s", "");
            String QCPropertyName = QCText.split("==")[0];
            String QCPropertyValue = QCText.split("==")[1];
            for (Expression e : Expression.splitANDExpressions(ccEntry.getValue().getSlo().getExpression())) {
                String SLOText = e.toString().replaceAll("\\s", "");
                String SLOPropertyName = SLOText.split("==")[0];
                String SLOPropertyValue = SLOText.split("==")[1];
                for (Entry<String, ConfigurationProperty> cpEntry : generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().entrySet()) {
                    String servicePropertyName = cpEntry.getKey();
                    if (servicePropertyName.equalsIgnoreCase(SLOPropertyName)) {
                        ConfigurationProperty newCp = new ConfigurationProperty(cpEntry.getValue().getId(), cpEntry.getValue().getMetric(), Expression.parse(SLOPropertyValue), cpEntry.getValue().getScope(), cpEntry.getValue().getFeature());
                        generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().put(servicePropertyName, newCp);
                    } else if (servicePropertyName.equalsIgnoreCase(QCPropertyName)) {
                        ConfigurationProperty newCp = new ConfigurationProperty(cpEntry.getValue().getId(), cpEntry.getValue().getMetric(), Expression.parse(QCPropertyValue), cpEntry.getValue().getScope(), cpEntry.getValue().getFeature());
                        generatedTemplate.getAgreementTerms().getService().getConfigurationProperties().put(servicePropertyName, newCp);
                    }
                }
            }
            templates.add(generatedTemplate);
        }
        return templates;
    }

}
