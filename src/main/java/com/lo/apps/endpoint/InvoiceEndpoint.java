package com.lo.apps.endpoint;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lo.apps.entity.invoice.InvoiceRequest;
import com.lo.apps.entity.invoice.InvoiceResponse;
import com.lo.apps.service.InvoiceService;
import com.lo.apps.testrepo.InvoiceRepo;

@Endpoint
public class InvoiceEndpoint {

	private static final String NAMESPACE_URI = "http://localhost:8080/invoiceService/";

	private XPathExpression<Element> invoiceRequest;
	private XPathExpression<Element> invoiceResponse;
	private InvoiceService invoiceService;
	private InvoiceRepo repo;

	@Autowired
	public InvoiceEndpoint(InvoiceService invoiceService) throws JDOMException {
		this.invoiceService = invoiceService;

		Namespace namespace = Namespace.getNamespace("ih", NAMESPACE_URI);
		XPathFactory factory = XPathFactory.instance();

		invoiceRequest = factory.compile("//ih:invoiceRequest", Filters.element(), null, namespace);
		invoiceResponse = factory.compile("//ih:invoiceResponse", Filters.element(), null, namespace);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InvoiceRequest")
	@ResponsePayload
	public InvoiceResponse handleInvoiceRequest(@RequestPayload InvoiceRequest invoiceRequestElement) throws Exception {
		InvoiceResponse response = new InvoiceResponse();
		response.setDescription(repo.getInvoice().toString());

		System.out.println("======invoiceRequestElement");
		System.out.println(invoiceRequestElement.toString());
		System.out.println("======response");
		System.out.println(response);

		return response;
	}

}
