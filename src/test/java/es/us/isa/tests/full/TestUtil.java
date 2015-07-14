/**
 * 
 */
package es.us.isa.tests.full;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import es.us.isa.aml.translator.IBuilder;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.translator.builders.wsag.WSAGBuilder;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class TestUtil {

	private static final Logger LOG = Logger
			.getLogger(TestUtil.class.getName());

	public static AMLTesterConfig loadConf(String aml_config,
			String aml_test_config) {
		AMLTesterConfig CONFIG = null;
		try {
			InputStream in = new FileInputStream(aml_config);
			String config = Util.getStringFromInputStream(in);
			Config.loadConfig(config);

			InputStream in2 = new FileInputStream(aml_test_config);
			String json = Util.getStringFromInputStream(in2);
			CONFIG = new Gson().fromJson(json, AMLTesterConfig.class);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		
		return CONFIG;
	}

	public static IBuilder getBuilderFromLanguage(AgreementLanguage dst_lang) {
		switch (dst_lang) {
		case IAGREE:
			return new IAgreeBuilder();
		case WSAG:
			return new WSAGBuilder();
		case OPL:
			return new CSPBuilder();
		case LUSDL:
			throw new UnsupportedOperationException("LUSDL builder not found");
		}
		return null;
	}

	public static String getExtensionFromLanguage(AgreementLanguage dst_lang,
			DocType docType) {
		String ext = "";
		switch (dst_lang) {
		case IAGREE:
			if (docType == DocType.TEMPLATE)
				ext = "at";
			else if (docType == DocType.OFFER)
				ext = "ao";
			else if (docType == DocType.AGREEMENT)
				ext = "ag";
			break;
		case WSAG:
			ext = "wsag";
			break;
		case OPL:
			ext = "opl";
			break;
		case LUSDL:
			ext = "ttl";
			break;
		}
		return ext;
	}

	public static AgreementLanguage getLanguageFromExtension(File file) {
		int index = file.getName().lastIndexOf(".");
		String ext = file.getName().substring(index + 1);
		switch (ext) {
		case "at":
		case "ao":
		case "ag":
			return AgreementLanguage.IAGREE;
		case "wsag":
			return AgreementLanguage.WSAG;
		case "opl":
			return AgreementLanguage.OPL;
		case "ttl":
			return AgreementLanguage.LUSDL;
		}
		return null;
	}

	public static Boolean isValidExtension(File file, AMLTesterConfig CONFIG) {
		int index = file.getName().lastIndexOf(".");
		String ext = file.getName().substring(index + 1);
		return CONFIG.getValid_extensions().contains(ext);
	}
}
