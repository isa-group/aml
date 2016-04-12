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
package es.us.isa.aml.operations.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the information of an operation response.
 *
 * @author jdelafuente
 *
 */
public class OperationResult {

    private Boolean existInconsistencies;
    private Boolean existDeadTerms;
    private Boolean existCondInconsTerms;
    private Boolean compliant;
    private String explaining;
    private String conflictType;
    private List<String> conflicts = new ArrayList<>();
    private List<String> affectedTerms = new ArrayList<>();
    private String error = new String();

    public Boolean isValid() {
        if (error.isEmpty() && existInconsistencies != null && existDeadTerms != null && existCondInconsTerms != null) {
            return !existInconsistencies && !existDeadTerms && !existCondInconsTerms;
        } else {
            return false;
        }
    }

    public Boolean getExistInconsistencies() {
        return existInconsistencies;
    }

    public void setExistInconsistencies(Boolean existInconsistencies) {
        this.existInconsistencies = existInconsistencies;
    }

    public Boolean getExistDeadTerms() {
        return existDeadTerms;
    }

    public void setExistDeadTerms(Boolean existDeadTerms) {
        this.existDeadTerms = existDeadTerms;
    }

    public Boolean getExistCondInconsTerms() {
        return existCondInconsTerms;
    }

    public void setExistCondInconsTerms(Boolean existCondInconsTerms) {
        this.existCondInconsTerms = existCondInconsTerms;
    }

    public Boolean getCompliant() {
        return compliant;
    }

    public void setCompliant(Boolean compliant) {
        this.compliant = compliant;
    }

    public String getExplaining() {
        return explaining;
    }

    public void setExplaining(String explaining) {
        this.explaining = explaining;
    }

    public String getConflictType() {
        return conflictType;
    }

    public void setConflictType(String conflictType) {
        this.conflictType = conflictType;
    }

    public List<String> getConflicts() {
        return conflicts;
    }

    public void setConflicts(List<String> conflicts) {
        this.conflicts = conflicts;
    }

    public List<String> getAffectedTerms() {
        return affectedTerms;
    }

    public void setAffectedTerms(List<String> affectedTerms) {
        this.affectedTerms = affectedTerms;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean hasErrors() {
        return !error.isEmpty();
    }

    @Override
    public String toString() {
        return "OperationResult{" + "existInconsistencies=" + existInconsistencies + ", existDeadTerms=" + existDeadTerms + ", existCondInconsTerms=" + existCondInconsTerms + ", compliant=" + compliant + ", explaining=" + explaining + ", conflicts=" + conflicts + ", error=" + error + '}';
    }
}
