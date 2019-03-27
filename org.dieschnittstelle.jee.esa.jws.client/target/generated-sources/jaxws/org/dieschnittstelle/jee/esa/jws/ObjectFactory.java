
package org.dieschnittstelle.jee.esa.jws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dieschnittstelle.jee.esa.jws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateTouchpoint_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "createTouchpoint");
    private final static QName _CreateTouchpointResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "createTouchpointResponse");
    private final static QName _DeleteTouchpoint_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "deleteTouchpoint");
    private final static QName _DeleteTouchpointResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "deleteTouchpointResponse");
    private final static QName _ReadAllTouchpoints_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "readAllTouchpoints");
    private final static QName _ReadAllTouchpointsResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "readAllTouchpointsResponse");
    private final static QName _UpdateTouchpoint_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "updateTouchpoint");
    private final static QName _UpdateTouchpointResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jws", "updateTouchpointResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dieschnittstelle.jee.esa.jws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateTouchpoint }
     * 
     */
    public CreateTouchpoint createCreateTouchpoint() {
        return new CreateTouchpoint();
    }

    /**
     * Create an instance of {@link CreateTouchpointResponse }
     * 
     */
    public CreateTouchpointResponse createCreateTouchpointResponse() {
        return new CreateTouchpointResponse();
    }

    /**
     * Create an instance of {@link DeleteTouchpoint }
     * 
     */
    public DeleteTouchpoint createDeleteTouchpoint() {
        return new DeleteTouchpoint();
    }

    /**
     * Create an instance of {@link DeleteTouchpointResponse }
     * 
     */
    public DeleteTouchpointResponse createDeleteTouchpointResponse() {
        return new DeleteTouchpointResponse();
    }

    /**
     * Create an instance of {@link ReadAllTouchpoints }
     * 
     */
    public ReadAllTouchpoints createReadAllTouchpoints() {
        return new ReadAllTouchpoints();
    }

    /**
     * Create an instance of {@link ReadAllTouchpointsResponse }
     * 
     */
    public ReadAllTouchpointsResponse createReadAllTouchpointsResponse() {
        return new ReadAllTouchpointsResponse();
    }

    /**
     * Create an instance of {@link UpdateTouchpoint }
     * 
     */
    public UpdateTouchpoint createUpdateTouchpoint() {
        return new UpdateTouchpoint();
    }

    /**
     * Create an instance of {@link UpdateTouchpointResponse }
     * 
     */
    public UpdateTouchpointResponse createUpdateTouchpointResponse() {
        return new UpdateTouchpointResponse();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link MobileTouchpoint }
     * 
     */
    public MobileTouchpoint createMobileTouchpoint() {
        return new MobileTouchpoint();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTouchpoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "createTouchpoint")
    public JAXBElement<CreateTouchpoint> createCreateTouchpoint(CreateTouchpoint value) {
        return new JAXBElement<CreateTouchpoint>(_CreateTouchpoint_QNAME, CreateTouchpoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTouchpointResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "createTouchpointResponse")
    public JAXBElement<CreateTouchpointResponse> createCreateTouchpointResponse(CreateTouchpointResponse value) {
        return new JAXBElement<CreateTouchpointResponse>(_CreateTouchpointResponse_QNAME, CreateTouchpointResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTouchpoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "deleteTouchpoint")
    public JAXBElement<DeleteTouchpoint> createDeleteTouchpoint(DeleteTouchpoint value) {
        return new JAXBElement<DeleteTouchpoint>(_DeleteTouchpoint_QNAME, DeleteTouchpoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTouchpointResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "deleteTouchpointResponse")
    public JAXBElement<DeleteTouchpointResponse> createDeleteTouchpointResponse(DeleteTouchpointResponse value) {
        return new JAXBElement<DeleteTouchpointResponse>(_DeleteTouchpointResponse_QNAME, DeleteTouchpointResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadAllTouchpoints }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "readAllTouchpoints")
    public JAXBElement<ReadAllTouchpoints> createReadAllTouchpoints(ReadAllTouchpoints value) {
        return new JAXBElement<ReadAllTouchpoints>(_ReadAllTouchpoints_QNAME, ReadAllTouchpoints.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadAllTouchpointsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "readAllTouchpointsResponse")
    public JAXBElement<ReadAllTouchpointsResponse> createReadAllTouchpointsResponse(ReadAllTouchpointsResponse value) {
        return new JAXBElement<ReadAllTouchpointsResponse>(_ReadAllTouchpointsResponse_QNAME, ReadAllTouchpointsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTouchpoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "updateTouchpoint")
    public JAXBElement<UpdateTouchpoint> createUpdateTouchpoint(UpdateTouchpoint value) {
        return new JAXBElement<UpdateTouchpoint>(_UpdateTouchpoint_QNAME, UpdateTouchpoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTouchpointResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jws", name = "updateTouchpointResponse")
    public JAXBElement<UpdateTouchpointResponse> createUpdateTouchpointResponse(UpdateTouchpointResponse value) {
        return new JAXBElement<UpdateTouchpointResponse>(_UpdateTouchpointResponse_QNAME, UpdateTouchpointResponse.class, null, value);
    }

}
