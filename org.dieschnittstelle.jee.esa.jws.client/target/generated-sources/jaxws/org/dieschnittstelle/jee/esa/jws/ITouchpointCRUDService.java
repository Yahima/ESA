package org.dieschnittstelle.jee.esa.jws;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2018-11-28T22:38:42.450+01:00
 * Generated source version: 3.1.5
 * 
 */
@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", name = "ITouchpointCRUDService")
@XmlSeeAlso({org.dieschnittstelle.jee.esa.entities.crm.ws.ObjectFactory.class, ObjectFactory.class})
public interface ITouchpointCRUDService {

    @WebMethod(operationName = "updateTouchpoint")
    @RequestWrapper(localName = "updateTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.UpdateTouchpoint")
    @ResponseWrapper(localName = "updateTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.UpdateTouchpointResponse")
    public Response<org.dieschnittstelle.jee.esa.jws.UpdateTouchpointResponse> updateTouchpointAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint arg1
    );

    @WebMethod(operationName = "updateTouchpoint")
    @ResponseWrapper(localName = "updateTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.UpdateTouchpointResponse")
    @RequestWrapper(localName = "updateTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.UpdateTouchpoint")
    public Future<?> updateTouchpointAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint arg1,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<org.dieschnittstelle.jee.esa.jws.UpdateTouchpointResponse> asyncHandler
    );

    @WebMethod
    @RequestWrapper(localName = "updateTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.UpdateTouchpoint")
    @ResponseWrapper(localName = "updateTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.UpdateTouchpointResponse")
    @WebResult(name = "return", targetNamespace = "")
    public org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint updateTouchpoint(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint arg1
    );

    @WebMethod(operationName = "deleteTouchpoint")
    @RequestWrapper(localName = "deleteTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.DeleteTouchpoint")
    @ResponseWrapper(localName = "deleteTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.DeleteTouchpointResponse")
    public Response<org.dieschnittstelle.jee.esa.jws.DeleteTouchpointResponse> deleteTouchpointAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0
    );

    @WebMethod(operationName = "deleteTouchpoint")
    @ResponseWrapper(localName = "deleteTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.DeleteTouchpointResponse")
    @RequestWrapper(localName = "deleteTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.DeleteTouchpoint")
    public Future<?> deleteTouchpointAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<org.dieschnittstelle.jee.esa.jws.DeleteTouchpointResponse> asyncHandler
    );

    @WebMethod
    @RequestWrapper(localName = "deleteTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.DeleteTouchpoint")
    @ResponseWrapper(localName = "deleteTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.DeleteTouchpointResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deleteTouchpoint(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0
    );

    @WebMethod(operationName = "createTouchpoint")
    @RequestWrapper(localName = "createTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.CreateTouchpoint")
    @ResponseWrapper(localName = "createTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.CreateTouchpointResponse")
    public Response<org.dieschnittstelle.jee.esa.jws.CreateTouchpointResponse> createTouchpointAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint arg0
    );

    @WebMethod(operationName = "createTouchpoint")
    @ResponseWrapper(localName = "createTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.CreateTouchpointResponse")
    @RequestWrapper(localName = "createTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.CreateTouchpoint")
    public Future<?> createTouchpointAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint arg0,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<org.dieschnittstelle.jee.esa.jws.CreateTouchpointResponse> asyncHandler
    );

    @WebMethod
    @RequestWrapper(localName = "createTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.CreateTouchpoint")
    @ResponseWrapper(localName = "createTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.CreateTouchpointResponse")
    @WebResult(name = "return", targetNamespace = "")
    public org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint createTouchpoint(
        @WebParam(name = "arg0", targetNamespace = "")
        org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint arg0
    );

    @WebMethod(operationName = "readAllTouchpoints")
    @RequestWrapper(localName = "readAllTouchpoints", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.ReadAllTouchpoints")
    @ResponseWrapper(localName = "readAllTouchpointsResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.ReadAllTouchpointsResponse")
    public Response<org.dieschnittstelle.jee.esa.jws.ReadAllTouchpointsResponse> readAllTouchpointsAsync();

    @WebMethod(operationName = "readAllTouchpoints")
    @ResponseWrapper(localName = "readAllTouchpointsResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.ReadAllTouchpointsResponse")
    @RequestWrapper(localName = "readAllTouchpoints", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.ReadAllTouchpoints")
    public Future<?> readAllTouchpointsAsync(
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<org.dieschnittstelle.jee.esa.jws.ReadAllTouchpointsResponse> asyncHandler
    );

    @WebMethod
    @RequestWrapper(localName = "readAllTouchpoints", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.ReadAllTouchpoints")
    @ResponseWrapper(localName = "readAllTouchpointsResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", className = "org.dieschnittstelle.jee.esa.jws.ReadAllTouchpointsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint> readAllTouchpoints();
}
