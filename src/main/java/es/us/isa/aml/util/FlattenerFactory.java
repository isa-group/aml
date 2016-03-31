/**
 * *****************************************************************************
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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 ******************************************************************************
 */
package es.us.isa.aml.util;

import es.us.isa.aml.generator.BasicTemplateFlattener;
import es.us.isa.aml.generator.TemplateFlattener;

/**
 * Provides a generator according to the configuration property:
 * AgreementGenerator.
 *
 * @author AntonioGamez
 *
 */
public class FlattenerFactory {

    public static TemplateFlattener createFlattener() {
        FlattenerType type = Config.getInstance().getTemplateFlattener();
        switch (type) {
            case BASIC:
                return new BasicTemplateFlattener();
            default:
                throw new IllegalArgumentException("there is no generator for this type: " + type);
        }
    }
}
