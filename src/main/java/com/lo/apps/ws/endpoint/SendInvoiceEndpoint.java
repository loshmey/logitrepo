package com.lo.apps.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lo.apps.exception.InvoiceException;
import com.lo.apps.ws.entity.invoice.SendInvoiceRequest;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;
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
	public SendInvoiceResponse sendInvoice(@RequestPayload SendInvoiceRequest invoiceRequest) throws InvoiceException {
		return invoiceService.sendInvoice(invoiceRequest.getInvoice());
	}

}
