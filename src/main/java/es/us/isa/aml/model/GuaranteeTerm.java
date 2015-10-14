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
package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class GuaranteeTerm extends AgreementElement implements
        Comparable<GuaranteeTerm> {

    private Role role;
    private SLO slo;
    private String serviceScope;
    private QualifyingCondition qc;
    private List<Compensation> compensations = new ArrayList<>();

    public GuaranteeTerm(String id) {
        super(id);
    }

    public GuaranteeTerm(String id, Role actor, SLO slo) {
        super(id);
        this.role = actor;
        this.slo = slo;
    }

    public GuaranteeTerm(String id, Role actor, SLO slo,
            QualifyingCondition qc, List<Compensation> compensations,
            String serviceScope) {
        super(id);
        this.role = actor;
        this.slo = slo;
        this.serviceScope = serviceScope;
        this.qc = qc;
        this.compensations = compensations;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role actor) {
        this.role = actor;
    }

    public SLO getSlo() {
        return this.slo;
    }

    public void setSlo(SLO slo) {
        this.slo = slo;
    }

    public String getServiceScope() {
        return serviceScope;
    }

    public void setServiceScope(String serviceScope) {
        this.serviceScope = serviceScope;
    }

    public QualifyingCondition getQc() {
        return qc;
    }

    public void setQc(QualifyingCondition qc) {
        this.qc = qc;
    }

    public List<Compensation> getCompensations() {
        return compensations;
    }

    public void setCompensations(List<Compensation> compensations) {
        this.compensations = compensations;
    }

    @Override
    public int compareTo(GuaranteeTerm o) {
        return getId().compareTo(o.getId());
    }
    
    @Override
    public GuaranteeTerm clone() {
    	GuaranteeTerm gt = new GuaranteeTerm(id);
    	gt.setRole(role);
    	gt.setServiceScope(serviceScope);
    	gt.setSlo(slo.clone());
    	if(qc != null)
    		gt.setQc(qc.clone());
    	return gt;
    }
}
