/**
 * *****************************************************************************
 * AML is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * AML is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015 Licensed under GPL
 * (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */
package es.us.isa.aml.parsers.agreements;


import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.yaml.ParserYAMLUtil;
import es.us.isa.aml.util.AgreementLanguage;
import java.io.File;
/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */
public class YamlParser extends AgreementParser {

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
