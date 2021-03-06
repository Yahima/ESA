package org.dieschnittstelle.jee.esa.jws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2018-11-26T23:05:59.380+01:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "ProductCRUDWebService", 
                  wsdlLocation = "http://localhost:8080/org.dieschnittstelle.jee.esa.ue.jws4/ProductCRUDWebService?wsdl",
                  targetNamespace = "http://dieschnittstelle.org/jee/esa/jws") 
public class ProductCRUDWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://dieschnittstelle.org/jee/esa/jws", "ProductCRUDWebService");
    public final static QName ProductCRUDPort = new QName("http://dieschnittstelle.org/jee/esa/jws", "ProductCRUDPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/org.dieschnittstelle.jee.esa.ue.jws4/ProductCRUDWebService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProductCRUDWebService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/org.dieschnittstelle.jee.esa.ue.jws4/ProductCRUDWebService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProductCRUDWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProductCRUDWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductCRUDWebService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ProductCRUDWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ProductCRUDWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ProductCRUDWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IProductCRUDService
     */
    @WebEndpoint(name = "ProductCRUDPort")
    public IProductCRUDService getProductCRUDPort() {
        return super.getPort(ProductCRUDPort, IProductCRUDService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IProductCRUDService
     */
    @WebEndpoint(name = "ProductCRUDPort")
    public IProductCRUDService getProductCRUDPort(WebServiceFeature... features) {
        return super.getPort(ProductCRUDPort, IProductCRUDService.class, features);
    }

}
