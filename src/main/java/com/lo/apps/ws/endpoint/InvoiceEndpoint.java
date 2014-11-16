package com.lo.apps.ws.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeader;

import com.lo.apps.ws.entity.invoice.InvoiceRequest;
import com.lo.apps.ws.entity.invoice.InvoiceResponse;
import com.lo.apps.ws.entity.invoice.ObjectFactory;
import com.lo.apps.ws.entity.invoice.Status;
import com.lo.apps.ws.service.InvoiceRequestService;
import com.lo.apps.ws.testrepo.InvoiceRepo;

/**
 * Endpoint for invoice web service.
 * 
 * @author milos.poljak
 *
 */
@Endpoint
public class InvoiceEndpoint {

	private static final String NAMESPACE_URI = "http://localhost:8080/xwsServer/";

	@Autowired
	private InvoiceRequestService invoiceService;

	@Autowired
	private InvoiceRepo repo;

	@Autowired
	public InvoiceEndpoint(InvoiceRequestService invoiceService) throws JDOMException {
		this.invoiceService = invoiceService;
	}

	/**
	 * Handles invoice request and sends response back.
	 * 
	 * @param invoiceRequestElement
	 *            Element from schema.
	 * @return Invoice response: <code>OK</code>, <code>PENDING</code> or
	 *         <code>ERROR</code>.
	 * @throws Exception
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InvoiceRequest")
	@ResponsePayload
	public JAXBElement<InvoiceResponse> handleInvoiceRequest(@RequestPayload JAXBElement<InvoiceRequest> invoiceRequestElement, SoapHeader soapHeader) throws Exception {
		// TODO zameniti sa pravim posle testa
		System.out.println(invoiceRequestElement);
		InvoiceResponse invRes = new ObjectFactory().createInvoiceResponse();
		invRes.setDescription(repo.getInvoice().toString());
		invRes.setStatus(Status.OK);

		JAXBElement<InvoiceResponse> invResJaxb = new JAXBElement<InvoiceResponse>(new QName(InvoiceResponse.class.getSimpleName()), InvoiceResponse.class, null, invRes);

		return invResJaxb;
	}
}
