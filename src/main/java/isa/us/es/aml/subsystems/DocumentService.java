/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.subsystems;

import isa.us.es.aml.parsers.ParserProxy;
import isa.us.es.aml.util.SLAFile;
import isa.us.es.aml.parsers.Parser;
import isa.us.es.aml.slamodel.AgreementModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Antonio
 */
public class DocumentService {

    private Map<String, SLAFile> SLAFileMap;
    private Map<String, AgreementModel> SLAModelMap;
    private Boolean isParsed;

    public DocumentService() {
        SLAFileMap = new HashMap<>();
        SLAFileMap = new HashMap<>();
        isParsed = false;
    }

    public Map<String, SLAFile> getSLAFileMap() {
        return SLAFileMap;
    }

    public Map<String, AgreementModel> getSLAModelMap() {
        return SLAModelMap;
    }

    public AgreementModel getSLAModel(String name) {
        if (!isParsed) {
            parseSLAFileMap();
        }
        return SLAModelMap.get(name);
    }

    public void addSLAFile(String key, SLAFile file) {
        isParsed = false;
        SLAFileMap.put(key, file);
    }

    public void deleteSLAFile(String key) {
        isParsed = false;
        SLAFileMap.remove(key);

    }

    public void parseSLAFileMap() {
        isParsed = true;
        for(Entry<String,SLAFile> entry: SLAFileMap.entrySet()){
            SLAFile slaFile = entry.getValue();
            Parser parser = ParserProxy.createParser(slaFile.getLang());
            AgreementModel slaModel = parser.doParse(slaFile);
            SLAModelMap.put(entry.getKey(), slaModel);
        }    }

    // todo: parsear file independientemente, no solo el mapa.
    // todo: revisar todo
}
