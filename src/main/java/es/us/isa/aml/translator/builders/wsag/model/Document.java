/*******************************************************************************
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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.translator.builders.wsag.model;

import es.us.isa.aml.model.AbstractModel;


/**
 * @author jdelafuente
 *
 */
public class Document extends AbstractModel {

    /**
     * This is a mandatory identifier of this particular version of the
     * agreement. It MUST be unique between Agreement Initiator and Agreement
     * Responder.
     */
    private String id;

    /**
     * This is an OPTIONAL name that can be given to an agreement. The name of
     * an agreement is independent of the name(s) of the template(s) it is based
     * on. The Name element is NOT a unique identifier. It MAY be used to
     * provide a human-understandable name to an agreement in addition to the
     * Endpoint Reference of the Agreement Resource that will be created in the
     * protocol.
     */
    private String name;

    /**
     * This is a REQUIRED element in the agreement and provides information
     * about the agreement that is not specified in the terms such as who the
     * involved parties are, what the services is that is being agree to, and
     * the duration of the agreement.
     */
    private Context context = new Context();

    /**
     * The terms of an agreement comprises one or more service definition terms,
     * and zero or more guarantee terms grouped using logical grouping
     * operators.
     */
    private TermCompositor terms = new TermCompositor();

    public Document() {
        id = "";
        name = "";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * @return the terms
     */
    public TermCompositor getTerms() {
        return terms;
    }

    /**
     * @param terms the terms to set
     */
    public void setTerms(TermCompositor terms) {
        this.terms = terms;
    }
}
