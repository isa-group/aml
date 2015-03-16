/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements;

import java.io.IOException;
import java.io.StringReader;

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

    @Override
    public AgreementModel doParse(String content) {
    	
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory
				.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(
					content)));
			doc.getDocumentElement().normalize();
			WsagParserHelper helper = new WsagParserHelper(doc);
			
			System.out.println(helper.getContext());
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
    }

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.WSAG;
    }

}
