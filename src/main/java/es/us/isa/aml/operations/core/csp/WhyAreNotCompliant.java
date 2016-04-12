/**
 * *****************************************************************************
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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */
package es.us.isa.aml.operations.core.csp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.operations.core.OperationResult;
import es.us.isa.aml.reasoners.cspwebreasoner.Solution;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.ReasonerFactory;
import java.util.concurrent.TimeoutException;

/**
 * @author cmuller
 *
 */
public class WhyAreNotCompliant extends CoreOperation {

    public WhyAreNotCompliant() {
        result = new OperationResult();
        this.reasoner = ReasonerFactory.createCSPReasoner();
    }

    public void analyze(AgreementModel template, AgreementModel offer) {
        // Compliance checking is done within whyNotImplies CSP operation.

        OperationResult res = null;
        Translator translator = new Translator(new CSPBuilder());

        CSPModel csp_offer = (CSPModel) translator.translate(offer);
        CSPModel csp_template = (CSPModel) translator.translate(template);

        // whyNotImplies(map(T.GTs), map(O.GTs))
        AgreementTemplate template_gts = (AgreementTemplate) template.clone();
        template_gts.getCreationConstraints().clear();

        AgreementOffer offer_gts = (AgreementOffer) offer.clone();
        offer_gts.getAgreementTerms().getService().getConfigurationProperties()
                .clear();
        // With the following code line I do not consider in the compliance
        // analysis the value assignments for MonitorableProps within the Offer
        Map<String, MonitorableProperty> mps = offer_gts.getAgreementTerms()
                .getMonitorableProperties();
        Iterator<String> it = mps.keySet().iterator();
        while (it.hasNext()) {
            String mpId = (String) it.next();
            MonitorableProperty mp = mps.get(mpId);
            if (mp.getExpression() != null) {
                mp.setExpression(null);
            }
        }

        try {

            if ((template.getAgreementTerms().getGuaranteeTerms().size() > 0)
                    && (offer.getAgreementTerms().getGuaranteeTerms().size() > 0)) {

                CSPModel csp_template_gts = (CSPModel) translator
                        .translate(template_gts);
                CSPModel csp_offer_gts = (CSPModel) translator.translate(offer_gts);
                Solution sol = reasoner.whyNotImplies(csp_template_gts, csp_offer_gts);
                res = new OperationResult();
                res.setCompliant(sol.getFeasibility());
                res.setExplaining(sol.getExplaining());
                res.setConflicts(sol.getConflicts());
            }

            if (res != null) {

                // If previous checking is not compliant conflicts are returned, and if
                // it was compliant second part is analysed as follows
                if (res.getCompliant()) {
                    // whyNotImplies(map(O.Terms), map(T.CCs))
                    AgreementTemplate template_ccs = (AgreementTemplate) template
                            .clone();
                    template_ccs.getAgreementTerms().getGuaranteeTerms().clear();

                    if (((AgreementTemplate) template).getCreationConstraints().size() > 0) {
                        CSPModel csp_template_ccs = (CSPModel) translator
                                .translate(template_ccs);
                        Solution sol2 = reasoner.whyNotImplies(csp_offer,
                                csp_template_ccs);

                        res = new OperationResult();
                        res.setCompliant(sol2.getFeasibility());
                        res.setExplaining(sol2.getExplaining());
                        res.setConflicts(sol2.getConflicts());
                    }
                }

                result.setCompliant(res.getCompliant());
                result.setExplaining(res.getExplaining());
                result.setConflicts(new ArrayList(res.getConflicts()));
                result.setAffectedTerms(res.getAffectedTerms());

                // If conflicts were found, we classify the kind of conflict as follows
                if (!res.getCompliant()) {
                    List<CSPConstraint> conflictingConstraints = putExplanation(res, csp_offer.clone(), csp_template.clone());
                    classifyConflicts(conflictingConstraints, (AgreementTemplate) template, csp_template.clone(), translator);
                }
            }
        } catch (TimeoutException ex) {
            result.setError(ex.getMessage());
        }
        // result.putAll(res);
    }

