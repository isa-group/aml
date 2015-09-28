/**
 * 
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
public class TestExplainInconsistencies implements TestOperation {

	private static final Logger LOG = Logger
			.getLogger(TestExplainInconsistencies.class.getName());

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

		if (incons_op.getResult().get("existInconsistencies") != null) {
			consistent = !(Boolean) incons_op.getResult().get(
					"existInconsistencies");

			if (consistent == expected_result) {
				sb.append(Status.PASSED + " " + currentFile.getPath()
						+ " (Result: " + consistent + ", Expected: "
						+ expected_result + ")");
				results[0] = 1;
			} else {
				sb.append(Status.NOT_PASSED + " " + currentFile.getPath()
						+ " (Result: " + consistent + ", Expected: "
						+ expected_result + ")");
				results[1] = 1;
			}

			log.append(sb.toString()).append("\n");

		} else {
			LOG.log(Level.SEVERE, "FAILED: " + currentFile.getAbsolutePath());
			sb.append(Status.FAILED + " " + currentFile.getPath());
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
