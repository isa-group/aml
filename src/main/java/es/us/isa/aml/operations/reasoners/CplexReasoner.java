/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.reasoners;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.opl.OPLBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerType;
import ilog.concert.IloConstraint;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AntonioGamez
 */
public class CplexReasoner extends Reasoner {

    private static final Logger LOG = Logger.getLogger(CplexReasoner.class
            .getName());
    private AgreementModel model;

    @Override
    public void addProblem(AgreementModel model) {
        this.model = model;
    }

    @Override
    public OperationResponse solve() {

        OperationResponse response = new OperationResponse();

        Boolean solve = false;
        String result = "";
        String conflicts = "";
        Map<String, List<String>> conflictsMap = new HashMap<>();

        if (this.model != null) {
            Translator translator = new Translator(new OPLBuilder());
            Date date = new Date();
            File temp;
            try {
                temp = File.createTempFile(String.valueOf(date.getTime()), ".opl");
                String content = translator.export(this.model);
                // write it
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
                    bw.write(content);
                }
                // IloOplFactory.setDebugMode(false);

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
//                    cp.setParameter(IntParam.ConflictRefinerOnVariables, ParameterValues.On);
                    IloOplModel opl = oplFactory.createOplModel(def, cp);

                    opl.generate();
                    solve = cp.solve();

                    List<IloConstraint> cts_list = new ArrayList<>();
                    for (Iterator<IloOplElement> it = opl.getElementIterator(); it.hasNext();) {
                        IloOplElement e = it.next();
                        if (!e.isDecisionVariable() && !e.isData()
                                && !e.isCalculated()) {
                            IloConstraint c = e.asConstraint();
                            c.setName(e.getName());
                            cts_list.add(c);
                        }
                    }

                    IloConstraint[] constraints = cts_list.toArray(new IloConstraint[cts_list.size()]);
                    double[] prefs = new double[constraints.length];
                    for (int p = 0; p < constraints.length; p++) {
                        prefs[p] = 1.0;
                    }

                    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                        if (solve) {
                            opl.printSolution(baos);
                            result = baos.toString();
                            conflicts = "The model is feasible";
                        } else {
                            result = "The document has conflicts";
                            if (cp.refineConflict(constraints, prefs)) {
                                //StringBuilder sb = new StringBuilder();

                                List<String> provedConflicts = new LinkedList<>();
                                List<String> possibleConflicts = new LinkedList<>();
                                for (IloConstraint constraint : constraints) {
                                    ConflictStatus cs = cp.getConflict(constraint);
                                    if (cs.equals(ConflictStatus.ConflictMember)) {
                                        //sb.append("Proved conflict member: ").append(constraint.getName()).append(";");
                                        provedConflicts.add(constraint.getName());
                                    } else if (cs.equals(ConflictStatus.ConflictPossibleMember)) {
                                        //sb.append("Possible conflict member: ").append(constraint.getName()).append(";");
                                        possibleConflicts.add(constraint.getName());
                                    }
                                }
                                //conflicts = sb.toString();
                                conflictsMap.put("provedConflicts", provedConflicts);
                                conflictsMap.put("possibleConflicts", possibleConflicts);
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
                            conflicts = "The model is feasible";
                        } else {
                            result = "The document has conflicts";
                            opl.printConflict(baos);
                            conflicts = baos.toString();
                        }
                    }
                    cplex.clearModel();
                    opl.endAll();
                }
                // oplFactory.end();
                // env.end();

            } catch (Error | Exception e) {
                solve = false;
                result = "ERROR";
                conflicts = "";
                LOG.log(Level.SEVERE, "There was an error processing the file", e);
            }
        } else {
            solve = false;
        }

        response.put("consistent", solve);
        response.put("result", result);
        //response.put("conflicts", conflicts);
        response.put("conflicts", conflictsMap);
        return response;
    }

    @Override
    public OperationResponse explain() {
        throw new UnsupportedOperationException("Not supported yet."); // Todo
    }

    @Override
    public OperationResponse implies() {
        throw new UnsupportedOperationException("Not supported yet."); // Todo
    }

    @Override
    public OperationResponse whyNotImplies() {
        throw new UnsupportedOperationException("Not supported yet."); // Todo
    }

    @Override
    public ReasonerType getType() {
        return ReasonerType.CPLEX;
    }

}
