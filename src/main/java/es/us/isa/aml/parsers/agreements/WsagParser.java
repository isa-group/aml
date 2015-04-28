/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.wsag.WsagParserHelper;
import es.us.isa.aml.util.AgreementLanguage;

/**
 * @author jdelafuente
 *
 */
public class WsagParser implements AgreementParser {

    private static final Logger LOG = Logger.getLogger(WsagParser.class.getName());

    @Override
	public AgreementModel doParse(String content) {
		return doParse(content, null);
	}
    
    @Override
    public AgreementModel doParse(String content, File[] metrics) {
        AgreementModel model = null;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(content)));
            doc.getDocumentElement().normalize();
            WsagParserHelper helper = new WsagParserHelper(doc, metrics);
            model = helper.getModel();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOG.log(Level.WARNING, null, e);
        }

        return model;
    }

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.WSAG;
    }

}
