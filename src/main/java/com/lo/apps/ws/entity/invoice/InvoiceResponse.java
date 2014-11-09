//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.09 at 08:25:37 PM CET 
//

package com.lo.apps.ws.entity.invoice;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Invoice response.
 * 
 * <p>
 * Java class for InvoiceResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invoiceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="responseDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="status" type="{http://localhost:8080/holidayService/}Status"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceResponse", propOrder = { "invoiceId", "responseDateTime", "status", "description" })
public class InvoiceResponse {

	protected long invoiceId;
	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date responseDateTime;
	@XmlElement(required = true)
	protected Status status;
	@XmlElement(required = true)
	protected String description;

	/**
	 * Gets the value of the invoiceId property.
	 * 
	 */
	public long getInvoiceId() {
		return invoiceId;
	}

	/**
	 * Sets the value of the invoiceId property.
	 * 
	 */
	public void setInvoiceId(long value) {
		this.invoiceId = value;
	}

	/**
	 * Gets the value of the responseDateTime property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getResponseDateTime() {
		return responseDateTime;
	}

	/**
	 * Sets the value of the responseDateTime property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setResponseDateTime(Date value) {
		this.responseDateTime = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link Status }
	 * 
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link Status }
	 * 
	 */
	public void setStatus(Status value) {
		this.status = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

}
