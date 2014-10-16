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

import com.lo.apps.service.InvoiceService;

@Endpoint
public class InvoiceEndpoint {

	private static final String NAMESPACE_URI = "http://localhost:8080/invoiceService/";

	private XPathExpression<Element> invoiceId;
	private XPathExpression<Element> getInvoiceRequest;
	private XPathExpression<Element> getInvoiceResponse;
	private InvoiceService invoiceService;

	@Autowired
	public InvoiceEndpoint(InvoiceService invoiceService) throws JDOMException {
		this.invoiceService = invoiceService;

		Namespace namespace = Namespace.getNamespace("ih", NAMESPACE_URI);
		XPathFactory factory = XPathFactory.instance();

		getInvoiceRequest = factory.compile("ih:invoiceRequestItems", Filters.element(), null, namespace);
		getInvoiceResponse = factory.compile("ih:invoiceResponseItems", Filters.element(), null, namespace);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "invoiceService")
	public void handleInvoiceRequest(@RequestPayload Element invoiceRequest) throws Exception {

	}

}
