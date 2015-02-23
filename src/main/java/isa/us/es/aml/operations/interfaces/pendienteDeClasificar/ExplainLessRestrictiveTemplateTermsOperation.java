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
//package isa.us.es.aml.operations.interfaces.pendienteDeClasificar;
//
//import isa.us.es.aml.adaintegration.adaadhoc.ada.errors.AgreementError;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.errors.Explanation;
//import isa.us.es.aml.operations.Operation;
//import java.util.Map;
//
///**
// * Explains the reasons why the template GTs are less restrictive than the
// * template CCs. The result is a mapping. For each less restrictive GT, the
// * operation associate a set of elements collides with it on the template CCs.
// *
// * @author Carlos
// *
// */
//public interface ExplainLessRestrictiveTemplateTermsOperation extends Operation {
//
//    /**
//     * Returns the mapping between Less Restrictive template GTs and template
//     * CCs
//     *
//     * @return Map<AgreementError,Explanation>>
//     */
//    int STANDARD_LEVEL = 0;
//    int REFINE_OFFER = 1;
//    int REFINE_TEMPLATE = 2;
//    int REFINE_ALL = 3;
//
//    public Map<AgreementError, Explanation> explainErrors();
//
//    public void setExplanationLevel(int level);
//}
