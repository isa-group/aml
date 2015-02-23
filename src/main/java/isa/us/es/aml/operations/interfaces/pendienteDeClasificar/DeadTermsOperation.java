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
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.Term;
//import isa.us.es.aml.operations.Operation;
//import java.util.Collection;
//
///**
// * Determines the set of dead terms of an agreement document
// *
// */
//public interface DeadTermsOperation extends Operation {
//
//    /**
//     * Returns true if the document has dead terms.
//     *
//     * A term is considered as dead when its qualifying condition is never hold
//     * since it collides with other elements of the document
//     *
//     * @return boolean
//     */
//    public boolean hasDeadTerms();
//
//    /**
//     * Returns a collection with the agreement document's dead terms.
//     *
//     * A term is considered as dead when its qualifyng condition is never hold
//     * since it collides with other elements of the document
//     *
//     * @return Collection<Term>
//     */
//    public Collection<Term> getDeadTerms();
//}
