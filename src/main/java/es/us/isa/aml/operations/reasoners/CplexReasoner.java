/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.reasoners;

import ilog.concert.cppimpl.IloEnv;
import ilog.cp.IloCP;
import ilog.cp.IloCP.IntParam;
import ilog.cp.IloCP.ParameterValues;
import ilog.cplex.IloCplex;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translators.Translator;
import es.us.isa.aml.translators.csp.opl.OPLBuilder;
import es.us.isa.aml.util.ReasonerType;

/**
 *
 * @author AntonioGamez
 */
public class CplexReasoner extends Reasoner {

    private static final Logger LOG = Logger.getLogger(CplexReasoner.class.getName());
    private AgreementModel model;

    @Override
    public void addProblem(AgreementModel model) {
        this.model = model;
    }

    @Override
    public Object solve() {
        Boolean solve = false;
        if (this.model != null) {
            Translator translator = new Translator(new OPLBuilder());
            Date date = new Date();
            File temp;
            try {
                temp = File.createTempFile(String.valueOf(date.getTime()), ".opl");
                String content = translator.export(this.model);
                try ( // write it
                        BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
                    bw.write(content);
                }
//                IloOplFactory.setDebugMode(false);

                IloEnv env = new IloEnv();
                IloOplFactory oplF = new IloOplFactory();

                ByteArrayOutputStream errors = new ByteArrayOutputStream();
                IloOplErrorHandler errHandler = oplF.createOplErrorHandler(errors);
                IloOplModelSource modelSource = oplF.createOplModelSource(temp.getAbsolutePath());

                IloOplSettings settings = new IloOplSettings(env, errHandler);
                IloOplModelDefinition def = oplF.createOplModelDefinition(modelSource, settings);

                String using = content.substring(0, content.indexOf('\n')).trim();
                Boolean useCP = using.equals("using CP;");

                if (useCP) {
                    IloCP cp = oplF.createCP();
                    cp.setOut(null);
                    cp.setParameter(IntParam.ConflictRefinerOnVariables, ParameterValues.On);
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
            } catch (Error | Exception e) {
                solve = false;
                LOG.log(Level.WARNING, null, e);
            }
        } else {
            solve = false;
        }
        return solve;
    }

    @Override
    public Object explain() {
        throw new UnsupportedOperationException("Not supported yet."); // Todo
    }

    @Override
    public Object implies() {
        throw new UnsupportedOperationException("Not supported yet."); // Todo
    }

    @Override
    public Object whyNotImplies() {
        throw new UnsupportedOperationException("Not supported yet."); // Todo
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CPLEX;
    }

}
