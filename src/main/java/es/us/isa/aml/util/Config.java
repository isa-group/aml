package es.us.isa.aml.util;

import java.io.File;
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

	public String defaultInputFormat;
	public String CSPReasoner;
	public String CSPWebReasonerEndpoint;
	public String DLReasoner;
	public Boolean ANDConstraintsBreaking;

	public static Config getInstance() {
		if (instance == null) {
			Gson gson = new Gson();
			InputStream in = Config.class.getResourceAsStream(File.separator
					+ DEFAULT_CONFIG);
			String config = Util.getStringFromInputStream(in);
			instance = gson.fromJson(config, Config.class);
		}
		return instance;
	}

	public static void load(Config conf) {
		if (instance == null) {
			instance = conf;
		}
	}

	public Config() {
		defaultInputFormat = "IAGREE";
		CSPReasoner = "CPLEX";
		CSPWebReasonerEndpoint = "http://150.214.188.130:8080/CSPWebReasoner";
		DLReasoner = "none";
		ANDConstraintsBreaking = true;
	}

	/**
	 * @return the defaultInputFormat
	 */
	public String getDefaultInputFormat() {
		return defaultInputFormat;
	}

	/**
	 * @param defaultInputFormat
	 *            the defaultInputFormat to set
	 */
	public void setDefaultInputFormat(String defaultInputFormat) {
		this.defaultInputFormat = defaultInputFormat;
	}

	/**
	 * @return the cSPReasoner
	 */
	public String getCSPReasoner() {
		return CSPReasoner;
	}

	/**
	 * @param cSPReasoner
	 *            the cSPReasoner to set
	 */
	public void setCSPReasoner(String cSPReasoner) {
		CSPReasoner = cSPReasoner;
	}

	/**
	 * @return the cSPWebReasonerEndpoint
	 */
	public String getCSPWebReasonerEndpoint() {
		return CSPWebReasonerEndpoint;
	}

	/**
	 * @param cSPWebReasonerEndpoint
	 *            the cSPWebReasonerEndpoint to set
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
	 * @param dLReasoner
	 *            the dLReasoner to set
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
	 * @param aNDConstraintsBreaking
	 *            the aNDConstraintsBreaking to set
	 */
	public void setANDConstraintsBreaking(Boolean aNDConstraintsBreaking) {
		ANDConstraintsBreaking = aNDConstraintsBreaking;
	}

}
