
package com.lo.apps.ws.entity.invoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invoiceHeaderData" type="{http://localhost:8080/invoice/schema}InvoiceHeader"/>
 *         &lt;element name="invoiceRecordData" type="{http://localhost:8080/invoice/schema}InvoiceRecord" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestDateTime",
    "invoiceHeaderData",
    "invoiceRecordData"
})
@XmlRootElement(name = "Invoice", namespace = "http://localhost:8080/invoice/schema")
public class Invoice {

    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String requestDateTime;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected InvoiceHeader invoiceHeaderData;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected List<InvoiceRecord> invoiceRecordData;

    /**
     * Gets the value of the requestDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestDateTime() {
        return requestDateTime;
    }

    /**
     * Sets the value of the requestDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDateTime(String value) {
        this.requestDateTime = value;
    }

    /**
     * Gets the value of the invoiceHeaderData property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceHeader }
     *     
     */
    public InvoiceHeader getInvoiceHeaderData() {
        return invoiceHeaderData;
    }

    /**
     * Sets the value of the invoiceHeaderData property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceHeader }
     *     
     */
    public void setInvoiceHeaderData(InvoiceHeader value) {
        this.invoiceHeaderData = value;
    }

    /**
     * Gets the value of the invoiceRecordData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceRecordData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceRecordData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceRecord }
     * 
     * 
     */
    public List<InvoiceRecord> getInvoiceRecordData() {
        if (invoiceRecordData == null) {
            invoiceRecordData = new ArrayList<InvoiceRecord>();
        }
        return this.invoiceRecordData;
    }

}
