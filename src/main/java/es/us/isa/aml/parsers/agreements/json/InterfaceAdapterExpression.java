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
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import es.us.isa.aml.model.expression.ArithmeticExpression;
import es.us.isa.aml.model.expression.ArithmeticOperator;
import es.us.isa.aml.model.expression.AssignmentExpression;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.DuringExpression;
//import es.us.isa.aml.model.expression.DuringExpression;
//import es.us.isa.aml.model.expression.FrecuencyExpression;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.FrecuencyExpression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */
public class InterfaceAdapterExpression implements JsonSerializer<Expression>, JsonDeserializer<Expression> {

    private static final Logger LOGGER = Logger.getLogger(InterfaceAdapterExpression.class.getName());

    @Override
    public JsonElement serialize(Expression src, Type typeOfSrc, JsonSerializationContext context) {
        return serializeInternalExprssion(src, context);

    }

    @Override
    public Expression deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return deserializeInternal(json, context);
    }

    private JsonElement serializeInternalExprssion(Expression src, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        JsonObject result2 = new JsonObject();
        Gson gson = new Gson();
        for (java.lang.reflect.Field f : ParserJSONUtil.getFieldsUpTo(src.getClass())) {
            String className = f.getType().getSimpleName();
            if (!className.equals("Logger")) {
                if (className.equals("Expression")) {
                    try {
                        f.setAccessible(true);
                        if (f.get(src) != null) {
                            result2.add(f.getName(), serializeInternalExprssion((Expression) f.get(src), context));
                        }
                        f.setAccessible(false);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        LOGGER.log(Level.SEVERE, e.getMessage());
                    }
                } else {
                    try {
                        f.setAccessible(true);
                        if (f.get(src) != null) {
                            result2.add(f.getName(), gson.toJsonTree(f.get(src), f.get(src).getClass()));
                        }
                        f.setAccessible(false);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        LOGGER.log(Level.SEVERE, e.getMessage());
                    }
                }
            }
        }
        result.add("_type", gson.toJsonTree(src.getClass().getSimpleName()));
        result.add("properties", result2);
        return result;

    }

    private Expression deserializeInternal(JsonElement json, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("_type").getAsString();
        JsonElement element = jsonObject.get("properties");
        Gson gson = new Gson();
        try {
            switch (type) {
                case "DuringExpression":
                    DuringExpression exp = context.deserialize(element, Class.forName("es.us.isa.aml.model.expression." + type));
                    exp.setState(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("state"), context));
                    exp.setNum(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("num"), context));
                    return exp;
                case "FrecuencyExpression":
                    FrecuencyExpression exp2 = context.deserialize(element, Class.forName("es.us.isa.aml.model.expression." + type));
                    exp2.setState(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("state"), context));
                    exp2.setNtimes(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("ntimes"), context));
                    return exp2;
                case "Atomic":
                    return new Atomic(jsonObject.get("properties").getAsJsonObject().get("value").getAsNumber());
                case "Var":
                    return new Var(jsonObject.get("properties").getAsJsonObject().get("id").getAsString());
                case "ArithmeticExpression":
                    Expression ae1 = deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp1"), context);
                    Expression ae2 = deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp2"), context);
                    ArithmeticOperator ao = gson.fromJson(jsonObject.get("properties").getAsJsonObject().get("operator"), ArithmeticOperator.class);
                    ArithmeticExpression expA = new ArithmeticExpression(ae1, ae2, ao);
                    return expA;
                case "AssignmentExpression":
                    AssignmentExpression expAss = context.deserialize(element, Class.forName("es.us.isa.aml.model.expression." + type));
                    expAss.setExpression1(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp1"), context));
                    expAss.setExpression2(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp2"), context));
                    return expAss;
                case "LogicalExpression":
                    Expression le1 = deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp1"), context);
                    Expression le2 = deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp2"), context);
                    LogicalOperator lo = gson.fromJson(jsonObject.get("properties").getAsJsonObject().get("operator"), LogicalOperator.class);
                    LogicalExpression expL = new LogicalExpression(le1, le2, lo);
                    return expL;
                case "RelationalExpression":
                    Expression re1 = deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp1"), context);
                    Expression re2 = deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp2"), context);
                    RelationalOperator ro = gson.fromJson(jsonObject.get("properties").getAsJsonObject().get("operator"), RelationalOperator.class);
                    RelationalExpression expR = new RelationalExpression(re1, re2, ro);
                    return expR;

                case "ParenthesisExpression":
                    ParenthesisExpression expP = context.deserialize(element, Class.forName("es.us.isa.aml.model.expression." + type));
                    expP.setExpression(deserializeInternal(jsonObject.get("properties").getAsJsonObject().get("exp"), context));
                    return expP;
                default:
                    return context.deserialize(element, Class.forName("es.us.isa.aml.model.expression." + type));
            }
        } catch (ClassNotFoundException cnfe) {
            LOGGER.log(Level.SEVERE, cnfe.getMessage());
            throw new JsonParseException("Unknown element type: " + type, cnfe);

        }
    }

}
