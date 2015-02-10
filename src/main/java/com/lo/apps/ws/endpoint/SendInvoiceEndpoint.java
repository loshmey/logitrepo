package com.lo.apps.ws.endpoint;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeader;

import com.lo.apps.exception.InvoiceException;
import com.lo.apps.ws.service.InvoiceRequestService;

/**
 * Endpoint for invoice web service.
 * 
 * @author milos.poljak
 *
 */
@Endpoint
public class SendInvoiceEndpoint {

	private final InvoiceRequestService invoiceService;

	@Autowired
	public SendInvoiceEndpoint(InvoiceRequestService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@PayloadRoot(namespace = "http://localhost:8080/invoice/schema", localPart = "SendInvoiceRequest")
	@ResponsePayload
	public Element sendInvoice(@RequestPayload Element request, SoapHeader soapHeader) throws InvoiceException, ParserConfigurationException, IOException {
		// return invoiceService.sendInvoice(invoiceRequest.getInvoice());
		return invoiceService.sendInvoice(request);
	}

}