    @SuppressWarnings("unchecked")
    private List<CSPConstraint> putExplanation(OperationResult res,
            CSPModel csp_offer, CSPModel csp_template) {
        // System.out.println("Res es: "+res);
        List<String> conflictResult = res.getConflicts();

        // Created a copy to remove the conflicts that are from the offer. This
        // is used to show the affected template constraints
        List<String> conflictsForTemplate = new ArrayList<>(conflictResult);

        List<CSPConstraint> sourceConstraints = csp_offer.getConstraints();
        List<CSPConstraint> constraints = new ArrayList<>();

        // the following line remove Problem constraint from the conflicts to be
        // returned
        //result.getConflicts().clear();
        // Sometimes, although documents have conflicts, none of them are
        // returned because some problematic SDT value assignment are not
        // detected
        // to be developed
        List<CSPConstraint> sourceTemplateConstraints = csp_template.getConstraints();
//        List<CSPConstraint> affectedTemplateConstraints = new ArrayList<>();

        Boolean constraintsEmpty = true;
        Boolean exit = false;
        while (constraintsEmpty) {
            Iterator<String> itConflictResult = conflictResult.iterator();
            while (itConflictResult.hasNext()) {
                String conf = (String) itConflictResult.next();
                List<String> confs = result.getConflicts();

                Iterator<CSPConstraint> itSourceConstraints = sourceConstraints.iterator();
                while (itSourceConstraints.hasNext()) {
                    CSPConstraint cons = (CSPConstraint) itSourceConstraints.next();
                    String constraint_name = cons.getId();

                    if (!conf.equalsIgnoreCase("Problem") && !(conf.startsWith("ASSIG"))) {

                        if (conf.contains("_")) {
                            conf = removeUnderScore(conf);
                        }

                        if (conf.equalsIgnoreCase(constraint_name)) {
                            if (conf.contains("_")) {
                                conf = removeUnderScore(conf);
                            }

                            // We check that the cons has not been included yet
                            // (such a situation happens when GTs have the same
                            // name in offer and template)
                            if (confs == null || !confs.contains(cons.toString())) {
                                constraints.add(cons);
                                List<String> newConst = new ArrayList<>();
                                newConst.add(cons.toString());
                                result.setConflicts(newConst);
                                conflictsForTemplate.remove(cons.getId());
                            }
                        }
                    }
                    if (conf.startsWith("ASSIG") && conf.equalsIgnoreCase(constraint_name)) {
                        if (confs == null || !confs.contains(cons.toString())) {
                            constraints.add(cons);
                            List<String> consts = new ArrayList<>();
                            consts.add(cons.toString());
                            result.setConflicts(consts);
                            conflictsForTemplate.remove(cons.getId());
                        }
                    }
                }
            }

            if (constraints.isEmpty() && !exit) {
                try {
                    CSPModel modelAux = csp_template.clone().add(csp_offer); // O y
                    // T
                    Solution solAux = reasoner.explain(modelAux);
                    conflictResult = solAux.getConflicts();
                    exit = true;
                } catch (TimeoutException ex) {
                    result.setError(ex.getMessage());
                }
            } else {
                constraintsEmpty = false;
            }
        }

        List<String> consts = new ArrayList<>();
        for (CSPConstraint cons : constraints) {
            consts.add(cons.toString());
        }
        result.setConflicts(consts);

        // To run on conflictsForTemplate in order to create the list of
        // affected template CSP conflicts
        // ESTO SE PODRÁ SACAR FACTOR COMÚN CON LO DE ARRIBA SEGURO
        Iterator<String> itConflictsForTemplate = conflictsForTemplate.iterator();
        while (itConflictsForTemplate.hasNext()) {
            String affected = (String) itConflictsForTemplate.next();
            Iterator<CSPConstraint> itSourceTemplateConstraints = sourceTemplateConstraints.iterator();
            while (itSourceTemplateConstraints.hasNext()) {
                CSPConstraint c = (CSPConstraint) itSourceTemplateConstraints.next();
                String constraint_name = c.getId();

                if (affected != null) {
                    if (!affected.equalsIgnoreCase("Problem") && !(affected.startsWith("ASSIG"))) {

                        if (affected.contains("_")) {
                            affected = removeUnderScore(affected);
                        }

                        if (affected.equalsIgnoreCase(constraint_name)) {
                            if (affected.contains("_")) {
                                affected = removeUnderScore(affected);
                            }
                            if (!affected.contains(c.toString())) {
//                                affectedTemplateConstraints.add(c);
                                List<String> afft = new ArrayList<>();
                                afft.add(c.toString());
                                result.setAffectedTerms(afft);
                            }

                        }
                    }
                    if (affected.startsWith("ASSIG") && affected.equalsIgnoreCase(constraint_name)) {
                        if (!affected.contains(c.toString())) {
//                            affectedTemplateConstraints.add(c);
                            List<String> afft = new ArrayList<>();
                            afft.add(c.toString());
                            result.setAffectedTerms(afft);
                        }
                    }
                }
            }
        }

        return constraints;
    }

    private void classifyConflicts(List<CSPConstraint> constraints, AgreementTemplate template, CSPModel csp_template, Translator translator) {
        Boolean moreRestrictive, contradictory;
        // Boolean intersec = null; //this is another kind of CSP conflict not
        // observed yet

        AgreementTemplate empty_template = (AgreementTemplate) template.clone();
        empty_template.getCreationConstraints().clear();
        empty_template.getAgreementTerms().getGuaranteeTerms().clear();
        CSPModel confModel = (CSPModel) translator.translate(empty_template);
        confModel.setConstraints(constraints);

        CSPModel modelForClassify2 = confModel.clone().add(csp_template); // V,D,Conflict
        // y
        // T

        try {
            Solution sol = reasoner.solve(modelForClassify2);
            moreRestrictive = sol.getFeasibility();
            String conflictType;

            if (moreRestrictive) {
                if (result.getConflicts() == null) {
                    conflictType = "the offer has more restrictive terms";
                } else {
                    conflictType = "more restrictive offer term";
                }
            } else {
                CSPModel modelForClassify = confModel.clone().add(csp_template.negate()); // V,D,Conflict y noT

                Solution sol2 = reasoner.solve(modelForClassify);
                contradictory = sol2.getFeasibility();

                if (contradictory) {
                    if (result.getConflicts() == null) {
                        conflictType = "the offer has contradictory terms";
                    } else {
                        conflictType = "contradictory offer term";
                    }
                } else if (result.getConflicts() == null) {
                    conflictType = "the offer has possibly contradictory terms (i.e. it allows values non-compliant with template terms)";
                } else {
                    conflictType = "possibly contradictory offer term (i.e. it allows values non-compliant with template terms)";
                }
            }

            result.setCompliant(false);
            result.setConflictType(conflictType);
        } catch (TimeoutException ex) {
            result.setError(ex.getMessage());
        }
    }

    private String removeUnderScore(String conf) {
        conf = conf.substring(0, conf.lastIndexOf("_"));
        return conf;
    }

    @Override
    public OperationResult getResult() {
        return result;
    }

}
