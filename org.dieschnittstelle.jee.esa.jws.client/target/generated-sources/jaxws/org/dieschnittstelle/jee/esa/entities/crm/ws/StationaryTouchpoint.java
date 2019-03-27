
package org.dieschnittstelle.jee.esa.entities.crm.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.jws.Address;


/**
 * <p>Java-Klasse für stationaryTouchpoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="stationaryTouchpoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dieschnittstelle.org/jee/esa/entities/crm/ws}abstractTouchpoint"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address" type="{http://dieschnittstelle.org/jee/esa/jws}address" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stationaryTouchpoint", propOrder = {
    "address"
})
public class StationaryTouchpoint
    extends AbstractTouchpoint
{

    protected Address address;

    /**
     * Ruft den Wert der address-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Legt den Wert der address-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

}
