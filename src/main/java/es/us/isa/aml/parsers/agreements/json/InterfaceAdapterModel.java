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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.Range;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */
public class InterfaceAdapterModel implements JsonDeserializer<AgreementModel> {

    private static final Logger LOGGER = Logger.getLogger(InterfaceAdapterModel.class.getName());

    @Override
    public AgreementModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = json.getAsJsonObject();
            Map metrics = new HashMap();
            if (jsonObject.get("context").getAsJsonObject().get("metrics") != null) {
                for (Entry<String, JsonElement> jse : jsonObject.get("context").getAsJsonObject().get("metrics").getAsJsonObject().entrySet()) {
                    Metric met = gson.fromJson(jse.getValue(), Metric.class);
                    if (jse.getValue().getAsJsonObject().get("domain").getAsJsonObject().get("max") != null) {
                        Range d1 = gson.fromJson(jse.getValue().getAsJsonObject().get("domain"), es.us.isa.aml.model.Range.class);
                        met.setDomain(d1);
                    }
                    if (jse.getValue().getAsJsonObject().get("domain").getAsJsonObject().get("values") != null) {
                        Enumerated d1 = gson.fromJson(jse.getValue().getAsJsonObject().get("domain"), es.us.isa.aml.model.Enumerated.class);
                        met.setDomain(d1);
                    }
                    metrics.put(met.getId(), met);
                }
            }
            switch (jsonObject.get("docType").getAsString()) {
                case "TEMPLATE":
                    AgreementTemplate agt = context.deserialize(json, Class.forName("es.us.isa.aml.model.AgreementTemplate"));
                    agt.getContext().setMetrics(metrics);
                    return agt;
                case "OFFER":
                    AgreementOffer ago = context.deserialize(json, Class.forName("es.us.isa.aml.model.AgreementOffer"));
                    ago.getContext().setMetrics(metrics);
                    return ago;
                case "AGREEMENT":
                    Agreement ag = context.deserialize(json, Class.forName("es.us.isa.aml.model.Agreement"));
                    ag.getContext().setMetrics(metrics);
                    return ag;
                default:
                    return null;
            }
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

}
