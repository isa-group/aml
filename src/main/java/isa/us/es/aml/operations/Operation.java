/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations;

import isa.us.es.aml.model.AgreementModel;

public interface Operation {

    public void analyze(AgreementModel agreementModel);

    public Object getResult();

}
