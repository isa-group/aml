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

/**
 * A Service Reference points to a service, e.g., by providing an Endpoint
 * Reference. Both parties understand the semantics of the service that is
 * referred to or know how to query the service about its properties.
 *
 * @author jdelafuente
 *
 */
public class ServiceReference {

    /**
     * This is the name given to this set of service references.
     */
    private String name;

    /**
     * This attribute identifies a service across multiple service description
     * terms. The purpose of this attribute has been described previously.
     */
    private String serviceName;

    
    public ServiceReference() {
	}
    
	/**
	 * @param name The name of this service reference
	 */
	public ServiceReference(String name) {
		super();
		this.name = name;
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
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
