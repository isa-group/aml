///**
// * This file is part of ADA.
// *
// * ADA is free software: you can redistribute it and/or modify it under the
// * terms of the GNU Lesser General Public License as published by the Free
// * Software Foundation, either version 3 of the License, or (at your option) any
// * later version.
// *
// * ADA is distributed in the hope that it will be useful, but WITHOUT ANY
// * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
// * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
// * details.
// *
// * You should have received a copy of the GNU Lesser General Public License
// * along with ADA. If not, see <http://www.gnu.org/licenses/>.
// */
//package isa.us.es.aml.operations.csp.choco;
//
//import choco.Choco;
//import choco.kernel.model.constraints.Constraint;
//import choco.kernel.model.variables.Variable;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.ChocoOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoComplianceTranslator;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.utils.Utils;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AbstractDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AgreementElement;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.operations.MoreRestrictiveTemplateTermsComplianceOperation;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Template;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Term;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
///*
// * Importante para esta operacion: primero debe hacerse el add de la plantilla,
// * y luego de la oferta (la plantilla ocupara el lugar 0, y la oferta el 1)
// */
//
//public class ChocoMoreRestrictiveTemplateTermsComplianceOp extends ChocoOperation implements
//        MoreRestrictiveTemplateTermsComplianceOperation {
//
//    private boolean moreRestrictiveTemplateTerms;
//
//    public ChocoMoreRestrictiveTemplateTermsComplianceOp() {
//        moreRestrictiveTemplateTerms = false;
//    }
//
//    @Override
//    public boolean isMoreRestrictiveTemplateTermsThanCC() {
//        return moreRestrictiveTemplateTerms;
//    }
//
//    public boolean checkConsistency(AbstractDocument d, ChocoAnalyzer an) {
//        ConsistencyOperation op = new ChocoConsistencyOp();
//        op.addDocument(d);
//        an.analyze(op);
//        boolean result = op.isConsistent();
//        return result;
//    }
//    /*public boolean checkCompliance(AbstractDocument t, AbstractDocument o, ChocoAnalyzer an){
//     ComplianceOperation op = new ChocoComplianceOp();
//     op.addDocument(t);
//     op.addDocument(o);
//     an.analyze(op);
//     boolean result = op.isCompliant();
//     return result;
//     }*/
//
//    @Override
//    public void execute(ChocoAnalyzer an) {
//        moreRestrictiveTemplateTerms = false;
//        // debe haber un documento que es la plantilla a comprobar
//        if (!docs.isEmpty()) {
//            Template t;
//            AbstractDocument doc = docs.get(0);
//            if (doc instanceof Template) {
//                // nos aseguramos que el documento sea una plantilla
//                t = (Template) doc;
//                if (checkConsistency(t, an)) {
//                    //System.out.println("La plantilla es consistente");
//                    // para esta operaci-n debemos asegurarnos de que la plantilla sea consistente
//                    ChocoAlternativeDocumentsOp adop = new ChocoAlternativeDocumentsOp();
//                    adop.addDocument(doc);
//                    an.analyze(adop);
//                    Collection<AbstractDocument> alts = adop
//                            .getAlternativeDocuments();
//                    Iterator<AbstractDocument> it = alts.iterator();
//                    boolean b = false;
//                    // revisar la condici-n de !b... pq..
//                    // -con que haya una more restrictive ya devolvemos TRUE?
//                    // es decir, creo que TODAS las vistas deben devolver true... (REVISAR)
//                    while (it.hasNext() && !b) {
//                        // por cada alternative document de la plantilla
//                        AbstractDocument d1 = it.next();
//                        //Map<ServiceScope,AbstractDocument> templateviews = super.getViews(d1,an);
//                        Collection<AbstractDocument> templateviews = super.getViews(d1, an).values();
//                        Iterator<AbstractDocument> itViews = templateviews.iterator();
//                        while (itViews.hasNext() && !b) {
//                            AbstractAgreementDocument aux = (AbstractAgreementDocument) itViews.next();
//                            ChocoTranslator trans1 = new ChocoTranslator(aux);
//                            trans1.translate();
//                            // necesito todas las constraints de la plantilla
//                            Map<AgreementElement, Constraint> tempCons = trans1
//                                    .getChocoConstraints();
//                            Map<String, Variable> tempVars = trans1.getChocoVars();
//                            // para evitar el nullPointerException
//                            Collection<Constraint> auxToArray = new LinkedList<Constraint>(
//                                    tempCons.values());
//                            auxToArray.add(Choco.TRUE);
//                            Constraint[] templateAux = auxToArray
//                                    .toArray(new Constraint[0]);
//                            //Constraint template = Choco.and(templateAux);
//                            //XXX Oferta
//                            ChocoComplianceTranslator trans2 = new ChocoComplianceTranslator(
//                                    aux, tempVars, trans1.getServicePropsMap());
//                            trans2.translate();
//								//Collection<AgreementElement> newVarsFromOffer = trans2.getNewVars();
//                            //Map<String, Variable> tempVars = trans.getChocoVars();
//                            //ChocoTranslator trans = new ChocoTranslator(aux);
//                            /*
//                             // necesito todas las constraints de la plantilla
//                             Map<AgreementElement, Constraint> tempCons = trans
//                             .getChocoConstraints();
//                             Map<String, Variable> tempVars = trans.getChocoVars();
//                             // para evitar el nullPointerException
//                             Collection<Constraint> auxToArray = new LinkedList<Constraint>(
//                             tempCons.values());
//                             auxToArray.add(Choco.TRUE);
//                             // tempCons.put("_TrueAuxConstraint", Choco.TRUE);
//                             Constraint[] templateAux = auxToArray
//                             .toArray(new Constraint[0]);
//                             Constraint template = Choco.and(templateAux);
//                             */
//                            // XXX no considerar los sdt's de forma distinta
//                            //Collection<Constraint> sdtConstraints = trans.getSdtConstraints();
//                            Collection<Constraint> gtConstraints = trans2
//                                    .getGtConstraints();
//                            /*
//                             //int termsArraySize = gtConstraints.size() + sdtConstraints.size();
//                             int termsArraySize = gtConstraints.size();
//                             Constraint[] termsConstraintsarray; 
//                             if (termsArraySize == 0){
//                             //para que al final tengamos algun tipo de restricion si no hay nada
//                             termsConstraintsarray = new Constraint[1];
//                             termsConstraintsarray[0] = Choco.TRUE;
//                             }
//                             else{
//                             termsConstraintsarray = new Constraint[termsArraySize];
//                             Iterator<Constraint> it1 = gtConstraints
//                             .iterator();
//                             int i = 0;
//                             while (it1.hasNext()) {
//                             Constraint c = it1.next();
//                             termsConstraintsarray[i] = c;
//                             i++;
//                             }
//                             //it1 = sdtConstraints.iterator();
//                             //while (it1.hasNext()) {
//                             //Constraint c = it1.next();
//                             //termsConstraintsarray[i] = c;
//                             //i++;
//                             //}
//                             }
//                             */
//                            Collection<Constraint> ccConstraints = trans2
//                                    .getCcConstraints();
//                            Constraint[] ccConstraintsarray;
//                            if (ccConstraints.size() == 0) {
//                                //para que al final tengamos algun tipo de restricion si no hay nada
//                                ccConstraintsarray = new Constraint[1];
//                                ccConstraintsarray[0] = Choco.TRUE;
//                            } else {
//                                ccConstraintsarray = new Constraint[ccConstraints.size()];
//                                Iterator<Constraint> it2 = ccConstraints
//                                        .iterator();
//                                int i = 0;
//                                while (it2.hasNext()) {
//                                    Constraint c = it2.next();
//                                    ccConstraintsarray[i] = c;
//                                    i++;
//                                };
//                            }
//                            //Problema por resolver: cuando las GTs no usan la variable o variables que usan las CCs
//                            //soluci-n actual: usando gtConstraints y ccConstraints
//                            // 1.- extraer variables de GTs
//                            // 2.- por cada CC, ver si su/s variable/s est-n en las GTs o no
//                            // 3.- si no estan copiamos la CC en el conjunto de GTs
//                            // 4.- generamos el array de GTs (por si hemos tenido que a-adir alguna/s CC/s)
//                            // 1.- extraer variables de GTs
//                            Collection<Variable> chocoVars = trans1.getChocoVars().values();
//                            Collection<Variable> gtVars = new HashSet<Variable>();
//                            for (Constraint c : gtConstraints) {
//                                Variable[] vars = c.getVariables();
//                                //Variable[] vars = c.extractVariables();
//                                //System.out.println(vars.toString());
//                                for (int i = 0; i < vars.length; i++) {
//                                    Variable variable = vars[i];
//                                    if (vars[i].extractVariables() != null) {
//                                        Variable[] internalVars = vars[i].extractVariables();
//                                        for (int i2 = 0; i2 < internalVars.length; i2++) {
//                                            Variable variable2 = internalVars[i2];
//                                            if (chocoVars.contains(variable2) && !gtVars.contains(variable2)) {
//                                                gtVars.add(variable2);
//                                            }
//                                        }
//                                    } else {
//                                        variable = vars[i];
//                                        if (chocoVars.contains(variable) && !gtVars.contains(variable)) {
//                                            gtVars.add(variable);
//                                        }
//                                    }
//                                }
//                            }
//                            // 2.- por cada CC, ver si su/s variable/s est-n en las GTs o no
//                            for (Constraint c : ccConstraints) {
//                                Boolean addConstraint = false;
//                                Variable[] vars = c.getVariables();
//                                //Variable[] vars = c.extractVariables();
//                                //System.out.println(vars.toString());
//                                for (int i = 0; i < vars.length; i++) {
//                                    Variable variable = vars[i];
//                                    if (vars[i].extractVariables() != null) {
//                                        Variable[] internalVars = vars[i].extractVariables();
//                                        for (int i2 = 0; i2 < internalVars.length; i2++) {
//                                            Variable variable2 = internalVars[i2];
//                                            if (chocoVars.contains(variable2) && !gtVars.contains(variable2)) {
//                                                addConstraint = true;
//                                                //gtVars.add(variable2);
//                                            }
//                                        }
//                                    } else {
//                                        variable = vars[i];
//                                        if (chocoVars.contains(variable) && !gtVars.contains(variable)) {
//                                            addConstraint = true;
//                                            //gtVars.add(variable);
//                                        }
//                                    }
//                                }
//                                // 3.- si no estan copiamos la CC en el conjunto de GTs
//                                if (addConstraint) {
//                                    gtConstraints.add(c);
//                                }
//                            }
//                            // 4.- generamos el array de GTs (por si hemos tenido que a-adir alguna/s CC/s)
//                            //int termsArraySize = gtConstraints.size() + sdtConstraints.size();
//                            int termsArraySize = gtConstraints.size();
//                            Constraint[] termsConstraintsarray;
//                            if (termsArraySize == 0) {
//                                //para que al final tengamos algun tipo de restricion si no hay nada
//                                termsConstraintsarray = new Constraint[1];
//                                termsConstraintsarray[0] = Choco.TRUE;
//                            } else {
//                                termsConstraintsarray = new Constraint[termsArraySize];
//                                Iterator<Constraint> it1 = gtConstraints
//                                        .iterator();
//                                int i = 0;
//                                while (it1.hasNext()) {
//                                    Constraint c = it1.next();
//                                    termsConstraintsarray[i] = c;
//                                    i++;
//                                }
//                                /*
//                                 it1 = sdtConstraints.iterator();
//                                 while (it1.hasNext()) {
//                                 Constraint c = it1.next();
//                                 termsConstraintsarray[i] = c;
//                                 i++;
//                                 }*/
//                            }
//                            /*
//                             Collection<Variable> ccVars = new HashSet<Variable>();
//                             for (Constraint c : ccConstraints) {
//                             Variable[] vars = c.getVariables();
//                             //Variable[] vars = c.extractVariables();
//                             //System.out.println(vars.toString());
//                             for (int i = 0; i < vars.length; i++) {
//                             Variable variable = vars[i];
//                             if (vars[i].extractVariables()!=null){
//                             Variable[] internalVars = vars[i].extractVariables();
//                             for (int i2 = 0; i2 < internalVars.length; i2++) {
//                             Variable variable2 = internalVars[i2];
//                             if (chocoVars.contains(variable2) && !gtVars.contains(variable2)) {
//                             ccVars.add(variable2);
//                             }
//                             }
//                             } else{
//                             variable = vars[i];
//                             if (chocoVars.contains(variable) && !gtVars.contains(variable)) {
//                             ccVars.add(variable);
//                             }
//                             }
//                             }
//                             }
//                             */
//                            // todas las constraints de SDTs y GTs
//                            Constraint templateTermsConstraint = Choco.and(termsConstraintsarray);
//                            // todas las constraints de las CCs
//                            Constraint templateCcConstraint = Choco.and(ccConstraintsarray);
//                            // XXX el primer par-metro debe ser el equivalente a la template en el compliance 
//                            // y el segundo debe ser el equivalente a la oferta en el compliance
//                            // para reutilizar la operaci-n isCompliantConstraint de cara a
//                            // comprobar si los t-rminos de la plantilla son m-s restrictivos
//                            // o no que las CCs de la plantilla	
//                            b = Utils.isCompliantConstraint(templateTermsConstraint, templateCcConstraint);
//                        }
//                        moreRestrictiveTemplateTerms = b;
//                    }
//                } else {
//                    moreRestrictiveTemplateTerms = false;
//                }
//            }
//        }
//    }
//    /*	
//     // XXX reutilizable
//     protected Collection<Variable> extractUsedVars(Collection<Variable> chocoVars, Constraint[] cons) {
//     Collection<Variable> res = new HashSet<Variable>();
//     Collection<Constraint> constraints = new HashSet<Constraint>();
//     constraints.add
//     for (Constraint c : constraints) {
//     Variable[] vars = c.getVariables();
//     //Variable[] vars = c.extractVariables();
//     //System.out.println(vars.toString());
//     for (int i = 0; i < vars.length; i++) {
//     Variable variable = vars[i];
//     if (vars[i].extractVariables()!=null){
//     Variable[] internalVars = vars[i].extractVariables();
//     for (int i2 = 0; i2 < internalVars.length; i2++) {
//     Variable variable2 = internalVars[i2];
//     if (chocoVars.contains(variable2) && !res.contains(variable2)) {
//     res.add(variable2);
//     }
//     }
//     } else{
//     variable = vars[i];
//     if (chocoVars.contains(variable) && !res.contains(variable)) {
//     res.add(variable);
//     }
//     }
//     }
//     }
//     return res;
//     }
//     */
//
//    public boolean validScopes(AgreementOffer o, Template t) {
//        // XXX recorre la oferta para ver si todos los scopes
//        // tienen su correspondencia en la plantilla
//        Collection<Term> offerTerms = o.getAllTerms();
//        Collection<ServiceScope> offerScopes = new HashSet<ServiceScope>();
//        for (Term term : offerTerms) {
//            if (term instanceof GuaranteeTerm) {
//                GuaranteeTerm gt = (GuaranteeTerm) term;
//                Set<ServiceScope> aux = gt.getScopes();
//                for (ServiceScope ss : aux) {
//                    offerScopes.add(ss);
//                }
//            }
//        }
//        Collection<Term> tempTerms = o.getAllTerms();
//        Collection<ServiceScope> tempScopes = new HashSet<ServiceScope>();
//        for (Term term : tempTerms) {
//            if (term instanceof GuaranteeTerm) {
//                GuaranteeTerm gt = (GuaranteeTerm) term;
//                Set<ServiceScope> aux = gt.getScopes();
//                for (ServiceScope ss : aux) {
//                    tempScopes.add(ss);
//                }
//            }
//        }
//        return tempScopes.containsAll(offerScopes);
//    }
//
//    public Map<AbstractDocument, AbstractDocument> matchViews(Map<ServiceScope, AbstractDocument> offerViews,
//            Map<ServiceScope, AbstractDocument> templateViews) {
//        Map<AbstractDocument, AbstractDocument> res = new HashMap<AbstractDocument, AbstractDocument>();
//        Set<Entry<ServiceScope, AbstractDocument>> set1 = offerViews.entrySet();
//        for (Entry<ServiceScope, AbstractDocument> e1 : set1) {
//            AbstractDocument aux = templateViews.get(e1.getKey());
//            if (aux != null) {
//                res.put(e1.getValue(), aux);
//            } else {
//                //scope declarado en la oferta que no existe en la plantilla!!
//                //error!!!!
//                //de todos modos, esto ya se habria detectado mediante
//                //una comprobacion previa
//            }
//        }
//        return res;
//    }
//}
