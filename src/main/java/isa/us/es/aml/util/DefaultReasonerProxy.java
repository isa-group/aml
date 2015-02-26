package isa.us.es.aml.util;

import isa.us.es.aml.operations.reasoners.ChocoReasoner;
import isa.us.es.aml.operations.reasoners.Reasoner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AntonioGamez
 */
public class DefaultReasonerProxy {

    public DefaultReasonerProxy() {
    }

    public static Reasoner createReasoner(ReasonerEngineType type) {
        switch (type) {
            case CSP:
                return new ChocoReasoner();
            //return new OplReasoner();
            case DL:
                throw new UnsupportedOperationException("there is no reasoner yet for this entgine type" + type.toString());
            default:
                throw new IllegalArgumentException("there is no reasoner for this entgine type" + type.toString());
        }
    }

}
