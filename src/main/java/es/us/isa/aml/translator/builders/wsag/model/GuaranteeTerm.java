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
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.util.Util;

/**
 * One motivation for creating a service agreement between a service provider
 * and a service consumer is to provide assurance to the service consumer on the
 * service quality and/or resource availability offered by the service provider.
 * Guarantee terms define this assurance on service quality, associated with the
 * service described by the service definition terms.
 *
 * @author jdelafuente
 *
 */
public class GuaranteeTerm {

    /**
     * The MANDATORY name attribute (of type String) represents the name given
     * to a guarantee. Since an Agreement MAY encompass multiple GuaranteeTerms
     * each term SHOULD be given a unique name.
     */
    private String name;

    /**
     * This attribute defines, which party enters the obligation to the
     * guarantee term. The ServiceRole can be either ServiceConsumer or
     * ServiceProvider.
     */
    private ServiceRole obligated;

    /**
     * A guarantee term can have one or more service scopes. A service scope
     * describes to what service element specifically a guarantee term applies.
     * For example, a performance guarantee might only apply to one operation of
     * a Web service at a particular end point.
     *
     * If a guarantee term applies to multiple services, a set of service scopes
     * MUST be defined.
     */
    private ServiceScope serviceScope;

    /**
     * This element MAY appear in order to express a precondition under which a
     * guarantee holds.
     */
    private QualifyingCondition qualifyingCondition;

    /**
     * This element expresses the condition that must be met to satisfy the
     * guarantee.
     */
    private ServiceLevelObjective slo;

    /**
     * This is the higher level element that contains a list of business value
     * elements associated with a service level objective.
     */
    private BusinessValueList bvl;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the obligated
     */
    public ServiceRole getObligated() {
        return obligated;
    }

    /**
     * @param obligated the obligated to set
     */
    public void setObligated(ServiceRole obligated) {
        this.obligated = obligated;
    }

    /**
     * @return the serviceScope
     */
    public ServiceScope getServiceScope() {
        return serviceScope;
    }

    /**
     * @param serviceScope the serviceScope to set
     */
    public void setServiceScope(ServiceScope serviceScope) {
        this.serviceScope = serviceScope;
    }

    /**
     * @return the qualifyingCondition
     */
    public QualifyingCondition getQualifyingCondition() {
        return qualifyingCondition;
    }

    /**
     * @param qualifyingCondition the qualifyingCondition to set
     */
    public void setQualifyingCondition(QualifyingCondition qualifyingCondition) {
        this.qualifyingCondition = qualifyingCondition;
    }

    /**
     * @return the slo
     */
    public ServiceLevelObjective getSlo() {
        return slo;
    }

    /**
     * @param slo the slo to set
     */
    public void setSlo(ServiceLevelObjective slo) {
        this.slo = slo;
    }

    /**
     * @return the bvl
     */
    public BusinessValueList getBvl() {
        return bvl;
    }

    /**
     * @param bvl the bvl to set
     */
    public void setBvl(BusinessValueList bvl) {
        this.bvl = bvl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t\t" + "<wsag:GuaranteeTerm wsag:Obligated=\"").append(getObligated()).append("\" wsag:Name=\"").append(getName()).append("\">").append("\n");

        if (getQualifyingCondition() != null) {
            sb.append("\t\t\t\t" + "<wsag:QualifyingCondition>").append("\n");
            sb.append("\t\t\t\t\t").append(Util.encodeEntities(getQualifyingCondition().getCondition().toString()))
                    .append("\n");
            sb.append("\t\t\t\t" + "</wsag:QualifyingCondition>").append("\n");
        }

        sb.append("\t\t\t\t" + "<wsag:ServiceLevelObjective>").append("\n");
        sb.append("\t\t\t\t\t" + "<wsag:CustomServiceLevel>");
        if (getSlo().getCustomServiceLevel() != null) {
        	Expression exp = getSlo().getCustomServiceLevel().getExpression();
            sb.append(Util.encodeEntities(exp.toString()));
        }
        sb.append("</wsag:CustomServiceLevel>").append("\n");
        sb.append("\t\t\t\t" + "</wsag:ServiceLevelObjective>").append("\n");

        sb.append("\t\t\t" + "</wsag:GuaranteeTerm>");

        return sb.toString();

    }

}
