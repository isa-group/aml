/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.core.csp;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 *
 * @author AntonioGamez
 */
public class ExistInconsistenciesOp extends CoreOperation {

    public ExistInconsistenciesOp() {
        this.reasoner = ReasonerFactory.createCSPReasoner();
    }

    public void analyze(AgreementModel agModel) {
        
    	// AgreementModel conversion a CSPModel
        
    	Translator t = new Translator(new CSPBuilder());
    	CSPModel model = (CSPModel) t.translate(agModel);
        Boolean solve = this.reasoner.solve(model);
        result.put("existInconsistencies", !solve);
        
        OperationResponse res = reasoner.explain(model);
        result.putAll(res);  
        
        // ... negar todas las expresiones del CSPModel ...
        // foreach(i) { 
        //	model.getConstraint(i).expression.negate()
        //  }
        // ... mode.add(agModel2)
        // ... 
        // reasoner.solve(model);
    }

    @Override
    public OperationResponse getResult() {
        return this.result;
    }
}
