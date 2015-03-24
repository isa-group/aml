/**
 *
 */
package es.us.isa.aml.translators.wsag.model;

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

}
