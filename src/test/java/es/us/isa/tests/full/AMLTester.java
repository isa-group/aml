package es.us.isa.tests.full;

/**
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.Store;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;
import es.us.isa.tests.full.AMLTesterConfig.DirOp;
import es.us.isa.tests.full.operations.TestAreCompliant;
import es.us.isa.tests.full.operations.TestOperation;

/**
 * @author jdelafuente
 *
 */
public class AMLTester {

	// public static String DIR = "testpacks/raw-packs/ada-blackbox/wsag";
	public static String DIR = "testpacks/release-packs/pack-v0.1/wsag";
	public static String DEFAULT_ROOT_DIR = "src/test/resources";
	public static String DEFAULT_AML_CONFIG_PATH = "src/main/resources"
			+ "/defaultConfig.json";
	public static String DEFAULT_AML_TEST_CONFIG_PATH = "src/main/resources"
			+ "/defaultTestConfig.json";
	public static String DEFAULT_PREFIX_LOGFILE = "test_results_";

	public static String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static String LOGFILE_DATE_FORMAT = "dd-MM-yyyy_HH-mm-ss";

	public enum Status {
		PASSED, NOT_PASSED, NOT_SUPPORTED, FAILED
	}

	private static final Logger LOG = Logger.getLogger(AMLTester.class
			.getName());
	static AMLTesterConfig CONFIG = new AMLTesterConfig();

	private List<String> analyzed_files = new ArrayList<String>();

	public AMLTester() {
		new AMLTester(DIR, DEFAULT_AML_CONFIG_PATH,
				DEFAULT_AML_TEST_CONFIG_PATH);
	}

	public AMLTester(String dir) {
		new AMLTester(dir, DEFAULT_AML_CONFIG_PATH,
				DEFAULT_AML_TEST_CONFIG_PATH);
	}

	public AMLTester(String dir, String aml_config) {
		new AMLTester(dir, aml_config, DEFAULT_AML_TEST_CONFIG_PATH);
	}

	public AMLTester(String dir, String aml_config, String aml_test_config) {
		DIR = dir;
		CONFIG = TestUtil.loadConf(aml_config, aml_test_config);
	}

	public static void main(String[] args) {
		File currentDir = new File(DEFAULT_ROOT_DIR + File.separator + DIR);

		AMLTester tester = new AMLTester();
		// tester.convertFiles(currentDir, "opl", AgreementLanguage.OPL);
		tester.analyzeFiles(currentDir);
	}

	/*
	 * ANALYSIS METHODS
	 */

