/**
 * 
 */
package es.us.isa.aml.reasoners;

import ilog.concert.IloConstraint;
import ilog.concert.IloException;
import ilog.concert.cppimpl.IloEnv;
import ilog.cp.IloCP;
import ilog.cp.IloCP.ConflictStatus;
import ilog.cplex.IloCplex;
import ilog.opl.IloOplElement;
import ilog.opl.IloOplErrorHandler;
import ilog.opl.IloOplFactory;
import ilog.opl.IloOplModel;
import ilog.opl.IloOplModelDefinition;
import ilog.opl.IloOplModelSource;
import ilog.opl.IloOplSettings;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import es.us.isa.aml.util.OperationResponse;

/**
 * @author jdelafuente
 *
 */
public class CplexHandler {

	private static final Logger LOG = Logger.getLogger(CplexHandler.class
			.getName());

	private IloEnv env;
	private IloOplFactory factory;
	private IloOplErrorHandler errorHandler;

	public void init() {
		ByteArrayOutputStream errors = new ByteArrayOutputStream();
		env = new IloEnv();
		factory = new IloOplFactory();
		errorHandler = factory.createOplErrorHandler(errors);
		IloOplFactory.setDebugMode(false);
	}

	public String solve(String raw) {
		Date date = new Date();
		File temp;		
		Boolean solve = false;

		try {
			temp = File.createTempFile(String.valueOf(date.getTime()), ".opl");
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));			
			//String content = URLDecoder.decode(raw, "UTF-8");		
			String content = raw;
			bw.write(content);
			bw.close();

			IloOplModelSource modelSource = factory.createOplModelSource(temp
					.getAbsolutePath());

			IloOplSettings settings = new IloOplSettings(env, errorHandler);
			IloOplModelDefinition def = factory.createOplModelDefinition(
					modelSource, settings);

			String using = content.substring(0, content.indexOf('\n')).trim();
			Boolean useCP = using.equals("using CP;");

			if (useCP) {
				IloCP cp = factory.createCP();
				cp.setOut(null);
				// cp.setParameter(IntParam.ConflictRefinerOnVariables,
				// ParameterValues.On);
				IloOplModel opl = factory.createOplModel(def, cp);

				opl.generate();
				solve = cp.solve();

				cp.clearModel();
				opl.endAll();

			} else {
				IloCplex cplex = factory.createCplex();
				cplex.setOut(null);
				IloOplModel opl = factory.createOplModel(def, cplex);
				opl.generate();
				solve = cplex.solve();

				cplex.clearModel();
				opl.endAll();
			}
			
			env.end();
		} catch (IloException e) {
			String[] aux = e.getMessage().split(":");
			String exc = aux[0];
			if (exc.equals("IloMapOutOfBoundException")){
				solve = false;
			} else {
				solve = null;
				LOG.log(Level.SEVERE, e.getMessage());
			}
			e.printStackTrace();
		} catch (Error | Exception e) {
			solve = null;
			LOG.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}

		return new Gson().toJson(solve);
	}

	public String explain(String raw) {
		OperationResponse response = new OperationResponse();

		Boolean solve = false;
		String result = "";
		List<String> conflicts = new ArrayList<String>();

		Date date = new Date();
		File temp;

		try {
			temp = File.createTempFile(String.valueOf(date.getTime()), ".opl");
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

			String content = URLDecoder.decode(raw, "UTF-8");
			bw.write(content);
			bw.close();

			ByteArrayOutputStream errors = new ByteArrayOutputStream();
			IloEnv env = new IloEnv();
			IloOplFactory oplFactory = new IloOplFactory();
			IloOplErrorHandler errHandler = oplFactory
					.createOplErrorHandler(errors);
			IloOplModelSource modelSource = oplFactory
					.createOplModelSource(temp.getAbsolutePath());

			IloOplSettings settings = new IloOplSettings(env, errHandler);
			IloOplModelDefinition def = oplFactory.createOplModelDefinition(
					modelSource, settings);

			String using = content.substring(0, content.indexOf('\n')).trim();
			Boolean useCP = using.equals("using CP;");

			if (useCP) {
				IloCP cp = oplFactory.createCP();
				cp.setOut(null);
				// cp.setParameter(IntParam.ConflictRefinerOnVariables,
				// ParameterValues.On);
				IloOplModel opl = oplFactory.createOplModel(def, cp);

				opl.generate();
				solve = cp.solve();

				List<IloConstraint> cts_list = new ArrayList<>();
				for (@SuppressWarnings("unchecked")
				Iterator<IloOplElement> it = opl.getElementIterator(); it
						.hasNext();) {
					IloOplElement e = it.next();
					if (!e.isDecisionVariable() && !e.isData()
							&& !e.isCalculated()) {
						IloConstraint c = e.asConstraint();
						c.setName(e.getName());
						cts_list.add(c);
					}
				}

				IloConstraint[] constraints = cts_list
						.toArray(new IloConstraint[cts_list.size()]);
				double[] prefs = new double[constraints.length];
				for (int p = 0; p < constraints.length; p++) {
					prefs[p] = 1.0;
				}

				try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
					if (solve) {
						opl.printSolution(baos);
						result = baos.toString();
					} else {
						result = "The document has conflicts";
						if (cp.refineConflict(constraints, prefs)) {
							for (IloConstraint constraint : constraints) {
								ConflictStatus cs = cp.getConflict(constraint);

								String constraint_name = constraint.getName();
								
								//System.out.println("Constraint name en CplexHandler: "+constraint_name);
								
								if (constraint_name.contains("_") && !constraint_name.startsWith("ASSIG")) {
									constraint_name = constraint_name
											.substring(0, constraint_name
													.lastIndexOf("_"));
								}

								if (cs.equals(ConflictStatus.ConflictMember)) {
									if (!conflicts
											.contains(constraint_name))
										conflicts.add(constraint_name);
								} else if (cs
										.equals(ConflictStatus.ConflictPossibleMember)) {
									if (!conflicts
											.contains(constraint_name))
										conflicts.add(constraint_name);
								}
							}
						}
					}
				}
				cp.clearModel();
				opl.endAll();

			} else {
				IloCplex cplex = oplFactory.createCplex();
				cplex.setOut(null);
				IloOplModel opl = oplFactory.createOplModel(def, cplex);
				opl.generate();
				solve = cplex.solve();

				try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
					if (solve) {
						opl.printSolution(baos);
						result = baos.toString();
					} else {
						result = "The document has conflicts";
						opl.printConflict(baos);
						conflicts.add(baos.toString());
					}
				}
				cplex.clearModel();
				opl.endAll();
			}
			
			env.end();
		} catch (IloException e) {
			String[] aux = e.getMessage().split(":");
			String exc = aux[0];
			if (exc.equals("IloMapOutOfBoundException")){
				result = "ERROR";
				conflicts.add(e.getMessage());
			} else {
				solve = null;
				LOG.log(Level.SEVERE, e.getMessage());
			}
		} catch (Error | Exception e) {
			result = "ERROR";
			LOG.log(Level.SEVERE, e.getMessage());
		}

		response.put("result", result);
		response.put("conflicts", conflicts);
		return new Gson().toJson(response);
	}
}
