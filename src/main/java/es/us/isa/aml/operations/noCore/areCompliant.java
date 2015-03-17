/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.util.OperationResponse;

/**
 *
 * @author AntonioGamez
 */
public class areCompliant extends NoCoreOperation {

    // private final CoreOperation algunaCoreOperation;
    private final Boolean res = true;

    public areCompliant() {
        //this.algunaCoreOperation = ;
    }

    public void analyze(AgreementTemplate template) {
        //In the case of templates, an additional condition is that the terms be compliant with the creation constraints.
        //areCompliant(T.CCs,T.Terms)
    }

    public void analyze(AgreementTemplate template, AgreementOffer offer) {
        //In the case of offer with a referenced template T, 
        //the strong compliance notion of iAgree forces to check if there exists compliance between D and T. 
        //This can be expressed as:
        //areCompliant(T.GTerms, O.Terms) ^ areCompliant(T.CCs, O.Terms)
    }

    @Override
    public OperationResponse getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
