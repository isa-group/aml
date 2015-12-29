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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.parsers.agreements.json.InterfaceAdapterExpression;
import es.us.isa.aml.parsers.agreements.json.InterfaceAdapterModel;
import es.us.isa.aml.util.AgreementLanguage;

import java.io.File;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */
public class JsonParser extends AgreementParser {

    @Override
    public AgreementModel doParse(String content) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Expression.class, new InterfaceAdapterExpression()).registerTypeAdapter(AgreementModel.class, new InterfaceAdapterModel()).create();
        AgreementModel mod = gson.fromJson(content, AgreementModel.class);
        return mod;
    }

    @Override
    public AgreementModel doParse(String content, File[] metrics) {
        return doParse(content);
    }

    @Override
    public AgreementLanguage getSupportedLang() {
        return AgreementLanguage.JSON;
    }

    public String parserToJson(AgreementModel agr) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().registerTypeAdapter(Expression.class, new InterfaceAdapterExpression()).registerTypeAdapter(AgreementModel.class, new InterfaceAdapterModel()).setPrettyPrinting().create();
        return gson.toJson(agr);
    }

}