	public void analyzeFiles(File dir) {
		LOG.log(Level.INFO, "ANALYSING FILES...");
		long startTime = System.nanoTime();
		String timeStamp = new SimpleDateFormat(LOGFILE_DATE_FORMAT)
				.format(Calendar.getInstance().getTime());
		File log_file = new File(DEFAULT_PREFIX_LOGFILE + timeStamp + ".txt");
		File[] metrics = null;
		for (File f : dir.listFiles()) {
			if (f.isDirectory()
					&& f.getName().equals(CONFIG.getMetrics_folder())) {
				int size = f.listFiles().length;
				metrics = new File[size];
				for (int i = 0; i < size; i++) {
					metrics[i] = f.listFiles()[i];
				}
			}
		}

		try {
			log_file.createNewFile();
			StringBuilder log = new StringBuilder();
			PrintWriter out = new PrintWriter(log_file);

			Map<Status, Map<String, Integer>> results = analyzeFilesRecursively(
					dir, dir, dir, metrics, log);

			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			StringBuilder sb = new StringBuilder();
			int total = 0;
			for (Status status : Status.values()) {
				Map<String, Integer> dirs = results.get(status);
				int dir_total = 0;
				for (String currDir : dirs.keySet()) {
					dir_total += dirs.get(currDir);
				}
				sb.append(status + " (" + dir_total + ")").append("\n");
				for (String currDir : dirs.keySet()) {
					sb.append("\t").append(currDir + ": " + dirs.get(currDir))
							.append("\n");
				}
				sb.append("\n");
				total += dir_total;
			}
			LOG.log(Level.INFO, "ANALYSIS FINISHED (" + duration + "ms). "
					+ total + " files analyzed.");
			LOG.log(Level.INFO, sb.toString());
			LOG.log(Level.INFO, "See log file: " + log_file.getPath()
					+ " for more details.");

			out.println("ANALYSIS SUMMARY");
			out.println(total + " files analyzed in " + duration + "ms");
			out.println(sb.toString());
			out.println("DETAILS");
			out.println(log.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	private Map<Status, Map<String, Integer>> analyzeFilesRecursively(
			File currentDir, File rootDir, File mainDir, File[] metrics,
			StringBuilder log) {
		analyzed_files = new ArrayList<String>();
		Integer passed = 0, not_passed = 0, not_supported = 0, failed = 0;

		Map<Status, Map<String, Integer>> results = new HashMap<Status, Map<String, Integer>>();
		Map<String, Integer> passed_map = new HashMap<String, Integer>();
		Map<String, Integer> not_passed_map = new HashMap<String, Integer>();
		Map<String, Integer> not_supported_map = new HashMap<String, Integer>();
		Map<String, Integer> failed_map = new HashMap<String, Integer>();

		passed_map.put(mainDir.getName(), 0);
		not_passed_map.put(mainDir.getName(), 0);
		not_supported_map.put(mainDir.getName(), 0);
		failed_map.put(mainDir.getName(), 0);

		File[] files = currentDir.listFiles();

		Properties prop = new Properties();

		for (File currentFile : files) {
			try {
				if (currentFile.isFile()) {
					if (!analyzed_files.contains(currentFile.getName())) {

						if (prop.isEmpty()
								&& !currentDir.getName().equals(
										CONFIG.getMetrics_folder())) {
							for (File file_prop : files) {
								if (file_prop.isFile()
										&& file_prop.getName().equals(
												CONFIG.getTest_result_file())) {
									FileInputStream in = new FileInputStream(
											file_prop);
									prop.load(in);
									break;
								}
							}

							if (prop.isEmpty()) {
								LOG.log(Level.SEVERE,
										"CONFIGURATION FILE NOT FOUND. Please, provide a configuration file called \"config.json\" and place it at src/main/resources.");
							}

						}

						AgreementLanguage src_lang = TestUtil
								.getLanguageFromExtension(currentFile);

						if (TestUtil.isValidExtension(currentFile, CONFIG)) {
							FileInputStream in = new FileInputStream(
									currentFile);
							String content = Util.getStringFromInputStream(in);

							AgreementModel model = null;
							model = Store.getInstance().parseAgreementFile(
									content, metrics, src_lang);

							if (model != null) {
								TestOperation test_op = CONFIG
										.getOperationFromPath(currentFile
												.getPath());

								if (test_op != null) {
									String expectedResult = "";
									expectedResult = prop
											.getProperty(currentFile.getName());

									int[] stats = new int[3];

									if (test_op instanceof TestAreCompliant) {
										AgreementModel model2 = null;
										for (File file : files) {
											if (TestUtil.isValidExtension(file,
													CONFIG)
													&& file != currentFile) {
												FileInputStream in2 = new FileInputStream(
														file);
												String content2 = Util
														.getStringFromInputStream(in2);
												model2 = Store.getInstance()
														.parseAgreementFile(
																content2,
																metrics,
																src_lang);
												if (model.getDocType() == DocType.TEMPLATE) {
													if (model2.getDocType() == DocType.OFFER) {
														analyzed_files.add(file
																.getName());
														break;
													}

												} else {
													if (model2.getDocType() == DocType.TEMPLATE) {
														analyzed_files.add(file
																.getName());
														break;
													}
												}
											}
										}
										stats = test_op.execute(model, model2,
												currentFile, expectedResult,
												log);

									} else {
										stats = test_op.execute(model,
												currentFile, expectedResult,
												log);
									}

									passed += stats[0];
									not_passed += stats[1];
									failed += stats[2];

								} else {
									String timeStamp = new SimpleDateFormat("("
											+ DATE_FORMAT + ")")
											.format(Calendar.getInstance()
													.getTime());
									StringBuilder sb = new StringBuilder(
											timeStamp + " ");
									sb.append(Status.NOT_SUPPORTED + " "
											+ currentFile.getPath());
									log.append(sb.toString()).append("\n");
									not_supported++;
								}
							} else {
								String timeStamp = new SimpleDateFormat("("
										+ DATE_FORMAT + ")").format(Calendar
										.getInstance().getTime());
								StringBuilder sb = new StringBuilder(timeStamp
										+ " ");
								LOG.log(Level.SEVERE,
										"FAILED: "
												+ currentFile.getAbsolutePath());
								sb.append(Status.FAILED + " "
										+ currentFile.getPath());
								log.append(sb.toString()).append("\n");
								System.exit(0);
							}

							analyzed_files.add(currentFile.getName());
						}

						passed_map.put(mainDir.getName(), passed);
						not_passed_map.put(mainDir.getName(), not_passed);
						not_supported_map.put(mainDir.getName(), not_supported);
						failed_map.put(mainDir.getName(), failed);
					} else {
						String timeStamp = new SimpleDateFormat("("
								+ DATE_FORMAT + ")").format(Calendar
								.getInstance().getTime());
						StringBuilder sb = new StringBuilder(timeStamp + " ");
						sb.append("ALREADY ANALYZED" + " "
								+ currentFile.getPath());
						log.append(sb.toString()).append("\n");
					}
				} else {
					prop = null;

					for (DirOp _mainDir : CONFIG.getDirectories()) {
						if (currentFile.getName().equals(_mainDir.getId())) {
							mainDir = currentFile;
							// Main Directory
							passed_map.put(mainDir.getName(), 0);
							not_passed_map.put(mainDir.getName(), 0);
							not_supported_map.put(mainDir.getName(), 0);
							failed_map.put(mainDir.getName(), 0);
						}
					}

					Map<Status, Map<String, Integer>> _results = analyzeFilesRecursively(
							currentFile, rootDir, mainDir, metrics, log);

					passed_map.put(
							mainDir.getName(),
							passed_map.get(mainDir.getName())
									+ _results.get(Status.PASSED).get(
											mainDir.getName()));

					not_passed_map.put(
							mainDir.getName(),
							not_passed_map.get(mainDir.getName())
									+ _results.get(Status.NOT_PASSED).get(
											mainDir.getName()));

					not_supported_map.put(
							mainDir.getName(),
							not_supported_map.get(mainDir.getName())
									+ _results.get(Status.NOT_SUPPORTED).get(
											mainDir.getName()));
					failed_map.put(
							mainDir.getName(),
							failed_map.get(mainDir.getName())
									+ _results.get(Status.FAILED).get(
											mainDir.getName()));

				}
			} catch (Exception | AssertionError e) {
				String timeStamp = new SimpleDateFormat("(" + DATE_FORMAT + ")")
						.format(Calendar.getInstance().getTime());
				StringBuilder sb = new StringBuilder(timeStamp + " ");
				LOG.log(Level.SEVERE,
						"FAILED: " + currentFile.getAbsolutePath(), e);
				sb.append(Status.FAILED + " " + currentFile.getPath());
				log.append(sb.toString()).append("\n");
				System.exit(0);
			}
		}

		results.put(Status.PASSED, passed_map);
		results.put(Status.NOT_PASSED, not_passed_map);
		results.put(Status.NOT_SUPPORTED, not_supported_map);
		results.put(Status.FAILED, failed_map);

		return results;
	}

	/*
	 * CONVERSION METHODS
	 */

	public void convertFiles(File dir, AgreementLanguage src_lang,
			AgreementLanguage dst_lang) {
		convertFiles(dir, "converted", dst_lang);
	}

	public void convertFiles(File dir, String destId, AgreementLanguage dst_lang) {
		LOG.log(Level.INFO, "CONVERTING FILES...");
		long startTime = System.nanoTime();

		File currentDir = new File(dir.getParent() + File.separator + destId);
		if (!currentDir.mkdir()) {
			LOG.log(Level.INFO,
					"Directory "
							+ currentDir.getPath()
							+ " already exists. All data on the destination will be overwritten.");
		}
		File[] metrics = null;
		for (File f : dir.listFiles()) {
			if (f.isDirectory()
					&& f.getName().equals(CONFIG.getMetrics_folder())) {
				int size = f.listFiles().length;
				metrics = new File[size];
				for (int i = 0; i < size; i++) {
					metrics[i] = f.listFiles()[i];
				}
			}
		}

		Integer converted_files = convertFilesRecursively(dir, currentDir,
				metrics, dst_lang);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		LOG.log(Level.INFO, "CONVERSION FINISHED (" + duration + "ms)");
		LOG.log(Level.INFO, converted_files + " files was converted.");
	}

	private Integer convertFilesRecursively(File currentFile, File currentDir,
			File[] metrics, AgreementLanguage dst_lang) {
		Integer converted_files = 0;
		File[] files = currentFile.listFiles();
		for (File file : files) {
			try {
				if (file.isFile()) {
					AgreementLanguage src_lang = TestUtil
							.getLanguageFromExtension(file);
					if (TestUtil.isValidExtension(file, CONFIG)) {
						FileInputStream in = new FileInputStream(file);
						String content = Util.getStringFromInputStream(in);

						AgreementModel model = null;
						model = Store.getInstance().parseAgreementFile(content,
								metrics, src_lang);

						if (model != null) {
							String new_ext = "."
									+ TestUtil.getExtensionFromLanguage(
											dst_lang, model.getDocType());
							String filename = file.getName().substring(0,
									file.getName().lastIndexOf("."));
							File newFile = new File(currentDir + File.separator
									+ filename + new_ext);

							newFile.createNewFile();
							converted_files++;

							Translator translator = new Translator(
									TestUtil.getBuilderFromLanguage(dst_lang));
							String new_content = translator.print(model);

							PrintWriter out = new PrintWriter(newFile);
							out.println(new_content);
							out.close();
						} else {
							LOG.log(Level.SEVERE,
									"ERROR: " + file.getAbsolutePath());
						}
					} else {
						File newFile = new File(currentDir + File.separator
								+ file.getName());
						if (!newFile.exists())
							Files.copy(file.toPath(), newFile.toPath());
					}
				} else {
					File newDir = new File(currentDir + File.separator
							+ file.getName());
					newDir.mkdir();
					converted_files += convertFilesRecursively(file, newDir,
							metrics, dst_lang);
				}
			} catch (IOException e) {
				LOG.log(Level.SEVERE, e.getMessage());
			}
		}
		return converted_files;
	}
}
