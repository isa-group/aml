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
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.questions.ChocoAlternativeDocumentsOp;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.questions.ChocoDecomposeIntoViewsOp;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.document.AbstractDocument;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
//import isa.us.es.aml.operations.Operation;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import javax.swing.text.AbstractDocument;
//
//public abstract class ChocoOperation implements Operation {
//
//    public List<AbstractDocument> docs;
//
//    public ChocoOperation() {
//        docs = new LinkedList<AbstractDocument>();
//    }
//
//    @Override
//    public void addDocument(AbstractDocument doc) {
//        docs.add(doc);
//    }
//
//    @Override
//    public void addDocuments(Collection<AbstractDocument> docz) {
//        docs.addAll(docz);
//    }
//
//    public abstract void execute(ChocoAnalyzer an);
//
//    public Map<ServiceScope, AbstractDocument> getViews(AbstractDocument doc, ChocoAnalyzer an) {
//        ChocoDecomposeIntoViewsOp op = new ChocoDecomposeIntoViewsOp();
//        op.addDocument(doc);
//        an.analyze(op);
//        return op.getScopes2Views();
//    }
//
//    public Collection<AbstractDocument> getAlternatives(AbstractDocument doc, ChocoAnalyzer an, boolean orToand) {
//        ChocoAlternativeDocumentsOp op = new ChocoAlternativeDocumentsOp();
//        op.orToAnd(orToand);
//        op.addDocument(doc);
//        an.analyze(op);
//        return op.getAlternativeDocuments();
//    }
//}
