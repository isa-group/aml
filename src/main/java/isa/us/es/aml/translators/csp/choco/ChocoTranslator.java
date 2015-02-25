/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.translators.csp.choco;

import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import isa.us.es.aml.model.AgreementElement;
import isa.us.es.aml.translators.csp.CoreTranslator;
import java.util.Map;

/**
 *
 * @author AntonioGamez
 */
public abstract class ChocoTranslator extends CoreTranslator {

    public abstract Map<String, Variable> getChocoVars();

    public abstract Map<AgreementElement, Constraint> getChocoConstraints();
}
