/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.noCore;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
//import isa.us.es.aml.operations.newClasses.core.ChocoExistDeadTermsCOp;
//import isa.us.es.aml.operations.newClasses.core.ExistInconsistenciesCOp;
//import isa.us.es.aml.operations.newClasses.core.ExistLudicrousTermsCOp;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author AntonioGamez
 */
public class ExistCondInconsTermsOp extends NoCoreOperation {

    CoreOperation existInconsistenciesCOp;
    CoreOperation existDeadTermsCOp;
    CoreOperation existLudicrousTermsCOp;

    public ExistCondInconsTermsOp() {
        this.coreOperations = new HashSet<>();

//        existInconsistenciesCOp = new ExistInconsistenciesCOp();
//        existDeadTermsCOp = new ChocoExistDeadTermsCOp();
//        existLudicrousTermsCOp = new ExistLudicrousTermsCOp();

        coreOperations.add(existInconsistenciesCOp);
        coreOperations.add(existDeadTermsCOp);
        coreOperations.add(existLudicrousTermsCOp);
    }

    @Override
    public void analyze(AgreementModel agreementModel) throws AssertionError {
        checkReasonerExistence(); // throws AssertionError if no reasoners have been provided

        existInconsistenciesCOp.analyze(agreementModel);
        existDeadTermsCOp.analyze(agreementModel);
        existLudicrousTermsCOp.analyze(agreementModel);

        setResult(new Random().nextBoolean());
        //todo: do something with these results

    }

    @Override
    public Boolean getResult() {
        return (Boolean) super.getResult();
    }
    


}
