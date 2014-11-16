//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.16 at 08:22:46 PM CET 
//


package com.lo.apps.ws.entity.invoice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lo.apps.ws.entity.invoice package. 
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

    private final static QName _InvoiceRequest_QNAME = new QName("http://localhost:8080/xwsServer/", "InvoiceRequest");
    private final static QName _InvoiceResponse_QNAME = new QName("http://localhost:8080/xwsServer/", "InvoiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lo.apps.ws.entity.invoice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvoiceResponse }
     * 
     */
    public InvoiceResponse createInvoiceResponse() {
        return new InvoiceResponse();
    }

    /**
     * Create an instance of {@link InvoiceRequest }
     * 
     */
    public InvoiceRequest createInvoiceRequest() {
        return new InvoiceRequest();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link Supplier }
     * 
     */
    public Supplier createSupplier() {
        return new Supplier();
    }

    /**
     * Create an instance of {@link InvoiceRecord }
     * 
     */
    public InvoiceRecord createInvoiceRecord() {
        return new InvoiceRecord();
    }

    /**
     * Create an instance of {@link Buyer }
     * 
     */
    public Buyer createBuyer() {
        return new Buyer();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link InvoiceHeader }
     * 
     */
    public InvoiceHeader createInvoiceHeader() {
        return new InvoiceHeader();
    }

    /**
     * Create an instance of {@link Sums }
     * 
     */
    public Sums createSums() {
        return new Sums();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/xwsServer/", name = "InvoiceRequest")
    public JAXBElement<InvoiceRequest> createInvoiceRequest(InvoiceRequest value) {
        return new JAXBElement<InvoiceRequest>(_InvoiceRequest_QNAME, InvoiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost:8080/xwsServer/", name = "InvoiceResponse")
    public JAXBElement<InvoiceResponse> createInvoiceResponse(InvoiceResponse value) {
        return new JAXBElement<InvoiceResponse>(_InvoiceResponse_QNAME, InvoiceResponse.class, null, value);
    }

}
