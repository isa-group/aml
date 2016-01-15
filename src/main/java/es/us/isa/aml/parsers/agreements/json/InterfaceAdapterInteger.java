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

package es.us.isa.aml.parsers.agreements.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */

public class InterfaceAdapterInteger implements JsonSerializer<Integer>, JsonDeserializer<Integer>{

        private static final Logger LOGGER = Logger.getLogger(InterfaceAdapterModel.class.getName());

    @Override
    public JsonElement serialize(Integer t, Type type, JsonSerializationContext jsc) {
        return new JsonPrimitive(t.toString());
    }

    @Override
    public Integer deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        return je.getAsInt();
    }

}