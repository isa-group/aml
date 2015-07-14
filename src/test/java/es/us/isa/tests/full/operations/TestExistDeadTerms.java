/**
 * 
 */
package es.us.isa.tests.full.operations;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.noCore.ExistDeadTermsOp;
import es.us.isa.tests.full.AMLTester;
import es.us.isa.tests.full.AMLTester.Status;

/**
 * @author jdelafuente
 *
 */
public class TestExistDeadTerms implements TestOperation {

	private static final Logger LOG = Logger.getLogger(TestExistDeadTerms.class
			.getName());

	@SuppressWarnings("unchecked")
	@Override
	public int[] execute(AgreementModel model, File currentFile,
			String expectedResult, StringBuilder log) {

		int[] results = new int[3];
		ExistDeadTermsOp dt_op = new ExistDeadTermsOp();
		dt_op.analyze(model);

		String timeStamp = new SimpleDateFormat("(" + AMLTester.DATE_FORMAT
				+ ")").format(Calendar.getInstance().getTime());
		StringBuilder sb = new StringBuilder(timeStamp + " ");

		Boolean deadterms = false;
		List<String> result = new ArrayList<String>();

		if (dt_op.getResult().get("existDeadTerms") != null) {
			deadterms = (Boolean) dt_op.getResult().get("existDeadTerms");
			if (deadterms) {
				result = (List<String>) dt_op.getResult().get(
						"conflicts_deadterms");
			} else {
				result.add("NULL");
			}

			Boolean passed = false;
			for (String res : result) {
				if (res.equals(expectedResult)) {
					sb.append(Status.PASSED + " " + currentFile.getPath()
							+ " (Result: " + result + ", Expected: "
							+ expectedResult + ")");
					results[0] = 1;
					passed = true;
				}
			}

			if (!passed) {
				sb.append(Status.NOT_PASSED + " " + currentFile.getPath()
						+ " (Result: " + result + ", Expected: "
						+ expectedResult + ")");
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
