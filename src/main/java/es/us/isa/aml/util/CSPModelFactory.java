package es.us.isa.aml.util;

import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.translator.builders.choco.model.ChocoModel;

/**
 *
 * @author AntonioGamez
 */
public class CSPModelFactory {

    public static CSPModel createCSPModel() {
        ReasonerType type = ReasonerType.valueOf((String) Config.getProperty("CSPReasoner"));
        switch (type) {
            case CHOCO:
                return new ChocoModel();
            case CPLEX:
                return new CSPModel();
            case CSPWebReasoner:
                throw new UnsupportedOperationException("Not supported yet");
                //todo
            default:
                throw new IllegalArgumentException("there is no CSPModel for this type: " + type);
        }
    }


    private CSPModelFactory() {
    }

}
