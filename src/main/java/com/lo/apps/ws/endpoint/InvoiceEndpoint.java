package com.lo.apps.ws.endpoint;

import org.jdom2.Element;
import org.jdom2.xpath.XPathExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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

	private static final String NAMESPACE_URI = "http://localhost:8080/holidayService/ws/";

	// private XPathExpression<Element> invoiceRequest;
	// private XPathExpression<Element> invoiceResponse;

	@Autowired
	private InvoiceRequestService invoiceService;

	@Autowired
	private InvoiceRepo repo;

	// @Autowired
	// public InvoiceEndpoint(InvoiceRequestService invoiceService) throws
	// JDOMException {
	// this.invoiceService = invoiceService;
	//
	// Namespace namespace = Namespace.getNamespace("ih", NAMESPACE_URI);
	// XPathFactory factory = XPathFactory.instance();
	//
	// invoiceRequest = factory.compile("//ih:InvoiceRequest",
	// Filters.element(), null, namespace);
	// invoiceResponse = factory.compile("//ih:InvoiceResponse",
	// Filters.element(), null, namespace);
	// }

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
	public InvoiceResponse handleInvoiceRequest(@RequestPayload InvoiceRequest invoiceRequestElement) throws Exception {
		// InvoiceRequest invReq = parseRequestElement(invoiceRequest,
		// invoiceRequestElement);
		//
		// InvoiceResponse invRes = parseResponseElement(invoiceResponse,
		// invoiceRequestElement);

		// TODO zameniti sa pravim posle testa
		System.out.println(invoiceRequestElement);
		InvoiceResponse invRes = new ObjectFactory().createInvoiceResponse();
		// JAXBElement<InvoiceResponse> responseElement = new
		// JAXBElement<InvoiceResponse>(new
		// QName(InvoiceResponse.class.getSimpleName()), InvoiceResponse.class,
		// invRes);
		invRes.setDescription(repo.getInvoice().toString());
		invRes.setStatus(Status.OK);

		// responseElement.setValue(invRes);

		return invRes;
	}

	/**
	 * Parse request element from schema.
	 * 
	 * @param expression
	 * @param element
	 * @return
	 * @throws ParseException
	 */
	private InvoiceRequest parseRequestElement(XPathExpression<Element> expression, Element element) throws ParseException {
		Element result = expression.evaluateFirst(element);
		if (result != null) {
			InvoiceRequest invReq = new InvoiceRequest();
			result.getAttributes();
			result.getContent();
			return invReq;
		} else {
			throw new IllegalArgumentException("Could not evaluate [" + expression + "] on [" + element + "]");
		}
	}

	/**
	 * Parse response element from schema.
	 * 
	 * @param expression
	 * @param element
	 * @return
	 * @throws ParseException
	 */
	private InvoiceResponse parseResponseElement(XPathExpression<Element> expression, Element element) throws ParseException {
		Element result = expression.evaluateFirst(element);
		if (result != null) {
			InvoiceResponse invRes = new InvoiceResponse();
			result.getAttributes();
			result.getContent();
			return invRes;
		} else {
			throw new IllegalArgumentException("Could not evaluate [" + expression + "] on [" + element + "]");
		}
	}

}
