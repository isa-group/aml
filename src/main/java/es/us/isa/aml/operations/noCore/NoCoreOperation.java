/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.util.OperationResponse;

/**
 *
 * @author AntonioGamez
 */
public abstract class NoCoreOperation {

    protected OperationResponse result = new OperationResponse();

    public abstract OperationResponse getResult();

}
