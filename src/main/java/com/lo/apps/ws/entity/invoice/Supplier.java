//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.09 at 03:12:03 PM CET 
//


package com.lo.apps.ws.entity.invoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Supplier properties.
 * 
 * <p>Java class for Supplier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Supplier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="supplierName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="255"/>
 *               &lt;pattern value="^[a-zA-Z ]{0,255}$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="supplierAddress">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="255"/>
 *               &lt;pattern value="^[a-zA-Z ]{0,255}$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="supplierPIB">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;length value="1"/>
 *               &lt;pattern value="^[1-9][0-9]{10}$"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Supplier", propOrder = {
    "supplierName",
    "supplierAddress",
    "supplierPIB"
})
public class Supplier {

    @XmlElement(required = true)
    protected String supplierName;
    @XmlElement(required = true)
    protected String supplierAddress;
    @XmlElement(required = true)
    protected String supplierPIB;

    /**
     * Gets the value of the supplierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * Sets the value of the supplierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierName(String value) {
        this.supplierName = value;
    }

    /**
     * Gets the value of the supplierAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }

    /**
     * Sets the value of the supplierAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierAddress(String value) {
        this.supplierAddress = value;
    }

    /**
     * Gets the value of the supplierPIB property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierPIB() {
        return supplierPIB;
    }

    /**
     * Sets the value of the supplierPIB property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierPIB(String value) {
        this.supplierPIB = value;
    }

}
