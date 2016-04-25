/**
 * *****************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 ******************************************************************************
 */
package es.us.isa.aml.util;

import es.us.isa.aml.reasoners.cspwebreasoner.CSPWebReasoner;
import es.us.isa.aml.reasoners.ChocoReasoner;
import es.us.isa.aml.reasoners.Reasoner;

/**
 * Provides a reasoner according to the configuration property: CSPReasoner.
 *
 * @author jdelafuente
 *
 */
public class ReasonerFactory {

    public static Reasoner createCSPReasoner() {
        ReasonerType type = Config.getInstance().getCSPReasoner();
        switch (type) {
            case CHOCO:
                return new ChocoReasoner();
            case CSPWebReasoner:
                return new CSPWebReasoner();
            default:
                throw new IllegalArgumentException(
                        "there is no reasoner for this type: " + type);
        }
    }

    public static Reasoner createDLReasoner() {
        ReasonerType type = ReasonerType.valueOf(Config.getInstance()
                .getDLReasoner());
        switch (type) {
            default:
                throw new IllegalArgumentException(
                        "there is no reasoner for this type: " + type);
        }
    }

    private ReasonerFactory() {
    }

}
