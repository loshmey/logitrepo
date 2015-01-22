package com.lo.apps.client.invoice;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * Invoice client.
 *
 * @author milos.poljak
 */
public class InvoiceClient extends WebServiceGatewaySupport {

	// public InvoiceResponse sendInvoice(InvoiceRequest invoice) {
	// Assert.notNull(invoice);
	//
	// System.out.println("Sending invoice: " + invoice.toString());
	// String soapCallback =
	// "http://localhost:8080/xwsServer/ws/InvoiceRequest";
	// InvoiceResponse response = (InvoiceResponse)
	// getWebServiceTemplate().marshalSendAndReceive(invoice, new
	// SoapActionCallback(soapCallback));
	//
	// System.out.println("Received response: " + response.toString());
	//
	// return response;
	// }
	//
	// public void printResponse(InvoiceResponse response) {
	//
	// }

}
