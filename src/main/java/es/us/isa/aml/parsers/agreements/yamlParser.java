/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.parsers.agreements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.parsers.agreements.json.InterfaceAdapterExpression;
import es.us.isa.aml.parsers.agreements.json.InterfaceAdapterModel;
import es.us.isa.aml.parsers.agreements.yaml.ParserYAMLUtil;
import es.us.isa.aml.util.AgreementLanguage;
import java.io.File;

/**
 *
 * @author Usuario
 */
public class yamlParser extends AgreementParser {

    @Override
    public AgreementModel doParse(String content) {
        String jsonContent = ParserYAMLUtil.convertToJson(content);
        JsonParser parser = new JsonParser();
        return parser.doParse(jsonContent);
    }

    @Override
    public AgreementModel doParse(String content, File[] metrics) {
        return doParse(content);
    }

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.YAML;
    }

    public String parserToYaml(AgreementModel agr) {
        JsonParser parser = new JsonParser();
        String jsonContent = parser.parserToJson(agr);
        return ParserYAMLUtil.convertToYaml(jsonContent);
    }

}
