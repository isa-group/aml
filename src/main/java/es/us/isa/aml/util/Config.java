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

import java.io.InputStream;

import com.google.gson.Gson;

/**
 * Sets the configuration properties.
 *
 * @author jdelafuente
 *
 */
public class Config {

    protected final static String DEFAULT_CONFIG = "defaultConfig.json";

    private static Config instance = null;

    public AgreementLanguage defaultInputFormat;
    public ReasonerType CSPReasoner;
    public String CSPWebReasonerEndpoint;
    public String DLReasoner;
    public Boolean ANDConstraintsBreaking;
    public GeneratorType AgreementGenerator;

    public static Config getInstance() {
        if (instance == null) {
            load();
        }
        return instance;
    }

    public static void load() {
        InputStream in = Config.class.getResourceAsStream("/" + DEFAULT_CONFIG);
        String config = Util.getStringFromInputStream(in);
        load(config);
    }

    public static void load(String jsonConfig) {
        instance = new Gson().fromJson(jsonConfig, Config.class);
    }

    public Config() {
        defaultInputFormat = AgreementLanguage.IAGREE;
        CSPReasoner = ReasonerType.CSPWebReasoner;
        CSPWebReasonerEndpoint = "http://150.214.188.130:8080/CSPWebReasoner";
        DLReasoner = "NONE";
        ANDConstraintsBreaking = true;
        AgreementGenerator = GeneratorType.BASIC;
    }

    /**
     * @return the defaultInputFormat
     */
    public AgreementLanguage getDefaultInputFormat() {
        return defaultInputFormat;
    }

    /**
     * @param defaultInputFormat the defaultInputFormat to set
     */
    public void setDefaultInputFormat(AgreementLanguage defaultInputFormat) {
        this.defaultInputFormat = defaultInputFormat;
    }

    /**
     * @return the cSPReasoner
     */
    public ReasonerType getCSPReasoner() {
        return CSPReasoner;
    }

    /**
     * @param cSPReasoner the cSPReasoner to set
     */
    public void setCSPReasoner(ReasonerType cSPReasoner) {
        CSPReasoner = cSPReasoner;
    }

    /**
     * @return the cSPWebReasonerEndpoint
     */
    public String getCSPWebReasonerEndpoint() {
        return CSPWebReasonerEndpoint;
    }

    /**
     * @param cSPWebReasonerEndpoint the cSPWebReasonerEndpoint to set
     */
    public void setCSPWebReasonerEndpoint(String cSPWebReasonerEndpoint) {
        CSPWebReasonerEndpoint = cSPWebReasonerEndpoint;
    }

    /**
     * @return the dLReasoner
     */
    public String getDLReasoner() {
        return DLReasoner;
    }

    /**
     * @param dLReasoner the dLReasoner to set
     */
    public void setDLReasoner(String dLReasoner) {
        DLReasoner = dLReasoner;
    }

    /**
     * @return the aNDConstraintsBreaking
     */
    public Boolean getANDConstraintsBreaking() {
        return ANDConstraintsBreaking;
    }

    /**
     * @param aNDConstraintsBreaking the aNDConstraintsBreaking to set
     */
    public void setANDConstraintsBreaking(Boolean aNDConstraintsBreaking) {
        ANDConstraintsBreaking = aNDConstraintsBreaking;
    }

    /**
     * @return the agreementGenerator
     */
    public GeneratorType getAgreementGenerator() {
        return AgreementGenerator;
    }

    /**
     * @param agreementGenerator the agreementGenerator to set
     */
    public void setAgreementGenerator(GeneratorType agreementGenerator) {
        AgreementGenerator = agreementGenerator;
    }

}
