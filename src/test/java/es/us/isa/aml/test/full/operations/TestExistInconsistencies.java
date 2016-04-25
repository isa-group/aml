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
package es.us.isa.aml.test.full.operations;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.test.full.AMLTester;
import es.us.isa.aml.test.full.AMLTester.Status;

/**
 * @author jdelafuente
 *
 */
public class TestExistInconsistencies implements TestOperation {

    private static final Logger LOG = Logger
            .getLogger(TestExistInconsistencies.class.getName());

    @Override
    public int[] execute(AgreementModel model, File currentFile,
            String expectedResult, StringBuilder log) {
        String timeStamp = new SimpleDateFormat("(" + AMLTester.DATE_FORMAT
                + ")").format(Calendar.getInstance().getTime());
        StringBuilder sb = new StringBuilder(timeStamp + " ");

        Boolean expected_result = Boolean.valueOf(expectedResult);
        int[] results = new int[3];
        ExistInconsistencies incons_op = new ExistInconsistencies();
        incons_op.analyze(model);

        Boolean consistent = false;

        if (incons_op.getResult().getExistInconsistencies() != null) {
            consistent = !incons_op.getResult().getExistInconsistencies();

            if (consistent.equals(expected_result)) {
                sb.append(Status.PASSED).append(" ").append(currentFile.getPath()).append(" (Result: ").append(consistent).append(", Expected: ").append(expected_result).append(")");
                results[0] = 1;
            } else {
                sb.append(Status.NOT_PASSED).append(" ").append(currentFile.getPath()).append(" (Result: ").append(consistent).append(", Expected: ").append(expected_result).append(")");
                results[1] = 1;
            }

            log.append(sb.toString()).append("\n");

        } else {
            LOG.log(Level.SEVERE, "FAILED: " + currentFile.getAbsolutePath());
            sb.append(Status.FAILED).append(" ").append(currentFile.getPath());
            log.append(sb.toString()).append("\n");
            results[2] = 1;
            System.exit(0);
        }

        return results;
    }

    @Override
    public int[] execute(AgreementModel model, AgreementModel model2,
            File currentFile, String expectedResult, StringBuilder log) {
        return execute(model, currentFile, expectedResult, log);
    }
}
