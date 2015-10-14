/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.translator.builders.wsag.model;

/**
 * @author jdelafuente
 *
 */
public class Agreement extends Document {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding = \"UTF-8\"?>").append("\n");
        sb.append("<wsag:Agreement wsag:AgreementId=\"").append(getId()).append("\"").append("\n")
                .append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"").append("\n")
                .append("xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\"").append("\n")
                .append("xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"").append("\n")
                .append("xmlns:iag=\"http://www.isa.us.es/schemas/iagree\"").append("\n")
                .append("xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\"").append("\n")
                .append("agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\">").append("\n");
        sb.append("\t" + "<wsag:Name>").append(getName()).append("</wsag:Name>").append("\n");
        sb.append(getContext().toString());
        sb.append(getTerms().toString());
        sb.append("</wsag:Agreement>");

        return sb.toString();
    }

}
