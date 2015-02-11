package com.lo.apps.ws.service.impl;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

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
	public SendInvoiceResponse sendInvoice(Element request) throws ParserConfigurationException, IOException {
		logger.debug("Request: {}", request);

		// XMLOutputter out = new XMLOutputter();
		// out.output(request, System.out);

		SendInvoiceResponse response = new SendInvoiceResponse();
		response.setDescription("FAKTURA PRIMLJENA!!!");
		response.setStatus(Status.OK);
		response.setTimestamp("2015-02-11");

		try {
			xmlUtilService.saveRequestAsXML(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
