/**
 * 
 */
package es.us.isa.tests.full.operations;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.util.DocType;
import es.us.isa.tests.full.AMLTester;
import es.us.isa.tests.full.AMLTester.Status;

/**
 * @author jdelafuente
 *
 */
public class TestAreCompliant implements TestOperation {

	private static final Logger LOG = Logger.getLogger(TestAreCompliant.class
			.getName());

	@Override
	public int[] execute(AgreementModel model, AgreementModel model2,
			File currentFile, String expectedResult, StringBuilder log) {

		int[] results = new int[3];
		AreCompliant compliance_op = new AreCompliant();

		String timeStamp = new SimpleDateFormat("(" + AMLTester.DATE_FORMAT
				+ ")").format(Calendar.getInstance().getTime());
		StringBuilder sb = new StringBuilder(timeStamp + " ");

		if (model.getDocType() == DocType.TEMPLATE)
			compliance_op.analyze(model, model2);
		else
			compliance_op.analyze(model2, model);

		Boolean expected_result = Boolean.valueOf(expectedResult);
		Boolean compliant = false;

		if (compliance_op.getResult().get("compliant") != null) {
			compliant = (Boolean) compliance_op.getResult().get("compliant");

			if (compliant == expected_result) {
				sb.append(Status.PASSED + " " + currentFile.getPath()
						+ " (Result: " + compliant + ", Expected: "
						+ expected_result + ")");
				results[0] = 1;
			} else {
				sb.append(Status.NOT_PASSED + " " + currentFile.getPath()
						+ " (Result: " + compliant + ", Expected: "
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
	public int[] execute(AgreementModel model, File currentFile,
			String expectedResult, StringBuilder log) {
		throw new UnsupportedOperationException();
	}

}
