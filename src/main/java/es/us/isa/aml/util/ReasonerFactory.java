package es.us.isa.aml.util;

import es.us.isa.aml.operations.reasoners.CSPWebReasoner;
import es.us.isa.aml.operations.reasoners.ChocoReasoner;
import es.us.isa.aml.operations.reasoners.CplexReasoner;
import es.us.isa.aml.operations.reasoners.Reasoner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AntonioGamez
 */
public class ReasonerFactory {

    public static Reasoner createCSPReasoner() {
        ReasonerType type = ReasonerType.valueOf(Config.getProperty("CSPReasoner"));
        switch (type) {
            case CHOCO:
                return new ChocoReasoner();
            case CPLEX:
                return new CplexReasoner();
            case CSPWebReasoner:
                return new CSPWebReasoner();
            default:
                throw new IllegalArgumentException("there is no reasoner for this type: " + type);
        }
    }

    public static Reasoner createDLReasoner() {
        ReasonerType type = ReasonerType.valueOf(Config.getProperty("DLReasoner"));
        switch (type) {
            default:
                throw new IllegalArgumentException("there is no reasoner for this type: " + type);
        }
    }

    private ReasonerFactory() {
    }

}
