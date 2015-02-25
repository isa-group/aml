//package isa.us.es.aml.translators.csp.choco;
//
//import choco.Choco;
//import choco.kernel.model.constraints.Constraint;
//import choco.kernel.model.variables.integer.IntegerExpressionVariable;
//import choco.kernel.model.variables.integer.IntegerVariable;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import javax.swing.text.AbstractDocument;
//
///**
// *
// * @author AntonioGamez
// */
//public class ChocoTranslator4Alternative extends ChocoTranslator {
//
//    private AbstractAgreementDocument doc;
//    private Collection<Constraint> chocoConstraints;
//    private Map<IntegerVariable, Term> varsToTerms;
//    //XXX con este atributo a cierto, mapeamos los term compositor OneOrMore como All
//    private boolean orToAnd;
//
//    public ChocoTranslator4Alternative(AbstractDocument d) {
//        this(d, false);
//    }
//
//    public ChocoTranslator4Alternative(AbstractDocument d, boolean orToAnd) {
//        doc = (AbstractAgreementDocument) d;
//        this.orToAnd = orToAnd;
//        reset();
//    }
//
//    protected void reset() {
//        varsToTerms = new HashMap<IntegerVariable, Term>();
//        chocoConstraints = new LinkedList<Constraint>();
//    }
//
//    public void translate() {
//        Term term = doc.getTerms();
//        IntegerVariable var = termToChoco(term);
//        chocoConstraints.add(Choco.eq(var, 1));
//    }
//
//    protected IntegerVariable termToChoco(Term term) {
//        IntegerVariable res = null;
//        if (term instanceof TermCompositor) {
//            TermCompositor compositor = (TermCompositor) term;
//            List<Term> termList = compositor.getComprisedTerms();
//            Iterator<Term> it = termList.iterator();
//            IntegerVariable[] array = new IntegerVariable[termList.size()];
//            int i = 0;
//            while (it.hasNext()) {
//                Term t = it.next();
//                IntegerVariable aux = termToChoco(t);
//                array[i] = aux;
//                i++;
//            }
//            IntegerExpressionVariable iev = Choco.sum(array);
//            res = Choco.makeBooleanVar(term.getName());
//            Constraint c = null;
//            String type = compositor.getType();
//            if (type.equals(TermCompositor.ALL)) {
//                c = Choco.ifThenElse(Choco.eq(res, 1), Choco.eq(iev,
//                        array.length), Choco.eq(iev, 0));
//            } else if (type.equals(TermCompositor.EXACTLY_ONE)) {
//                c = Choco.ifThenElse(Choco.eq(res, 1), Choco.eq(iev, 1), Choco.eq(iev, 0));
//            } else if (type.equals(TermCompositor.ONE_OR_MORE)) {
//                if (orToAnd) {
//                    c = Choco.ifThenElse(Choco.eq(res, 1), Choco.eq(iev,
//                            array.length), Choco.eq(iev, 0));
//                } else {
//                    c = Choco.ifThenElse(Choco.eq(res, 1), Choco.geq(iev, 1), Choco.eq(iev, 0));
//                }
//            }
//            chocoConstraints.add(c);
//        } else {
//            res = Choco.makeBooleanVar(term.getName());
//            varsToTerms.put(res, term);
//        }
//        return res;
//    }
//
//    @Override
//    public Collection<Constraint> getChocoConstraints() {
//        return chocoConstraints;
//    }
//
//    public Map<IntegerVariable, Term> getVarsToTerms() {
//        return varsToTerms;
//    }
//}
