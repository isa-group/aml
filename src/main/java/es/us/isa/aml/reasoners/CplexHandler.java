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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.reasoners;

import ilog.concert.IloConstraint;
import ilog.concert.IloException;
import ilog.concert.cppimpl.IloEnv;
import ilog.cp.IloCP;
import ilog.cp.IloCP.ConflictStatus;
import ilog.cplex.IloCplex;
import ilog.opl.IloOplElement;
import ilog.opl.IloOplElementType;
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
			String content = URLDecoder.decode(raw, "UTF-8");
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
			if (exc.equals("IloMapOutOfBoundException")) {
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
					if (e.getElementType().equals(
							IloOplElementType.Type.CONSTRAINT)) {
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
						if (cp.refineConflict()) {
							for (IloConstraint constraint : constraints) {
								ConflictStatus cs = cp.getConflict(constraint);
								String constraint_name = constraint.getName();
								if (cs.equals(ConflictStatus.ConflictMember)) {
									if (!conflicts.contains(constraint_name))
										conflicts.add(constraint_name);
								} else if (cs
										.equals(ConflictStatus.ConflictPossibleMember)) {
									if (!conflicts.contains(constraint_name))
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

				List<IloConstraint> cts_list = new ArrayList<>();
				for (@SuppressWarnings("unchecked")
				Iterator<IloOplElement> it = opl.getElementIterator(); it
						.hasNext();) {
					IloOplElement e = it.next();
					if (e.getElementType().equals(
							IloOplElementType.Type.CONSTRAINT)) {
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

						if (cplex.refineConflict(constraints, prefs)) {
							for (IloConstraint constraint : constraints) {
								ilog.cplex.IloCplex.ConflictStatus cs = cplex
										.getConflict(constraint);
								String constraint_name = constraint.getName();
								if (cs.equals(ilog.cplex.IloCplex.ConflictStatus.Member)) {
									if (!conflicts.contains(constraint_name))
										conflicts.add(constraint_name);
								} else if (cs
										.equals(ilog.cplex.IloCplex.ConflictStatus.PossibleMember)) {
									if (!conflicts.contains(constraint_name))
										conflicts.add(constraint_name);
								}
							}
						}
					}
				}
				cplex.clearModel();
				opl.endAll();
			}

			env.end();
		} catch (IloException e) {
			String[] aux = e.getMessage().split(":");
			String exc = aux[0];
			if (exc.equals("IloMapOutOfBoundException")) {
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
