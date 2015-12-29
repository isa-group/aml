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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */
public class ParserJSONUtil {

    public static Iterable<Field> getFieldsUpTo(Class<?> startClass) {
        List<Field> currentClassFields = new ArrayList(Arrays.asList(startClass.getDeclaredFields()));
        Class<?> parentClass = startClass.getSuperclass();
        if (parentClass != null) {
            List<Field> parentClassFields = (List<Field>) getFieldsUpTo(parentClass);
            currentClassFields.addAll(parentClassFields);
        }
        return currentClassFields;
    }

}
