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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Within Terms compositor, special compositor elements can be used as logical
 * AND/OR/XOR operators to combine terms. This enables the specification of
 * alternative branches with potentially complex nesting within the terms of
 * agreement. The terms consist of one or more service terms and zero or more
 * guarantee terms grouped using the logical grouping compositors. Term
 * compositors are structural elements of an agreement offer and the agreement.
 * Choices expressed using compositors MUST be exercised by the service provider
 * to satisfy the described requirements through some concrete delivery of
 * service.
 *
 * @author jdelafuente
 *
 */
public class TermCompositor {

	/**
	 * This is a logical AND (or OR, or XOR) operator of type TermCompositorType
	 * which is used to logically group terms and/or other compositors
	 * underneath it.
	 */
	private TermCompositorType compositorType = TermCompositorType.All;

	/**
	 * These terms are OPTIONAL. A service reference contains a domain-specific
	 * reference to an existing service.
	 */
	private ServiceReference serviceReference = new ServiceReference();

	/**
	 * A Service Description Term provides an inline full or partial functional
	 * description of a new service, i.e. the information necessary to provide
	 * the service to the consumer.
	 */
	private ServiceDescriptionTerm serviceDescriptionTerm = new ServiceDescriptionTerm();

	/**
	 * These terms are OPTIONAL. Service properties specify domain-specific
	 * aspects of a service that can be used to express the non-functional
	 * requirements (guarantees) of the service.
	 */
	private ServiceProperties serviceProperties = new ServiceProperties();

	/**
	 * These terms are OPTIONAL and MAY specify the guarantees (both promises
	 * and penalties) that are associated with the other terms in the agreement.
	 */
	private List<GuaranteeTerm> guaranteeTerms = new ArrayList<>();

	/**
	 * @return the compositorType
	 */
	public TermCompositorType getCompositorType() {
		return compositorType;
	}

	/**
	 * @param compositorType
	 *            the compositorType to set
	 */
	public void setCompositorType(TermCompositorType compositorType) {
		this.compositorType = compositorType;
	}

	/**
	 * @return the serviceDescriptionTerm
	 */
	public ServiceDescriptionTerm getServiceDescriptionTerm() {
		return serviceDescriptionTerm;
	}

	/**
	 * @param serviceDescriptionTerm
	 *            the serviceDescriptionTerm to set
	 */
	public void setServiceDescriptionTerm(
			ServiceDescriptionTerm serviceDescriptionTerm) {
		this.serviceDescriptionTerm = serviceDescriptionTerm;
	}

	/**
	 * @return the serviceReference
	 */
	public ServiceReference getServiceReference() {
		return serviceReference;
	}

	/**
	 * @param serviceReference
	 *            the serviceReference to set
	 */
	public void setServiceReference(ServiceReference serviceReference) {
		this.serviceReference = serviceReference;
	}

	/**
	 * @return the serviceProperties
	 */
	public ServiceProperties getServiceProperties() {
		return serviceProperties;
	}

	/**
	 * @param serviceProperties
	 *            the serviceProperties to set
	 */
	public void setServiceProperties(ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	/**
	 * @return the guaranteeTerm
	 */
	public List<GuaranteeTerm> getGuaranteeTerms() {
		return guaranteeTerms;
	}

	/**
	 * @param guaranteeTerms
	 *            the guaranteeTerms list to set
	 */
	public void setGuaranteeTerms(List<GuaranteeTerm> guaranteeTerms) {
		this.guaranteeTerms = guaranteeTerms;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\t" + "<wsag:Terms ")
				.append("wsag:Name=\"" + getServiceReference().getName()
						+ "\">").append("\n");
		sb.append("\t\t" + "<wsag:All>").append("\n");
		if (getServiceDescriptionTerm() != null) {
			sb.append(getServiceDescriptionTerm().toString()).append("\n");
		}
		if (getServiceProperties() != null) {
			sb.append(getServiceProperties().toString()).append("\n");
		}
		if (getGuaranteeTerms() != null) {
			for (GuaranteeTerm gt : getGuaranteeTerms()) {
				sb.append(gt.toString()).append("\n");
			}
		}
		sb.append("\t\t" + "</wsag:All>").append("\n");
		sb.append("\t" + "</wsag:Terms>").append("\n");

		return sb.toString();

	}

	public enum TermCompositorType {

		All, OneOrMore, ExactlyOne
	}

}
