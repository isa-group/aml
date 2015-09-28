package es.us.isa.aml.test.full;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.test.full.operations.TestExistDeadTerms;
import es.us.isa.aml.test.full.operations.TestExistInconsistencies;
import es.us.isa.aml.test.full.operations.TestOperation;

/**
 * @author jdelafuente
 *
 */
public class AMLTesterConfig {

	List<String> valid_extensions = new ArrayList<String>();
	String test_result_file;
	String metrics_folder;
	List<DirOp> directories = new ArrayList<AMLTesterConfig.DirOp>();

	/**
	 * @return the valid_extensions
	 */
	public List<String> getValid_extensions() {
		return valid_extensions;
	}

	/**
	 * @param valid_extensions
	 *            the valid_extensions to set
	 */
	public void setValid_extensions(List<String> valid_extensions) {
		this.valid_extensions = valid_extensions;
	}

	/**
	 * @return the test_result_file
	 */
	public String getTest_result_file() {
		return test_result_file;
	}

	/**
	 * @param test_result_file
	 *            the test_result_file to set
	 */
	public void setTest_result_file(String test_result_file) {
		this.test_result_file = test_result_file;
	}

	/**
	 * @return the metrics_folder
	 */
	public String getMetrics_folder() {
		return metrics_folder;
	}

	/**
	 * @param metrics_folder
	 *            the metrics_folder to set
	 */
	public void setMetrics_folder(String metrics_folder) {
		this.metrics_folder = metrics_folder;
	}

	/**
	 * @return the directories
	 */
	public List<DirOp> getDirectories() {
		return directories;
	}

	/**
	 * @param directories
	 *            the directories to set
	 */
	public void setDirectories(List<DirOp> directories) {
		this.directories = directories;
	}

	public class DirOp {
		String id;
		String operation;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the operation
		 */
		public String getOperation() {
			return operation;
		}

		/**
		 * @param operation
		 *            the operation to set
		 */
		public void setOperation(String operation) {
			this.operation = operation;
		}
	}

	/**
	 * @param path
	 * @return the testOperation
	 */
	public TestOperation getOperationFromPath(String path) {
		TestOperation op = null;
		for (DirOp dirOp : directories) {
			if (path.contains(dirOp.getId())) {
				switch (dirOp.operation) {
				case "existInconsistencies":
					op = new TestExistInconsistencies();
					break;
				case "existDeadTerms":
					op = new TestExistDeadTerms();
					break;
				// TODO solve areCompliant operation
				// case "areCompliant":
				// op = new TestAreCompliant();
				// break;
				}
			}
		}
		return op;
	}

}
