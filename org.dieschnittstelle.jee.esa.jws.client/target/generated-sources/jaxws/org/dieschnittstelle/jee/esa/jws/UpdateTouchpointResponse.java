
package org.dieschnittstelle.jee.esa.jws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint;


/**
 * <p>Java-Klasse für updateTouchpointResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="updateTouchpointResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://dieschnittstelle.org/jee/esa/entities/crm/ws}abstractTouchpoint" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTouchpointResponse", propOrder = {
    "_return"
})
public class UpdateTouchpointResponse {

    @XmlElement(name = "return")
    protected AbstractTouchpoint _return;

    /**
     * Ruft den Wert der return-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public AbstractTouchpoint getReturn() {
        return _return;
    }

    /**
     * Legt den Wert der return-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public void setReturn(AbstractTouchpoint value) {
        this._return = value;
    }

}
