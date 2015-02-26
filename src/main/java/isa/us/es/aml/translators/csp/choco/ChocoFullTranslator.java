///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package isa.us.es.aml.translators.csp.choco;
//
//import choco.Choco;
//import choco.kernel.model.constraints.Constraint;
//import choco.kernel.model.variables.Variable;
//import choco.kernel.model.variables.integer.IntegerVariable;
//import choco.kernel.model.variables.real.RealVariable;
//import choco.kernel.solver.variables.Domain;
//import choco.kernel.solver.variables.real.RealDomain;
//import isa.us.es.aml.model.AgreementElement;
//import isa.us.es.aml.model.AgreementOffer;
//import isa.us.es.aml.model.GuaranteeTerm;
//import isa.us.es.aml.model.Template;
////import isa.us.es.aml.parsers.choco.ChocoParser;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//import javax.swing.text.AbstractDocument;
//import org.antlr.v4.runtime.misc.Utils;
//import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList.Member2.Item;
//import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
//
///**
// *
// * @author AntonioGamez
// */
//public class ChocoFullTranslator extends ChocoTranslator {
//
//    private ChocoParser p;
//    protected AbstractDocument doc;
//    protected Map<String, Variable> chocoVars;
//    protected Map<AgreementElement, Constraint> chocoConstraints;
//    protected Collection<AgreementElement> duplicatedVars;
//    protected Map<GuaranteeTerm, ChocoComplexGT> complexGTs;
//    protected Map<GuaranteeTerm, Float> wrongUtilityVals;
//    protected Collection<Term> duplicatedSDTsGTs;
//    private Collection<AgreementElement> unknownVars;
//    protected Map<String, isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable> servicePropsMap;
//    private boolean isTemplate;
//    private Collection<Constraint> domainExtraConstraints;
//
//    public ChocoFullTranslator(AbstractDocument d) {
//        reset();
//        doc = d;
//    }
//
//    public ChocoFullTranslator(AbstractDocument d, Map<String, Variable> vars) {
//        reset();
//        doc = d;
//        chocoVars = new HashMap<String, Variable>(vars);
//    }
//
//    protected void reset() {
//        p = new ChocoParser();
//        isTemplate = false;
//        chocoVars = new HashMap<String, Variable>();
//        chocoConstraints = new HashMap<AgreementElement, Constraint>();
//        servicePropsMap = new HashMap<String, isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable>();
//        duplicatedVars = new LinkedList<AgreementElement>();
//        complexGTs = new HashMap<GuaranteeTerm, ChocoComplexGT>();
//        wrongUtilityVals = new HashMap<GuaranteeTerm, Float>();
//        duplicatedSDTsGTs = new HashSet<Term>();
//        unknownVars = new HashSet<AgreementElement>();
//    }
//
//    public void translate() {
//        AbstractAgreementDocument entryAgreement = (AbstractAgreementDocument) doc;
//        Iterator<Term> it = entryAgreement.getTerms().getComprisedTerms().iterator();
//        this.mapProperties(it);
//        p.setVariables(chocoVars);
//        this.mapTerms(entryAgreement.getTerms().getComprisedTerms());
//        if (entryAgreement instanceof Template) {
//            isTemplate = true;
//            Template template = (Template) entryAgreement;
//            CreationConstraints cc = template.getCc();
//            Set<Item> items = cc.getItems();
//            Iterator<Item> itemsIterator = items.iterator();
//            while (itemsIterator.hasNext()) {
//                Item item = itemsIterator.next();
//                addItemVar(item);
//            }
//            Set<GeneralConstraint> cons = cc.getConstraints();
//            Iterator<GeneralConstraint> consIterator = cons.iterator();
//            while (consIterator.hasNext()) {
//                GeneralConstraint genCon = consIterator.next();
//                String stringConstraint = genCon.getConstraint();
//                ParsingResult ps = p.parseConstraint(stringConstraint);
//                if (!ps.getUnknownVars().isEmpty()) {
//                    if (isTemplate) {
//                        unknownVars.add(genCon);
//                    }
//                } else {
//                    Constraint c = ps.getConstraint();
//                    chocoConstraints.put(genCon, c);
//                }
//            }
//        }
//    }
//
//    protected void mapProperties(Iterator<Term> it) {
//        while (it.hasNext()) {
//            Term term = (Term) it.next();
//            ServiceProperties sp = new ServiceProperties();
//            if (term instanceof ServiceProperties) {
//                sp = (ServiceProperties) term;
//                Set<isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable> variables = sp.getVariableSet();
//                Iterator<isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable> it3 = variables.iterator();
//                while (it3.hasNext()) {
//                    isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable v = (isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable) it3.next();
//                    addVar(v);
//                }
//            }
//        }
//    }
//
//    protected void addVar(isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable var) {
//        Variable v = null;
//        String name = var.getUniqueName();
//        if (!chocoVars.containsKey(name)) {
//            Domain d = var.getDomain();
//            if (d instanceof IntegerDomain) {
//                IntegerDomain dom = (IntegerDomain) d;
//                Collection<IntegerRange> ranges = dom.getRanges();
//                int absoluteMin = Integer.MAX_VALUE, absoluteMax = Integer.MIN_VALUE;
//                for (IntegerRange range : ranges) {
//                    if (range.getMin() < absoluteMin) {
//                        absoluteMin = range.getMin();
//                    }
//                    if (range.getMax() > absoluteMax) {
//                        absoluteMax = range.getMax();
//                    }
//                }
//                IntegerVariable chocoVar = Choco.makeIntVar(name, absoluteMin, absoluteMax);
//                if (ranges.size() > 1) {
//                    Collection<Constraint> consCol = new LinkedList<Constraint>();
//                    for (IntegerRange range : ranges) {
//                        Constraint aux = Choco.and(Choco.geq(chocoVar, range.getMin()), Choco.leq(chocoVar, range.getMax()));
//                        consCol.add(aux);
//                    }
//                    Constraint[] consArray = consCol.toArray(new Constraint[0]);
//                    Constraint domainConstraint = Choco.and(consArray);
//                    domainExtraConstraints.add(domainConstraint);
//                }
//                v = chocoVar;
//            } else if (d instanceof RealDomain) {
//                RealDomain dom = (RealDomain) d;
//                Collection<RealRange> ranges = dom.getRanges();
//                double absoluteMin = Double.POSITIVE_INFINITY, absoluteMax = Double.NEGATIVE_INFINITY;
//                for (RealRange range : ranges) {
//                    if (range.getMin() < absoluteMin) {
//                        absoluteMin = range.getMin();
//                    }
//                    if (range.getMax() > absoluteMax) {
//                        absoluteMax = range.getMax();
//                    }
//                }
//                RealVariable chocoVar = Choco.makeRealVar(name, absoluteMin, absoluteMax);
//                if (ranges.size() > 1) {
//                    Collection<Constraint> consCol = new LinkedList<Constraint>();
//                    for (RealRange range : ranges) {
//                        Constraint aux = Choco.and(Choco.geq(chocoVar, range.getMin()), Choco.leq(chocoVar, range.getMax()));
//                        consCol.add(aux);
//                    }
//                    Constraint[] consArray = consCol.toArray(new Constraint[0]);
//                    Constraint domainConstraint = Choco.and(consArray);
//                    domainExtraConstraints.add(domainConstraint);
//                }
//                v = chocoVar;
//            } else if (d instanceof EnumeratedDomain) {
//                EnumeratedDomain dom = (EnumeratedDomain) d;
//                Collection<Integer> col = dom.getIntegerValues();
//                int[] values = new int[col.size()];
//                int i = 0;
//                for (Integer elem : col) {
//                    values[i] = elem;
//                    i++;
//                }
//                IntegerVariable intVar = Choco.makeIntVar(name, values);
//                v = intVar;
//            }
//            chocoVars.put(var.getUniqueName(), v);
//            servicePropsMap.put(var.getUniqueName(), var);
//        } else {
//            duplicatedVars.add(var);
//        }
//    }
//
//    protected void addItemVar(Item i) {
//        String location = i.getLocation();
//        location = location.trim();
//        location = location.replace("\\", "");
//        String vName = location.replace("/", "");
//        Restriction r = (Restriction) i.getIconst();
//        String sMin = r.getMinInclusive(), sMax = r.getMaxInclusive();
//        if (!chocoVars.containsKey(vName)) {
//            unknownVars.add(i);
//        } else {
//            Variable v = chocoVars.get(vName);
//            if (v instanceof IntegerVariable) {
//                int min = Integer.parseInt(sMin), max = Integer.parseInt(sMax);
//                IntegerVariable intVar = (IntegerVariable) v;
//                Constraint c = Choco.and(Choco.leq(intVar, max), Choco.geq(intVar, min));
//                chocoConstraints.put(i, c);
//            } else if (v instanceof RealVariable) {
//                double min = Double.parseDouble(sMin), max = Double.parseDouble(sMax);
//                RealVariable realVar = (RealVariable) v;
//                Constraint c = Choco.and(Choco.leq(realVar, max), Choco.geq(realVar, min));
//                chocoConstraints.put(i, c);
//            } else {
//            }
//        }
//    }
//
//    protected void mapTerms(List<Term> list) {
//        for (Term t : list) {
//            if (t instanceof ServiceDescriptionTerm) {
//                termToConstraint(t);
//            }
//        }
//        Iterator<Term> it = list.iterator();
//        while (it.hasNext()) {
//            Term term = it.next();
//            if (!(term instanceof ServiceDescriptionTerm)) {
//                termToConstraint(term);
//            }
//        }
//    }
//
//    protected Constraint termToConstraint(Term term) {
//        Constraint res = null;
//        if (term instanceof ServiceDescriptionTerm) {
//            ServiceDescriptionTerm sdt = (ServiceDescriptionTerm) term;
//            Map<isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction> moreFeatures = sdt.getServiceFeatures();
//            Iterator<Entry<isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction>> secondIt = moreFeatures.entrySet().iterator();
//            while (secondIt.hasNext()) {
//                Entry<isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction> entry = secondIt.next();
//                isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable agreementVar = entry.getKey();
//                addVar(agreementVar);
//                p.setVariables(chocoVars);
//            }
//            if (doc instanceof AgreementOffer) {
//                Iterator<OfferItem> itSdt = sdt.getOfferItems().iterator();
//                while (itSdt.hasNext()) {
//                    OfferItem oi = itSdt.next();
//                    Restriction value = oi.getRestriction();
//                    if (!value.getFixedValue().equals("")) {
//                        Constraint c;
//                        try {
//                            c = Utils.restriction2Choco(oi.getName(), value, chocoVars);
//                            chocoConstraints.put(oi, c);
//                        } catch (UnknownVariableException e) {
//                        }
//                    }
//                }
//            }
//        } else if (term instanceof GuaranteeTerm) {
//            GuaranteeTerm gt = (GuaranteeTerm) term;
//            if (!gt.hasQualifyCondition()) {
//                StringSLO slo = new StringSLO();
//                if (slo.getClass().isInstance(gt.getSlo())) {
//                    slo = (StringSLO) gt.getSlo();
//                    String stringConstraint = slo.getSlo();
//                    ParsingResult ps = p.parseConstraint(stringConstraint);
//                    res = ps.getConstraint();
//                    if (!ps.getUnknownVars().isEmpty()) {
//                        res = Choco.TRUE;
//                        if (isTemplate) {
//                            unknownVars.add(gt);
//                        }
//                    }
//                    chocoConstraints.put(gt, res);
//                }
//            } else {
//                StringSLO slo = new StringSLO();
//                if (slo.getClass().isInstance(gt.getSlo())) {
//                    slo = (StringSLO) gt.getSlo();
//                    String stringConstraint = slo.getSlo();
//                    ParsingResult ps1 = p.parseConstraint(stringConstraint);
//                    Constraint c1 = ps1.getConstraint();
//                    String qualifyCond = gt.getQualifyingCondition();
//                    ParsingResult ps2 = p.parseConstraint(qualifyCond);
//                    Constraint c2 = ps2.getConstraint();
//                    chocoConstraints.put(gt, c2);
//                    if (!ps1.getUnknownVars().isEmpty() || !ps2.getUnknownVars().isEmpty()) {
//                        if (isTemplate) {
//                            unknownVars.add(gt);
//                        }
//                        res = Choco.TRUE;
//                    } else {
//                        ChocoComplexGT complexGT = new ChocoComplexGT(c2, c1, gt);
//                        complexGTs.put(gt, complexGT);
//                        res = Choco.implies(c2, c1);
//                        chocoConstraints.put(gt, res);
//                    }
//                }
//            }
//            Collection<Preference> utilVals = gt.getBvl().getPreferences();
//            Iterator<Preference> it = utilVals.iterator();
//            Set<ServiceDescriptionTerm> sdts = new HashSet<ServiceDescriptionTerm>();
//            float sum = 0;
//            while (it.hasNext()) {
//                Preference p = it.next();
//                sum = sum + p.getUtility();
//                ServiceDescriptionTerm aux = p.getServiceTermReference();
//                if (sdts.contains(aux)) {
//                    duplicatedSDTsGTs.add(gt);
//                } else {
//                    sdts.add(aux);
//                }
//            }
//            if (sum > 1) {
//                wrongUtilityVals.put(gt, sum);
//            }
//        } else if (term instanceof ServiceReference) {
//        }
//        return res;
//    }
//
//    protected boolean isInteger(String s) {
//        try {
//            Integer.parseInt(s);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//    protected boolean isReal(String s) {
//        try {
//            Double.parseDouble(s);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//    protected IntegerVariable makeIntegerVar(String s, int min, int max) {
//        return Choco.makeIntVar(s, min, max);
//    }
//
//    protected RealVariable makeRealVar(String s, double min, double max) {
//        return Choco.makeRealVar(s, min, max);
//    }
//
//    public AbstractDocument getDoc() {
//        return doc;
//    }
//
//    @Override
//    public Map<String, Variable> getChocoVars() {
//        return chocoVars;
//    }
//
//    @Override
//    public Map<AgreementElement, Constraint> getChocoConstraints() {
//        return chocoConstraints;
//    }
//
//    public Map<String, isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Variable> getServicePropsMap() {
//        return servicePropsMap;
//    }
//
//    public Collection<AgreementElement> getDuplicatedVars() {
//        return duplicatedVars;
//    }
//
//    public Map<GuaranteeTerm, ChocoComplexGT> getComplexGTs() {
//        return complexGTs;
//    }
//
//    public Collection<Term> getDuplicatedSDTsGTs() {
//        return duplicatedSDTsGTs;
//    }
//
//    public Map<GuaranteeTerm, Float> getBadUtilitySums() {
//        return wrongUtilityVals;
//    }
//
//    public Collection<AgreementElement> getUnknownVars() {
//        return unknownVars;
//    }
//
//    public Collection<Constraint> getDomainAdditionalConstraints() {
//        return domainExtraConstraints;
//    }
//}
