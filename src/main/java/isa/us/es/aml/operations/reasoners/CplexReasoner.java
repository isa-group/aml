/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.reasoners;

import ilog.concert.IloException;
import ilog.concert.cppimpl.IloEnv;
import ilog.cp.IloCP;
import ilog.cplex.IloCplex;
import ilog.opl.IloOplErrorHandler;
import ilog.opl.IloOplFactory;
import ilog.opl.IloOplModel;
import ilog.opl.IloOplModelDefinition;
import ilog.opl.IloOplModelSource;
import ilog.opl.IloOplSettings;
import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.operations.core.CoreOperation;
import isa.us.es.aml.translators.Translator;
import isa.us.es.aml.translators.csp.opl.OPLBuilder;
import isa.us.es.aml.util.CoreOperationProxy;
import isa.us.es.aml.util.ReasonerType;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author AntonioGamez
 */
public class CplexReasoner extends Reasoner {

	AgreementModel model;

	@Override
	public Object execute(CoreOperation coreOperation,
			AgreementModel agreementModel) {
		CoreOperation op = CoreOperationProxy.createOperation(
				coreOperation.getType(), getType());
		op.setModel(agreementModel);
		op.setReasoner(coreOperation.getReasoner());
		op.analyze();
		return op.getResult();
	}

	@Override
	public void addProblem(AgreementModel model) {
		this.model = (AgreementModel) model;
	}

	@Override
	public Object solve() {
		Boolean solve = false;

		Translator translator = new Translator(new OPLBuilder());

		Date date = new Date();
		File temp;

		try {
			temp = File.createTempFile(String.valueOf(date.getTime()), ".opl");
			String content = translator.export(model);
			
			// write it
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			bw.write(content);
			bw.close();

			IloEnv env = new IloEnv();
			IloOplFactory oplF = new IloOplFactory();
			ByteArrayOutputStream errors = new ByteArrayOutputStream();
			IloOplErrorHandler errHandler = oplF.createOplErrorHandler(errors);
			IloOplModelSource modelSource = oplF.createOplModelSource(temp.getAbsolutePath());
//			IloOplModelSource modelSource = oplF.createOplModelSource("samples/sampleopl.opl");

			IloOplSettings settings = new IloOplSettings(env, errHandler);
			IloOplModelDefinition def = oplF.createOplModelDefinition(
					modelSource, settings);

			String using = content.substring(0, content.indexOf("\n")).trim();
			Boolean useCP = using.equals("using CP;") ? true : false;

			if (useCP) {
				IloCP cp = oplF.createCP();
				cp.setOut(null);
				cp.setParameter(IloCP.IntParam.ConflictRefinerOnVariables,
						IloCP.ParameterValues.On);
				IloOplModel opl = oplF.createOplModel(def, cp);
				opl.generate();
				solve = cp.solve();
			} else {
				IloCplex cplex = oplF.createCplex();
				cplex.setOut(null);
				IloOplModel opl = oplF.createOplModel(def, cplex);
				opl.generate();
				solve = cplex.solve();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IloException e) {
			e.printStackTrace();
		}

		return solve;
	}

	@Override
	public Object explain() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public Object implies() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public Object whyNotImplies() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public ReasonerType getType() {
		return ReasonerType.CPLEX;
	}

}
