package com.lo.apps.ws.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lo.apps.exception.InvoiceException;
import com.lo.apps.ws.entity.invoice.Invoice;
import com.lo.apps.ws.entity.invoice.ObjectFactory;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.entity.invoice.Status;
import com.lo.apps.ws.service.InvoiceRequestService;
import com.lo.apps.ws.service.XMLUtilService;

/**
 * Implementation of InvoiceRequestService, handles crud operations.
 * 
 * @author milos.poljak
 *
 */
@Service
public class InvoiceRequestServiceImpl implements InvoiceRequestService {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceRequestServiceImpl.class);

	@Autowired
	private XMLUtilService xmlUtilService;

	@Override
	public SendInvoiceResponse sendInvoice(Invoice invoice) throws InvoiceException {
		// TODO Snimiti invoice u XML bazu

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		SendInvoiceResponse response = new ObjectFactory().createSendInvoiceResponse();
		response.setDescription("Uspesno poslata faktura!");
		response.setStatus(Status.OK);
		response.setTimestamp(sdf.format(new Date()));

		logger.debug("Slanje response-a: {}", response);

		return response;
	}

	@Override
	public Element sendInvoice(Element request) throws ParserConfigurationException, IOException {
		String[] documents = null;
		try {
			documents = xmlUtilService.fetchAllXMLDocuments();

			if (documents.length > 0) {
				for (String doc : documents) {
					System.out.println(doc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Element root = new Element("SendInvoiceResponse", request.getNamespace());
		Element invoiceResponse = new Element("SendInvoiceResponse", request.getNamespace());
		root.addContent(invoiceResponse);
		Element message = new Element("Message", request.getNamespace());
		invoiceResponse.addContent(message);
		message.setText("SVE OK!!!");
		Document doc = new Document(root);

		return doc.getRootElement();
	}

}
