
package org.dieschnittstelle.jee.esa.jws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.entities.crm.ws.AbstractTouchpoint;


/**
 * <p>Java-Klasse für mobileTouchpoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="mobileTouchpoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dieschnittstelle.org/jee/esa/entities/crm/ws}abstractTouchpoint"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mobilePhoneIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mobileTouchpoint", propOrder = {
    "mobilePhoneIds"
})
public class MobileTouchpoint
    extends AbstractTouchpoint
{

    @XmlElement(nillable = true)
    protected List<String> mobilePhoneIds;

    /**
     * Gets the value of the mobilePhoneIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mobilePhoneIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMobilePhoneIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMobilePhoneIds() {
        if (mobilePhoneIds == null) {
            mobilePhoneIds = new ArrayList<String>();
        }
        return this.mobilePhoneIds;
    }

}
