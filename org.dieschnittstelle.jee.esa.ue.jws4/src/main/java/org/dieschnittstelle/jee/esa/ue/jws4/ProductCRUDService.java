package org.dieschnittstelle.jee.esa.ue.jws4;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.logging.log4j.Logger;
import org.dieschnittstelle.jee.esa.entities.GenericCRUDExecutor;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;

/*
 * UE JWS4: machen Sie die Funktionalitaet dieser Klasse als Web Service verfuegbar und verwenden Sie fuer 
 * die Umetzung der Methoden die Instanz von GenericCRUDExecutor<AbstractProduct>,
 * die Sie aus dem ServletContext auslesen koennen
 */
@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", name = "IProductCRUDService", serviceName = "ProductCRUDWebService", portName = "ProductCRUDPort")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ProductCRUDService {

	protected static Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(ProductCRUDService.class);

	@Resource
	private WebServiceContext wscontext;

	public ProductCRUDService() {
		logger.info("<constructor>");
	}

	@PostConstruct
	@WebMethod(exclude = true)
	public void initialiseContext() {
		logger.info("@PostConstruct: the wscontext is: " + wscontext);

		// we cannot read out any context attributes (ServletContext,
		// HttpServletRequest) from the WebServiceContext as this is only
		// allowed from a thread that actually handles a particular request to a
		// service operation
		// wscontext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
	}

	@WebMethod
	public List<AbstractProduct> readAllProducts() {
		GenericCRUDExecutor<AbstractProduct> productCRUD = (GenericCRUDExecutor<AbstractProduct>) ((ServletContext) wscontext
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT))
				.getAttribute("productCRUD");
		return productCRUD.readAllObjects();
	}

	@WebMethod
	public AbstractProduct createProduct(AbstractProduct product) {
		GenericCRUDExecutor<AbstractProduct> productCRUD = (GenericCRUDExecutor<AbstractProduct>) ((ServletContext) wscontext
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT))
				.getAttribute("productCRUD");
		return productCRUD.createObject(product);
	}

	@WebMethod
	public AbstractProduct updateProduct(AbstractProduct update) {
		GenericCRUDExecutor<AbstractProduct> productCRUD = (GenericCRUDExecutor<AbstractProduct>) ((ServletContext) wscontext
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT))
				.getAttribute("productCRUD");
		return productCRUD.updateObject(update);
	}

	@WebMethod
	public boolean deleteProduct(long id) {
		GenericCRUDExecutor<AbstractProduct> productCRUD = (GenericCRUDExecutor<AbstractProduct>) ((ServletContext) wscontext
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT))
				.getAttribute("productCRUD");
		return productCRUD.deleteObject(id);
	}

	@WebMethod
	public IndividualisedProductItem readProduct(long id) {
		GenericCRUDExecutor<AbstractProduct> productCRUD = (GenericCRUDExecutor<AbstractProduct>) ((ServletContext) wscontext
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT))
				.getAttribute("productCRUD");
		return (IndividualisedProductItem) productCRUD.readObject(id);
	}

}
