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

                ByteArrayOutputStream errors = new ByteArrayOutputStream();
                IloEnv env = new IloEnv();
                IloOplFactory oplFactory = new IloOplFactory();
                IloOplErrorHandler errHandler = oplFactory.createOplErrorHandler(errors);
                IloOplModelSource modelSource = oplFactory.createOplModelSource(temp.getAbsolutePath());

                IloOplSettings settings = new IloOplSettings(env, errHandler);
                IloOplModelDefinition def = oplFactory.createOplModelDefinition(modelSource, settings);

                String using = content.substring(0, content.indexOf('\n')).trim();
                Boolean useCP = using.equals("using CP;");

                if (useCP) {
                    IloCP cp = oplFactory.createCP();
                    cp.setOut(null);
                    cp.setParameter(IntParam.ConflictRefinerOnVariables, ParameterValues.On);
                    IloOplModel opl = oplFactory.createOplModel(def, cp);
                    opl.generate();
                    solve = cp.solve();
                    
                    cp.clearModel();
                    opl.endAll();
                    
                } else {
                    IloCplex cplex = oplFactory.createCplex();
                    cplex.setOut(null);
                    IloOplModel opl = oplFactory.createOplModel(def, cplex);
                    opl.generate();
                    solve = cplex.solve();
                    
                    cplex.clearModel();
                    opl.endAll();
                }
//                oplFactory.end();
//                env.end();
                
            } catch (Error | Exception e) {
                solve = false;
                LOG.log(Level.SEVERE, "There was an error processing the file", e);
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
