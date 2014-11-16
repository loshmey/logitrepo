package com.lo.apps.client.invoice;

import org.springframework.util.Assert;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.lo.apps.ws.entity.invoice.InvoiceRequest;
import com.lo.apps.ws.entity.invoice.InvoiceResponse;

/**
 * Invoice client.
 *
 * @author milos.poljak
 */
public class InvoiceClient extends WebServiceGatewaySupport {

	public InvoiceResponse sendInvoice(InvoiceRequest invoice) {
		Assert.notNull(invoice);

		System.out.println("Sending invoice: " + invoice.toString());
		String soapCallback = "http://localhost:8080/xwsServer/ws/InvoiceRequest";
		InvoiceResponse response = (InvoiceResponse) getWebServiceTemplate().marshalSendAndReceive(invoice, new SoapActionCallback(soapCallback));

		System.out.println("Received response: " + response.toString());

		return response;
	}

	public void printResponse(InvoiceResponse response) {

	}

}
