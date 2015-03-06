/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.core;

import es.us.isa.aml.operations.reasoners.Reasoner;
import es.us.isa.aml.util.OperationResponse;

/**
 *
 * @author AntonioGamez
 */
public abstract class CoreOperation {

    protected OperationResponse result = new OperationResponse();
    protected Reasoner reasoner;

    public abstract OperationResponse getResult();
}
