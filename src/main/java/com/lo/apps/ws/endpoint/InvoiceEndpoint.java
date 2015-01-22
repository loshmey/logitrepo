package com.lo.apps.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Endpoint for invoice web service.
 * 
 * @author milos.poljak
 *
 */
@Endpoint
public class InvoiceEndpoint {

	// private static final String NAMESPACE_URI =
	// "http://localhost:8080/xwsServer/";
	//
	// @Autowired
	// private InvoiceRequestService invoiceService;
	//
	// @Autowired
	// private InvoiceRepo repo;
	//
	// @Autowired
	// public InvoiceEndpoint(InvoiceRequestService invoiceService) throws
	// JDOMException {
	// this.invoiceService = invoiceService;
	// }
	//
	// /**
	// * Handles invoice request and sends response back.
	// *
	// * @param invoiceRequestElement
	// * Element from schema.
	// * @return Invoice response: <code>OK</code>, <code>PENDING</code> or
	// * <code>ERROR</code>.
	// * @throws Exception
	// */
	// // @PayloadRoot(namespace = NAMESPACE_URI, localPart = "InvoiceRequest")
	// @SoapAction(value = NAMESPACE_URI + "InvoiceRequest")
	// @ResponsePayload
	// public JAXBElement<InvoiceResponse> handleInvoiceRequest(@RequestPayload
	// JAXBElement<InvoiceRequest> invoiceRequestElement, SoapHeader soapHeader)
	// throws Exception {
	// // TODO zameniti sa pravim posle testa
	// System.out.println(invoiceRequestElement);
	// InvoiceResponse invRes = new ObjectFactory().createInvoiceResponse();
	// invRes.setDescription(repo.getInvoice().toString());
	// invRes.setStatus(Status.OK);
	//
	// JAXBElement<InvoiceResponse> invResJaxb = new
	// JAXBElement<InvoiceResponse>(new
	// QName(InvoiceResponse.class.getSimpleName()), InvoiceResponse.class,
	// null, invRes);
	//
	// return invResJaxb;
	// }
}
